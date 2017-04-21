package com.sudaotech.huolijuzhen.task.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.task.dao.TaskExecutorEntity;
import com.sudaotech.huolijuzhen.task.dao.TaskExecutorEntityExample;
import com.sudaotech.huolijuzhen.task.dao.TaskExecutorEntityExample.Criteria;
import com.sudaotech.huolijuzhen.task.dao.LocationTaskExecutorEntityMapper;
import com.sudaotech.util.BeanUtils;

public class TaskExecutorServiceImpl extends BaseServiceImpl implements TaskExecutorService {
	private static final String TRACKING_TYPE = "TaskExecutor";

    @Inject
    private LocationTaskExecutorEntityMapper taskExecutorEntityMapper;

	@Override
	public TaskExecutor getById(Long id) {
		TaskExecutorEntity entity = this.taskExecutorEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, TaskExecutor.class);
		}
		
		return null;
	}

	@Override
	public Long create(TaskExecutor obj) {
		logger.debug("Creating TaskExecutor: {}", obj);
		obj.setId(this.getSequenceService().nextLong());
		TaskExecutorEntity entity = BeanUtils.copyProperties(obj, TaskExecutorEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.taskExecutorEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created TaskExecutor: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(TaskExecutor obj) {
		logger.debug("Updating TaskExecutor: {}", obj);

		TaskExecutorEntity entity = BeanUtils.copyProperties(obj, TaskExecutorEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.taskExecutorEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated TaskExecutor: {}", obj);
	}

	@Override
	public Long save(TaskExecutor obj) {
		logger.debug("Saving TaskExecutor: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<TaskExecutor> find(Query query) {
		Page<TaskExecutor> page = new Page<TaskExecutor>(query);
		TaskExecutorEntityExample example = new TaskExecutorEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.taskExecutorEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TaskExecutorEntity> list = this.taskExecutorEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, TaskExecutor.class));
		}
		
		return page;
	}

	@Override
	public List<Long> findAllTaskByExecutorId(Long userId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("executorId", userId);
		params.put("status", Status.NORMAL.code());
		List<Long> taskIds = this.taskExecutorEntityMapper.findAllTaskByExecutorId(params);
		
		return taskIds;
	}

	@Override
	public List<Long> findAllTaskExecutorByTaskId(Long taskId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskId);
		params.put("status", Status.NORMAL.code());
		List<Long> taskExecutorIds = this.taskExecutorEntityMapper.findAllTaskExecutorByTaskId(params);
		
		return taskExecutorIds;
	}

	@Override
	public List<Long> findAllExecutorByTaskId(Long taskId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskId);
		params.put("status", Status.NORMAL.code());
		List<Long> taskExecutorIds = this.taskExecutorEntityMapper.findAllExecutorByTaskId(params);
		
		return taskExecutorIds;
	}

}
