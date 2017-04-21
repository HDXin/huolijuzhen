package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ParkInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkInfoEntityExample;
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

public interface ParkInfoEntityMapper {
    @SelectProvider(type=ParkInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ParkInfoEntityExample example);

    @DeleteProvider(type=ParkInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkInfoEntityExample example);

    @Delete({
        "delete from park_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into park_info (id, name, ",
        "provinceId, cityId, ",
        "regionId, positionId, ",
        "contacts, mobilePhone, ",
        "phone, email, adminAccount, ",
        "adminUserId, isGroup, ",
        "closeBy, closeTime, ",
        "enableStatus, startBy, ",
        "startTime, accountManager, ",
        "managerPhone, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{provinceId,jdbcType=BIGINT}, #{cityId,jdbcType=BIGINT}, ",
        "#{regionId,jdbcType=BIGINT}, #{positionId,jdbcType=BIGINT}, ",
        "#{contacts,jdbcType=VARCHAR}, #{mobilePhone,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{adminAccount,jdbcType=VARCHAR}, ",
        "#{adminUserId,jdbcType=BIGINT}, #{isGroup,jdbcType=INTEGER}, ",
        "#{closeBy,jdbcType=BIGINT}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{enableStatus,jdbcType=INTEGER}, #{startBy,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{accountManager,jdbcType=VARCHAR}, ",
        "#{managerPhone,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ParkInfoEntity record);

    @InsertProvider(type=ParkInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ParkInfoEntity record);

    @SelectProvider(type=ParkInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="regionId", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="positionId", property="positionId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="isGroup", property="isGroup", jdbcType=JdbcType.INTEGER),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="accountManager", property="accountManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="managerPhone", property="managerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkInfoEntity> selectByExampleWithRowbounds(ParkInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ParkInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="regionId", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="positionId", property="positionId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="isGroup", property="isGroup", jdbcType=JdbcType.INTEGER),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="accountManager", property="accountManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="managerPhone", property="managerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkInfoEntity> selectByExample(ParkInfoEntityExample example);

    @Select({
        "select",
        "id, name, provinceId, cityId, regionId, positionId, contacts, mobilePhone, phone, ",
        "email, adminAccount, adminUserId, isGroup, closeBy, closeTime, enableStatus, ",
        "startBy, startTime, accountManager, managerPhone, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from park_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="regionId", property="regionId", jdbcType=JdbcType.BIGINT),
        @Result(column="positionId", property="positionId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminUserId", property="adminUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="isGroup", property="isGroup", jdbcType=JdbcType.INTEGER),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="accountManager", property="accountManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="managerPhone", property="managerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkInfoEntity record, @Param("example") ParkInfoEntityExample example);

    @UpdateProvider(type=ParkInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkInfoEntity record, @Param("example") ParkInfoEntityExample example);

    @UpdateProvider(type=ParkInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkInfoEntity record);

    @Update({
        "update park_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "provinceId = #{provinceId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "regionId = #{regionId,jdbcType=BIGINT},",
          "positionId = #{positionId,jdbcType=BIGINT},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "mobilePhone = #{mobilePhone,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "adminAccount = #{adminAccount,jdbcType=VARCHAR},",
          "adminUserId = #{adminUserId,jdbcType=BIGINT},",
          "isGroup = #{isGroup,jdbcType=INTEGER},",
          "closeBy = #{closeBy,jdbcType=BIGINT},",
          "closeTime = #{closeTime,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "startBy = #{startBy,jdbcType=BIGINT},",
          "startTime = #{startTime,jdbcType=TIMESTAMP},",
          "accountManager = #{accountManager,jdbcType=VARCHAR},",
          "managerPhone = #{managerPhone,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkInfoEntity record);
}