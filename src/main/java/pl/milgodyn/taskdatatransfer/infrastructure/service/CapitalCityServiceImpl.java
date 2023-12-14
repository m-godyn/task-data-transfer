package pl.milgodyn.taskdatatransfer.infrastructure.service;

import lombok.RequiredArgsConstructor;
import pl.milgodyn.taskdatatransfer.application.exception.CapitalCityNotFoundException;
import pl.milgodyn.taskdatatransfer.application.utils.LogExecutionTime;
import pl.milgodyn.taskdatatransfer.application.utils.LogInputAndOutput;
import pl.milgodyn.taskdatatransfer.domain.service.CapitalCityService;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;

import java.util.List;

@RequiredArgsConstructor
public class CapitalCityServiceImpl implements CapitalCityService {

    private static final List<String> INVALID_VALUES = List.of("Country not found in the database", "None", "-");
    private final CapitalCityClient capitalCityClient;

    @Override
    @LogExecutionTime
    @LogInputAndOutput
    public String getCapitalCityByCountryCode(String countryCode) {
        String capitalCity = capitalCityClient.getCapitalCity(countryCode).getCapitalCityResult();
        if (INVALID_VALUES.contains(capitalCity)) {
            throw new CapitalCityNotFoundException();
        }
        return capitalCity;
    }
}
