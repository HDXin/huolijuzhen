package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnitTierInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnitTierInfoEntityExample() {
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

        public Criteria andIsBaseIsNull() {
            addCriterion("isBase is null");
            return (Criteria) this;
        }

        public Criteria andIsBaseIsNotNull() {
            addCriterion("isBase is not null");
            return (Criteria) this;
        }

        public Criteria andIsBaseEqualTo(Boolean value) {
            addCriterion("isBase =", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseNotEqualTo(Boolean value) {
            addCriterion("isBase <>", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseGreaterThan(Boolean value) {
            addCriterion("isBase >", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isBase >=", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseLessThan(Boolean value) {
            addCriterion("isBase <", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseLessThanOrEqualTo(Boolean value) {
            addCriterion("isBase <=", value, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseIn(List<Boolean> values) {
            addCriterion("isBase in", values, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseNotIn(List<Boolean> values) {
            addCriterion("isBase not in", values, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseBetween(Boolean value1, Boolean value2) {
            addCriterion("isBase between", value1, value2, "isBase");
            return (Criteria) this;
        }

        public Criteria andIsBaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isBase not between", value1, value2, "isBase");
            return (Criteria) this;
        }

        public Criteria andTierNumIsNull() {
            addCriterion("tierNum is null");
            return (Criteria) this;
        }

        public Criteria andTierNumIsNotNull() {
            addCriterion("tierNum is not null");
            return (Criteria) this;
        }

        public Criteria andTierNumEqualTo(Integer value) {
            addCriterion("tierNum =", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotEqualTo(Integer value) {
            addCriterion("tierNum <>", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumGreaterThan(Integer value) {
            addCriterion("tierNum >", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("tierNum >=", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumLessThan(Integer value) {
            addCriterion("tierNum <", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumLessThanOrEqualTo(Integer value) {
            addCriterion("tierNum <=", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumIn(List<Integer> values) {
            addCriterion("tierNum in", values, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotIn(List<Integer> values) {
            addCriterion("tierNum not in", values, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumBetween(Integer value1, Integer value2) {
            addCriterion("tierNum between", value1, value2, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotBetween(Integer value1, Integer value2) {
            addCriterion("tierNum not between", value1, value2, "tierNum");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNull() {
            addCriterion("resInfoId is null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNotNull() {
            addCriterion("resInfoId is not null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdEqualTo(Long value) {
            addCriterion("resInfoId =", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotEqualTo(Long value) {
            addCriterion("resInfoId <>", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThan(Long value) {
            addCriterion("resInfoId >", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resInfoId >=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThan(Long value) {
            addCriterion("resInfoId <", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("resInfoId <=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIn(List<Long> values) {
            addCriterion("resInfoId in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotIn(List<Long> values) {
            addCriterion("resInfoId not in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdBetween(Long value1, Long value2) {
            addCriterion("resInfoId between", value1, value2, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("resInfoId not between", value1, value2, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoNameIsNull() {
            addCriterion("resInfoName is null");
            return (Criteria) this;
        }

        public Criteria andResInfoNameIsNotNull() {
            addCriterion("resInfoName is not null");
            return (Criteria) this;
        }

        public Criteria andResInfoNameEqualTo(String value) {
            addCriterion("resInfoName =", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameNotEqualTo(String value) {
            addCriterion("resInfoName <>", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameGreaterThan(String value) {
            addCriterion("resInfoName >", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("resInfoName >=", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameLessThan(String value) {
            addCriterion("resInfoName <", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameLessThanOrEqualTo(String value) {
            addCriterion("resInfoName <=", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameLike(String value) {
            addCriterion("resInfoName like", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameNotLike(String value) {
            addCriterion("resInfoName not like", value, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameIn(List<String> values) {
            addCriterion("resInfoName in", values, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameNotIn(List<String> values) {
            addCriterion("resInfoName not in", values, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameBetween(String value1, String value2) {
            addCriterion("resInfoName between", value1, value2, "resInfoName");
            return (Criteria) this;
        }

        public Criteria andResInfoNameNotBetween(String value1, String value2) {
            addCriterion("resInfoName not between", value1, value2, "resInfoName");
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

        public Criteria andGardenIdIsNull() {
            addCriterion("gardenId is null");
            return (Criteria) this;
        }

        public Criteria andGardenIdIsNotNull() {
            addCriterion("gardenId is not null");
            return (Criteria) this;
        }

        public Criteria andGardenIdEqualTo(Long value) {
            addCriterion("gardenId =", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotEqualTo(Long value) {
            addCriterion("gardenId <>", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdGreaterThan(Long value) {
            addCriterion("gardenId >", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gardenId >=", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdLessThan(Long value) {
            addCriterion("gardenId <", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdLessThanOrEqualTo(Long value) {
            addCriterion("gardenId <=", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdIn(List<Long> values) {
            addCriterion("gardenId in", values, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotIn(List<Long> values) {
            addCriterion("gardenId not in", values, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdBetween(Long value1, Long value2) {
            addCriterion("gardenId between", value1, value2, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotBetween(Long value1, Long value2) {
            addCriterion("gardenId not between", value1, value2, "gardenId");
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

        public Criteria andStartByIsNull() {
            addCriterion("startBy is null");
            return (Criteria) this;
        }

        public Criteria andStartByIsNotNull() {
            addCriterion("startBy is not null");
            return (Criteria) this;
        }

        public Criteria andStartByEqualTo(Long value) {
            addCriterion("startBy =", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByNotEqualTo(Long value) {
            addCriterion("startBy <>", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByGreaterThan(Long value) {
            addCriterion("startBy >", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByGreaterThanOrEqualTo(Long value) {
            addCriterion("startBy >=", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByLessThan(Long value) {
            addCriterion("startBy <", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByLessThanOrEqualTo(Long value) {
            addCriterion("startBy <=", value, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByIn(List<Long> values) {
            addCriterion("startBy in", values, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByNotIn(List<Long> values) {
            addCriterion("startBy not in", values, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByBetween(Long value1, Long value2) {
            addCriterion("startBy between", value1, value2, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartByNotBetween(Long value1, Long value2) {
            addCriterion("startBy not between", value1, value2, "startBy");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("startTime =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("startTime <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("startTime in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCloseByIsNull() {
            addCriterion("closeBy is null");
            return (Criteria) this;
        }

        public Criteria andCloseByIsNotNull() {
            addCriterion("closeBy is not null");
            return (Criteria) this;
        }

        public Criteria andCloseByEqualTo(Long value) {
            addCriterion("closeBy =", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByNotEqualTo(Long value) {
            addCriterion("closeBy <>", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByGreaterThan(Long value) {
            addCriterion("closeBy >", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByGreaterThanOrEqualTo(Long value) {
            addCriterion("closeBy >=", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByLessThan(Long value) {
            addCriterion("closeBy <", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByLessThanOrEqualTo(Long value) {
            addCriterion("closeBy <=", value, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByIn(List<Long> values) {
            addCriterion("closeBy in", values, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByNotIn(List<Long> values) {
            addCriterion("closeBy not in", values, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByBetween(Long value1, Long value2) {
            addCriterion("closeBy between", value1, value2, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseByNotBetween(Long value1, Long value2) {
            addCriterion("closeBy not between", value1, value2, "closeBy");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("closeTime is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("closeTime is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("closeTime =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("closeTime <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("closeTime >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("closeTime >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("closeTime <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("closeTime <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("closeTime in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("closeTime not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("closeTime between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("closeTime not between", value1, value2, "closeTime");
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