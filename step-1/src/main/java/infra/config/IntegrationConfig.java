package infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:environment/application-integration.properties")
@Profile("integration")
public class IntegrationConfig implements EnvironmentConfig {

    @Override
    @Bean
    public String bootstrapMessageBean() {
        return "This is the 'Integration' environment bootstrap message bean.";
    }

}
