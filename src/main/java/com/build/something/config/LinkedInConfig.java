package com.build.something.config;

/**
 * Created with IntelliJ IDEA.
 * User: ajaypromodh
 * Date: 13-03-24
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedInConfig {
    private final String apiKey;
    private final String secretKey;
    private final String oAuthUserToken;
    private final String oAuthUserSecret;
    private final String oAuthSampleAccessKey;

    public LinkedInConfig(String apiKey, String secretKey, String oAuthUserToken, String oAuthUserSecret, String oAuthSampleAccessKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.oAuthUserToken = oAuthUserToken;
        this.oAuthUserSecret = oAuthUserSecret;
        this.oAuthSampleAccessKey = oAuthSampleAccessKey;
    }

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
