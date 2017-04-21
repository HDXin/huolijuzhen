package com.sudaotech.exception;

public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 2673451367143201768L;

    public PermissionException(String msg) {
        super(msg);
    }

    public PermissionException() {
        super();
    }

}
