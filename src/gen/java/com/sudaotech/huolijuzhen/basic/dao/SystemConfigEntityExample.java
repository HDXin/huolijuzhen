package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemConfigEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemConfigEntityExample() {
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

        public Criteria andMaintenanceReportSignIsNull() {
            addCriterion("maintenanceReportSign is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignIsNotNull() {
            addCriterion("maintenanceReportSign is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignEqualTo(EnableStatus value) {
            addCriterion("maintenanceReportSign =", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignNotEqualTo(EnableStatus value) {
            addCriterion("maintenanceReportSign <>", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignGreaterThan(EnableStatus value) {
            addCriterion("maintenanceReportSign >", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignGreaterThanOrEqualTo(EnableStatus value) {
            addCriterion("maintenanceReportSign >=", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignLessThan(EnableStatus value) {
            addCriterion("maintenanceReportSign <", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignLessThanOrEqualTo(EnableStatus value) {
            addCriterion("maintenanceReportSign <=", value, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignIn(List<EnableStatus> values) {
            addCriterion("maintenanceReportSign in", values, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignNotIn(List<EnableStatus> values) {
            addCriterion("maintenanceReportSign not in", values, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("maintenanceReportSign between", value1, value2, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportSignNotBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("maintenanceReportSign not between", value1, value2, "maintenanceReportSign");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysIsNull() {
            addCriterion("maintenanceReportDays is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysIsNotNull() {
            addCriterion("maintenanceReportDays is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysEqualTo(Integer value) {
            addCriterion("maintenanceReportDays =", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysNotEqualTo(Integer value) {
            addCriterion("maintenanceReportDays <>", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysGreaterThan(Integer value) {
            addCriterion("maintenanceReportDays >", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintenanceReportDays >=", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysLessThan(Integer value) {
            addCriterion("maintenanceReportDays <", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysLessThanOrEqualTo(Integer value) {
            addCriterion("maintenanceReportDays <=", value, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysIn(List<Integer> values) {
            addCriterion("maintenanceReportDays in", values, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysNotIn(List<Integer> values) {
            addCriterion("maintenanceReportDays not in", values, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysBetween(Integer value1, Integer value2) {
            addCriterion("maintenanceReportDays between", value1, value2, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andMaintenanceReportDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("maintenanceReportDays not between", value1, value2, "maintenanceReportDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignIsNull() {
            addCriterion("createParkSign is null");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignIsNotNull() {
            addCriterion("createParkSign is not null");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignEqualTo(EnableStatus value) {
            addCriterion("createParkSign =", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignNotEqualTo(EnableStatus value) {
            addCriterion("createParkSign <>", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignGreaterThan(EnableStatus value) {
            addCriterion("createParkSign >", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignGreaterThanOrEqualTo(EnableStatus value) {
            addCriterion("createParkSign >=", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignLessThan(EnableStatus value) {
            addCriterion("createParkSign <", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignLessThanOrEqualTo(EnableStatus value) {
            addCriterion("createParkSign <=", value, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignIn(List<EnableStatus> values) {
            addCriterion("createParkSign in", values, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignNotIn(List<EnableStatus> values) {
            addCriterion("createParkSign not in", values, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("createParkSign between", value1, value2, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkSignNotBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("createParkSign not between", value1, value2, "createParkSign");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysIsNull() {
            addCriterion("createParkDays is null");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysIsNotNull() {
            addCriterion("createParkDays is not null");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysEqualTo(Integer value) {
            addCriterion("createParkDays =", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysNotEqualTo(Integer value) {
            addCriterion("createParkDays <>", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysGreaterThan(Integer value) {
            addCriterion("createParkDays >", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("createParkDays >=", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysLessThan(Integer value) {
            addCriterion("createParkDays <", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysLessThanOrEqualTo(Integer value) {
            addCriterion("createParkDays <=", value, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysIn(List<Integer> values) {
            addCriterion("createParkDays in", values, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysNotIn(List<Integer> values) {
            addCriterion("createParkDays not in", values, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysBetween(Integer value1, Integer value2) {
            addCriterion("createParkDays between", value1, value2, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andCreateParkDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("createParkDays not between", value1, value2, "createParkDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignIsNull() {
            addCriterion("equipmentMaintainSign is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignIsNotNull() {
            addCriterion("equipmentMaintainSign is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignEqualTo(EnableStatus value) {
            addCriterion("equipmentMaintainSign =", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignNotEqualTo(EnableStatus value) {
            addCriterion("equipmentMaintainSign <>", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignGreaterThan(EnableStatus value) {
            addCriterion("equipmentMaintainSign >", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignGreaterThanOrEqualTo(EnableStatus value) {
            addCriterion("equipmentMaintainSign >=", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignLessThan(EnableStatus value) {
            addCriterion("equipmentMaintainSign <", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignLessThanOrEqualTo(EnableStatus value) {
            addCriterion("equipmentMaintainSign <=", value, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignIn(List<EnableStatus> values) {
            addCriterion("equipmentMaintainSign in", values, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignNotIn(List<EnableStatus> values) {
            addCriterion("equipmentMaintainSign not in", values, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("equipmentMaintainSign between", value1, value2, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainSignNotBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("equipmentMaintainSign not between", value1, value2, "equipmentMaintainSign");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysIsNull() {
            addCriterion("equipmentMaintainDays is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysIsNotNull() {
            addCriterion("equipmentMaintainDays is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysEqualTo(Integer value) {
            addCriterion("equipmentMaintainDays =", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysNotEqualTo(Integer value) {
            addCriterion("equipmentMaintainDays <>", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysGreaterThan(Integer value) {
            addCriterion("equipmentMaintainDays >", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipmentMaintainDays >=", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysLessThan(Integer value) {
            addCriterion("equipmentMaintainDays <", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysLessThanOrEqualTo(Integer value) {
            addCriterion("equipmentMaintainDays <=", value, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysIn(List<Integer> values) {
            addCriterion("equipmentMaintainDays in", values, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysNotIn(List<Integer> values) {
            addCriterion("equipmentMaintainDays not in", values, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysBetween(Integer value1, Integer value2) {
            addCriterion("equipmentMaintainDays between", value1, value2, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andEquipmentMaintainDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("equipmentMaintainDays not between", value1, value2, "equipmentMaintainDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignIsNull() {
            addCriterion("urgeTermSign is null");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignIsNotNull() {
            addCriterion("urgeTermSign is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignEqualTo(EnableStatus value) {
            addCriterion("urgeTermSign =", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignNotEqualTo(EnableStatus value) {
            addCriterion("urgeTermSign <>", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignGreaterThan(EnableStatus value) {
            addCriterion("urgeTermSign >", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignGreaterThanOrEqualTo(EnableStatus value) {
            addCriterion("urgeTermSign >=", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignLessThan(EnableStatus value) {
            addCriterion("urgeTermSign <", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignLessThanOrEqualTo(EnableStatus value) {
            addCriterion("urgeTermSign <=", value, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignIn(List<EnableStatus> values) {
            addCriterion("urgeTermSign in", values, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignNotIn(List<EnableStatus> values) {
            addCriterion("urgeTermSign not in", values, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("urgeTermSign between", value1, value2, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermSignNotBetween(EnableStatus value1, EnableStatus value2) {
            addCriterion("urgeTermSign not between", value1, value2, "urgeTermSign");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysIsNull() {
            addCriterion("urgeTermDays is null");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysIsNotNull() {
            addCriterion("urgeTermDays is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysEqualTo(Integer value) {
            addCriterion("urgeTermDays =", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysNotEqualTo(Integer value) {
            addCriterion("urgeTermDays <>", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysGreaterThan(Integer value) {
            addCriterion("urgeTermDays >", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("urgeTermDays >=", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysLessThan(Integer value) {
            addCriterion("urgeTermDays <", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysLessThanOrEqualTo(Integer value) {
            addCriterion("urgeTermDays <=", value, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysIn(List<Integer> values) {
            addCriterion("urgeTermDays in", values, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysNotIn(List<Integer> values) {
            addCriterion("urgeTermDays not in", values, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysBetween(Integer value1, Integer value2) {
            addCriterion("urgeTermDays between", value1, value2, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeTermDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("urgeTermDays not between", value1, value2, "urgeTermDays");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateIsNull() {
            addCriterion("urgeContentTemplate is null");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateIsNotNull() {
            addCriterion("urgeContentTemplate is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateEqualTo(String value) {
            addCriterion("urgeContentTemplate =", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateNotEqualTo(String value) {
            addCriterion("urgeContentTemplate <>", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateGreaterThan(String value) {
            addCriterion("urgeContentTemplate >", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("urgeContentTemplate >=", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateLessThan(String value) {
            addCriterion("urgeContentTemplate <", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateLessThanOrEqualTo(String value) {
            addCriterion("urgeContentTemplate <=", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateLike(String value) {
            addCriterion("urgeContentTemplate like", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateNotLike(String value) {
            addCriterion("urgeContentTemplate not like", value, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateIn(List<String> values) {
            addCriterion("urgeContentTemplate in", values, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateNotIn(List<String> values) {
            addCriterion("urgeContentTemplate not in", values, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateBetween(String value1, String value2) {
            addCriterion("urgeContentTemplate between", value1, value2, "urgeContentTemplate");
            return (Criteria) this;
        }

        public Criteria andUrgeContentTemplateNotBetween(String value1, String value2) {
            addCriterion("urgeContentTemplate not between", value1, value2, "urgeContentTemplate");
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

        public Criteria andBillIntroductionIsNull() {
            addCriterion("billIntroduction is null");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionIsNotNull() {
            addCriterion("billIntroduction is not null");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionEqualTo(String value) {
            addCriterion("billIntroduction =", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionNotEqualTo(String value) {
            addCriterion("billIntroduction <>", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionGreaterThan(String value) {
            addCriterion("billIntroduction >", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("billIntroduction >=", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionLessThan(String value) {
            addCriterion("billIntroduction <", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionLessThanOrEqualTo(String value) {
            addCriterion("billIntroduction <=", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionLike(String value) {
            addCriterion("billIntroduction like", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionNotLike(String value) {
            addCriterion("billIntroduction not like", value, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionIn(List<String> values) {
            addCriterion("billIntroduction in", values, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionNotIn(List<String> values) {
            addCriterion("billIntroduction not in", values, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionBetween(String value1, String value2) {
            addCriterion("billIntroduction between", value1, value2, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIntroductionNotBetween(String value1, String value2) {
            addCriterion("billIntroduction not between", value1, value2, "billIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillPayWayIsNull() {
            addCriterion("billPayWay is null");
            return (Criteria) this;
        }

        public Criteria andBillPayWayIsNotNull() {
            addCriterion("billPayWay is not null");
            return (Criteria) this;
        }

        public Criteria andBillPayWayEqualTo(String value) {
            addCriterion("billPayWay =", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayNotEqualTo(String value) {
            addCriterion("billPayWay <>", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayGreaterThan(String value) {
            addCriterion("billPayWay >", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("billPayWay >=", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayLessThan(String value) {
            addCriterion("billPayWay <", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayLessThanOrEqualTo(String value) {
            addCriterion("billPayWay <=", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayLike(String value) {
            addCriterion("billPayWay like", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayNotLike(String value) {
            addCriterion("billPayWay not like", value, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayIn(List<String> values) {
            addCriterion("billPayWay in", values, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayNotIn(List<String> values) {
            addCriterion("billPayWay not in", values, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayBetween(String value1, String value2) {
            addCriterion("billPayWay between", value1, value2, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillPayWayNotBetween(String value1, String value2) {
            addCriterion("billPayWay not between", value1, value2, "billPayWay");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountIsNull() {
            addCriterion("billBankAccount is null");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountIsNotNull() {
            addCriterion("billBankAccount is not null");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountEqualTo(String value) {
            addCriterion("billBankAccount =", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountNotEqualTo(String value) {
            addCriterion("billBankAccount <>", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountGreaterThan(String value) {
            addCriterion("billBankAccount >", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("billBankAccount >=", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountLessThan(String value) {
            addCriterion("billBankAccount <", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountLessThanOrEqualTo(String value) {
            addCriterion("billBankAccount <=", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountLike(String value) {
            addCriterion("billBankAccount like", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountNotLike(String value) {
            addCriterion("billBankAccount not like", value, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountIn(List<String> values) {
            addCriterion("billBankAccount in", values, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountNotIn(List<String> values) {
            addCriterion("billBankAccount not in", values, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountBetween(String value1, String value2) {
            addCriterion("billBankAccount between", value1, value2, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillBankAccountNotBetween(String value1, String value2) {
            addCriterion("billBankAccount not between", value1, value2, "billBankAccount");
            return (Criteria) this;
        }

        public Criteria andBillInscribleIsNull() {
            addCriterion("billInscrible is null");
            return (Criteria) this;
        }

        public Criteria andBillInscribleIsNotNull() {
            addCriterion("billInscrible is not null");
            return (Criteria) this;
        }

        public Criteria andBillInscribleEqualTo(String value) {
            addCriterion("billInscrible =", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleNotEqualTo(String value) {
            addCriterion("billInscrible <>", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleGreaterThan(String value) {
            addCriterion("billInscrible >", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleGreaterThanOrEqualTo(String value) {
            addCriterion("billInscrible >=", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleLessThan(String value) {
            addCriterion("billInscrible <", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleLessThanOrEqualTo(String value) {
            addCriterion("billInscrible <=", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleLike(String value) {
            addCriterion("billInscrible like", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleNotLike(String value) {
            addCriterion("billInscrible not like", value, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleIn(List<String> values) {
            addCriterion("billInscrible in", values, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleNotIn(List<String> values) {
            addCriterion("billInscrible not in", values, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleBetween(String value1, String value2) {
            addCriterion("billInscrible between", value1, value2, "billInscrible");
            return (Criteria) this;
        }

        public Criteria andBillInscribleNotBetween(String value1, String value2) {
            addCriterion("billInscrible not between", value1, value2, "billInscrible");
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