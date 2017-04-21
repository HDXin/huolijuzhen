package com.sudaotech.huolijuzhen.task.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CommentGrade;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskEntityExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("taskType is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("taskType is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(TaskType value) {
            addCriterion("taskType =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(TaskType value) {
            addCriterion("taskType <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(TaskType value) {
            addCriterion("taskType >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(TaskType value) {
            addCriterion("taskType >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(TaskType value) {
            addCriterion("taskType <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(TaskType value) {
            addCriterion("taskType <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<TaskType> values) {
            addCriterion("taskType in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<TaskType> values) {
            addCriterion("taskType not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(TaskType value1, TaskType value2) {
            addCriterion("taskType between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(TaskType value1, TaskType value2) {
            addCriterion("taskType not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdIsNull() {
            addCriterion("equPlanId is null");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdIsNotNull() {
            addCriterion("equPlanId is not null");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdEqualTo(Long value) {
            addCriterion("equPlanId =", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdNotEqualTo(Long value) {
            addCriterion("equPlanId <>", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdGreaterThan(Long value) {
            addCriterion("equPlanId >", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("equPlanId >=", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdLessThan(Long value) {
            addCriterion("equPlanId <", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("equPlanId <=", value, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdIn(List<Long> values) {
            addCriterion("equPlanId in", values, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdNotIn(List<Long> values) {
            addCriterion("equPlanId not in", values, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdBetween(Long value1, Long value2) {
            addCriterion("equPlanId between", value1, value2, "equPlanId");
            return (Criteria) this;
        }

        public Criteria andEquPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("equPlanId not between", value1, value2, "equPlanId");
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

        public Criteria andTaskStatusIsNull() {
            addCriterion("taskStatus is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("taskStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(TaskStatus value) {
            addCriterion("taskStatus =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(TaskStatus value) {
            addCriterion("taskStatus <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(TaskStatus value) {
            addCriterion("taskStatus >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(TaskStatus value) {
            addCriterion("taskStatus >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(TaskStatus value) {
            addCriterion("taskStatus <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(TaskStatus value) {
            addCriterion("taskStatus <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<TaskStatus> values) {
            addCriterion("taskStatus in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<TaskStatus> values) {
            addCriterion("taskStatus not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(TaskStatus value1, TaskStatus value2) {
            addCriterion("taskStatus between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(TaskStatus value1, TaskStatus value2) {
            addCriterion("taskStatus not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIsNull() {
            addCriterion("isAdjust is null");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIsNotNull() {
            addCriterion("isAdjust is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdjustEqualTo(Boolean value) {
            addCriterion("isAdjust =", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotEqualTo(Boolean value) {
            addCriterion("isAdjust <>", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustGreaterThan(Boolean value) {
            addCriterion("isAdjust >", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isAdjust >=", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustLessThan(Boolean value) {
            addCriterion("isAdjust <", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustLessThanOrEqualTo(Boolean value) {
            addCriterion("isAdjust <=", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIn(List<Boolean> values) {
            addCriterion("isAdjust in", values, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotIn(List<Boolean> values) {
            addCriterion("isAdjust not in", values, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustBetween(Boolean value1, Boolean value2) {
            addCriterion("isAdjust between", value1, value2, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isAdjust not between", value1, value2, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andAdjustByIsNull() {
            addCriterion("adjustBy is null");
            return (Criteria) this;
        }

        public Criteria andAdjustByIsNotNull() {
            addCriterion("adjustBy is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustByEqualTo(Long value) {
            addCriterion("adjustBy =", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByNotEqualTo(Long value) {
            addCriterion("adjustBy <>", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByGreaterThan(Long value) {
            addCriterion("adjustBy >", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByGreaterThanOrEqualTo(Long value) {
            addCriterion("adjustBy >=", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByLessThan(Long value) {
            addCriterion("adjustBy <", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByLessThanOrEqualTo(Long value) {
            addCriterion("adjustBy <=", value, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByIn(List<Long> values) {
            addCriterion("adjustBy in", values, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByNotIn(List<Long> values) {
            addCriterion("adjustBy not in", values, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByBetween(Long value1, Long value2) {
            addCriterion("adjustBy between", value1, value2, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustByNotBetween(Long value1, Long value2) {
            addCriterion("adjustBy not between", value1, value2, "adjustBy");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNull() {
            addCriterion("adjustTime is null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIsNotNull() {
            addCriterion("adjustTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeEqualTo(Date value) {
            addCriterion("adjustTime =", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotEqualTo(Date value) {
            addCriterion("adjustTime <>", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThan(Date value) {
            addCriterion("adjustTime >", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adjustTime >=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThan(Date value) {
            addCriterion("adjustTime <", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeLessThanOrEqualTo(Date value) {
            addCriterion("adjustTime <=", value, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeIn(List<Date> values) {
            addCriterion("adjustTime in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotIn(List<Date> values) {
            addCriterion("adjustTime not in", values, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeBetween(Date value1, Date value2) {
            addCriterion("adjustTime between", value1, value2, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustTimeNotBetween(Date value1, Date value2) {
            addCriterion("adjustTime not between", value1, value2, "adjustTime");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoIsNull() {
            addCriterion("adjustMemo is null");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoIsNotNull() {
            addCriterion("adjustMemo is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoEqualTo(String value) {
            addCriterion("adjustMemo =", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoNotEqualTo(String value) {
            addCriterion("adjustMemo <>", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoGreaterThan(String value) {
            addCriterion("adjustMemo >", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoGreaterThanOrEqualTo(String value) {
            addCriterion("adjustMemo >=", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoLessThan(String value) {
            addCriterion("adjustMemo <", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoLessThanOrEqualTo(String value) {
            addCriterion("adjustMemo <=", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoLike(String value) {
            addCriterion("adjustMemo like", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoNotLike(String value) {
            addCriterion("adjustMemo not like", value, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoIn(List<String> values) {
            addCriterion("adjustMemo in", values, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoNotIn(List<String> values) {
            addCriterion("adjustMemo not in", values, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoBetween(String value1, String value2) {
            addCriterion("adjustMemo between", value1, value2, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andAdjustMemoNotBetween(String value1, String value2) {
            addCriterion("adjustMemo not between", value1, value2, "adjustMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Long value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Long value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Long value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Long value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Long value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Long value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Long> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Long> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Long value1, Long value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Long value1, Long value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoIsNull() {
            addCriterion("operatorMemo is null");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoIsNotNull() {
            addCriterion("operatorMemo is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoEqualTo(String value) {
            addCriterion("operatorMemo =", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoNotEqualTo(String value) {
            addCriterion("operatorMemo <>", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoGreaterThan(String value) {
            addCriterion("operatorMemo >", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoGreaterThanOrEqualTo(String value) {
            addCriterion("operatorMemo >=", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoLessThan(String value) {
            addCriterion("operatorMemo <", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoLessThanOrEqualTo(String value) {
            addCriterion("operatorMemo <=", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoLike(String value) {
            addCriterion("operatorMemo like", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoNotLike(String value) {
            addCriterion("operatorMemo not like", value, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoIn(List<String> values) {
            addCriterion("operatorMemo in", values, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoNotIn(List<String> values) {
            addCriterion("operatorMemo not in", values, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoBetween(String value1, String value2) {
            addCriterion("operatorMemo between", value1, value2, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorMemoNotBetween(String value1, String value2) {
            addCriterion("operatorMemo not between", value1, value2, "operatorMemo");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIsNull() {
            addCriterion("operatorTime is null");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIsNotNull() {
            addCriterion("operatorTime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeEqualTo(Date value) {
            addCriterion("operatorTime =", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotEqualTo(Date value) {
            addCriterion("operatorTime <>", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeGreaterThan(Date value) {
            addCriterion("operatorTime >", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatorTime >=", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeLessThan(Date value) {
            addCriterion("operatorTime <", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeLessThanOrEqualTo(Date value) {
            addCriterion("operatorTime <=", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIn(List<Date> values) {
            addCriterion("operatorTime in", values, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotIn(List<Date> values) {
            addCriterion("operatorTime not in", values, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeBetween(Date value1, Date value2) {
            addCriterion("operatorTime between", value1, value2, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotBetween(Date value1, Date value2) {
            addCriterion("operatorTime not between", value1, value2, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("payWay is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("payWay is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(PayWay value) {
            addCriterion("payWay =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(PayWay value) {
            addCriterion("payWay <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(PayWay value) {
            addCriterion("payWay >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(PayWay value) {
            addCriterion("payWay >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(PayWay value) {
            addCriterion("payWay <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(PayWay value) {
            addCriterion("payWay <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<PayWay> values) {
            addCriterion("payWay in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<PayWay> values) {
            addCriterion("payWay not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(PayWay value1, PayWay value2) {
            addCriterion("payWay between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(PayWay value1, PayWay value2) {
            addCriterion("payWay not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNull() {
            addCriterion("executor is null");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNotNull() {
            addCriterion("executor is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorEqualTo(String value) {
            addCriterion("executor =", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotEqualTo(String value) {
            addCriterion("executor <>", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThan(String value) {
            addCriterion("executor >", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThanOrEqualTo(String value) {
            addCriterion("executor >=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThan(String value) {
            addCriterion("executor <", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThanOrEqualTo(String value) {
            addCriterion("executor <=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLike(String value) {
            addCriterion("executor like", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotLike(String value) {
            addCriterion("executor not like", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorIn(List<String> values) {
            addCriterion("executor in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotIn(List<String> values) {
            addCriterion("executor not in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorBetween(String value1, String value2) {
            addCriterion("executor between", value1, value2, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotBetween(String value1, String value2) {
            addCriterion("executor not between", value1, value2, "executor");
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

        public Criteria andAllByIsNull() {
            addCriterion("allBy is null");
            return (Criteria) this;
        }

        public Criteria andAllByIsNotNull() {
            addCriterion("allBy is not null");
            return (Criteria) this;
        }

        public Criteria andAllByEqualTo(Long value) {
            addCriterion("allBy =", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByNotEqualTo(Long value) {
            addCriterion("allBy <>", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByGreaterThan(Long value) {
            addCriterion("allBy >", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByGreaterThanOrEqualTo(Long value) {
            addCriterion("allBy >=", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByLessThan(Long value) {
            addCriterion("allBy <", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByLessThanOrEqualTo(Long value) {
            addCriterion("allBy <=", value, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByIn(List<Long> values) {
            addCriterion("allBy in", values, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByNotIn(List<Long> values) {
            addCriterion("allBy not in", values, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByBetween(Long value1, Long value2) {
            addCriterion("allBy between", value1, value2, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllByNotBetween(Long value1, Long value2) {
            addCriterion("allBy not between", value1, value2, "allBy");
            return (Criteria) this;
        }

        public Criteria andAllTimeIsNull() {
            addCriterion("allTime is null");
            return (Criteria) this;
        }

        public Criteria andAllTimeIsNotNull() {
            addCriterion("allTime is not null");
            return (Criteria) this;
        }

        public Criteria andAllTimeEqualTo(Date value) {
            addCriterion("allTime =", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeNotEqualTo(Date value) {
            addCriterion("allTime <>", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeGreaterThan(Date value) {
            addCriterion("allTime >", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("allTime >=", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeLessThan(Date value) {
            addCriterion("allTime <", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeLessThanOrEqualTo(Date value) {
            addCriterion("allTime <=", value, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeIn(List<Date> values) {
            addCriterion("allTime in", values, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeNotIn(List<Date> values) {
            addCriterion("allTime not in", values, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeBetween(Date value1, Date value2) {
            addCriterion("allTime between", value1, value2, "allTime");
            return (Criteria) this;
        }

        public Criteria andAllTimeNotBetween(Date value1, Date value2) {
            addCriterion("allTime not between", value1, value2, "allTime");
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

        public Criteria andCreateNameIsNull() {
            addCriterion("createName is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("createName is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("createName =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("createName <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("createName >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("createName >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("createName <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("createName <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("createName like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("createName not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("createName in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("createName not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("createName between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("createName not between", value1, value2, "createName");
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

        public Criteria andHasCostIsNull() {
            addCriterion("hasCost is null");
            return (Criteria) this;
        }

        public Criteria andHasCostIsNotNull() {
            addCriterion("hasCost is not null");
            return (Criteria) this;
        }

        public Criteria andHasCostEqualTo(Boolean value) {
            addCriterion("hasCost =", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostNotEqualTo(Boolean value) {
            addCriterion("hasCost <>", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostGreaterThan(Boolean value) {
            addCriterion("hasCost >", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasCost >=", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostLessThan(Boolean value) {
            addCriterion("hasCost <", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostLessThanOrEqualTo(Boolean value) {
            addCriterion("hasCost <=", value, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostIn(List<Boolean> values) {
            addCriterion("hasCost in", values, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostNotIn(List<Boolean> values) {
            addCriterion("hasCost not in", values, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostBetween(Boolean value1, Boolean value2) {
            addCriterion("hasCost between", value1, value2, "hasCost");
            return (Criteria) this;
        }

        public Criteria andHasCostNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasCost not between", value1, value2, "hasCost");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyIsNull() {
            addCriterion("costIsVerify is null");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyIsNotNull() {
            addCriterion("costIsVerify is not null");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyEqualTo(Boolean value) {
            addCriterion("costIsVerify =", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyNotEqualTo(Boolean value) {
            addCriterion("costIsVerify <>", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyGreaterThan(Boolean value) {
            addCriterion("costIsVerify >", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("costIsVerify >=", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyLessThan(Boolean value) {
            addCriterion("costIsVerify <", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyLessThanOrEqualTo(Boolean value) {
            addCriterion("costIsVerify <=", value, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyIn(List<Boolean> values) {
            addCriterion("costIsVerify in", values, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyNotIn(List<Boolean> values) {
            addCriterion("costIsVerify not in", values, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyBetween(Boolean value1, Boolean value2) {
            addCriterion("costIsVerify between", value1, value2, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andCostIsVerifyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("costIsVerify not between", value1, value2, "costIsVerify");
            return (Criteria) this;
        }

        public Criteria andTaskCostIsNull() {
            addCriterion("taskCost is null");
            return (Criteria) this;
        }

        public Criteria andTaskCostIsNotNull() {
            addCriterion("taskCost is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCostEqualTo(BigDecimal value) {
            addCriterion("taskCost =", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostNotEqualTo(BigDecimal value) {
            addCriterion("taskCost <>", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostGreaterThan(BigDecimal value) {
            addCriterion("taskCost >", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taskCost >=", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostLessThan(BigDecimal value) {
            addCriterion("taskCost <", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taskCost <=", value, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostIn(List<BigDecimal> values) {
            addCriterion("taskCost in", values, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostNotIn(List<BigDecimal> values) {
            addCriterion("taskCost not in", values, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taskCost between", value1, value2, "taskCost");
            return (Criteria) this;
        }

        public Criteria andTaskCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taskCost not between", value1, value2, "taskCost");
            return (Criteria) this;
        }

        public Criteria andVerifyByIsNull() {
            addCriterion("verifyBy is null");
            return (Criteria) this;
        }

        public Criteria andVerifyByIsNotNull() {
            addCriterion("verifyBy is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyByEqualTo(Long value) {
            addCriterion("verifyBy =", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByNotEqualTo(Long value) {
            addCriterion("verifyBy <>", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByGreaterThan(Long value) {
            addCriterion("verifyBy >", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByGreaterThanOrEqualTo(Long value) {
            addCriterion("verifyBy >=", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByLessThan(Long value) {
            addCriterion("verifyBy <", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByLessThanOrEqualTo(Long value) {
            addCriterion("verifyBy <=", value, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByIn(List<Long> values) {
            addCriterion("verifyBy in", values, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByNotIn(List<Long> values) {
            addCriterion("verifyBy not in", values, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByBetween(Long value1, Long value2) {
            addCriterion("verifyBy between", value1, value2, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVerifyByNotBetween(Long value1, Long value2) {
            addCriterion("verifyBy not between", value1, value2, "verifyBy");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeIsNull() {
            addCriterion("veribyTime is null");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeIsNotNull() {
            addCriterion("veribyTime is not null");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeEqualTo(Date value) {
            addCriterion("veribyTime =", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeNotEqualTo(Date value) {
            addCriterion("veribyTime <>", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeGreaterThan(Date value) {
            addCriterion("veribyTime >", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("veribyTime >=", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeLessThan(Date value) {
            addCriterion("veribyTime <", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeLessThanOrEqualTo(Date value) {
            addCriterion("veribyTime <=", value, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeIn(List<Date> values) {
            addCriterion("veribyTime in", values, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeNotIn(List<Date> values) {
            addCriterion("veribyTime not in", values, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeBetween(Date value1, Date value2) {
            addCriterion("veribyTime between", value1, value2, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyTimeNotBetween(Date value1, Date value2) {
            addCriterion("veribyTime not between", value1, value2, "veribyTime");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoIsNull() {
            addCriterion("veribyMemo is null");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoIsNotNull() {
            addCriterion("veribyMemo is not null");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoEqualTo(String value) {
            addCriterion("veribyMemo =", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoNotEqualTo(String value) {
            addCriterion("veribyMemo <>", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoGreaterThan(String value) {
            addCriterion("veribyMemo >", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoGreaterThanOrEqualTo(String value) {
            addCriterion("veribyMemo >=", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoLessThan(String value) {
            addCriterion("veribyMemo <", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoLessThanOrEqualTo(String value) {
            addCriterion("veribyMemo <=", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoLike(String value) {
            addCriterion("veribyMemo like", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoNotLike(String value) {
            addCriterion("veribyMemo not like", value, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoIn(List<String> values) {
            addCriterion("veribyMemo in", values, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoNotIn(List<String> values) {
            addCriterion("veribyMemo not in", values, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoBetween(String value1, String value2) {
            addCriterion("veribyMemo between", value1, value2, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andVeribyMemoNotBetween(String value1, String value2) {
            addCriterion("veribyMemo not between", value1, value2, "veribyMemo");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNull() {
            addCriterion("isComment is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNotNull() {
            addCriterion("isComment is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentEqualTo(Boolean value) {
            addCriterion("isComment =", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotEqualTo(Boolean value) {
            addCriterion("isComment <>", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThan(Boolean value) {
            addCriterion("isComment >", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isComment >=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThan(Boolean value) {
            addCriterion("isComment <", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("isComment <=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentIn(List<Boolean> values) {
            addCriterion("isComment in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotIn(List<Boolean> values) {
            addCriterion("isComment not in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("isComment between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isComment not between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andCommentByIsNull() {
            addCriterion("commentBy is null");
            return (Criteria) this;
        }

        public Criteria andCommentByIsNotNull() {
            addCriterion("commentBy is not null");
            return (Criteria) this;
        }

        public Criteria andCommentByEqualTo(Long value) {
            addCriterion("commentBy =", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByNotEqualTo(Long value) {
            addCriterion("commentBy <>", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByGreaterThan(Long value) {
            addCriterion("commentBy >", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByGreaterThanOrEqualTo(Long value) {
            addCriterion("commentBy >=", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByLessThan(Long value) {
            addCriterion("commentBy <", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByLessThanOrEqualTo(Long value) {
            addCriterion("commentBy <=", value, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByIn(List<Long> values) {
            addCriterion("commentBy in", values, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByNotIn(List<Long> values) {
            addCriterion("commentBy not in", values, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByBetween(Long value1, Long value2) {
            addCriterion("commentBy between", value1, value2, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentByNotBetween(Long value1, Long value2) {
            addCriterion("commentBy not between", value1, value2, "commentBy");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("commentTime is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("commentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("commentTime =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("commentTime <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("commentTime >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commentTime >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("commentTime <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("commentTime <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("commentTime in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("commentTime not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("commentTime between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("commentTime not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIsNull() {
            addCriterion("commentGrade is null");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIsNotNull() {
            addCriterion("commentGrade is not null");
            return (Criteria) this;
        }

        public Criteria andCommentGradeEqualTo(CommentGrade value) {
            addCriterion("commentGrade =", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotEqualTo(CommentGrade value) {
            addCriterion("commentGrade <>", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeGreaterThan(CommentGrade value) {
            addCriterion("commentGrade >", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeGreaterThanOrEqualTo(CommentGrade value) {
            addCriterion("commentGrade >=", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeLessThan(CommentGrade value) {
            addCriterion("commentGrade <", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeLessThanOrEqualTo(CommentGrade value) {
            addCriterion("commentGrade <=", value, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeIn(List<CommentGrade> values) {
            addCriterion("commentGrade in", values, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotIn(List<CommentGrade> values) {
            addCriterion("commentGrade not in", values, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeBetween(CommentGrade value1, CommentGrade value2) {
            addCriterion("commentGrade between", value1, value2, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentGradeNotBetween(CommentGrade value1, CommentGrade value2) {
            addCriterion("commentGrade not between", value1, value2, "commentGrade");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("commentContent is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("commentContent is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("commentContent =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("commentContent <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("commentContent >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("commentContent >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("commentContent <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("commentContent <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("commentContent like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("commentContent not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("commentContent in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("commentContent not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("commentContent between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("commentContent not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeIsNull() {
            addCriterion("commentStarGrade is null");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeIsNotNull() {
            addCriterion("commentStarGrade is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeEqualTo(Integer value) {
            addCriterion("commentStarGrade =", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeNotEqualTo(Integer value) {
            addCriterion("commentStarGrade <>", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeGreaterThan(Integer value) {
            addCriterion("commentStarGrade >", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentStarGrade >=", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeLessThan(Integer value) {
            addCriterion("commentStarGrade <", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeLessThanOrEqualTo(Integer value) {
            addCriterion("commentStarGrade <=", value, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeIn(List<Integer> values) {
            addCriterion("commentStarGrade in", values, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeNotIn(List<Integer> values) {
            addCriterion("commentStarGrade not in", values, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeBetween(Integer value1, Integer value2) {
            addCriterion("commentStarGrade between", value1, value2, "commentStarGrade");
            return (Criteria) this;
        }

        public Criteria andCommentStarGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("commentStarGrade not between", value1, value2, "commentStarGrade");
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

        public Criteria andUpdateMemoIsNull() {
            addCriterion("updateMemo is null");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoIsNotNull() {
            addCriterion("updateMemo is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoEqualTo(String value) {
            addCriterion("updateMemo =", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoNotEqualTo(String value) {
            addCriterion("updateMemo <>", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoGreaterThan(String value) {
            addCriterion("updateMemo >", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoGreaterThanOrEqualTo(String value) {
            addCriterion("updateMemo >=", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoLessThan(String value) {
            addCriterion("updateMemo <", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoLessThanOrEqualTo(String value) {
            addCriterion("updateMemo <=", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoLike(String value) {
            addCriterion("updateMemo like", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoNotLike(String value) {
            addCriterion("updateMemo not like", value, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoIn(List<String> values) {
            addCriterion("updateMemo in", values, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoNotIn(List<String> values) {
            addCriterion("updateMemo not in", values, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoBetween(String value1, String value2) {
            addCriterion("updateMemo between", value1, value2, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andUpdateMemoNotBetween(String value1, String value2) {
            addCriterion("updateMemo not between", value1, value2, "updateMemo");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNull() {
            addCriterion("history is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNotNull() {
            addCriterion("history is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryEqualTo(String value) {
            addCriterion("history =", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotEqualTo(String value) {
            addCriterion("history <>", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThan(String value) {
            addCriterion("history >", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("history >=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThan(String value) {
            addCriterion("history <", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThanOrEqualTo(String value) {
            addCriterion("history <=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLike(String value) {
            addCriterion("history like", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotLike(String value) {
            addCriterion("history not like", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryIn(List<String> values) {
            addCriterion("history in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotIn(List<String> values) {
            addCriterion("history not in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryBetween(String value1, String value2) {
            addCriterion("history between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotBetween(String value1, String value2) {
            addCriterion("history not between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andIsChooseIsNull() {
            addCriterion("isChoose is null");
            return (Criteria) this;
        }

        public Criteria andIsChooseIsNotNull() {
            addCriterion("isChoose is not null");
            return (Criteria) this;
        }

        public Criteria andIsChooseEqualTo(Integer value) {
            addCriterion("isChoose =", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotEqualTo(Integer value) {
            addCriterion("isChoose <>", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseGreaterThan(Integer value) {
            addCriterion("isChoose >", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseGreaterThanOrEqualTo(Integer value) {
            addCriterion("isChoose >=", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseLessThan(Integer value) {
            addCriterion("isChoose <", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseLessThanOrEqualTo(Integer value) {
            addCriterion("isChoose <=", value, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseIn(List<Integer> values) {
            addCriterion("isChoose in", values, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotIn(List<Integer> values) {
            addCriterion("isChoose not in", values, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseBetween(Integer value1, Integer value2) {
            addCriterion("isChoose between", value1, value2, "isChoose");
            return (Criteria) this;
        }

        public Criteria andIsChooseNotBetween(Integer value1, Integer value2) {
            addCriterion("isChoose not between", value1, value2, "isChoose");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("billId is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("billId is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("billId =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("billId <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("billId >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("billId >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("billId <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("billId <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("billId in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("billId not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("billId between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("billId not between", value1, value2, "billId");
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