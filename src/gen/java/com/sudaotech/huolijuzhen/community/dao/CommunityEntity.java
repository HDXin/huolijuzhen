package com.sudaotech.huolijuzhen.community.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import java.util.Date;

public class CommunityEntity extends BaseEntity {
    private Long id;

    private String title;

    private String discrible;

    private Date time;

    private PublicGrade publicGrade;

    private Long parkId;

    private String proId;

    private String cityId;

    private String counId;

    private Long locationId;

    private ApprovalStatus approvalStatus;

    private Integer version;

    private Status status;

    private Long approvalBy;

    private Date approvalTime;

    private String approvalMemo;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private Long deleteBy;

    private Date deleteTime;

    private CreateSide createSide;

    private Long createSideId;

    private Long terminateBy;

    private Date terminateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible == null ? null : discrible.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PublicGrade getPublicGrade() {
        return publicGrade;
    }

    public void setPublicGrade(PublicGrade publicGrade) {
        this.publicGrade = publicGrade;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCounId() {
        return counId;
    }

    public void setCounId(String counId) {
        this.counId = counId == null ? null : counId.trim();
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public Long getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(Long approvalBy) {
        this.approvalBy = approvalBy;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovalMemo() {
        return approvalMemo;
    }

    public void setApprovalMemo(String approvalMemo) {
        this.approvalMemo = approvalMemo == null ? null : approvalMemo.trim();
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

    public CreateSide getCreateSide() {
        return createSide;
    }

    public void setCreateSide(CreateSide createSide) {
        this.createSide = createSide;
    }

    public Long getCreateSideId() {
        return createSideId;
    }

    public void setCreateSideId(Long createSideId) {
        this.createSideId = createSideId;
    }

    public Long getTerminateBy() {
        return terminateBy;
    }

    public void setTerminateBy(Long terminateBy) {
        this.terminateBy = terminateBy;
    }

    public Date getTerminateTime() {
        return terminateTime;
    }

    public void setTerminateTime(Date terminateTime) {
        this.terminateTime = terminateTime;
    }
}