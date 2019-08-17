package com.duoermei.healthmanage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/7/31
 * @Version V1.0
 **/
@Component
public class MobileAuthenticationFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;
    private final static String UTF8 = "utf-8";
    private final static String CONTENT_TYPE = " application/json";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exceptior) throws IOException {
        response.setCharacterEncoding(UTF8);
        response.setContentType(CONTENT_TYPE);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString("错误异常"));
    }
}