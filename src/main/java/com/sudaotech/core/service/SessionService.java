package com.sudaotech.core.service;

import com.sudaotech.core.Session;
import com.sudaotech.core.crypt.AuthToken;

public interface SessionService extends BaseService {

    void createSession(AuthToken authToken);

    /**
     * 清除session
     */
    void deleteSession(AuthToken authToken);

    Session getSession(AuthToken authToken);
}
