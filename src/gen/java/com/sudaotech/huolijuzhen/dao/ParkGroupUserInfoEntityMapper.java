package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntityExample;
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

public interface ParkGroupUserInfoEntityMapper {
    @SelectProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ParkGroupUserInfoEntityExample example);

    @DeleteProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkGroupUserInfoEntityExample example);

    @Delete({
        "delete from park_group_user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into park_group_user_info (id, parkGroupId, ",
        "adminUserId, username, ",
        "contacts, mobilePhone, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{parkGroupId,jdbcType=BIGINT}, ",
        "#{adminUserId,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{contacts,jdbcType=VARCHAR}, #{mobilePhone,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ParkGroupUserInfoEntity record);

    @InsertProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ParkGroupUserInfoEntity record);

    @SelectProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupUserInfoEntity> selectByExampleWithRowbounds(ParkGroupUserInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupUserInfoEntity> selectByExample(ParkGroupUserInfoEntityExample example);

    @Select({
        "select",
        "id, parkGroupId, adminUserId, username, contacts, mobilePhone, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from park_group_user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkGroupUserInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkGroupUserInfoEntity record, @Param("example") ParkGroupUserInfoEntityExample example);

    @UpdateProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkGroupUserInfoEntity record, @Param("example") ParkGroupUserInfoEntityExample example);

    @UpdateProvider(type=ParkGroupUserInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkGroupUserInfoEntity record);

    @Update({
        "update park_group_user_info",
        "set parkGroupId = #{parkGroupId,jdbcType=BIGINT},",
          "adminUserId = #{adminUserId,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "mobilePhone = #{mobilePhone,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkGroupUserInfoEntity record);
}