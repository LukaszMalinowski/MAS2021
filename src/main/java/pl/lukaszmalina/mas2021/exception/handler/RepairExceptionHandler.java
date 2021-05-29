package pl.lukaszmalina.mas2021.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.lukaszmalina.mas2021.exception.RepairNotFoundException;

@ControllerAdvice
public class RepairExceptionHandler {

    @ExceptionHandler (value = RepairNotFoundException.class)
    public ResponseEntity<Object> handleRepairNotFoundException(RepairNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
