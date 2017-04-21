package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import java.util.Date;

public class OrderTemplateEntity extends BaseEntity {
    private Long id;

    private Long serviceProId;

    private Boolean supportAliPay;

    private Boolean supportWeChatPay;

    private String priceTitleOne;

    private String priceTitleTwo;

    private String priceTitleThree;

    private String discountTitleOne;

    private String discountTitleTwo;

    private String discountTitleThree;

    private Double discountThree;

    private Double discountOne;

    private Double priceThree;

    private Double priceOne;

    private Double priceTwo;

    private Double discountTwo;

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

    public Long getServiceProId() {
        return serviceProId;
    }

    public void setServiceProId(Long serviceProId) {
        this.serviceProId = serviceProId;
    }

    public Boolean getSupportAliPay() {
        return supportAliPay;
    }

    public void setSupportAliPay(Boolean supportAliPay) {
        this.supportAliPay = supportAliPay;
    }

    public Boolean getSupportWeChatPay() {
        return supportWeChatPay;
    }

    public void setSupportWeChatPay(Boolean supportWeChatPay) {
        this.supportWeChatPay = supportWeChatPay;
    }

    public String getPriceTitleOne() {
        return priceTitleOne;
    }

    public void setPriceTitleOne(String priceTitleOne) {
        this.priceTitleOne = priceTitleOne == null ? null : priceTitleOne.trim();
    }

    public String getPriceTitleTwo() {
        return priceTitleTwo;
    }

    public void setPriceTitleTwo(String priceTitleTwo) {
        this.priceTitleTwo = priceTitleTwo == null ? null : priceTitleTwo.trim();
    }

    public String getPriceTitleThree() {
        return priceTitleThree;
    }

    public void setPriceTitleThree(String priceTitleThree) {
        this.priceTitleThree = priceTitleThree == null ? null : priceTitleThree.trim();
    }

    public String getDiscountTitleOne() {
        return discountTitleOne;
    }

    public void setDiscountTitleOne(String discountTitleOne) {
        this.discountTitleOne = discountTitleOne == null ? null : discountTitleOne.trim();
    }

    public String getDiscountTitleTwo() {
        return discountTitleTwo;
    }

    public void setDiscountTitleTwo(String discountTitleTwo) {
        this.discountTitleTwo = discountTitleTwo == null ? null : discountTitleTwo.trim();
    }

    public String getDiscountTitleThree() {
        return discountTitleThree;
    }

    public void setDiscountTitleThree(String discountTitleThree) {
        this.discountTitleThree = discountTitleThree == null ? null : discountTitleThree.trim();
    }

    public Double getDiscountThree() {
        return discountThree;
    }

    public void setDiscountThree(Double discountThree) {
        this.discountThree = discountThree;
    }

    public Double getDiscountOne() {
        return discountOne;
    }

    public void setDiscountOne(Double discountOne) {
        this.discountOne = discountOne;
    }

    public Double getPriceThree() {
        return priceThree;
    }

    public void setPriceThree(Double priceThree) {
        this.priceThree = priceThree;
    }

    public Double getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(Double priceOne) {
        this.priceOne = priceOne;
    }

    public Double getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(Double priceTwo) {
        this.priceTwo = priceTwo;
    }

    public Double getDiscountTwo() {
        return discountTwo;
    }

    public void setDiscountTwo(Double discountTwo) {
        this.discountTwo = discountTwo;
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