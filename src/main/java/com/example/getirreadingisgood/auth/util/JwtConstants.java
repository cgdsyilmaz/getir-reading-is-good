package com.example.getirreadingisgood.auth.util;

import org.springframework.beans.factory.annotation.Value;

public class JwtConstants {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/customer/register";
}