package com.sudaotech.user.dao;

import com.sudaotech.user.dao.ExternalUserEntity;
import com.sudaotech.user.dao.ExternalUserEntityExample;
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

public interface ExternalUserEntityMapper {
    @SelectProvider(type=ExternalUserEntitySqlProvider.class, method="countByExample")
    int countByExample(ExternalUserEntityExample example);

    @DeleteProvider(type=ExternalUserEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ExternalUserEntityExample example);

    @Delete({
        "delete from external_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into external_user (id, type, ",
        "userId, openId, accessToken, ",
        "note, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, json)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=BIGINT}, #{openId,jdbcType=VARCHAR}, #{accessToken,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{json,jdbcType=LONGVARCHAR})"
    })
    int insert(ExternalUserEntity record);

    @InsertProvider(type=ExternalUserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ExternalUserEntity record);

    @SelectProvider(type=ExternalUserEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openId", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="accessToken", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ExternalUserEntity> selectByExampleWithBLOBsWithRowbounds(ExternalUserEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ExternalUserEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openId", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="accessToken", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ExternalUserEntity> selectByExampleWithBLOBs(ExternalUserEntityExample example);

    @SelectProvider(type=ExternalUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openId", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="accessToken", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ExternalUserEntity> selectByExampleWithRowbounds(ExternalUserEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ExternalUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openId", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="accessToken", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ExternalUserEntity> selectByExample(ExternalUserEntityExample example);

    @Select({
        "select",
        "id, type, userId, openId, accessToken, note, displayOrder, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate, json",
        "from external_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="openId", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="accessToken", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    ExternalUserEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ExternalUserEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ExternalUserEntity record, @Param("example") ExternalUserEntityExample example);

    @UpdateProvider(type=ExternalUserEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ExternalUserEntity record, @Param("example") ExternalUserEntityExample example);

    @UpdateProvider(type=ExternalUserEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ExternalUserEntity record, @Param("example") ExternalUserEntityExample example);

    @UpdateProvider(type=ExternalUserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ExternalUserEntity record);

    @Update({
        "update external_user",
        "set type = #{type,jdbcType=INTEGER},",
          "userId = #{userId,jdbcType=BIGINT},",
          "openId = #{openId,jdbcType=VARCHAR},",
          "accessToken = #{accessToken,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "json = #{json,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ExternalUserEntity record);

    @Update({
        "update external_user",
        "set type = #{type,jdbcType=INTEGER},",
          "userId = #{userId,jdbcType=BIGINT},",
          "openId = #{openId,jdbcType=VARCHAR},",
          "accessToken = #{accessToken,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
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
    int updateByPrimaryKey(ExternalUserEntity record);
}