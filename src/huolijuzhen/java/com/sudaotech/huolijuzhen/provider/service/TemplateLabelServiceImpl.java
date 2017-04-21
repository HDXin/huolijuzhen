package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.TemplateLabelEntity;
import com.sudaotech.huolijuzhen.provider.dao.TemplateLabelEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.TemplateLabelEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.LocationTemplateLabelEntityMapper;
import com.sudaotech.util.BeanUtils;

public class TemplateLabelServiceImpl extends BaseServiceImpl implements TemplateLabelService {
	private static final String TRACKING_TYPE = "TemplateLabel";

    @Inject
    private LocationTemplateLabelEntityMapper templateLabelEntityMapper;

	@Override
	public TemplateLabel getById(Long id) {
		TemplateLabelEntity entity = this.templateLabelEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, TemplateLabel.class);
		}
		
		return null;
	}

	@Override
	public Long create(TemplateLabel obj) {
		logger.debug("Creating TemplateLabel: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		Long labelNo = obj.getId();
		obj.setLabelNo(labelNo);
		
		TemplateLabelEntity entity = BeanUtils.copyProperties(obj, TemplateLabelEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.templateLabelEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created TemplateLabel: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(TemplateLabel obj) {
		logger.debug("Updating TemplateLabel: {}", obj);

		TemplateLabelEntity entity = BeanUtils.copyProperties(obj, TemplateLabelEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.templateLabelEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated TemplateLabel: {}", obj);
	}

	@Override
	public Long save(TemplateLabel obj) {
		logger.debug("Saving TemplateLabel: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<TemplateLabel> find(Query query) {
		Page<TemplateLabel> page = new Page<TemplateLabel>(query);
		TemplateLabelEntityExample example = new TemplateLabelEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long applyTemplateId = query.getApplyTemplateId();
		if(applyTemplateId != null){
			criteria.andApplyTemplateIdEqualTo(applyTemplateId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("labelNo ASC");
		page.setTotal(this.templateLabelEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TemplateLabelEntity> list = this.templateLabelEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, TemplateLabel.class));
		}
		
		return page;
	}

	@Override
	public List<Map<String, Object>> findByApplyTemplateId(Long applateTemplateId) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("applyTemplateId", applateTemplateId);
		params.put("status", Status.NORMAL.code());
		
		List<Map<String, Object>> templateLabelList = this.templateLabelEntityMapper.findByApplyTemplateId(params);
		return templateLabelList;
	}

	/**
	 * 获取前面一个标签
	 */
	@Override
	public List<TemplateLabel> findUpItem(TemplateLabel templateLabel) {

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("labelNo", templateLabel.getLabelNo());
		params.put("applyTemplateId", templateLabel.getApplyTemplateId());
		params.put("status", Status.NORMAL.code());
		List<TemplateLabel> templateLabels = templateLabelEntityMapper.findUpItem(params);
		
		return templateLabels;
	}

	/**
	 * 获取其后的一个标签
	 */
	@Override
	public List<TemplateLabel> findDownItem(TemplateLabel templateLabel) {

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("labelNo", templateLabel.getLabelNo());
		params.put("applyTemplateId", templateLabel.getApplyTemplateId());
		params.put("status", Status.NORMAL.code());
		
		List<TemplateLabel> templateLabels = templateLabelEntityMapper.findDownItem(params);
		
		return templateLabels;
	}

	@Override
	public List<TemplateLabel> findByObj(TemplateLabel templateLabel) {
		TemplateLabelEntityExample example = new TemplateLabelEntityExample();
		Criteria criteria = example.createCriteria();
		
		if(templateLabel.getApplyTemplateId() != null){
			criteria.andApplyTemplateIdEqualTo(templateLabel.getApplyTemplateId());
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("labelNo ASC");
		return BeanUtils.copyListProperties(this.templateLabelEntityMapper.selectByExample(example), TemplateLabel.class);
	}
}
