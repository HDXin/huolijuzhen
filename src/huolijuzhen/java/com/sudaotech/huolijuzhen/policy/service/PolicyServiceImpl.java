package com.sudaotech.huolijuzhen.policy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.policy.dao.PolicyEntity;
import com.sudaotech.huolijuzhen.policy.dao.PolicyEntityExample;
import com.sudaotech.huolijuzhen.policy.dao.PolicyEntityExample.Criteria;
import com.sudaotech.huolijuzhen.policy.dao.LocationPolicyEntityMapper;
import com.sudaotech.util.BeanUtils;

public class PolicyServiceImpl extends BaseServiceImpl implements PolicyService {
	private static final String TRACKING_TYPE = "Policy";

	@Inject
	private LocationPolicyEntityMapper policyEntityMapper;

	@Override
	public Policy getById(Long id) {
		PolicyEntity entity = this.policyEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Policy.class);
		}

		return null;
	}

	@Override
	public Long create(Policy obj) {
		logger.debug("Creating Policy: {}", obj);

		obj.setId(this.getSequenceService().nextLong());

		PolicyEntity entity = BeanUtils.copyProperties(obj, PolicyEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.policyEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create",
				entity);

		logger.info("Created Policy: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Policy obj) {
		logger.debug("Updating Policy: {}", obj);

		PolicyEntity entity = BeanUtils.copyProperties(obj, PolicyEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.policyEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update",
				entity);

		logger.info("Updated Policy: {}", obj);
	}

	@Override
	public Long save(Policy obj) {
		logger.debug("Saving Policy: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Policy> find(Query query) {
		Page<Policy> page = new Page<Policy>(query);
		PolicyEntityExample example = new PolicyEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.policyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<PolicyEntity> list = this.policyEntityMapper
					.selectByExampleWithRowbounds(example,
							this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Policy.class));
		}

		return page;
	}

	/**
	 * 按条件查询
	 * @throws ParseException 
	 */
	@Override
	public Page<Policy> findByCondition(Query query) throws ParseException {
		Page<Policy> page = new Page<Policy>(query);
		PolicyEntityExample example = new PolicyEntityExample();
		Criteria criteria = example.createCriteria();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = query.getStartDate();
		if (StringUtils.isNotBlank(startDate)) {
			Date startCreateDate = sdf.parse(startDate);
			criteria.andCreateTimeGreaterThan(startCreateDate);
		}
		String endDate = query.getEndDate();
		if(StringUtils.isNotBlank(endDate)){
			Date endCreateDate = sdf.parse(endDate);
			criteria.andCreateTimeLessThanOrEqualTo(endCreateDate);
		}
		
		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.policyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<PolicyEntity> list = this.policyEntityMapper
					.selectByExampleWithRowbounds(example,
							this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Policy.class));
		}

		return page;
	}

	/**
	 * 当为匿名用户时，获取去所有的平台的政策
	 */
	@Override
	public Page<Policy> findAllPlatform(AdminEnterpriseQuery query) {
		Page<Policy> page = new Page<Policy>(query);
		PolicyEntityExample example = new PolicyEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andApprovalStatusEqualTo(ApprovalStatus.ALREADYPASS);
		criteria.andPublicGradeEqualTo(PublicGrade.PLATFORM);
		
		criteria.andStatusEqualTo(Status.NORMAL);
		
		example.setOrderByClause("approvalTime DESC");
		
		page.setTotal(this.policyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<PolicyEntity> list = this.policyEntityMapper
					.selectByExampleWithRowbounds(example,
							this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Policy.class));
		}

		return page;
	}

	/**
	 * 根据 parkId 获取指定园区可见的政策
	 */
	@Override
	public Page<Policy> findAllByParkId(AdminEnterpriseQuery query) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("offset", query.getOffset());
		params.put("limit", query.getLimit());
		params.put("pPublicGrade", PublicGrade.PLATFORM.code());
		params.put("aPublicGrade", PublicGrade.ADMINISTRACTIVE.code());
		params.put("status", Status.NORMAL.code());
		params.put("approvalStatus", ApprovalStatus.ALREADYPASS.code());
		
		params.put("proId", query.getProId());
		params.put("cityId", query.getCityId());
		params.put("counId", query.getCounId());
		params.put("locationId", query.getLocationId());
		
		Integer total = policyEntityMapper.findAllCountByParkId(params);
		
		List<Policy> list = policyEntityMapper.findAllByParkId(params);
		
		Page<Policy> page = new Page<Policy>();
		page.setItems(list);
		page.setTotal(total);
		
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		
		return page;
	}

	/**
	 * 政策统计
	 */
	@Override
	public Page<Policy> statistics(Query query) {
		Page<Policy> page = new Page<Policy>(query);
		PolicyEntityExample example = new PolicyEntityExample();
		Criteria criteria = example.createCriteria();

		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("readNum DESC");
		page.setTotal(this.policyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<PolicyEntity> list = this.policyEntityMapper
					.selectByExampleWithRowbounds(example,
							this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Policy.class));
		}

		return page;
	}
}
