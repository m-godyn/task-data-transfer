package pl.milgodyn.taskdatatransfer.application.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CoordinatesControllerIT extends AbstractIntegrationTest {

    @Test
    void shouldReturn200() throws Exception {
        // given
        final var countryCode = "DE";

        // expect
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + countryCode)
                                .header(HttpHeaders.AUTHORIZATION, VALID_AUTHORIZATION_HEADER_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldReturn400_whenInvalidCodeGiven() throws Exception {
        // given
        final var invalidCountryCode = "12";

        // expect
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + invalidCountryCode)
                                .header(HttpHeaders.AUTHORIZATION, VALID_AUTHORIZATION_HEADER_VALUE)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Invalid or no existent country code was given")))
                .andExpect(jsonPath("$.path", is(COORDINATES_REQUEST_PATH + invalidCountryCode)));
    }
}
