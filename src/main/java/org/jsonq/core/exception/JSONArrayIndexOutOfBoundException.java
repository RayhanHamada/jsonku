package org.jsonq.core.exception;

public class JSONArrayIndexOutOfBoundException extends RuntimeException {

    public JSONArrayIndexOutOfBoundException()
    {
        super("Index greater than the size of the array");
    }
}
