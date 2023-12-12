package pl.milgodyn.taskdatatransfer.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.milgodyn.taskdatatransfer.application.exception.ErrorType;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class CoordinatesControllerIT {

    private static final String COORDINATES_REQUEST_PATH = "/v1/coordinates/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn200() throws Exception {
        // given
        final var countryCode = "DE";

        // expect
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + countryCode)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(countryCode)));
    }

    @Test
    void shouldReturn400_whenInvalidCodeGiven() throws Exception {
        // given
        final var invalidCountryCode = "12";

        // expect
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + invalidCountryCode)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is(ErrorType.INVALID_COUNTRY_CODE.name())))
                .andExpect(jsonPath("$.message", is("Invalid country code: " + invalidCountryCode)));
    }
}
