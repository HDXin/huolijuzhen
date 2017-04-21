package com.sudaotech.tag.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.tag.dao.TagEntity;
import com.sudaotech.tag.dao.TagEntityExample;
import com.sudaotech.tag.dao.TagEntityExample.Criteria;
import com.sudaotech.tag.dao.TagEntityMapper;
import com.sudaotech.util.BeanUtils;

public class TagServiceImpl extends BaseServiceImpl implements TagService {
	private static final String TRACKING_TYPE = "Tag";

    @Inject
    private TagEntityMapper tagEntityMapper;

	@Override
	public Tag getById(Long tagId) {
		TagEntity entity = this.tagEntityMapper.selectByPrimaryKey(tagId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Tag.class);
		}
		
		return null;
	}

	@Override
	public Long create(Tag obj) {
		logger.debug("Creating Tag: {}", obj);

		obj.setTagId(this.getSequenceService().nextLong());
		
		TagEntity entity = BeanUtils.copyProperties(obj, TagEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.tagEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getTagId(), "create", entity);
		
		logger.info("Created Tag: {}", obj);

		return obj.getTagId();
	}

	@Override
	public void update(Tag obj) {
		logger.debug("Updating Tag: {}", obj);

		TagEntity entity = BeanUtils.copyProperties(obj, TagEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.tagEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getTagId(), "update", entity);

		logger.info("Updated Tag: {}", obj);
	}

	@Override
	public Long save(Tag obj) {
		logger.debug("Saving Tag: {}", obj);

		if (obj.getTagId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getTagId();
	}

	@Override
	public Page<Tag> find(TagQuery query) {
		Page<Tag> page = new Page<Tag>(query);
		TagEntityExample example = new TagEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if (StringUtils.isNotBlank(query.getParent())) {
		    criteria.andParentEqualTo(query.getParent());
		}
		example.setOrderByClause("tagId DESC");
		page.setTotal(this.tagEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<TagEntity> list = this.tagEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Tag.class));
		}
		
		return page;
	}
}
