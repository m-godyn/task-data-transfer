package pl.milgodyn.taskdatatransfer.application.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiErrors {

    INVALID_COUNTRY_CODE("Invalid or no existent country code was given");

    private final String message;
}
