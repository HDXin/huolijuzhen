package com.sudaotech.huolijuzhen.approval.dao;

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

import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample.Criterion;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample;
import java.util.List;
import java.util.Map;

public class ApprovalRecordEntitySqlProvider {

    public String countByExample(ApprovalRecordEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("approval_record");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ApprovalRecordEntityExample example) {
        BEGIN();
        DELETE_FROM("approval_record");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ApprovalRecordEntity record) {
        BEGIN();
        INSERT_INTO("approval_record");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalType() != null) {
            VALUES("approvalType", "#{approvalType,jdbcType=INTEGER}");
        }
        
        if (record.getMainId() != null) {
            VALUES("mainId", "#{mainId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemId() != null) {
            VALUES("approvalItemId", "#{approvalItemId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemName() != null) {
            VALUES("approvalItemName", "#{approvalItemName,jdbcType=VARCHAR}");
        }
        
        if (record.getApprovalItemNo() != null) {
            VALUES("approvalItemNo", "#{approvalItemNo,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalItemVersion() != null) {
            VALUES("approvalItemVersion", "#{approvalItemVersion,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalId() != null) {
            VALUES("approvalId", "#{approvalId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalName() != null) {
            VALUES("approvalName", "#{approvalName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassStatus() != null) {
            VALUES("passStatus", "#{passStatus,jdbcType=BIT}");
        }
        
        if (record.getApprovalMemo() != null) {
            VALUES("approvalMemo", "#{approvalMemo,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(ApprovalRecordEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("approvalType");
        SELECT("mainId");
        SELECT("approvalItemId");
        SELECT("approvalItemName");
        SELECT("approvalItemNo");
        SELECT("approvalItemVersion");
        SELECT("approvalId");
        SELECT("approvalName");
        SELECT("passStatus");
        SELECT("approvalMemo");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("approval_record");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ApprovalRecordEntity record = (ApprovalRecordEntity) parameter.get("record");
        ApprovalRecordEntityExample example = (ApprovalRecordEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("approval_record");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalType() != null) {
            SET("approvalType = #{record.approvalType,jdbcType=INTEGER}");
        }
        
        if (record.getMainId() != null) {
            SET("mainId = #{record.mainId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemId() != null) {
            SET("approvalItemId = #{record.approvalItemId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemName() != null) {
            SET("approvalItemName = #{record.approvalItemName,jdbcType=VARCHAR}");
        }
        
        if (record.getApprovalItemNo() != null) {
            SET("approvalItemNo = #{record.approvalItemNo,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalItemVersion() != null) {
            SET("approvalItemVersion = #{record.approvalItemVersion,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalId() != null) {
            SET("approvalId = #{record.approvalId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalName() != null) {
            SET("approvalName = #{record.approvalName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassStatus() != null) {
            SET("passStatus = #{record.passStatus,jdbcType=BIT}");
        }
        
        if (record.getApprovalMemo() != null) {
            SET("approvalMemo = #{record.approvalMemo,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("approval_record");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("approvalType = #{record.approvalType,jdbcType=INTEGER}");
        SET("mainId = #{record.mainId,jdbcType=BIGINT}");
        SET("approvalItemId = #{record.approvalItemId,jdbcType=BIGINT}");
        SET("approvalItemName = #{record.approvalItemName,jdbcType=VARCHAR}");
        SET("approvalItemNo = #{record.approvalItemNo,jdbcType=INTEGER}");
        SET("approvalItemVersion = #{record.approvalItemVersion,jdbcType=INTEGER}");
        SET("approvalId = #{record.approvalId,jdbcType=BIGINT}");
        SET("approvalName = #{record.approvalName,jdbcType=VARCHAR}");
        SET("passStatus = #{record.passStatus,jdbcType=BIT}");
        SET("approvalMemo = #{record.approvalMemo,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        ApprovalRecordEntityExample example = (ApprovalRecordEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ApprovalRecordEntity record) {
        BEGIN();
        UPDATE("approval_record");
        
        if (record.getApprovalType() != null) {
            SET("approvalType = #{approvalType,jdbcType=INTEGER}");
        }
        
        if (record.getMainId() != null) {
            SET("mainId = #{mainId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemId() != null) {
            SET("approvalItemId = #{approvalItemId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalItemName() != null) {
            SET("approvalItemName = #{approvalItemName,jdbcType=VARCHAR}");
        }
        
        if (record.getApprovalItemNo() != null) {
            SET("approvalItemNo = #{approvalItemNo,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalItemVersion() != null) {
            SET("approvalItemVersion = #{approvalItemVersion,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalId() != null) {
            SET("approvalId = #{approvalId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalName() != null) {
            SET("approvalName = #{approvalName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassStatus() != null) {
            SET("passStatus = #{passStatus,jdbcType=BIT}");
        }
        
        if (record.getApprovalMemo() != null) {
            SET("approvalMemo = #{approvalMemo,jdbcType=VARCHAR}");
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
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ApprovalRecordEntityExample example, boolean includeExamplePhrase) {
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