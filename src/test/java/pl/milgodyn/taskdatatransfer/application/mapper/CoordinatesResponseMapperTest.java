package pl.milgodyn.taskdatatransfer.application.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class CoordinatesResponseMapperTest {

    private CoordinatesResponseMapper coordinatesResponseMapper = Mappers.getMapper(CoordinatesResponseMapper.class);

    @Test
    void shouldReturnMappedResponse() {
        // given
        final var coordinates = Coordinates.builder()
                .capital("Warszawa")
                .latitude(BigDecimal.valueOf(52.2319581))
                .longitude(BigDecimal.valueOf(21.0067249))
                .country("Polska")
                .displayName("Warszawa, województwo mazowieckie, Polska")
                .build();

        // when
        var mappedResponse = coordinatesResponseMapper.mapToResponse(coordinates);

        // then
        assertThat(mappedResponse).usingRecursiveComparison().isEqualTo(coordinates);
    }
}
