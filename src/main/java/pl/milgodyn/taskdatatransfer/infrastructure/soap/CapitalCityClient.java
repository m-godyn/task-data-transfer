package pl.milgodyn.taskdatatransfer.infrastructure.soap;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@RequiredArgsConstructor
public class CapitalCityClient extends WebServiceGatewaySupport {

    private final String url;


    public CapitalCityResponse getCapitalCity(String countryCode) {
        CapitalCity request = new CapitalCity();
        request.setSCountryISOCode(countryCode);

        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        url,
                        request,
                        new SoapActionCallback("Task Data Transfer - getting capital city of " + countryCode)
                );

        return response;
    }
}
