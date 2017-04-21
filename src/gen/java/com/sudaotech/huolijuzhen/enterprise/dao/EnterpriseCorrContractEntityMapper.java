package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntityExample;
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

public interface EnterpriseCorrContractEntityMapper {
    @SelectProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseCorrContractEntityExample example);

    @DeleteProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseCorrContractEntityExample example);

    @Delete({
        "delete from enterprise_corr_contract",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_corr_contract (id, enterpriseCottId, ",
        "contractId, contNo, ",
        "startDate, endDate, contractStatus, ",
        "terminateUser, terminate, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{enterpriseCottId,jdbcType=BIGINT}, ",
        "#{contractId,jdbcType=BIGINT}, #{contNo,jdbcType=VARCHAR}, ",
        "#{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, #{contractStatus,jdbcType=INTEGER}, ",
        "#{terminateUser,jdbcType=BIGINT}, #{terminate,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterpriseCorrContractEntity record);

    @InsertProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseCorrContractEntity record);

    @SelectProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="terminateUser", property="terminateUser", jdbcType=JdbcType.BIGINT),
        @Result(column="terminate", property="terminate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCorrContractEntity> selectByExampleWithRowbounds(EnterpriseCorrContractEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="terminateUser", property="terminateUser", jdbcType=JdbcType.BIGINT),
        @Result(column="terminate", property="terminate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCorrContractEntity> selectByExample(EnterpriseCorrContractEntityExample example);

    @Select({
        "select",
        "id, enterpriseCottId, contractId, contNo, startDate, endDate, contractStatus, ",
        "terminateUser, terminate, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate",
        "from enterprise_corr_contract",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="terminateUser", property="terminateUser", jdbcType=JdbcType.BIGINT),
        @Result(column="terminate", property="terminate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterpriseCorrContractEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseCorrContractEntity record, @Param("example") EnterpriseCorrContractEntityExample example);

    @UpdateProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseCorrContractEntity record, @Param("example") EnterpriseCorrContractEntityExample example);

    @UpdateProvider(type=EnterpriseCorrContractEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseCorrContractEntity record);

    @Update({
        "update enterprise_corr_contract",
        "set enterpriseCottId = #{enterpriseCottId,jdbcType=BIGINT},",
          "contractId = #{contractId,jdbcType=BIGINT},",
          "contNo = #{contNo,jdbcType=VARCHAR},",
          "startDate = #{startDate,jdbcType=DATE},",
          "endDate = #{endDate,jdbcType=DATE},",
          "contractStatus = #{contractStatus,jdbcType=INTEGER},",
          "terminateUser = #{terminateUser,jdbcType=BIGINT},",
          "terminate = #{terminate,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseCorrContractEntity record);
}