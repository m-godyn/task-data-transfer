package pl.milgodyn.taskdatatransfer.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;

@Configuration
public class SoapConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.milgodyn.taskdatatransfer.infrastructure.soap");
        return marshaller;
    }

    @Bean
    public CapitalCityClient capitalCityClient(Jaxb2Marshaller marshaller) {
        CapitalCityClient client = new CapitalCityClient();
        client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
