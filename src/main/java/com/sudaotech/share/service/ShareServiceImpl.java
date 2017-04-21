package com.sudaotech.share.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.share.dao.ShareEntity;
import com.sudaotech.share.dao.ShareEntityExample;
import com.sudaotech.share.dao.ShareEntityExample.Criteria;
import com.sudaotech.share.dao.ShareEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ShareServiceImpl extends BaseServiceImpl implements ShareService {
	private static final String TRACKING_TYPE = "Share";

    @Inject
    private ShareEntityMapper shareEntityMapper;

	@Override
	public Share getById(Long shareId) {
		ShareEntity entity = this.shareEntityMapper.selectByPrimaryKey(shareId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Share.class);
		}
		
		return null;
	}

	@Override
	public Long create(Share obj) {
		logger.debug("Creating Share: {}", obj);

		obj.setShareId(this.getSequenceService().nextLong());
		
		ShareEntity entity = BeanUtils.copyProperties(obj, ShareEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.shareEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getShareId(), "create", entity);
		
		logger.info("Created Share: {}", obj);

		return obj.getShareId();
	}

	@Override
	public void update(Share obj) {
		logger.debug("Updating Share: {}", obj);

		ShareEntity entity = BeanUtils.copyProperties(obj, ShareEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.shareEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getShareId(), "update", entity);

		logger.info("Updated Share: {}", obj);
	}

	@Override
	public Long save(Share obj) {
		logger.debug("Saving Share: {}", obj);

		if (obj.getShareId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getShareId();
	}

	@Override
	public Page<Share> find(ShareQuery query) {
		Page<Share> page = new Page<Share>(query);
		ShareEntityExample example = new ShareEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("shareId DESC");
		page.setTotal(this.shareEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<ShareEntity> list = this.shareEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Share.class));
		}
		
		return page;
	}
    @Override
    public int getShareCountByTargetId(int type, Long targetId) {
        ShareEntityExample example = new ShareEntityExample();
        example.createCriteria()
            .andStatusEqualTo(Status.NORMAL)
            .andTypeEqualTo(type)
            .andTargetIdEqualTo(targetId);
        int cnt = this.shareEntityMapper.countByExample(example);
        return cnt;
    }

    @Override
    public int getShareCountByTarget(int type, String target) {
        ShareEntityExample example = new ShareEntityExample();
        example.createCriteria()
            .andStatusEqualTo(Status.NORMAL)
            .andTypeEqualTo(type)
            .andTargetEqualTo(target);
        int cnt = this.shareEntityMapper.countByExample(example);
        return cnt;
    }
}
