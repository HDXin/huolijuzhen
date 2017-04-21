package com.sudaotech.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface AccountMapper {

    @SelectProvider(type=AccountSqlProvider.class, method="findRoleIdsByUserId")
    List<Long> findRoleIdsByUserId(Long userId);

    
    @SelectProvider(type=AccountSqlProvider.class, method="findPermissionsByRoleIds")
    List<String> findPermissionsByRoleIds(@Param("roleIds") List<Long> roleIds);
}