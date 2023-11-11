package com.example.testdeveloppeursstagiairespolyvalent.exception;

import lombok.Getter;

public class EntityAlreadyExistException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;

}
