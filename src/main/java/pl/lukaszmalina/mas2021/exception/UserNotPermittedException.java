package pl.lukaszmalina.mas2021.exception;

public class UserNotPermittedException extends RuntimeException {

    public UserNotPermittedException(String message) {
        super(message);
    }

}
