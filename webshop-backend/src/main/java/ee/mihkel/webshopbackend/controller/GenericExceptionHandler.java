package ee.mihkel.webshopbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleError(ProductNotFoundException exception) {
        ProductErrorResponse error = new ProductErrorResponse();
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleError(NumberFormatException exception) {
        ProductErrorResponse error = new ProductErrorResponse();
        error.setDate(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage("Got alphabetical id instead of numerical (long)");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleError(Exception exception) {
        ProductErrorResponse error = new ProductErrorResponse();
        error.setDate(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage("Unknown error");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
