package com.sudaotech.content.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.content.dao.ContentEntity;
import com.sudaotech.content.dao.ContentEntityExample;
import com.sudaotech.content.dao.ContentEntityExample.Criteria;
import com.sudaotech.content.dao.ContentEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ContentServiceImpl extends BaseServiceImpl implements ContentService {
	private static final String TRACKING_TYPE = "Content";

    @Inject
    private ContentEntityMapper contentEntityMapper;

	@Override
	public Content getById(Long contentId) {
		ContentEntity entity = this.contentEntityMapper.selectByPrimaryKey(contentId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Content.class);
		}
		
		return null;
	}

	@Override
	public Long create(Content obj) {
		logger.debug("Creating Content: {}", obj);

		obj.setContentId(this.getSequenceService().nextLong());
		
		ContentEntity entity = BeanUtils.copyProperties(obj, ContentEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.contentEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getContentId(), "create", entity);
		
		logger.info("Created Content: {}", obj);

		return obj.getContentId();
	}

	@Override
	public void update(Content obj) {
		logger.debug("Updating Content: {}", obj);

		ContentEntity entity = BeanUtils.copyProperties(obj, ContentEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.contentEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getContentId(), "update", entity);

		logger.info("Updated Content: {}", obj);
	}

	@Override
	public Long save(Content obj) {
		logger.debug("Saving Content: {}", obj);

		if (obj.getContentId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getContentId();
	}

	@Override
	public Page<Content> find(ContentQuery query) {
		Page<Content> page = new Page<Content>(query);
		ContentEntityExample example = new ContentEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if (StringUtils.isNotBlank(query.getParent())) {
		    criteria.andParentEqualTo(query.getParent());
		}
		if (CollectionUtils.isNotEmpty(query.getContentTypes())) {
		    criteria.andContentTypeIn(query.getContentTypes());
		}
        if (StringUtils.isNotBlank(query.getTitle())) {
            criteria.andTitleLike("%" + StringUtils.trim(query.getTitle()) + "%");
        }

		example.setOrderByClause("displayOrder DESC, contentId DESC");
		page.setTotal(this.contentEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<ContentEntity> list = this.contentEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Content.class));
		}
		
		return page;
	}
}
