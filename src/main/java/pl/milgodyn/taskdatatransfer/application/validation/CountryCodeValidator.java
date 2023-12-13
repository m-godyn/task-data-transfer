package pl.milgodyn.taskdatatransfer.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.milgodyn.taskdatatransfer.domain.model.CountryCode;

import java.util.Arrays;

public class CountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    @Override
    public void initialize(ValidCountryCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.length() == 2 && Arrays.stream(CountryCode.values())
                .anyMatch(code -> code.name().equals(value));
    }
}
