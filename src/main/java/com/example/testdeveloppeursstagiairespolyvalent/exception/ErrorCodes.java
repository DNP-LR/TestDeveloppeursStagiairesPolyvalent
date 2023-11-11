package com.example.testdeveloppeursstagiairespolyvalent.exception;

public enum ErrorCodes {


    USER_NOT_FOUND(1000),
    USER_NOT_VALID(1001),
    BOOK_NOT_VALID(1001),


    AUTHENTICATION_REQUEST_NOT_VALIDE(3000),
    AUTHENTICATION_REQUEST_NOT_MATCH(3001),
    USER_ROLE_NOT_VALIDE(4000),


    ROLE_NOT_FOUND(5000),


    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}