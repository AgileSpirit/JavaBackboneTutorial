package infra.bootstrap;

import infra.util.DataGenerator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Abstract class containing the Spring PostConstruct method called after the context had been initialied.
 */
public abstract class ApplicationBootstrap {

    /**
     * SLF4J / Logback logger
     */
    private static Logger logger = LoggerFactory.getLogger(ApplicationBootstrap.class);

    /**
     * System property referenced by 'environment' retrieved through the Spring PropertyPlaceholder from one of the application-*.properties
     */
    @Value("${environment}")
    private String environment;

    /**
     * The demo data generator injected to initialize the data repository in the {@link #doBootstrap()} method
     */
    @Inject
    private DataGenerator dataGenerator;

    /**
     * Method that is called after the Spring context had been initialized and its managed beans instanced ; finally the current environment
     * indication is displayed
     */
    @PostConstruct
    public void doBootstrap() {
        // Initialize the data repository
        dataGenerator.populateData();
        dataGenerator.retrieveAndDisplayAllData();

        // Execute environment-depending treatements contained in the #bootstrap() method
        bootstrap();
        
        // Application is ready 
        logger.info("Application is ready for environment '" + environment + "' !");
    }

    /**
     * Method called by the {@link ApplicationBootstrap#doBootstrap()} Spring post-construct method
     */
    abstract void bootstrap();

}
