package com.duoermei.healthdoctor.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 在请求中获得用户名和密码然后封装起来
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = -8445943548965154778L;
    private String username;
    private String password;
}
