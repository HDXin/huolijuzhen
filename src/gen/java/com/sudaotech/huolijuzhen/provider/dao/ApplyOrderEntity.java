package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.enums.PayWay;
import java.math.BigDecimal;
import java.util.Date;

public class ApplyOrderEntity extends BaseEntity {
    private Long id;

    private String applyOrderNo;

    private ApplyOrderType applyOrderType;

    private ApplyOrderStatus applyOrderStatus;

    private Long serviceProId;

    private Long enterpriseId;

    private String enterpriseName;

    private String applyOrderStatusMemo;

    private Long billHistoryId;

    private String orderMemo;

    private String priceTitle;

    private BigDecimal price;

    private Long commentId;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private PayWay payWay;

    private Integer serviceProRelease;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplyOrderNo() {
        return applyOrderNo;
    }

    public void setApplyOrderNo(String applyOrderNo) {
        this.applyOrderNo = applyOrderNo == null ? null : applyOrderNo.trim();
    }

    public ApplyOrderType getApplyOrderType() {
        return applyOrderType;
    }

    public void setApplyOrderType(ApplyOrderType applyOrderType) {
        this.applyOrderType = applyOrderType;
    }

    public ApplyOrderStatus getApplyOrderStatus() {
        return applyOrderStatus;
    }

    public void setApplyOrderStatus(ApplyOrderStatus applyOrderStatus) {
        this.applyOrderStatus = applyOrderStatus;
    }

    public Long getServiceProId() {
        return serviceProId;
    }

    public void setServiceProId(Long serviceProId) {
        this.serviceProId = serviceProId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getApplyOrderStatusMemo() {
        return applyOrderStatusMemo;
    }

    public void setApplyOrderStatusMemo(String applyOrderStatusMemo) {
        this.applyOrderStatusMemo = applyOrderStatusMemo == null ? null : applyOrderStatusMemo.trim();
    }

    public Long getBillHistoryId() {
        return billHistoryId;
    }

    public void setBillHistoryId(Long billHistoryId) {
        this.billHistoryId = billHistoryId;
    }

    public String getOrderMemo() {
        return orderMemo;
    }

    public void setOrderMemo(String orderMemo) {
        this.orderMemo = orderMemo == null ? null : orderMemo.trim();
    }

    public String getPriceTitle() {
        return priceTitle;
    }

    public void setPriceTitle(String priceTitle) {
        this.priceTitle = priceTitle == null ? null : priceTitle.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public PayWay getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWay payWay) {
        this.payWay = payWay;
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