package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntityExample;
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

public interface EnterpriseInfoEntityMapper {
    @SelectProvider(type=EnterpriseInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseInfoEntityExample example);

    @DeleteProvider(type=EnterpriseInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseInfoEntityExample example);

    @Delete({
        "delete from enterprise_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_info (id, name, ",
        "type, code, contacts, ",
        "phone, adminAccount, ",
        "createSource, totalBala, ",
        "ableBala, freezeBala, ",
        "bindBala, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, #{contacts,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{adminAccount,jdbcType=VARCHAR}, ",
        "#{createSource,jdbcType=INTEGER}, #{totalBala,jdbcType=DOUBLE}, ",
        "#{ableBala,jdbcType=DOUBLE}, #{freezeBala,jdbcType=DOUBLE}, ",
        "#{bindBala,jdbcType=DOUBLE}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterpriseInfoEntity record);

    @InsertProvider(type=EnterpriseInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseInfoEntity record);

    @SelectProvider(type=EnterpriseInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="totalBala", property="totalBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="ableBala", property="ableBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="freezeBala", property="freezeBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="bindBala", property="bindBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseInfoEntity> selectByExampleWithRowbounds(EnterpriseInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="totalBala", property="totalBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="ableBala", property="ableBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="freezeBala", property="freezeBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="bindBala", property="bindBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseInfoEntity> selectByExample(EnterpriseInfoEntityExample example);

    @Select({
        "select",
        "id, name, type, code, contacts, phone, adminAccount, createSource, totalBala, ",
        "ableBala, freezeBala, bindBala, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate",
        "from enterprise_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminAccount", property="adminAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="totalBala", property="totalBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="ableBala", property="ableBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="freezeBala", property="freezeBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="bindBala", property="bindBala", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterpriseInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseInfoEntity record, @Param("example") EnterpriseInfoEntityExample example);

    @UpdateProvider(type=EnterpriseInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseInfoEntity record, @Param("example") EnterpriseInfoEntityExample example);

    @UpdateProvider(type=EnterpriseInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseInfoEntity record);

    @Update({
        "update enterprise_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "adminAccount = #{adminAccount,jdbcType=VARCHAR},",
          "createSource = #{createSource,jdbcType=INTEGER},",
          "totalBala = #{totalBala,jdbcType=DOUBLE},",
          "ableBala = #{ableBala,jdbcType=DOUBLE},",
          "freezeBala = #{freezeBala,jdbcType=DOUBLE},",
          "bindBala = #{bindBala,jdbcType=DOUBLE},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseInfoEntity record);
}