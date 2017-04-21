package com.sudaotech.user.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.user.dao.ExternalUserEntity;
import com.sudaotech.user.dao.ExternalUserEntityExample;
import com.sudaotech.user.dao.ExternalUserEntityExample.Criteria;
import com.sudaotech.user.dao.ExternalUserEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ExternalUserServiceImpl extends BaseServiceImpl implements ExternalUserService {
	private static final String TRACKING_TYPE = "ExternalUser";

    @Inject
    private ExternalUserEntityMapper externalUserEntityMapper;

	@Override
	public ExternalUser getById(Long userId) {
		ExternalUserEntity entity = this.externalUserEntityMapper.selectByPrimaryKey(userId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ExternalUser.class);
		}
		
		return null;
	}

	@Override
	public Long create(ExternalUser obj) {
		logger.debug("Creating ExternalUser: {}", obj);

		ExternalUserEntity entity = BeanUtils.copyProperties(obj, ExternalUserEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.externalUserEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ExternalUser: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ExternalUser obj) {
		logger.debug("Updating ExternalUser: {}", obj);

		ExternalUserEntity entity = BeanUtils.copyProperties(obj, ExternalUserEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.externalUserEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ExternalUser: {}", obj);
	}

	@Override
	public Long save(ExternalUser obj) {
		logger.debug("Saving ExternalUser: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ExternalUser> find(Query query) {
		Page<ExternalUser> page = new Page<ExternalUser>(query);
		ExternalUserEntityExample example = new ExternalUserEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.externalUserEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<ExternalUserEntity> list = this.externalUserEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ExternalUser.class));
		}
		
		return page;
	}

    @Override
    public ExternalUser getByOpenId(String openId) {
        ExternalUserEntityExample example = new ExternalUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL).andOpenIdEqualTo(openId);
        List<ExternalUserEntity> list = this.externalUserEntityMapper.selectByExampleWithBLOBs(example);
        if (list.size() > 1) {
            throw new IllegalStateException("found " + list.size() + " records by openId: " + openId);
        }
        if (list.isEmpty()) {
            return null;
        }
        return BeanUtils.copyProperties(list.get(0), ExternalUser.class);
    }
}
