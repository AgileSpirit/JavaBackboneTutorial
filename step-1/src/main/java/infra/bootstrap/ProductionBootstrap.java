package infra.bootstrap;

import javax.inject.Named;

import org.springframework.context.annotation.Profile;

@Named
@Profile("production")
public class ProductionBootstrap extends ApplicationBootstrap {

    @Override
    void bootstrap() {
        // Yay !
    }
}
