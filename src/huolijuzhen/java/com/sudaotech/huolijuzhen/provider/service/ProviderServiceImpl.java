package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntity;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ProviderServiceImpl extends BaseServiceImpl implements ProviderService {
	private static final String TRACKING_TYPE = "Provider";

    @Inject
    private ProviderEntityMapper providerEntityMapper;

	@Override
	public Provider getById(Long id) {
		ProviderEntity entity = this.providerEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Provider.class);
		}
		
		return null;
	}

	@Override
	public Long create(Provider obj) {
		logger.debug("Creating Provider: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ProviderEntity entity = BeanUtils.copyProperties(obj, ProviderEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.providerEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Provider: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Provider obj) {
		logger.debug("Updating Provider: {}", obj);

		ProviderEntity entity = BeanUtils.copyProperties(obj, ProviderEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.providerEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Provider: {}", obj);
	}

	@Override
	public Long save(Provider obj) {
		logger.debug("Saving Provider: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Provider> find(Query query) {
		Page<Provider> page = new Page<Provider>(query);
		ProviderEntityExample example = new ProviderEntityExample();
		Criteria criteria = example.createCriteria();
		
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			criteria.andNameLike("%" + providerName + "%");
		}

		String createSideStr = query.getCreateSide();
		if(StringUtils.isNotBlank(createSideStr)){
			CreateSide createSide = CreateSide.valueOf(createSideStr);
			if(createSide != null){
				if(CreateSide.PARK.equals(createSide)){
					criteria.andParkIdEqualTo(query.getParkId());
				}
				criteria.andCreateSideEqualTo(createSide);
			}
		}
		
		String enableStatusStr = query.getEnableStatus();
		if(StringUtils.isNotBlank(enableStatusStr)){
			EnableStatus enableStatus = EnableStatus.valueOf(enableStatusStr);
			if(enableStatus != null){
				criteria.andEnableStatusEqualTo(enableStatus);
			}
		}
 		
		Long proId = query.getProId();
		if(proId != null){
			criteria.andProIdEqualTo(proId);
		}
		
		Long cityId = query.getCityId();
		if(cityId != null){
			criteria.andCityIdEqualTo(cityId);
		}
		
		Long counId = query.getCounId();
		if(counId != null){
			criteria.andCounIdEqualTo(counId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.providerEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ProviderEntity> list = this.providerEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Provider.class));
		}
		
		return page;
	}
}
