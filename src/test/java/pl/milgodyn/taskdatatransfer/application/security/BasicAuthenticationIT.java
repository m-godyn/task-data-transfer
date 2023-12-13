package pl.milgodyn.taskdatatransfer.application.security;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BasicAuthenticationIT extends AbstractIntegrationTest {

    private static final String INVALID_AUTHORIZATION_HEADER_VALUE = "Basic dXNlcjp3cm9uZ3Bhc3N3b3Jk";
    private static final String VALID_COUNTRY_CODE = "PL";

    @Test
    void shouldReturn200_whenValidAuthorization() throws Exception {
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + VALID_COUNTRY_CODE)
                                .header(HttpHeaders.AUTHORIZATION, VALID_AUTHORIZATION_HEADER_VALUE)
                )
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn401_whenInvalidAuthorization() throws Exception {
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + VALID_COUNTRY_CODE)
                                .header(HttpHeaders.AUTHORIZATION, INVALID_AUTHORIZATION_HEADER_VALUE)
                )
                .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturn401_whenNoAuthorization() throws Exception {
        mockMvc.perform(
                        get(COORDINATES_REQUEST_PATH + VALID_COUNTRY_CODE)
                )
                .andExpect(status().isUnauthorized());
    }
}
