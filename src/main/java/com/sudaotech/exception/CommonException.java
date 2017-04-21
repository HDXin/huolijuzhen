package com.sudaotech.exception;


public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 3500614839325781150L;

    public CommonException() {
    }

    public CommonException(Exception e) {
        super(e);
    }

    public CommonException(String msg) {
        super(msg);
    }

}
