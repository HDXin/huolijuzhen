package com.sudaotech.huolijuzhen.task.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.task.dao.DescribleEntity;
import com.sudaotech.huolijuzhen.task.dao.DescribleEntityExample;
import com.sudaotech.huolijuzhen.task.dao.DescribleEntityExample.Criteria;
import com.sudaotech.huolijuzhen.task.dao.LocationDescribleEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.BeanUtils;

public class DescribleServiceImpl extends BaseServiceImpl implements DescribleService {
	private static final String TRACKING_TYPE = "Describle";

    @Inject
    private LocationDescribleEntityMapper describleEntityMapper;

	@Override
	public Describle getById(Long id) {
		DescribleEntity entity = this.describleEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Describle.class);
		}
		
		return null;
	}

	@Override
	public Long create(Describle obj) {
		logger.debug("Creating Describle: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		DescribleEntity entity = BeanUtils.copyProperties(obj, DescribleEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.describleEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Describle: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Describle obj) {
		logger.debug("Updating Describle: {}", obj);

		DescribleEntity entity = BeanUtils.copyProperties(obj, DescribleEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.describleEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Describle: {}", obj);
	}

	@Override
	public Long save(Describle obj) {
		logger.debug("Saving Describle: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	/**
	 * 根据条件分页检索
	 */
	@Override
	public Page<Describle> find(Query query) {
		Page<Describle> page = new Page<Describle>(query);
		DescribleEntityExample example = new DescribleEntityExample();
		Criteria criteria = example.createCriteria();
		
		//获取当前园区的常用术语
		Long parkId = query.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		//1.描述
		String description = query.getDescription();
		if(StringUtils.isNotBlank(description)){
			criteria.andDesciptionLike("%" + description + "%");
		}
		//启用、禁用状态
		String enableStatus = query.getEnableStatus();
		if(StringUtils.isNotBlank(enableStatus)){
			criteria.andEnableStatusEqualTo(EnableStatus.valueOf(enableStatus));
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.describleEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<DescribleEntity> list = this.describleEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Describle.class));
		}
		
		return page;
	}

	@Override
	public List<Describle> findAll(Long parkId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parkId", parkId);
		params.put("status", Status.NORMAL.code());
		params.put("enableStatus", EnableStatus.ENABLE.code());
		
		List<Describle> list = describleEntityMapper.findAll(params);
		
		return list;
	}
}
