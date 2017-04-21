package com.sudaotech.huolijuzhen.equipment.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntity;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityExample;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityExample.Criteria;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentPlanEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EquipmentPlanServiceImpl extends BaseServiceImpl implements EquipmentPlanService {
	private static final String TRACKING_TYPE = "EquipmentPlan";

    @Inject
    private LocationEquipmentPlanEntityMapper equipmentPlanEntityMapper;

	@Override
	public EquipmentPlan getById(Long id) {
		EquipmentPlanEntity entity = this.equipmentPlanEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EquipmentPlan.class);
		}
		
		return null;
	}

	@Override
	public Long create(EquipmentPlan obj) {
		logger.debug("Creating EquipmentPlan: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EquipmentPlanEntity entity = BeanUtils.copyProperties(obj, EquipmentPlanEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.equipmentPlanEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EquipmentPlan: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EquipmentPlan obj) {
		logger.debug("Updating EquipmentPlan: {}", obj);

		EquipmentPlanEntity entity = BeanUtils.copyProperties(obj, EquipmentPlanEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.equipmentPlanEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EquipmentPlan: {}", obj);
	}

	@Override
	public Long save(EquipmentPlan obj) {
		logger.debug("Saving EquipmentPlan: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EquipmentPlan> find(Query query) {
		Page<EquipmentPlan> page = new Page<EquipmentPlan>(query);
		EquipmentPlanEntityExample example = new EquipmentPlanEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.equipmentPlanEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EquipmentPlanEntity> list = this.equipmentPlanEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentPlan.class));
		}
		
		return page;
	}
	
	/**
	 * 根据条件进行分页检索
	 */
	@Override
	public Page<EquipmentPlan> findByCondition(Query query) {
		Page<EquipmentPlan> page = new Page<EquipmentPlan>(query);
		EquipmentPlanEntityExample example = new EquipmentPlanEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.equipmentPlanEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EquipmentPlanEntity> list = this.equipmentPlanEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentPlan.class));
		}
		
		return page;
	}
	
	/**
	 * 根据月份获取指定月份的所有计划
	 * @throws ParseException 
	 */
	@Override
	public List<EquipmentPlan> findByMonth(Query query) throws ParseException {
		EquipmentPlanEntityExample example = new EquipmentPlanEntityExample();
		Criteria criteria = example.createCriteria();
		
		List<Long> equIds = query.getEquIds();
		if(CollectionUtils.isNotEmpty(equIds)){
			criteria.andEquIdIn(equIds);
		}
		
		String month = query.getByMonth();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if(StringUtils.isNotBlank(month)){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(month));
			
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date value1 = calendar.getTime();
			
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Date value2 = calendar.getTime();
			
			criteria.andPlanExecutorDateBetween(value1, value2);
		}
		//获取当前园区的计划
		//TODO 根据用户 ID 获取当前园区 ID
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andEnableStatusEqualTo(EnableStatus.ENABLE);
		
		return BeanUtils.copyListProperties(this.equipmentPlanEntityMapper.selectByExample(example), EquipmentPlan.class);
	}
	
	/**
	 * 根据日期，获取指定日期的所有计划信息
	 * @throws ParseException 
	 */
	@Override
	public Page<EquipmentPlan> findByDate(Query query) throws ParseException {
		query.setLimit(1000);
		Page<EquipmentPlan> page = new Page<EquipmentPlan>(query);
		EquipmentPlanEntityExample example = new EquipmentPlanEntityExample();
		Criteria criteria = example.createCriteria();
		
		List<Long> equIds = query.getEquIds();
		if(CollectionUtils.isNotEmpty(equIds)){
			criteria.andEquIdIn(equIds);
		}
		
		String date = query.getByDay();
		if(StringUtils.isNotBlank(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			criteria.andPlanExecutorDateEqualTo(sdf.parse(date));
		}
		criteria.andEnableStatusEqualTo(EnableStatus.ENABLE);
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.equipmentPlanEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EquipmentPlanEntity> list = this.equipmentPlanEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentPlan.class));
		}
		
		return page;
	}

	/**
	 * 根据维护项目，获取此时之后的所有几乎
	 */
	@Override
	public List<Long> getByEquPreId(Long id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		params.put("equPreId", id);
		params.put("planExecutorDate", sdf.format(new Date()));
		params.put("planStatus", PlanStatus.WAITALLOT.code());
		
		return equipmentPlanEntityMapper.getByEquPreId(params);
	}

    /**
     * 根据计划 ID 删除所有计划
     */
	@Override
	public void removeByIds(List<Long> ids) {

		if(CollectionUtils.isNotEmpty(ids)){
			Map<String,Object> params = new HashMap<String, Object>();
			for(Long id:ids){
				params = new HashMap<String, Object>();
				params.put("planId", id);
//				equipmentPlanEntityMapper.removeById(params);
			}			
		}
		
	}

	@Override
	public List<Map<String,Object>> findByEquId(Map<String, Object> params) {
		List<Map<String, Object>> planMap = equipmentPlanEntityMapper.findByEquId(params);
		return planMap;
	}

	/**
	 * 园区管理 web 设备计划提醒
	 * @throws ParseException 
	 */
	@Override
	public Page<EquipmentPlan> equipmentPlanStatistics(EquipmentPlanQuery equipmentPlanQuery) throws ParseException {
		
		Page<EquipmentPlan> page = new Page<EquipmentPlan>(equipmentPlanQuery);
		EquipmentPlanEntityExample example = new EquipmentPlanEntityExample();
		Criteria criteria = example.createCriteria();
		
		List<Long> equIds = equipmentPlanQuery.getEquIds();
		if(CollectionUtils.isNotEmpty(equIds)){
			criteria.andEquIdIn(equIds);
		}
		
		Date date = equipmentPlanQuery.getStartDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		criteria.andPlanExecutorDateGreaterThanOrEqualTo(sdf.parse(dateStr));
		criteria.andPlanStatusEqualTo(PlanStatus.WAITALLOT);
		criteria.andEnableStatusEqualTo(EnableStatus.ENABLE);
		criteria.andStatusEqualTo(Status.NORMAL);

		example.setOrderByClause("planExecutorDate ASC");
		page.setTotal(this.equipmentPlanEntityMapper.countByExample(example));
		if (page.getTotal() > equipmentPlanQuery.getOffset()) {
			List<EquipmentPlanEntity> list = this.equipmentPlanEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(equipmentPlanQuery));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentPlan.class));
		}
		
		return page;
	}
	
}
