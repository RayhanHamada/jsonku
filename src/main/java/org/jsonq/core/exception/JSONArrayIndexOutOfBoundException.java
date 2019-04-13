package org.jsonq.core.exception;

public class JSONArrayIndexOutOfBoundException extends RuntimeException {

    public JSONArrayIndexOutOfBoundException()
    {
        super("Index greater than or equal to the size of the array");
    }
}
