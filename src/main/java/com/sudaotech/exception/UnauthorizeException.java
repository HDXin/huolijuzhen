package com.sudaotech.exception;

public class UnauthorizeException extends RuntimeException {
    private static final long serialVersionUID = -5625379607787487107L;

    public UnauthorizeException(Exception e) {
        super(e);
    }

    public UnauthorizeException(String msg) {
        super(msg);
    }

}