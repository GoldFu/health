package com.duoermei.healthmanage.security;

import com.duoermei.healthmanage.model.AdminInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

/**
 * 创建jwt
 */
public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(AdminInfo admin) {
        return new JwtUser(
                admin.getPhone(),
                admin.getAdminId(),
                admin.getPassword(),
                admin.getAvatar(),
                mapToGrantedAuthorities(admin.getRoleId())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String role) {
        if (role == null) {
            //返回空列表
            return Collections.emptyList();
        }
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
