package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.Date;

public class RollPeriodEntity extends BaseEntity {
    private Long id;

    private Date startDate;

    private Date endDate;

    private Integer rollPeriod;

    private BigDecimal rollRange;

    private Long billCostCalRulesId;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getRollPeriod() {
        return rollPeriod;
    }

    public void setRollPeriod(Integer rollPeriod) {
        this.rollPeriod = rollPeriod;
    }

    public BigDecimal getRollRange() {
        return rollRange;
    }

    public void setRollRange(BigDecimal rollRange) {
        this.rollRange = rollRange;
    }

    public Long getBillCostCalRulesId() {
        return billCostCalRulesId;
    }

    public void setBillCostCalRulesId(Long billCostCalRulesId) {
        this.billCostCalRulesId = billCostCalRulesId;
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
}