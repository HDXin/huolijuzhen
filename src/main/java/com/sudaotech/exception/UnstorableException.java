package com.sudaotech.exception;

public class UnstorableException extends RuntimeException {

    private static final long serialVersionUID = -7896887327676105502L;

    public UnstorableException(Exception e) {
        super(e);
    }

    public UnstorableException(String msg) {
        super(msg);
    }

}