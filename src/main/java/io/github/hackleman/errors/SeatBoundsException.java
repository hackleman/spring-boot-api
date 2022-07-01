package io.github.hackleman.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeatBoundsException extends RuntimeException
{
    public SeatBoundsException(String message)
    {
        super(message);
    }
}