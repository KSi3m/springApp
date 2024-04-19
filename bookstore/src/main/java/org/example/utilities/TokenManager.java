package org.example.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenManager {

    private PayUAuthToken payUAuthToken;
    private Instant expirationTime;

    public TokenManager() {
    }

    public void setToken(PayUAuthToken payUAuthToken) {
        this.payUAuthToken = payUAuthToken;
        this.expirationTime = Instant.now().plusSeconds(payUAuthToken.getExpiresIn());
    }

    public boolean isTokenValid() {
        return payUAuthToken != null && expirationTime.isAfter(Instant.now());
    }

    public String getAccessToken() {
        return payUAuthToken.getAccessToken();
    }

}
