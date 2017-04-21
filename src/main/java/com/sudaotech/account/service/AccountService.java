package com.sudaotech.account.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;

public interface AccountService extends BaseService {

    public List<String> getPermissionsByUserId(Long userId);
    public List<Long> getRoleIdsByUserId(final Long userId);
    
    public void createAccount(Account account);
    public void updateAccount(Account account);
    
    public static class Account {
        private Long operator;
        private Long userId;
        private List<String> permissions;
        private List<Long> roleIds;
        public List<Long> getRoleIds() {
            return roleIds;
        }
        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }
        public Long getOperator() {
            return operator;
        }
        public void setOperator(Long operator) {
            this.operator = operator;
        }
        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public List<String> getPermissions() {
            return permissions;
        }
        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }
    }
}
