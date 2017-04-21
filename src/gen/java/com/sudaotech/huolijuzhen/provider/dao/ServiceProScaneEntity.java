package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.util.Date;

public class ServiceProScaneEntity extends BaseEntity {
    private Long id;

    private Long serviceProId;

    private Long serviceScaneId;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private Integer serviceProRelease;

    private Integer isPast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceProId() {
        return serviceProId;
    }

    public void setServiceProId(Long serviceProId) {
        this.serviceProId = serviceProId;
    }

    public Long getServiceScaneId() {
        return serviceScaneId;
    }

    public void setServiceScaneId(Long serviceScaneId) {
        this.serviceScaneId = serviceScaneId;
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

    public Integer getServiceProRelease() {
        return serviceProRelease;
    }

    public void setServiceProRelease(Integer serviceProRelease) {
        this.serviceProRelease = serviceProRelease;
    }

    public Integer getIsPast() {
        return isPast;
    }

    public void setIsPast(Integer isPast) {
        this.isPast = isPast;
    }
}