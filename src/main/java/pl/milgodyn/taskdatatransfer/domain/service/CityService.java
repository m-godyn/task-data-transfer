package pl.milgodyn.taskdatatransfer.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.milgodyn.taskdatatransfer.application.response.CoordinatesResponse;
import pl.milgodyn.taskdatatransfer.application.mapper.CoordinatesResponseMapper;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CoordinatesResponseMapper coordinatesResponseMapper;

    public CoordinatesResponse getFullInformation(String countryCode) {
        return coordinatesResponseMapper.mapToResponse(
                Coordinates.builder()
                        .capital("Warszawa")
                        .latitude(BigDecimal.valueOf(52.2319581))
                        .longitude(BigDecimal.valueOf(21.0067249))
                        .country("Polska")
                        .displayName("Warszawa, województwo mazowieckie, Polska")
                        .build());
    }
}
