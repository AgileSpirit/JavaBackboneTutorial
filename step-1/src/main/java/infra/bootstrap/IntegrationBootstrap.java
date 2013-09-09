package infra.bootstrap;

import javax.inject.Named;

import org.springframework.context.annotation.Profile;

@Named
@Profile("integration")
public class IntegrationBootstrap extends ApplicationBootstrap {

    @Override
    void bootstrap() {
        // Do nothing (for the moment)
    }

}
