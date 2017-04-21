package com.sudaotech.exception;

/**
 * 操作非法，业务不允许
 */
public class IllegalOperationException extends RuntimeException {

    private static final long serialVersionUID = -4542115410791703393L;

    public IllegalOperationException(String msg) {
        super(msg);
    }

    public IllegalOperationException() {
        super();
    }

}
