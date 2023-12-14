package pl.milgodyn.taskdatatransfer.domain.service;

import pl.milgodyn.taskdatatransfer.domain.model.Coordinates;

public interface CoordinatesService {

    Coordinates getCoordinatesByCapitalCity(String capitalCity);
}
