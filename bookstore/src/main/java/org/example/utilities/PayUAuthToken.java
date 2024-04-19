package org.example.utilities;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PayUAuthToken {
    @JsonAlias("access_token")
    private String accessToken;
    @JsonAlias("token_type")
    private String tokenType;
    @JsonAlias("expires_in")
    private int expiresIn;
    @JsonAlias("grant_type")
    private String grantType;


    public PayUAuthToken() {
    }

    public PayUAuthToken(String accessToken, String tokenType, int expiresIn, String grantType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.grantType = grantType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return "PayUAuthToken{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", grantType='" + grantType + '\'' +
                '}';
    }
}
