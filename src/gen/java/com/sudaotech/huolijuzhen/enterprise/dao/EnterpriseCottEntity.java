package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import java.util.Date;

public class EnterpriseCottEntity extends BaseEntity {
    private Long id;

    private CorrStatus corrStatus;

    private CorrType corrType;

    private Date corrTime;

    private Long parkId;

    private Long enterpriseId;

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

    public CorrStatus getCorrStatus() {
        return corrStatus;
    }

    public void setCorrStatus(CorrStatus corrStatus) {
        this.corrStatus = corrStatus;
    }

    public CorrType getCorrType() {
        return corrType;
    }

    public void setCorrType(CorrType corrType) {
        this.corrType = corrType;
    }

    public Date getCorrTime() {
        return corrTime;
    }

    public void setCorrTime(Date corrTime) {
        this.corrTime = corrTime;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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