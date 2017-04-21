package com.sudaotech.huolijuzhen.task.dao;

import com.sudaotech.core.dao.entity.BaseEntity;
import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CommentGrade;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import java.math.BigDecimal;
import java.util.Date;

public class TaskEntity extends BaseEntity {
    private Long id;

    private String title;

    private String code;

    private TaskType taskType;

    private Long equPlanId;

    private Long equId;

    private String description;

    private EnableStatus enableStatus;

    private TaskStatus taskStatus;

    private Boolean isAdjust;

    private Long adjustBy;

    private Date adjustTime;

    private String adjustMemo;

    private Long operator;

    private String operatorMemo;

    private Date operatorTime;

    private PayWay payWay;

    private String executor;

    private Long parkId;

    private Long allBy;

    private Date allTime;

    private Long closeBy;

    private Date closeTime;

    private Integer version;

    private Status status;

    private Long createBy;

    private Date createTime;

    private String createName;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    private Boolean hasCost;

    private Boolean costIsVerify;

    private BigDecimal taskCost;

    private Long verifyBy;

    private Date veribyTime;

    private String veribyMemo;

    private Boolean isComment;

    private Long commentBy;

    private Date commentTime;

    private CommentGrade commentGrade;

    private String commentContent;

    private Integer commentStarGrade;

    private Long equTypeId;

    private String updateMemo;

    private String history;

    private Integer isChoose;

    private Long billId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Long getEquPlanId() {
        return equPlanId;
    }

    public void setEquPlanId(Long equPlanId) {
        this.equPlanId = equPlanId;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public EnableStatus getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(EnableStatus enableStatus) {
        this.enableStatus = enableStatus;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Boolean getIsAdjust() {
        return isAdjust;
    }

    public void setIsAdjust(Boolean isAdjust) {
        this.isAdjust = isAdjust;
    }

    public Long getAdjustBy() {
        return adjustBy;
    }

    public void setAdjustBy(Long adjustBy) {
        this.adjustBy = adjustBy;
    }

    public Date getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Date adjustTime) {
        this.adjustTime = adjustTime;
    }

    public String getAdjustMemo() {
        return adjustMemo;
    }

    public void setAdjustMemo(String adjustMemo) {
        this.adjustMemo = adjustMemo == null ? null : adjustMemo.trim();
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getOperatorMemo() {
        return operatorMemo;
    }

    public void setOperatorMemo(String operatorMemo) {
        this.operatorMemo = operatorMemo == null ? null : operatorMemo.trim();
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public PayWay getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWay payWay) {
        this.payWay = payWay;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor == null ? null : executor.trim();
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getAllBy() {
        return allBy;
    }

    public void setAllBy(Long allBy) {
        this.allBy = allBy;
    }

    public Date getAllTime() {
        return allTime;
    }

    public void setAllTime(Date allTime) {
        this.allTime = allTime;
    }

    public Long getCloseBy() {
        return closeBy;
    }

    public void setCloseBy(Long closeBy) {
        this.closeBy = closeBy;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
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

    public Boolean getHasCost() {
        return hasCost;
    }

    public void setHasCost(Boolean hasCost) {
        this.hasCost = hasCost;
    }

    public Boolean getCostIsVerify() {
        return costIsVerify;
    }

    public void setCostIsVerify(Boolean costIsVerify) {
        this.costIsVerify = costIsVerify;
    }

    public BigDecimal getTaskCost() {
        return taskCost;
    }

    public void setTaskCost(BigDecimal taskCost) {
        this.taskCost = taskCost;
    }

    public Long getVerifyBy() {
        return verifyBy;
    }

    public void setVerifyBy(Long verifyBy) {
        this.verifyBy = verifyBy;
    }

    public Date getVeribyTime() {
        return veribyTime;
    }

    public void setVeribyTime(Date veribyTime) {
        this.veribyTime = veribyTime;
    }

    public String getVeribyMemo() {
        return veribyMemo;
    }

    public void setVeribyMemo(String veribyMemo) {
        this.veribyMemo = veribyMemo == null ? null : veribyMemo.trim();
    }

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
    }

    public Long getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(Long commentBy) {
        this.commentBy = commentBy;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public CommentGrade getCommentGrade() {
        return commentGrade;
    }

    public void setCommentGrade(CommentGrade commentGrade) {
        this.commentGrade = commentGrade;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Integer getCommentStarGrade() {
        return commentStarGrade;
    }

    public void setCommentStarGrade(Integer commentStarGrade) {
        this.commentStarGrade = commentStarGrade;
    }

    public Long getEquTypeId() {
        return equTypeId;
    }

    public void setEquTypeId(Long equTypeId) {
        this.equTypeId = equTypeId;
    }

    public String getUpdateMemo() {
        return updateMemo;
    }

    public void setUpdateMemo(String updateMemo) {
        this.updateMemo = updateMemo == null ? null : updateMemo.trim();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    public Integer getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(Integer isChoose) {
        this.isChoose = isChoose;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }
}