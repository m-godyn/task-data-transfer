package pl.milgodyn.taskdatatransfer.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CoordinatesControllerIT {

    private static final String COORDINATES_REQUEST_PATH = "/v1/coordinates/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void dummyControllerTest() throws Exception {
        final var countryCode = "DE";

        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + countryCode)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(countryCode)));
    }
}
