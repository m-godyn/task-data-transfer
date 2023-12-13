package pl.milgodyn.taskdatatransfer.infrastructure.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CapitalCityClient extends WebServiceGatewaySupport {

    public CapitalCityResponse getCapitalCity(String countryCode) {
        CapitalCity request = new CapitalCity();
        request.setSCountryISOCode(countryCode);

        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?op=CapitalCity",
                        request,
                        new SoapActionCallback("Task Data Transfer - getting capital city of " + countryCode)
                );

        return response;
    }
}
