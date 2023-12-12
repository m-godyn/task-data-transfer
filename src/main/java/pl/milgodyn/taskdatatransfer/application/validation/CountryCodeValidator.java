package pl.milgodyn.taskdatatransfer.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.milgodyn.taskdatatransfer.domain.CountryCode;

import java.util.Arrays;

public class CountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    private static final String ERROR_MESSAGE = "Invalid country code: ";

    @Override
    public void initialize(ValidCountryCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (!isCountryCodeValid(value)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(ERROR_MESSAGE + value)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean isCountryCodeValid(String value) {
        return value != null && value.length() == 2 && Arrays.stream(CountryCode.values())
                .anyMatch(code -> code.name().equals(value));
    }
}
