package com.sudaotech.huolijuzhen.sys.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.sys.common.dao.ImageInfoEntity;
import com.sudaotech.huolijuzhen.sys.common.dao.ImageInfoEntityExample;
import com.sudaotech.huolijuzhen.sys.common.dao.ImageInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.sys.common.dao.LocationImageInfoEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class ImageInfoServiceImpl extends BaseServiceImpl implements ImageInfoService {
	private static final String TRACKING_TYPE = "ImageInfo";

    @Inject
    private LocationImageInfoEntityMapper imageInfoEntityMapper;

	@Override
	public ImageInfo getById(Long id) {
		ImageInfoEntity entity = this.imageInfoEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ImageInfo.class);
		}
		
		return null;
	}

	@Override
	public Long create(ImageInfo obj) {
		logger.debug("Creating ImageInfo: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_SYS_IMAGE));
		
		ImageInfoEntity entity = BeanUtils.copyProperties(obj, ImageInfoEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.imageInfoEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ImageInfo: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ImageInfo obj) {
		logger.debug("Updating ImageInfo: {}", obj);

		ImageInfoEntity entity = BeanUtils.copyProperties(obj, ImageInfoEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.imageInfoEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ImageInfo: {}", obj);
	}

	@Override
	public Long save(ImageInfo obj) {
		logger.debug("Saving ImageInfo: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ImageInfo> find(Query query) {
		Page<ImageInfo> page = new Page<ImageInfo>(query);
		ImageInfoEntityExample example = new ImageInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.imageInfoEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ImageInfoEntity> list = this.imageInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ImageInfo.class));
		}
		
		return page;
	}

	/**
	 * 根据图片类型、所属元素 ID 获取所有符合要求的图片
	 */
	@Override
	public List<ImageInfo> findAllByImageTypeAndTargetId(ImageType imageType,
			Long targetId) {
		
		ImageInfoEntityExample example = new ImageInfoEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andImageTypeEqualTo(imageType);
		criteria.andTargetIdEqualTo(targetId);
		criteria.andStatusEqualTo(Status.NORMAL);
		
		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.imageInfoEntityMapper.selectByExample(example), ImageInfo.class);
	}
	
	/**
	 * 删除该属性所有的图片
	 */
	@Override
	public int deleteMore(ImageType imageType, Long targetId) {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("imageType", imageType.code());
		params.put("targetId", targetId);
		params.put("status", Status.DELETED.code());
		
		int rowNum = imageInfoEntityMapper.deleteMore(params);
		return rowNum;
	}

	@Override
	public List<ImageInfo> findByObj(ImageInfo imageInfo) {
		ImageInfoEntityExample example = new ImageInfoEntityExample();
		Criteria criteria = example.createCriteria();
		
		if(imageInfo.getImageType() != null){
			criteria.andImageTypeEqualTo(imageInfo.getImageType());
		}
		
		if(imageInfo.getTargetId() != null){
			criteria.andTargetIdEqualTo(imageInfo.getTargetId());
		}
		
		if(imageInfo.getServiceProRelease() != null){
			criteria.andServiceProReleaseEqualTo(imageInfo.getServiceProRelease());
		}
		
		if(!imageInfo.getIsAll()){
			criteria.andStatusEqualTo(Status.NORMAL);
		}
		
		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.imageInfoEntityMapper.selectByExample(example), ImageInfo.class);
	}
}
