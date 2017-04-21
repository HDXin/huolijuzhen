package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import java.util.Date;

public class ServiceTypeEntity extends BaseEntity {
    private Long id;

    private String name;

    private Boolean isReco;

    private ServerGrade serverGrade;

    private String describle;

    private EnableStatus enableStatus;

    private Long enableBy;

    private Date enableTime;

    private Long disableBy;

    private Date disableTime;

    private Long recoBy;

    private Date recoTime;

    private Long unRecoBy;

    private Date unRecoTime;

    private String typeLogo;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private String recoLogo;

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

    public Boolean getIsReco() {
        return isReco;
    }

    public void setIsReco(Boolean isReco) {
        this.isReco = isReco;
    }

    public ServerGrade getServerGrade() {
        return serverGrade;
    }

    public void setServerGrade(ServerGrade serverGrade) {
        this.serverGrade = serverGrade;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }

    public EnableStatus getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(EnableStatus enableStatus) {
        this.enableStatus = enableStatus;
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

    public Long getRecoBy() {
        return recoBy;
    }

    public void setRecoBy(Long recoBy) {
        this.recoBy = recoBy;
    }

    public Date getRecoTime() {
        return recoTime;
    }

    public void setRecoTime(Date recoTime) {
        this.recoTime = recoTime;
    }

    public Long getUnRecoBy() {
        return unRecoBy;
    }

    public void setUnRecoBy(Long unRecoBy) {
        this.unRecoBy = unRecoBy;
    }

    public Date getUnRecoTime() {
        return unRecoTime;
    }

    public void setUnRecoTime(Date unRecoTime) {
        this.unRecoTime = unRecoTime;
    }

    public String getTypeLogo() {
        return typeLogo;
    }

    public void setTypeLogo(String typeLogo) {
        this.typeLogo = typeLogo == null ? null : typeLogo.trim();
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

    public String getRecoLogo() {
        return recoLogo;
    }

    public void setRecoLogo(String recoLogo) {
        this.recoLogo = recoLogo == null ? null : recoLogo.trim();
    }
}