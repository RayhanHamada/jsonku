package org.jsonq.core.exception;

public class KeyNotFoundException extends RuntimeException{

    private final static String MESSAGE = "Target key is not found.";

    public KeyNotFoundException()
    {
        super(MESSAGE);
    }

}
