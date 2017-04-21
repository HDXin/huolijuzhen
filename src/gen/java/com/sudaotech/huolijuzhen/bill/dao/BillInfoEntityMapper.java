package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample;
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

public interface BillInfoEntityMapper {
    @SelectProvider(type=BillInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(BillInfoEntityExample example);

    @DeleteProvider(type=BillInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillInfoEntityExample example);

    @Delete({
        "delete from bill_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_info (id, billNo, ",
        "parkId, companyId, ",
        "companyName, contractId, ",
        "contractNo, billMonth, ",
        "totalMoney, totalTaxMoney, ",
        "reliefMoney, reliefRemark, ",
        "totalAmount, billStatus, ",
        "submitStatus, submitBy, ",
        "submitTime, approvalStatus, ",
        "approvalBy, approvalTime, ",
        "pushStatus, pushBy, ",
        "pushTime, confirmStatus, ",
        "confirmBy, confirmTime, ",
        "verificationStatus, verificationBy, ",
        "verificationTime, urgePushStatus, ",
        "urgeBy, urgeTime, ",
        "payBank, paySerialNumber, ",
        "nextAdjust, adjustAmount, ",
        "adjustRemark, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "approvalProcessId, approvalExecutorId, ",
        "verifyProcessId, verifyExecutorId)",
        "values (#{id,jdbcType=BIGINT}, #{billNo,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=BIGINT}, #{companyId,jdbcType=BIGINT}, ",
        "#{companyName,jdbcType=VARCHAR}, #{contractId,jdbcType=BIGINT}, ",
        "#{contractNo,jdbcType=VARCHAR}, #{billMonth,jdbcType=VARCHAR}, ",
        "#{totalMoney,jdbcType=DECIMAL}, #{totalTaxMoney,jdbcType=DECIMAL}, ",
        "#{reliefMoney,jdbcType=DECIMAL}, #{reliefRemark,jdbcType=VARCHAR}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{billStatus,jdbcType=INTEGER}, ",
        "#{submitStatus,jdbcType=INTEGER}, #{submitBy,jdbcType=BIGINT}, ",
        "#{submitTime,jdbcType=TIMESTAMP}, #{approvalStatus,jdbcType=INTEGER}, ",
        "#{approvalBy,jdbcType=BIGINT}, #{approvalTime,jdbcType=TIMESTAMP}, ",
        "#{pushStatus,jdbcType=INTEGER}, #{pushBy,jdbcType=BIGINT}, ",
        "#{pushTime,jdbcType=TIMESTAMP}, #{confirmStatus,jdbcType=INTEGER}, ",
        "#{confirmBy,jdbcType=BIGINT}, #{confirmTime,jdbcType=TIMESTAMP}, ",
        "#{verificationStatus,jdbcType=INTEGER}, #{verificationBy,jdbcType=BIGINT}, ",
        "#{verificationTime,jdbcType=TIMESTAMP}, #{urgePushStatus,jdbcType=INTEGER}, ",
        "#{urgeBy,jdbcType=BIGINT}, #{urgeTime,jdbcType=TIMESTAMP}, ",
        "#{payBank,jdbcType=VARCHAR}, #{paySerialNumber,jdbcType=VARCHAR}, ",
        "#{nextAdjust,jdbcType=INTEGER}, #{adjustAmount,jdbcType=DECIMAL}, ",
        "#{adjustRemark,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{approvalProcessId,jdbcType=BIGINT}, #{approvalExecutorId,jdbcType=BIGINT}, ",
        "#{verifyProcessId,jdbcType=BIGINT}, #{verifyExecutorId,jdbcType=BIGINT})"
    })
    int insert(BillInfoEntity record);

    @InsertProvider(type=BillInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillInfoEntity record);

    @SelectProvider(type=BillInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billNo", property="billNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalTaxMoney", property="totalTaxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefMoney", property="reliefMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefRemark", property="reliefRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalAmount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="billStatus", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitStatus", property="submitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitBy", property="submitBy", jdbcType=JdbcType.BIGINT),
        @Result(column="submitTime", property="submitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pushStatus", property="pushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pushBy", property="pushBy", jdbcType=JdbcType.BIGINT),
        @Result(column="pushTime", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirmStatus", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="confirmBy", property="confirmBy", jdbcType=JdbcType.BIGINT),
        @Result(column="confirmTime", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verificationStatus", property="verificationStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="verificationBy", property="verificationBy", jdbcType=JdbcType.BIGINT),
        @Result(column="verificationTime", property="verificationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="urgePushStatus", property="urgePushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeBy", property="urgeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="urgeTime", property="urgeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payBank", property="payBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNumber", property="paySerialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="nextAdjust", property="nextAdjust", jdbcType=JdbcType.INTEGER),
        @Result(column="adjustAmount", property="adjustAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjustRemark", property="adjustRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalExecutorId", property="approvalExecutorId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyProcessId", property="verifyProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyExecutorId", property="verifyExecutorId", jdbcType=JdbcType.BIGINT)
    })
    List<BillInfoEntity> selectByExampleWithRowbounds(BillInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billNo", property="billNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalTaxMoney", property="totalTaxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefMoney", property="reliefMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefRemark", property="reliefRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalAmount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="billStatus", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitStatus", property="submitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitBy", property="submitBy", jdbcType=JdbcType.BIGINT),
        @Result(column="submitTime", property="submitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pushStatus", property="pushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pushBy", property="pushBy", jdbcType=JdbcType.BIGINT),
        @Result(column="pushTime", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirmStatus", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="confirmBy", property="confirmBy", jdbcType=JdbcType.BIGINT),
        @Result(column="confirmTime", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verificationStatus", property="verificationStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="verificationBy", property="verificationBy", jdbcType=JdbcType.BIGINT),
        @Result(column="verificationTime", property="verificationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="urgePushStatus", property="urgePushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeBy", property="urgeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="urgeTime", property="urgeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payBank", property="payBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNumber", property="paySerialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="nextAdjust", property="nextAdjust", jdbcType=JdbcType.INTEGER),
        @Result(column="adjustAmount", property="adjustAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjustRemark", property="adjustRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalExecutorId", property="approvalExecutorId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyProcessId", property="verifyProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyExecutorId", property="verifyExecutorId", jdbcType=JdbcType.BIGINT)
    })
    List<BillInfoEntity> selectByExample(BillInfoEntityExample example);

    @Select({
        "select",
        "id, billNo, parkId, companyId, companyName, contractId, contractNo, billMonth, ",
        "totalMoney, totalTaxMoney, reliefMoney, reliefRemark, totalAmount, billStatus, ",
        "submitStatus, submitBy, submitTime, approvalStatus, approvalBy, approvalTime, ",
        "pushStatus, pushBy, pushTime, confirmStatus, confirmBy, confirmTime, verificationStatus, ",
        "verificationBy, verificationTime, urgePushStatus, urgeBy, urgeTime, payBank, ",
        "paySerialNumber, nextAdjust, adjustAmount, adjustRemark, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, approvalProcessId, approvalExecutorId, ",
        "verifyProcessId, verifyExecutorId",
        "from bill_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billNo", property="billNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalTaxMoney", property="totalTaxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefMoney", property="reliefMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="reliefRemark", property="reliefRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="totalAmount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="billStatus", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitStatus", property="submitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="submitBy", property="submitBy", jdbcType=JdbcType.BIGINT),
        @Result(column="submitTime", property="submitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pushStatus", property="pushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pushBy", property="pushBy", jdbcType=JdbcType.BIGINT),
        @Result(column="pushTime", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirmStatus", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="confirmBy", property="confirmBy", jdbcType=JdbcType.BIGINT),
        @Result(column="confirmTime", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verificationStatus", property="verificationStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="verificationBy", property="verificationBy", jdbcType=JdbcType.BIGINT),
        @Result(column="verificationTime", property="verificationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="urgePushStatus", property="urgePushStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeBy", property="urgeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="urgeTime", property="urgeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payBank", property="payBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNumber", property="paySerialNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="nextAdjust", property="nextAdjust", jdbcType=JdbcType.INTEGER),
        @Result(column="adjustAmount", property="adjustAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjustRemark", property="adjustRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalProcessId", property="approvalProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalExecutorId", property="approvalExecutorId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyProcessId", property="verifyProcessId", jdbcType=JdbcType.BIGINT),
        @Result(column="verifyExecutorId", property="verifyExecutorId", jdbcType=JdbcType.BIGINT)
    })
    BillInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillInfoEntity record, @Param("example") BillInfoEntityExample example);

    @UpdateProvider(type=BillInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillInfoEntity record, @Param("example") BillInfoEntityExample example);

    @UpdateProvider(type=BillInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillInfoEntity record);

    @Update({
        "update bill_info",
        "set billNo = #{billNo,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "companyId = #{companyId,jdbcType=BIGINT},",
          "companyName = #{companyName,jdbcType=VARCHAR},",
          "contractId = #{contractId,jdbcType=BIGINT},",
          "contractNo = #{contractNo,jdbcType=VARCHAR},",
          "billMonth = #{billMonth,jdbcType=VARCHAR},",
          "totalMoney = #{totalMoney,jdbcType=DECIMAL},",
          "totalTaxMoney = #{totalTaxMoney,jdbcType=DECIMAL},",
          "reliefMoney = #{reliefMoney,jdbcType=DECIMAL},",
          "reliefRemark = #{reliefRemark,jdbcType=VARCHAR},",
          "totalAmount = #{totalAmount,jdbcType=DECIMAL},",
          "billStatus = #{billStatus,jdbcType=INTEGER},",
          "submitStatus = #{submitStatus,jdbcType=INTEGER},",
          "submitBy = #{submitBy,jdbcType=BIGINT},",
          "submitTime = #{submitTime,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "pushStatus = #{pushStatus,jdbcType=INTEGER},",
          "pushBy = #{pushBy,jdbcType=BIGINT},",
          "pushTime = #{pushTime,jdbcType=TIMESTAMP},",
          "confirmStatus = #{confirmStatus,jdbcType=INTEGER},",
          "confirmBy = #{confirmBy,jdbcType=BIGINT},",
          "confirmTime = #{confirmTime,jdbcType=TIMESTAMP},",
          "verificationStatus = #{verificationStatus,jdbcType=INTEGER},",
          "verificationBy = #{verificationBy,jdbcType=BIGINT},",
          "verificationTime = #{verificationTime,jdbcType=TIMESTAMP},",
          "urgePushStatus = #{urgePushStatus,jdbcType=INTEGER},",
          "urgeBy = #{urgeBy,jdbcType=BIGINT},",
          "urgeTime = #{urgeTime,jdbcType=TIMESTAMP},",
          "payBank = #{payBank,jdbcType=VARCHAR},",
          "paySerialNumber = #{paySerialNumber,jdbcType=VARCHAR},",
          "nextAdjust = #{nextAdjust,jdbcType=INTEGER},",
          "adjustAmount = #{adjustAmount,jdbcType=DECIMAL},",
          "adjustRemark = #{adjustRemark,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalProcessId = #{approvalProcessId,jdbcType=BIGINT},",
          "approvalExecutorId = #{approvalExecutorId,jdbcType=BIGINT},",
          "verifyProcessId = #{verifyProcessId,jdbcType=BIGINT},",
          "verifyExecutorId = #{verifyExecutorId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillInfoEntity record);
}