package infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Exemple of an application configuration based on a properties file that is outside the war ; this is often the case for a Production
 * context, in companies that does not want developers interacting with the production infrastructure.
 */
@Configuration
@PropertySource("file:/tomcat/conf/application.properties")
@Profile("production")
public class ProductionConfig implements EnvironmentConfig {

    @Override
    @Bean
    public String bootstrapMessageBean() {
        return "This is the 'Production' environment bootstrap message bean.";
    }

}
