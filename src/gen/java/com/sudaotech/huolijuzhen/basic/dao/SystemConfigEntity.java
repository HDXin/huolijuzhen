package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.util.Date;

public class SystemConfigEntity extends BaseEntity {
    private Long id;

    private Long parkId;

    private EnableStatus maintenanceReportSign;

    private Integer maintenanceReportDays;

    private EnableStatus createParkSign;

    private Integer createParkDays;

    private EnableStatus equipmentMaintainSign;

    private Integer equipmentMaintainDays;

    private EnableStatus urgeTermSign;

    private Integer urgeTermDays;

    private String urgeContentTemplate;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private String billIntroduction;

    private String billPayWay;

    private String billBankAccount;

    private String billInscrible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public EnableStatus getMaintenanceReportSign() {
        return maintenanceReportSign;
    }

    public void setMaintenanceReportSign(EnableStatus maintenanceReportSign) {
        this.maintenanceReportSign = maintenanceReportSign;
    }

    public Integer getMaintenanceReportDays() {
        return maintenanceReportDays;
    }

    public void setMaintenanceReportDays(Integer maintenanceReportDays) {
        this.maintenanceReportDays = maintenanceReportDays;
    }

    public EnableStatus getCreateParkSign() {
        return createParkSign;
    }

    public void setCreateParkSign(EnableStatus createParkSign) {
        this.createParkSign = createParkSign;
    }

    public Integer getCreateParkDays() {
        return createParkDays;
    }

    public void setCreateParkDays(Integer createParkDays) {
        this.createParkDays = createParkDays;
    }

    public EnableStatus getEquipmentMaintainSign() {
        return equipmentMaintainSign;
    }

    public void setEquipmentMaintainSign(EnableStatus equipmentMaintainSign) {
        this.equipmentMaintainSign = equipmentMaintainSign;
    }

    public Integer getEquipmentMaintainDays() {
        return equipmentMaintainDays;
    }

    public void setEquipmentMaintainDays(Integer equipmentMaintainDays) {
        this.equipmentMaintainDays = equipmentMaintainDays;
    }

    public EnableStatus getUrgeTermSign() {
        return urgeTermSign;
    }

    public void setUrgeTermSign(EnableStatus urgeTermSign) {
        this.urgeTermSign = urgeTermSign;
    }

    public Integer getUrgeTermDays() {
        return urgeTermDays;
    }

    public void setUrgeTermDays(Integer urgeTermDays) {
        this.urgeTermDays = urgeTermDays;
    }

    public String getUrgeContentTemplate() {
        return urgeContentTemplate;
    }

    public void setUrgeContentTemplate(String urgeContentTemplate) {
        this.urgeContentTemplate = urgeContentTemplate == null ? null : urgeContentTemplate.trim();
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

    public String getBillIntroduction() {
        return billIntroduction;
    }

    public void setBillIntroduction(String billIntroduction) {
        this.billIntroduction = billIntroduction == null ? null : billIntroduction.trim();
    }

    public String getBillPayWay() {
        return billPayWay;
    }

    public void setBillPayWay(String billPayWay) {
        this.billPayWay = billPayWay == null ? null : billPayWay.trim();
    }

    public String getBillBankAccount() {
        return billBankAccount;
    }

    public void setBillBankAccount(String billBankAccount) {
        this.billBankAccount = billBankAccount == null ? null : billBankAccount.trim();
    }

    public String getBillInscrible() {
        return billInscrible;
    }

    public void setBillInscrible(String billInscrible) {
        this.billInscrible = billInscrible == null ? null : billInscrible.trim();
    }
}