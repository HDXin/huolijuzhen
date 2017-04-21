package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntity;
import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.LocationApplyOrderEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ApplyOrderServiceImpl extends BaseServiceImpl implements ApplyOrderService {
	private static final String TRACKING_TYPE = "ApplyOrder";

    @Inject
    private LocationApplyOrderEntityMapper applyOrderEntityMapper;

	@Override
	public ApplyOrder getById(Long id) {
		ApplyOrderEntity entity = this.applyOrderEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApplyOrder.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApplyOrder obj) {
		logger.debug("Creating ApplyOrder: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApplyOrderEntity entity = BeanUtils.copyProperties(obj, ApplyOrderEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.applyOrderEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApplyOrder: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApplyOrder obj) {
		logger.debug("Updating ApplyOrder: {}", obj);

		ApplyOrderEntity entity = BeanUtils.copyProperties(obj, ApplyOrderEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.applyOrderEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApplyOrder: {}", obj);
	}

	@Override
	public Long save(ApplyOrder obj) {
		logger.debug("Saving ApplyOrder: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApplyOrder> findAll(FindCondition findCondition) {
		Page<ApplyOrder> page = new Page<ApplyOrder>(findCondition);
		ApplyOrderEntityExample example = new ApplyOrderEntityExample();
		Criteria criteria = example.createCriteria();

		List<Long> serviceProIds = findCondition.getServiceProIds();
		boolean isPlatform = findCondition.getIsPlatform();
		if(isPlatform){
			if(CollectionUtils.isEmpty(serviceProIds)){
				criteria.andServiceProIdIsNotNull();
			}else{
				criteria.andServiceProIdIn(serviceProIds);
			}
		}else{
			if(CollectionUtils.isEmpty(serviceProIds)){
				return page;
			}else{
				criteria.andServiceProIdIn(serviceProIds);
			}
		}
		
		Long enterpriseId = findCondition.getEnterpriseId();
		if(enterpriseId != null){
			criteria.andEnterpriseIdEqualTo(enterpriseId);
		}
		
		Date startDate = findCondition.getStartDate();
		if(startDate != null){
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		
		Date endDate = findCondition.getEndDate();
		if(endDate != null){
			criteria.andCreateTimeLessThanOrEqualTo(endDate);
		}
		
		String enterpriceName = findCondition.getEnterpriseName();
		if(StringUtils.isNotBlank(enterpriceName)){
			criteria.andEnterpriseNameLike("%" + enterpriceName + "%");
		}
		
		String applyOrderNo = findCondition.getApplyOrderNo();
		if(StringUtils.isNotBlank(applyOrderNo)){
			criteria.andApplyOrderNoLike("%" + applyOrderNo + "%");
		}
		
		ApplyOrderType applyOrderType = findCondition.getApplyOrderType();
		if(applyOrderType != null){
			criteria.andApplyOrderTypeEqualTo(applyOrderType);
		}
		
		List<ApplyOrderStatus> applyOrderStatusList = findCondition.getApplyOrderStatusList();
		if(CollectionUtils.isNotEmpty(applyOrderStatusList)){
			criteria.andApplyOrderStatusIn(applyOrderStatusList);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.applyOrderEntityMapper.countByExample(example));
		if (page.getTotal() > findCondition.getOffset()) {
			List<ApplyOrderEntity> list = this.applyOrderEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(findCondition));
			page.setItems(BeanUtils.copyListProperties(list, ApplyOrder.class));
		}
		
		return page;
	}

	@Override
	public Integer findApplyOrOrderCount(Long serviceProId,ApplyOrderType applyOrderType) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applyOrderType", applyOrderType.code());
		params.put("serviceProId", serviceProId);
		params.put("status", Status.NORMAL.code());
		
		Integer applyOrderNum = applyOrderEntityMapper.findApplyOrOrderCount(params);
		
		return applyOrderNum == null ? 0:applyOrderNum;
	}
	
	@Override
	public Integer findApplyOrderCount(Long serviceProId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceProId", serviceProId);
		params.put("status", Status.NORMAL.code());
		
		Integer applyOrderNum = applyOrderEntityMapper.findApplyOrderCount(params);
		
		return applyOrderNum == null ? 0:applyOrderNum;
	}

	/**
	 * 支付回调函数，维护订单状态
	 */
	@Override
	public int updateStatusByPay(ApplyOrder applyOrder) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("payWay", applyOrder.getPayWay().code());
		params.put("applyOrderStatus", applyOrder.getApplyOrderStatus().code());
		params.put("applyOrderNo", applyOrder.getApplyOrderNo());
		
		int num = applyOrderEntityMapper.updateStatusByPay(params);
		return num;
	}

	@Override
	public ApplyOrder findByApplyOrderNo(String applyOrderNo) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("applyOrderNo", applyOrderNo);
		params.put("status", Status.NORMAL.code());
		
		List<ApplyOrder> applyOrders = applyOrderEntityMapper.findByApplyOrderNo(params);
		
		if(CollectionUtils.isNotEmpty(applyOrders)){
			return applyOrders.get(0);
		}
		
		return null;
	}

	@Override
	public Page<ApplyOrder> findAllOfEnterprise(FindCondition findCondition) {
		Page<ApplyOrder> page = new Page<ApplyOrder>(findCondition);
		ApplyOrderEntityExample example = new ApplyOrderEntityExample();
		Criteria criteria = example.createCriteria();

		Long enterpriseId = findCondition.getEnterpriseId();
		if(enterpriseId != null){
			criteria.andEnterpriseIdEqualTo(enterpriseId);
		}
		
		Date startDate = findCondition.getStartDate();
		if(startDate != null){
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		
		Date endDate = findCondition.getEndDate();
		if(endDate != null){
			criteria.andCreateTimeLessThanOrEqualTo(endDate);
		}
		
		String enterpriceName = findCondition.getEnterpriseName();
		if(StringUtils.isNotBlank(enterpriceName)){
			criteria.andEnterpriseNameLike("%" + enterpriceName + "%");
		}
		
		String applyOrderNo = findCondition.getApplyOrderNo();
		if(StringUtils.isNotBlank(applyOrderNo)){
			criteria.andApplyOrderNoLike("%" + applyOrderNo + "%");
		}
		
		
		
		ApplyOrderType applyOrderType = findCondition.getApplyOrderType();
		if(applyOrderType != null){
			criteria.andApplyOrderTypeEqualTo(applyOrderType);
		}
		
		List<ApplyOrderStatus> applyOrderStatusList = findCondition.getApplyOrderStatusList();
		if(CollectionUtils.isNotEmpty(applyOrderStatusList)){
			criteria.andApplyOrderStatusIn(applyOrderStatusList);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.applyOrderEntityMapper.countByExample(example));
		if (page.getTotal() > findCondition.getOffset()) {
			List<ApplyOrderEntity> list = this.applyOrderEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(findCondition));
			page.setItems(BeanUtils.copyListProperties(list, ApplyOrder.class));
		}
		
		return page;
	}
	
}
