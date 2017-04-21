package com.sudaotech.huolijuzhen.transaction.dao;

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

import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntity;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample.Criterion;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample;
import java.util.List;
import java.util.Map;

public class TransactionRecordEntitySqlProvider {

    public String countByExample(TransactionRecordEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("transaction_record");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TransactionRecordEntityExample example) {
        BEGIN();
        DELETE_FROM("transaction_record");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TransactionRecordEntity record) {
        BEGIN();
        INSERT_INTO("transaction_record");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            VALUES("userId", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getTransactionAmount() != null) {
            VALUES("transactionAmount", "#{transactionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTransactionTime() != null) {
            VALUES("transactionTime", "#{transactionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransactionDirection() != null) {
            VALUES("transactionDirection", "#{transactionDirection,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionType() != null) {
            VALUES("transactionType", "#{transactionType,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionStatus() != null) {
            VALUES("transactionStatus", "#{transactionStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            VALUES("payChannel", "#{payChannel,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromType() != null) {
            VALUES("transferFromType", "#{transferFromType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromId() != null) {
            VALUES("transferFromId", "#{transferFromId,jdbcType=BIGINT}");
        }
        
        if (record.getTransferToType() != null) {
            VALUES("transferToType", "#{transferToType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferToId() != null) {
            VALUES("transferToId", "#{transferToId,jdbcType=BIGINT}");
        }
        
        if (record.getBizType() != null) {
            VALUES("bizType", "#{bizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            VALUES("bizId", "#{bizId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            VALUES("orderNo", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeNo() != null) {
            VALUES("tradeNo", "#{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerEmail() != null) {
            VALUES("buyerEmail", "#{buyerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            VALUES("buyerId", "#{buyerId,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(TransactionRecordEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("userId");
        SELECT("transactionAmount");
        SELECT("transactionTime");
        SELECT("transactionDirection");
        SELECT("transactionType");
        SELECT("transactionStatus");
        SELECT("payChannel");
        SELECT("transferFromType");
        SELECT("transferFromId");
        SELECT("transferToType");
        SELECT("transferToId");
        SELECT("bizType");
        SELECT("bizId");
        SELECT("orderNo");
        SELECT("explanation");
        SELECT("tradeNo");
        SELECT("buyerEmail");
        SELECT("buyerId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("createName");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("transaction_record");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TransactionRecordEntity record = (TransactionRecordEntity) parameter.get("record");
        TransactionRecordEntityExample example = (TransactionRecordEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("transaction_record");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            SET("userId = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getTransactionAmount() != null) {
            SET("transactionAmount = #{record.transactionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTransactionTime() != null) {
            SET("transactionTime = #{record.transactionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransactionDirection() != null) {
            SET("transactionDirection = #{record.transactionDirection,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionType() != null) {
            SET("transactionType = #{record.transactionType,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionStatus() != null) {
            SET("transactionStatus = #{record.transactionStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            SET("payChannel = #{record.payChannel,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromType() != null) {
            SET("transferFromType = #{record.transferFromType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromId() != null) {
            SET("transferFromId = #{record.transferFromId,jdbcType=BIGINT}");
        }
        
        if (record.getTransferToType() != null) {
            SET("transferToType = #{record.transferToType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferToId() != null) {
            SET("transferToId = #{record.transferToId,jdbcType=BIGINT}");
        }
        
        if (record.getBizType() != null) {
            SET("bizType = #{record.bizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            SET("bizId = #{record.bizId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            SET("orderNo = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExplanation() != null) {
            SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeNo() != null) {
            SET("tradeNo = #{record.tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerEmail() != null) {
            SET("buyerEmail = #{record.buyerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            SET("buyerId = #{record.buyerId,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("transaction_record");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("userId = #{record.userId,jdbcType=BIGINT}");
        SET("transactionAmount = #{record.transactionAmount,jdbcType=DECIMAL}");
        SET("transactionTime = #{record.transactionTime,jdbcType=TIMESTAMP}");
        SET("transactionDirection = #{record.transactionDirection,jdbcType=INTEGER}");
        SET("transactionType = #{record.transactionType,jdbcType=INTEGER}");
        SET("transactionStatus = #{record.transactionStatus,jdbcType=INTEGER}");
        SET("payChannel = #{record.payChannel,jdbcType=INTEGER}");
        SET("transferFromType = #{record.transferFromType,jdbcType=INTEGER}");
        SET("transferFromId = #{record.transferFromId,jdbcType=BIGINT}");
        SET("transferToType = #{record.transferToType,jdbcType=INTEGER}");
        SET("transferToId = #{record.transferToId,jdbcType=BIGINT}");
        SET("bizType = #{record.bizType,jdbcType=INTEGER}");
        SET("bizId = #{record.bizId,jdbcType=VARCHAR}");
        SET("orderNo = #{record.orderNo,jdbcType=VARCHAR}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("tradeNo = #{record.tradeNo,jdbcType=VARCHAR}");
        SET("buyerEmail = #{record.buyerEmail,jdbcType=VARCHAR}");
        SET("buyerId = #{record.buyerId,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("createName = #{record.createName,jdbcType=VARCHAR}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        TransactionRecordEntityExample example = (TransactionRecordEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TransactionRecordEntity record) {
        BEGIN();
        UPDATE("transaction_record");
        
        if (record.getUserId() != null) {
            SET("userId = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getTransactionAmount() != null) {
            SET("transactionAmount = #{transactionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTransactionTime() != null) {
            SET("transactionTime = #{transactionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransactionDirection() != null) {
            SET("transactionDirection = #{transactionDirection,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionType() != null) {
            SET("transactionType = #{transactionType,jdbcType=INTEGER}");
        }
        
        if (record.getTransactionStatus() != null) {
            SET("transactionStatus = #{transactionStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            SET("payChannel = #{payChannel,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromType() != null) {
            SET("transferFromType = #{transferFromType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferFromId() != null) {
            SET("transferFromId = #{transferFromId,jdbcType=BIGINT}");
        }
        
        if (record.getTransferToType() != null) {
            SET("transferToType = #{transferToType,jdbcType=INTEGER}");
        }
        
        if (record.getTransferToId() != null) {
            SET("transferToId = #{transferToId,jdbcType=BIGINT}");
        }
        
        if (record.getBizType() != null) {
            SET("bizType = #{bizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            SET("bizId = #{bizId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            SET("orderNo = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExplanation() != null) {
            SET("explanation = #{explanation,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeNo() != null) {
            SET("tradeNo = #{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerEmail() != null) {
            SET("buyerEmail = #{buyerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            SET("buyerId = #{buyerId,jdbcType=VARCHAR}");
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
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(TransactionRecordEntityExample example, boolean includeExamplePhrase) {
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