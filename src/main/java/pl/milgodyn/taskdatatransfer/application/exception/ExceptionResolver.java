package pl.milgodyn.taskdatatransfer.application.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.milgodyn.taskdatatransfer.application.response.ErrorResponse;

@RestControllerAdvice
@NoArgsConstructor
public final class ExceptionResolver {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity
                .badRequest()
                .body(
                        new ErrorResponse(
                                ErrorType.INVALID_COUNTRY_CODE,
                                e.getConstraintViolations().iterator().next().getMessage()
                        )
                );
    }
}
