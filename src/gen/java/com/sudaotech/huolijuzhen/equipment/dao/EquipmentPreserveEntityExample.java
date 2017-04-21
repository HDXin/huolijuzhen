package com.sudaotech.huolijuzhen.equipment.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CycleType;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EquipmentPreserveEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentPreserveEntityExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPreCycleIsNull() {
            addCriterion("preCycle is null");
            return (Criteria) this;
        }

        public Criteria andPreCycleIsNotNull() {
            addCriterion("preCycle is not null");
            return (Criteria) this;
        }

        public Criteria andPreCycleEqualTo(Integer value) {
            addCriterion("preCycle =", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleNotEqualTo(Integer value) {
            addCriterion("preCycle <>", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleGreaterThan(Integer value) {
            addCriterion("preCycle >", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("preCycle >=", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleLessThan(Integer value) {
            addCriterion("preCycle <", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleLessThanOrEqualTo(Integer value) {
            addCriterion("preCycle <=", value, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleIn(List<Integer> values) {
            addCriterion("preCycle in", values, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleNotIn(List<Integer> values) {
            addCriterion("preCycle not in", values, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleBetween(Integer value1, Integer value2) {
            addCriterion("preCycle between", value1, value2, "preCycle");
            return (Criteria) this;
        }

        public Criteria andPreCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("preCycle not between", value1, value2, "preCycle");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIsNull() {
            addCriterion("cycleType is null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIsNotNull() {
            addCriterion("cycleType is not null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeEqualTo(CycleType value) {
            addCriterion("cycleType =", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotEqualTo(CycleType value) {
            addCriterion("cycleType <>", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThan(CycleType value) {
            addCriterion("cycleType >", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThanOrEqualTo(CycleType value) {
            addCriterion("cycleType >=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThan(CycleType value) {
            addCriterion("cycleType <", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThanOrEqualTo(CycleType value) {
            addCriterion("cycleType <=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIn(List<CycleType> values) {
            addCriterion("cycleType in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotIn(List<CycleType> values) {
            addCriterion("cycleType not in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeBetween(CycleType value1, CycleType value2) {
            addCriterion("cycleType between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotBetween(CycleType value1, CycleType value2) {
            addCriterion("cycleType not between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("parkId is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("parkId is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Long value) {
            addCriterion("parkId =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Long value) {
            addCriterion("parkId <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Long value) {
            addCriterion("parkId >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkId >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Long value) {
            addCriterion("parkId <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Long value) {
            addCriterion("parkId <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Long> values) {
            addCriterion("parkId in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Long> values) {
            addCriterion("parkId not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Long value1, Long value2) {
            addCriterion("parkId between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Long value1, Long value2) {
            addCriterion("parkId not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andPreObjIsNull() {
            addCriterion("preObj is null");
            return (Criteria) this;
        }

        public Criteria andPreObjIsNotNull() {
            addCriterion("preObj is not null");
            return (Criteria) this;
        }

        public Criteria andPreObjEqualTo(String value) {
            addCriterion("preObj =", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjNotEqualTo(String value) {
            addCriterion("preObj <>", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjGreaterThan(String value) {
            addCriterion("preObj >", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjGreaterThanOrEqualTo(String value) {
            addCriterion("preObj >=", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjLessThan(String value) {
            addCriterion("preObj <", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjLessThanOrEqualTo(String value) {
            addCriterion("preObj <=", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjLike(String value) {
            addCriterion("preObj like", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjNotLike(String value) {
            addCriterion("preObj not like", value, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjIn(List<String> values) {
            addCriterion("preObj in", values, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjNotIn(List<String> values) {
            addCriterion("preObj not in", values, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjBetween(String value1, String value2) {
            addCriterion("preObj between", value1, value2, "preObj");
            return (Criteria) this;
        }

        public Criteria andPreObjNotBetween(String value1, String value2) {
            addCriterion("preObj not between", value1, value2, "preObj");
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

        public Criteria andEnableDateIsNull() {
            addCriterion("enableDate is null");
            return (Criteria) this;
        }

        public Criteria andEnableDateIsNotNull() {
            addCriterion("enableDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnableDateEqualTo(Date value) {
            addCriterionForJDBCDate("enableDate =", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enableDate <>", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateGreaterThan(Date value) {
            addCriterionForJDBCDate("enableDate >", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enableDate >=", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateLessThan(Date value) {
            addCriterionForJDBCDate("enableDate <", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enableDate <=", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateIn(List<Date> values) {
            addCriterionForJDBCDate("enableDate in", values, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enableDate not in", values, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enableDate between", value1, value2, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enableDate not between", value1, value2, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableByIsNull() {
            addCriterion("enableBy is null");
            return (Criteria) this;
        }

        public Criteria andEnableByIsNotNull() {
            addCriterion("enableBy is not null");
            return (Criteria) this;
        }

        public Criteria andEnableByEqualTo(Long value) {
            addCriterion("enableBy =", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByNotEqualTo(Long value) {
            addCriterion("enableBy <>", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByGreaterThan(Long value) {
            addCriterion("enableBy >", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByGreaterThanOrEqualTo(Long value) {
            addCriterion("enableBy >=", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByLessThan(Long value) {
            addCriterion("enableBy <", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByLessThanOrEqualTo(Long value) {
            addCriterion("enableBy <=", value, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByIn(List<Long> values) {
            addCriterion("enableBy in", values, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByNotIn(List<Long> values) {
            addCriterion("enableBy not in", values, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByBetween(Long value1, Long value2) {
            addCriterion("enableBy between", value1, value2, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableByNotBetween(Long value1, Long value2) {
            addCriterion("enableBy not between", value1, value2, "enableBy");
            return (Criteria) this;
        }

        public Criteria andEnableTimeIsNull() {
            addCriterion("enableTime is null");
            return (Criteria) this;
        }

        public Criteria andEnableTimeIsNotNull() {
            addCriterion("enableTime is not null");
            return (Criteria) this;
        }

        public Criteria andEnableTimeEqualTo(Date value) {
            addCriterion("enableTime =", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeNotEqualTo(Date value) {
            addCriterion("enableTime <>", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeGreaterThan(Date value) {
            addCriterion("enableTime >", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enableTime >=", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeLessThan(Date value) {
            addCriterion("enableTime <", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeLessThanOrEqualTo(Date value) {
            addCriterion("enableTime <=", value, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeIn(List<Date> values) {
            addCriterion("enableTime in", values, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeNotIn(List<Date> values) {
            addCriterion("enableTime not in", values, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeBetween(Date value1, Date value2) {
            addCriterion("enableTime between", value1, value2, "enableTime");
            return (Criteria) this;
        }

        public Criteria andEnableTimeNotBetween(Date value1, Date value2) {
            addCriterion("enableTime not between", value1, value2, "enableTime");
            return (Criteria) this;
        }

        public Criteria andDisableByIsNull() {
            addCriterion("disableBy is null");
            return (Criteria) this;
        }

        public Criteria andDisableByIsNotNull() {
            addCriterion("disableBy is not null");
            return (Criteria) this;
        }

        public Criteria andDisableByEqualTo(Long value) {
            addCriterion("disableBy =", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByNotEqualTo(Long value) {
            addCriterion("disableBy <>", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByGreaterThan(Long value) {
            addCriterion("disableBy >", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByGreaterThanOrEqualTo(Long value) {
            addCriterion("disableBy >=", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByLessThan(Long value) {
            addCriterion("disableBy <", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByLessThanOrEqualTo(Long value) {
            addCriterion("disableBy <=", value, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByIn(List<Long> values) {
            addCriterion("disableBy in", values, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByNotIn(List<Long> values) {
            addCriterion("disableBy not in", values, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByBetween(Long value1, Long value2) {
            addCriterion("disableBy between", value1, value2, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableByNotBetween(Long value1, Long value2) {
            addCriterion("disableBy not between", value1, value2, "disableBy");
            return (Criteria) this;
        }

        public Criteria andDisableTimeIsNull() {
            addCriterion("disableTime is null");
            return (Criteria) this;
        }

        public Criteria andDisableTimeIsNotNull() {
            addCriterion("disableTime is not null");
            return (Criteria) this;
        }

        public Criteria andDisableTimeEqualTo(Date value) {
            addCriterion("disableTime =", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeNotEqualTo(Date value) {
            addCriterion("disableTime <>", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeGreaterThan(Date value) {
            addCriterion("disableTime >", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("disableTime >=", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeLessThan(Date value) {
            addCriterion("disableTime <", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeLessThanOrEqualTo(Date value) {
            addCriterion("disableTime <=", value, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeIn(List<Date> values) {
            addCriterion("disableTime in", values, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeNotIn(List<Date> values) {
            addCriterion("disableTime not in", values, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeBetween(Date value1, Date value2) {
            addCriterion("disableTime between", value1, value2, "disableTime");
            return (Criteria) this;
        }

        public Criteria andDisableTimeNotBetween(Date value1, Date value2) {
            addCriterion("disableTime not between", value1, value2, "disableTime");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanIsNull() {
            addCriterion("isEnablePlan is null");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanIsNotNull() {
            addCriterion("isEnablePlan is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanEqualTo(Boolean value) {
            addCriterion("isEnablePlan =", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanNotEqualTo(Boolean value) {
            addCriterion("isEnablePlan <>", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanGreaterThan(Boolean value) {
            addCriterion("isEnablePlan >", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isEnablePlan >=", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanLessThan(Boolean value) {
            addCriterion("isEnablePlan <", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanLessThanOrEqualTo(Boolean value) {
            addCriterion("isEnablePlan <=", value, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanIn(List<Boolean> values) {
            addCriterion("isEnablePlan in", values, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanNotIn(List<Boolean> values) {
            addCriterion("isEnablePlan not in", values, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanBetween(Boolean value1, Boolean value2) {
            addCriterion("isEnablePlan between", value1, value2, "isEnablePlan");
            return (Criteria) this;
        }

        public Criteria andIsEnablePlanNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isEnablePlan not between", value1, value2, "isEnablePlan");
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