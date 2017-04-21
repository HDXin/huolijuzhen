package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottMapper;
import com.sudaotech.util.BeanUtils;


public class EnterpriseCottServiceImpl extends BaseServiceImpl implements EnterpriseCottService {
	
	private static final String TRACKING_TYPE = "EnterpriseCott";

    @Inject
    private EnterpriseCottMapper enterpriseCottMapper;

	@Override
	public EnterpriseCott getById(Long id) {
		EnterpriseCottEntity entity = this.enterpriseCottMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseCott.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseCott obj) {
		logger.debug("Creating EnterpriseCott: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseCottEntity entity = BeanUtils.copyProperties(obj, EnterpriseCottEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseCottMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseCott: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseCott obj) {
		logger.debug("Updating EnterpriseCott: {}", obj);

		EnterpriseCottEntity entity = BeanUtils.copyProperties(obj, EnterpriseCottEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseCottMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseCott: {}", obj);
	}

	@Override
	public Long save(EnterpriseCott obj) {
		logger.debug("Saving EnterpriseCott: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseCott> find(Query query) {
		Page<EnterpriseCott> page = new Page<EnterpriseCott>(query);
		EnterpriseCottEntityExample example = new EnterpriseCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(query.getParkId() != null){
			criteria.andParkIdEqualTo(query.getParkId());
		}
		
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseCottMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseCottEntity> list = this.enterpriseCottMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseCott.class));
		}
		
		return page;
	}

	@Override
	public List<EnterpriseCott> findList(EnterpriseCott obj) {
		EnterpriseCottEntityExample example = new EnterpriseCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(obj.getEnterpriseId() != null){
			criteria.andEnterpriseIdEqualTo(obj.getEnterpriseId());
		}
		if(obj.getParkId() != null){
			criteria.andParkIdEqualTo(obj.getParkId());
		}
		if(obj.getCorrStatus() !=null){
			criteria.andCorrStatusEqualTo(obj.getCorrStatus());
		}
		if(CollectionUtils.isNotEmpty(obj.getIds())){
			criteria.andIdIn(obj.getIds());
		}
		
		example.setOrderByClause("id DESC");
	    return BeanUtils.copyListProperties(this.enterpriseCottMapper.selectByExample(example), EnterpriseCott.class);
	    
	}

	@Override
	public Page<EnterpriseCottInfo> findByObj(Query query) {
		Page<EnterpriseCottInfo> page = new Page<EnterpriseCottInfo>(query);
        EnterpriseCott ec = new EnterpriseCott();
        
        ec.setParkId(query.getParkId());
        
        ec.setEnterpriseId(query.getEnterpriseId());
        
        ec.setCorrStatus(query.getCorrStatus());
        
        ec.setEnterpriseName(query.getEnterpriseName());
        
		page.setTotal(this.enterpriseCottMapper.countByObj(ec));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseCottInfo> list = this.enterpriseCottMapper.selectByObj(ec, this.toRowBounds(query));
			page.setItems(list);
		}
		return page;
	}

	@Override
	public List<EnterpriseCott> getEnterPriseCottByEnterpriseId(Long enterPriseId,Long parkId) {
		if(enterPriseId == null )
			return null;
		EnterpriseCottEntityExample example=new EnterpriseCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(enterPriseId !=null){
		criteria.andEnterpriseIdEqualTo(enterPriseId);
		}
		if(parkId != null){
		criteria.andParkIdEqualTo(parkId);
		}
		List<EnterpriseCott> cotts = BeanUtils.copyListProperties(this.enterpriseCottMapper.selectByExample(example), EnterpriseCott.class);
		
		return cotts;
	}

	@Override
	public List<EnterpriseCott> getEnterPriseCottByParkId(Long parkId) {
		if( parkId == null )
			return null;
		EnterpriseCottEntityExample example=new EnterpriseCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		return BeanUtils.copyListProperties(this.enterpriseCottMapper.selectByExample(example), EnterpriseCott.class);
		
	}
}
