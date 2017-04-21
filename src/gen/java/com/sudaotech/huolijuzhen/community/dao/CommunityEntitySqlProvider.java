package com.sudaotech.huolijuzhen.community.dao;

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

import com.sudaotech.huolijuzhen.community.dao.CommunityEntityExample.Criteria;
import com.sudaotech.huolijuzhen.community.dao.CommunityEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class CommunityEntitySqlProvider {

    public String countByExample(CommunityEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("community_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CommunityEntityExample example) {
        BEGIN();
        DELETE_FROM("community_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CommunityEntityWithBLOBs record) {
        BEGIN();
        INSERT_INTO("community_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscrible() != null) {
            VALUES("discrible", "#{discrible,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublicGrade() != null) {
            VALUES("publicGrade", "#{publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            VALUES("proId", "#{proId,jdbcType=CHAR}");
        }
        
        if (record.getCityId() != null) {
            VALUES("cityId", "#{cityId,jdbcType=CHAR}");
        }
        
        if (record.getCounId() != null) {
            VALUES("counId", "#{counId,jdbcType=CHAR}");
        }
        
        if (record.getLocationId() != null) {
            VALUES("locationId", "#{locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            VALUES("approvalStatus", "#{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            VALUES("approvalBy", "#{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            VALUES("approvalTime", "#{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalMemo() != null) {
            VALUES("approvalMemo", "#{approvalMemo,jdbcType=VARCHAR}");
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
        
        if (record.getDeleteBy() != null) {
            VALUES("deleteBy", "#{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            VALUES("deleteTime", "#{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateSide() != null) {
            VALUES("createSide", "#{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            VALUES("createSideId", "#{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateBy() != null) {
            VALUES("terminateBy", "#{terminateBy,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateTime() != null) {
            VALUES("terminateTime", "#{terminateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getOperatorHistory() != null) {
            VALUES("operatorHistory", "#{operatorHistory,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(CommunityEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("discrible");
        SELECT("time");
        SELECT("publicGrade");
        SELECT("parkId");
        SELECT("proId");
        SELECT("cityId");
        SELECT("counId");
        SELECT("locationId");
        SELECT("approvalStatus");
        SELECT("version");
        SELECT("status");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalMemo");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("deleteBy");
        SELECT("deleteTime");
        SELECT("createSide");
        SELECT("createSideId");
        SELECT("terminateBy");
        SELECT("terminateTime");
        SELECT("content");
        SELECT("operatorHistory");
        FROM("community_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(CommunityEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("discrible");
        SELECT("time");
        SELECT("publicGrade");
        SELECT("parkId");
        SELECT("proId");
        SELECT("cityId");
        SELECT("counId");
        SELECT("locationId");
        SELECT("approvalStatus");
        SELECT("version");
        SELECT("status");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalMemo");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("deleteBy");
        SELECT("deleteTime");
        SELECT("createSide");
        SELECT("createSideId");
        SELECT("terminateBy");
        SELECT("terminateTime");
        FROM("community_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityEntityWithBLOBs record = (CommunityEntityWithBLOBs) parameter.get("record");
        CommunityEntityExample example = (CommunityEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("community_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscrible() != null) {
            SET("discrible = #{record.discrible,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublicGrade() != null) {
            SET("publicGrade = #{record.publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            SET("proId = #{record.proId,jdbcType=CHAR}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{record.cityId,jdbcType=CHAR}");
        }
        
        if (record.getCounId() != null) {
            SET("counId = #{record.counId,jdbcType=CHAR}");
        }
        
        if (record.getLocationId() != null) {
            SET("locationId = #{record.locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalMemo() != null) {
            SET("approvalMemo = #{record.approvalMemo,jdbcType=VARCHAR}");
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
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateBy() != null) {
            SET("terminateBy = #{record.terminateBy,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateTime() != null) {
            SET("terminateTime = #{record.terminateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getOperatorHistory() != null) {
            SET("operatorHistory = #{record.operatorHistory,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("community_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("discrible = #{record.discrible,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("publicGrade = #{record.publicGrade,jdbcType=INTEGER}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("proId = #{record.proId,jdbcType=CHAR}");
        SET("cityId = #{record.cityId,jdbcType=CHAR}");
        SET("counId = #{record.counId,jdbcType=CHAR}");
        SET("locationId = #{record.locationId,jdbcType=BIGINT}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalMemo = #{record.approvalMemo,jdbcType=VARCHAR}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        SET("terminateBy = #{record.terminateBy,jdbcType=BIGINT}");
        SET("terminateTime = #{record.terminateTime,jdbcType=TIMESTAMP}");
        SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        SET("operatorHistory = #{record.operatorHistory,jdbcType=LONGVARCHAR}");
        
        CommunityEntityExample example = (CommunityEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("community_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("discrible = #{record.discrible,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("publicGrade = #{record.publicGrade,jdbcType=INTEGER}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("proId = #{record.proId,jdbcType=CHAR}");
        SET("cityId = #{record.cityId,jdbcType=CHAR}");
        SET("counId = #{record.counId,jdbcType=CHAR}");
        SET("locationId = #{record.locationId,jdbcType=BIGINT}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalMemo = #{record.approvalMemo,jdbcType=VARCHAR}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        SET("terminateBy = #{record.terminateBy,jdbcType=BIGINT}");
        SET("terminateTime = #{record.terminateTime,jdbcType=TIMESTAMP}");
        
        CommunityEntityExample example = (CommunityEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommunityEntityWithBLOBs record) {
        BEGIN();
        UPDATE("community_info");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscrible() != null) {
            SET("discrible = #{discrible,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublicGrade() != null) {
            SET("publicGrade = #{publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            SET("proId = #{proId,jdbcType=CHAR}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{cityId,jdbcType=CHAR}");
        }
        
        if (record.getCounId() != null) {
            SET("counId = #{counId,jdbcType=CHAR}");
        }
        
        if (record.getLocationId() != null) {
            SET("locationId = #{locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalMemo() != null) {
            SET("approvalMemo = #{approvalMemo,jdbcType=VARCHAR}");
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
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateBy() != null) {
            SET("terminateBy = #{terminateBy,jdbcType=BIGINT}");
        }
        
        if (record.getTerminateTime() != null) {
            SET("terminateTime = #{terminateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getOperatorHistory() != null) {
            SET("operatorHistory = #{operatorHistory,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CommunityEntityExample example, boolean includeExamplePhrase) {
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