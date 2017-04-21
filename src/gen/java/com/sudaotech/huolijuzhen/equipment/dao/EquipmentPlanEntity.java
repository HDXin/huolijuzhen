package com.sudaotech.huolijuzhen.equipment.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import java.util.Date;

public class EquipmentPlanEntity extends BaseEntity {
    private Long id;

    private Long equId;

    private String equCode;

    private String equName;

    private Long equTypeId;

    private Date upkeepTime;

    private String equTypeName;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private PlanStatus planStatus;

    private Long assignerId;

    private Date assignerTime;

    private Date planExecutorDate;

    private Long deleteBy;

    private Date deleteTime;

    private String deleteMemo;

    private EnableStatus enableStatus;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getEquCode() {
        return equCode;
    }

    public void setEquCode(String equCode) {
        this.equCode = equCode == null ? null : equCode.trim();
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName == null ? null : equName.trim();
    }

    public Long getEquTypeId() {
        return equTypeId;
    }

    public void setEquTypeId(Long equTypeId) {
        this.equTypeId = equTypeId;
    }

    public Date getUpkeepTime() {
        return upkeepTime;
    }

    public void setUpkeepTime(Date upkeepTime) {
        this.upkeepTime = upkeepTime;
    }

    public String getEquTypeName() {
        return equTypeName;
    }

    public void setEquTypeName(String equTypeName) {
        this.equTypeName = equTypeName == null ? null : equTypeName.trim();
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

    public PlanStatus getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(PlanStatus planStatus) {
        this.planStatus = planStatus;
    }

    public Long getAssignerId() {
        return assignerId;
    }

    public void setAssignerId(Long assignerId) {
        this.assignerId = assignerId;
    }

    public Date getAssignerTime() {
        return assignerTime;
    }

    public void setAssignerTime(Date assignerTime) {
        this.assignerTime = assignerTime;
    }

    public Date getPlanExecutorDate() {
        return planExecutorDate;
    }

    public void setPlanExecutorDate(Date planExecutorDate) {
        this.planExecutorDate = planExecutorDate;
    }

    public Long getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(Long deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteMemo() {
        return deleteMemo;
    }

    public void setDeleteMemo(String deleteMemo) {
        this.deleteMemo = deleteMemo == null ? null : deleteMemo.trim();
    }

    public EnableStatus getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(EnableStatus enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}