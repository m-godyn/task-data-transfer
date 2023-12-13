package pl.milgodyn.taskdatatransfer.application.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;
import pl.milgodyn.taskdatatransfer.application.exception.ApiErrors;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(status().isOk());
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
                .andExpect(jsonPath("$.error", is(ApiErrors.INVALID_COUNTRY_CODE.getMessage())))
                .andExpect(jsonPath("$.path", is(COORDINATES_REQUEST_PATH + invalidCountryCode)));
    }
}
