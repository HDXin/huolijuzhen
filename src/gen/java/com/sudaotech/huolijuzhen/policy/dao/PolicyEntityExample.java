package com.sudaotech.huolijuzhen.policy.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PolicyEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyEntityExample() {
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

        public Criteria andPolUriIsNull() {
            addCriterion("polUri is null");
            return (Criteria) this;
        }

        public Criteria andPolUriIsNotNull() {
            addCriterion("polUri is not null");
            return (Criteria) this;
        }

        public Criteria andPolUriEqualTo(String value) {
            addCriterion("polUri =", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriNotEqualTo(String value) {
            addCriterion("polUri <>", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriGreaterThan(String value) {
            addCriterion("polUri >", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriGreaterThanOrEqualTo(String value) {
            addCriterion("polUri >=", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriLessThan(String value) {
            addCriterion("polUri <", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriLessThanOrEqualTo(String value) {
            addCriterion("polUri <=", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriLike(String value) {
            addCriterion("polUri like", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriNotLike(String value) {
            addCriterion("polUri not like", value, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriIn(List<String> values) {
            addCriterion("polUri in", values, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriNotIn(List<String> values) {
            addCriterion("polUri not in", values, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriBetween(String value1, String value2) {
            addCriterion("polUri between", value1, value2, "polUri");
            return (Criteria) this;
        }

        public Criteria andPolUriNotBetween(String value1, String value2) {
            addCriterion("polUri not between", value1, value2, "polUri");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIsNull() {
            addCriterion("publicGrade is null");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIsNotNull() {
            addCriterion("publicGrade is not null");
            return (Criteria) this;
        }

        public Criteria andPublicGradeEqualTo(PublicGrade value) {
            addCriterion("publicGrade =", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotEqualTo(PublicGrade value) {
            addCriterion("publicGrade <>", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeGreaterThan(PublicGrade value) {
            addCriterion("publicGrade >", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeGreaterThanOrEqualTo(PublicGrade value) {
            addCriterion("publicGrade >=", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeLessThan(PublicGrade value) {
            addCriterion("publicGrade <", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeLessThanOrEqualTo(PublicGrade value) {
            addCriterion("publicGrade <=", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIn(List<PublicGrade> values) {
            addCriterion("publicGrade in", values, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotIn(List<PublicGrade> values) {
            addCriterion("publicGrade not in", values, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeBetween(PublicGrade value1, PublicGrade value2) {
            addCriterion("publicGrade between", value1, value2, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotBetween(PublicGrade value1, PublicGrade value2) {
            addCriterion("publicGrade not between", value1, value2, "publicGrade");
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

        public Criteria andProIdIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("proId =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("proId <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("proId >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("proId >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("proId <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("proId <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("proId in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("proId not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("proId between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("proId not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("cityId is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("cityId is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Long value) {
            addCriterion("cityId =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Long value) {
            addCriterion("cityId <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Long value) {
            addCriterion("cityId >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cityId >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Long value) {
            addCriterion("cityId <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Long value) {
            addCriterion("cityId <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Long> values) {
            addCriterion("cityId in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Long> values) {
            addCriterion("cityId not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Long value1, Long value2) {
            addCriterion("cityId between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Long value1, Long value2) {
            addCriterion("cityId not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCounIdIsNull() {
            addCriterion("counId is null");
            return (Criteria) this;
        }

        public Criteria andCounIdIsNotNull() {
            addCriterion("counId is not null");
            return (Criteria) this;
        }

        public Criteria andCounIdEqualTo(Long value) {
            addCriterion("counId =", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotEqualTo(Long value) {
            addCriterion("counId <>", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdGreaterThan(Long value) {
            addCriterion("counId >", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdGreaterThanOrEqualTo(Long value) {
            addCriterion("counId >=", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdLessThan(Long value) {
            addCriterion("counId <", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdLessThanOrEqualTo(Long value) {
            addCriterion("counId <=", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdIn(List<Long> values) {
            addCriterion("counId in", values, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotIn(List<Long> values) {
            addCriterion("counId not in", values, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdBetween(Long value1, Long value2) {
            addCriterion("counId between", value1, value2, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotBetween(Long value1, Long value2) {
            addCriterion("counId not between", value1, value2, "counId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("locationId is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("locationId is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Long value) {
            addCriterion("locationId =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Long value) {
            addCriterion("locationId <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Long value) {
            addCriterion("locationId >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("locationId >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Long value) {
            addCriterion("locationId <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Long value) {
            addCriterion("locationId <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Long> values) {
            addCriterion("locationId in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Long> values) {
            addCriterion("locationId not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Long value1, Long value2) {
            addCriterion("locationId between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Long value1, Long value2) {
            addCriterion("locationId not between", value1, value2, "locationId");
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

        public Criteria andApprovalStatusEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(ApprovalStatus value) {
            addCriterion("approvalStatus >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(ApprovalStatus value) {
            addCriterion("approvalStatus <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<ApprovalStatus> values) {
            addCriterion("approvalStatus in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<ApprovalStatus> values) {
            addCriterion("approvalStatus not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(ApprovalStatus value1, ApprovalStatus value2) {
            addCriterion("approvalStatus between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(ApprovalStatus value1, ApprovalStatus value2) {
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

        public Criteria andCreateSideIsNull() {
            addCriterion("createSide is null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIsNotNull() {
            addCriterion("createSide is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSideEqualTo(CreateSide value) {
            addCriterion("createSide =", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotEqualTo(CreateSide value) {
            addCriterion("createSide <>", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideGreaterThan(CreateSide value) {
            addCriterion("createSide >", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideGreaterThanOrEqualTo(CreateSide value) {
            addCriterion("createSide >=", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideLessThan(CreateSide value) {
            addCriterion("createSide <", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideLessThanOrEqualTo(CreateSide value) {
            addCriterion("createSide <=", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideIn(List<CreateSide> values) {
            addCriterion("createSide in", values, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotIn(List<CreateSide> values) {
            addCriterion("createSide not in", values, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideBetween(CreateSide value1, CreateSide value2) {
            addCriterion("createSide between", value1, value2, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotBetween(CreateSide value1, CreateSide value2) {
            addCriterion("createSide not between", value1, value2, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIsNull() {
            addCriterion("createSideId is null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIsNotNull() {
            addCriterion("createSideId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdEqualTo(Long value) {
            addCriterion("createSideId =", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotEqualTo(Long value) {
            addCriterion("createSideId <>", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdGreaterThan(Long value) {
            addCriterion("createSideId >", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdGreaterThanOrEqualTo(Long value) {
            addCriterion("createSideId >=", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdLessThan(Long value) {
            addCriterion("createSideId <", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdLessThanOrEqualTo(Long value) {
            addCriterion("createSideId <=", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIn(List<Long> values) {
            addCriterion("createSideId in", values, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotIn(List<Long> values) {
            addCriterion("createSideId not in", values, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdBetween(Long value1, Long value2) {
            addCriterion("createSideId between", value1, value2, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotBetween(Long value1, Long value2) {
            addCriterion("createSideId not between", value1, value2, "createSideId");
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