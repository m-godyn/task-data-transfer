package pl.milgodyn.taskdatatransfer.infrastructure.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CoordinatesClientRestIT extends AbstractIntegrationTest {

    @Autowired
    private CoordinatesClient coordinatesClient;

    @ParameterizedTest
    @MethodSource("provideCapitalCitiesWithCoordinateResponses")
    void shouldReturnCoordinateResponse_whenGivenCapitalCity(String givenCapitalCity, CoordinatesResponse expected) {
        // when
        var actual = coordinatesClient.getDetailsWithCoordinates(givenCapitalCity);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowIllegalArgumentException_whenInvalidCapitalCityGiven() {
        // given
        String capitalCity = "-";

        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> coordinatesClient.getDetailsWithCoordinates(capitalCity)
                )
                .withMessage("Capital city was not found");
    }

    private static Stream<Arguments> provideCapitalCitiesWithCoordinateResponses() {
        return Stream.of(
                Arguments.of(
                        "Warsaw", CoordinatesResponse.builder()
                                .lat("52.2319581")
                                .lon("21.0067249")
                                .name("Warszawa")
                                .displayName("Warszawa, województwo mazowieckie, Polska")
                                .address(new CoordinatesResponse.Address("Polska"))
                                .build()
                ),
                Arguments.of(
                        "Berlin", CoordinatesResponse.builder()
                                .lat("52.5170365")
                                .lon("13.3888599")
                                .name("Berlin")
                                .displayName("Berlin, Deutschland")
                                .address(new CoordinatesResponse.Address("Deutschland"))
                                .build()
                ),
                Arguments.of(
                        "London", CoordinatesResponse.builder()
                                .lat("51.4893335")
                                .lon("-0.14405508452768728")
                                .name("London")
                                .displayName("London, Greater London, England, United Kingdom")
                                .address(new CoordinatesResponse.Address("United Kingdom"))
                                .build()
                ),
                Arguments.of(
                        "Copenhagen", CoordinatesResponse.builder()
                                .lat("55.6867243")
                                .lon("12.5700724")
                                .name("København")
                                .displayName("København, Københavns Kommune, Region Hovedstaden, 1357, Danmark")
                                .address(new CoordinatesResponse.Address("Danmark"))
                                .build()
                )
        );
    }
}
