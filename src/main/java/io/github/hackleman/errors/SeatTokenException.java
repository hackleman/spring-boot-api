package io.github.hackleman.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeatTokenException extends RuntimeException
{
    public SeatTokenException(String message)
    {
        super(message);
    }
}