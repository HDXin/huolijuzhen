package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.Date;

public class BillCcrAdjEntity extends BaseEntity {
    private Long id;

    private Long bccrId;

    private BigDecimal adjAmount;

    private String adjMonth;

    private String adjRemark;

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

    public Long getBccrId() {
        return bccrId;
    }

    public void setBccrId(Long bccrId) {
        this.bccrId = bccrId;
    }

    public BigDecimal getAdjAmount() {
        return adjAmount;
    }

    public void setAdjAmount(BigDecimal adjAmount) {
        this.adjAmount = adjAmount;
    }

    public String getAdjMonth() {
        return adjMonth;
    }

    public void setAdjMonth(String adjMonth) {
        this.adjMonth = adjMonth == null ? null : adjMonth.trim();
    }

    public String getAdjRemark() {
        return adjRemark;
    }

    public void setAdjRemark(String adjRemark) {
        this.adjRemark = adjRemark == null ? null : adjRemark.trim();
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