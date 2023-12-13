package pl.milgodyn.taskdatatransfer.application.response;

import java.time.LocalDateTime;

public record ApiErrorResponse(LocalDateTime timestamp, int status, String error, String path   ) {
}
