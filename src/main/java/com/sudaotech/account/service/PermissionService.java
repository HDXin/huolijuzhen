package com.sudaotech.account.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;

public interface PermissionService extends BaseService {
    
    public List<Permission> getPermissions(List<Integer> permissionIds);
    
    public List<String> getPermissionCode(List<Integer> permissionIds);

    /**
     * 获取权限列表
     * @param scope 可选
     * @return
     */
    public List<Permission> listPermissions(Integer scope);
}
