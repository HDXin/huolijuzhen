package com.sudaotech.huolijuzhen.enterprise.dao;

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

public interface ContractResourceEntityMapper {
    @SelectProvider(type=ContractResourceEntitySqlProvider.class, method="countByExample")
    int countByExample(ContractResourceEntityExample example);

    @DeleteProvider(type=ContractResourceEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContractResourceEntityExample example);

    @Delete({
        "delete from contract_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into contract_resource (id, contractId, ",
        "resourceId, version, ",
        "status, createBy, ",
        "createTime, createName, ",
        "updateBy, updateTime, ",
        "lastUpdate, startDate, ",
        "endDate, useStatus)",
        "values (#{id,jdbcType=BIGINT}, #{contractId,jdbcType=BIGINT}, ",
        "#{resourceId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createName,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{startDate,jdbcType=TIMESTAMP}, ",
        "#{endDate,jdbcType=TIMESTAMP}, #{useStatus,jdbcType=INTEGER})"
    })
    int insert(ContractResourceEntity record);

    @InsertProvider(type=ContractResourceEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ContractResourceEntity record);

    @SelectProvider(type=ContractResourceEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER)
    })
    List<ContractResourceEntity> selectByExampleWithRowbounds(ContractResourceEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContractResourceEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER)
    })
    List<ContractResourceEntity> selectByExample(ContractResourceEntityExample example);

    @Select({
        "select",
        "id, contractId, resourceId, version, status, createBy, createTime, createName, ",
        "updateBy, updateTime, lastUpdate, startDate, endDate, useStatus",
        "from contract_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER)
    })
    ContractResourceEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContractResourceEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContractResourceEntity record, @Param("example") ContractResourceEntityExample example);

    @UpdateProvider(type=ContractResourceEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContractResourceEntity record, @Param("example") ContractResourceEntityExample example);

    @UpdateProvider(type=ContractResourceEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractResourceEntity record);

    @Update({
        "update contract_resource",
        "set contractId = #{contractId,jdbcType=BIGINT},",
          "resourceId = #{resourceId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "startDate = #{startDate,jdbcType=TIMESTAMP},",
          "endDate = #{endDate,jdbcType=TIMESTAMP},",
          "useStatus = #{useStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContractResourceEntity record);
}