package pl.lukaszmalina.mas2021.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.lukaszmalina.mas2021.exception.CompanyNotFoundException;
import pl.lukaszmalina.mas2021.exception.MechanicAlreadyExistsException;

@ControllerAdvice
public class CompanyExceptionHandler {

    @ExceptionHandler (value = CompanyNotFoundException.class)
    public ResponseEntity<Object> handleCompanyNotFoundException(CompanyNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = MechanicAlreadyExistsException.class)
    public ResponseEntity<Object> handleMechanicAlreadyExistsException(MechanicAlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
