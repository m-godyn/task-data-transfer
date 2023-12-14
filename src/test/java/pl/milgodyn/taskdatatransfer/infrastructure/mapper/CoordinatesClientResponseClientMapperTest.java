package pl.milgodyn.taskdatatransfer.infrastructure.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClientResponse;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesClientResponseClientMapperTest {

    private CoordinatesResponseClientMapper mapper = Mappers.getMapper(CoordinatesResponseClientMapper.class);

    @Test
    void shouldMapResponseToDomain() {
        // given
        CoordinatesClientResponse givenResponse = CoordinatesClientResponse.builder()
                .lat("52.2319581")
                .lon("21.0067249")
                .name("Warszawa")
                .displayName("Warszawa, województwo mazowieckie, Polska")
                .address(new CoordinatesClientResponse.Address("Polska"))
                .build();

        // when
        Coordinates actual = mapper.mapToDomain(givenResponse);

        // then
        Coordinates expected = Coordinates.builder()
                .latitude(BigDecimal.valueOf(52.2319581))
                .longitude(BigDecimal.valueOf(21.0067249))
                .capital("Warszawa")
                .country("Polska")
                .displayName("Warszawa, województwo mazowieckie, Polska")
                .build();

        assertThat(actual).isEqualTo(expected);
    }
}
