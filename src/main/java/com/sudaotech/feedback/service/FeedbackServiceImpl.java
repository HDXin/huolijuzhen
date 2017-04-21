package com.sudaotech.feedback.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.feedback.FeedbackStatus;
import com.sudaotech.feedback.dao.FeedbackEntity;
import com.sudaotech.feedback.dao.FeedbackEntityExample;
import com.sudaotech.feedback.dao.FeedbackEntityExample.Criteria;
import com.sudaotech.feedback.dao.FeedbackEntityMapper;
import com.sudaotech.util.BeanUtils;

public class FeedbackServiceImpl extends BaseServiceImpl implements FeedbackService {
	private static final String TRACKING_TYPE = "Feedback";

    @Inject
    private FeedbackEntityMapper feedbackEntityMapper;

	@Override
	public Feedback getById(Long feedbackId) {
		FeedbackEntity entity = this.feedbackEntityMapper.selectByPrimaryKey(feedbackId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Feedback.class);
		}
		
		return null;
	}

	@Override
	public Long create(Feedback obj) {
		logger.debug("Creating Feedback: {}", obj);

		obj.setFeedbackId(this.getSequenceService().nextLong());
		
		FeedbackEntity entity = BeanUtils.copyProperties(obj, FeedbackEntity.class);
		
		// 默认状态设置为：未处理
		entity.setFeedbackStatus(FeedbackStatus.UNPROCESSED);
		
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.feedbackEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getFeedbackId(), "create", entity);
		
		logger.info("Created Feedback: {}", obj);

		return obj.getFeedbackId();
	}

	@Override
	public void update(Feedback obj) {
		logger.debug("Updating Feedback: {}", obj);

		FeedbackEntity entity = BeanUtils.copyProperties(obj, FeedbackEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.feedbackEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getFeedbackId(), "update", entity);

		logger.info("Updated Feedback: {}", obj);
	}

	@Override
	public Long save(Feedback obj) {
		logger.debug("Saving Feedback: {}", obj);

		if (obj.getFeedbackId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getFeedbackId();
	}

	@Override
	public Page<Feedback> find(Query query) {
		Page<Feedback> page = new Page<Feedback>(query);
		FeedbackEntityExample example = new FeedbackEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
        if (query.getBeginTime() != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(query.getBeginTime());
        }
        if (query.getEndTime() != null) {
            criteria.andCreateTimeLessThanOrEqualTo(query.getEndTime());
        }
		
		example.setOrderByClause("feedbackId DESC");
		page.setTotal(this.feedbackEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<FeedbackEntity> list = this.feedbackEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Feedback.class));
		}
		
		return page;
	}
}
