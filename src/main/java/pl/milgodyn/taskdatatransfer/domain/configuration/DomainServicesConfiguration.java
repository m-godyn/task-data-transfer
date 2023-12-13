package pl.milgodyn.taskdatatransfer.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.milgodyn.taskdatatransfer.application.mapper.CoordinatesResponseMapper;
import pl.milgodyn.taskdatatransfer.domain.service.CityService;

@Configuration
public class DomainServicesConfiguration {

    @Bean
    public CityService cityService(CoordinatesResponseMapper coordinatesResponseMapper) {
        return new CityService(coordinatesResponseMapper);
    }
}
