package com.example.testdeveloppeursstagiairespolyvalent.exception;

import lombok.Getter;

public class EntityAlreadyExistException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;

    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }

    public EntityAlreadyExistException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
