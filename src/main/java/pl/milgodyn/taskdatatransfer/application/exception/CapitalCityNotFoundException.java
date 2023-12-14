package pl.milgodyn.taskdatatransfer.application.exception;

public class CapitalCityNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Capital city was not found in external database";

    public CapitalCityNotFoundException() {
        super(MESSAGE);
    }
}
