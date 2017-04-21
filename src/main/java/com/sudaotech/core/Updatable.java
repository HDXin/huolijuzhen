package com.sudaotech.core;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.serialize.DateSerializer;

public abstract class Updatable {
    
    @JsonIgnore
    private Long operator;
    
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnore
    private Integer displayOrder;

//    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL, using=EnumTypeSerializer.class)
    @JsonIgnore
    private Status status;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnore
    private Long createBy;

    @JsonSerialize(using=DateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnore
    private Date createTime;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnore
    private Long updateBy;

    @JsonSerialize(using=DateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    private Integer version;

    @JsonIgnore
    private Date lastUpdate;

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }
}