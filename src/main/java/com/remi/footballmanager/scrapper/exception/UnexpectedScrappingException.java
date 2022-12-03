package com.remi.footballmanager.scrapper.exception;

public class UnexpectedScrappingException extends RuntimeException {
    public UnexpectedScrappingException(){}
    public UnexpectedScrappingException(String message) {
        super(message);
    }
}
