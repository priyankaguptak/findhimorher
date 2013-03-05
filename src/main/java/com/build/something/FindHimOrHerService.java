package com.build.something;

import com.build.something.config.HimOrHerConfiguration;
import com.build.something.resource.FindHimOrHerResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 *
 */
public class FindHimOrHerService extends Service<HimOrHerConfiguration> {
    public static void main(String[] args) throws Exception {
        new FindHimOrHerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HimOrHerConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
        bootstrap.addBundle(new AssetsBundle());

    }

    @Override
    public void run(HimOrHerConfiguration configuration,
                    Environment environment) {

        environment.addResource(new FindHimOrHerResource());
    }

}
