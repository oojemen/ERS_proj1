package com.revature.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {



    private String secret;
    private String header;
    private String prefix;
    private int expiration; // Token expiration in seconds



    // Getters and setters for the configuration properties



    public String getSecret() {
        return secret;
    }



    public void setSecret(String secret) {
        this.secret = secret;
    }



    public String getHeader() {
        return header;
    }



    public void setHeader(String header) {
        this.header = header;
    }



    public String getPrefix() {
        return prefix;
    }



    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }



    public int getExpiration() {
        return expiration;
    }



    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }
}
