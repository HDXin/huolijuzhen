package com.sudaotech.account.service;

import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.service.BaseService;

public interface AdminAuthService extends BaseService {

    AuthToken create(Login login);
}
