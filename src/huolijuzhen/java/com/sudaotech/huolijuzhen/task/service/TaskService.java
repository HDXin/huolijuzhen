package com.sudaotech.huolijuzhen.task.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enums.CommentGrade;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.task.dao.TaskEntity;

public interface TaskService extends BaseService {

    public Task getById(Long id);

    public Long create(Task obj);

    public void update(Task obj);

    public Long save(Task obj);

    public Page<Task> find(Query query);
    
    public Page<Task> findByConfig(Query query);
    
    public Page<Task> findByCondition(Query query);
    
    public List<Map<String, Object>> findByEquPlanIds(List<Long> equPlanIds);
    
    public Page<Task> findHistoryByCondition(Query query);
    
    public List<Map<String, Object>> statisticsTask(Map<String, Object> paramsMap);
    
    public List<Task> findByObj(Task task);
    
    //根据计划 ID 删除所有任务
    public void removeByEquPlanIds(List<Long> ids);
    
    public static class Query extends Pagination {
    	//编码
    	private String code;
    	//申请人
    	private String applyName;
    	//执行人
    	private String executorName;
    	//任务类型
    	private String taskType;
    	//任务状态
    	private String taskStatus;
    	//设备类型
    	private Long equTypeId;
    	//所属园区
    	private Long parkId;
    	//描述
    	private String description;
    	
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getApplyName() {
			return applyName;
		}
		public void setApplyName(String applyName) {
			this.applyName = applyName;
		}
		public String getExecutorName() {
			return executorName;
		}
		public void setExecutorName(String executorName) {
			this.executorName = executorName;
		}
		public String getTaskType() {
			return taskType;
		}
		public void setTaskType(String taskType) {
			this.taskType = taskType;
		}
		public String getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		public Long getEquTypeId() {
			return equTypeId;
		}
		public void setEquTypeId(Long equTypeId) {
			this.equTypeId = equTypeId;
		}
		
		private Long companyId;

		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		//园区物业管理使用
		private List<Long> taskIds;
		private Date createTime;
		//企业申报
		private Date companyCreateTime;
		//园区创建
		private Date parkCreateTime;
		//设备计划
		private Date equiCreateTime;
		//大于:GL 小于:LT
		private String flag;
		
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public List<Long> getTaskIds() {
			return taskIds;
		}
		public void setTaskIds(List<Long> taskIds) {
			this.taskIds = taskIds;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public Date getCompanyCreateTime() {
			return companyCreateTime;
		}
		public void setCompanyCreateTime(Date companyCreateTime) {
			this.companyCreateTime = companyCreateTime;
		}
		public Date getParkCreateTime() {
			return parkCreateTime;
		}
		public void setParkCreateTime(Date parkCreateTime) {
			this.parkCreateTime = parkCreateTime;
		}
		public Date getEquiCreateTime() {
			return equiCreateTime;
		}
		public void setEquiCreateTime(Date equiCreateTime) {
			this.equiCreateTime = equiCreateTime;
		}
    }
    
    public static class Task extends TaskEntity {
    	
    	//任务ID(用于批量操作)
    	private List<Long> ids = new ArrayList<Long>();
    	//执行人
    	private List<Long> executorIds = new ArrayList<Long>();
		public List<Long> getExecutorIds() {
			return executorIds;
		}
		public void setExecutorIds(List<Long> executorIds) {
			this.executorIds = executorIds;
		}
		public List<Long> getIds() {
			return ids;
		}
		public void setIds(List<Long> ids) {
			this.ids = ids;
		}

		//维修申报处理
		private List<ImageInfo> imageInfoList;
		public List<ImageInfo> getImageInfoList() {
			return imageInfoList;
		}
		public void setImageInfoList(List<ImageInfo> imageInfoList) {
			this.imageInfoList = imageInfoList;
		}
		
		//IOS 特殊处理
		private String tempHasCost;
		private String tempTaskCost;
		public String getTempHasCost() {
			return tempHasCost;
		}
		public void setTempHasCost(String tempHasCost) {
			this.tempHasCost = tempHasCost;
			if(StringUtils.isNotBlank(tempHasCost)){
				if("true".equals(tempHasCost)){
					setHasCost(true);
				}else{
					setHasCost(false);
				}
			}
		}
		public String getTempTaskCost() {
			return tempTaskCost;
		}
		public void setTempTaskCost(String tempTaskCost) {
			this.tempTaskCost = tempTaskCost;
			if(StringUtils.isNotBlank(tempTaskCost)){
				BigDecimal taskCost = new BigDecimal(tempTaskCost);
				setTaskCost(taskCost);
			}
		}
    }
    
    public static class ApplyItem{
    	private Long parkId;
    	private String description;
    	private List<ImageInfo> imageInfoList = new ArrayList<ImageInfo>();
    	private String title;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<ImageInfo> getImageInfoList() {
			return imageInfoList;
		}
		public void setImageInfoList(List<ImageInfo> imageInfoList) {
			this.imageInfoList = imageInfoList;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
    	
    }
    
    public static class AllotItem{
    	//计划的 ID
		private List<Long> equiPlanIds;
    	
		//执行人
		private List<Long> excutors;
		public List<Long> getEquiPlanIds() {
			return equiPlanIds;
		}
		public void setEquiPlanIds(List<Long> equiPlanIds) {
			this.equiPlanIds = equiPlanIds;
		}
		public List<Long> getExcutors() {
			return excutors;
		}
		public void setExcutors(List<Long> excutors) {
			this.excutors = excutors;
		}
    }

    public class Executor{
    	private Long id;
    	private String name;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    	
    }
    
    public class History{
    	private Long operatorId;
    	private String operatorName;
    	private String operatorType;
    	private String time;
    	private String memo;
		
		public Long getOperatorId() {
			return operatorId;
		}
		public void setOperatorId(Long operatorId) {
			this.operatorId = operatorId;
		}
		public String getOperatorName() {
			return operatorName;
		}
		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}
		public String getOperatorType() {
			return operatorType;
		}
		public void setOperatorType(String operatorType) {
			this.operatorType = operatorType;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
    	
    }
    
    public static class CommentItem{
    	private Long id;
    	private CommentGrade commentGrade;
    	private String commentContent;
    	private List<ImageInfo> commentImageList = new ArrayList<ImageInfo>();
    	
		public CommentGrade getCommentGrade() {
			return commentGrade;
		}
		public void setCommentGrade(CommentGrade commentGrade) {
			this.commentGrade = commentGrade;
		}
		public String getCommentContent() {
			return commentContent;
		}
		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}
		public List<ImageInfo> getCommentImageList() {
			return commentImageList;
		}
		public void setCommentImageList(List<ImageInfo> commentImageList) {
			this.commentImageList = commentImageList;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
    }

	
	
}
