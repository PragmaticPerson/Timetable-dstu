package ru.donstu.edu.exception.handler;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ru.donstu.edu.exception.CustomExceptionResponce;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String PATH = "ru.donstu.edu.models.";
    private static final String EMPTY = "";

    @ExceptionHandler({ EntityNotFoundException.class })
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        CustomExceptionResponce responce = new CustomExceptionResponce();
        responce.setMessage(ex.getMessage().replaceAll(PATH, EMPTY));
        responce.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(responce, responce.getStatus());
    }

    @ExceptionHandler({ NumberFormatException.class })
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> numberFormatExceptionHandler(NumberFormatException ex) {
        CustomExceptionResponce responce = new CustomExceptionResponce();
        responce.setMessage(ex.getMessage());
        responce.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(responce, responce.getStatus());
    }
}
