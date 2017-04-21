package com.sudaotech.exception;

public class SequenceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -6741998390556827156L;

    public SequenceException(Exception e) {
        super(e);
    }

    public SequenceException(String msg) {
        super(msg);
    }

}
