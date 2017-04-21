package com.sudaotech.account.dao;

import com.sudaotech.account.dao.RoleEntity;
import com.sudaotech.account.dao.RoleEntityExample;
import java.util.List;
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

public interface RoleEntityMapper {
    @SelectProvider(type=RoleEntitySqlProvider.class, method="countByExample")
    int countByExample(RoleEntityExample example);

    @DeleteProvider(type=RoleEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleEntityExample example);

    @Delete({
        "delete from role",
        "where roleId = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into role (roleId, platformSource, ",
        "platformSourceId, name, ",
        "description, scope, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{roleId,jdbcType=BIGINT}, #{platformSource,jdbcType=INTEGER}, ",
        "#{platformSourceId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{scope,jdbcType=INTEGER}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(RoleEntity record);

    @InsertProvider(type=RoleEntitySqlProvider.class, method="insertSelective")
    int insertSelective(RoleEntity record);

    @SelectProvider(type=RoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RoleEntity> selectByExampleWithRowbounds(RoleEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=RoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RoleEntity> selectByExample(RoleEntityExample example);

    @Select({
        "select",
        "roleId, platformSource, platformSourceId, name, description, scope, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from role",
        "where roleId = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="roleId", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    RoleEntity selectByPrimaryKey(Long roleId);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleEntity record);

    @Update({
        "update role",
        "set platformSource = #{platformSource,jdbcType=INTEGER},",
          "platformSourceId = #{platformSourceId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "scope = #{scope,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where roleId = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RoleEntity record);
}