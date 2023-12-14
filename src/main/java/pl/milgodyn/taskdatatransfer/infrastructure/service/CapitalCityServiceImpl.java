package pl.milgodyn.taskdatatransfer.infrastructure.service;

import lombok.RequiredArgsConstructor;
import pl.milgodyn.taskdatatransfer.domain.service.CapitalCityService;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;

@RequiredArgsConstructor
public class CapitalCityServiceImpl implements CapitalCityService {

    private final CapitalCityClient capitalCityClient;

    @Override
    public String getCapitalCityByCountryCode(String countryCode) {
        return capitalCityClient.getCapitalCity(countryCode).getCapitalCityResult();
    }
}
