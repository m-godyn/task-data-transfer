package pl.milgodyn.taskdatatransfer.infrastructure.service;

import lombok.RequiredArgsConstructor;
import pl.milgodyn.taskdatatransfer.application.utils.LogExecutionTime;
import pl.milgodyn.taskdatatransfer.application.utils.LogInputAndOutput;
import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;
import pl.milgodyn.taskdatatransfer.domain.service.CoordinatesService;
import pl.milgodyn.taskdatatransfer.infrastructure.mapper.CoordinatesResponseClientMapper;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClient;
import pl.milgodyn.taskdatatransfer.infrastructure.rest.CoordinatesClientResponse;

@RequiredArgsConstructor
public class CoordinatesServiceImpl implements CoordinatesService {

    private final CoordinatesClient coordinatesClient;
    private final CoordinatesResponseClientMapper coordinatesResponseClientMapper;


    @Override
    @LogExecutionTime
    @LogInputAndOutput
    public Coordinates getCoordinatesByCapitalCity(String capitalCity) {
        CoordinatesClientResponse response = coordinatesClient.getDetailsWithCoordinates(capitalCity);
        return coordinatesResponseClientMapper.mapToDomain(response);
    }
}
