package com.sudaotech.huolijuzhen.basic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.LocationServiceTypeEntityMapper;
import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntity;
import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntityExample;
import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.util.BeanUtils;

public class ServiceTypeServiceImpl extends BaseServiceImpl implements ServiceTypeService {
	private static final String TRACKING_TYPE = "ServiceType";

    @Inject
    private LocationServiceTypeEntityMapper serviceTypeEntityMapper;

	@Override
	public ServiceType getById(Long id) {
		ServiceTypeEntity entity = this.serviceTypeEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceType.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceType obj) {
		logger.debug("Creating ServiceType: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceTypeEntity entity = BeanUtils.copyProperties(obj, ServiceTypeEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceTypeEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceType: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceType obj) {
		logger.debug("Updating ServiceType: {}", obj);

		ServiceTypeEntity entity = BeanUtils.copyProperties(obj, ServiceTypeEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceTypeEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceType: {}", obj);
	}

	@Override
	public Long save(ServiceType obj) {
		logger.debug("Saving ServiceType: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceType> find(Query query) {
		Page<ServiceType> page = new Page<ServiceType>(query);
		ServiceTypeEntityExample example = new ServiceTypeEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.serviceTypeEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceTypeEntity> list = this.serviceTypeEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceType.class));
		}
		
		return page;
	}
	
	@Override
	public Page<ServiceType> findByCondition(Query query) {
		Page<ServiceType> page = new Page<ServiceType>(query);
		ServiceTypeEntityExample example = new ServiceTypeEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		//启用状态
		EnableStatus enableStatus = query.getEnableStatus();
		if(enableStatus != null && EnableStatus.ENABLE.equals(enableStatus)){
			criteria.andEnableStatusEqualTo(enableStatus);
		}
		
		String name = query.getName();
		if(StringUtils.isNotBlank(name)){
			criteria.andNameLike("%"+ name +"%");
		}
		String serverGrade = query.getServerGrade();
		if(StringUtils.isNotBlank(serverGrade)){
			criteria.andServerGradeEqualTo(ServerGrade.valueOf(serverGrade));
		}
		Boolean isReco = query.getIsReco();
		if(isReco != null){
			criteria.andIsRecoEqualTo(isReco);
		}
		
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.serviceTypeEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceTypeEntity> list = this.serviceTypeEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceType.class));
		}
		
		return page;
	}
	
	@Override
	public List<ServiceType> findAll(String type) {
		ServiceTypeEntityExample example = new ServiceTypeEntityExample();
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
		return BeanUtils.copyListProperties(this.serviceTypeEntityMapper.selectByExample(example), ServiceType.class);
	}
	
	@Override
	public List<ServiceType> findValid(String type) {
		ServiceTypeEntityExample example = new ServiceTypeEntityExample();
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
		return BeanUtils.copyListProperties(this.serviceTypeEntityMapper.selectByExample(example), ServiceType.class);
	}
}
