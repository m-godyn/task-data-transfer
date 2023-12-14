package pl.milgodyn.taskdatatransfer.infrastructure.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClient;

@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CoordinatesClient coordinatesClient(RestTemplate restTemplate) {
        return new CoordinatesClient(restTemplate);
    }
}