package pl.lukaszmalina.mas2021.exception;

public class DateIsInPastException extends RuntimeException {

    public DateIsInPastException() {
        super("You can't add date that is in the past");
    }

}
