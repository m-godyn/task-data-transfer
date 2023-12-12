package pl.milgodyn.taskdatatransfer.application.rest;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.milgodyn.taskdatatransfer.application.validation.ValidCountryCode;

@RestController
@RequestMapping("v1/")
@NoArgsConstructor
@Validated
public class CoordinatesController {

    @GetMapping("/coordinates/{countryCode}")
    public ResponseEntity<String> getCoordinatesOfCapitalCityByCountryCode(
            @PathVariable
            @ValidCountryCode String countryCode) {
        return ResponseEntity.ok(countryCode);
    }
}
