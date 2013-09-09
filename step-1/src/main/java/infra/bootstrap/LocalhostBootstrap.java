package infra.bootstrap;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

/**
 * An exemple of Bootstraper implementation class for the 'Localhost' environment 
 */
@Named
@Profile("localhost")
public class LocalhostBootstrap extends ApplicationBootstrap {

    private static Logger logger = LoggerFactory.getLogger(LocalhostBootstrap.class);
    
    @Inject
    private String bootstrapMessageBean;
    
    @Override
    void bootstrap() {
        logger.info(bootstrapMessageBean);
    }

}
