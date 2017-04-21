package com.sudaotech.huolijuzhen.bill.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntity;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class CostProSettingServiceImpl extends BaseServiceImpl implements CostProSettingService {
	private static final String TRACKING_TYPE = "CostProSetting";

    @Inject
    private CostProSettingEntityMapper costProSettingEntityMapper;

	@Override
	public CostProSetting getById(Long id) {
		CostProSettingEntity entity = this.costProSettingEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, CostProSetting.class);
		}
		
		return null;
	}

	@Override
	public Long create(CostProSetting obj) {
		logger.debug("Creating CostProSetting: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_COST_PRO_SETTING));
		
		CostProSettingEntity entity = BeanUtils.copyProperties(obj, CostProSettingEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.costProSettingEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created CostProSetting: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(CostProSetting obj) {
		logger.debug("Updating CostProSetting: {}", obj);

		CostProSettingEntity entity = BeanUtils.copyProperties(obj, CostProSettingEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.costProSettingEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated CostProSetting: {}", obj);
	}

	@Override
	public Long save(CostProSetting obj) {
		logger.debug("Saving CostProSetting: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<CostProSetting> find(Query query) {
		Page<CostProSetting> page = new Page<CostProSetting>(query);
		CostProSettingEntityExample example = new CostProSettingEntityExample();
		Criteria criteria = example.createCriteria();
		String billMonth = query.getBillMonth();
		if(StringUtils.isBlank(billMonth)){
			billMonth = SystemUtil.dateFormat(new Date(), "yyyy-MM");
		}
		criteria.andBillMonthEqualTo(billMonth);
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andEnableStatusEqualTo(EnableStatus.ENABLE);
		example.setOrderByClause("contractId ASC");
		page.setTotal(this.costProSettingEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CostProSettingEntity> list = this.costProSettingEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, CostProSetting.class));
		}
		
		return page;
	}

	@Override
	public CostProSetting findByObject(CostProSetting costProSetting) {
		CostProSettingEntityExample example = new CostProSettingEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long contractId = costProSetting.getContractId();
		if(contractId != null){
			criteria.andContractIdEqualTo(contractId);
		}
		Long costProType = costProSetting.getCostProType();
		if(costProType != null){
			criteria.andCostProTypeEqualTo(costProType);
		}
		String billMonth = costProSetting.getBillMonth();
		if(StringUtils.isNotBlank(billMonth)){
			criteria.andBillMonthEqualTo(billMonth);
		}
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("contractId ASC");		
		List<CostProSetting> costProSettings = BeanUtils.copyListProperties(this.costProSettingEntityMapper.selectByExample(example), CostProSetting.class);
		if(CollectionUtils.isNotEmpty(costProSettings)){
			return costProSettings.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<CostProSetting> findAllByObject(CostProSetting costProSetting) {
		CostProSettingEntityExample example = new CostProSettingEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long costProType = costProSetting.getCostProType();
		if(costProType != null){
			criteria.andCostProTypeEqualTo(costProType);
		}
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("enterpriseName ASC");		
		List<CostProSetting> costProSettings = BeanUtils.copyListProperties(this.costProSettingEntityMapper.selectByExample(example), CostProSetting.class);
		if(CollectionUtils.isNotEmpty(costProSettings)){
			return costProSettings;
		}else{
			return null;
		}
	}
}
