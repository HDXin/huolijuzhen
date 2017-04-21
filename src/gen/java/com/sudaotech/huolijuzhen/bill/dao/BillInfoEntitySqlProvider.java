package com.sudaotech.huolijuzhen.bill.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample.Criterion;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample;
import java.util.List;
import java.util.Map;

public class BillInfoEntitySqlProvider {

    public String countByExample(BillInfoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bill_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BillInfoEntityExample example) {
        BEGIN();
        DELETE_FROM("bill_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BillInfoEntity record) {
        BEGIN();
        INSERT_INTO("bill_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBillNo() != null) {
            VALUES("billNo", "#{billNo,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            VALUES("companyId", "#{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            VALUES("companyName", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContractId() != null) {
            VALUES("contractId", "#{contractId,jdbcType=BIGINT}");
        }
        
        if (record.getContractNo() != null) {
            VALUES("contractNo", "#{contractNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillMonth() != null) {
            VALUES("billMonth", "#{billMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalMoney() != null) {
            VALUES("totalMoney", "#{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTaxMoney() != null) {
            VALUES("totalTaxMoney", "#{totalTaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefMoney() != null) {
            VALUES("reliefMoney", "#{reliefMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefRemark() != null) {
            VALUES("reliefRemark", "#{reliefRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            VALUES("totalAmount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBillStatus() != null) {
            VALUES("billStatus", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitStatus() != null) {
            VALUES("submitStatus", "#{submitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitBy() != null) {
            VALUES("submitBy", "#{submitBy,jdbcType=BIGINT}");
        }
        
        if (record.getSubmitTime() != null) {
            VALUES("submitTime", "#{submitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            VALUES("approvalStatus", "#{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            VALUES("approvalBy", "#{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            VALUES("approvalTime", "#{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushStatus() != null) {
            VALUES("pushStatus", "#{pushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPushBy() != null) {
            VALUES("pushBy", "#{pushBy,jdbcType=BIGINT}");
        }
        
        if (record.getPushTime() != null) {
            VALUES("pushTime", "#{pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmStatus() != null) {
            VALUES("confirmStatus", "#{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmBy() != null) {
            VALUES("confirmBy", "#{confirmBy,jdbcType=BIGINT}");
        }
        
        if (record.getConfirmTime() != null) {
            VALUES("confirmTime", "#{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerificationStatus() != null) {
            VALUES("verificationStatus", "#{verificationStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerificationBy() != null) {
            VALUES("verificationBy", "#{verificationBy,jdbcType=BIGINT}");
        }
        
        if (record.getVerificationTime() != null) {
            VALUES("verificationTime", "#{verificationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUrgePushStatus() != null) {
            VALUES("urgePushStatus", "#{urgePushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeBy() != null) {
            VALUES("urgeBy", "#{urgeBy,jdbcType=BIGINT}");
        }
        
        if (record.getUrgeTime() != null) {
            VALUES("urgeTime", "#{urgeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBank() != null) {
            VALUES("payBank", "#{payBank,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNumber() != null) {
            VALUES("paySerialNumber", "#{paySerialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNextAdjust() != null) {
            VALUES("nextAdjust", "#{nextAdjust,jdbcType=INTEGER}");
        }
        
        if (record.getAdjustAmount() != null) {
            VALUES("adjustAmount", "#{adjustAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdjustRemark() != null) {
            VALUES("adjustRemark", "#{adjustRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            VALUES("createBy", "#{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            VALUES("updateBy", "#{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            VALUES("lastUpdate", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalProcessId() != null) {
            VALUES("approvalProcessId", "#{approvalProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalExecutorId() != null) {
            VALUES("approvalExecutorId", "#{approvalExecutorId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyProcessId() != null) {
            VALUES("verifyProcessId", "#{verifyProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyExecutorId() != null) {
            VALUES("verifyExecutorId", "#{verifyExecutorId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(BillInfoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("billNo");
        SELECT("parkId");
        SELECT("companyId");
        SELECT("companyName");
        SELECT("contractId");
        SELECT("contractNo");
        SELECT("billMonth");
        SELECT("totalMoney");
        SELECT("totalTaxMoney");
        SELECT("reliefMoney");
        SELECT("reliefRemark");
        SELECT("totalAmount");
        SELECT("billStatus");
        SELECT("submitStatus");
        SELECT("submitBy");
        SELECT("submitTime");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("pushStatus");
        SELECT("pushBy");
        SELECT("pushTime");
        SELECT("confirmStatus");
        SELECT("confirmBy");
        SELECT("confirmTime");
        SELECT("verificationStatus");
        SELECT("verificationBy");
        SELECT("verificationTime");
        SELECT("urgePushStatus");
        SELECT("urgeBy");
        SELECT("urgeTime");
        SELECT("payBank");
        SELECT("paySerialNumber");
        SELECT("nextAdjust");
        SELECT("adjustAmount");
        SELECT("adjustRemark");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("approvalProcessId");
        SELECT("approvalExecutorId");
        SELECT("verifyProcessId");
        SELECT("verifyExecutorId");
        FROM("bill_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BillInfoEntity record = (BillInfoEntity) parameter.get("record");
        BillInfoEntityExample example = (BillInfoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bill_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBillNo() != null) {
            SET("billNo = #{record.billNo,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContractId() != null) {
            SET("contractId = #{record.contractId,jdbcType=BIGINT}");
        }
        
        if (record.getContractNo() != null) {
            SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillMonth() != null) {
            SET("billMonth = #{record.billMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTaxMoney() != null) {
            SET("totalTaxMoney = #{record.totalTaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefMoney() != null) {
            SET("reliefMoney = #{record.reliefMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefRemark() != null) {
            SET("reliefRemark = #{record.reliefRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            SET("totalAmount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBillStatus() != null) {
            SET("billStatus = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitStatus() != null) {
            SET("submitStatus = #{record.submitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitBy() != null) {
            SET("submitBy = #{record.submitBy,jdbcType=BIGINT}");
        }
        
        if (record.getSubmitTime() != null) {
            SET("submitTime = #{record.submitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushStatus() != null) {
            SET("pushStatus = #{record.pushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPushBy() != null) {
            SET("pushBy = #{record.pushBy,jdbcType=BIGINT}");
        }
        
        if (record.getPushTime() != null) {
            SET("pushTime = #{record.pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmStatus() != null) {
            SET("confirmStatus = #{record.confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmBy() != null) {
            SET("confirmBy = #{record.confirmBy,jdbcType=BIGINT}");
        }
        
        if (record.getConfirmTime() != null) {
            SET("confirmTime = #{record.confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerificationStatus() != null) {
            SET("verificationStatus = #{record.verificationStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerificationBy() != null) {
            SET("verificationBy = #{record.verificationBy,jdbcType=BIGINT}");
        }
        
        if (record.getVerificationTime() != null) {
            SET("verificationTime = #{record.verificationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUrgePushStatus() != null) {
            SET("urgePushStatus = #{record.urgePushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeBy() != null) {
            SET("urgeBy = #{record.urgeBy,jdbcType=BIGINT}");
        }
        
        if (record.getUrgeTime() != null) {
            SET("urgeTime = #{record.urgeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBank() != null) {
            SET("payBank = #{record.payBank,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNumber() != null) {
            SET("paySerialNumber = #{record.paySerialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNextAdjust() != null) {
            SET("nextAdjust = #{record.nextAdjust,jdbcType=INTEGER}");
        }
        
        if (record.getAdjustAmount() != null) {
            SET("adjustAmount = #{record.adjustAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdjustRemark() != null) {
            SET("adjustRemark = #{record.adjustRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalProcessId() != null) {
            SET("approvalProcessId = #{record.approvalProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalExecutorId() != null) {
            SET("approvalExecutorId = #{record.approvalExecutorId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyProcessId() != null) {
            SET("verifyProcessId = #{record.verifyProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyExecutorId() != null) {
            SET("verifyExecutorId = #{record.verifyExecutorId,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bill_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("billNo = #{record.billNo,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        SET("contractId = #{record.contractId,jdbcType=BIGINT}");
        SET("contractNo = #{record.contractNo,jdbcType=VARCHAR}");
        SET("billMonth = #{record.billMonth,jdbcType=VARCHAR}");
        SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
        SET("totalTaxMoney = #{record.totalTaxMoney,jdbcType=DECIMAL}");
        SET("reliefMoney = #{record.reliefMoney,jdbcType=DECIMAL}");
        SET("reliefRemark = #{record.reliefRemark,jdbcType=VARCHAR}");
        SET("totalAmount = #{record.totalAmount,jdbcType=DECIMAL}");
        SET("billStatus = #{record.billStatus,jdbcType=INTEGER}");
        SET("submitStatus = #{record.submitStatus,jdbcType=INTEGER}");
        SET("submitBy = #{record.submitBy,jdbcType=BIGINT}");
        SET("submitTime = #{record.submitTime,jdbcType=TIMESTAMP}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("pushStatus = #{record.pushStatus,jdbcType=INTEGER}");
        SET("pushBy = #{record.pushBy,jdbcType=BIGINT}");
        SET("pushTime = #{record.pushTime,jdbcType=TIMESTAMP}");
        SET("confirmStatus = #{record.confirmStatus,jdbcType=INTEGER}");
        SET("confirmBy = #{record.confirmBy,jdbcType=BIGINT}");
        SET("confirmTime = #{record.confirmTime,jdbcType=TIMESTAMP}");
        SET("verificationStatus = #{record.verificationStatus,jdbcType=INTEGER}");
        SET("verificationBy = #{record.verificationBy,jdbcType=BIGINT}");
        SET("verificationTime = #{record.verificationTime,jdbcType=TIMESTAMP}");
        SET("urgePushStatus = #{record.urgePushStatus,jdbcType=INTEGER}");
        SET("urgeBy = #{record.urgeBy,jdbcType=BIGINT}");
        SET("urgeTime = #{record.urgeTime,jdbcType=TIMESTAMP}");
        SET("payBank = #{record.payBank,jdbcType=VARCHAR}");
        SET("paySerialNumber = #{record.paySerialNumber,jdbcType=VARCHAR}");
        SET("nextAdjust = #{record.nextAdjust,jdbcType=INTEGER}");
        SET("adjustAmount = #{record.adjustAmount,jdbcType=DECIMAL}");
        SET("adjustRemark = #{record.adjustRemark,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("approvalProcessId = #{record.approvalProcessId,jdbcType=BIGINT}");
        SET("approvalExecutorId = #{record.approvalExecutorId,jdbcType=BIGINT}");
        SET("verifyProcessId = #{record.verifyProcessId,jdbcType=BIGINT}");
        SET("verifyExecutorId = #{record.verifyExecutorId,jdbcType=BIGINT}");
        
        BillInfoEntityExample example = (BillInfoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BillInfoEntity record) {
        BEGIN();
        UPDATE("bill_info");
        
        if (record.getBillNo() != null) {
            SET("billNo = #{billNo,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContractId() != null) {
            SET("contractId = #{contractId,jdbcType=BIGINT}");
        }
        
        if (record.getContractNo() != null) {
            SET("contractNo = #{contractNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillMonth() != null) {
            SET("billMonth = #{billMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalTaxMoney() != null) {
            SET("totalTaxMoney = #{totalTaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefMoney() != null) {
            SET("reliefMoney = #{reliefMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getReliefRemark() != null) {
            SET("reliefRemark = #{reliefRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            SET("totalAmount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBillStatus() != null) {
            SET("billStatus = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitStatus() != null) {
            SET("submitStatus = #{submitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubmitBy() != null) {
            SET("submitBy = #{submitBy,jdbcType=BIGINT}");
        }
        
        if (record.getSubmitTime() != null) {
            SET("submitTime = #{submitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushStatus() != null) {
            SET("pushStatus = #{pushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPushBy() != null) {
            SET("pushBy = #{pushBy,jdbcType=BIGINT}");
        }
        
        if (record.getPushTime() != null) {
            SET("pushTime = #{pushTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmStatus() != null) {
            SET("confirmStatus = #{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmBy() != null) {
            SET("confirmBy = #{confirmBy,jdbcType=BIGINT}");
        }
        
        if (record.getConfirmTime() != null) {
            SET("confirmTime = #{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerificationStatus() != null) {
            SET("verificationStatus = #{verificationStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerificationBy() != null) {
            SET("verificationBy = #{verificationBy,jdbcType=BIGINT}");
        }
        
        if (record.getVerificationTime() != null) {
            SET("verificationTime = #{verificationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUrgePushStatus() != null) {
            SET("urgePushStatus = #{urgePushStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeBy() != null) {
            SET("urgeBy = #{urgeBy,jdbcType=BIGINT}");
        }
        
        if (record.getUrgeTime() != null) {
            SET("urgeTime = #{urgeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBank() != null) {
            SET("payBank = #{payBank,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNumber() != null) {
            SET("paySerialNumber = #{paySerialNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNextAdjust() != null) {
            SET("nextAdjust = #{nextAdjust,jdbcType=INTEGER}");
        }
        
        if (record.getAdjustAmount() != null) {
            SET("adjustAmount = #{adjustAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdjustRemark() != null) {
            SET("adjustRemark = #{adjustRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalProcessId() != null) {
            SET("approvalProcessId = #{approvalProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalExecutorId() != null) {
            SET("approvalExecutorId = #{approvalExecutorId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyProcessId() != null) {
            SET("verifyProcessId = #{verifyProcessId,jdbcType=BIGINT}");
        }
        
        if (record.getVerifyExecutorId() != null) {
            SET("verifyExecutorId = #{verifyExecutorId,jdbcType=BIGINT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(BillInfoEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}