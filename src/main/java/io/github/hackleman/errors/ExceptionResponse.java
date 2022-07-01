package io.github.hackleman.errors;

public class ExceptionResponse
{
    private String error;

    public ExceptionResponse(String error)
    {
        super();
        this.error = error;
    }

    public String getError()
    {
        return error;
    }
}