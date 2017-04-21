package com.sudaotech.account.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.account.dao.AccountMapper;
import com.sudaotech.account.dao.UserPermissionEntity;
import com.sudaotech.account.dao.UserPermissionEntityMapper;
import com.sudaotech.account.dao.UserRoleEntity;
import com.sudaotech.account.dao.UserRoleEntityMapper;
import com.sudaotech.core.Cachable;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;

public class AccountServiceImpl extends BaseServiceImpl implements AccountService {
    @Inject
    private AccountMapper accountMapper;
    @Inject
    private UserPermissionEntityMapper userPermissionEntityMapper;
    @Inject
    private UserRoleEntityMapper userRoleEntityMapper;

	@Override
    public List<String> getPermissionsByUserId(final Long userId) {
	    Cachable<List<String>> cache = new Cachable<List<String>>(){
            @Override
            public Object getKey() {
                return AccountServiceImpl.class.getSimpleName() + "#getPermissionsByUserId=" + userId;
            }

            @Override
            public List<String> getValue() {
                Set<String> permissions = new HashSet<String>();
                
                // from user-permissions
//                UserPermissionEntityExample example = new UserPermissionEntityExample();
//                example.createCriteria().andStatusEqualTo(Status.NORMAL).andUserIdEqualTo(userId);
//                for (UserPermissionEntity entity : userPermissionEntityMapper.selectByExample(example)) {
//                    permissions.add(entity.getPermissionCode());
//                }
                
                // from user-role-permissions
                List<Long> roleIds = getRoleIdsByUserId(userId);
                if (CollectionUtils.isNotEmpty(roleIds)) {
                    List<String> list = accountMapper.findPermissionsByRoleIds(roleIds);
                    permissions.addAll(list);
                }
                
                ArrayList<String> result = new ArrayList<String>(permissions);
                
                
                return result;
            }
	    };
	    
//        return this.getRedisCacheService().cache(cache);
          return this.getCacheService().cache(cache);
    }

    @Override
    public List<Long> getRoleIdsByUserId(final Long userId) {
        List<Long> roleIds = accountMapper.findRoleIdsByUserId(userId);
        return roleIds;
    }
    
    @Override
    public void createAccount(Account account) {
    	 
    	 
         
         if (account.getRoleIds() != null) {
            for (Long roleId : account.getRoleIds()) {
                UserRoleEntity entity = new UserRoleEntity();
                entity.setStatus(Status.NORMAL);
                entity.setUserId(account.getUserId());
                entity.setRoleId(roleId);
                this.userRoleEntityMapper.insertSelective(entity);
            }
        }
        
        if (account.getPermissions() != null) {
            for (String permission : account.getPermissions()) {
                UserPermissionEntity record = new UserPermissionEntity();
                record.setStatus(Status.NORMAL);
                record.setUserId(account.getUserId());
                record.setPermissionCode(permission);
                this.userPermissionEntityMapper.insertSelective(record);
            }
        }
    }

    @Override
    public void updateAccount(Account account) {
        if (account == null || account.getPermissions() == null) {
            return;
        }
        
        //清楚缓存
//        String key = AccountServiceImpl.class.getSimpleName() + "#getPermissionsByUserId=" + account.getUserId();
        this.getCacheService().clearCache();
        
        //删除所有的角色权限关系
        Map<String, Object> userRoleEntity = new HashMap<String, Object>();
        userRoleEntity.put("userId", account.getUserId());
        userRoleEntity.put("status", Status.DELETED.code());
        userRoleEntityMapper.updateByUserId(userRoleEntity);
        

        //删除所有的权限用户关联
        Map<String, Object> userPermissionEntity = new HashMap<String, Object>();
        userPermissionEntity.put("userId", account.getUserId());
        userPermissionEntity.put("status", Status.DELETED.code());
        userPermissionEntityMapper.updateByUserId(userPermissionEntity);
//        
//        UserPermissionEntity record = new UserPermissionEntity();
//        record.setStatus(Status.DELETED);
//        record.setUserId(account.getUserId());
//        record.setUpdateBy(account.getOperator());
//        record.setUpdateTime(new Date());
//        
//        UserPermissionEntityExample example = new UserPermissionEntityExample();
//        example.createCriteria()
//            .andStatusEqualTo(Status.NORMAL)
//            .andUserIdEqualTo(account.getUserId());
//        this.userPermissionEntityMapper.updateByExampleSelective(record, example);
        
        this.createAccount(account);
    }
}
