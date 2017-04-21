package com.sudaotech.account.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sudaotech.account.dao.PermissionEntity;
import com.sudaotech.account.dao.PermissionEntityExample;
import com.sudaotech.account.dao.PermissionEntityExample.Criteria;
import com.sudaotech.account.dao.PermissionEntityMapper;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.util.BeanUtils;

@Singleton
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService {
    @Inject
    private PermissionEntityMapper permissionMapper;

    @Override
    public List<Permission> listPermissions(Integer scope) {
        PermissionEntityExample example = new PermissionEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        if (scope != null) {
            criteria.andScopeEqualTo(scope);
        }
        List<PermissionEntity> entityList = this.permissionMapper.selectByExample(example);
        return BeanUtils.copyListProperties(entityList, Permission.class);
    }

    @Override
    public List<Permission> getPermissions(List<Integer> permissionIds) {
        if (CollectionUtils.isEmpty(permissionIds)) {
            return Collections.emptyList();
        }
        
        PermissionEntityExample example = new PermissionEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        criteria.andPermissionIdIn(permissionIds);
        
        List<PermissionEntity> entityList = this.permissionMapper.selectByExample(example);
        return BeanUtils.copyListProperties(entityList, Permission.class);
    }

    @Override
    public List<String> getPermissionCode(List<Integer> permissionIds) {
        List<Permission> permissions = this.getPermissions(permissionIds);
        List<String> list = new ArrayList<String>(permissions.size());
        for (Permission p : permissions) {
            list.add(p.getCode());
        }
        
        return list;
    }
}
