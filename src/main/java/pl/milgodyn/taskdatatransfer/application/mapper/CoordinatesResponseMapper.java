package pl.milgodyn.taskdatatransfer.application.mapper;

import org.mapstruct.Mapper;
import pl.milgodyn.taskdatatransfer.application.response.CoordinatesResponse;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;

@Mapper
public interface CoordinatesResponseMapper {

    CoordinatesResponse mapToResponse(Coordinates coordinates);
}
