package com.duoermei.healthdoctor.exception;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: token异常
 * @Author GoldFu
 * @Date 2019/7/17
 * @Version V1.0
 **/
@Slf4j
@Component("TokenException")
public class TokenException extends Throwable implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;
    private final static String UTF8 = "utf-8";
    private final static String CONTENT_TYPE = " application/json";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exceptior) throws IOException {
        response.setCharacterEncoding(UTF8);
        response.setContentType(CONTENT_TYPE);
        PrintWriter printWriter = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentPut("mgs", "token过期");
        jsonObject.fluentPut("code", "401");
        printWriter.append(objectMapper.writeValueAsString(jsonObject));
    }

}
