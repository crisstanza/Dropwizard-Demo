package io.github.crisstanza;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class DropwizardDemoApplication extends Application<DropwizardDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardDemo";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardDemoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardDemoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
