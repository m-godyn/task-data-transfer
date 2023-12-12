package pl.milgodyn.taskdatatransfer.application.response;

import pl.milgodyn.taskdatatransfer.application.exception.ErrorType;

public record ErrorResponse(ErrorType error, String message) {
}
