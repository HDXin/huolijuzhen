package com.sudaotech.account.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.account.dao.LoginHistoryEntity;
import com.sudaotech.account.dao.LoginHistoryEntityMapper;
import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.crypt.PasswordCrypt;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.user.enums.UserStatus;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.RandUtil;

public class AdminAuthServiceImpl extends BaseServiceImpl implements AdminAuthService {

    @Inject
    private LoginHistoryEntityMapper loginHistoryEntityMapper;

    @Inject
    private AdminUserService userService;

    @Override
    public AuthToken create(Login login) {
        AdminUser user = null;
        
        // query by username
        if (!StringUtils.isBlank(login.getUsername())) {
            user = this.userService.getByUsername(login.getUsername());
            if (user == null) {
            	// 手机号作为username传递
//                user = this.userService.getByCellphone(login.getUsername()); 
            }
        }
        
        if (user == null || !PasswordCrypt.encrypt(login.getPassword()).equals(user.getPassword())) {
            logger.warn("password incorrect");
            return null;
        }
        else if (user.getUserStatus() == UserStatus.FORBIDDEN) {
            logger.warn("userStatus is FORBIDDEN");
            return null;
        }
        //各个平台用户区分
        else if (user.getPlatformSource().code() != login.getPlatformSource().code()) {
            logger.warn("Unauthorized");
            return null;
        }

        login.setUserId(user.getUserId());
        saveLoginHistory(login);

        long userId = user.getUserId();
        long userType = user.getUserType();
        
        AuthToken authToken = createAuthToken(userId, userType, login.getRemember());
        return authToken;
    }

    private void saveLoginHistory(Login login) {
        // record history
        login.setLoginTime(new Date());
        this.loginHistoryEntityMapper.insertSelective(BeanUtils.copyProperties(login, LoginHistoryEntity.class));
    }

    private AuthToken createAuthToken(long userId, long userType, boolean remember) {
        long age = Constants.AUTH_TOKEN_AGE_MAX;

        // set authToken cookie
        final long now = System.currentTimeMillis();
        final long expiry = now + age * 1000;
        /*final AuthToken authToken = new AuthToken(userId, AccountType.ADMIN_USER, now, expiry, RandUtil.rand());*/
        final AuthToken authToken = new AuthToken(userId, userType, now, expiry, RandUtil.rand());
        return authToken;
    }
}
