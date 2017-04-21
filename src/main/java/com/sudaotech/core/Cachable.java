package com.sudaotech.core;

public interface Cachable<T> {
    public Object getKey();

    public T getValue();
}
