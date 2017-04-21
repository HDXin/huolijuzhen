package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.LocationEnterpriseInfoEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class EnterpriseInfoServiceImpl extends BaseServiceImpl implements EnterpriseInfoService {
	private static final String TRACKING_TYPE = "EnterpriseInfo";

    @Inject
    private LocationEnterpriseInfoEntityMapper enterpriseInfoEntityMapper;

	@Override
	public EnterpriseInfo getById(Long id) {
		
		EnterpriseInfoEntity entity = this.enterpriseInfoEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseInfo.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseInfo obj) {
		logger.debug("Creating EnterpriseInfo: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_ENTERPRISE));
		
		EnterpriseInfoEntity entity = BeanUtils.copyProperties(obj, EnterpriseInfoEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseInfoEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseInfo: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseInfo obj) {
		logger.debug("Updating EnterpriseInfo: {}", obj);

		EnterpriseInfoEntity entity = BeanUtils.copyProperties(obj, EnterpriseInfoEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseInfoEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseInfo: {}", obj);
	}

	@Override
	public Long save(EnterpriseInfo obj) {
		logger.debug("Saving EnterpriseInfo: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseInfo> find(Query query) {
		Page<EnterpriseInfo> page = new Page<EnterpriseInfo>(query);
		EnterpriseInfoEntityExample example = new EnterpriseInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(StringUtils.isNotBlank(query.getName())){
        criteria.andNameLike("%"+query.getName()+"%");			
		}
		if(query.getCreateSource() != null){
        criteria.andCreateSourceEqualTo(query.getCreateSource());			
		}
		
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseInfoEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseInfoEntity> list = this.enterpriseInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseInfo.class));
		}
		
		return page;
	}

	@Override
	public EnterpriseInfo findByCode(String code) {
		EnterpriseInfoEntityExample example = new EnterpriseInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andCodeEqualTo(code);
		List<EnterpriseInfoEntity> list = this.enterpriseInfoEntityMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list) && list.get(0) != null){
			return BeanUtils.copyProperties(list.get(0), EnterpriseInfo.class);
		}
      return null;
	}

	@Override
	public List<EnterpriseInfo> findByObj(EnterpriseInfo ei) {
		
		EnterpriseInfoEntityExample example = new EnterpriseInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(StringUtils.isNotBlank(ei.getCode())){
		criteria.andCodeEqualTo(ei.getCode());
		}
		
		if(StringUtils.isNotBlank(ei.getName())){
			criteria.andNameLike("%"+ei.getName()+"%");
		}
		if(CollectionUtils.isNotEmpty(ei.getIds())){
			criteria.andIdIn(ei.getIds());
		}
		if(ei.getCreateSource() != null){
			criteria.andCreateSourceEqualTo(ei.getCreateSource());
		}
		List<EnterpriseInfoEntity> list = this.enterpriseInfoEntityMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return  BeanUtils.copyListProperties(list, EnterpriseInfo.class);
		}
      return null;
      
	}

	@Override
	public Integer enterpriseInfoStatistics(Map<String, Object> params) {
		return this.enterpriseInfoEntityMapper.enterpriseInfoStatistics(params);
	}
}
