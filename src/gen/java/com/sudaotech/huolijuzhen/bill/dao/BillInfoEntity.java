package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import java.math.BigDecimal;
import java.util.Date;

public class BillInfoEntity extends BaseEntity {
    private Long id;

    private String billNo;

    private Long parkId;

    private Long companyId;

    private String companyName;

    private Long contractId;

    private String contractNo;

    private String billMonth;

    private BigDecimal totalMoney;

    private BigDecimal totalTaxMoney;

    private BigDecimal reliefMoney;

    private String reliefRemark;

    private BigDecimal totalAmount;

    private BillStatus billStatus;

    private BillSubmitStatus submitStatus;

    private Long submitBy;

    private Date submitTime;

    private BillApprovalStatus approvalStatus;

    private Long approvalBy;

    private Date approvalTime;

    private BillPushStatus pushStatus;

    private Long pushBy;

    private Date pushTime;

    private BillConfirmStatus confirmStatus;

    private Long confirmBy;

    private Date confirmTime;

    private BillVerificationStatus verificationStatus;

    private Long verificationBy;

    private Date verificationTime;

    private BillUrgePushStatus urgePushStatus;

    private Long urgeBy;

    private Date urgeTime;

    private String payBank;

    private String paySerialNumber;

    private Integer nextAdjust;

    private BigDecimal adjustAmount;

    private String adjustRemark;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private Long approvalProcessId;

    private Long approvalExecutorId;

    private Long verifyProcessId;

    private Long verifyExecutorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth == null ? null : billMonth.trim();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalTaxMoney() {
        return totalTaxMoney;
    }

    public void setTotalTaxMoney(BigDecimal totalTaxMoney) {
        this.totalTaxMoney = totalTaxMoney;
    }

    public BigDecimal getReliefMoney() {
        return reliefMoney;
    }

    public void setReliefMoney(BigDecimal reliefMoney) {
        this.reliefMoney = reliefMoney;
    }

    public String getReliefRemark() {
        return reliefRemark;
    }

    public void setReliefRemark(String reliefRemark) {
        this.reliefRemark = reliefRemark == null ? null : reliefRemark.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public BillSubmitStatus getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(BillSubmitStatus submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Long getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(Long submitBy) {
        this.submitBy = submitBy;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public BillApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(BillApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Long getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(Long approvalBy) {
        this.approvalBy = approvalBy;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public BillPushStatus getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(BillPushStatus pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Long getPushBy() {
        return pushBy;
    }

    public void setPushBy(Long pushBy) {
        this.pushBy = pushBy;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public BillConfirmStatus getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(BillConfirmStatus confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Long getConfirmBy() {
        return confirmBy;
    }

    public void setConfirmBy(Long confirmBy) {
        this.confirmBy = confirmBy;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public BillVerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(BillVerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Long getVerificationBy() {
        return verificationBy;
    }

    public void setVerificationBy(Long verificationBy) {
        this.verificationBy = verificationBy;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public BillUrgePushStatus getUrgePushStatus() {
        return urgePushStatus;
    }

    public void setUrgePushStatus(BillUrgePushStatus urgePushStatus) {
        this.urgePushStatus = urgePushStatus;
    }

    public Long getUrgeBy() {
        return urgeBy;
    }

    public void setUrgeBy(Long urgeBy) {
        this.urgeBy = urgeBy;
    }

    public Date getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(Date urgeTime) {
        this.urgeTime = urgeTime;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank == null ? null : payBank.trim();
    }

    public String getPaySerialNumber() {
        return paySerialNumber;
    }

    public void setPaySerialNumber(String paySerialNumber) {
        this.paySerialNumber = paySerialNumber == null ? null : paySerialNumber.trim();
    }

    public Integer getNextAdjust() {
        return nextAdjust;
    }

    public void setNextAdjust(Integer nextAdjust) {
        this.nextAdjust = nextAdjust;
    }

    public BigDecimal getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(BigDecimal adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public String getAdjustRemark() {
        return adjustRemark;
    }

    public void setAdjustRemark(String adjustRemark) {
        this.adjustRemark = adjustRemark == null ? null : adjustRemark.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getApprovalProcessId() {
        return approvalProcessId;
    }

    public void setApprovalProcessId(Long approvalProcessId) {
        this.approvalProcessId = approvalProcessId;
    }

    public Long getApprovalExecutorId() {
        return approvalExecutorId;
    }

    public void setApprovalExecutorId(Long approvalExecutorId) {
        this.approvalExecutorId = approvalExecutorId;
    }

    public Long getVerifyProcessId() {
        return verifyProcessId;
    }

    public void setVerifyProcessId(Long verifyProcessId) {
        this.verifyProcessId = verifyProcessId;
    }

    public Long getVerifyExecutorId() {
        return verifyExecutorId;
    }

    public void setVerifyExecutorId(Long verifyExecutorId) {
        this.verifyExecutorId = verifyExecutorId;
    }
}