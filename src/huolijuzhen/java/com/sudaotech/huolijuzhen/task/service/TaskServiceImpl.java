package com.sudaotech.huolijuzhen.task.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.task.dao.LocationTaskEntityMapper;
import com.sudaotech.huolijuzhen.task.dao.TaskEntity;
import com.sudaotech.huolijuzhen.task.dao.TaskEntityExample;
import com.sudaotech.huolijuzhen.task.dao.TaskEntityExample.Criteria;
import com.sudaotech.util.BeanUtils;

public class TaskServiceImpl extends BaseServiceImpl implements TaskService {
	private static final String TRACKING_TYPE = "Task";

    @Inject
    private LocationTaskEntityMapper taskEntityMapper;

	@Override
	public Task getById(Long id) {
		TaskEntity entity = this.taskEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Task.class);
		}
		
		return null;
	}

	@Override
	public Long create(Task obj) {
		logger.debug("Creating Task: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		TaskEntity entity = BeanUtils.copyProperties(obj, TaskEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.taskEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Task: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Task obj) {
		logger.debug("Updating Task: {}", obj);

		TaskEntity entity = BeanUtils.copyProperties(obj, TaskEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.taskEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Task: {}", obj);
	}

	@Override
	public Long save(Task obj) {
		logger.debug("Saving Task: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Task> find(Query query){
		Page<Task> page = new Page<Task>(query);
		TaskEntityExample example = new TaskEntityExample();
		Criteria criteria = example.createCriteria();
		
		List<Long> taskIds = query.getTaskIds();
		if(CollectionUtils.isNotEmpty(taskIds)){
			criteria.andIdIn(taskIds);
		}
		
		String taskStatusStr = query.getTaskStatus();
		if(StringUtils.isNotBlank(taskStatusStr)){
			TaskStatus taskStatus = TaskStatus.valueOf(taskStatusStr);
			
			if(TaskStatus.FINISH.equals(taskStatus)){
				List<TaskStatus> taskStatusList = new ArrayList<TaskStatus>();
				taskStatusList.add(TaskStatus.WAITCOMMENT);
				taskStatusList.add(TaskStatus.FINISH);
				taskStatusList.add(TaskStatus.ISCLOSE);
				
				criteria.andTaskStatusIn(taskStatusList);
			}else{
				criteria.andTaskStatusEqualTo(taskStatus);
			}
		}
		
		Date createTime = query.getCreateTime();
		if(createTime != null){
			String flag = query.getFlag();
			if("GL".equals(flag)){
				criteria.andCreateTimeGreaterThan(createTime);
			}else{
				criteria.andCreateTimeLessThan(createTime);
			}
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("updateTime DESC");
		page.setTotal(this.taskEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TaskEntity> list = this.taskEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Task.class));
		}
		
		return page;
	}
	@Override
	public Page<Task> findByConfig(Query query){
		Page<Task> page = new Page<Task>(query);
		
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		page.setSortField("createTime");
		page.setSortOrder("DESC");
		
		Integer total = this.taskEntityMapper.findByConfigCount(query);
		page.setTotal(0);
		if(total != null){
			page.setTotal(total);
		}
		
		List<Task> items = this.taskEntityMapper.findByConfig(query);
		if(CollectionUtils.isNotEmpty(items)){
			page.setItems(items);
		}
		return page;
	}
	
	/**
	 * 根据条件分页检索
	 */
	@Override
	public Page<Task> findByCondition(Query query) {
		Page<Task> page = new Page<Task>(query);
		TaskEntityExample example = new TaskEntityExample();
		Criteria criteria = example.createCriteria();
		
		//查询指定园区
		criteria.andParkIdEqualTo(query.getParkId());
		
		//1.编码
		String code = query.getCode();
		if(StringUtils.isNotBlank(code)){
			criteria.andCodeLike("%" + code + "%");
		}
		//2.申请人
		String createName = query.getApplyName();
		if(StringUtils.isNotBlank(createName)){
			criteria.andCreateNameLike("%" + createName + "%");
		}
		//3.执行人
		String executorName = query.getExecutorName();
		if(StringUtils.isNotBlank(executorName)){
			criteria.andExecutorNotLike("%" + executorName + "%");
		}
		//4.任务类型
		String taskType = query.getTaskType();
		if(StringUtils.isNotBlank(taskType)){
			criteria.andTaskTypeEqualTo(TaskType.valueOf(taskType));
		}
		//5.任务状态
		String taskStatus = query.getTaskStatus();
		if(StringUtils.isNotBlank(taskStatus)){
			criteria.andTaskStatusEqualTo(TaskStatus.valueOf(taskStatus));
		}
		//6.设备类型
		Long equTypeId = query.getEquTypeId();
		if(equTypeId != null){
			criteria.andEquTypeIdEqualTo(equTypeId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.taskEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TaskEntity> list = this.taskEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Task.class));
		}
		
		return page;
	}
	
	

	/**
	 * 根据计划 ID 删除所有任务
	 */
	@Override
	public void removeByEquPlanIds(List<Long> ids) {
		
//		if(CollectionUtils.isNotEmpty(ids)){
//			for(Long id:ids){
//				
//				
//			}
//		}
		
		
	}

	@Override
	public Page<Task> findHistoryByCondition(Query query) {
		Page<Task> page = new Page<Task>(query);
		TaskEntityExample example = new TaskEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long companyId = query.getCompanyId();
		if(companyId != null){
			criteria.andEquPlanIdEqualTo(companyId);
			criteria.andTaskTypeEqualTo(TaskType.COMPANYAPPLY);
		}
		
		Long parkId = query.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		String taskStatuStr = query.getTaskStatus();
		if(StringUtils.isNotBlank(taskStatuStr)){
			TaskStatus taskStatus = TaskStatus.valueOf(taskStatuStr);
			criteria.andTaskStatusEqualTo(taskStatus);
		}
		
		String description = query.getDescription();
		if(StringUtils.isNotBlank(description)){
			criteria.andDescriptionLike("%" + description + "%");
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.taskEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TaskEntity> list = this.taskEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Task.class));
		}
		
		return page;
	}

	@Override
	public List<Map<String, Object>> findByEquPlanIds(List<Long> equPlanIds) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("equPlanIds", equPlanIds);
		params.put("taskType", TaskType.EQUI.code());
		params.put("status", Status.NORMAL.code());
		List<Map<String, Object>> taskList = taskEntityMapper.findTaskByEquPlanIds(params);
		
		return taskList;
	}

	@Override
	public List<Map<String, Object>> statisticsTask(
			Map<String, Object> paramsMap) {
		
		List<Map<String, Object>> results = this.taskEntityMapper.statisticsTask(paramsMap);
		String type = (String)paramsMap.get("type");
		if(CollectionUtils.isNotEmpty(results) && "TASKTYPE".equals(type)){
			for(Map<String, Object> item:results){
				Integer taskType = (Integer)item.get("name");
				item.put("name", TaskType.codeOf(taskType));
			}
		}
		return results;
	}

	@Override
	public List<Task> findByObj(Task task) {
		TaskEntityExample example = new TaskEntityExample();
		Criteria criteria = example.createCriteria();
		
		TaskType taskType = task.getTaskType();
		if(taskType != null){
			criteria.andTaskTypeEqualTo(taskType);
		}
		
		Integer isChoose = task.getIsChoose();
		if(isChoose != null){
			criteria.andIsChooseEqualTo(isChoose);
		}
		
		Boolean hasCost = task.getHasCost();
		if(hasCost != null && hasCost){
			criteria.andHasCostEqualTo(hasCost);
		}
		
		Long enterpriseId = task.getEquPlanId();
		if(enterpriseId != null){
			criteria.andEquPlanIdEqualTo(enterpriseId);
		}

		Boolean costIsVerify = task.getCostIsVerify();
		if(costIsVerify != null && costIsVerify){
			criteria.andCostIsVerifyEqualTo(costIsVerify);
		}
		
		PayWay payWay = task.getPayWay();
		if(payWay != null){
			criteria.andPayWayEqualTo(payWay);
		}
		
		if(task.getBillId() != null){
			criteria.andBillIdEqualTo(task.getBillId());
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.taskEntityMapper.selectByExample(example), Task.class);
	}
}
