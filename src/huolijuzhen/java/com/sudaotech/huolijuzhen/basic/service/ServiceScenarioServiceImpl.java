package com.sudaotech.huolijuzhen.basic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.ServiceScenarioEntity;
import com.sudaotech.huolijuzhen.basic.dao.ServiceScenarioEntityExample;
import com.sudaotech.huolijuzhen.basic.dao.LocationServiceScenarioEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.ServiceScenarioEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.util.BeanUtils;

public class ServiceScenarioServiceImpl extends BaseServiceImpl implements ServiceScenarioService {
	private static final String TRACKING_TYPE = "ServiceScenario";

    @Inject
    private LocationServiceScenarioEntityMapper serviceScenarioEntityMapper;

	@Override
	public ServiceScenario getById(Long id) {
		ServiceScenarioEntity entity = this.serviceScenarioEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceScenario.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceScenario obj) {
		logger.debug("Creating ServiceScenario: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceScenarioEntity entity = BeanUtils.copyProperties(obj, ServiceScenarioEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceScenarioEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceScenario: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceScenario obj) {
		logger.debug("Updating ServiceScenario: {}", obj);

		ServiceScenarioEntity entity = BeanUtils.copyProperties(obj, ServiceScenarioEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceScenarioEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceScenario: {}", obj);
	}

	@Override
	public Long save(ServiceScenario obj) {
		logger.debug("Saving ServiceScenario: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceScenario> find(Query query) {
		Page<ServiceScenario> page = new Page<ServiceScenario>(query);
		ServiceScenarioEntityExample example = new ServiceScenarioEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceScenarioEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceScenarioEntity> list = this.serviceScenarioEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceScenario.class));
		}
		
		return page;
	}
	
	/**
	 * 按条件查询
	 */
	@Override
	public Page<ServiceScenario> findByCondition(Query query) {
		Page<ServiceScenario> page = new Page<ServiceScenario>(query);
		ServiceScenarioEntityExample example = new ServiceScenarioEntityExample();
		Criteria criteria = example.createCriteria();
		
		//场景名称
		String name = query.getName();
		if(StringUtils.isNotBlank(name)){
			criteria.andNameLike(name);
		}
		//场景适用级别
		String serverGrade = query.getServerGrade();
		if(StringUtils.isNotBlank(serverGrade)){
			criteria.andServerGradeEqualTo(ServerGrade.valueOf(serverGrade));
		}
		
		//启用状态
		EnableStatus enableStatus = query.getEnableStatus();
		if(enableStatus != null && EnableStatus.ENABLE.equals(enableStatus)){
			criteria.andEnableStatusEqualTo(enableStatus);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.serviceScenarioEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceScenarioEntity> list = this.serviceScenarioEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceScenario.class));
		}
		
		return page;
	}

	@Override
	public List<ServiceScenario> findAll(String type){
		ServiceScenarioEntityExample example = new ServiceScenarioEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		List<ServerGrade> serverGrades = new ArrayList<ServerGrade>();
		if("PLATFORM".equals(type)){
			serverGrades.add(ServerGrade.PLATFORM);
		}else if("PARK".equals(type)){
			serverGrades.add(ServerGrade.PARK);
		}else if("ALL".equals(type)){
			serverGrades.add(ServerGrade.PLATFORM);
			serverGrades.add(ServerGrade.PARK);
		}
		serverGrades.add(ServerGrade.PLATFORMANDPARK);
		criteria.andServerGradeIn(serverGrades);
		
		return BeanUtils.copyListProperties(this.serviceScenarioEntityMapper.selectByExample(example), ServiceScenario.class);
	}
	
	@Override
	public List<ServiceScenario> findValid(String type){
		ServiceScenarioEntityExample example = new ServiceScenarioEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		List<ServerGrade> serverGrades = new ArrayList<ServerGrade>();
		if("PLATFORM".equals(type)){
			serverGrades.add(ServerGrade.PLATFORM);
		}else if("PARK".equals(type)){
			serverGrades.add(ServerGrade.PARK);
		}
		serverGrades.add(ServerGrade.PLATFORMANDPARK);
		criteria.andServerGradeIn(serverGrades);
		criteria.andEnableStatusEqualTo(EnableStatus.ENABLE);
		
		return BeanUtils.copyListProperties(this.serviceScenarioEntityMapper.selectByExample(example), ServiceScenario.class);
	}

}
