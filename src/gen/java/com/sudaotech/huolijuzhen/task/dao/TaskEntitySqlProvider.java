package com.sudaotech.huolijuzhen.task.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sudaotech.huolijuzhen.task.dao.TaskEntityExample.Criteria;
import com.sudaotech.huolijuzhen.task.dao.TaskEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class TaskEntitySqlProvider {

    public String countByExample(TaskEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("task_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TaskEntityExample example) {
        BEGIN();
        DELETE_FROM("task_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TaskEntity record) {
        BEGIN();
        INSERT_INTO("task_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskType() != null) {
            VALUES("taskType", "#{taskType,jdbcType=INTEGER}");
        }
        
        if (record.getEquPlanId() != null) {
            VALUES("equPlanId", "#{equPlanId,jdbcType=BIGINT}");
        }
        
        if (record.getEquId() != null) {
            VALUES("equId", "#{equId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            VALUES("enableStatus", "#{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            VALUES("taskStatus", "#{taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsAdjust() != null) {
            VALUES("isAdjust", "#{isAdjust,jdbcType=BIT}");
        }
        
        if (record.getAdjustBy() != null) {
            VALUES("adjustBy", "#{adjustBy,jdbcType=BIGINT}");
        }
        
        if (record.getAdjustTime() != null) {
            VALUES("adjustTime", "#{adjustTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAdjustMemo() != null) {
            VALUES("adjustMemo", "#{adjustMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            VALUES("operator", "#{operator,jdbcType=BIGINT}");
        }
        
        if (record.getOperatorMemo() != null) {
            VALUES("operatorMemo", "#{operatorMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorTime() != null) {
            VALUES("operatorTime", "#{operatorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayWay() != null) {
            VALUES("payWay", "#{payWay,jdbcType=INTEGER}");
        }
        
        if (record.getExecutor() != null) {
            VALUES("executor", "#{executor,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getAllBy() != null) {
            VALUES("allBy", "#{allBy,jdbcType=BIGINT}");
        }
        
        if (record.getAllTime() != null) {
            VALUES("allTime", "#{allTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            VALUES("closeBy", "#{closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            VALUES("closeTime", "#{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            VALUES("createBy", "#{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateName() != null) {
            VALUES("createName", "#{createName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateBy() != null) {
            VALUES("updateBy", "#{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            VALUES("lastUpdate", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasCost() != null) {
            VALUES("hasCost", "#{hasCost,jdbcType=BIT}");
        }
        
        if (record.getCostIsVerify() != null) {
            VALUES("costIsVerify", "#{costIsVerify,jdbcType=BIT}");
        }
        
        if (record.getTaskCost() != null) {
            VALUES("taskCost", "#{taskCost,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyBy() != null) {
            VALUES("verifyBy", "#{verifyBy,jdbcType=BIGINT}");
        }
        
        if (record.getVeribyTime() != null) {
            VALUES("veribyTime", "#{veribyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVeribyMemo() != null) {
            VALUES("veribyMemo", "#{veribyMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsComment() != null) {
            VALUES("isComment", "#{isComment,jdbcType=BIT}");
        }
        
        if (record.getCommentBy() != null) {
            VALUES("commentBy", "#{commentBy,jdbcType=BIGINT}");
        }
        
        if (record.getCommentTime() != null) {
            VALUES("commentTime", "#{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentGrade() != null) {
            VALUES("commentGrade", "#{commentGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentContent() != null) {
            VALUES("commentContent", "#{commentContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentStarGrade() != null) {
            VALUES("commentStarGrade", "#{commentStarGrade,jdbcType=INTEGER}");
        }
        
        if (record.getEquTypeId() != null) {
            VALUES("equTypeId", "#{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateMemo() != null) {
            VALUES("updateMemo", "#{updateMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getHistory() != null) {
            VALUES("history", "#{history,jdbcType=VARCHAR}");
        }
        
        if (record.getIsChoose() != null) {
            VALUES("isChoose", "#{isChoose,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            VALUES("billId", "#{billId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(TaskEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("code");
        SELECT("taskType");
        SELECT("equPlanId");
        SELECT("equId");
        SELECT("description");
        SELECT("enableStatus");
        SELECT("taskStatus");
        SELECT("isAdjust");
        SELECT("adjustBy");
        SELECT("adjustTime");
        SELECT("adjustMemo");
        SELECT("operator");
        SELECT("operatorMemo");
        SELECT("operatorTime");
        SELECT("payWay");
        SELECT("executor");
        SELECT("parkId");
        SELECT("allBy");
        SELECT("allTime");
        SELECT("closeBy");
        SELECT("closeTime");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("createName");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("hasCost");
        SELECT("costIsVerify");
        SELECT("taskCost");
        SELECT("verifyBy");
        SELECT("veribyTime");
        SELECT("veribyMemo");
        SELECT("isComment");
        SELECT("commentBy");
        SELECT("commentTime");
        SELECT("commentGrade");
        SELECT("commentContent");
        SELECT("commentStarGrade");
        SELECT("equTypeId");
        SELECT("updateMemo");
        SELECT("history");
        SELECT("isChoose");
        SELECT("billId");
        FROM("task_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskEntity record = (TaskEntity) parameter.get("record");
        TaskEntityExample example = (TaskEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("task_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskType() != null) {
            SET("taskType = #{record.taskType,jdbcType=INTEGER}");
        }
        
        if (record.getEquPlanId() != null) {
            SET("equPlanId = #{record.equPlanId,jdbcType=BIGINT}");
        }
        
        if (record.getEquId() != null) {
            SET("equId = #{record.equId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            SET("taskStatus = #{record.taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsAdjust() != null) {
            SET("isAdjust = #{record.isAdjust,jdbcType=BIT}");
        }
        
        if (record.getAdjustBy() != null) {
            SET("adjustBy = #{record.adjustBy,jdbcType=BIGINT}");
        }
        
        if (record.getAdjustTime() != null) {
            SET("adjustTime = #{record.adjustTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAdjustMemo() != null) {
            SET("adjustMemo = #{record.adjustMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("operator = #{record.operator,jdbcType=BIGINT}");
        }
        
        if (record.getOperatorMemo() != null) {
            SET("operatorMemo = #{record.operatorMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorTime() != null) {
            SET("operatorTime = #{record.operatorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayWay() != null) {
            SET("payWay = #{record.payWay,jdbcType=INTEGER}");
        }
        
        if (record.getExecutor() != null) {
            SET("executor = #{record.executor,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getAllBy() != null) {
            SET("allBy = #{record.allBy,jdbcType=BIGINT}");
        }
        
        if (record.getAllTime() != null) {
            SET("allTime = #{record.allTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            SET("closeBy = #{record.closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            SET("closeTime = #{record.closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateName() != null) {
            SET("createName = #{record.createName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasCost() != null) {
            SET("hasCost = #{record.hasCost,jdbcType=BIT}");
        }
        
        if (record.getCostIsVerify() != null) {
            SET("costIsVerify = #{record.costIsVerify,jdbcType=BIT}");
        }
        
        if (record.getTaskCost() != null) {
            SET("taskCost = #{record.taskCost,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyBy() != null) {
            SET("verifyBy = #{record.verifyBy,jdbcType=BIGINT}");
        }
        
        if (record.getVeribyTime() != null) {
            SET("veribyTime = #{record.veribyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVeribyMemo() != null) {
            SET("veribyMemo = #{record.veribyMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsComment() != null) {
            SET("isComment = #{record.isComment,jdbcType=BIT}");
        }
        
        if (record.getCommentBy() != null) {
            SET("commentBy = #{record.commentBy,jdbcType=BIGINT}");
        }
        
        if (record.getCommentTime() != null) {
            SET("commentTime = #{record.commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentGrade() != null) {
            SET("commentGrade = #{record.commentGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentContent() != null) {
            SET("commentContent = #{record.commentContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentStarGrade() != null) {
            SET("commentStarGrade = #{record.commentStarGrade,jdbcType=INTEGER}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateMemo() != null) {
            SET("updateMemo = #{record.updateMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getHistory() != null) {
            SET("history = #{record.history,jdbcType=VARCHAR}");
        }
        
        if (record.getIsChoose() != null) {
            SET("isChoose = #{record.isChoose,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            SET("billId = #{record.billId,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("task_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("taskType = #{record.taskType,jdbcType=INTEGER}");
        SET("equPlanId = #{record.equPlanId,jdbcType=BIGINT}");
        SET("equId = #{record.equId,jdbcType=BIGINT}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        SET("taskStatus = #{record.taskStatus,jdbcType=INTEGER}");
        SET("isAdjust = #{record.isAdjust,jdbcType=BIT}");
        SET("adjustBy = #{record.adjustBy,jdbcType=BIGINT}");
        SET("adjustTime = #{record.adjustTime,jdbcType=TIMESTAMP}");
        SET("adjustMemo = #{record.adjustMemo,jdbcType=VARCHAR}");
        SET("operator = #{record.operator,jdbcType=BIGINT}");
        SET("operatorMemo = #{record.operatorMemo,jdbcType=VARCHAR}");
        SET("operatorTime = #{record.operatorTime,jdbcType=TIMESTAMP}");
        SET("payWay = #{record.payWay,jdbcType=INTEGER}");
        SET("executor = #{record.executor,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("allBy = #{record.allBy,jdbcType=BIGINT}");
        SET("allTime = #{record.allTime,jdbcType=TIMESTAMP}");
        SET("closeBy = #{record.closeBy,jdbcType=BIGINT}");
        SET("closeTime = #{record.closeTime,jdbcType=TIMESTAMP}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("createName = #{record.createName,jdbcType=VARCHAR}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("hasCost = #{record.hasCost,jdbcType=BIT}");
        SET("costIsVerify = #{record.costIsVerify,jdbcType=BIT}");
        SET("taskCost = #{record.taskCost,jdbcType=DECIMAL}");
        SET("verifyBy = #{record.verifyBy,jdbcType=BIGINT}");
        SET("veribyTime = #{record.veribyTime,jdbcType=TIMESTAMP}");
        SET("veribyMemo = #{record.veribyMemo,jdbcType=VARCHAR}");
        SET("isComment = #{record.isComment,jdbcType=BIT}");
        SET("commentBy = #{record.commentBy,jdbcType=BIGINT}");
        SET("commentTime = #{record.commentTime,jdbcType=TIMESTAMP}");
        SET("commentGrade = #{record.commentGrade,jdbcType=INTEGER}");
        SET("commentContent = #{record.commentContent,jdbcType=VARCHAR}");
        SET("commentStarGrade = #{record.commentStarGrade,jdbcType=INTEGER}");
        SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        SET("updateMemo = #{record.updateMemo,jdbcType=VARCHAR}");
        SET("history = #{record.history,jdbcType=VARCHAR}");
        SET("isChoose = #{record.isChoose,jdbcType=INTEGER}");
        SET("billId = #{record.billId,jdbcType=BIGINT}");
        
        TaskEntityExample example = (TaskEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TaskEntity record) {
        BEGIN();
        UPDATE("task_info");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskType() != null) {
            SET("taskType = #{taskType,jdbcType=INTEGER}");
        }
        
        if (record.getEquPlanId() != null) {
            SET("equPlanId = #{equPlanId,jdbcType=BIGINT}");
        }
        
        if (record.getEquId() != null) {
            SET("equId = #{equId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            SET("taskStatus = #{taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsAdjust() != null) {
            SET("isAdjust = #{isAdjust,jdbcType=BIT}");
        }
        
        if (record.getAdjustBy() != null) {
            SET("adjustBy = #{adjustBy,jdbcType=BIGINT}");
        }
        
        if (record.getAdjustTime() != null) {
            SET("adjustTime = #{adjustTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAdjustMemo() != null) {
            SET("adjustMemo = #{adjustMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("operator = #{operator,jdbcType=BIGINT}");
        }
        
        if (record.getOperatorMemo() != null) {
            SET("operatorMemo = #{operatorMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorTime() != null) {
            SET("operatorTime = #{operatorTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayWay() != null) {
            SET("payWay = #{payWay,jdbcType=INTEGER}");
        }
        
        if (record.getExecutor() != null) {
            SET("executor = #{executor,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getAllBy() != null) {
            SET("allBy = #{allBy,jdbcType=BIGINT}");
        }
        
        if (record.getAllTime() != null) {
            SET("allTime = #{allTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            SET("closeBy = #{closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            SET("closeTime = #{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateName() != null) {
            SET("createName = #{createName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasCost() != null) {
            SET("hasCost = #{hasCost,jdbcType=BIT}");
        }
        
        if (record.getCostIsVerify() != null) {
            SET("costIsVerify = #{costIsVerify,jdbcType=BIT}");
        }
        
        if (record.getTaskCost() != null) {
            SET("taskCost = #{taskCost,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyBy() != null) {
            SET("verifyBy = #{verifyBy,jdbcType=BIGINT}");
        }
        
        if (record.getVeribyTime() != null) {
            SET("veribyTime = #{veribyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVeribyMemo() != null) {
            SET("veribyMemo = #{veribyMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsComment() != null) {
            SET("isComment = #{isComment,jdbcType=BIT}");
        }
        
        if (record.getCommentBy() != null) {
            SET("commentBy = #{commentBy,jdbcType=BIGINT}");
        }
        
        if (record.getCommentTime() != null) {
            SET("commentTime = #{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentGrade() != null) {
            SET("commentGrade = #{commentGrade,jdbcType=INTEGER}");
        }
        
        if (record.getCommentContent() != null) {
            SET("commentContent = #{commentContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentStarGrade() != null) {
            SET("commentStarGrade = #{commentStarGrade,jdbcType=INTEGER}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateMemo() != null) {
            SET("updateMemo = #{updateMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getHistory() != null) {
            SET("history = #{history,jdbcType=VARCHAR}");
        }
        
        if (record.getIsChoose() != null) {
            SET("isChoose = #{isChoose,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            SET("billId = #{billId,jdbcType=BIGINT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(TaskEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}