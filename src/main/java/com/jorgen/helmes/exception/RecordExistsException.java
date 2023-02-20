package com.jorgen.helmes.exception;

public class RecordExistsException extends RuntimeException {
    public RecordExistsException(String type, String conflictReason) {
        super("Record already present: " + type + " conflictReason:" + conflictReason);
    }
}
