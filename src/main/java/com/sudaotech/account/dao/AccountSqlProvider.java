package com.sudaotech.account.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class AccountSqlProvider {
    
    public String findPermissionsByRoleIds(Map<String, Object> parameters) {
        @SuppressWarnings("unchecked")
        List<Long> roleIds = (List<Long>) parameters.get("roleIds");

        StringBuilder builder = new StringBuilder("select rp.permissionCode from role_permission rp where rp.status = 1 and rp.roleId in (");
        builder.append(StringUtils.join(roleIds, ","));
        builder.append(")");
        
        return builder.toString();
    }
    
    public String findRoleIdsByUserId(Long userId) {
        StringBuilder builder = new StringBuilder("select ur.roleId from user_role ur where ur.status = 1 and ur.userId = ");
        builder.append(userId);
        
        return builder.toString();
    }
}
