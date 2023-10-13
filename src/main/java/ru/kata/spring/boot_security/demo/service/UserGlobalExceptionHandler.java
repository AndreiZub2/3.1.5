package ru.kata.spring.boot_security.demo.service;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrect> handlerException(NoUserException exception){
        UserIncorrect userIncorrect = new UserIncorrect();
        userIncorrect.setInfo(exception.getMessage());
        return new ResponseEntity<>(userIncorrect, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrect> handlerException(Exception exception){
        UserIncorrect userIncorrect = new UserIncorrect();
        userIncorrect.setInfo(exception.getMessage());
        return new ResponseEntity<>(userIncorrect, HttpStatus.BAD_REQUEST);
    }
}
