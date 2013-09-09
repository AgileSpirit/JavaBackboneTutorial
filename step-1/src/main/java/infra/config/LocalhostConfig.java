package infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:environment/application-localhost.properties")
@Profile("localhost")
public class LocalhostConfig implements EnvironmentConfig {

    @Override
    @Bean
    public String bootstrapMessageBean() {
        return "This is the 'Localhost' environment bootstrap message bean.";
    }

}
