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

import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class ApplyOrderEntitySqlProvider {

    public String countByExample(ApplyOrderEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("apply_order_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ApplyOrderEntityExample example) {
        BEGIN();
        DELETE_FROM("apply_order_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ApplyOrderEntity record) {
        BEGIN();
        INSERT_INTO("apply_order_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getApplyOrderNo() != null) {
            VALUES("applyOrderNo", "#{applyOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderType() != null) {
            VALUES("applyOrderType", "#{applyOrderType,jdbcType=INTEGER}");
        }
        
        if (record.getApplyOrderStatus() != null) {
            VALUES("applyOrderStatus", "#{applyOrderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceProId() != null) {
            VALUES("serviceProId", "#{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseId() != null) {
            VALUES("enterpriseId", "#{enterpriseId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseName() != null) {
            VALUES("enterpriseName", "#{enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderStatusMemo() != null) {
            VALUES("applyOrderStatusMemo", "#{applyOrderStatusMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillHistoryId() != null) {
            VALUES("billHistoryId", "#{billHistoryId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderMemo() != null) {
            VALUES("orderMemo", "#{orderMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitle() != null) {
            VALUES("priceTitle", "#{priceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentId() != null) {
            VALUES("commentId", "#{commentId,jdbcType=BIGINT}");
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
        
        if (record.getPayWay() != null) {
            VALUES("payWay", "#{payWay,jdbcType=INTEGER}");
        }
        
        if (record.getServiceProRelease() != null) {
            VALUES("serviceProRelease", "#{serviceProRelease,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ApplyOrderEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("applyOrderNo");
        SELECT("applyOrderType");
        SELECT("applyOrderStatus");
        SELECT("serviceProId");
        SELECT("enterpriseId");
        SELECT("enterpriseName");
        SELECT("applyOrderStatusMemo");
        SELECT("billHistoryId");
        SELECT("orderMemo");
        SELECT("priceTitle");
        SELECT("price");
        SELECT("commentId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("payWay");
        SELECT("serviceProRelease");
        SELECT("content");
        FROM("apply_order_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ApplyOrderEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("applyOrderNo");
        SELECT("applyOrderType");
        SELECT("applyOrderStatus");
        SELECT("serviceProId");
        SELECT("enterpriseId");
        SELECT("enterpriseName");
        SELECT("applyOrderStatusMemo");
        SELECT("billHistoryId");
        SELECT("orderMemo");
        SELECT("priceTitle");
        SELECT("price");
        SELECT("commentId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("payWay");
        SELECT("serviceProRelease");
        FROM("apply_order_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ApplyOrderEntity record = (ApplyOrderEntity) parameter.get("record");
        ApplyOrderEntityExample example = (ApplyOrderEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("apply_order_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getApplyOrderNo() != null) {
            SET("applyOrderNo = #{record.applyOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderType() != null) {
            SET("applyOrderType = #{record.applyOrderType,jdbcType=INTEGER}");
        }
        
        if (record.getApplyOrderStatus() != null) {
            SET("applyOrderStatus = #{record.applyOrderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseId() != null) {
            SET("enterpriseId = #{record.enterpriseId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseName() != null) {
            SET("enterpriseName = #{record.enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderStatusMemo() != null) {
            SET("applyOrderStatusMemo = #{record.applyOrderStatusMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillHistoryId() != null) {
            SET("billHistoryId = #{record.billHistoryId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderMemo() != null) {
            SET("orderMemo = #{record.orderMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitle() != null) {
            SET("priceTitle = #{record.priceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentId() != null) {
            SET("commentId = #{record.commentId,jdbcType=BIGINT}");
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
        
        if (record.getPayWay() != null) {
            SET("payWay = #{record.payWay,jdbcType=INTEGER}");
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
        UPDATE("apply_order_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("applyOrderNo = #{record.applyOrderNo,jdbcType=VARCHAR}");
        SET("applyOrderType = #{record.applyOrderType,jdbcType=INTEGER}");
        SET("applyOrderStatus = #{record.applyOrderStatus,jdbcType=INTEGER}");
        SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        SET("enterpriseId = #{record.enterpriseId,jdbcType=BIGINT}");
        SET("enterpriseName = #{record.enterpriseName,jdbcType=VARCHAR}");
        SET("applyOrderStatusMemo = #{record.applyOrderStatusMemo,jdbcType=VARCHAR}");
        SET("billHistoryId = #{record.billHistoryId,jdbcType=BIGINT}");
        SET("orderMemo = #{record.orderMemo,jdbcType=VARCHAR}");
        SET("priceTitle = #{record.priceTitle,jdbcType=VARCHAR}");
        SET("price = #{record.price,jdbcType=DECIMAL}");
        SET("commentId = #{record.commentId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("payWay = #{record.payWay,jdbcType=INTEGER}");
        SET("serviceProRelease = #{record.serviceProRelease,jdbcType=INTEGER}");
        SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        ApplyOrderEntityExample example = (ApplyOrderEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("apply_order_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("applyOrderNo = #{record.applyOrderNo,jdbcType=VARCHAR}");
        SET("applyOrderType = #{record.applyOrderType,jdbcType=INTEGER}");
        SET("applyOrderStatus = #{record.applyOrderStatus,jdbcType=INTEGER}");
        SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        SET("enterpriseId = #{record.enterpriseId,jdbcType=BIGINT}");
        SET("enterpriseName = #{record.enterpriseName,jdbcType=VARCHAR}");
        SET("applyOrderStatusMemo = #{record.applyOrderStatusMemo,jdbcType=VARCHAR}");
        SET("billHistoryId = #{record.billHistoryId,jdbcType=BIGINT}");
        SET("orderMemo = #{record.orderMemo,jdbcType=VARCHAR}");
        SET("priceTitle = #{record.priceTitle,jdbcType=VARCHAR}");
        SET("price = #{record.price,jdbcType=DECIMAL}");
        SET("commentId = #{record.commentId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("payWay = #{record.payWay,jdbcType=INTEGER}");
        SET("serviceProRelease = #{record.serviceProRelease,jdbcType=INTEGER}");
        
        ApplyOrderEntityExample example = (ApplyOrderEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ApplyOrderEntity record) {
        BEGIN();
        UPDATE("apply_order_info");
        
        if (record.getApplyOrderNo() != null) {
            SET("applyOrderNo = #{applyOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderType() != null) {
            SET("applyOrderType = #{applyOrderType,jdbcType=INTEGER}");
        }
        
        if (record.getApplyOrderStatus() != null) {
            SET("applyOrderStatus = #{applyOrderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseId() != null) {
            SET("enterpriseId = #{enterpriseId,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseName() != null) {
            SET("enterpriseName = #{enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyOrderStatusMemo() != null) {
            SET("applyOrderStatusMemo = #{applyOrderStatusMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillHistoryId() != null) {
            SET("billHistoryId = #{billHistoryId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderMemo() != null) {
            SET("orderMemo = #{orderMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitle() != null) {
            SET("priceTitle = #{priceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentId() != null) {
            SET("commentId = #{commentId,jdbcType=BIGINT}");
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
        
        if (record.getPayWay() != null) {
            SET("payWay = #{payWay,jdbcType=INTEGER}");
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

    protected void applyWhere(ApplyOrderEntityExample example, boolean includeExamplePhrase) {
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