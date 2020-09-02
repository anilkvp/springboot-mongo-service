package org.example.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){
        ErrorEntity errorEntity = new ErrorEntity(notFoundException.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Object> handleDuplicateException(DuplicateException duplicateException){
        ErrorEntity errorEntity = new ErrorEntity(duplicateException.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleDuplicateException(Exception exception){
        ErrorEntity errorEntity = new ErrorEntity(exception.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
