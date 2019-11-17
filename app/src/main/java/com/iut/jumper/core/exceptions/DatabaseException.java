package com.iut.jumper.core.exceptions;

public class DatabaseException extends Exception {

    public DatabaseException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
