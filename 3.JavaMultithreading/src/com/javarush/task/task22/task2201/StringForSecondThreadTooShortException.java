package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(StringIndexOutOfBoundsException e) {
        initCause(e);
    }

    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
