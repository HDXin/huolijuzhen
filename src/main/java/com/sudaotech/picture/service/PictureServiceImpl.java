package com.sudaotech.picture.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.picture.dao.PictureEntity;
import com.sudaotech.picture.dao.PictureEntityExample;
import com.sudaotech.picture.dao.PictureEntityExample.Criteria;
import com.sudaotech.picture.dao.PictureEntityMapper;
import com.sudaotech.util.BeanUtils;

public class PictureServiceImpl extends BaseServiceImpl implements PictureService {
	private static final String TRACKING_TYPE = "Picture";

    @Inject
    private PictureEntityMapper pictureEntityMapper;

	@Override
	public Picture getById(Long pictureId) {
		PictureEntity entity = this.pictureEntityMapper.selectByPrimaryKey(pictureId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Picture.class);
		}
		
		return null;
	}

	@Override
	public Long create(Picture obj) {
		logger.debug("Creating Picture: {}", obj);

		obj.setPictureId(this.getSequenceService().nextLong());
		
		PictureEntity entity = BeanUtils.copyProperties(obj, PictureEntity.class);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());

		this.pictureEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getPictureId(), "create", entity);
		
		logger.info("Created Picture: {}", obj);

		return obj.getPictureId();
	}

	@Override
	public void update(Picture obj) {
		logger.debug("Updating Picture: {}", obj);

		PictureEntity entity = BeanUtils.copyProperties(obj, PictureEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.pictureEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getPictureId(), "update", entity);

		logger.info("Updated Picture: {}", obj);
	}

	@Override
	public Page<Picture> find(Query query) {
		Page<Picture> page = new Page<Picture>(query);
		PictureEntityExample example = new PictureEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("pictureId DESC");
		page.setTotal(this.pictureEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<PictureEntity> list = this.pictureEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Picture.class));
		}
		
		return page;
	}
}
