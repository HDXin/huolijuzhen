package com.sudaotech.huolijuzhen.bill.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BillInfo;

public interface BillInfoMapper extends BillInfoEntityMapper {
	
    @SelectProvider(type=BillInfoSqlProvider.class, method="countByObj")
    int countByObj(BillInfo bi);


    @SelectProvider(type=BillInfoSqlProvider.class, method="selectByPage")
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
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillInfoEntity> selectByPage(BillInfo bi, RowBounds rowBounds);
    
    @SelectProvider(type=BillInfoSqlProvider.class,method="statisticsByCostPro")
    List<Map<String, Object>> statisticsByCostPro(Map<String, Object> params);

    //累计欠款（待支付确认）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitPayBillTotalAmount")
    BigDecimal waitPayBillTotalAmount(Map<String, Object> params);
    
    //累计欠款（待核销总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitVerificationBillTotalAmount")
    BigDecimal waitVerificationBillTotalAmount(Map<String, Object> params);
 
    //累计欠款（待核销已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitVerificationBillAlreadyCollection")
    BigDecimal waitVerificationBillAlreadyCollection(Map<String, Object> params);
    
    //累计欠款（已挂起总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="alreadySuspendBillAlreadyCollection")
    BigDecimal alreadySuspendBillAlreadyCollection(Map<String, Object> params);
 
    //累计欠款（已挂起已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="alreadySuspendBillTotalAmount")
    BigDecimal alreadySuspendBillTotalAmount(Map<String, Object> params);
   
    //欠款本期还款
    @SelectProvider(type=BillInfoSqlProvider.class,method="alreadyDebtBillCurrentRepayment")
    BigDecimal alreadyDebtBillCurrentRepayment(Map<String, Object> params);
  
    //本期应收总额（本期账单总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentAllBillTotalAmount")
    BigDecimal currentAllBillTotalAmount(Map<String, Object> params);
   
    //本期应收总额（本期账单已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentAllBillAlreadyCollection")
    BigDecimal currentAllBillAlreadyCollection(Map<String, Object> params);
  
    //本期已核销总额
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentAllBillAlreadyVerification")
    BigDecimal currentAllBillAlreadyVerification(Map<String, Object> params);
  
    //本期已挂起账单总额（本期已挂起账单总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentSuspendBillTotalAmount")
    BigDecimal currentSuspendBillTotalAmount(Map<String, Object> params);
  
    //本期已挂起账单总额（本期已挂起账单已收款总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentSuspendBillAlreadyCollection")
    BigDecimal currentSuspendBillAlreadyCollection(Map<String, Object> params);
  
    //本期待核销账单总额（本期待核销账单总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentWaitVerificationBillTotalAmount")
    BigDecimal currentWaitVerificationBillTotalAmount(Map<String, Object> params);
  
    //本期待核销账单总额（本期待核销账单已收款总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentWaitVerificationBillAlreadyCollection")
    BigDecimal currentWaitVerificationBillAlreadyCollection(Map<String, Object> params);

    //已完结部分的核销金额
    @SelectProvider(type=BillInfoSqlProvider.class,method="findAlreadyFinished")
	BigDecimal findAlreadyFinished(Map<String, Object> params);

	//已挂起部分的核销金额
    @SelectProvider(type=BillInfoSqlProvider.class,method="findAlreadySuspen")
	BigDecimal findAlreadySuspen(Map<String, Object> params);

    //当前年应收总额（本期账单总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentAllBillTotalAmountYear")
    BigDecimal currentAllBillTotalAmountYear(Map<String, Object> params);

    //当前年应收总额（本期账单已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="currentAllBillAlreadyCollectionYear")
    BigDecimal currentAllBillAlreadyCollectionYear(Map<String, Object> params);

    //当前年累计欠款（待支付确认）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitPayBillTotalAmountYear")
    BigDecimal waitPayBillTotalAmountYear(Map<String, Object> params);
    
    //当前年累计欠款（待核销总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitVerificationBillTotalAmountYear")
    BigDecimal waitVerificationBillTotalAmountYear(Map<String, Object> params);
 
    //当前年累计欠款（待核销已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="waitVerificationBillAlreadyCollectionYear")
    BigDecimal waitVerificationBillAlreadyCollectionYear(Map<String, Object> params);
    
    //当前年累计欠款（已挂起总额）
    @SelectProvider(type=BillInfoSqlProvider.class,method="alreadySuspendBillAlreadyCollectionYear")
    BigDecimal alreadySuspendBillAlreadyCollectionYear(Map<String, Object> params);
 
    //当前年累计欠款（已挂起已收款）
    @SelectProvider(type=BillInfoSqlProvider.class,method="alreadySuspendBillTotalAmountYear")
    BigDecimal alreadySuspendBillTotalAmountYear(Map<String, Object> params);

  
}