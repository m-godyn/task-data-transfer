package pl.milgodyn.taskdatatransfer.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;
import pl.milgodyn.taskdatatransfer.domain.service.CoordinatesService;
import pl.milgodyn.taskdatatransfer.infrastructure.mapper.CoordinatesResponseClientMapper;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClient;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClientResponse;
import pl.milgodyn.taskdatatransfer.infrastructure.service.CoordinatesServiceImpl;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoordinatesServiceTest {

    @Mock
    private CoordinatesClient coordinatesClient;
    @Mock
    private CoordinatesResponseClientMapper coordinatesResponseClientMapper;
    private CoordinatesService coordinatesService;


    @BeforeEach
    void setUp() {
        coordinatesService = new CoordinatesServiceImpl(coordinatesClient, coordinatesResponseClientMapper);
    }

    @Test
    void shouldReturnCapitalCity_whenGivenCountryCode() {
        // given
        String capitalCity = "Berlin";
        CoordinatesClientResponse mockedResponse = CoordinatesClientResponse.builder()
                .lat("52.5170365")
                .lon("13.3888599")
                .name("Berlin")
                .displayName("Berlin, Deutschland")
                .address(new CoordinatesClientResponse.Address("Deutschland"))
                .build();

        Coordinates expected = Coordinates.builder()
                .latitude(BigDecimal.valueOf(52.5170365))
                .longitude(BigDecimal.valueOf(13.3888599))
                .capital("Berlin")
                .displayName("Berlin, Deutschland")
                .country("Deutschland")
                .build();

        when(coordinatesResponseClientMapper.mapToDomain(mockedResponse)).thenReturn(expected);
        when(coordinatesClient.getDetailsWithCoordinates(capitalCity)).thenReturn(mockedResponse);

        // when
        Coordinates actual = coordinatesService.getCoordinatesByCapitalCity(capitalCity);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
