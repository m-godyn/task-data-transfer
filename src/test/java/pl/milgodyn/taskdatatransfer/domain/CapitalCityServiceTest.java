package pl.milgodyn.taskdatatransfer.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.milgodyn.taskdatatransfer.domain.service.CapitalCityService;
import pl.milgodyn.taskdatatransfer.infrastructure.service.CapitalCityServiceImpl;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityClient;
import pl.milgodyn.taskdatatransfer.infrastructure.soap.CapitalCityResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapitalCityServiceTest {

    @Mock
    private CapitalCityClient capitalCityClient;
    private CapitalCityService capitalCityService;

    @BeforeEach
    void setUp() {
        capitalCityService = new CapitalCityServiceImpl(capitalCityClient);
    }

    @Test
    void shouldReturnCapitalCity_whenGivenCountryCode() {
        // given
        String givenCountryCode = "DE";
        String expected = "Berlin";
        CapitalCityResponse mockedResponse = new CapitalCityResponse();
        mockedResponse.setCapitalCityResult(expected);

        when(capitalCityClient.getCapitalCity(any())).thenReturn(mockedResponse);

        // when
        String actual = capitalCityService.getCapitalCityByCountryCode(givenCountryCode);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
