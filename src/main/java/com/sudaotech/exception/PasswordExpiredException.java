package com.sudaotech.exception;

public class PasswordExpiredException extends RuntimeException {

    private static final long serialVersionUID = -7896887327676105502L;

    public PasswordExpiredException(Exception e) {
        super(e);
    }

    public PasswordExpiredException(String msg) {
        super(msg);
    }

}