package io.github.crisstanza;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.github.crisstanza.health.TemplateHealthCheck;
import io.github.crisstanza.resources.HelloWorldResource;

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
        // getting-started: HelloWorldApplication#run->HelloWorldResource
        HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        // getting-started: HelloWorldApplication#run->HelloWorldResource

        // getting-started: HelloWorldApplication#run->TemplateHealthCheck
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        // getting-started: HelloWorldApplication#run->TemplateHealthCheck    }
    }
}
