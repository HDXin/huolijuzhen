package com.sudaotech.huolijuzhen.transaction.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.PayChannels;
import com.sudaotech.huolijuzhen.enums.SuccessOrFailEnums;
import com.sudaotech.huolijuzhen.enums.TransDirectionType;
import com.sudaotech.huolijuzhen.enums.TransactionType;
import com.sudaotech.huolijuzhen.enums.TransferSourceType;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionRecordEntity extends BaseEntity {
    private Long id;

    private Long userId;

    private BigDecimal transactionAmount;

    private Date transactionTime;

    private TransDirectionType transactionDirection;

    private TransactionType transactionType;

    private SuccessOrFailEnums transactionStatus;

    private PayChannels payChannel;

    private TransferSourceType transferFromType;

    private Long transferFromId;

    private TransferSourceType transferToType;

    private Long transferToId;

    private Integer bizType;

    private String bizId;

    private String orderNo;

    private String explanation;

    private String tradeNo;

    private String buyerEmail;

    private String buyerId;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private String createName;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public TransDirectionType getTransactionDirection() {
        return transactionDirection;
    }

    public void setTransactionDirection(TransDirectionType transactionDirection) {
        this.transactionDirection = transactionDirection;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public SuccessOrFailEnums getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(SuccessOrFailEnums transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public PayChannels getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(PayChannels payChannel) {
        this.payChannel = payChannel;
    }

    public TransferSourceType getTransferFromType() {
        return transferFromType;
    }

    public void setTransferFromType(TransferSourceType transferFromType) {
        this.transferFromType = transferFromType;
    }

    public Long getTransferFromId() {
        return transferFromId;
    }

    public void setTransferFromId(Long transferFromId) {
        this.transferFromId = transferFromId;
    }

    public TransferSourceType getTransferToType() {
        return transferToType;
    }

    public void setTransferToType(TransferSourceType transferToType) {
        this.transferToType = transferToType;
    }

    public Long getTransferToId() {
        return transferToId;
    }

    public void setTransferToId(Long transferToId) {
        this.transferToId = transferToId;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail == null ? null : buyerEmail.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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