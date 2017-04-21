package com.sudaotech.core.service;

import java.util.Collections;
import java.util.List;
import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.core.Constants;
import com.sudaotech.core.Session;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.redis.service.RedisService;
import com.sudaotech.user.enums.UserStatus;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;

public class SessionServiceImpl extends BaseServiceImpl implements SessionService {

    @Inject
    protected RedisService redisService;
    @Inject
    protected AccountService accountService;
    
    @Inject
    private AdminUserService adminUserService;
    @Inject
    private AppUserService appUserService;

    protected static final Session anonymousSession = new Session() {
        @Override
        public Long getUserId() {
            return null;
        }
        @Override
        public List<String> getPermissions() {
            return Collections.emptyList();
        }
        @Override
        public Long getUserType() {
        	//匿名用户类型，优先采用匿名用户类型配置参数，不存在则采用以前默认的
        	/*String typeId = TemplateConfig.getInstance().getTemplates().get(anonymousUserTypeIdKey);
        	if(StringUtils.isNotBlank(typeId)){
        		return Long.parseLong(typeId);
        	}
            return AccountType.UNKNOWN;*/
        	return null ;// UserType.ANONYMOUS_USER_TYPE_ID.code();
        }
        @Override
        public Long getCompanyId() {
            return null;
        }
		@Override
		public Long getPlatformId() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Integer getPlatformSource() {
			// TODO Auto-generated method stub
			return null;
		}
    };

    @Override
    public void createSession(AuthToken authToken) {
        this.resetSessionExpiryTime(authToken);
    }
    @Override
    public void deleteSession(AuthToken authToken) {
        if (authToken == null) {
            logger.warn("authToken is null");
            return;
        }
        this.redisService.del(buildSessionKey(authToken));
    }
    
    @Override
    public Session getSession(final AuthToken authToken) {
        if (authToken == null) {
            return anonymousSession;
        }
        //admin_user里的userType统一修改为表user_type关联的
//        if (authToken.type == AccountType.ADMIN_USER) {
            return this.getAdminSession(authToken);
//        }

//        return anonymousSession;
    }

    protected void resetSessionExpiryTime(AuthToken authToken) {
        this.redisService.set(buildSessionKey(authToken), "ACTIVE", Constants.AUTH_TOKEN_AGE_ACTIVE);
    }
    protected boolean isSessionInactive(AuthToken authToken) {
        return !this.isSessionActive(authToken);
    }
    protected boolean isSessionActive(AuthToken authToken) {
        return this.redisService.exists(buildSessionKey(authToken));
    }
    protected String buildSessionKey(AuthToken authToken) {
        String sessionKey = "session-" + authToken.userId + "-" + authToken.rand;
        return sessionKey;
    }

    private final Session getAdminSession(final AuthToken authToken) {
        if (authToken == null || this.isSessionInactive(authToken)) {
            return anonymousSession;
        }
        
        final Long userId = authToken.userId;
        
        this.resetSessionExpiryTime(authToken);
        
        final AdminUser user = adminUserService.getById(userId);
        if (user.getUserStatus() == UserStatus.FORBIDDEN) {
            logger.warn("userStatus is FORBIDDEN");
            return anonymousSession;
        }
        
        return new Session() {
            @Override
            public Long getUserId() {
                return userId;
            }
            @Override
            public List<String> getPermissions() {
                return accountService.getPermissionsByUserId(userId);
            }
            @Override
            public Long getUserType() {
                return user.getUserType();
            }
            @Override
            public Long getCompanyId() {
                return user.getCompanyId();
            }
			@Override
			public Long getPlatformId() {
				// TODO Auto-generated method stub
				return user.getPlatformSourceId();
			}
			@Override
			public Integer getPlatformSource() {
				// TODO Auto-generated method stub
				return user.getPlatformSource().code();
			}
        };
    }

    private final Session getAppSession(final AuthToken authToken) {
//        if (authToken == null || this.isSessionInactive(authToken)) {
//            return anonymousSession;
//        }
        // APP Session暂不检查是否活跃
        if (authToken == null) {
            return anonymousSession;
        }
        
        final Long userId = authToken.userId;
        
        this.resetSessionExpiryTime(authToken);
        
        final AppUser user = appUserService.getById(userId);
        if (null == user || user.getUserStatus() == UserStatus.FORBIDDEN) {
            logger.warn("userStatus is FORBIDDEN");
            return anonymousSession;
        }
        
        return new Session() {
            @Override
            public Long getUserId() {
                return userId;
            }
            @Override
            public List<String> getPermissions() {
                /*return accountService.getPermissionsByUserId(userId);*/
            	List<String> permissionList = accountService.getPermissionsByUserId(userId);
            	
            	//普通用户默认拥有的权限
            	permissionList.add("IMAGE::*");
            	permissionList.add("FILE::*");
            	return permissionList;
            }
            @Override
            public Long getUserType() {
                return user.getUserType();
            }
            @Override
            public Long getCompanyId() {
                return user.getCompanyId();
            }
			@Override
			public Long getPlatformId() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Integer getPlatformSource() {
				// TODO Auto-generated method stub
				return null;
			}
        };
    }
}
