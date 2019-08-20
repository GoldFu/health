package com.duoermei.healthdoctor.security;

import com.duoermei.healthcommons.model.Doctor;
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

    public static JwtUser create(Doctor doctor) {
        return new JwtUser(
                doctor.getPhone(),
                doctor.getDoctorId(),
                doctor.getPassword(),
                doctor.getAvatar(),
                doctor.getNickName(),
                mapToGrantedAuthorities(doctor.getDoctorId())
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
