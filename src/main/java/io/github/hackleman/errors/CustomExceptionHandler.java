package io.github.hackleman.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler(SeatUnavailableException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(SeatUnavailableException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeatBoundsException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(SeatBoundsException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeatTokenException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(SeatTokenException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeatAuthException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(SeatAuthException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

}