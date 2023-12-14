package pl.milgodyn.taskdatatransfer.domain.service;

import lombok.RequiredArgsConstructor;
import pl.milgodyn.taskdatatransfer.application.mapper.CoordinatesResponseMapper;
import pl.milgodyn.taskdatatransfer.application.response.CoordinatesResponse;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;

@RequiredArgsConstructor
public class CityService {

    private final CoordinatesResponseMapper coordinatesResponseMapper;
    private final CapitalCityService capitalCityService;
    private final CoordinatesService coordinatesService;

    public CoordinatesResponse getFullInformation(String countryCode) {
        String capitalCity = capitalCityService.getCapitalCityByCountryCode(countryCode);
        Coordinates coordinatesByCapitalCity = coordinatesService.getCoordinatesByCapitalCity(capitalCity);
        return coordinatesResponseMapper.mapToResponse(coordinatesByCapitalCity);
    }
}
