package pl.milgodyn.taskdatatransfer.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;

@Configuration
@RequiredArgsConstructor
public class SoapConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.milgodyn.taskdatatransfer.infrastructure.soap");
        return marshaller;
    }

    @Bean
    public CapitalCityClient capitalCityClient(Jaxb2Marshaller marshaller, Environment env) {
        CapitalCityClient client = new CapitalCityClient(env.getProperty("webservice.capital-city.url"));
        client.setDefaultUri(env.getProperty("webservice.capital-city.default-url"));
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
