package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import java.util.Date;

public class ApprovalRecordEntity extends BaseEntity {
    private Long id;

    private ApprovalType approvalType;

    private Long mainId;

    private Long approvalItemId;

    private String approvalItemName;

    private Integer approvalItemNo;

    private Integer approvalItemVersion;

    private Long approvalId;

    private String approvalName;

    private Boolean passStatus;

    private String approvalMemo;

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

    public ApprovalType getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(ApprovalType approvalType) {
        this.approvalType = approvalType;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    public Long getApprovalItemId() {
        return approvalItemId;
    }

    public void setApprovalItemId(Long approvalItemId) {
        this.approvalItemId = approvalItemId;
    }

    public String getApprovalItemName() {
        return approvalItemName;
    }

    public void setApprovalItemName(String approvalItemName) {
        this.approvalItemName = approvalItemName == null ? null : approvalItemName.trim();
    }

    public Integer getApprovalItemNo() {
        return approvalItemNo;
    }

    public void setApprovalItemNo(Integer approvalItemNo) {
        this.approvalItemNo = approvalItemNo;
    }

    public Integer getApprovalItemVersion() {
        return approvalItemVersion;
    }

    public void setApprovalItemVersion(Integer approvalItemVersion) {
        this.approvalItemVersion = approvalItemVersion;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName == null ? null : approvalName.trim();
    }

    public Boolean getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Boolean passStatus) {
        this.passStatus = passStatus;
    }

    public String getApprovalMemo() {
        return approvalMemo;
    }

    public void setApprovalMemo(String approvalMemo) {
        this.approvalMemo = approvalMemo == null ? null : approvalMemo.trim();
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