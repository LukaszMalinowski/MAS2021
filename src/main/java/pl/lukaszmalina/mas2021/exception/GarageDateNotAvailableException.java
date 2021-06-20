package pl.lukaszmalina.mas2021.exception;

import java.time.LocalDateTime;

public class GarageDateNotAvailableException extends RuntimeException {

    public GarageDateNotAvailableException(LocalDateTime localDateTime) {
        super(localDateTime + " is not available");
    }

}
