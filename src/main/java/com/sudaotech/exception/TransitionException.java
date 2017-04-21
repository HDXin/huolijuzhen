package com.sudaotech.exception;

public class TransitionException extends RuntimeException {

    private static final long serialVersionUID = 3409657248441731329L;

    public TransitionException(String msg) {
        super(msg);
    }

    public TransitionException() {
        super();
    }

}
