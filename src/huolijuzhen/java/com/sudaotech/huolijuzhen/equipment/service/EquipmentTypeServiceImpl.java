package com.sudaotech.huolijuzhen.equipment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentTypeEntity;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentTypeEntityExample;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentTypeEntityExample.Criteria;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentTypeEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.BeanUtils;

public class EquipmentTypeServiceImpl extends BaseServiceImpl implements EquipmentTypeService {
	private static final String TRACKING_TYPE = "EquipmentType";

    @Inject
    private LocationEquipmentTypeEntityMapper equipmentTypeEntityMapper;

	@Override
	public EquipmentType getById(Long id) {
		EquipmentTypeEntity entity = this.equipmentTypeEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EquipmentType.class);
		}
		
		return null;
	}

	@Override
	public Long create(EquipmentType obj) {
		logger.debug("Creating EquipmentType: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EquipmentTypeEntity entity = BeanUtils.copyProperties(obj, EquipmentTypeEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.equipmentTypeEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EquipmentType: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EquipmentType obj) {
		logger.debug("Updating EquipmentType: {}", obj);

		EquipmentTypeEntity entity = BeanUtils.copyProperties(obj, EquipmentTypeEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.equipmentTypeEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EquipmentType: {}", obj);
	}

	@Override
	public Long save(EquipmentType obj) {
		logger.debug("Saving EquipmentType: {}", obj);

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
	public Page<EquipmentType> find(Query query) {
		Page<EquipmentType> page = new Page<EquipmentType>(query);
		EquipmentTypeEntityExample example = new EquipmentTypeEntityExample();
		Criteria criteria = example.createCriteria();
		
		//1.名称或代码搜索
		String nameOrCode = query.getNameOrCode();
		if(StringUtils.isNotBlank(nameOrCode)){
			criteria.andNameLike("%" + nameOrCode + "%");
		}
		//2.启用、禁用状态搜索
		String enableStatus = query.getEnableStatus();
		if(StringUtils.isNotBlank(enableStatus)){
			criteria.andEnableStatusEqualTo(EnableStatus.valueOf(enableStatus));
		}
		
		criteria.andParkIdEqualTo(query.getParkId());
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.equipmentTypeEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EquipmentTypeEntity> list = this.equipmentTypeEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentType.class));
		}
		
		return page;
	}

	@Override
	public List<EquipmentType> findAll(Long parkId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(parkId != null){
			params.put("parkId", parkId);
		}
		params.put("status", Status.NORMAL.code());
		params.put("enableStatus", EnableStatus.ENABLE.code());
		
		List<EquipmentType> list = equipmentTypeEntityMapper.findAll(params);
		
		return list;
	}
}
