package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCommentEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCommentEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCommentEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceCommentEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ServiceCommentServiceImpl extends BaseServiceImpl implements ServiceCommentService {
	private static final String TRACKING_TYPE = "ServiceComment";

    @Inject
    private LocationServiceCommentEntityMapper serviceCommentEntityMapper;

	@Override
	public ServiceComment getById(Long id) {
		ServiceCommentEntity entity = this.serviceCommentEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceComment.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceComment obj) {
		logger.debug("Creating ServiceComment: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceCommentEntity entity = BeanUtils.copyProperties(obj, ServiceCommentEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceCommentEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceComment: {}", obj);

		return obj.getId();
	}
	
	@Override
	public void update(ServiceComment obj) {
		logger.debug("Updating ServiceComment: {}", obj);

		ServiceCommentEntity entity = BeanUtils.copyProperties(obj, ServiceCommentEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceCommentEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceComment: {}", obj);
	}

	@Override
	public Long save(ServiceComment obj) {
		logger.debug("Saving ServiceComment: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceComment> find(Query query) {
		Page<ServiceComment> page = new Page<ServiceComment>(query);
		ServiceCommentEntityExample example = new ServiceCommentEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long serviceProId = query.getServiceProId();
		if(serviceProId != null){
			criteria.andServiceProIdEqualTo(serviceProId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceCommentEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceCommentEntity> list = this.serviceCommentEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceComment.class));
		}
		
		return page;
	}

	@Override
	public List<Integer> findGradeNum(Long serviceProId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceProId", serviceProId);
		params.put("status", Status.NORMAL.code());
	
		List<Integer> gradeNumSum = serviceCommentEntityMapper.findGradeNum(params);
		
		return gradeNumSum;
	}
}
