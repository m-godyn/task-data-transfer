package pl.milgodyn.taskdatatransfer.application.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.milgodyn.taskdatatransfer.application.response.ApiErrorResponse;

import static pl.milgodyn.taskdatatransfer.application.exception.ApiErrors.INVALID_COUNTRY_CODE;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ApiErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                INVALID_COUNTRY_CODE.getMessage()
                        )
                );
    }
}
