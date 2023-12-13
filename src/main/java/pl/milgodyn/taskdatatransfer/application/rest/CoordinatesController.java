package pl.milgodyn.taskdatatransfer.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.milgodyn.taskdatatransfer.application.response.CoordinatesResponse;
import pl.milgodyn.taskdatatransfer.domain.service.CityService;
import pl.milgodyn.taskdatatransfer.application.validation.ValidCountryCode;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
@Validated
public class CoordinatesController {

    private final CityService cityService;

    @GetMapping("/coordinates/{countryCode}")
    public ResponseEntity<CoordinatesResponse> getCoordinatesOfCapitalCityByCountryCode(
            @PathVariable
            @ValidCountryCode String countryCode) {
        var response = cityService.getFullInformation(countryCode);
        return ResponseEntity.ok(response);
    }
}
