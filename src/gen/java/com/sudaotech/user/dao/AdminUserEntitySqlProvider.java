package com.sudaotech.user.dao;

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

import com.sudaotech.user.dao.AdminUserEntity;
import com.sudaotech.user.dao.AdminUserEntityExample.Criteria;
import com.sudaotech.user.dao.AdminUserEntityExample.Criterion;
import com.sudaotech.user.dao.AdminUserEntityExample;
import java.util.List;
import java.util.Map;

public class AdminUserEntitySqlProvider {

    public String countByExample(AdminUserEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("admin_user");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AdminUserEntityExample example) {
        BEGIN();
        DELETE_FROM("admin_user");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AdminUserEntity record) {
        BEGIN();
        INSERT_INTO("admin_user");
        
        if (record.getUserId() != null) {
            VALUES("userId", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            VALUES("companyId", "#{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getProviderId() != null) {
            VALUES("providerId", "#{providerId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            VALUES("userType", "#{userType,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformSource() != null) {
            VALUES("platformSource", "#{platformSource,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSourceId() != null) {
            VALUES("platformSourceId", "#{platformSourceId,jdbcType=BIGINT}");
        }
        
        if (record.getUserAttribute() != null) {
            VALUES("userAttribute", "#{userAttribute,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getPasswordStatus() != null) {
            VALUES("passwordStatus", "#{passwordStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            VALUES("photo", "#{photo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCellphone() != null) {
            VALUES("cellphone", "#{cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getHidden() != null) {
            VALUES("hidden", "#{hidden,jdbcType=INTEGER}");
        }
        
        if (record.getUserStatus() != null) {
            VALUES("userStatus", "#{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            VALUES("displayOrder", "#{displayOrder,jdbcType=INTEGER}");
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

    public String selectByExample(AdminUserEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("userId");
        } else {
            SELECT("userId");
        }
        SELECT("companyId");
        SELECT("providerId");
        SELECT("userType");
        SELECT("platformSource");
        SELECT("platformSourceId");
        SELECT("userAttribute");
        SELECT("username");
        SELECT("password");
        SELECT("passwordStatus");
        SELECT("nickname");
        SELECT("photo");
        SELECT("name");
        SELECT("gender");
        SELECT("birthday");
        SELECT("cellphone");
        SELECT("tel");
        SELECT("email");
        SELECT("hidden");
        SELECT("userStatus");
        SELECT("displayOrder");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("admin_user");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AdminUserEntity record = (AdminUserEntity) parameter.get("record");
        AdminUserEntityExample example = (AdminUserEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("admin_user");
        
        if (record.getUserId() != null) {
            SET("userId = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        }
        
        if (record.getProviderId() != null) {
            SET("providerId = #{record.providerId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            SET("userType = #{record.userType,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformSource() != null) {
            SET("platformSource = #{record.platformSource,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSourceId() != null) {
            SET("platformSourceId = #{record.platformSourceId,jdbcType=BIGINT}");
        }
        
        if (record.getUserAttribute() != null) {
            SET("userAttribute = #{record.userAttribute,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getPasswordStatus() != null) {
            SET("passwordStatus = #{record.passwordStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            SET("photo = #{record.photo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{record.gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{record.birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCellphone() != null) {
            SET("cellphone = #{record.cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getHidden() != null) {
            SET("hidden = #{record.hidden,jdbcType=INTEGER}");
        }
        
        if (record.getUserStatus() != null) {
            SET("userStatus = #{record.userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("displayOrder = #{record.displayOrder,jdbcType=INTEGER}");
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
        UPDATE("admin_user");
        
        SET("userId = #{record.userId,jdbcType=BIGINT}");
        SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        SET("providerId = #{record.providerId,jdbcType=BIGINT}");
        SET("userType = #{record.userType,jdbcType=BIGINT}");
        SET("platformSource = #{record.platformSource,jdbcType=INTEGER}");
        SET("platformSourceId = #{record.platformSourceId,jdbcType=BIGINT}");
        SET("userAttribute = #{record.userAttribute,jdbcType=INTEGER}");
        SET("username = #{record.username,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("passwordStatus = #{record.passwordStatus,jdbcType=INTEGER}");
        SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        SET("photo = #{record.photo,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("gender = #{record.gender,jdbcType=INTEGER}");
        SET("birthday = #{record.birthday,jdbcType=TIMESTAMP}");
        SET("cellphone = #{record.cellphone,jdbcType=VARCHAR}");
        SET("tel = #{record.tel,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("hidden = #{record.hidden,jdbcType=INTEGER}");
        SET("userStatus = #{record.userStatus,jdbcType=INTEGER}");
        SET("displayOrder = #{record.displayOrder,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        AdminUserEntityExample example = (AdminUserEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AdminUserEntity record) {
        BEGIN();
        UPDATE("admin_user");
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getProviderId() != null) {
            SET("providerId = #{providerId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            SET("userType = #{userType,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformSource() != null) {
            SET("platformSource = #{platformSource,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSourceId() != null) {
            SET("platformSourceId = #{platformSourceId,jdbcType=BIGINT}");
        }
        
        if (record.getUserAttribute() != null) {
            SET("userAttribute = #{userAttribute,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getPasswordStatus() != null) {
            SET("passwordStatus = #{passwordStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            SET("photo = #{photo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCellphone() != null) {
            SET("cellphone = #{cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getHidden() != null) {
            SET("hidden = #{hidden,jdbcType=INTEGER}");
        }
        
        if (record.getUserStatus() != null) {
            SET("userStatus = #{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("displayOrder = #{displayOrder,jdbcType=INTEGER}");
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
        
        WHERE("userId = #{userId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(AdminUserEntityExample example, boolean includeExamplePhrase) {
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