package pl.lukaszmalina.mas2021.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.lukaszmalina.mas2021.exception.UserAlreadyExistsException;
import pl.lukaszmalina.mas2021.exception.UserNotPermittedException;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler (value = UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler (value = UserNotPermittedException.class)
    public ResponseEntity<Object> handleUserNotPermittedException(UserNotPermittedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
