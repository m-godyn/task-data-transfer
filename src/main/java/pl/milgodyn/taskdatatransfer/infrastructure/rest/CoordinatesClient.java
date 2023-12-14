package pl.milgodyn.taskdatatransfer.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.milgodyn.taskdatatransfer.application.exception.CapitalCityNotFoundException;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CoordinatesClient {

    private final RestTemplate restTemplate;
    private final String url;

    public CoordinatesClientResponse getDetailsWithCoordinates(String capitalCity) {
        String urlWithParameter = url.replace("{capitalCity}", capitalCity);
        ResponseEntity<List<CoordinatesClientResponse>> response = restTemplate.exchange(
                urlWithParameter, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );

        List<CoordinatesClientResponse> responseList = response.getBody();
        responseList = Objects.requireNonNullElse(responseList, List.of());

        return responseList.stream()
                .findFirst()
                .orElseThrow(CapitalCityNotFoundException::new);
    }
}
