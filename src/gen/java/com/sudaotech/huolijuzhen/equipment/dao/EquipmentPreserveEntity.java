package com.sudaotech.huolijuzhen.equipment.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CycleType;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.util.Date;

public class EquipmentPreserveEntity extends BaseEntity {
    private Long id;

    private String name;

    private Integer preCycle;

    private CycleType cycleType;

    private Long parkId;

    private String code;

    private Long equTypeId;

    private String equTypeName;

    private String preObj;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private EnableStatus enableStatus;

    private Date enableDate;

    private Long enableBy;

    private Date enableTime;

    private Long disableBy;

    private Date disableTime;

    private Boolean isEnablePlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPreCycle() {
        return preCycle;
    }

    public void setPreCycle(Integer preCycle) {
        this.preCycle = preCycle;
    }

    public CycleType getCycleType() {
        return cycleType;
    }

    public void setCycleType(CycleType cycleType) {
        this.cycleType = cycleType;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getEquTypeId() {
        return equTypeId;
    }

    public void setEquTypeId(Long equTypeId) {
        this.equTypeId = equTypeId;
    }

    public String getEquTypeName() {
        return equTypeName;
    }

    public void setEquTypeName(String equTypeName) {
        this.equTypeName = equTypeName == null ? null : equTypeName.trim();
    }

    public String getPreObj() {
        return preObj;
    }

    public void setPreObj(String preObj) {
        this.preObj = preObj == null ? null : preObj.trim();
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

    public EnableStatus getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(EnableStatus enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Date getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Date enableDate) {
        this.enableDate = enableDate;
    }

    public Long getEnableBy() {
        return enableBy;
    }

    public void setEnableBy(Long enableBy) {
        this.enableBy = enableBy;
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public Long getDisableBy() {
        return disableBy;
    }

    public void setDisableBy(Long disableBy) {
        this.disableBy = disableBy;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    public Boolean getIsEnablePlan() {
        return isEnablePlan;
    }

    public void setIsEnablePlan(Boolean isEnablePlan) {
        this.isEnablePlan = isEnablePlan;
    }
}