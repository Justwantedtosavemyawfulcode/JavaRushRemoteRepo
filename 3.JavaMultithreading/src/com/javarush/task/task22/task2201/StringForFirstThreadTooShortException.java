package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public StringForFirstThreadTooShortException(StringIndexOutOfBoundsException e) {
        initCause(e);
    }
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
