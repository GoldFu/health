package com.duoermei.healthmanage.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应令牌类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private String token;
}
