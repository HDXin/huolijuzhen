package com.sudaotech.huolijuzhen.dao;

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

import com.sudaotech.huolijuzhen.dao.MessageEntity;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample.Criterion;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample;
import java.util.List;
import java.util.Map;

public class MessageEntitySqlProvider {

    public String countByExample(MessageEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("message");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MessageEntityExample example) {
        BEGIN();
        DELETE_FROM("message");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(MessageEntity record) {
        BEGIN();
        INSERT_INTO("message");
        
        if (record.getMsgId() != null) {
            VALUES("msgId", "#{msgId,jdbcType=BIGINT}");
        }
        
        if (record.getMsgBizType() != null) {
            VALUES("msgBizType", "#{msgBizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            VALUES("bizId", "#{bizId,jdbcType=BIGINT}");
        }
        
        if (record.getMsgType() != null) {
            VALUES("msgType", "#{msgType,jdbcType=INTEGER}");
        }
        
        if (record.getSrc() != null) {
            VALUES("src", "#{src,jdbcType=BIGINT}");
        }
        
        if (record.getDst() != null) {
            VALUES("dst", "#{dst,jdbcType=BIGINT}");
        }
        
        if (record.getMsgStatus() != null) {
            VALUES("msgStatus", "#{msgStatus,jdbcType=INTEGER}");
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
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getExtId() != null) {
            VALUES("extId", "#{extId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            VALUES("sourceType", "#{sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(MessageEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("msgId");
        } else {
            SELECT("msgId");
        }
        SELECT("msgBizType");
        SELECT("bizId");
        SELECT("msgType");
        SELECT("src");
        SELECT("dst");
        SELECT("msgStatus");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("content");
        SELECT("extId");
        SELECT("sourceType");
        SELECT("title");
        SELECT("parkId");
        FROM("message");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MessageEntity record = (MessageEntity) parameter.get("record");
        MessageEntityExample example = (MessageEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("message");
        
        if (record.getMsgId() != null) {
            SET("msgId = #{record.msgId,jdbcType=BIGINT}");
        }
        
        if (record.getMsgBizType() != null) {
            SET("msgBizType = #{record.msgBizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            SET("bizId = #{record.bizId,jdbcType=BIGINT}");
        }
        
        if (record.getMsgType() != null) {
            SET("msgType = #{record.msgType,jdbcType=INTEGER}");
        }
        
        if (record.getSrc() != null) {
            SET("src = #{record.src,jdbcType=BIGINT}");
        }
        
        if (record.getDst() != null) {
            SET("dst = #{record.dst,jdbcType=BIGINT}");
        }
        
        if (record.getMsgStatus() != null) {
            SET("msgStatus = #{record.msgStatus,jdbcType=INTEGER}");
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
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getExtId() != null) {
            SET("extId = #{record.extId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            SET("sourceType = #{record.sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("message");
        
        SET("msgId = #{record.msgId,jdbcType=BIGINT}");
        SET("msgBizType = #{record.msgBizType,jdbcType=INTEGER}");
        SET("bizId = #{record.bizId,jdbcType=BIGINT}");
        SET("msgType = #{record.msgType,jdbcType=INTEGER}");
        SET("src = #{record.src,jdbcType=BIGINT}");
        SET("dst = #{record.dst,jdbcType=BIGINT}");
        SET("msgStatus = #{record.msgStatus,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("content = #{record.content,jdbcType=VARCHAR}");
        SET("extId = #{record.extId,jdbcType=INTEGER}");
        SET("sourceType = #{record.sourceType,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        
        MessageEntityExample example = (MessageEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(MessageEntity record) {
        BEGIN();
        UPDATE("message");
        
        if (record.getMsgBizType() != null) {
            SET("msgBizType = #{msgBizType,jdbcType=INTEGER}");
        }
        
        if (record.getBizId() != null) {
            SET("bizId = #{bizId,jdbcType=BIGINT}");
        }
        
        if (record.getMsgType() != null) {
            SET("msgType = #{msgType,jdbcType=INTEGER}");
        }
        
        if (record.getSrc() != null) {
            SET("src = #{src,jdbcType=BIGINT}");
        }
        
        if (record.getDst() != null) {
            SET("dst = #{dst,jdbcType=BIGINT}");
        }
        
        if (record.getMsgStatus() != null) {
            SET("msgStatus = #{msgStatus,jdbcType=INTEGER}");
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
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getExtId() != null) {
            SET("extId = #{extId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            SET("sourceType = #{sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        WHERE("msgId = #{msgId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(MessageEntityExample example, boolean includeExamplePhrase) {
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