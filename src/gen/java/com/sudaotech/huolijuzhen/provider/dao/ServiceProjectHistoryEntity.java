package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import java.math.BigDecimal;
import java.util.Date;

public class ServiceProjectHistoryEntity extends BaseEntity {
    private Long id;

    private String mainTitle;

    private String subTitle;

    private Long serviceTypeId;

    private ServerGrade serverGrade;

    private ServiceGrade serviceGrade;

    private Long serviceGradeId;

    private String serviceGradeName;

    private Long parkId;

    private Boolean supportApply;

    private Long applyViewId;

    private Boolean supportOrder;

    private Long orderViewId;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private ServiceApprovalStatus approvalStatus;

    private Long approvalBy;

    private Date approvalTime;

    private String approvalText;

    private Long parkProId;

    private Long parkCityId;

    private Long parkCounId;

    private Long parkLocationId;

    private Integer applyOrderNum;

    private Integer collectNum;

    private Integer readNum;

    private BigDecimal commentNum;

    private Long serviceProId;

    private Integer serviceProRelease;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public ServerGrade getServerGrade() {
        return serverGrade;
    }

    public void setServerGrade(ServerGrade serverGrade) {
        this.serverGrade = serverGrade;
    }

    public ServiceGrade getServiceGrade() {
        return serviceGrade;
    }

    public void setServiceGrade(ServiceGrade serviceGrade) {
        this.serviceGrade = serviceGrade;
    }

    public Long getServiceGradeId() {
        return serviceGradeId;
    }

    public void setServiceGradeId(Long serviceGradeId) {
        this.serviceGradeId = serviceGradeId;
    }

    public String getServiceGradeName() {
        return serviceGradeName;
    }

    public void setServiceGradeName(String serviceGradeName) {
        this.serviceGradeName = serviceGradeName == null ? null : serviceGradeName.trim();
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Boolean getSupportApply() {
        return supportApply;
    }

    public void setSupportApply(Boolean supportApply) {
        this.supportApply = supportApply;
    }

    public Long getApplyViewId() {
        return applyViewId;
    }

    public void setApplyViewId(Long applyViewId) {
        this.applyViewId = applyViewId;
    }

    public Boolean getSupportOrder() {
        return supportOrder;
    }

    public void setSupportOrder(Boolean supportOrder) {
        this.supportOrder = supportOrder;
    }

    public Long getOrderViewId() {
        return orderViewId;
    }

    public void setOrderViewId(Long orderViewId) {
        this.orderViewId = orderViewId;
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

    public ServiceApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ServiceApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public String getApprovalText() {
        return approvalText;
    }

    public void setApprovalText(String approvalText) {
        this.approvalText = approvalText == null ? null : approvalText.trim();
    }

    public Long getParkProId() {
        return parkProId;
    }

    public void setParkProId(Long parkProId) {
        this.parkProId = parkProId;
    }

    public Long getParkCityId() {
        return parkCityId;
    }

    public void setParkCityId(Long parkCityId) {
        this.parkCityId = parkCityId;
    }

    public Long getParkCounId() {
        return parkCounId;
    }

    public void setParkCounId(Long parkCounId) {
        this.parkCounId = parkCounId;
    }

    public Long getParkLocationId() {
        return parkLocationId;
    }

    public void setParkLocationId(Long parkLocationId) {
        this.parkLocationId = parkLocationId;
    }

    public Integer getApplyOrderNum() {
        return applyOrderNum;
    }

    public void setApplyOrderNum(Integer applyOrderNum) {
        this.applyOrderNum = applyOrderNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public BigDecimal getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(BigDecimal commentNum) {
        this.commentNum = commentNum;
    }

    public Long getServiceProId() {
        return serviceProId;
    }

    public void setServiceProId(Long serviceProId) {
        this.serviceProId = serviceProId;
    }

    public Integer getServiceProRelease() {
        return serviceProRelease;
    }

    public void setServiceProRelease(Integer serviceProRelease) {
        this.serviceProRelease = serviceProRelease;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}