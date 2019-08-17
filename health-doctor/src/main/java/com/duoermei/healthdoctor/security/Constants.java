package com.duoermei.healthdoctor.security;

import java.util.concurrent.TimeUnit;

class Constants {
    static final String JWT_SECRET = "WenNingJwtSecret";
    static final long JWT_TOKEN_EXP_TIME = TimeUnit.DAYS.toMicros(1);
    static final String JWT_HEADER = "Authorization";
    static final String JWT_TOKEN_HEAD = "Bearer ";
    static final String ENTERPRISE_SIGNATURE="Signature";
    static final String CLIENT_SOURCE="clientSource";
    static final String TOURIST_UUID="tourist_unique_identifier";

}
