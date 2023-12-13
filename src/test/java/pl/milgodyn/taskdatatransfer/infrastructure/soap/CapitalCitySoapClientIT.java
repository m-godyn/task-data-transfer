package pl.milgodyn.taskdatatransfer.infrastructure.soap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;
import pl.milgodyn.taskdatatransfer.domain.model.CountryCode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CapitalCitySoapClientIT extends AbstractIntegrationTest {

    @Autowired
    private CapitalCityClient capitalCityClient;

    @ParameterizedTest
    @MethodSource("provideCountryCodesWithCapitalCities")
    void shouldReturnCapitalCity_forGivenISOCountryCode(String countryCode, String expected) {
        // when
        var actual = capitalCityClient.getCapitalCity(countryCode).getCapitalCityResult();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * This test is disabled because I used it to check if database has correct values. Although it fails because
     * country codes have not capital cities in this database, user could raise a bug because of valid country code.
     * This test is here to test from time to time if we should not handle other unexpected scenarios.
     */
    @Disabled
    @ParameterizedTest
    @EnumSource(CountryCode.class)
    void shouldReturnCapitalCity_forEveryEnumValue(CountryCode countryCode) {
        // when
        var actual = capitalCityClient.getCapitalCity(countryCode.name()).getCapitalCityResult();

        // then
        System.out.println(actual);
        assertThat(actual).isNotBlank();
        assertThat(actual).isNotEqualTo("Country not found in the database");
        assertThat(actual).isNotEqualTo("None");
        assertThat(actual).isNotEqualTo("-");
    }

    private static Stream<Arguments> provideCountryCodesWithCapitalCities() {
        return Stream.of(
                Arguments.of("PL", "Warsaw"),
                Arguments.of("DE", "Berlin"),
                Arguments.of("GB", "London"),
                Arguments.of("DK", "Copenhagen")
        );
    }
}
