package com.sudaotech.core;

public interface SessionAware {
    Session getSession();
    void clearSession();
}
