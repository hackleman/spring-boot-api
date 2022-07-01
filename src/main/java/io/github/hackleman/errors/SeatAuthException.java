package io.github.hackleman.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SeatAuthException extends RuntimeException
{
    public SeatAuthException(String message)
    {
        super(message);
    }
}