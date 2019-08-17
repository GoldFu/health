package com.duoermei.healthdoctor.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 身份验证的入口
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final AuthenticationManager authenticationManager;
    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/no", "POST"));
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        JwtAuthenticationRequest user;
        try {
            user = objectMapper.readValue(req.getInputStream(), JwtAuthenticationRequest.class);
        } catch (IOException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = JwtTokenHelper.generateToken((UserDetails) auth.getPrincipal());
        res.addHeader(Constants.JWT_HEADER, Constants.JWT_TOKEN_HEAD + token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(req, res);
    }
}
