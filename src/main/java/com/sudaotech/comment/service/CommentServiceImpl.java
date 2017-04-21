package com.sudaotech.comment.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.comment.dao.CommentEntity;
import com.sudaotech.comment.dao.CommentEntityExample;
import com.sudaotech.comment.dao.CommentEntityExample.Criteria;
import com.sudaotech.comment.dao.CommentEntityMapper;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.util.BeanUtils;

public class CommentServiceImpl extends BaseServiceImpl implements CommentService {
	private static final String TRACKING_TYPE = "Comment";

    @Inject
    private CommentEntityMapper commentEntityMapper;

	@Override
	public Comment getById(Long commentId) {
		CommentEntity entity = this.commentEntityMapper.selectByPrimaryKey(commentId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Comment.class);
		}
		
		return null;
	}

	@Override
	public Long create(Comment obj) {
		logger.debug("Creating Comment: {}", obj);

		obj.setCommentId(this.getSequenceService().nextLong());
		
		CommentEntity entity = BeanUtils.copyProperties(obj, CommentEntity.class);
		if (entity.getStatus() == null) {
	        entity.setStatus(Status.NORMAL);
		}
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.commentEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getCommentId(), "create", entity);
		
		logger.info("Created Comment: {}", obj);

		return obj.getCommentId();
	}

	@Override
	public void update(Comment obj) {
		logger.debug("Updating Comment: {}", obj);

		CommentEntity entity = BeanUtils.copyProperties(obj, CommentEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.commentEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getCommentId(), "update", entity);

		logger.info("Updated Comment: {}", obj);
	}

	@Override
	public Long save(Comment obj) {
		logger.debug("Saving Comment: {}", obj);

		if (obj.getCommentId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getCommentId();
	}

	@Override
	public List<Comment> list(ListQuery query) {
		CommentEntityExample example = new CommentEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
        if (query.getMinCommentId() != null) {
            criteria.andCommentIdGreaterThanOrEqualTo(query.getMinCommentId());
        }
        if (query.getStartTime() != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(query.getStartTime());
        }
        if (StringUtils.isNotBlank(query.getParent())) {
            criteria.andParentEqualTo(query.getParent());
        }
		example.setOrderByClause("commentId ASC");
		PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
        List<CommentEntity> list = this.commentEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
        return BeanUtils.copyListProperties(list, Comment.class);
	}
    @Override
    public Page<Comment> find(CommentQuery query) {
        Page<Comment> page = new Page<Comment>(query);
        CommentEntityExample example = new CommentEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        if (StringUtils.isNotBlank(query.getParent())) {
            criteria.andParentEqualTo(query.getParent());
        }
        example.setOrderByClause("commentId ASC");
        page.setTotal(this.commentEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
        	PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
            List<CommentEntity> list = this.commentEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, Comment.class));
        }
        
        return page;
    }
}
