package com.duoermei.healthmanage.config;

import com.duoermei.healthmanage.security.AuditorAwareImpl;
import com.duoermei.healthmanage.security.JwtAuthenticationEntryPoint;
import com.duoermei.healthmanage.security.JwtAuthenticationFilter;
import com.duoermei.healthmanage.security.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @Description: 权限管理
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, StringRedisTemplate stringRedisTemplate) {
        this.userDetailsService = userDetailsService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint())
                .and().cors()
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/token").permitAll()
                .antMatchers(HttpMethod.POST, "/admin/add", "/user/token", "/user/login").permitAll()
                .and()
                .addFilterBefore(new JwtLoginFilter(authenticationManager()), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(authenticationManager(), userDetailsService, stringRedisTemplate), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}