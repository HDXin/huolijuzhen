package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import java.util.Date;

public class EnterpriseInfoEntity extends BaseEntity {
    private Long id;

    private String name;

    private Integer type;

    private String code;

    private String contacts;

    private String phone;

    private String adminAccount;

    private CreateSource createSource;

    private Double totalBala;

    private Double ableBala;

    private Double freezeBala;

    private Double bindBala;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount == null ? null : adminAccount.trim();
    }

    public CreateSource getCreateSource() {
        return createSource;
    }

    public void setCreateSource(CreateSource createSource) {
        this.createSource = createSource;
    }

    public Double getTotalBala() {
        return totalBala;
    }

    public void setTotalBala(Double totalBala) {
        this.totalBala = totalBala;
    }

    public Double getAbleBala() {
        return ableBala;
    }

    public void setAbleBala(Double ableBala) {
        this.ableBala = ableBala;
    }

    public Double getFreezeBala() {
        return freezeBala;
    }

    public void setFreezeBala(Double freezeBala) {
        this.freezeBala = freezeBala;
    }

    public Double getBindBala() {
        return bindBala;
    }

    public void setBindBala(Double bindBala) {
        this.bindBala = bindBala;
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