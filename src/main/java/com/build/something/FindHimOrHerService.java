package com.build.something;

import com.build.something.config.HimOrHerConfiguration;
import com.build.something.dao.LinkedInDao;
import com.build.something.facade.PeopleRanker;
import com.build.something.resource.FindHimOrHerResource;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
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
        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(configuration.getLinkedInConfig().getApiKey(), configuration.getLinkedInConfig().getSecretKey());
        final LinkedInApiClient client = factory.createLinkedInApiClient(configuration.getLinkedInConfig().getoAuthUserToken(), configuration.getLinkedInConfig().getoAuthUserSecret());
        LinkedInDao dao = new LinkedInDao(factory, client);
        environment.addResource(new FindHimOrHerResource(new PeopleRanker(dao)));
    }

}
