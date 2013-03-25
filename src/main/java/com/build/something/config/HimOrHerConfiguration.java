package com.build.something.config;

import com.yammer.dropwizard.config.Configuration;

/**
 *
 */
public class HimOrHerConfiguration  extends Configuration {
    private final LinkedInConfig linkedInConfig;

    public HimOrHerConfiguration(LinkedInConfig linkedInConfig) {
        this.linkedInConfig = linkedInConfig;
    }

    public LinkedInConfig getLinkedInConfig() {
        return linkedInConfig;
    }
}
