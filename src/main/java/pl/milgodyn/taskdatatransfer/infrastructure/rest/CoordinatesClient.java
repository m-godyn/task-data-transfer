package pl.milgodyn.taskdatatransfer.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
public class CoordinatesClient {

    private static final String API_URL = "https://nominatim.openstreetmap.org/?addressdetails=1&q={capitalCity}&format=json&limit=1";
    private final RestTemplate restTemplate;

    public CoordinatesClientResponse getDetailsWithCoordinates(String capitalCity) {
        String url = API_URL.replace("{capitalCity}", capitalCity);
        ResponseEntity<List<CoordinatesClientResponse>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );

        List<CoordinatesClientResponse> responseList = response.getBody();

        return responseList.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Capital city was not found"));
    }
}
