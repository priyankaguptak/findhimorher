package com.build.something.config;

import com.yammer.dropwizard.config.Configuration;

/**
 *
 */
public class HimOrHerConfiguration  extends Configuration {
    private LinkedInConfig linkedInConfig;

    public LinkedInConfig getLinkedInConfig() {
        return linkedInConfig;
    }
}
