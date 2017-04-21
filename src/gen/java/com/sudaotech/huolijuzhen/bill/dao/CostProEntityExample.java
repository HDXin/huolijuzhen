package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostProEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostProEntityExample() {
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

        public Criteria andChargeModeIsNull() {
            addCriterion("chargeMode is null");
            return (Criteria) this;
        }

        public Criteria andChargeModeIsNotNull() {
            addCriterion("chargeMode is not null");
            return (Criteria) this;
        }

        public Criteria andChargeModeEqualTo(ChargeMode value) {
            addCriterion("chargeMode =", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeNotEqualTo(ChargeMode value) {
            addCriterion("chargeMode <>", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeGreaterThan(ChargeMode value) {
            addCriterion("chargeMode >", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeGreaterThanOrEqualTo(ChargeMode value) {
            addCriterion("chargeMode >=", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeLessThan(ChargeMode value) {
            addCriterion("chargeMode <", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeLessThanOrEqualTo(ChargeMode value) {
            addCriterion("chargeMode <=", value, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeIn(List<ChargeMode> values) {
            addCriterion("chargeMode in", values, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeNotIn(List<ChargeMode> values) {
            addCriterion("chargeMode not in", values, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeBetween(ChargeMode value1, ChargeMode value2) {
            addCriterion("chargeMode between", value1, value2, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargeModeNotBetween(ChargeMode value1, ChargeMode value2) {
            addCriterion("chargeMode not between", value1, value2, "chargeMode");
            return (Criteria) this;
        }

        public Criteria andChargePriceIsNull() {
            addCriterion("chargePrice is null");
            return (Criteria) this;
        }

        public Criteria andChargePriceIsNotNull() {
            addCriterion("chargePrice is not null");
            return (Criteria) this;
        }

        public Criteria andChargePriceEqualTo(BigDecimal value) {
            addCriterion("chargePrice =", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotEqualTo(BigDecimal value) {
            addCriterion("chargePrice <>", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceGreaterThan(BigDecimal value) {
            addCriterion("chargePrice >", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("chargePrice >=", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceLessThan(BigDecimal value) {
            addCriterion("chargePrice <", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("chargePrice <=", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceIn(List<BigDecimal> values) {
            addCriterion("chargePrice in", values, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotIn(List<BigDecimal> values) {
            addCriterion("chargePrice not in", values, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chargePrice between", value1, value2, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("chargePrice not between", value1, value2, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNull() {
            addCriterion("costRate is null");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNotNull() {
            addCriterion("costRate is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateEqualTo(BigDecimal value) {
            addCriterion("costRate =", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotEqualTo(BigDecimal value) {
            addCriterion("costRate <>", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThan(BigDecimal value) {
            addCriterion("costRate >", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costRate >=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThan(BigDecimal value) {
            addCriterion("costRate <", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costRate <=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIn(List<BigDecimal> values) {
            addCriterion("costRate in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotIn(List<BigDecimal> values) {
            addCriterion("costRate not in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costRate between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costRate not between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNull() {
            addCriterion("createSource is null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNotNull() {
            addCriterion("createSource is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceEqualTo(CreateSource value) {
            addCriterion("createSource =", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotEqualTo(CreateSource value) {
            addCriterion("createSource <>", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThan(CreateSource value) {
            addCriterion("createSource >", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThanOrEqualTo(CreateSource value) {
            addCriterion("createSource >=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThan(CreateSource value) {
            addCriterion("createSource <", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThanOrEqualTo(CreateSource value) {
            addCriterion("createSource <=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIn(List<CreateSource> values) {
            addCriterion("createSource in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotIn(List<CreateSource> values) {
            addCriterion("createSource not in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceBetween(CreateSource value1, CreateSource value2) {
            addCriterion("createSource between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotBetween(CreateSource value1, CreateSource value2) {
            addCriterion("createSource not between", value1, value2, "createSource");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("isDefault is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("isDefault is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Integer value) {
            addCriterion("isDefault =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Integer value) {
            addCriterion("isDefault <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Integer value) {
            addCriterion("isDefault >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDefault >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Integer value) {
            addCriterion("isDefault <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("isDefault <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Integer> values) {
            addCriterion("isDefault in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Integer> values) {
            addCriterion("isDefault not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            addCriterion("isDefault between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("isDefault not between", value1, value2, "isDefault");
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

        public Criteria andRecommendStatusIsNull() {
            addCriterion("recommendStatus is null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNotNull() {
            addCriterion("recommendStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusEqualTo(Integer value) {
            addCriterion("recommendStatus =", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotEqualTo(Integer value) {
            addCriterion("recommendStatus <>", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThan(Integer value) {
            addCriterion("recommendStatus >", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommendStatus >=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThan(Integer value) {
            addCriterion("recommendStatus <", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("recommendStatus <=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIn(List<Integer> values) {
            addCriterion("recommendStatus in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotIn(List<Integer> values) {
            addCriterion("recommendStatus not in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusBetween(Integer value1, Integer value2) {
            addCriterion("recommendStatus between", value1, value2, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("recommendStatus not between", value1, value2, "recommendStatus");
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