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

import com.sudaotech.huolijuzhen.dao.ResInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample.Criterion;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample;
import java.util.List;
import java.util.Map;

public class ResInfoEntitySqlProvider {

    public String countByExample(ResInfoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("res_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ResInfoEntityExample example) {
        BEGIN();
        DELETE_FROM("res_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ResInfoEntity record) {
        BEGIN();
        INSERT_INTO("res_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getResType() != null) {
            VALUES("resType", "#{resType,jdbcType=INTEGER}");
        }
        
        if (record.getEnableStatus() != null) {
            VALUES("enableStatus", "#{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGardenId() != null) {
            VALUES("gardenId", "#{gardenId,jdbcType=BIGINT}");
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
        
        if (record.getStartBy() != null) {
            VALUES("startBy", "#{startBy,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            VALUES("startTime", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            VALUES("closeBy", "#{closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            VALUES("closeTime", "#{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCalcDimension() != null) {
            VALUES("calcDimension", "#{calcDimension,jdbcType=INTEGER}");
        }
        
        if (record.getEnableAvg() != null) {
            VALUES("enableAvg", "#{enableAvg,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(ResInfoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("code");
        SELECT("resType");
        SELECT("enableStatus");
        SELECT("gardenId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("startBy");
        SELECT("startTime");
        SELECT("closeBy");
        SELECT("closeTime");
        SELECT("calcDimension");
        SELECT("enableAvg");
        FROM("res_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ResInfoEntity record = (ResInfoEntity) parameter.get("record");
        ResInfoEntityExample example = (ResInfoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("res_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getResType() != null) {
            SET("resType = #{record.resType,jdbcType=INTEGER}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGardenId() != null) {
            SET("gardenId = #{record.gardenId,jdbcType=BIGINT}");
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
        
        if (record.getStartBy() != null) {
            SET("startBy = #{record.startBy,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            SET("startTime = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            SET("closeBy = #{record.closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            SET("closeTime = #{record.closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCalcDimension() != null) {
            SET("calcDimension = #{record.calcDimension,jdbcType=INTEGER}");
        }
        
        if (record.getEnableAvg() != null) {
            SET("enableAvg = #{record.enableAvg,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("res_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("resType = #{record.resType,jdbcType=INTEGER}");
        SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        SET("gardenId = #{record.gardenId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("startBy = #{record.startBy,jdbcType=BIGINT}");
        SET("startTime = #{record.startTime,jdbcType=TIMESTAMP}");
        SET("closeBy = #{record.closeBy,jdbcType=BIGINT}");
        SET("closeTime = #{record.closeTime,jdbcType=TIMESTAMP}");
        SET("calcDimension = #{record.calcDimension,jdbcType=INTEGER}");
        SET("enableAvg = #{record.enableAvg,jdbcType=INTEGER}");
        
        ResInfoEntityExample example = (ResInfoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResInfoEntity record) {
        BEGIN();
        UPDATE("res_info");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getResType() != null) {
            SET("resType = #{resType,jdbcType=INTEGER}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGardenId() != null) {
            SET("gardenId = #{gardenId,jdbcType=BIGINT}");
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
        
        if (record.getStartBy() != null) {
            SET("startBy = #{startBy,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            SET("startTime = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCloseBy() != null) {
            SET("closeBy = #{closeBy,jdbcType=BIGINT}");
        }
        
        if (record.getCloseTime() != null) {
            SET("closeTime = #{closeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCalcDimension() != null) {
            SET("calcDimension = #{calcDimension,jdbcType=INTEGER}");
        }
        
        if (record.getEnableAvg() != null) {
            SET("enableAvg = #{enableAvg,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ResInfoEntityExample example, boolean includeExamplePhrase) {
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