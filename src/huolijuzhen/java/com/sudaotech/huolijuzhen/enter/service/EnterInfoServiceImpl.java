package com.sudaotech.huolijuzhen.enter.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntity;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityMapper;
import com.sudaotech.huolijuzhen.enums.EntryType;
import com.sudaotech.util.BeanUtils;

public class EnterInfoServiceImpl extends BaseServiceImpl implements EnterInfoService {
	private static final String TRACKING_TYPE = "EnterInfo";

    @Inject
    private EnterInfoEntityMapper enterInfoEntityMapper;

	@Override
	public EnterInfo getById(Long id) {
		EnterInfoEntity entity = this.enterInfoEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterInfo.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterInfo obj) {
		logger.debug("Creating EnterInfo: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterInfoEntity entity = BeanUtils.copyProperties(obj, EnterInfoEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterInfoEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterInfo: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterInfo obj) {
		logger.debug("Updating EnterInfo: {}", obj);

		EnterInfoEntity entity = BeanUtils.copyProperties(obj, EnterInfoEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterInfoEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterInfo: {}", obj);
	}

	@Override
	public Long save(EnterInfo obj) {
		logger.debug("Saving EnterInfo: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterInfo> find(Query query, EntryType type) {
		Page<EnterInfo> page = new Page<EnterInfo>(query);
		EnterInfoEntityExample example = new EnterInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(EntryType.PARK.equals(type) || EntryType.SERVICE_PROVIDER.equals(type)){
			criteria.andEntryTypeEqualTo(type);
		}
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterInfoEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterInfoEntity> list = this.enterInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterInfo.class));
		}
		
		return page;
	}
}
