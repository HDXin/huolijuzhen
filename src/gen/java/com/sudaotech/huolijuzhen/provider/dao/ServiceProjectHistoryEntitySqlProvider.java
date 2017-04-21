package com.sudaotech.huolijuzhen.provider.dao;

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

import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class ServiceProjectHistoryEntitySqlProvider {

    public String countByExample(ServiceProjectHistoryEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("service_pro_history");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ServiceProjectHistoryEntityExample example) {
        BEGIN();
        DELETE_FROM("service_pro_history");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ServiceProjectHistoryEntity record) {
        BEGIN();
        INSERT_INTO("service_pro_history");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getMainTitle() != null) {
            VALUES("mainTitle", "#{mainTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            VALUES("subTitle", "#{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTypeId() != null) {
            VALUES("serviceTypeId", "#{serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServerGrade() != null) {
            VALUES("serverGrade", "#{serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            VALUES("serviceGrade", "#{serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGradeId() != null) {
            VALUES("serviceGradeId", "#{serviceGradeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceGradeName() != null) {
            VALUES("serviceGradeName", "#{serviceGradeName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportApply() != null) {
            VALUES("supportApply", "#{supportApply,jdbcType=BIT}");
        }
        
        if (record.getApplyViewId() != null) {
            VALUES("applyViewId", "#{applyViewId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportOrder() != null) {
            VALUES("supportOrder", "#{supportOrder,jdbcType=BIT}");
        }
        
        if (record.getOrderViewId() != null) {
            VALUES("orderViewId", "#{orderViewId,jdbcType=BIGINT}");
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
        
        if (record.getUpdateBy() != null) {
            VALUES("updateBy", "#{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            VALUES("lastUpdate", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            VALUES("approvalStatus", "#{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            VALUES("approvalBy", "#{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            VALUES("approvalTime", "#{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            VALUES("approvalText", "#{approvalText,jdbcType=VARCHAR}");
        }
        
        if (record.getParkProId() != null) {
            VALUES("parkProId", "#{parkProId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCityId() != null) {
            VALUES("parkCityId", "#{parkCityId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCounId() != null) {
            VALUES("parkCounId", "#{parkCounId,jdbcType=BIGINT}");
        }
        
        if (record.getParkLocationId() != null) {
            VALUES("parkLocationId", "#{parkLocationId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyOrderNum() != null) {
            VALUES("applyOrderNum", "#{applyOrderNum,jdbcType=INTEGER}");
        }
        
        if (record.getCollectNum() != null) {
            VALUES("collectNum", "#{collectNum,jdbcType=INTEGER}");
        }
        
        if (record.getReadNum() != null) {
            VALUES("readNum", "#{readNum,jdbcType=INTEGER}");
        }
        
        if (record.getCommentNum() != null) {
            VALUES("commentNum", "#{commentNum,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceProId() != null) {
            VALUES("serviceProId", "#{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceProRelease() != null) {
            VALUES("serviceProRelease", "#{serviceProRelease,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ServiceProjectHistoryEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("mainTitle");
        SELECT("subTitle");
        SELECT("serviceTypeId");
        SELECT("serverGrade");
        SELECT("serviceGrade");
        SELECT("serviceGradeId");
        SELECT("serviceGradeName");
        SELECT("parkId");
        SELECT("supportApply");
        SELECT("applyViewId");
        SELECT("supportOrder");
        SELECT("orderViewId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalText");
        SELECT("parkProId");
        SELECT("parkCityId");
        SELECT("parkCounId");
        SELECT("parkLocationId");
        SELECT("applyOrderNum");
        SELECT("collectNum");
        SELECT("readNum");
        SELECT("commentNum");
        SELECT("serviceProId");
        SELECT("serviceProRelease");
        SELECT("content");
        FROM("service_pro_history");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ServiceProjectHistoryEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("mainTitle");
        SELECT("subTitle");
        SELECT("serviceTypeId");
        SELECT("serverGrade");
        SELECT("serviceGrade");
        SELECT("serviceGradeId");
        SELECT("serviceGradeName");
        SELECT("parkId");
        SELECT("supportApply");
        SELECT("applyViewId");
        SELECT("supportOrder");
        SELECT("orderViewId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalText");
        SELECT("parkProId");
        SELECT("parkCityId");
        SELECT("parkCounId");
        SELECT("parkLocationId");
        SELECT("applyOrderNum");
        SELECT("collectNum");
        SELECT("readNum");
        SELECT("commentNum");
        SELECT("serviceProId");
        SELECT("serviceProRelease");
        FROM("service_pro_history");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ServiceProjectHistoryEntity record = (ServiceProjectHistoryEntity) parameter.get("record");
        ServiceProjectHistoryEntityExample example = (ServiceProjectHistoryEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("service_pro_history");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getMainTitle() != null) {
            SET("mainTitle = #{record.mainTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            SET("subTitle = #{record.subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTypeId() != null) {
            SET("serviceTypeId = #{record.serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServerGrade() != null) {
            SET("serverGrade = #{record.serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            SET("serviceGrade = #{record.serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGradeId() != null) {
            SET("serviceGradeId = #{record.serviceGradeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceGradeName() != null) {
            SET("serviceGradeName = #{record.serviceGradeName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportApply() != null) {
            SET("supportApply = #{record.supportApply,jdbcType=BIT}");
        }
        
        if (record.getApplyViewId() != null) {
            SET("applyViewId = #{record.applyViewId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportOrder() != null) {
            SET("supportOrder = #{record.supportOrder,jdbcType=BIT}");
        }
        
        if (record.getOrderViewId() != null) {
            SET("orderViewId = #{record.orderViewId,jdbcType=BIGINT}");
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
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
        }
        
        if (record.getParkProId() != null) {
            SET("parkProId = #{record.parkProId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCityId() != null) {
            SET("parkCityId = #{record.parkCityId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCounId() != null) {
            SET("parkCounId = #{record.parkCounId,jdbcType=BIGINT}");
        }
        
        if (record.getParkLocationId() != null) {
            SET("parkLocationId = #{record.parkLocationId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyOrderNum() != null) {
            SET("applyOrderNum = #{record.applyOrderNum,jdbcType=INTEGER}");
        }
        
        if (record.getCollectNum() != null) {
            SET("collectNum = #{record.collectNum,jdbcType=INTEGER}");
        }
        
        if (record.getReadNum() != null) {
            SET("readNum = #{record.readNum,jdbcType=INTEGER}");
        }
        
        if (record.getCommentNum() != null) {
            SET("commentNum = #{record.commentNum,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceProRelease() != null) {
            SET("serviceProRelease = #{record.serviceProRelease,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("service_pro_history");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("mainTitle = #{record.mainTitle,jdbcType=VARCHAR}");
        SET("subTitle = #{record.subTitle,jdbcType=VARCHAR}");
        SET("serviceTypeId = #{record.serviceTypeId,jdbcType=BIGINT}");
        SET("serverGrade = #{record.serverGrade,jdbcType=INTEGER}");
        SET("serviceGrade = #{record.serviceGrade,jdbcType=INTEGER}");
        SET("serviceGradeId = #{record.serviceGradeId,jdbcType=BIGINT}");
        SET("serviceGradeName = #{record.serviceGradeName,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("supportApply = #{record.supportApply,jdbcType=BIT}");
        SET("applyViewId = #{record.applyViewId,jdbcType=BIGINT}");
        SET("supportOrder = #{record.supportOrder,jdbcType=BIT}");
        SET("orderViewId = #{record.orderViewId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
        SET("parkProId = #{record.parkProId,jdbcType=BIGINT}");
        SET("parkCityId = #{record.parkCityId,jdbcType=BIGINT}");
        SET("parkCounId = #{record.parkCounId,jdbcType=BIGINT}");
        SET("parkLocationId = #{record.parkLocationId,jdbcType=BIGINT}");
        SET("applyOrderNum = #{record.applyOrderNum,jdbcType=INTEGER}");
        SET("collectNum = #{record.collectNum,jdbcType=INTEGER}");
        SET("readNum = #{record.readNum,jdbcType=INTEGER}");
        SET("commentNum = #{record.commentNum,jdbcType=DECIMAL}");
        SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        SET("serviceProRelease = #{record.serviceProRelease,jdbcType=INTEGER}");
        SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        ServiceProjectHistoryEntityExample example = (ServiceProjectHistoryEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("service_pro_history");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("mainTitle = #{record.mainTitle,jdbcType=VARCHAR}");
        SET("subTitle = #{record.subTitle,jdbcType=VARCHAR}");
        SET("serviceTypeId = #{record.serviceTypeId,jdbcType=BIGINT}");
        SET("serverGrade = #{record.serverGrade,jdbcType=INTEGER}");
        SET("serviceGrade = #{record.serviceGrade,jdbcType=INTEGER}");
        SET("serviceGradeId = #{record.serviceGradeId,jdbcType=BIGINT}");
        SET("serviceGradeName = #{record.serviceGradeName,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("supportApply = #{record.supportApply,jdbcType=BIT}");
        SET("applyViewId = #{record.applyViewId,jdbcType=BIGINT}");
        SET("supportOrder = #{record.supportOrder,jdbcType=BIT}");
        SET("orderViewId = #{record.orderViewId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
        SET("parkProId = #{record.parkProId,jdbcType=BIGINT}");
        SET("parkCityId = #{record.parkCityId,jdbcType=BIGINT}");
        SET("parkCounId = #{record.parkCounId,jdbcType=BIGINT}");
        SET("parkLocationId = #{record.parkLocationId,jdbcType=BIGINT}");
        SET("applyOrderNum = #{record.applyOrderNum,jdbcType=INTEGER}");
        SET("collectNum = #{record.collectNum,jdbcType=INTEGER}");
        SET("readNum = #{record.readNum,jdbcType=INTEGER}");
        SET("commentNum = #{record.commentNum,jdbcType=DECIMAL}");
        SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        SET("serviceProRelease = #{record.serviceProRelease,jdbcType=INTEGER}");
        
        ServiceProjectHistoryEntityExample example = (ServiceProjectHistoryEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ServiceProjectHistoryEntity record) {
        BEGIN();
        UPDATE("service_pro_history");
        
        if (record.getMainTitle() != null) {
            SET("mainTitle = #{mainTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getSubTitle() != null) {
            SET("subTitle = #{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTypeId() != null) {
            SET("serviceTypeId = #{serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServerGrade() != null) {
            SET("serverGrade = #{serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGrade() != null) {
            SET("serviceGrade = #{serviceGrade,jdbcType=INTEGER}");
        }
        
        if (record.getServiceGradeId() != null) {
            SET("serviceGradeId = #{serviceGradeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceGradeName() != null) {
            SET("serviceGradeName = #{serviceGradeName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportApply() != null) {
            SET("supportApply = #{supportApply,jdbcType=BIT}");
        }
        
        if (record.getApplyViewId() != null) {
            SET("applyViewId = #{applyViewId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportOrder() != null) {
            SET("supportOrder = #{supportOrder,jdbcType=BIT}");
        }
        
        if (record.getOrderViewId() != null) {
            SET("orderViewId = #{orderViewId,jdbcType=BIGINT}");
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
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            SET("approvalText = #{approvalText,jdbcType=VARCHAR}");
        }
        
        if (record.getParkProId() != null) {
            SET("parkProId = #{parkProId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCityId() != null) {
            SET("parkCityId = #{parkCityId,jdbcType=BIGINT}");
        }
        
        if (record.getParkCounId() != null) {
            SET("parkCounId = #{parkCounId,jdbcType=BIGINT}");
        }
        
        if (record.getParkLocationId() != null) {
            SET("parkLocationId = #{parkLocationId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyOrderNum() != null) {
            SET("applyOrderNum = #{applyOrderNum,jdbcType=INTEGER}");
        }
        
        if (record.getCollectNum() != null) {
            SET("collectNum = #{collectNum,jdbcType=INTEGER}");
        }
        
        if (record.getReadNum() != null) {
            SET("readNum = #{readNum,jdbcType=INTEGER}");
        }
        
        if (record.getCommentNum() != null) {
            SET("commentNum = #{commentNum,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceProRelease() != null) {
            SET("serviceProRelease = #{serviceProRelease,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ServiceProjectHistoryEntityExample example, boolean includeExamplePhrase) {
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