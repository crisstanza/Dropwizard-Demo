package io.github.crisstanza;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.views.common.ViewBundle;
import io.github.crisstanza.health.TemplateHealthCheck;
import io.github.crisstanza.resources.HelloWorldResource;
import io.github.crisstanza.resources.PersonResource;

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
        bootstrap.addBundle(new ViewBundle<>());
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

        environment.jersey().register(new PersonResource());

        // getting-started: HelloWorldApplication#run->TemplateHealthCheck
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        // getting-started: HelloWorldApplication#run->TemplateHealthCheck    }
    }
}
