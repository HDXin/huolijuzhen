package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import java.math.BigDecimal;
import java.util.Date;

public class BillCostCalRulesEntity extends BaseEntity {
    private Long id;

    private Long contractId;

    private Long costProId;

    private String costProName;

    private ComputeMode computeMode;

    private Integer freeMonth;

    private Integer advanceMonth;

    private BigDecimal fixedAmount;

    private BigDecimal startAdjAmount;

    private String startAdjMonth;

    private BigDecimal endAdjAmount;

    private String endAdjMonth;

    private Integer leaseAreaCal;

    private Integer contAmountCal;

    private Integer daysCal;

    private Integer isRollingCal;

    private Integer rollingStartMonth;

    private Integer rollingPeriod;

    private BigDecimal rollingRange;

    private String formula;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private Date startDate;

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getCostProId() {
        return costProId;
    }

    public void setCostProId(Long costProId) {
        this.costProId = costProId;
    }

    public String getCostProName() {
        return costProName;
    }

    public void setCostProName(String costProName) {
        this.costProName = costProName == null ? null : costProName.trim();
    }

    public ComputeMode getComputeMode() {
        return computeMode;
    }

    public void setComputeMode(ComputeMode computeMode) {
        this.computeMode = computeMode;
    }

    public Integer getFreeMonth() {
        return freeMonth;
    }

    public void setFreeMonth(Integer freeMonth) {
        this.freeMonth = freeMonth;
    }

    public Integer getAdvanceMonth() {
        return advanceMonth;
    }

    public void setAdvanceMonth(Integer advanceMonth) {
        this.advanceMonth = advanceMonth;
    }

    public BigDecimal getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(BigDecimal fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public BigDecimal getStartAdjAmount() {
        return startAdjAmount;
    }

    public void setStartAdjAmount(BigDecimal startAdjAmount) {
        this.startAdjAmount = startAdjAmount;
    }

    public String getStartAdjMonth() {
        return startAdjMonth;
    }

    public void setStartAdjMonth(String startAdjMonth) {
        this.startAdjMonth = startAdjMonth == null ? null : startAdjMonth.trim();
    }

    public BigDecimal getEndAdjAmount() {
        return endAdjAmount;
    }

    public void setEndAdjAmount(BigDecimal endAdjAmount) {
        this.endAdjAmount = endAdjAmount;
    }

    public String getEndAdjMonth() {
        return endAdjMonth;
    }

    public void setEndAdjMonth(String endAdjMonth) {
        this.endAdjMonth = endAdjMonth == null ? null : endAdjMonth.trim();
    }

    public Integer getLeaseAreaCal() {
        return leaseAreaCal;
    }

    public void setLeaseAreaCal(Integer leaseAreaCal) {
        this.leaseAreaCal = leaseAreaCal;
    }

    public Integer getContAmountCal() {
        return contAmountCal;
    }

    public void setContAmountCal(Integer contAmountCal) {
        this.contAmountCal = contAmountCal;
    }

    public Integer getDaysCal() {
        return daysCal;
    }

    public void setDaysCal(Integer daysCal) {
        this.daysCal = daysCal;
    }

    public Integer getIsRollingCal() {
        return isRollingCal;
    }

    public void setIsRollingCal(Integer isRollingCal) {
        this.isRollingCal = isRollingCal;
    }

    public Integer getRollingStartMonth() {
        return rollingStartMonth;
    }

    public void setRollingStartMonth(Integer rollingStartMonth) {
        this.rollingStartMonth = rollingStartMonth;
    }

    public Integer getRollingPeriod() {
        return rollingPeriod;
    }

    public void setRollingPeriod(Integer rollingPeriod) {
        this.rollingPeriod = rollingPeriod;
    }

    public BigDecimal getRollingRange() {
        return rollingRange;
    }

    public void setRollingRange(BigDecimal rollingRange) {
        this.rollingRange = rollingRange;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}