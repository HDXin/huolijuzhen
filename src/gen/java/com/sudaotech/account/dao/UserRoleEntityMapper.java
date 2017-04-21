package com.sudaotech.account.dao;

import com.sudaotech.account.dao.UserRoleEntity;
import com.sudaotech.account.dao.UserRoleEntityExample;

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

public interface UserRoleEntityMapper {
    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="countByExample")
    int countByExample(UserRoleEntityExample example);

    @DeleteProvider(type=UserRoleEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleEntityExample example);

    @Delete({
        "delete from user_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_role (id, userId, ",
        "roleId, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=BIGINT}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(UserRoleEntity record);

    @InsertProvider(type=UserRoleEntitySqlProvider.class, method="insertSelective")
    int insertSelective(UserRoleEntity record);

    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserRoleEntity> selectByExampleWithRowbounds(UserRoleEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserRoleEntity> selectByExample(UserRoleEntityExample example);

    @Select({
        "select",
        "id, userId, roleId, displayOrder, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate",
        "from user_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    UserRoleEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRoleEntity record, @Param("example") UserRoleEntityExample example);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRoleEntity record, @Param("example") UserRoleEntityExample example);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRoleEntity record);

    @Update({
        "update user_role",
        "set userId = #{userId,jdbcType=BIGINT},",
          "roleId = #{roleId,jdbcType=BIGINT},",
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
    int updateByPrimaryKey(UserRoleEntity record);
    
    @Update({
        "update user_role"
        + " set status = #{status}"
        + " where userId = #{userId}"
    })
    int updateByUserId(Map<String, Object> userRoleEntity);
}