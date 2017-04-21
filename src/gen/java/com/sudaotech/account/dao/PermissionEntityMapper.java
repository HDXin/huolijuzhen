package com.sudaotech.account.dao;

import com.sudaotech.account.dao.PermissionEntity;
import com.sudaotech.account.dao.PermissionEntityExample;
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

public interface PermissionEntityMapper {
    @SelectProvider(type=PermissionEntitySqlProvider.class, method="countByExample")
    int countByExample(PermissionEntityExample example);

    @DeleteProvider(type=PermissionEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(PermissionEntityExample example);

    @Delete({
        "delete from permission",
        "where permissionId = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer permissionId);

    @Insert({
        "insert into permission (permissionId, code, ",
        "name, description, ",
        "scope, module, menuCode, ",
        "menuName, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{permissionId,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{scope,jdbcType=INTEGER}, #{module,jdbcType=VARCHAR}, #{menuCode,jdbcType=VARCHAR}, ",
        "#{menuName,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(PermissionEntity record);

    @InsertProvider(type=PermissionEntitySqlProvider.class, method="insertSelective")
    int insertSelective(PermissionEntity record);

    @SelectProvider(type=PermissionEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="permissionId", property="permissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuCode", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuName", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PermissionEntity> selectByExampleWithRowbounds(PermissionEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=PermissionEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="permissionId", property="permissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuCode", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuName", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PermissionEntity> selectByExample(PermissionEntityExample example);

    @Select({
        "select",
        "permissionId, code, name, description, scope, module, menuCode, menuName, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from permission",
        "where permissionId = #{permissionId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="permissionId", property="permissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.INTEGER),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuCode", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menuName", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    PermissionEntity selectByPrimaryKey(Integer permissionId);

    @UpdateProvider(type=PermissionEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    @UpdateProvider(type=PermissionEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    @UpdateProvider(type=PermissionEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionEntity record);

    @Update({
        "update permission",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "scope = #{scope,jdbcType=INTEGER},",
          "module = #{module,jdbcType=VARCHAR},",
          "menuCode = #{menuCode,jdbcType=VARCHAR},",
          "menuName = #{menuName,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where permissionId = #{permissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PermissionEntity record);
}