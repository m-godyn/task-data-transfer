package pl.milgodyn.taskdatatransfer.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.milgodyn.taskdatatransfer.domain.service.CapitalCityService;
import pl.milgodyn.taskdatatransfer.domain.service.CoordinatesService;
import pl.milgodyn.taskdatatransfer.infrastructure.mapper.CoordinatesResponseClientMapper;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClient;
import pl.milgodyn.taskdatatransfer.infrastructure.service.CapitalCityServiceImpl;
import pl.milgodyn.taskdatatransfer.infrastructure.service.CoordinatesServiceImpl;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;

@Configuration
public class InfrastructureServicesConfiguration {

    @Bean
    public CapitalCityService capitalCityService(CapitalCityClient client) {
        return new CapitalCityServiceImpl(client);
    }

    @Bean
    public CoordinatesService coordinatesService(CoordinatesClient client, CoordinatesResponseClientMapper mapper) {
        return new CoordinatesServiceImpl(client, mapper);
    }
}
