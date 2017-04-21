package com.sudaotech.huolijuzhen.bill.dao;

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

import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample.Criterion;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample;
import java.util.List;
import java.util.Map;

public class BillCollectionRecordEntitySqlProvider {

    public String countByExample(BillCollectionRecordEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bill_collection_record");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BillCollectionRecordEntityExample example) {
        BEGIN();
        DELETE_FROM("bill_collection_record");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BillCollectionRecordEntity record) {
        BEGIN();
        INSERT_INTO("bill_collection_record");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            VALUES("billId", "#{billId,jdbcType=BIGINT}");
        }
        
        if (record.getCollectionTime() != null) {
            VALUES("collectionTime", "#{collectionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectionBank() != null) {
            VALUES("collectionBank", "#{collectionBank,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAccount() != null) {
            VALUES("collectionAccount", "#{collectionAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAmount() != null) {
            VALUES("collectionAmount", "#{collectionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayChannels() != null) {
            VALUES("payChannels", "#{payChannels,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNum() != null) {
            VALUES("paySerialNum", "#{paySerialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
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

    public String selectByExample(BillCollectionRecordEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("billId");
        SELECT("collectionTime");
        SELECT("collectionBank");
        SELECT("collectionAccount");
        SELECT("collectionAmount");
        SELECT("payChannels");
        SELECT("paySerialNum");
        SELECT("remark");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("bill_collection_record");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BillCollectionRecordEntity record = (BillCollectionRecordEntity) parameter.get("record");
        BillCollectionRecordEntityExample example = (BillCollectionRecordEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bill_collection_record");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            SET("billId = #{record.billId,jdbcType=BIGINT}");
        }
        
        if (record.getCollectionTime() != null) {
            SET("collectionTime = #{record.collectionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectionBank() != null) {
            SET("collectionBank = #{record.collectionBank,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAccount() != null) {
            SET("collectionAccount = #{record.collectionAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAmount() != null) {
            SET("collectionAmount = #{record.collectionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayChannels() != null) {
            SET("payChannels = #{record.payChannels,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNum() != null) {
            SET("paySerialNum = #{record.paySerialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
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
        UPDATE("bill_collection_record");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("billId = #{record.billId,jdbcType=BIGINT}");
        SET("collectionTime = #{record.collectionTime,jdbcType=TIMESTAMP}");
        SET("collectionBank = #{record.collectionBank,jdbcType=VARCHAR}");
        SET("collectionAccount = #{record.collectionAccount,jdbcType=VARCHAR}");
        SET("collectionAmount = #{record.collectionAmount,jdbcType=DECIMAL}");
        SET("payChannels = #{record.payChannels,jdbcType=VARCHAR}");
        SET("paySerialNum = #{record.paySerialNum,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        BillCollectionRecordEntityExample example = (BillCollectionRecordEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BillCollectionRecordEntity record) {
        BEGIN();
        UPDATE("bill_collection_record");
        
        if (record.getBillId() != null) {
            SET("billId = #{billId,jdbcType=BIGINT}");
        }
        
        if (record.getCollectionTime() != null) {
            SET("collectionTime = #{collectionTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectionBank() != null) {
            SET("collectionBank = #{collectionBank,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAccount() != null) {
            SET("collectionAccount = #{collectionAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCollectionAmount() != null) {
            SET("collectionAmount = #{collectionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayChannels() != null) {
            SET("payChannels = #{payChannels,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySerialNum() != null) {
            SET("paySerialNum = #{paySerialNum,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
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

    protected void applyWhere(BillCollectionRecordEntityExample example, boolean includeExamplePhrase) {
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