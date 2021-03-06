package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillCcrAdjEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCcrAdjEntityExample() {
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

        public Criteria andBccrIdIsNull() {
            addCriterion("bccrId is null");
            return (Criteria) this;
        }

        public Criteria andBccrIdIsNotNull() {
            addCriterion("bccrId is not null");
            return (Criteria) this;
        }

        public Criteria andBccrIdEqualTo(Long value) {
            addCriterion("bccrId =", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotEqualTo(Long value) {
            addCriterion("bccrId <>", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdGreaterThan(Long value) {
            addCriterion("bccrId >", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bccrId >=", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdLessThan(Long value) {
            addCriterion("bccrId <", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdLessThanOrEqualTo(Long value) {
            addCriterion("bccrId <=", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdIn(List<Long> values) {
            addCriterion("bccrId in", values, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotIn(List<Long> values) {
            addCriterion("bccrId not in", values, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdBetween(Long value1, Long value2) {
            addCriterion("bccrId between", value1, value2, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotBetween(Long value1, Long value2) {
            addCriterion("bccrId not between", value1, value2, "bccrId");
            return (Criteria) this;
        }

        public Criteria andAdjAmountIsNull() {
            addCriterion("adjAmount is null");
            return (Criteria) this;
        }

        public Criteria andAdjAmountIsNotNull() {
            addCriterion("adjAmount is not null");
            return (Criteria) this;
        }

        public Criteria andAdjAmountEqualTo(BigDecimal value) {
            addCriterion("adjAmount =", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountNotEqualTo(BigDecimal value) {
            addCriterion("adjAmount <>", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountGreaterThan(BigDecimal value) {
            addCriterion("adjAmount >", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjAmount >=", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountLessThan(BigDecimal value) {
            addCriterion("adjAmount <", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjAmount <=", value, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountIn(List<BigDecimal> values) {
            addCriterion("adjAmount in", values, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountNotIn(List<BigDecimal> values) {
            addCriterion("adjAmount not in", values, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjAmount between", value1, value2, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjAmount not between", value1, value2, "adjAmount");
            return (Criteria) this;
        }

        public Criteria andAdjMonthIsNull() {
            addCriterion("adjMonth is null");
            return (Criteria) this;
        }

        public Criteria andAdjMonthIsNotNull() {
            addCriterion("adjMonth is not null");
            return (Criteria) this;
        }

        public Criteria andAdjMonthEqualTo(String value) {
            addCriterion("adjMonth =", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthNotEqualTo(String value) {
            addCriterion("adjMonth <>", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthGreaterThan(String value) {
            addCriterion("adjMonth >", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthGreaterThanOrEqualTo(String value) {
            addCriterion("adjMonth >=", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthLessThan(String value) {
            addCriterion("adjMonth <", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthLessThanOrEqualTo(String value) {
            addCriterion("adjMonth <=", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthLike(String value) {
            addCriterion("adjMonth like", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthNotLike(String value) {
            addCriterion("adjMonth not like", value, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthIn(List<String> values) {
            addCriterion("adjMonth in", values, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthNotIn(List<String> values) {
            addCriterion("adjMonth not in", values, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthBetween(String value1, String value2) {
            addCriterion("adjMonth between", value1, value2, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjMonthNotBetween(String value1, String value2) {
            addCriterion("adjMonth not between", value1, value2, "adjMonth");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkIsNull() {
            addCriterion("adjRemark is null");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkIsNotNull() {
            addCriterion("adjRemark is not null");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkEqualTo(String value) {
            addCriterion("adjRemark =", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkNotEqualTo(String value) {
            addCriterion("adjRemark <>", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkGreaterThan(String value) {
            addCriterion("adjRemark >", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("adjRemark >=", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkLessThan(String value) {
            addCriterion("adjRemark <", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkLessThanOrEqualTo(String value) {
            addCriterion("adjRemark <=", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkLike(String value) {
            addCriterion("adjRemark like", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkNotLike(String value) {
            addCriterion("adjRemark not like", value, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkIn(List<String> values) {
            addCriterion("adjRemark in", values, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkNotIn(List<String> values) {
            addCriterion("adjRemark not in", values, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkBetween(String value1, String value2) {
            addCriterion("adjRemark between", value1, value2, "adjRemark");
            return (Criteria) this;
        }

        public Criteria andAdjRemarkNotBetween(String value1, String value2) {
            addCriterion("adjRemark not between", value1, value2, "adjRemark");
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