package com.sudaotech.user;

public abstract class UserType {
	
    /**匿名用户*/
    public static final Long UNKNOWN = 0L;
    
    /**管理员用户*/
    public static final Long ADMIN_USER = 10L;
    
    /**园区组用户*/
    public static final Long PARK_GROUP_USER = 11L;

    /**普通用户用户*/
    public static final Long NORMAL_USER = 20L;
    
    /**服务商用户*/
    public static final Long SERVICE_PROVIDER_USER = 30L;
    
    
}
