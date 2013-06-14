package com.build.something.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: ajaypromodh
 * Date: 13-03-24
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedInConfig {
    @JsonProperty
    private String apiKey;
    @JsonProperty private String secretKey;
    @JsonProperty private String oAuthUserToken;
    @JsonProperty private String oAuthUserSecret;
    @JsonProperty private String oAuthSampleAccessKey;

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getoAuthUserToken() {
        return oAuthUserToken;
    }

    public String getoAuthUserSecret() {
        return oAuthUserSecret;
    }

    public String getoAuthSampleAccessKey() {
        return oAuthSampleAccessKey;
    }
}
