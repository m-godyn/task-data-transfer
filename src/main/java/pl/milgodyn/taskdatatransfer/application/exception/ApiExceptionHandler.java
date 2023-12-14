package pl.milgodyn.taskdatatransfer.application.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import pl.milgodyn.taskdatatransfer.application.response.ApiErrorResponse;

import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolationException(ServletWebRequest request) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ApiErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_REQUEST.value(),
                                "Invalid or no existent country code was given",
                                request.getRequest().getRequestURI()
                        )
                );
    }

    @ExceptionHandler(CapitalCityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCapitalCityNotFoundException(CapitalCityNotFoundException e, ServletWebRequest request) {

        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(
                        new ApiErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_GATEWAY.value(),
                                e.getMessage(),
                                request.getRequest().getRequestURI()
                        )
                );
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ApiErrorResponse> handleTimeoutException(ServletWebRequest request) {

        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(
                        new ApiErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_GATEWAY.value(),
                                "External service is unavailable",
                                request.getRequest().getRequestURI()
                        )
                );
    }

}
