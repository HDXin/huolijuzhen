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

import com.sudaotech.huolijuzhen.dao.ResourceInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample.Criterion;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample;
import java.util.List;
import java.util.Map;

public class ResourceInfoEntitySqlProvider {

    public String countByExample(ResourceInfoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("resource_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ResourceInfoEntityExample example) {
        BEGIN();
        DELETE_FROM("resource_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ResourceInfoEntity record) {
        BEGIN();
        INSERT_INTO("resource_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getIsRoot() != null) {
            VALUES("isRoot", "#{isRoot,jdbcType=BIT}");
        }
        
        if (record.getResInfoId() != null) {
            VALUES("resInfoId", "#{resInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getTierId() != null) {
            VALUES("tierId", "#{tierId,jdbcType=BIGINT}");
        }
        
        if (record.getTierName() != null) {
            VALUES("tierName", "#{tierName,jdbcType=VARCHAR}");
        }
        
        if (record.getTierNum() != null) {
            VALUES("tierNum", "#{tierNum,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getGardenId() != null) {
            VALUES("gardenId", "#{gardenId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parentId", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getIsSeat() != null) {
            VALUES("isSeat", "#{isSeat,jdbcType=BIT}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("area", "#{area,jdbcType=DOUBLE}");
        }
        
        if (record.getDeleteBy() != null) {
            VALUES("deleteBy", "#{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            VALUES("deleteTime", "#{deleteTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getContId() != null) {
            VALUES("contId", "#{contId,jdbcType=BIGINT}");
        }
        
        if (record.getUseStatus() != null) {
            VALUES("useStatus", "#{useStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    public String selectByExample(ResourceInfoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("isRoot");
        SELECT("resInfoId");
        SELECT("tierId");
        SELECT("tierName");
        SELECT("tierNum");
        SELECT("name");
        SELECT("description");
        SELECT("gardenId");
        SELECT("parentId");
        SELECT("isSeat");
        SELECT("code");
        SELECT("area");
        SELECT("deleteBy");
        SELECT("deleteTime");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("contId");
        SELECT("useStatus");
        SELECT("price");
        FROM("resource_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ResourceInfoEntity record = (ResourceInfoEntity) parameter.get("record");
        ResourceInfoEntityExample example = (ResourceInfoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("resource_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getIsRoot() != null) {
            SET("isRoot = #{record.isRoot,jdbcType=BIT}");
        }
        
        if (record.getResInfoId() != null) {
            SET("resInfoId = #{record.resInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getTierId() != null) {
            SET("tierId = #{record.tierId,jdbcType=BIGINT}");
        }
        
        if (record.getTierName() != null) {
            SET("tierName = #{record.tierName,jdbcType=VARCHAR}");
        }
        
        if (record.getTierNum() != null) {
            SET("tierNum = #{record.tierNum,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getGardenId() != null) {
            SET("gardenId = #{record.gardenId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            SET("parentId = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getIsSeat() != null) {
            SET("isSeat = #{record.isSeat,jdbcType=BIT}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{record.area,jdbcType=DOUBLE}");
        }
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getContId() != null) {
            SET("contId = #{record.contId,jdbcType=BIGINT}");
        }
        
        if (record.getUseStatus() != null) {
            SET("useStatus = #{record.useStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("resource_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("isRoot = #{record.isRoot,jdbcType=BIT}");
        SET("resInfoId = #{record.resInfoId,jdbcType=BIGINT}");
        SET("tierId = #{record.tierId,jdbcType=BIGINT}");
        SET("tierName = #{record.tierName,jdbcType=VARCHAR}");
        SET("tierNum = #{record.tierNum,jdbcType=INTEGER}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        SET("gardenId = #{record.gardenId,jdbcType=BIGINT}");
        SET("parentId = #{record.parentId,jdbcType=BIGINT}");
        SET("isSeat = #{record.isSeat,jdbcType=BIT}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("area = #{record.area,jdbcType=DOUBLE}");
        SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("contId = #{record.contId,jdbcType=BIGINT}");
        SET("useStatus = #{record.useStatus,jdbcType=INTEGER}");
        SET("price = #{record.price,jdbcType=DECIMAL}");
        
        ResourceInfoEntityExample example = (ResourceInfoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResourceInfoEntity record) {
        BEGIN();
        UPDATE("resource_info");
        
        if (record.getIsRoot() != null) {
            SET("isRoot = #{isRoot,jdbcType=BIT}");
        }
        
        if (record.getResInfoId() != null) {
            SET("resInfoId = #{resInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getTierId() != null) {
            SET("tierId = #{tierId,jdbcType=BIGINT}");
        }
        
        if (record.getTierName() != null) {
            SET("tierName = #{tierName,jdbcType=VARCHAR}");
        }
        
        if (record.getTierNum() != null) {
            SET("tierNum = #{tierNum,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getGardenId() != null) {
            SET("gardenId = #{gardenId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            SET("parentId = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getIsSeat() != null) {
            SET("isSeat = #{isSeat,jdbcType=BIT}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{area,jdbcType=DOUBLE}");
        }
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{deleteTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getContId() != null) {
            SET("contId = #{contId,jdbcType=BIGINT}");
        }
        
        if (record.getUseStatus() != null) {
            SET("useStatus = #{useStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ResourceInfoEntityExample example, boolean includeExamplePhrase) {
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