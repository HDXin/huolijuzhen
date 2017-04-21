package com.sudaotech.account.dao;

import com.sudaotech.account.dao.RolePermissionEntity;
import com.sudaotech.account.dao.RolePermissionEntityExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RolePermissionEntityMapper {
    @SelectProvider(type=RolePermissionEntitySqlProvider.class, method="countByExample")
    int countByExample(RolePermissionEntityExample example);

    @DeleteProvider(type=RolePermissionEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePermissionEntityExample example);

    @Delete({
        "delete from role_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into role_permission (id, roleId, ",
        "permissionCode, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{permissionCode,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(RolePermissionEntity record);

    @InsertProvider(type=RolePermissionEntitySqlProvider.class, method="insertSelective")
    int insertSelective(RolePermissionEntity record);

    @SelectProvider(type=RolePermissionEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="permissionCode", property="permissionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RolePermissionEntity> selectByExampleWithRowbounds(RolePermissionEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=RolePermissionEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="permissionCode", property="permissionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RolePermissionEntity> selectByExample(RolePermissionEntityExample example);

    @Select({
        "select",
        "id, roleId, permissionCode, displayOrder, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from role_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="permissionCode", property="permissionCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    RolePermissionEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=RolePermissionEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    @UpdateProvider(type=RolePermissionEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    @UpdateProvider(type=RolePermissionEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePermissionEntity record);

    @Update({
        "update role_permission",
        "set roleId = #{roleId,jdbcType=BIGINT},",
          "permissionCode = #{permissionCode,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RolePermissionEntity record);
    
    @Update({
        "update role_permission"
        + " set status = #{status}"
        + " where roleId = #{roleId}"
    })
    int updateByRoleId(Map<String, Object> rolePermissionEntity);
    
}