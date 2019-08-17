package com.duoermei.healthdoctor.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * @Description: 添加默认创建人唯一标识
 * @Author GoldFu
 * @Date 2019/6/6
 * @Version V1.0
 **/
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            //开发者id（默认）
            return Optional.of("0");
        }
        //登录者Id
        return Optional.ofNullable(((UserDetails) authentication.getPrincipal()).getUsername());
    }
}