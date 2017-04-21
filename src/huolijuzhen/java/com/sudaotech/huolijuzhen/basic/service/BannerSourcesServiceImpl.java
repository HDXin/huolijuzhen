package com.sudaotech.huolijuzhen.basic.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntity;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntityExample;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntityMapper;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BannerSourcesServiceImpl extends BaseServiceImpl implements BannerSourcesService {
	private static final String TRACKING_TYPE = "BannerSources";

    @Inject
    private BannerSourcesEntityMapper bannerSourcesEntityMapper;

	@Override
	public BannerSources getById(Long id, ReqSourceType reqSourceType) {
		BannerSourcesEntityExample example = new BannerSourcesEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andReqSourceTypeEqualTo(reqSourceType);
		List<BannerSourcesEntity> list = this.bannerSourcesEntityMapper.selectByExample(example);
		BannerSourcesEntity entity = null;
		if(list.size()==1){
			entity = list.get(0);
		}
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BannerSources.class);
		}
		
		return null;
	}

	@Override
	public Long create(BannerSources obj) {
		logger.debug("Creating BannerSources: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BANNER));
		
		BannerSourcesEntity entity = BeanUtils.copyProperties(obj, BannerSourcesEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.bannerSourcesEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BannerSources: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BannerSources obj) {
		logger.debug("Updating BannerSources: {}", obj);

		BannerSourcesEntity entity = BeanUtils.copyProperties(obj, BannerSourcesEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.bannerSourcesEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BannerSources: {}", obj);
	}

	@Override
	public Long save(BannerSources obj) {
		logger.debug("Saving BannerSources: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BannerSources> find(Query query, ReqSourceType reqSourceType) {
		/*if(!ReqSourceType.APP_ENTERPRISE.equals(reqSourceType) && !ReqSourceType.APP_PARK.equals(reqSourceType) && 
				!ReqSourceType.APP_ENTERPRISE_SERVER.equals(reqSourceType) )
			return null;*/
		Page<BannerSources> page = new Page<BannerSources>(query);
		BannerSourcesEntityExample example = new BannerSourcesEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andReqSourceTypeEqualTo(reqSourceType);
		example.setOrderByClause("id DESC");
		page.setTotal(this.bannerSourcesEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BannerSourcesEntity> list = this.bannerSourcesEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BannerSources.class));
		}
		
		return page;
	}
}