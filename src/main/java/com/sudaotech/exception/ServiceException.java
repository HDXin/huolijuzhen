package com.sudaotech.exception;


public class ServiceException extends CommonException {

    private static final long serialVersionUID = -1457180504918107185L;

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String msg) {
        super(msg);
    }


}
