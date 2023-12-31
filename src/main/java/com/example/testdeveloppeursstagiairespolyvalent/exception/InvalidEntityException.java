package com.example.testdeveloppeursstagiairespolyvalent.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException {
    @Getter
    private ErrorCodes errorCodes;

    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }



    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
