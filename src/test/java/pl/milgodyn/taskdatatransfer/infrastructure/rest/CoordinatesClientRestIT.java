package pl.milgodyn.taskdatatransfer.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import pl.milgodyn.taskdatatransfer.AbstractIntegrationTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CoordinatesClientRestIT extends AbstractIntegrationTest {

    @Autowired
    private CoordinatesClient coordinatesClient;

    @ParameterizedTest
    @MethodSource("provideCapitalCitiesWithCoordinateResponses")
    void shouldReturnCoordinateResponse_whenGivenCapitalCity(String givenCapitalCity, CoordinatesClientResponse expected) {
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
                        "Warsaw", CoordinatesClientResponse.builder()
                                .lat("52.2319581")
                                .lon("21.0067249")
                                .name("Warszawa")
                                .displayName("Warszawa, województwo mazowieckie, Polska")
                                .address(new CoordinatesClientResponse.Address("Polska"))
                                .build()
                ),
                Arguments.of(
                        "Berlin", CoordinatesClientResponse.builder()
                                .lat("52.5170365")
                                .lon("13.3888599")
                                .name("Berlin")
                                .displayName("Berlin, Deutschland")
                                .address(new CoordinatesClientResponse.Address("Deutschland"))
                                .build()
                ),
                Arguments.of(
                        "London", CoordinatesClientResponse.builder()
                                .lat("51.5074456")
                                .lon("-0.1277653")
                                .name("London")
                                .displayName("London, Greater London, England, United Kingdom")
                                .address(new CoordinatesClientResponse.Address("United Kingdom"))
                                .build()
                ),
                Arguments.of(
                        "Copenhagen", CoordinatesClientResponse.builder()
                                .lat("55.6867243")
                                .lon("12.5700724")
                                .name("København")
                                .displayName("København, Københavns Kommune, Region Hovedstaden, 1357, Danmark")
                                .address(new CoordinatesClientResponse.Address("Danmark"))
                                .build()
                )
        );
    }
}
