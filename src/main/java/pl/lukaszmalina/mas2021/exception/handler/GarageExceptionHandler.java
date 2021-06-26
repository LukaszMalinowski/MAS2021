package pl.lukaszmalina.mas2021.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.lukaszmalina.mas2021.exception.DateIsInPastException;
import pl.lukaszmalina.mas2021.exception.GarageDateNotAvailableException;
import pl.lukaszmalina.mas2021.exception.GarageNotFoundException;

@ControllerAdvice
public class GarageExceptionHandler {

    @ExceptionHandler (value = GarageNotFoundException.class)
    public ResponseEntity<Object> handleGarageNotFoundException(GarageNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = GarageDateNotAvailableException.class)
    public ResponseEntity<Object> handleGarageDateNotAvailableException(GarageDateNotAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = DateIsInPastException.class)
    public ResponseEntity<Object> handleDateIsInPastException(DateIsInPastException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
