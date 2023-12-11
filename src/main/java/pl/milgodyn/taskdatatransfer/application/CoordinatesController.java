package pl.milgodyn.taskdatatransfer.application;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
@NoArgsConstructor
public class CoordinatesController {

    @GetMapping("/coordinates/{countryCode}")
    public ResponseEntity<String> getCoordinatesOfCapitalCityByCountryCode(@PathVariable String countryCode) {
        return ResponseEntity.ok(countryCode);
    }
}
