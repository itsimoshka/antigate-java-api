package com.antigate.exception;

/**
 * Represent exceptions returned from Antigate.
 * Descriptions see on Antigate web site
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
