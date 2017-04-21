package com.sudaotech.huolijuzhen.basic.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntity;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class CostProServiceImpl extends BaseServiceImpl implements CostProService {
	private static final String TRACKING_TYPE = "CostPro";

    @Inject
    private CostProEntityMapper costProEntityMapper;

	@Override
	public CostPro getById(Long id) {
		CostProEntity entity = this.costProEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, CostPro.class);
		}
		
		return null;
	}

	@Override
	public Long create(CostPro obj) {
		logger.debug("Creating CostPro: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_COST_PRO));
		
		CostProEntity entity = BeanUtils.copyProperties(obj, CostProEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.costProEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created CostPro: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(CostPro obj) {
		logger.debug("Updating CostPro: {}", obj);

		CostProEntity entity = BeanUtils.copyProperties(obj, CostProEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.costProEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated CostPro: {}", obj);
	}

	@Override
	public Long save(CostPro obj) {
		logger.debug("Saving CostPro: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<CostPro> find(Query query) {
		Page<CostPro> page = new Page<CostPro>(query);
		CostProEntityExample example = new CostProEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(StringUtils.isNotBlank(query.getCode())){
			criteria.andCodeEqualTo(query.getCode());
		}
		if(StringUtils.isNotBlank(query.getName())){
			criteria.andNameLike("%"+query.getName()+"%");
		}
		
		if(query.getChargeMode() != null){
			criteria.andChargeModeEqualTo(query.getChargeMode());
		}
		if(query.getEnableStatus() != null){
			criteria.andEnableStatusEqualTo(query.getEnableStatus());
		}
		if(query.getCreateSource() != null){
			criteria.andCreateSourceEqualTo(query.getCreateSource());
		}
		if(query.getParkId() != null){
			criteria.andParkIdEqualTo(query.getParkId());
		}
		if(query.getIsDefault() != null){
			criteria.andIsDefaultEqualTo(query.getIsDefault());
		}
		
		example.setOrderByClause("id DESC ,enableStatus ASC ");
		
		page.setTotal(this.costProEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CostProEntity> list = this.costProEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, CostPro.class));
		}
		
		return page;
	}

	@Override
	public List<CostPro> findByObj(CostPro cp) {
		CostProEntityExample example = new CostProEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(StringUtils.isNotBlank(cp.getCode())){
			criteria.andCodeEqualTo(cp.getCode());
		}
		if(StringUtils.isNotBlank(cp.getName())){
			criteria.andNameLike("%"+cp.getName()+"%");
		}
		
		if(cp.getChargeMode() != null){
			criteria.andChargeModeEqualTo(cp.getChargeMode());
		}
		if(cp.getEnableStatus() != null){
			criteria.andEnableStatusEqualTo(cp.getEnableStatus());
		}
		if(cp.getCreateSource() != null){
			criteria.andCreateSourceEqualTo(cp.getCreateSource());
		}
		if(cp.getParkId() != null){
			criteria.andParkIdEqualTo(cp.getParkId());
		}
		if(cp.getIsDefault() != null){
			criteria.andIsDefaultEqualTo(cp.getIsDefault());
		}
		example.setOrderByClause("id DESC ");
		
		List<CostProEntity> list = this.costProEntityMapper.selectByExample(example);
	    return BeanUtils.copyListProperties(list, CostPro.class);
	}
}
