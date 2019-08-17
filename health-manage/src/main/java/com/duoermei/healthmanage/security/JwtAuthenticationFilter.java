package com.duoermei.healthmanage.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    private final UserDetailsService userDetailsService;
    private final StringRedisTemplate stringRedisTemplate;

    public JwtAuthenticationFilter(AuthenticationManager authManager, UserDetailsService userDetailsService, StringRedisTemplate stringRedisTemplate) {
        super(authManager);
        this.userDetailsService = userDetailsService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        final String authHeader = req.getHeader(Constants.JWT_HEADER);
        final String authSignature = req.getHeader(Constants.ENTERPRISE_SIGNATURE);
        //客户端来源（app/pc）
        final String clientSource = req.getHeader(Constants.CLIENT_SOURCE);
        if (authHeader == null || !authHeader.startsWith(Constants.JWT_TOKEN_HEAD)) {
            chain.doFilter(req, res);
        } else {
            //请求过来的token
            final String authToken = authHeader.substring(Constants.JWT_TOKEN_HEAD.length());
            String username = JwtTokenHelper.getUsernameFromToken(authToken);
            log.info("token标识：" + username);
            //判断不是游客模式
            if (!Constants.TOURIST_UUID.equals(username)) {
                //redis保存原来的token
                String curryToken = stringRedisTemplate.opsForValue().get(username + ":" + clientSource);
                //判断两次token是否相同
                if (!authToken.equals(curryToken)) {
                    try {
                        throw new Exception("token已过期");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            log.debug("checking authentication " + username);
            log.info("检查身份验证" + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = null;
                try {
                    userDetails = userDetailsService.loadUserByUsername(username);
                } catch (UsernameNotFoundException e) {
                    log.warn("authenticated user " + username + " not found");
                    log.info("未找到经过身份验证的用户" + username);
                }
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    log.debug("authenticated user " + username + ", setting security context");
                    log.debug("经过身份验证的用户" + username + "，设置安全上下文");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            chain.doFilter(req, res);
        }
    }
}

