package com.sudaotech.huolijuzhen.task.web.app.tenement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService.SystemConfig;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlan;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.task.service.TaskExecutorService;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.History;
import com.sudaotech.huolijuzhen.task.service.TaskService.Query;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

@Path("/app/tenement/task")
public class AppTenementTaskResource extends BusinessBaseResource {

    @Inject
    private TaskService taskService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private TaskExecutorService TaskExecutorService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private EquipmentPlanService equipmentPlanService;
    
    @Inject
    private SystemConfigService systemConfigService;
    
    /**
     * 维修申报处理
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final Task obj) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long userId= getSessionQuietly().getUserId();
    		Task task = taskService.getById(id);
    		if(task == null){
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		
    		Task temp = extractValidInfo(obj);
    		temp.setId(id);
    		
    		//维护特殊信息
    		TaskType taskType = task.getTaskType();
    		if(TaskType.COMPANYAPPLY.equals(taskType)){
    			temp.setTaskStatus(TaskStatus.WAITCOMMENT);
    			
    			//2.推送处理消息到创建人
                Message message = new Message();
        		String content = NoticeConstants.Enterprise.Task.TASK_COMMENT;
        		message.setMsgBizType(MsgBizType.APPLY);
                message.setBizId(id);
                message.setMsgType(MsgType.REPAIR_APPLY);
                message.setSrc(userId);
                message.setMsgStatus(MsgStatus.CREATE);
                message.setSourceType(SourceType.SYSTEM_MESSAGE);
                message.setTitle(content);
                message.setContent(content);
                message.setParkId(task.getParkId());
                
                List<Long> dstIds = new ArrayList<Long>();
                dstIds.add(task.getCreateBy());
                
                sendMessageToUser(dstIds,message);
    		}else{
        		temp.setTaskStatus(TaskStatus.FINISH);
        		
        		//维护计划
        		if(TaskType.EQUI.equals(taskType)){
        			Long equPlanId = task.getEquPlanId();
        			
        			EquipmentPlan equPlan = new EquipmentPlan();
        			
        			equPlan.setId(equPlanId);
        			equPlan.setPlanStatus(PlanStatus.FINISH);

        			equipmentPlanService.update(equPlan);
        		}
        		
    		}
    		temp.setOperator(userId);
    		temp.setOperatorTime(new Date());
    		
    		temp.setHistory(task.getHistory());
            temp.setOperator(userId);
            temp.setHistory(task.getHistory());
            
            //保存编辑记录到 history 字段中
            History history = new History();
    		history.setOperatorId(userId);
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		history.setTime(sdf.format(new Date()));
    		
    		AdminUser user = adminUserService.getById(userId);
    		history.setOperatorName(user.getUsername());
    		history.setOperatorType("园区物业处理任务");
    		history.setMemo("");
    		temp = createHistory(temp, history);
    		
            taskService.update(temp);
            
            //3.保存图片信息
        	List<ImageInfo> imageInfoList = temp.getImageInfoList();
        	updateImageInfoPath(imageInfoList);
        	createImageInfo(ImageType.TASK_OPERATOR, id, imageInfoList);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("园区物业处理任务 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 查看维修申报详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            Task obj = taskService.getById(id);
            Map<String, Object> dataMap = new HashedMap<String, Object>();
            if(obj != null){
            	dataMap = packItemInfo(obj);
            }

            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("园区物业根据 ID 查询任务详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 任务查询(已完成)
     * @param query
     * @return
     */
    @GET
    @Path("/finish")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> finish(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum) {
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			
			//1.获取当前登录用户所有的任务 ID
			Long userId = getSessionQuietly().getUserId();
			List<Long> taskIds = TaskExecutorService.findAllTaskByExecutorId(userId);
			if(CollectionUtils.isEmpty(taskIds)){
				Map<String, Object> dataMap = new HashedMap<String, Object>();
	        	dataMap.put("offset", 0);
	        	dataMap.put("limit", 16);
	        	dataMap.put("total", 0);
	        	dataMap.put("items", new ArrayList<Map<String,Object>>());
				return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
			}
			
			//2.
			query.setTaskIds(taskIds);
			query.setTaskStatus("FINISH");
			Page<Task> page = taskService.find(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Task> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Task comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
		    return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("园区 web 按条件查询任务 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 任务查询(待处理)
     * @param query
     * @return
     */
    @GET
    @Path("/pending")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> pengding(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum) {
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			
			//1.获取当前登录用户所有的任务 ID
			Long userId = getSessionQuietly().getUserId();
			List<Long> taskIds = TaskExecutorService.findAllTaskByExecutorId(userId);
			if(CollectionUtils.isEmpty(taskIds)){
				Map<String, Object> dataMap = new HashedMap<String, Object>();
	        	dataMap.put("offset", 0);
	        	dataMap.put("limit", 16);
	        	dataMap.put("total", 0);
	        	dataMap.put("items", new ArrayList<Map<String,Object>>());
				return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
			}
			
			//2.
			query.setTaskIds(taskIds);
			query.setFlag("GL");
			
			//3.获取配置信息
			updateQuery(query);
			
			Page<Task> page = taskService.findByConfig(query);
			//4.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Task> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Task comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
		    return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("园区 web 按条件查询任务 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 任务查询(预警)
     * @param query
     * @return
     */
    @GET
    @Path("/warning")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> warning(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum) {
    	
    	Long userId = getSessionQuietly().getUserId();
    	
    	if(userId == null || userId == 0){
    		return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    	}
    	
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			//1.获取当前登录用户所有的任务 ID
			List<Long> taskIds = TaskExecutorService.findAllTaskByExecutorId(userId);
			if(CollectionUtils.isEmpty(taskIds)){
	        	Map<String, Object> dataMap = new HashedMap<String, Object>();
	        	dataMap.put("offset", 0);
	        	dataMap.put("limit", 16);
	        	dataMap.put("total", 0);
	        	dataMap.put("items", new ArrayList<Map<String,Object>>());
				return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
			}
			
			//2.
			query.setTaskIds(taskIds);
			query.setFlag("LT");
			
			//3 获取配置信息
			updateQuery(query);
			Page<Task> page = taskService.findByConfig(query);
			//4.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Task> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Task comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
		    return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("园区 web 按条件查询任务 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 
     * @param query
     * @return
     */
    private void updateQuery(Query query){
    	
    	Long parkId = getSessionQuietly().getPlatformId();
    	List<SystemConfig> systemConfigList = systemConfigService.getByParkId(parkId);
    	
    	//1.没有想关配置时
    	if(CollectionUtils.isEmpty(systemConfigList)){
    		return ;
    	}
    	
    	//2.获取配置信息
    	//2.1企业申报
    	Date now = new Date();
    	SystemConfig systemConfig = systemConfigList.get(0);
    	EnableStatus companyEnableStatus = systemConfig.getMaintenanceReportSign();
    	if(EnableStatus.ENABLE.equals(companyEnableStatus)){
    		int companyNum = systemConfig.getMaintenanceReportDays();
        	if(companyNum > 0){
        		Calendar calendar = Calendar.getInstance();
        		calendar.setTime(now);
        		calendar.add(Calendar.DAY_OF_MONTH, companyNum*(-1));

        		query.setCompanyCreateTime(calendar.getTime());
        	}
    	}
		
    	//2.2 园区创建
    	EnableStatus parkEnableStatus =  systemConfig.getCreateParkSign();
    	if(EnableStatus.ENABLE.equals(parkEnableStatus)){
    		int parkNum = systemConfig.getCreateParkDays();
        	if(parkNum > 0){
        		Calendar calendar = Calendar.getInstance();
        		calendar.setTime(now);
        		calendar.add(Calendar.DAY_OF_MONTH, parkNum*(-1));
        		
        		query.setParkCreateTime(calendar.getTime());
        	}
    	}
    	//2.3维护计划生成
    	EnableStatus equEnableStatus = systemConfig.getEquipmentMaintainSign();
    	if(EnableStatus.ENABLE.equals(equEnableStatus)){
    		int equNum = systemConfig.getEquipmentMaintainDays();
        	if(equNum > 0){
        		Calendar calendar = Calendar.getInstance();
        		calendar.setTime(now);
        		calendar.add(Calendar.DAY_OF_MONTH, equNum*(-1));
        		
        		query.setEquiCreateTime(calendar.getTime());
        	}
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Task extractValidInfo(Task temp){
    	Task obj = new Task();

    	obj.setHasCost(temp.getHasCost());
    	obj.setPayWay(temp.getPayWay());
    	obj.setTaskCost(temp.getTaskCost());
    	obj.setOperatorMemo(temp.getOperatorMemo());
    	obj.setEquTypeId(temp.getEquTypeId());
    	obj.setImageInfoList(temp.getImageInfoList());
    	
    	return obj;
    }
    
    /**
     * 添加任务的操作记录
     * @param task
     * @param history
     * @return
     */
    private Task createHistory(Task task,History history){
    	
    	Gson gson = new Gson();
		List<History> list = new ArrayList<History>();
		String historyString = task.getHistory();
		if(StringUtils.isNotBlank(historyString)){
			list = gson.fromJson(historyString, new TypeToken<List<History>>(){}.getType());
		}
		list.add(history);
		String str = gson.toJson(list);
		task.setHistory(str);
		
		return task;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Task item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	infoMap.put("description", notNull(item.getDescription()));
    	infoMap.put("taskType", notNull(item.getTaskType()));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	infoMap.put("createTime", sdf.format(item.getCreateTime()));
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Task item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	//重用列表信息
    	infoMap.putAll(packListInfo(item));
    	
    	//获取特殊信息
    	TaskType taskType = item.getTaskType();
    	infoMap.put("taskType", notNull(taskType));
    	
    	//当为企业维修申报时
		Long companyId = item.getEquPlanId();
		EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(companyId);
		if(enterpriseInfo != null){
			infoMap.put("enterpriseName", notNull(enterpriseInfo.getName()));
		}else{
			infoMap.put("enterpriseName", "");
		}
		
		//企业申报主图
		List<ImageInfo> taskImgUri = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_LOCALE, item.getId());
		infoMap.put("taskImageUri", new ArrayList<Map<String, Object>>());
		if(CollectionUtils.isNotEmpty(taskImgUri)){
			infoMap.put("taskImageUri", imageInfoListToMap(taskImgUri));
		}
		
		//评论内容
		Boolean isComment = item.getIsComment();
		infoMap.put("isComment", isComment);
		infoMap.put("commentGrade", notNull(item.getCommentGrade()));
		infoMap.put("commentContent", notNull(item.getCommentContent()));
		
		infoMap.put("hasCost", notNull(item.getHasCost()));
		infoMap.put("costIsVerify", notNull(item.getCostIsVerify()));
		infoMap.put("payWay", notNull(item.getPayWay()));
   		infoMap.put("taskCost",notNull(item.getTaskCost()));
    	
    	TaskStatus taskStatus = item.getTaskStatus();
    	infoMap.put("taskStatus", taskStatus);
		infoMap.put("operatorBy", -1L);
		infoMap.put("operatorTime", "");
		infoMap.put("operatorMemo", "");
		infoMap.put("operatorImage", new ArrayList<Map<String, Object>>());
		infoMap.put("equTypeId", -1L);
		
    	if(TaskStatus.FINISH.equals(taskStatus) || TaskStatus.WAITCOMMENT.equals(taskStatus)){
    		infoMap.put("operatorBy", notNull(item.getOperator()));
    		infoMap.put("operatorTime", sdf.format(item.getOperatorTime()));
    		infoMap.put("operatorMemo", notNull(item.getOperatorMemo()));
    		infoMap.put("equTypeId", notNull(item.getEquTypeId()));
    		
    		List<ImageInfo> operatorImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_OPERATOR, item.getId());
    		if(CollectionUtils.isNotEmpty(operatorImageInfos)){
    			infoMap.put("operatorImage", imageInfoListToMap(operatorImageInfos));
    		}
    	}
    	
    	Boolean isAdjust = item.getIsAdjust();
    	if(isAdjust){
    		infoMap.put("taskArriveTime", sdf.format(item.getAdjustTime()));
    	}
    	else if(TaskStatus.WAITALLOT.equals(taskStatus)){
			infoMap.put("taskArriveTime", "");
		}else{
			infoMap.put("taskArriveTime", sdf.format(item.getAllTime()));
		}
    	
    	return infoMap;
    }
}
