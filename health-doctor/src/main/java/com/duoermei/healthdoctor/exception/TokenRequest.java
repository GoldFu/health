package com.duoermei.healthdoctor.exception;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/8/2
 * @Version V1.0
 **/
public class TokenRequest {
    @Autowired
    private static ObjectMapper objectMapper;
    public static void onAuthenticationFailure( HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentPut("mgs", "token过期");
        jsonObject.fluentPut("code", "401");
        printWriter.append(objectMapper.writeValueAsString(jsonObject));
    }
}
