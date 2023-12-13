package pl.milgodyn.taskdatatransfer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.milgodyn.taskdatatransfer.application.rest.CoordinatesController;
import pl.milgodyn.taskdatatransfer.domain.service.CityService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

    @Autowired
    private CoordinatesController coordinatesController;

    @Autowired
    private CityService cityService;

    @Test
    void contextLoads() {
        assertThat(coordinatesController).isNotNull();
        assertThat(cityService).isNotNull();
    }

}
