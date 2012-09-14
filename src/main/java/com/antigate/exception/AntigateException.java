package com.antigate.exception;

/**
 * @author itsimoshka
 */
public class AntigateException extends Exception {
    private ErrorCode errorCode;

    public AntigateException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
