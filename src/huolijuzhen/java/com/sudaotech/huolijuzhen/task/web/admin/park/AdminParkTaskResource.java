package com.sudaotech.huolijuzhen.task.web.admin.park;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.CommentGrade;
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
import com.sudaotech.huolijuzhen.task.service.TaskExecutorService.TaskExecutor;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.AllotItem;
import com.sudaotech.huolijuzhen.task.service.TaskService.History;
import com.sudaotech.huolijuzhen.task.service.TaskService.Query;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/task")
public class AdminParkTaskResource extends BusinessBaseResource {

    @Inject
    private TaskService taskService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private EquipmentPlanService equipmentPlanService;
    
    @Inject
    private TaskExecutorService taskExecutorService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    /**
     * 添加任务
     * 
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(
    		@Valid final Task obj) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}

    		Long parkId = session.getPlatformId();
            // create
    		Task temp = extractValidInfo(obj);
    		temp.setParkId(parkId);
    		temp.setOperator(getSessionQuietly().getUserId());
    		temp.setIsAdjust(false);
    		temp.setIsComment(false);
    		temp.setCommentGrade(CommentGrade.UNKNOWN);
    		
    		//保存创建记录到 history 字段
    		History history = new History();
    		history.setOperatorId(getSessionQuietly().getUserId());
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		history.setTime(sdf.format(new Date()));
    		
    		Long userId = getSessionQuietly().getUserId();
    		AdminUser adminUser = adminUserService.getById(userId);
    		
    		history.setOperatorName(adminUser.getUsername());
    		history.setOperatorType("创建");
    		history.setMemo("");
    		temp = createHistory(temp, history);
    		
    		temp.setCode(createTaskNo());
            Long id = taskService.create(temp);
            
            //维护任务与执行人之间的关系
            List<Long> executorIds = temp.getExecutorIds();
            if(CollectionUtils.isNotEmpty(executorIds)){
            	createTaskToExecutor(id,temp.getExecutorIds());

            	//2.给任务执行人发送消息
            	String content = NoticeConstants.Park.Task.TASK_ARRIVE;
        		temp.setId(id);
        		sendMessageToUser(temp,content,executorIds);
            }
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/task/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("园区创建任务 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 通过维修计划生产维修任务
     * @param query
     * @return
     */
    @POST
    @Path("/allotTask")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> allotTask(
            @Valid final AllotItem allotItem) {
		try{
			Session session = getSessionQuietly();
			Long userId = session.getUserId();
			Long parkId = session.getPlatformId();
			//1.在任务表中添加任务
			List<Long> executorIds = allotItem.getExcutors();

			//2.更新计划的状态为已生成任务,并生产任务
			List<Long> equiPlanIds = allotItem.getEquiPlanIds();
			if(CollectionUtils.isNotEmpty(equiPlanIds)){
				for(Long equipPlanId:equiPlanIds){
					EquipmentPlan equipmentPlan = equipmentPlanService.getById(equipPlanId);
					
					//2.1、更改计划状态为已生成任务
					EquipmentPlan obj = new EquipmentPlan();
					obj.setId(equipmentPlan.getId());
					obj.setPlanStatus(PlanStatus.WAITEXECUTOR);
					obj.setAssignerId(userId);
					obj.setAssignerTime(new Date());
					equipmentPlanService.update(obj);
					
					//2.2、创建计划对应的任务信息
					Task temp = new Task();
					temp.setEquPlanId(equipPlanId);
			    	temp.setTitle(equipmentPlan.getEquName());
			    	temp.setDescription(equipmentPlan.getDescription());
			    	if(CollectionUtils.isEmpty(executorIds)){
			    		temp.setTaskStatus(TaskStatus.WAITALLOT);
			    	}else{
			    		temp.setTaskStatus(TaskStatus.WAITEXECUTOR);
			    		temp.setAllBy(getSessionQuietly().getUserId());
			    		temp.setAllTime(new Date());
			    	}
		    		
		    		temp.setOperator(userId);
		    		temp.setIsAdjust(false);
		    		temp.setTaskType(TaskType.EQUI);
		    		temp.setEquId(equipmentPlan.getEquId());
		    		temp.setEquTypeId(equipmentPlan.getEquTypeId()); 
		    		temp.setEnableStatus(EnableStatus.ENABLE);
		    		temp.setParkId(parkId);
		    		temp.setIsComment(false);
		    		temp.setCommentGrade(CommentGrade.UNKNOWN);
		    		
		    		//保存创建记录到 history 字段
		    		History history = new History();
		    		history.setOperatorId(getSessionQuietly().getUserId());
		    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    		history.setTime(sdf.format(new Date()));
		    		
		    		AdminUser adminUser = adminUserService.getById(userId);
		    		history.setOperatorName(adminUser.getUsername());
		    		history.setOperatorType("创建");
		    		history.setMemo("");
		    		temp = createHistory(temp, history);
		    		
		    		temp.setCode(createTaskNo());
		            Long id = taskService.create(temp);
		            
		            //3.创建任务与执行人的关系
		            createTaskToExecutor(id, executorIds);
		            
	            	//4.给任务执行人发送消息
		            if(CollectionUtils.isNotEmpty(executorIds)){
		            	String content = NoticeConstants.Park.Task.TASK_ARRIVE;
		        		temp.setId(id);
		        		sendMessageToUser(temp,content,executorIds);
		            }

				}
			}
	        return new Result<Map<String,Object>>(ResultCode.OK);	
		}catch(Exception e){
			logger.error("通过维修计划生产维修任务 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}

	}

    /**
     * 创建任务与执行人的关系
     * @param taskIds
     * @param executorIds
     */
    private void createTaskToExecutor(Long taskId,List<Long> executorIds)throws Exception{
    	
    	if(CollectionUtils.isNotEmpty(executorIds)){
    		//1.维护任务与执行人之间的关系	
			for(Long executorId:executorIds){
					TaskExecutor taskExecutor = new TaskExecutor();
					
					taskExecutor.setTaskId(taskId);
					taskExecutor.setExecutorId(executorId);
					
					taskExecutor.setOperator(getSessionQuietly().getUserId());
					taskExecutor.setStatus(Status.NORMAL);
					
					taskExecutorService.create(taskExecutor);
			}
    	}
    }
    
    /**
     * 删除任务与执行人之间的关系
     * @param taskId
     * @throws Exception
     */
    private void deleteTaskToExecutor(Long taskId)throws Exception{
    	List<Long> taskExecutorIds = taskExecutorService.findAllTaskExecutorByTaskId(taskId);
		if(CollectionUtils.isNotEmpty(taskExecutorIds)){
			TaskExecutor taskExecutor = null;
			for(Long taskExecutorId:taskExecutorIds){
				taskExecutor = new TaskExecutor();
				taskExecutor.setId(taskExecutorId);
				taskExecutor.setStatus(Status.DELETED);
				taskExecutor.setOperator(getSessionQuietly().getUserId());
				
    			taskExecutorService.update(taskExecutor);
			}
		}
    }
    
    /**
     * 推送消息到执行人
     * @param userIds
     * @param item
     */
    private void sendMessageToUser(Task task,String content,List<Long> excutors){
        
        //发送异步消息到消息中间件
    	Message message = new Message();
		Task tempTask = taskService.getById(task.getId());
        message.setBizId(tempTask.getId());
        message.setMsgBizType(MsgBizType.TASK);
        message.setMsgType(MsgType.REPAIR_APPLY);
        message.setSrc(getSessionQuietly().getUserId());
        message.setMsgStatus(MsgStatus.CREATE);
        message.setSourceType(SourceType.SYSTEM_MESSAGE);
        message.setTitle(content);
        message.setContent(content);
        message.setToPark(true);
        message.setParkId(-1L);
        sendMessageToUser(excutors,message);
    }
    
    /**
     * 编辑任务
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
    		//1.获取指定任务
    		Task task = taskService.getById(id);
    		if(task == null){
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		//2.取消所有的执行人关系
    		deleteTaskToExecutor(task.getId());;
    		
    		//3.保存任务信息
    		Task temp = extractValidInfo(obj);
    		temp.setId(id);
    		temp.setHistory(task.getHistory());
            temp.setOperator(getSessionQuietly().getUserId());
            temp.setHistory(task.getHistory());
            
            //保存编辑记录到 history 字段中
            History history = new History();
    		history.setOperatorId(getSessionQuietly().getUserId());
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		history.setTime(sdf.format(new Date()));
    		history.setOperatorName("Jerry");
    		history.setOperatorType("编辑");
    		history.setMemo("");
    		temp = createHistory(temp, history);
            taskService.update(temp);
            
            //4.维护执行人关系
            List<Long> executorIds = temp.getExecutorIds();
            createTaskToExecutor(task.getId(), executorIds);
            
        	//5.给任务执行人发送消息
            if(CollectionUtils.isNotEmpty(executorIds)){
            	String content = NoticeConstants.Park.Task.TASK_ARRIVE;
        		sendMessageToUser(temp,content,executorIds);
            }
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("园区添加任务 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 分配任务
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/allot")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> allot(
           @Valid final Task obj) {
    	try{
    		Long userId = getSessionQuietly().getUserId();
    		AdminUser adminUser = adminUserService.getById(userId);
    		
    		List<Long> ids = obj.getIds();
    		List<Long> executorIds = obj.getExecutorIds();
    		
    		if(CollectionUtils.isEmpty(executorIds)){
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		
    		Task task = null;
    		Task temp = null;
    		for(Long id:ids){
    			task = taskService.getById(id);
    			if(task == null){
    				continue;
    			}
    			temp = new Task();
    			temp.setId(task.getId());
    			temp.setTaskStatus(TaskStatus.WAITEXECUTOR);
    			temp.setOperator(userId);
    			temp.setAllBy(userId);
    			temp.setAllTime(new Date());
    			temp.setHistory(task.getHistory());
    			
    			//保存分配记录到 history 字段
    			History history = new History();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		history.setTime(sdf.format(new Date()));
        		
        		history.setOperatorId(userId);
        		history.setOperatorName(adminUser.getUsername());
        		history.setOperatorType("分配任务");
        		history.setMemo("");
        		temp = createHistory(temp, history);
        		
    			taskService.update(temp);
    			
    			//删除任务与执行人关系
    			deleteTaskToExecutor(temp.getId());
    			
    			//重新建立任务与执行人关系
    			createTaskToExecutor(task.getId(), executorIds);    

    			 //2.当执行人不为空,推送消息
                if(CollectionUtils.isNotEmpty(executorIds)){
                	String content = NoticeConstants.Park.Task.TASK_ARRIVE;
            		sendMessageToUser(task, content, executorIds);
                }
    		}
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("分配任务 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 调整任务
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/adjust")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> adjust(@Valid final Task obj) {
    	try{
    		Long userId = getSessionQuietly().getUserId();
    		AdminUser adminUser = adminUserService.getById(userId);
    		
    		List<Long> ids = obj.getIds();
    		if(CollectionUtils.isEmpty(ids)){
    			return new Result<String>(ResultCode.BAD_REQUEST,"请选择任务！");
    		}
    		List<Long> executorIds = obj.getExecutorIds();
    		if(CollectionUtils.isEmpty(executorIds)){
    			return new Result<String>(ResultCode.BAD_REQUEST,"请选择执行人");
    		}
    		Task task = null;
    		Task temp = null;
    		for(Long id:ids){
    			task = taskService.getById(id);
    			if(task == null){
    				continue;
    			}
    			temp = new Task();
    			
    			temp.setId(task.getId());
    			temp.setIsAdjust(true);
    			
    			temp.setAdjustBy(userId);
    			temp.setAdjustTime(new Date());
    			temp.setOperator(userId);
    			temp.setHistory(task.getHistory());
    			
    			//保存调整记录到 adjustMemo
    			History history = new History();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		history.setTime(sdf.format(new Date()));
        		history.setOperatorId(userId);
        		history.setOperatorName(adminUser.getUsername());
        		history.setOperatorType("调整任务");
        		history.setMemo("");
        		temp = createHistory(temp, history);
    			
    			taskService.update(temp);

    			//删除任务与执行人关系
    			deleteTaskToExecutor(temp.getId());
    			
    			//重新建立任务与执行人关系
    			createTaskToExecutor(task.getId(), executorIds);  
    			
    			//发送消息给任务执行人
                if(CollectionUtils.isNotEmpty(executorIds)){
                	String content = NoticeConstants.Park.Task.TASK_ARRIVE;
                	sendMessageToUser(temp,content,executorIds);
                }
    			
    		}
    		
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("调整任务 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 关闭任务
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/close/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> close(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		Long userId = getSessionQuietly().getUserId();
    		AdminUser adminUser = adminUserService.getById(userId);
    		
    		Task task = taskService.getById(id);
    		if(task == null){
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		
    		Task temp = new Task();
    		temp.setId(task.getId());
    		temp.setTaskStatus(TaskStatus.ISCLOSE);
    		temp.setCloseBy(userId);
    		temp.setCloseTime(new Date());
    		temp.setHistory(task.getHistory());
    		
    		//保存关闭记录到 history 字段中
    		History history = new History();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		history.setTime(sdf.format(new Date()));
    		history.setOperatorId(userId);
    		history.setOperatorName(adminUser.getUsername());
    		history.setOperatorType("关闭任务");
    		history.setMemo("");
    		temp = createHistory(temp, history);
    		
    		taskService.update(temp);
    		
    		//发送消息给任务执行人
    		List<Long> taskExecutorIds = taskExecutorService.findAllTaskExecutorByTaskId(id);
    		if(CollectionUtils.isNotEmpty(taskExecutorIds)){
        		String content = NoticeConstants.Park.Task.TASK_CLOSE;
        		sendMessageToUser(temp,content,taskExecutorIds);
            }
    		
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("关闭任务 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 查查操作日志
     * @param id
     * @return
     */
    @GET
    @Path("/operatorLog/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String, Object>>> operatorLog(@NotNull @PathParam("id") final Long id) {
    	try{
            Task obj = taskService.getById(id);
            List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
            if(obj != null){
            	String historyStr = obj.getHistory();
            	Gson gson = new Gson();
            	List<History> list = gson.fromJson(historyStr, new TypeToken<List<History>>(){}.getType());
            	Map<String,Object> dataMap = null;
            	for(History item:list){
            		dataMap = new HashedMap<String, Object>();
            		dataMap.put("operatroId", item.getOperatorId());
            		dataMap.put("operatorName", item.getOperatorName());
            		dataMap.put("operatorType", item.getOperatorType());
            		dataMap.put("time", item.getTime());
            		dataMap.put("memo", item.getMemo());
            		
            		dataList.add(dataMap);
            	}
            }

            return new Result<List<Map<String,Object>>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataList);
    	}catch(Exception e){
    		logger.error("根据 ID 查询任务详情 error:{}",e);
    		return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 查看任务详情
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
    		logger.error("根据 ID 查询任务详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按条件查询任务
     * @param query
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
    		@QueryParam("code") String code,
            @QueryParam("applyName") String applyName,
            @QueryParam("executorName") String executorName,
            @QueryParam("taskType") String taskType,
            @QueryParam("taskStatus") String taskStatus,
            @QueryParam("equTypeId") Long equTypeId) {
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setCode(code);
			query.setApplyName(applyName);
			query.setExecutorName(executorName);
			query.setTaskType(taskType);
			query.setTaskStatus(taskStatus);
			query.setEquTypeId(equTypeId);
			
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			
			Long parkId = session.getPlatformId();
			query.setParkId(parkId);

			Page<Task> page = taskService.findByCondition(query);
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
     * 按条件查询任务并將結果集导出到 Excel 中
     * @param query
     * @return
     */
    @GET
    @Path("/excel")
    @Produces("application/vnd.ms-excel; charset=UTF-8")  
    public Response excel(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
    		@QueryParam("code") String code,
            @QueryParam("applyName") String applyName,
            @QueryParam("executorName") String executorName,
            @QueryParam("taskType") String taskType,
            @QueryParam("taskStatus") String taskStatus,
            @QueryParam("equTypeId") Long equTypeId) {
		
    	ResponseBuilder response = null;
    	try{
			Query query = new Query();
			query.setOffset(0);
			query.setLimit(200);
			query.setPage(pageNum);
			query.setCode(code);
			query.setApplyName(applyName);
			query.setExecutorName(executorName);
			query.setTaskType(taskType);
			query.setTaskStatus(taskStatus);
			query.setEquTypeId(equTypeId);
			
			Session session = getSessionQuietly();
			if(session == null){
				response = Response.status(Response.Status.BAD_REQUEST);
				return response.build();
			}
			
			Long parkId = session.getPlatformId();
			if(parkId == null){
				response = Response.status(Response.Status.BAD_REQUEST);
				return response.build();
			}
			query.setParkId(parkId);
			
			//创建临时文件
			String filePath = createNewExcelFile();

			//将查询的临时数据插入到 Excel 文件中
			createExcel(query,filePath);
			
			File file = new File(filePath);
			if(!file.exists()){
				response = Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND);
				return response.build();
			}
			
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] arr = new byte[1024*1024]; 
			int len = 0;
        	while((len = fis.read(arr)) != -1){
        		bos.write(arr, 0, len);
        	}
        	fis.close();
        	file.delete();
        	
        	response = Response.ok(bos.toByteArray());
            response.header("Content-Disposition","attachment; filename=\"task.xls\"");
            
            return response.build();
		}catch(Exception e){
			logger.error("园区 web 按条件导出任务列表 error:{}",e);
			response = Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
			return response.build();
		}
    }
    
    private String createNewExcelFile(){
    	try{
            // 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet("任务表一");  
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = sheet.createRow(0);  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
           //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
           HSSFCell cell=row.createCell(0);  
           //设置单元格内容  
           cell.setCellValue("任务列表");  
           cell.setCellStyle(style); 
           //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
           sheet.addMergedRegion(new CellRangeAddress(0,0,0,8)); 
            
	        row = sheet.createRow(1);
	        cell = row.createCell(0);
	        cell.setCellValue("任务ID ");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(1);  
	        cell.setCellValue("任务编号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(2);  
	        cell.setCellValue("任务类别");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(3);  
	        cell.setCellValue("创建人");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(4);  
	        cell.setCellValue("创建时间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(5);  
	        cell.setCellValue("任务状态");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(6);  
	        cell.setCellValue("执行人");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(7);  
	        cell.setCellValue("任务到达时间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(8);  
	        cell.setCellValue("实际执行时间");  
	        cell.setCellStyle(style);  
	        
	        HuolijuzhenConfig huolijuzhenConfig = HuolijuzhenConfig.getInstance();
	        String filePath = huolijuzhenConfig.getFilePath();
	        
	        
	        // 第六步，将文件存到指定位置  
	        String fileName = ((Long)System.currentTimeMillis()).toString();
	        String path = filePath + "任务列表-" + getSessionQuietly().getUserId() + "-" + fileName + ".xls";
	        FileOutputStream fout = new FileOutputStream(path);  
	        wb.write(fout);  
	        fout.close();
	        wb.close();
	        return path;
    	}catch(Exception e){
    		logger.error("任务列表导出 excel error:{}",e);
    		return null;
    	}
    }
    
    
    
    /**
     * 分页查询数据
     * @param query
     */
    private void createExcel(Query query,String filePath){
    	
    	Page<Task> page = taskService.findByCondition(query);
    	Integer offset = page.getOffset();
		Integer limit = page.getLimit();
		Integer total = page.getTotal();
    	
		List<Task> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(Task comm:list){
    			item = packListInfo(comm);
    			items.add(item);
    		}
    	}
    	//将数据写入 Excel 文件中
    	writerIntoExcel(items,filePath,offset);
		offset += limit;
    	if(offset < total){
    		query.setOffset(offset);
    		createExcel(query,filePath);
    	}
    }

    /**
     * 將数据写入 excel 文件中
     * @param items
     */
    private void writerIntoExcel(List<Map<String, Object>> items,String filePath,Integer offset){

    	try{
    		
    		FileInputStream fis = new FileInputStream(new File(filePath));
    		// 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            //关闭输入流
            fis.close();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.getSheetAt(0);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = null;  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
            if(CollectionUtils.isEmpty(items)){
            	wb.close();
            	  return;
            }
           
            Map<String, Object> itemMap = null;
            for (int i = 0; i < items.size(); i++)  
            {
            	itemMap = items.get(i);
	            row = sheet.createRow(offset + i + 2);  

	            //ID
	            row.createCell(0).setCellValue(itemMap.get("id").toString());
	            
	            //任务编码
	            row.createCell(1).setCellValue((String)itemMap.get("code"));
	            
	            //任务状态
	            Object taskType = itemMap.get("taskType");
	            if(taskType != null){
		            row.createCell(2).setCellValue(((TaskType)taskType).text());
	            }
	            
	            //任务创建人
	            AdminUser createBy = (AdminUser)itemMap.get("createBy");
	            row.createCell(3).setCellValue(notNull(createBy.getName()).toString());
	            
	            //创建时间
	            Object createTime = itemMap.get("createTime");
	            if(createTime != null){
		            row.createCell(4).setCellValue(SystemUtil.dateFormat((Date)createTime, "yyyy-MM-dd HH:mm:ss"));
	            }
	            
	            //任务状态
	            Object taskStatus = itemMap.get("taskStatus");
	            if(taskStatus != null){
		            row.createCell(5).setCellValue(((TaskStatus)taskStatus).text());
	            }
	            
	            //执行人
	            List<AdminUser> executors = (List<AdminUserService.AdminUser>)itemMap.get("executors");
	            StringBuilder executorsStr = new StringBuilder("");
	            if(CollectionUtils.isNotEmpty(executors)){
	            	for(int num=0;num< executors.size();num++){
	            		executorsStr.append(executors.get(num).getName());
	        		    if(num < executors.size()-1){
	        		    	executorsStr.append(" , ");
	        		  }
	            	}
	            }
	            row.createCell(6).setCellValue(executorsStr.toString());
	            
	            //任务到达时间
	        	Object allTime = itemMap.get("allTime");
	        	if(allTime != null){
		            row.createCell(7).setCellValue(SystemUtil.dateFormat((Date)allTime, "yyyy-MM-dd HH:mm:ss"));
	        	}

	        	//时间执行时间
	        	Object operationTime = itemMap.get("operatorTime");
	        	if(operationTime != null){
		            row.createCell(8).setCellValue(SystemUtil.dateFormat((Date)operationTime,"yyyy-MM-dd HH:mm:ss"));
	        	}
	            
            }  
            
            //写入到 Excel 文件中
            FileOutputStream fos = new FileOutputStream(filePath);
    		wb.write(fos);
    		fos.flush();
    		fos.close();
    		wb.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Task extractValidInfo(Task temp){
    	Task obj = new Task();
    	obj.setTitle(temp.getTitle());
    	obj.setEquTypeId(temp.getEquTypeId());
    	obj.setTaskType(temp.getTaskType());
    	obj.setEquPlanId(temp.getEquPlanId());
    	obj.setDescription(temp.getDescription());
    	obj.setExecutorIds(temp.getExecutorIds());
    	obj.setTaskType(temp.getTaskType());
    	
    	List<Long> executorIds = temp.getExecutorIds();
    	if(CollectionUtils.isEmpty(executorIds)){
    		obj.setTaskStatus(TaskStatus.WAITALLOT);
    	}else{
    		obj.setTaskStatus(TaskStatus.WAITEXECUTOR);
    		obj.setAllBy(getSessionQuietly().getUserId());
    		obj.setAllTime(new Date());
    	}
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
    	infoMap.put("code", notNull(item.getCode()));
    	infoMap.put("taskType", notNull(item.getTaskType()));
    	infoMap.put("createTime", notNull(item.getCreateTime()));
    	infoMap.put("taskStatus", notNull(item.getTaskStatus()));
    	infoMap.put("title", notNull(item.getTitle()));
    	
    	boolean isAdjust = item.getIsAdjust();
    	if(isAdjust){
        	infoMap.put("allTime", notNull(item.getAdjustTime()));
    	}else{
        	infoMap.put("allTime", item.getAllTime());
    	}
    	infoMap.put("operatorTime", item.getOperatorTime());
    	
    	
    	Long createById = item.getCreateBy();
    	AdminUser createBy = adminUserService.getById(createById);
    	infoMap.put("createBy", notNull(createBy));
    	
    	Long taskId = item.getId();
    	if(taskId != null){
    		List<AdminUser> executors = new ArrayList<AdminUserService.AdminUser>();
    		List<Long> taskExecutorIds = taskExecutorService.findAllExecutorByTaskId(taskId);
    		if(CollectionUtils.isNotEmpty(taskExecutorIds)){
    			AdminUser executor = null;
    			for(Long executorId:taskExecutorIds){
    				executor = adminUserService.getById(executorId);
    				executors.add(executor);
    			}
    		}
    		infoMap.put("executors", executors);
    	}else{
    		infoMap.put("executors", new ArrayList<AdminUser>());
    	}
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Task item){
    	Map<String, Object> infoMap = packListInfo(item);
    	
    	infoMap.put("description", notNull(item.getDescription()));
    	
    	//企业申报主图
		List<ImageInfo> taskImgUris = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_LOCALE, item.getId());
		infoMap.put("taskImgUri", new ArrayList<Map<String, Object>>());
		if(CollectionUtils.isNotEmpty(taskImgUris)){
			infoMap.put("taskImgUri", imageInfoListToMap(taskImgUris));
		}
		
		//执行现场图
		List<ImageInfo> operatorImages = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_OPERATOR, item.getId());
		infoMap.put("operatorImage", new ArrayList<Map<String, Object>>());
		if(CollectionUtils.isNotEmpty(operatorImages)){
			List<Map<String, Object>> operatorImage = imageInfoListToMap(operatorImages);
			infoMap.put("operatorImage", operatorImage);
		}    	
		
		infoMap.put("hasCost", notNull(item.getHasCost()));
		infoMap.put("costIsVerify", notNull(item.getCostIsVerify()));
		infoMap.put("taskCost", notNull(item.getTaskCost()));
		infoMap.put("payWay", notNull(item.getPayWay()));
		
		infoMap.put("isComment", notNull(item.getIsComment()));
		infoMap.put("commentContent", notNull(item.getCommentContent()));
		infoMap.put("commentGrade", notNull(item.getCommentGrade()));
		infoMap.put("commentStarGrade", notNull(item.getCommentStarGrade()));
		
		//执行人描述
		Long opetatorId = item.getOperator();
		infoMap.put("operatorId", notNull(opetatorId));
		infoMap.put("operatorName", "");
		if(opetatorId != null){
			AdminUser operator = adminUserService.getById(opetatorId);
			if(operator != null){
				infoMap.put("operatorName", notNull(operator.getName()));
			}
		}
		infoMap.put("operatorTime", notNull(item.getOperatorTime()));
		infoMap.put("operatorMemo", notNull(item.getOperatorMemo()));
		
		infoMap.put("companyName", "");
		TaskType taskType = item.getTaskType();
		if(TaskType.COMPANYAPPLY.equals(taskType)){
			Long companyId = item.getEquPlanId();
			if(companyId != null){
				EnterpriseInfo  enterpriseInfo = enterpriseInfoService.getById(companyId);
				if(enterpriseInfo != null){
					infoMap.put("companyName", notNull(enterpriseInfo.getName()));
				}
			}
		}
		
		
    	return infoMap;
    }
    
    
    @Test
    public void testHssf(){
    	
    	try{
            // 第一步，创建一个webbook，对应一个Excel文件  
    		String filePath = "E://任務列表-20170215171506.xls";
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File(filePath)));
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.getSheet("任務表一");  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
           //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  

            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = null;  
            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
            for (int i = 0; i < 5; i++)  
            {  
                row = sheet.createRow(i + 2);  

                row.createCell(0).setCellValue("aaa");
                row.createCell(1).setCellValue("bbb");
                row.createCell(2).setCellValue("ccc");
                row.createCell(3).setCellValue("ddd");
                row.createCell(4).setCellValue("eee");
            
            }  
            
         // 新建一输出文件流  
            filePath = "E://任務列表-20170215171507.xls";
            FileOutputStream fOut = new FileOutputStream(filePath);  
            // 把相应的Excel 工作簿存盘  
            wb.write(fOut);  
            fOut.flush();  
            // 操作结束，关闭文件  
            fOut.close();  
            wb.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
}

