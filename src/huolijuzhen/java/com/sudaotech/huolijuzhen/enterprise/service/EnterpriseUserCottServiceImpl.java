package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EnterpriseUserCottServiceImpl extends BaseServiceImpl implements EnterpriseUserCottService {
	private static final String TRACKING_TYPE = "EnterpriseUserCott";

    @Inject
    private EnterpriseUserCottEntityMapper enterpriseUserCottEntityMapper;

	@Override
	public EnterpriseUserCott getById(Long id) {
		EnterpriseUserCottEntity entity = this.enterpriseUserCottEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseUserCott.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseUserCott obj) {
		logger.debug("Creating EnterpriseUserCott: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseUserCottEntity entity = BeanUtils.copyProperties(obj, EnterpriseUserCottEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseUserCottEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseUserCott: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseUserCott obj) {
		logger.debug("Updating EnterpriseUserCott: {}", obj);

		EnterpriseUserCottEntity entity = BeanUtils.copyProperties(obj, EnterpriseUserCottEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseUserCottEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseUserCott: {}", obj);
	}

	@Override
	public Long save(EnterpriseUserCott obj) {
		logger.debug("Saving EnterpriseUserCott: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseUserCott> find(Query query) {
		Page<EnterpriseUserCott> page = new Page<EnterpriseUserCott>(query);
		EnterpriseUserCottEntityExample example = new EnterpriseUserCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		//根据企业用户id,园区id,关联关系id分页查询
		Long enterpriseUserId = query.getEnterpriseUserId();
		Long parkId = query.getParkId();
		Long cottId = query.getCottId();
		if(enterpriseUserId!=null && enterpriseUserId>0)
			criteria.andEnterpriseUserIdEqualTo(enterpriseUserId);
		if(parkId!=null && parkId>0)
			criteria.andParkIdEqualTo(parkId);
		if(cottId!=null && cottId>0)
			criteria.andCottIdEqualTo(cottId);
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseUserCottEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseUserCottEntity> list = this.enterpriseUserCottEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseUserCott.class));
		}
		
		return page;
	}

	@Override
	public List<EnterpriseUserCott> findByObj(EnterpriseUserCott euc) {
		
		EnterpriseUserCottEntityExample example = new EnterpriseUserCottEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		//根据企业用户id,园区id,关联关系id分页查询
		Long enterpriseUserId = euc.getEnterpriseUserId();
		Long parkId = euc.getParkId();
		Long cottId = euc.getCottId();
		if(enterpriseUserId !=null && enterpriseUserId >0){
			criteria.andEnterpriseUserIdEqualTo(enterpriseUserId);
		}
		if(parkId!=null && parkId >0){
			criteria.andParkIdEqualTo(parkId);
	    }
	    if(cottId!=null && cottId>0 ){
			criteria.andCottIdEqualTo(cottId);
		}   
	    
		example.setOrderByClause("id DESC");
			
		List<EnterpriseUserCottEntity> list = this.enterpriseUserCottEntityMapper.selectByExample(example);
			
		return BeanUtils.copyListProperties(list, EnterpriseUserCott.class);
		
	}
	
}
