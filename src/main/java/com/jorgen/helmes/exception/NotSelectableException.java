package com.jorgen.helmes.exception;

public class NotSelectableException extends RuntimeException {
    public NotSelectableException(String classification) {
        super("Classification: " + classification + " is not selectable.");
    }
}
