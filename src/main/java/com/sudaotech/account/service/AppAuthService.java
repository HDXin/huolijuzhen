package com.sudaotech.account.service;

import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.service.BaseService;

public interface AppAuthService extends BaseService {

    /**
     * 创建登陆token（验证有效性）
     * @param login
     * @return
     */
    AuthToken auth(Login login);
    /**
     * 创建登陆token（未验证有效性）
     * @param login
     * @return
     */
    AuthToken create(Login login);
    
    AuthToken createAuthToken(Long userId, Long userTypeId);
    
}
