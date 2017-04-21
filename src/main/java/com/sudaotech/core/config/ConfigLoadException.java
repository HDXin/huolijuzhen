package com.sudaotech.core.config;


public class ConfigLoadException extends RuntimeException {

    private static final long serialVersionUID = 272654964421153391L;

    public ConfigLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigLoadException(String message) {
        super(message);
    }

    public ConfigLoadException(Throwable cause) {
        super(cause);
    }
    
}
