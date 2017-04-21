package com.sudaotech.huolijuzhen.provider.dao;

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

public interface ProviderEntityMapper {
    @SelectProvider(type=ProviderEntitySqlProvider.class, method="countByExample")
    int countByExample(ProviderEntityExample example);

    @DeleteProvider(type=ProviderEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ProviderEntityExample example);

    @Delete({
        "delete from provider_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into provider_info (id, name, ",
        "proId, cityId, counId, ",
        "contacts, phone, ",
        "account, description, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, createSide, ",
        "parkId, enableStatus, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{proId,jdbcType=BIGINT}, #{cityId,jdbcType=BIGINT}, #{counId,jdbcType=BIGINT}, ",
        "#{contacts,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{createSide,jdbcType=INTEGER}, ",
        "#{parkId,jdbcType=BIGINT}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP})"
    })
    int insert(ProviderEntity record);

    @InsertProvider(type=ProviderEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ProviderEntity record);

    @SelectProvider(type=ProviderEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ProviderEntity> selectByExampleWithRowbounds(ProviderEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ProviderEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ProviderEntity> selectByExample(ProviderEntityExample example);

    @Select({
        "select",
        "id, name, proId, cityId, counId, contacts, phone, account, description, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate, createSide, ",
        "parkId, enableStatus, enableBy, enableTime, disableBy, disableTime",
        "from provider_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ProviderEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ProviderEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProviderEntity record, @Param("example") ProviderEntityExample example);

    @UpdateProvider(type=ProviderEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProviderEntity record, @Param("example") ProviderEntityExample example);

    @UpdateProvider(type=ProviderEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProviderEntity record);

    @Update({
        "update provider_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "proId = #{proId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "counId = #{counId,jdbcType=BIGINT},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProviderEntity record);
}