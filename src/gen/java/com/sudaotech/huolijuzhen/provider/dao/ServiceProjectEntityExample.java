package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceProjectEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceProjectEntityExample() {
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

        public Criteria andMainTitleIsNull() {
            addCriterion("mainTitle is null");
            return (Criteria) this;
        }

        public Criteria andMainTitleIsNotNull() {
            addCriterion("mainTitle is not null");
            return (Criteria) this;
        }

        public Criteria andMainTitleEqualTo(String value) {
            addCriterion("mainTitle =", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotEqualTo(String value) {
            addCriterion("mainTitle <>", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleGreaterThan(String value) {
            addCriterion("mainTitle >", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mainTitle >=", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLessThan(String value) {
            addCriterion("mainTitle <", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLessThanOrEqualTo(String value) {
            addCriterion("mainTitle <=", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLike(String value) {
            addCriterion("mainTitle like", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotLike(String value) {
            addCriterion("mainTitle not like", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleIn(List<String> values) {
            addCriterion("mainTitle in", values, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotIn(List<String> values) {
            addCriterion("mainTitle not in", values, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleBetween(String value1, String value2) {
            addCriterion("mainTitle between", value1, value2, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotBetween(String value1, String value2) {
            addCriterion("mainTitle not between", value1, value2, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNull() {
            addCriterion("subTitle is null");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("subTitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("subTitle =", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("subTitle <>", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("subTitle >", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("subTitle >=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("subTitle <", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("subTitle <=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("subTitle like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("subTitle not like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIn(List<String> values) {
            addCriterion("subTitle in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotIn(List<String> values) {
            addCriterion("subTitle not in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("subTitle between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("subTitle not between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIsNull() {
            addCriterion("serviceTypeId is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIsNotNull() {
            addCriterion("serviceTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdEqualTo(Long value) {
            addCriterion("serviceTypeId =", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotEqualTo(Long value) {
            addCriterion("serviceTypeId <>", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThan(Long value) {
            addCriterion("serviceTypeId >", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("serviceTypeId >=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThan(Long value) {
            addCriterion("serviceTypeId <", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("serviceTypeId <=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIn(List<Long> values) {
            addCriterion("serviceTypeId in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotIn(List<Long> values) {
            addCriterion("serviceTypeId not in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdBetween(Long value1, Long value2) {
            addCriterion("serviceTypeId between", value1, value2, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("serviceTypeId not between", value1, value2, "serviceTypeId");
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

        public Criteria andServiceGradeIsNull() {
            addCriterion("serviceGrade is null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIsNotNull() {
            addCriterion("serviceGrade is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeEqualTo(ServiceGrade value) {
            addCriterion("serviceGrade =", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotEqualTo(ServiceGrade value) {
            addCriterion("serviceGrade <>", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeGreaterThan(ServiceGrade value) {
            addCriterion("serviceGrade >", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeGreaterThanOrEqualTo(ServiceGrade value) {
            addCriterion("serviceGrade >=", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeLessThan(ServiceGrade value) {
            addCriterion("serviceGrade <", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeLessThanOrEqualTo(ServiceGrade value) {
            addCriterion("serviceGrade <=", value, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIn(List<ServiceGrade> values) {
            addCriterion("serviceGrade in", values, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotIn(List<ServiceGrade> values) {
            addCriterion("serviceGrade not in", values, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeBetween(ServiceGrade value1, ServiceGrade value2) {
            addCriterion("serviceGrade between", value1, value2, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNotBetween(ServiceGrade value1, ServiceGrade value2) {
            addCriterion("serviceGrade not between", value1, value2, "serviceGrade");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdIsNull() {
            addCriterion("serviceGradeId is null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdIsNotNull() {
            addCriterion("serviceGradeId is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdEqualTo(Long value) {
            addCriterion("serviceGradeId =", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdNotEqualTo(Long value) {
            addCriterion("serviceGradeId <>", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdGreaterThan(Long value) {
            addCriterion("serviceGradeId >", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("serviceGradeId >=", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdLessThan(Long value) {
            addCriterion("serviceGradeId <", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("serviceGradeId <=", value, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdIn(List<Long> values) {
            addCriterion("serviceGradeId in", values, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdNotIn(List<Long> values) {
            addCriterion("serviceGradeId not in", values, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdBetween(Long value1, Long value2) {
            addCriterion("serviceGradeId between", value1, value2, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("serviceGradeId not between", value1, value2, "serviceGradeId");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameIsNull() {
            addCriterion("serviceGradeName is null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameIsNotNull() {
            addCriterion("serviceGradeName is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameEqualTo(String value) {
            addCriterion("serviceGradeName =", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameNotEqualTo(String value) {
            addCriterion("serviceGradeName <>", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameGreaterThan(String value) {
            addCriterion("serviceGradeName >", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("serviceGradeName >=", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameLessThan(String value) {
            addCriterion("serviceGradeName <", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameLessThanOrEqualTo(String value) {
            addCriterion("serviceGradeName <=", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameLike(String value) {
            addCriterion("serviceGradeName like", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameNotLike(String value) {
            addCriterion("serviceGradeName not like", value, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameIn(List<String> values) {
            addCriterion("serviceGradeName in", values, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameNotIn(List<String> values) {
            addCriterion("serviceGradeName not in", values, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameBetween(String value1, String value2) {
            addCriterion("serviceGradeName between", value1, value2, "serviceGradeName");
            return (Criteria) this;
        }

        public Criteria andServiceGradeNameNotBetween(String value1, String value2) {
            addCriterion("serviceGradeName not between", value1, value2, "serviceGradeName");
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

        public Criteria andSupportApplyIsNull() {
            addCriterion("supportApply is null");
            return (Criteria) this;
        }

        public Criteria andSupportApplyIsNotNull() {
            addCriterion("supportApply is not null");
            return (Criteria) this;
        }

        public Criteria andSupportApplyEqualTo(Boolean value) {
            addCriterion("supportApply =", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyNotEqualTo(Boolean value) {
            addCriterion("supportApply <>", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyGreaterThan(Boolean value) {
            addCriterion("supportApply >", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("supportApply >=", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyLessThan(Boolean value) {
            addCriterion("supportApply <", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyLessThanOrEqualTo(Boolean value) {
            addCriterion("supportApply <=", value, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyIn(List<Boolean> values) {
            addCriterion("supportApply in", values, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyNotIn(List<Boolean> values) {
            addCriterion("supportApply not in", values, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyBetween(Boolean value1, Boolean value2) {
            addCriterion("supportApply between", value1, value2, "supportApply");
            return (Criteria) this;
        }

        public Criteria andSupportApplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("supportApply not between", value1, value2, "supportApply");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdIsNull() {
            addCriterion("applyViewId is null");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdIsNotNull() {
            addCriterion("applyViewId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdEqualTo(Long value) {
            addCriterion("applyViewId =", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdNotEqualTo(Long value) {
            addCriterion("applyViewId <>", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdGreaterThan(Long value) {
            addCriterion("applyViewId >", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdGreaterThanOrEqualTo(Long value) {
            addCriterion("applyViewId >=", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdLessThan(Long value) {
            addCriterion("applyViewId <", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdLessThanOrEqualTo(Long value) {
            addCriterion("applyViewId <=", value, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdIn(List<Long> values) {
            addCriterion("applyViewId in", values, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdNotIn(List<Long> values) {
            addCriterion("applyViewId not in", values, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdBetween(Long value1, Long value2) {
            addCriterion("applyViewId between", value1, value2, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andApplyViewIdNotBetween(Long value1, Long value2) {
            addCriterion("applyViewId not between", value1, value2, "applyViewId");
            return (Criteria) this;
        }

        public Criteria andSupportOrderIsNull() {
            addCriterion("supportOrder is null");
            return (Criteria) this;
        }

        public Criteria andSupportOrderIsNotNull() {
            addCriterion("supportOrder is not null");
            return (Criteria) this;
        }

        public Criteria andSupportOrderEqualTo(Boolean value) {
            addCriterion("supportOrder =", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderNotEqualTo(Boolean value) {
            addCriterion("supportOrder <>", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderGreaterThan(Boolean value) {
            addCriterion("supportOrder >", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("supportOrder >=", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderLessThan(Boolean value) {
            addCriterion("supportOrder <", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("supportOrder <=", value, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderIn(List<Boolean> values) {
            addCriterion("supportOrder in", values, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderNotIn(List<Boolean> values) {
            addCriterion("supportOrder not in", values, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("supportOrder between", value1, value2, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andSupportOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("supportOrder not between", value1, value2, "supportOrder");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdIsNull() {
            addCriterion("orderViewId is null");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdIsNotNull() {
            addCriterion("orderViewId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdEqualTo(Long value) {
            addCriterion("orderViewId =", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdNotEqualTo(Long value) {
            addCriterion("orderViewId <>", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdGreaterThan(Long value) {
            addCriterion("orderViewId >", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdGreaterThanOrEqualTo(Long value) {
            addCriterion("orderViewId >=", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdLessThan(Long value) {
            addCriterion("orderViewId <", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdLessThanOrEqualTo(Long value) {
            addCriterion("orderViewId <=", value, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdIn(List<Long> values) {
            addCriterion("orderViewId in", values, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdNotIn(List<Long> values) {
            addCriterion("orderViewId not in", values, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdBetween(Long value1, Long value2) {
            addCriterion("orderViewId between", value1, value2, "orderViewId");
            return (Criteria) this;
        }

        public Criteria andOrderViewIdNotBetween(Long value1, Long value2) {
            addCriterion("orderViewId not between", value1, value2, "orderViewId");
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

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approvalStatus is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approvalStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(ServiceApprovalStatus value) {
            addCriterion("approvalStatus =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(ServiceApprovalStatus value) {
            addCriterion("approvalStatus <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(ServiceApprovalStatus value) {
            addCriterion("approvalStatus >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(ServiceApprovalStatus value) {
            addCriterion("approvalStatus >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(ServiceApprovalStatus value) {
            addCriterion("approvalStatus <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(ServiceApprovalStatus value) {
            addCriterion("approvalStatus <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<ServiceApprovalStatus> values) {
            addCriterion("approvalStatus in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<ServiceApprovalStatus> values) {
            addCriterion("approvalStatus not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(ServiceApprovalStatus value1, ServiceApprovalStatus value2) {
            addCriterion("approvalStatus between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(ServiceApprovalStatus value1, ServiceApprovalStatus value2) {
            addCriterion("approvalStatus not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalByIsNull() {
            addCriterion("approvalBy is null");
            return (Criteria) this;
        }

        public Criteria andApprovalByIsNotNull() {
            addCriterion("approvalBy is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalByEqualTo(Long value) {
            addCriterion("approvalBy =", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotEqualTo(Long value) {
            addCriterion("approvalBy <>", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByGreaterThan(Long value) {
            addCriterion("approvalBy >", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalBy >=", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByLessThan(Long value) {
            addCriterion("approvalBy <", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByLessThanOrEqualTo(Long value) {
            addCriterion("approvalBy <=", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByIn(List<Long> values) {
            addCriterion("approvalBy in", values, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotIn(List<Long> values) {
            addCriterion("approvalBy not in", values, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByBetween(Long value1, Long value2) {
            addCriterion("approvalBy between", value1, value2, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotBetween(Long value1, Long value2) {
            addCriterion("approvalBy not between", value1, value2, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approvalTime is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approvalTime is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approvalTime =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approvalTime <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approvalTime >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approvalTime >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approvalTime <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approvalTime <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approvalTime in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approvalTime not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approvalTime between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approvalTime not between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTextIsNull() {
            addCriterion("approvalText is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTextIsNotNull() {
            addCriterion("approvalText is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTextEqualTo(String value) {
            addCriterion("approvalText =", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextNotEqualTo(String value) {
            addCriterion("approvalText <>", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextGreaterThan(String value) {
            addCriterion("approvalText >", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextGreaterThanOrEqualTo(String value) {
            addCriterion("approvalText >=", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextLessThan(String value) {
            addCriterion("approvalText <", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextLessThanOrEqualTo(String value) {
            addCriterion("approvalText <=", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextLike(String value) {
            addCriterion("approvalText like", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextNotLike(String value) {
            addCriterion("approvalText not like", value, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextIn(List<String> values) {
            addCriterion("approvalText in", values, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextNotIn(List<String> values) {
            addCriterion("approvalText not in", values, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextBetween(String value1, String value2) {
            addCriterion("approvalText between", value1, value2, "approvalText");
            return (Criteria) this;
        }

        public Criteria andApprovalTextNotBetween(String value1, String value2) {
            addCriterion("approvalText not between", value1, value2, "approvalText");
            return (Criteria) this;
        }

        public Criteria andParkProIdIsNull() {
            addCriterion("parkProId is null");
            return (Criteria) this;
        }

        public Criteria andParkProIdIsNotNull() {
            addCriterion("parkProId is not null");
            return (Criteria) this;
        }

        public Criteria andParkProIdEqualTo(Long value) {
            addCriterion("parkProId =", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdNotEqualTo(Long value) {
            addCriterion("parkProId <>", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdGreaterThan(Long value) {
            addCriterion("parkProId >", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkProId >=", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdLessThan(Long value) {
            addCriterion("parkProId <", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdLessThanOrEqualTo(Long value) {
            addCriterion("parkProId <=", value, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdIn(List<Long> values) {
            addCriterion("parkProId in", values, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdNotIn(List<Long> values) {
            addCriterion("parkProId not in", values, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdBetween(Long value1, Long value2) {
            addCriterion("parkProId between", value1, value2, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkProIdNotBetween(Long value1, Long value2) {
            addCriterion("parkProId not between", value1, value2, "parkProId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdIsNull() {
            addCriterion("parkCityId is null");
            return (Criteria) this;
        }

        public Criteria andParkCityIdIsNotNull() {
            addCriterion("parkCityId is not null");
            return (Criteria) this;
        }

        public Criteria andParkCityIdEqualTo(Long value) {
            addCriterion("parkCityId =", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdNotEqualTo(Long value) {
            addCriterion("parkCityId <>", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdGreaterThan(Long value) {
            addCriterion("parkCityId >", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkCityId >=", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdLessThan(Long value) {
            addCriterion("parkCityId <", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdLessThanOrEqualTo(Long value) {
            addCriterion("parkCityId <=", value, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdIn(List<Long> values) {
            addCriterion("parkCityId in", values, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdNotIn(List<Long> values) {
            addCriterion("parkCityId not in", values, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdBetween(Long value1, Long value2) {
            addCriterion("parkCityId between", value1, value2, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCityIdNotBetween(Long value1, Long value2) {
            addCriterion("parkCityId not between", value1, value2, "parkCityId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdIsNull() {
            addCriterion("parkCounId is null");
            return (Criteria) this;
        }

        public Criteria andParkCounIdIsNotNull() {
            addCriterion("parkCounId is not null");
            return (Criteria) this;
        }

        public Criteria andParkCounIdEqualTo(Long value) {
            addCriterion("parkCounId =", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdNotEqualTo(Long value) {
            addCriterion("parkCounId <>", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdGreaterThan(Long value) {
            addCriterion("parkCounId >", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkCounId >=", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdLessThan(Long value) {
            addCriterion("parkCounId <", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdLessThanOrEqualTo(Long value) {
            addCriterion("parkCounId <=", value, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdIn(List<Long> values) {
            addCriterion("parkCounId in", values, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdNotIn(List<Long> values) {
            addCriterion("parkCounId not in", values, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdBetween(Long value1, Long value2) {
            addCriterion("parkCounId between", value1, value2, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkCounIdNotBetween(Long value1, Long value2) {
            addCriterion("parkCounId not between", value1, value2, "parkCounId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdIsNull() {
            addCriterion("parkLocationId is null");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdIsNotNull() {
            addCriterion("parkLocationId is not null");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdEqualTo(Long value) {
            addCriterion("parkLocationId =", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdNotEqualTo(Long value) {
            addCriterion("parkLocationId <>", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdGreaterThan(Long value) {
            addCriterion("parkLocationId >", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkLocationId >=", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdLessThan(Long value) {
            addCriterion("parkLocationId <", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdLessThanOrEqualTo(Long value) {
            addCriterion("parkLocationId <=", value, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdIn(List<Long> values) {
            addCriterion("parkLocationId in", values, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdNotIn(List<Long> values) {
            addCriterion("parkLocationId not in", values, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdBetween(Long value1, Long value2) {
            addCriterion("parkLocationId between", value1, value2, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andParkLocationIdNotBetween(Long value1, Long value2) {
            addCriterion("parkLocationId not between", value1, value2, "parkLocationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumIsNull() {
            addCriterion("applyOrderNum is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumIsNotNull() {
            addCriterion("applyOrderNum is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumEqualTo(Integer value) {
            addCriterion("applyOrderNum =", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumNotEqualTo(Integer value) {
            addCriterion("applyOrderNum <>", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumGreaterThan(Integer value) {
            addCriterion("applyOrderNum >", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyOrderNum >=", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumLessThan(Integer value) {
            addCriterion("applyOrderNum <", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("applyOrderNum <=", value, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumIn(List<Integer> values) {
            addCriterion("applyOrderNum in", values, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumNotIn(List<Integer> values) {
            addCriterion("applyOrderNum not in", values, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("applyOrderNum between", value1, value2, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("applyOrderNum not between", value1, value2, "applyOrderNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNull() {
            addCriterion("collectNum is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNotNull() {
            addCriterion("collectNum is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumEqualTo(Integer value) {
            addCriterion("collectNum =", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotEqualTo(Integer value) {
            addCriterion("collectNum <>", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThan(Integer value) {
            addCriterion("collectNum >", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collectNum >=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThan(Integer value) {
            addCriterion("collectNum <", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThanOrEqualTo(Integer value) {
            addCriterion("collectNum <=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIn(List<Integer> values) {
            addCriterion("collectNum in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotIn(List<Integer> values) {
            addCriterion("collectNum not in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumBetween(Integer value1, Integer value2) {
            addCriterion("collectNum between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collectNum not between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("readNum is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("readNum is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Integer value) {
            addCriterion("readNum =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Integer value) {
            addCriterion("readNum <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Integer value) {
            addCriterion("readNum >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("readNum >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Integer value) {
            addCriterion("readNum <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("readNum <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Integer> values) {
            addCriterion("readNum in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Integer> values) {
            addCriterion("readNum not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Integer value1, Integer value2) {
            addCriterion("readNum between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("readNum not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("commentNum is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("commentNum is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(BigDecimal value) {
            addCriterion("commentNum =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(BigDecimal value) {
            addCriterion("commentNum <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(BigDecimal value) {
            addCriterion("commentNum >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commentNum >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(BigDecimal value) {
            addCriterion("commentNum <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commentNum <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<BigDecimal> values) {
            addCriterion("commentNum in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<BigDecimal> values) {
            addCriterion("commentNum not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commentNum between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commentNum not between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andReleasesIsNull() {
            addCriterion("releases is null");
            return (Criteria) this;
        }

        public Criteria andReleasesIsNotNull() {
            addCriterion("releases is not null");
            return (Criteria) this;
        }

        public Criteria andReleasesEqualTo(Integer value) {
            addCriterion("releases =", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesNotEqualTo(Integer value) {
            addCriterion("releases <>", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesGreaterThan(Integer value) {
            addCriterion("releases >", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("releases >=", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesLessThan(Integer value) {
            addCriterion("releases <", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesLessThanOrEqualTo(Integer value) {
            addCriterion("releases <=", value, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesIn(List<Integer> values) {
            addCriterion("releases in", values, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesNotIn(List<Integer> values) {
            addCriterion("releases not in", values, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesBetween(Integer value1, Integer value2) {
            addCriterion("releases between", value1, value2, "releases");
            return (Criteria) this;
        }

        public Criteria andReleasesNotBetween(Integer value1, Integer value2) {
            addCriterion("releases not between", value1, value2, "releases");
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