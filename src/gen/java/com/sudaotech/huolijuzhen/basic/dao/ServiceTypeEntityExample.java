package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceTypeEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceTypeEntityExample() {
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

        public Criteria andIsRecoIsNull() {
            addCriterion("isReco is null");
            return (Criteria) this;
        }

        public Criteria andIsRecoIsNotNull() {
            addCriterion("isReco is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecoEqualTo(Boolean value) {
            addCriterion("isReco =", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoNotEqualTo(Boolean value) {
            addCriterion("isReco <>", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoGreaterThan(Boolean value) {
            addCriterion("isReco >", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isReco >=", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoLessThan(Boolean value) {
            addCriterion("isReco <", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoLessThanOrEqualTo(Boolean value) {
            addCriterion("isReco <=", value, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoIn(List<Boolean> values) {
            addCriterion("isReco in", values, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoNotIn(List<Boolean> values) {
            addCriterion("isReco not in", values, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoBetween(Boolean value1, Boolean value2) {
            addCriterion("isReco between", value1, value2, "isReco");
            return (Criteria) this;
        }

        public Criteria andIsRecoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isReco not between", value1, value2, "isReco");
            return (Criteria) this;
        }

        public Criteria andServerGradeIsNull() {
            addCriterion("serverGrade is null");
            return (Criteria) this;
        }

        public Criteria andServerGradeIsNotNull() {
            addCriterion("serverGrade is not null");
            return (Criteria) this;
        }

        public Criteria andServerGradeEqualTo(ServerGrade value) {
            addCriterion("serverGrade =", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeNotEqualTo(ServerGrade value) {
            addCriterion("serverGrade <>", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeGreaterThan(ServerGrade value) {
            addCriterion("serverGrade >", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeGreaterThanOrEqualTo(ServerGrade value) {
            addCriterion("serverGrade >=", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeLessThan(ServerGrade value) {
            addCriterion("serverGrade <", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeLessThanOrEqualTo(ServerGrade value) {
            addCriterion("serverGrade <=", value, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeIn(List<ServerGrade> values) {
            addCriterion("serverGrade in", values, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeNotIn(List<ServerGrade> values) {
            addCriterion("serverGrade not in", values, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeBetween(ServerGrade value1, ServerGrade value2) {
            addCriterion("serverGrade between", value1, value2, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andServerGradeNotBetween(ServerGrade value1, ServerGrade value2) {
            addCriterion("serverGrade not between", value1, value2, "serverGrade");
            return (Criteria) this;
        }

        public Criteria andDescribleIsNull() {
            addCriterion("describle is null");
            return (Criteria) this;
        }

        public Criteria andDescribleIsNotNull() {
            addCriterion("describle is not null");
            return (Criteria) this;
        }

        public Criteria andDescribleEqualTo(String value) {
            addCriterion("describle =", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleNotEqualTo(String value) {
            addCriterion("describle <>", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleGreaterThan(String value) {
            addCriterion("describle >", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleGreaterThanOrEqualTo(String value) {
            addCriterion("describle >=", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleLessThan(String value) {
            addCriterion("describle <", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleLessThanOrEqualTo(String value) {
            addCriterion("describle <=", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleLike(String value) {
            addCriterion("describle like", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleNotLike(String value) {
            addCriterion("describle not like", value, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleIn(List<String> values) {
            addCriterion("describle in", values, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleNotIn(List<String> values) {
            addCriterion("describle not in", values, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleBetween(String value1, String value2) {
            addCriterion("describle between", value1, value2, "describle");
            return (Criteria) this;
        }

        public Criteria andDescribleNotBetween(String value1, String value2) {
            addCriterion("describle not between", value1, value2, "describle");
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

        public Criteria andRecoByIsNull() {
            addCriterion("recoBy is null");
            return (Criteria) this;
        }

        public Criteria andRecoByIsNotNull() {
            addCriterion("recoBy is not null");
            return (Criteria) this;
        }

        public Criteria andRecoByEqualTo(Long value) {
            addCriterion("recoBy =", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByNotEqualTo(Long value) {
            addCriterion("recoBy <>", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByGreaterThan(Long value) {
            addCriterion("recoBy >", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByGreaterThanOrEqualTo(Long value) {
            addCriterion("recoBy >=", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByLessThan(Long value) {
            addCriterion("recoBy <", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByLessThanOrEqualTo(Long value) {
            addCriterion("recoBy <=", value, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByIn(List<Long> values) {
            addCriterion("recoBy in", values, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByNotIn(List<Long> values) {
            addCriterion("recoBy not in", values, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByBetween(Long value1, Long value2) {
            addCriterion("recoBy between", value1, value2, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoByNotBetween(Long value1, Long value2) {
            addCriterion("recoBy not between", value1, value2, "recoBy");
            return (Criteria) this;
        }

        public Criteria andRecoTimeIsNull() {
            addCriterion("recoTime is null");
            return (Criteria) this;
        }

        public Criteria andRecoTimeIsNotNull() {
            addCriterion("recoTime is not null");
            return (Criteria) this;
        }

        public Criteria andRecoTimeEqualTo(Date value) {
            addCriterion("recoTime =", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeNotEqualTo(Date value) {
            addCriterion("recoTime <>", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeGreaterThan(Date value) {
            addCriterion("recoTime >", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recoTime >=", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeLessThan(Date value) {
            addCriterion("recoTime <", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeLessThanOrEqualTo(Date value) {
            addCriterion("recoTime <=", value, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeIn(List<Date> values) {
            addCriterion("recoTime in", values, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeNotIn(List<Date> values) {
            addCriterion("recoTime not in", values, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeBetween(Date value1, Date value2) {
            addCriterion("recoTime between", value1, value2, "recoTime");
            return (Criteria) this;
        }

        public Criteria andRecoTimeNotBetween(Date value1, Date value2) {
            addCriterion("recoTime not between", value1, value2, "recoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoByIsNull() {
            addCriterion("unRecoBy is null");
            return (Criteria) this;
        }

        public Criteria andUnRecoByIsNotNull() {
            addCriterion("unRecoBy is not null");
            return (Criteria) this;
        }

        public Criteria andUnRecoByEqualTo(Long value) {
            addCriterion("unRecoBy =", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByNotEqualTo(Long value) {
            addCriterion("unRecoBy <>", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByGreaterThan(Long value) {
            addCriterion("unRecoBy >", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByGreaterThanOrEqualTo(Long value) {
            addCriterion("unRecoBy >=", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByLessThan(Long value) {
            addCriterion("unRecoBy <", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByLessThanOrEqualTo(Long value) {
            addCriterion("unRecoBy <=", value, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByIn(List<Long> values) {
            addCriterion("unRecoBy in", values, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByNotIn(List<Long> values) {
            addCriterion("unRecoBy not in", values, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByBetween(Long value1, Long value2) {
            addCriterion("unRecoBy between", value1, value2, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoByNotBetween(Long value1, Long value2) {
            addCriterion("unRecoBy not between", value1, value2, "unRecoBy");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeIsNull() {
            addCriterion("unRecoTime is null");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeIsNotNull() {
            addCriterion("unRecoTime is not null");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeEqualTo(Date value) {
            addCriterion("unRecoTime =", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeNotEqualTo(Date value) {
            addCriterion("unRecoTime <>", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeGreaterThan(Date value) {
            addCriterion("unRecoTime >", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("unRecoTime >=", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeLessThan(Date value) {
            addCriterion("unRecoTime <", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeLessThanOrEqualTo(Date value) {
            addCriterion("unRecoTime <=", value, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeIn(List<Date> values) {
            addCriterion("unRecoTime in", values, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeNotIn(List<Date> values) {
            addCriterion("unRecoTime not in", values, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeBetween(Date value1, Date value2) {
            addCriterion("unRecoTime between", value1, value2, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andUnRecoTimeNotBetween(Date value1, Date value2) {
            addCriterion("unRecoTime not between", value1, value2, "unRecoTime");
            return (Criteria) this;
        }

        public Criteria andTypeLogoIsNull() {
            addCriterion("typeLogo is null");
            return (Criteria) this;
        }

        public Criteria andTypeLogoIsNotNull() {
            addCriterion("typeLogo is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLogoEqualTo(String value) {
            addCriterion("typeLogo =", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoNotEqualTo(String value) {
            addCriterion("typeLogo <>", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoGreaterThan(String value) {
            addCriterion("typeLogo >", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoGreaterThanOrEqualTo(String value) {
            addCriterion("typeLogo >=", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoLessThan(String value) {
            addCriterion("typeLogo <", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoLessThanOrEqualTo(String value) {
            addCriterion("typeLogo <=", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoLike(String value) {
            addCriterion("typeLogo like", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoNotLike(String value) {
            addCriterion("typeLogo not like", value, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoIn(List<String> values) {
            addCriterion("typeLogo in", values, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoNotIn(List<String> values) {
            addCriterion("typeLogo not in", values, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoBetween(String value1, String value2) {
            addCriterion("typeLogo between", value1, value2, "typeLogo");
            return (Criteria) this;
        }

        public Criteria andTypeLogoNotBetween(String value1, String value2) {
            addCriterion("typeLogo not between", value1, value2, "typeLogo");
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

        public Criteria andRecoLogoIsNull() {
            addCriterion("recoLogo is null");
            return (Criteria) this;
        }

        public Criteria andRecoLogoIsNotNull() {
            addCriterion("recoLogo is not null");
            return (Criteria) this;
        }

        public Criteria andRecoLogoEqualTo(String value) {
            addCriterion("recoLogo =", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoNotEqualTo(String value) {
            addCriterion("recoLogo <>", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoGreaterThan(String value) {
            addCriterion("recoLogo >", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoGreaterThanOrEqualTo(String value) {
            addCriterion("recoLogo >=", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoLessThan(String value) {
            addCriterion("recoLogo <", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoLessThanOrEqualTo(String value) {
            addCriterion("recoLogo <=", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoLike(String value) {
            addCriterion("recoLogo like", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoNotLike(String value) {
            addCriterion("recoLogo not like", value, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoIn(List<String> values) {
            addCriterion("recoLogo in", values, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoNotIn(List<String> values) {
            addCriterion("recoLogo not in", values, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoBetween(String value1, String value2) {
            addCriterion("recoLogo between", value1, value2, "recoLogo");
            return (Criteria) this;
        }

        public Criteria andRecoLogoNotBetween(String value1, String value2) {
            addCriterion("recoLogo not between", value1, value2, "recoLogo");
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