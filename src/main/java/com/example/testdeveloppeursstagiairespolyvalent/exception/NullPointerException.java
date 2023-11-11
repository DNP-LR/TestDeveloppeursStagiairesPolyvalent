package com.example.testdeveloppeursstagiairespolyvalent.exception;

import lombok.Getter;

public class NullPointerException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;

    public NullPointerException(String message) {
        super(message);
    }

    public NullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPointerException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }

    public NullPointerException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
