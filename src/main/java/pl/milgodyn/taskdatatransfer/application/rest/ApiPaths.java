package pl.milgodyn.taskdatatransfer.application.rest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPaths {

    public static final String BASE_PATH = "/v1";
    public static final String COORDINATES_PATH = BASE_PATH + "/coordinates";
}
