package com.duoermei.healthmanage.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 抛异常后，向客户端响应的信息类（未授权的响应信息）
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

}
