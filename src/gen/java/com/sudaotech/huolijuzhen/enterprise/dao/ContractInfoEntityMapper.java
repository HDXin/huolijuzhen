package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample;
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

public interface ContractInfoEntityMapper {
    @SelectProvider(type=ContractInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ContractInfoEntityExample example);

    @DeleteProvider(type=ContractInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContractInfoEntityExample example);

    @Delete({
        "delete from contract_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into contract_info (id, businessNum, ",
        "enterpriseName, contNo, ",
        "startDate, endDate, proAddr, ",
        "area, totalMoney, ",
        "deposit, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "contractStatus, lastUpdateBy, ",
        "lastUpdateTime, executorId, ",
        "approvalProcessId)",
        "values (#{id,jdbcType=BIGINT}, #{businessNum,jdbcType=VARCHAR}, ",
        "#{enterpriseName,jdbcType=VARCHAR}, #{contNo,jdbcType=VARCHAR}, ",
        "#{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, #{proAddr,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=DECIMAL}, #{totalMoney,jdbcType=DECIMAL}, ",
        "#{deposit,jdbcType=DECIMAL}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{contractStatus,jdbcType=INTEGER}, #{lastUpdateBy,jdbcType=BIGINT}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{executorId,jdbcType=BIGINT}, ",
        "#{approvalProcessId,jdbcType=BIGINT})"
    })
    int insert(ContractInfoEntity record);

    @InsertProvider(type=ContractInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ContractInfoEntity record);

    @SelectProvider(type=ContractInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessNum", property="businessNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="proAddr", property="proAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="lastUpdateBy", property="lastUpdateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT)
    })
    List<ContractInfoEntity> selectByExampleWithRowbounds(ContractInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContractInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessNum", property="businessNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="proAddr", property="proAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="lastUpdateBy", property="lastUpdateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT)
    })
    List<ContractInfoEntity> selectByExample(ContractInfoEntityExample example);

    @Select({
        "select",
        "id, businessNum, enterpriseName, contNo, startDate, endDate, proAddr, area, ",
        "totalMoney, deposit, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate, contractStatus, lastUpdateBy, lastUpdateTime, executorId, approvalProcessId",
        "from contract_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessNum", property="businessNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contNo", property="contNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="proAddr", property="proAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contractStatus", property="contractStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="lastUpdateBy", property="lastUpdateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT)
    })
    ContractInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContractInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContractInfoEntity record, @Param("example") ContractInfoEntityExample example);

    @UpdateProvider(type=ContractInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContractInfoEntity record, @Param("example") ContractInfoEntityExample example);

    @UpdateProvider(type=ContractInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractInfoEntity record);

    @Update({
        "update contract_info",
        "set businessNum = #{businessNum,jdbcType=VARCHAR},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "contNo = #{contNo,jdbcType=VARCHAR},",
          "startDate = #{startDate,jdbcType=DATE},",
          "endDate = #{endDate,jdbcType=DATE},",
          "proAddr = #{proAddr,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=DECIMAL},",
          "totalMoney = #{totalMoney,jdbcType=DECIMAL},",
          "deposit = #{deposit,jdbcType=DECIMAL},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "contractStatus = #{contractStatus,jdbcType=INTEGER},",
          "lastUpdateBy = #{lastUpdateBy,jdbcType=BIGINT},",
          "lastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "executorId = #{executorId,jdbcType=BIGINT},",
          "approvalProcessId = #{approvalProcessId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContractInfoEntity record);
}