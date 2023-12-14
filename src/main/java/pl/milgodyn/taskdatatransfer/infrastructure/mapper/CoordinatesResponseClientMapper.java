package pl.milgodyn.taskdatatransfer.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClientResponse;

@Mapper
public interface CoordinatesResponseClientMapper {

    @Mapping(source = "lat", target = "latitude")
    @Mapping(source = "lon", target = "longitude")
    @Mapping(source = "name", target = "capital")
    @Mapping(source = "displayName", target = "displayName")
    @Mapping(source = "address.country", target = "country")
    Coordinates mapToDomain(CoordinatesClientResponse response);
}
