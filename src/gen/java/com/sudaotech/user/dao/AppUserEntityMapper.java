package com.sudaotech.user.dao;

import com.sudaotech.user.dao.AppUserEntity;
import com.sudaotech.user.dao.AppUserEntityExample;
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

public interface AppUserEntityMapper {
    @SelectProvider(type=AppUserEntitySqlProvider.class, method="countByExample")
    int countByExample(AppUserEntityExample example);

    @DeleteProvider(type=AppUserEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AppUserEntityExample example);

    @Delete({
        "delete from app_user",
        "where userId = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into app_user (userId, companyId, ",
        "userType, username, ",
        "password, passwordStatus, ",
        "nickname, photo, ",
        "name, gender, birthday, ",
        "cellphone, tel, ",
        "email, hidden, userStatus, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{userId,jdbcType=BIGINT}, #{companyId,jdbcType=BIGINT}, ",
        "#{userType,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{passwordStatus,jdbcType=INTEGER}, ",
        "#{nickname,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{gender,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{cellphone,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{hidden,jdbcType=INTEGER}, #{userStatus,jdbcType=INTEGER}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(AppUserEntity record);

    @InsertProvider(type=AppUserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(AppUserEntity record);

    @SelectProvider(type=AppUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwordStatus", property="passwordStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.INTEGER),
        @Result(column="userStatus", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppUserEntity> selectByExampleWithRowbounds(AppUserEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=AppUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwordStatus", property="passwordStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.INTEGER),
        @Result(column="userStatus", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppUserEntity> selectByExample(AppUserEntityExample example);

    @Select({
        "select",
        "userId, companyId, userType, username, password, passwordStatus, nickname, photo, ",
        "name, gender, birthday, cellphone, tel, email, hidden, userStatus, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from app_user",
        "where userId = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwordStatus", property="passwordStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.INTEGER),
        @Result(column="userStatus", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    AppUserEntity selectByPrimaryKey(Long userId);

    @UpdateProvider(type=AppUserEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppUserEntity record, @Param("example") AppUserEntityExample example);

    @UpdateProvider(type=AppUserEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppUserEntity record, @Param("example") AppUserEntityExample example);

    @UpdateProvider(type=AppUserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppUserEntity record);

    @Update({
        "update app_user",
        "set companyId = #{companyId,jdbcType=BIGINT},",
          "userType = #{userType,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "passwordStatus = #{passwordStatus,jdbcType=INTEGER},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "cellphone = #{cellphone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "hidden = #{hidden,jdbcType=INTEGER},",
          "userStatus = #{userStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where userId = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AppUserEntity record);
}