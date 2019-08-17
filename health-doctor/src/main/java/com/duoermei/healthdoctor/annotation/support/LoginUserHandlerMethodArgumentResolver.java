package com.duoermei.healthdoctor.annotation.support;


import com.duoermei.healthdoctor.annotation.LoginUser;
import com.duoermei.healthdoctor.security.JwtUser;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(String.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        JwtUser jwtUser = null;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof JwtUser) {
            jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        LoginUser loginUser = parameter.getParameterAnnotation(LoginUser.class);

        if (jwtUser == null && (loginUser != null && loginUser.required())) {
            //throw new UnauthorizedException("需要登录");
        }
        return jwtUser == null ? null : jwtUser.getUsername();
    }
}