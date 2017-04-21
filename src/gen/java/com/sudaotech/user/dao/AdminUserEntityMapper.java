package com.sudaotech.user.dao;

import com.sudaotech.user.dao.AdminUserEntity;
import com.sudaotech.user.dao.AdminUserEntityExample;
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

public interface AdminUserEntityMapper {
    @SelectProvider(type=AdminUserEntitySqlProvider.class, method="countByExample")
    int countByExample(AdminUserEntityExample example);

    @DeleteProvider(type=AdminUserEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminUserEntityExample example);

    @Delete({
        "delete from admin_user",
        "where userId = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into admin_user (userId, companyId, ",
        "providerId, userType, ",
        "platformSource, platformSourceId, ",
        "userAttribute, username, ",
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
        "#{providerId,jdbcType=BIGINT}, #{userType,jdbcType=BIGINT}, ",
        "#{platformSource,jdbcType=INTEGER}, #{platformSourceId,jdbcType=BIGINT}, ",
        "#{userAttribute,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
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
    int insert(AdminUserEntity record);

    @InsertProvider(type=AdminUserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(AdminUserEntity record);

    @SelectProvider(type=AdminUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="providerId", property="providerId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="userAttribute", property="userAttribute", jdbcType=JdbcType.INTEGER),
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
    List<AdminUserEntity> selectByExampleWithRowbounds(AdminUserEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=AdminUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="providerId", property="providerId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="userAttribute", property="userAttribute", jdbcType=JdbcType.INTEGER),
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
    List<AdminUserEntity> selectByExample(AdminUserEntityExample example);

    @Select({
        "select",
        "userId, companyId, providerId, userType, platformSource, platformSourceId, userAttribute, ",
        "username, password, passwordStatus, nickname, photo, name, gender, birthday, ",
        "cellphone, tel, email, hidden, userStatus, displayOrder, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from admin_user",
        "where userId = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="providerId", property="providerId", jdbcType=JdbcType.BIGINT),
        @Result(column="userType", property="userType", jdbcType=JdbcType.BIGINT),
        @Result(column="platformSource", property="platformSource", jdbcType=JdbcType.INTEGER),
        @Result(column="platformSourceId", property="platformSourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="userAttribute", property="userAttribute", jdbcType=JdbcType.INTEGER),
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
    AdminUserEntity selectByPrimaryKey(Long userId);

    @UpdateProvider(type=AdminUserEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminUserEntity record, @Param("example") AdminUserEntityExample example);

    @UpdateProvider(type=AdminUserEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminUserEntity record, @Param("example") AdminUserEntityExample example);

    @UpdateProvider(type=AdminUserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminUserEntity record);

    @Update({
        "update admin_user",
        "set companyId = #{companyId,jdbcType=BIGINT},",
          "providerId = #{providerId,jdbcType=BIGINT},",
          "userType = #{userType,jdbcType=BIGINT},",
          "platformSource = #{platformSource,jdbcType=INTEGER},",
          "platformSourceId = #{platformSourceId,jdbcType=BIGINT},",
          "userAttribute = #{userAttribute,jdbcType=INTEGER},",
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
    int updateByPrimaryKey(AdminUserEntity record);
}