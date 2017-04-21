package com.sudaotech.core;

import java.io.Serializable;

public interface Storable {
    Serializable getStorableId();

    /**
     * 超时过期时间(单位：秒)
     * @return
     */
    int getExpires();
}
