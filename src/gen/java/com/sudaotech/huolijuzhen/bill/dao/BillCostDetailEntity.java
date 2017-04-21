package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.Date;

public class BillCostDetailEntity extends BaseEntity {
    private Long id;

    private Long billId;

    private Long bccrId;

    private BigDecimal dosage;

    private BigDecimal unitPrise;

    private String costProName;

    private BigDecimal cost;

    private BigDecimal taxRate;

    private BigDecimal taxMoney;

    private BigDecimal totalMoney;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private BigDecimal verifyMoney;

    private Integer isTask;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getBccrId() {
        return bccrId;
    }

    public void setBccrId(Long bccrId) {
        this.bccrId = bccrId;
    }

    public BigDecimal getDosage() {
        return dosage;
    }

    public void setDosage(BigDecimal dosage) {
        this.dosage = dosage;
    }

    public BigDecimal getUnitPrise() {
        return unitPrise;
    }

    public void setUnitPrise(BigDecimal unitPrise) {
        this.unitPrise = unitPrise;
    }

    public String getCostProName() {
        return costProName;
    }

    public void setCostProName(String costProName) {
        this.costProName = costProName == null ? null : costProName.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(BigDecimal taxMoney) {
        this.taxMoney = taxMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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

    public BigDecimal getVerifyMoney() {
        return verifyMoney;
    }

    public void setVerifyMoney(BigDecimal verifyMoney) {
        this.verifyMoney = verifyMoney;
    }

    public Integer getIsTask() {
        return isTask;
    }

    public void setIsTask(Integer isTask) {
        this.isTask = isTask;
    }
}