package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.util.Date;

public class EnterpriseCorrBusinessEntity extends BaseEntity {
    private Long id;

    private Long enterpriseCottId;

    private Date cottTime;

    private Long cottUser;

    private Integer cottStatus;

    private Integer number;

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

    public Long getEnterpriseCottId() {
        return enterpriseCottId;
    }

    public void setEnterpriseCottId(Long enterpriseCottId) {
        this.enterpriseCottId = enterpriseCottId;
    }

    public Date getCottTime() {
        return cottTime;
    }

    public void setCottTime(Date cottTime) {
        this.cottTime = cottTime;
    }

    public Long getCottUser() {
        return cottUser;
    }

    public void setCottUser(Long cottUser) {
        this.cottUser = cottUser;
    }

    public Integer getCottStatus() {
        return cottStatus;
    }

    public void setCottStatus(Integer cottStatus) {
        this.cottStatus = cottStatus;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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