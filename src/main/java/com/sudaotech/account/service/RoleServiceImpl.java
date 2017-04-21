package com.sudaotech.account.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.account.dao.RoleEntity;
import com.sudaotech.account.dao.RoleEntityExample;
import com.sudaotech.account.dao.RoleEntityMapper;
import com.sudaotech.account.dao.RolePermissionEntity;
import com.sudaotech.account.dao.RolePermissionEntityExample;
import com.sudaotech.account.dao.RolePermissionEntityMapper;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.user.web.admin.AdminUserResource.RoleVo;
import com.sudaotech.util.BeanUtils;

public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    private static final String CACHE_PREFIX_ROLE_PERMISSION = "RolePermission-";

    @Inject
    private RoleEntityMapper roleMapper;
    @Inject
    private RolePermissionEntityMapper rolePermissionMapper;

    @Override
    public Role getById(Long roleId) {
        RoleEntity entity = this.roleMapper.selectByPrimaryKey(roleId);
        if (entity == null) {
            return null;
        }
        
        Role role = BeanUtils.copyProperties(entity, Role.class);
        role.setPermissions(getPermissionsByRoleId(roleId));
        
        return role;
    }
    
    private List<String> getPermissionsByRoleId(Long roleId) {
        RolePermissionEntityExample example = new RolePermissionEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL).andRoleIdEqualTo(roleId);
        List<String> permissions = new ArrayList<String>();
        List<RolePermissionEntity> list = this.rolePermissionMapper.selectByExample(example);
        for (RolePermissionEntity item : list) {
            permissions.add(item.getPermissionCode());
        }
        return permissions;
    }

    @Override
    public List<RoleVo> getRoles(List<Long> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            logger.warn("empty roleIds");
            return Collections.emptyList();
        }
        
        RoleEntityExample example = new RoleEntityExample();
        example.createCriteria().andRoleIdIn(roleIds).andStatusEqualTo(Status.NORMAL);
        List<RoleEntity> list = this.roleMapper.selectByExample(example);
        return BeanUtils.copyListProperties(list, RoleVo.class);
    }
    
    @Override
    @Transactional
    public Long create(Role role) {
        if (role.getRoleId() == null) {
            role.setRoleId(this.getSequenceService().nextLong());
        }

        RoleEntity roleEntity = BeanUtils.copyProperties(role, RoleEntity.class);
        roleEntity.setCreateBy(role.getOperator());
        roleEntity.setCreateTime(new Date());
        roleEntity.setStatus(Status.NORMAL);
        this.roleMapper.insertSelective(roleEntity);

        this.saveRolePermissionMapping(role);

        logger.info("Created Role: {}", role);

        return role.getRoleId();
    }


    private void saveRolePermissionMapping(Role role) {
        if (role.getPermissions() == null) {
            return;
        }
        
        Map<String, Object> rolePermissionMap = new HashMap<String, Object>();
        rolePermissionMap.put("roleId", role.getRoleId());
        rolePermissionMap.put("status", Status.DELETED.code());
        rolePermissionMapper.updateByRoleId(rolePermissionMap);
        
//        // delete at first
//        RolePermissionEntity record = new RolePermissionEntity();
//        record.setUpdateBy(role.getOperator());
//        record.setUpdateTime(new Date());
//        record.setStatus(Status.DELETED);
//        RolePermissionEntityExample example = new RolePermissionEntityExample();
//        example.createCriteria()
//            .andStatusEqualTo(Status.NORMAL)
//            .andRoleIdEqualTo(role.getRoleId());
//        this.rolePermissionMapper.updateByExampleSelective(record, example);
        
        // create later
        for (String permission : role.getPermissions()) {
            RolePermissionEntity rolePermission = new RolePermissionEntity();
            rolePermission.setStatus(Status.NORMAL);
            rolePermission.setCreateBy(role.getOperator());
            rolePermission.setCreateTime(new Date());
            rolePermission.setRoleId(role.getRoleId());
            rolePermission.setPermissionCode(permission);

            this.rolePermissionMapper.insertSelective(rolePermission);
        }
    }

    @Override
    @Transactional
    public void update(Role role) {
        RoleEntity entity = BeanUtils.copyProperties(role, RoleEntity.class);
        entity.setUpdateBy(role.getOperator());
        entity.setUpdateTime(new Date());
        this.roleMapper.updateByPrimaryKeySelective(entity);
        this.saveRolePermissionMapping(role);

        //清除缓存
        this.getCacheService().clearCache();
//        this.clearCache(role.getRoleId());
        logger.info("Update Role: {}", role);
    }

    @Override
    public Page<Role> find(RoleQuery query) {
        RoleEntityExample example = new RoleEntityExample();
        RoleEntityExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        //同一平台下
        if(query.getPlatformSource() != null){    
        	criteria.andPlatformSourceEqualTo(query.getPlatformSource());
        }
        //只能看到同一平台下的所属平台角色以及 系统默认的该平台角色
        if(query.getPlatformSourceId() != null){  
        	//正式环境
        	criteria.andPlatformSourceIdIn(Arrays.asList(new Long[]{query.getPlatformSourceId()}));
        	//测试环境放开权限
//        	criteria.andPlatformSourceIdIn(Arrays.asList(new Long[]{0L,query.getPlatformSourceId()}));
        }
        if (query.getScope() != null) {
            criteria.andScopeEqualTo(query.getScope());    
        }
        if (!StringUtils.isBlank(query.getName())) {
            criteria.andNameLike("%" + query.getName() + "%");
        }

        Page<Role> page = new Page<Role>(query);
        page.setTotal(this.roleMapper.countByExample(example));
        if (page.getTotal() > 0) {
        	PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
            List<RoleEntity> list = this.roleMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            List<Role> roles = BeanUtils.copyListProperties(list, Role.class);
            for (Role role : roles) {
                role.setPermissions(this.getPermissionsByRoleId(role.getRoleId()));
            }
            page.setItems(roles);
        }

        return page;
    }


    private void clearCache(Long roleId) {
        this.getRedisCacheService().clear(CACHE_PREFIX_ROLE_PERMISSION + roleId);
    }

}
