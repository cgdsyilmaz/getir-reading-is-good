package com.example.getirreadingisgood.auth.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("reading.is.good.jwt")
@Getter
@Setter
public class JwtProperties {
    private String secret;
    private int expiration;
}
