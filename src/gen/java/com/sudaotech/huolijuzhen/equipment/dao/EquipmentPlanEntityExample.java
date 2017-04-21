package com.sudaotech.huolijuzhen.equipment.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EquipmentPlanEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentPlanEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEquIdIsNull() {
            addCriterion("equId is null");
            return (Criteria) this;
        }

        public Criteria andEquIdIsNotNull() {
            addCriterion("equId is not null");
            return (Criteria) this;
        }

        public Criteria andEquIdEqualTo(Long value) {
            addCriterion("equId =", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdNotEqualTo(Long value) {
            addCriterion("equId <>", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdGreaterThan(Long value) {
            addCriterion("equId >", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdGreaterThanOrEqualTo(Long value) {
            addCriterion("equId >=", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdLessThan(Long value) {
            addCriterion("equId <", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdLessThanOrEqualTo(Long value) {
            addCriterion("equId <=", value, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdIn(List<Long> values) {
            addCriterion("equId in", values, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdNotIn(List<Long> values) {
            addCriterion("equId not in", values, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdBetween(Long value1, Long value2) {
            addCriterion("equId between", value1, value2, "equId");
            return (Criteria) this;
        }

        public Criteria andEquIdNotBetween(Long value1, Long value2) {
            addCriterion("equId not between", value1, value2, "equId");
            return (Criteria) this;
        }

        public Criteria andEquCodeIsNull() {
            addCriterion("equCode is null");
            return (Criteria) this;
        }

        public Criteria andEquCodeIsNotNull() {
            addCriterion("equCode is not null");
            return (Criteria) this;
        }

        public Criteria andEquCodeEqualTo(String value) {
            addCriterion("equCode =", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeNotEqualTo(String value) {
            addCriterion("equCode <>", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeGreaterThan(String value) {
            addCriterion("equCode >", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equCode >=", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeLessThan(String value) {
            addCriterion("equCode <", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeLessThanOrEqualTo(String value) {
            addCriterion("equCode <=", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeLike(String value) {
            addCriterion("equCode like", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeNotLike(String value) {
            addCriterion("equCode not like", value, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeIn(List<String> values) {
            addCriterion("equCode in", values, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeNotIn(List<String> values) {
            addCriterion("equCode not in", values, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeBetween(String value1, String value2) {
            addCriterion("equCode between", value1, value2, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquCodeNotBetween(String value1, String value2) {
            addCriterion("equCode not between", value1, value2, "equCode");
            return (Criteria) this;
        }

        public Criteria andEquNameIsNull() {
            addCriterion("equName is null");
            return (Criteria) this;
        }

        public Criteria andEquNameIsNotNull() {
            addCriterion("equName is not null");
            return (Criteria) this;
        }

        public Criteria andEquNameEqualTo(String value) {
            addCriterion("equName =", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameNotEqualTo(String value) {
            addCriterion("equName <>", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameGreaterThan(String value) {
            addCriterion("equName >", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameGreaterThanOrEqualTo(String value) {
            addCriterion("equName >=", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameLessThan(String value) {
            addCriterion("equName <", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameLessThanOrEqualTo(String value) {
            addCriterion("equName <=", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameLike(String value) {
            addCriterion("equName like", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameNotLike(String value) {
            addCriterion("equName not like", value, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameIn(List<String> values) {
            addCriterion("equName in", values, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameNotIn(List<String> values) {
            addCriterion("equName not in", values, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameBetween(String value1, String value2) {
            addCriterion("equName between", value1, value2, "equName");
            return (Criteria) this;
        }

        public Criteria andEquNameNotBetween(String value1, String value2) {
            addCriterion("equName not between", value1, value2, "equName");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdIsNull() {
            addCriterion("equTypeId is null");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdIsNotNull() {
            addCriterion("equTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdEqualTo(Long value) {
            addCriterion("equTypeId =", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdNotEqualTo(Long value) {
            addCriterion("equTypeId <>", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdGreaterThan(Long value) {
            addCriterion("equTypeId >", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("equTypeId >=", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdLessThan(Long value) {
            addCriterion("equTypeId <", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("equTypeId <=", value, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdIn(List<Long> values) {
            addCriterion("equTypeId in", values, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdNotIn(List<Long> values) {
            addCriterion("equTypeId not in", values, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdBetween(Long value1, Long value2) {
            addCriterion("equTypeId between", value1, value2, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andEquTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("equTypeId not between", value1, value2, "equTypeId");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeIsNull() {
            addCriterion("upkeepTime is null");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeIsNotNull() {
            addCriterion("upkeepTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeEqualTo(Date value) {
            addCriterion("upkeepTime =", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeNotEqualTo(Date value) {
            addCriterion("upkeepTime <>", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeGreaterThan(Date value) {
            addCriterion("upkeepTime >", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upkeepTime >=", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeLessThan(Date value) {
            addCriterion("upkeepTime <", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeLessThanOrEqualTo(Date value) {
            addCriterion("upkeepTime <=", value, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeIn(List<Date> values) {
            addCriterion("upkeepTime in", values, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeNotIn(List<Date> values) {
            addCriterion("upkeepTime not in", values, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeBetween(Date value1, Date value2) {
            addCriterion("upkeepTime between", value1, value2, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andUpkeepTimeNotBetween(Date value1, Date value2) {
            addCriterion("upkeepTime not between", value1, value2, "upkeepTime");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameIsNull() {
            addCriterion("equTypeName is null");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameIsNotNull() {
            addCriterion("equTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameEqualTo(String value) {
            addCriterion("equTypeName =", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameNotEqualTo(String value) {
            addCriterion("equTypeName <>", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameGreaterThan(String value) {
            addCriterion("equTypeName >", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("equTypeName >=", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameLessThan(String value) {
            addCriterion("equTypeName <", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameLessThanOrEqualTo(String value) {
            addCriterion("equTypeName <=", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameLike(String value) {
            addCriterion("equTypeName like", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameNotLike(String value) {
            addCriterion("equTypeName not like", value, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameIn(List<String> values) {
            addCriterion("equTypeName in", values, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameNotIn(List<String> values) {
            addCriterion("equTypeName not in", values, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameBetween(String value1, String value2) {
            addCriterion("equTypeName between", value1, value2, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andEquTypeNameNotBetween(String value1, String value2) {
            addCriterion("equTypeName not between", value1, value2, "equTypeName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Status value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Status value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Status value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Status value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Status value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Status value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Status> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Status> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Status value1, Status value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Status value1, Status value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("createBy is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("createBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("createBy =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("createBy <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("createBy >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("createBy >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("createBy <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("createBy <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("createBy in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("createBy not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("createBy between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("createBy not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("updateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("updateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("updateBy =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("updateBy <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("updateBy >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("updateBy >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("updateBy <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("updateBy <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("updateBy in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("updateBy not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("updateBy between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("updateBy not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("lastUpdate is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("lastUpdate is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(Date value) {
            addCriterion("lastUpdate =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(Date value) {
            addCriterion("lastUpdate <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(Date value) {
            addCriterion("lastUpdate >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdate >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(Date value) {
            addCriterion("lastUpdate <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdate <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<Date> values) {
            addCriterion("lastUpdate in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<Date> values) {
            addCriterion("lastUpdate not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(Date value1, Date value2) {
            addCriterion("lastUpdate between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdate not between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNull() {
            addCriterion("planStatus is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("planStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(PlanStatus value) {
            addCriterion("planStatus =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(PlanStatus value) {
            addCriterion("planStatus <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(PlanStatus value) {
            addCriterion("planStatus >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(PlanStatus value) {
            addCriterion("planStatus >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(PlanStatus value) {
            addCriterion("planStatus <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(PlanStatus value) {
            addCriterion("planStatus <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<PlanStatus> values) {
            addCriterion("planStatus in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<PlanStatus> values) {
            addCriterion("planStatus not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(PlanStatus value1, PlanStatus value2) {
            addCriterion("planStatus between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(PlanStatus value1, PlanStatus value2) {
            addCriterion("planStatus not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andAssignerIdIsNull() {
            addCriterion("assignerId is null");
            return (Criteria) this;
        }

        public Criteria andAssignerIdIsNotNull() {
            addCriterion("assignerId is not null");
            return (Criteria) this;
        }

        public Criteria andAssignerIdEqualTo(Long value) {
            addCriterion("assignerId =", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdNotEqualTo(Long value) {
            addCriterion("assignerId <>", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdGreaterThan(Long value) {
            addCriterion("assignerId >", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assignerId >=", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdLessThan(Long value) {
            addCriterion("assignerId <", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdLessThanOrEqualTo(Long value) {
            addCriterion("assignerId <=", value, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdIn(List<Long> values) {
            addCriterion("assignerId in", values, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdNotIn(List<Long> values) {
            addCriterion("assignerId not in", values, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdBetween(Long value1, Long value2) {
            addCriterion("assignerId between", value1, value2, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerIdNotBetween(Long value1, Long value2) {
            addCriterion("assignerId not between", value1, value2, "assignerId");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeIsNull() {
            addCriterion("assignerTime is null");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeIsNotNull() {
            addCriterion("assignerTime is not null");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeEqualTo(Date value) {
            addCriterion("assignerTime =", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeNotEqualTo(Date value) {
            addCriterion("assignerTime <>", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeGreaterThan(Date value) {
            addCriterion("assignerTime >", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assignerTime >=", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeLessThan(Date value) {
            addCriterion("assignerTime <", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeLessThanOrEqualTo(Date value) {
            addCriterion("assignerTime <=", value, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeIn(List<Date> values) {
            addCriterion("assignerTime in", values, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeNotIn(List<Date> values) {
            addCriterion("assignerTime not in", values, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeBetween(Date value1, Date value2) {
            addCriterion("assignerTime between", value1, value2, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andAssignerTimeNotBetween(Date value1, Date value2) {
            addCriterion("assignerTime not between", value1, value2, "assignerTime");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateIsNull() {
            addCriterion("planExecutorDate is null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateIsNotNull() {
            addCriterion("planExecutorDate is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateEqualTo(Date value) {
            addCriterionForJDBCDate("planExecutorDate =", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("planExecutorDate <>", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateGreaterThan(Date value) {
            addCriterionForJDBCDate("planExecutorDate >", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planExecutorDate >=", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateLessThan(Date value) {
            addCriterionForJDBCDate("planExecutorDate <", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planExecutorDate <=", value, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateIn(List<Date> values) {
            addCriterionForJDBCDate("planExecutorDate in", values, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("planExecutorDate not in", values, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planExecutorDate between", value1, value2, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andPlanExecutorDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planExecutorDate not between", value1, value2, "planExecutorDate");
            return (Criteria) this;
        }

        public Criteria andDeleteByIsNull() {
            addCriterion("deleteBy is null");
            return (Criteria) this;
        }

        public Criteria andDeleteByIsNotNull() {
            addCriterion("deleteBy is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteByEqualTo(Long value) {
            addCriterion("deleteBy =", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotEqualTo(Long value) {
            addCriterion("deleteBy <>", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThan(Long value) {
            addCriterion("deleteBy >", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThanOrEqualTo(Long value) {
            addCriterion("deleteBy >=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThan(Long value) {
            addCriterion("deleteBy <", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThanOrEqualTo(Long value) {
            addCriterion("deleteBy <=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByIn(List<Long> values) {
            addCriterion("deleteBy in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotIn(List<Long> values) {
            addCriterion("deleteBy not in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByBetween(Long value1, Long value2) {
            addCriterion("deleteBy between", value1, value2, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotBetween(Long value1, Long value2) {
            addCriterion("deleteBy not between", value1, value2, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("deleteTime is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("deleteTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("deleteTime =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("deleteTime <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("deleteTime >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deleteTime >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("deleteTime <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("deleteTime <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("deleteTime in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("deleteTime not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("deleteTime between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("deleteTime not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoIsNull() {
            addCriterion("deleteMemo is null");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoIsNotNull() {
            addCriterion("deleteMemo is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoEqualTo(String value) {
            addCriterion("deleteMemo =", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoNotEqualTo(String value) {
            addCriterion("deleteMemo <>", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoGreaterThan(String value) {
            addCriterion("deleteMemo >", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoGreaterThanOrEqualTo(String value) {
            addCriterion("deleteMemo >=", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoLessThan(String value) {
            addCriterion("deleteMemo <", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoLessThanOrEqualTo(String value) {
            addCriterion("deleteMemo <=", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoLike(String value) {
            addCriterion("deleteMemo like", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoNotLike(String value) {
            addCriterion("deleteMemo not like", value, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoIn(List<String> values) {
            addCriterion("deleteMemo in", values, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoNotIn(List<String> values) {
            addCriterion("deleteMemo not in", values, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoBetween(String value1, String value2) {
            addCriterion("deleteMemo between", value1, value2, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andDeleteMemoNotBetween(String value1, String value2) {
            addCriterion("deleteMemo not between", value1, value2, "deleteMemo");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNull() {
            addCriterion("enableStatus is null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNotNull() {
            addCriterion("enableStatus is not null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusEqualTo(EnableStatus value) {
            addCriterion("enableStatus =", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotEqualTo(EnableStatus value) {
            addCriterion("enableStatus <>", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThan(EnableStatus value) {
            addCriterion("enableStatus >", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThanOrEqualTo(EnableStatus value) {
            addCriterion("enableStatus >=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThan(EnableStatus value) {
            addCriterion("enableStatus <", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThanOrEqualTo(EnableStatus value) {
            addCriterion("enableStatus <=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIn(List<EnableStatus> values) {
            addCriterion("enableStatus in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotIn(List<EnableStatus> values) {
            addCriterion("enableStatus not in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("enableStatus between", value1, value2, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("enableStatus not between", value1, value2, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}