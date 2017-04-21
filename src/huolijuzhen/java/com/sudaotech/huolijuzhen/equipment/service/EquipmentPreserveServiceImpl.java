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
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntity;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntityExample;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntityExample.Criteria;
import com.sudaotech.huolijuzhen.equipment.dao.LocationEquipmentPreserveEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.BeanUtils;

public class EquipmentPreserveServiceImpl extends BaseServiceImpl implements EquipmentPreserveService {
	private static final String TRACKING_TYPE = "EquipmentPreserve";

    @Inject
    private LocationEquipmentPreserveEntityMapper equipmentPreserveEntityMapper;

	@Override
	public EquipmentPreserve getById(Long id) {
		EquipmentPreserveEntity entity = this.equipmentPreserveEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EquipmentPreserve.class);
		}
		
		return null;
	}

	@Override
	public Long create(EquipmentPreserve obj) {
		logger.debug("Creating EquipmentPreserve: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EquipmentPreserveEntity entity = BeanUtils.copyProperties(obj, EquipmentPreserveEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.equipmentPreserveEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EquipmentPreserve: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EquipmentPreserve obj) {
		logger.debug("Updating EquipmentPreserve: {}", obj);

		EquipmentPreserveEntity entity = BeanUtils.copyProperties(obj, EquipmentPreserveEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.equipmentPreserveEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EquipmentPreserve: {}", obj);
	}

	@Override
	public Long save(EquipmentPreserve obj) {
		logger.debug("Saving EquipmentPreserve: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	/**
	 * 根据条件进行分页检索
	 */
	@Override
	public Page<EquipmentPreserve> find(Query query) {
		Page<EquipmentPreserve> page = new Page<EquipmentPreserve>(query);
		EquipmentPreserveEntityExample example = new EquipmentPreserveEntityExample();
		Criteria criteria = example.createCriteria();
		
		//1.名称
		String name = query.getName();
		if(StringUtils.isNotBlank(name)){
			criteria.andNameLike("%" + name + "%");
		}
		//2.代码
		String code = query.getCode();
		if(StringUtils.isNotBlank(code)){
			criteria.andCodeLike("%" + code + "%");
		}
		//3.设备类型
		Long equTypeId = query.getEquTypeId();
		if(equTypeId != null){
			criteria.andEquTypeIdEqualTo(equTypeId);
		}
		//4.启用、禁用状态
		String enableStatus = query.getEnableStatus();
		if(StringUtils.isNotBlank(enableStatus)){
			criteria.andEnableStatusEqualTo(EnableStatus.valueOf(enableStatus));
		}
		criteria.andParkIdEqualTo(query.getParkId());
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.equipmentPreserveEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EquipmentPreserveEntity> list = this.equipmentPreserveEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EquipmentPreserve.class));
		}
		
		return page;
	}
	
	/**
	 * 根据条件进行分页检索
	 */
	@Override
	public List<EquipmentPreserve> findByObj(EquipmentPreserve equipmentPreserve) {
		EquipmentPreserveEntityExample example = new EquipmentPreserveEntityExample();
		Criteria criteria = example.createCriteria();
		
		//1.园区 ID
		if(equipmentPreserve.getParkId() != null){
			criteria.andParkIdEqualTo(equipmentPreserve.getParkId());
		}
		//2.启用、禁用状态
		EnableStatus enableStatus = equipmentPreserve.getEnableStatus();
		if(enableStatus != null){
			criteria.andEnableStatusEqualTo(enableStatus);
		}

		//3.未删除状态
		criteria.andStatusEqualTo(Status.NORMAL);
		return BeanUtils.copyListProperties(this.equipmentPreserveEntityMapper.selectByExample(example), EquipmentPreserve.class);
	}
	
	

	/**
	 * 根据设备类型获取任务数
	 */
	@Override
	public int findCountByEquTypeId(Long parkId,Long equTypeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Status.NORMAL.code());
		params.put("parkId", parkId);
		params.put("equTypeId", equTypeId);
		
		int count = equipmentPreserveEntityMapper.findCountByEquTypeId(params);
		
		return count;
	}
}
