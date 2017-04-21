package com.sudaotech.huolijuzhen.task.web.app.enterprise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.ApplyItem;
import com.sudaotech.huolijuzhen.task.service.TaskService.CommentItem;
import com.sudaotech.huolijuzhen.task.service.TaskService.History;
import com.sudaotech.huolijuzhen.task.service.TaskService.Query;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/app/enterprise/task")
public class AppEnterpriseTaskResource extends BusinessBaseResource {

    @Inject
    private TaskService taskService;
    
    @Inject
    private AdminUserService adminUserService;
    
    /**
     * 企业申报维修
     * 
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(
    		@Valid final ApplyItem applyItem) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long parkId = applyItem.getParkId();
    		if(parkId == null || parkId == -1){
    			return new Result<Map<String,Long>>(ResultCode.BAD_REQUEST);
    		}
    		
    		//当前用户ID
    		Long userId = session.getUserId();
            // create
    		Task temp = new Task();
    		//1.获取表单数据
    		temp.setParkId(parkId);
    		temp.setTitle(applyItem.getTitle());
    		temp.setDescription(applyItem.getDescription());
        	
        	//2.维护其它项
        	temp.setTaskType(TaskType.COMPANYAPPLY);
        	Long companyId = session.getPlatformId();
        	temp.setEquPlanId(companyId);
        	
        	temp.setTaskStatus(TaskStatus.WAITALLOT);
        	temp.setIsAdjust(false);
        	temp.setCreateBy(userId);
        	temp.setOperator(userId);
        	temp.setIsComment(false);
        	
    		//保存创建记录到 history 字段
    		History history = new History();
    		history.setOperatorId(userId);
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		history.setTime(sdf.format(new Date()));
    		
    		AdminUser adminUser = adminUserService.getById(userId);
    		history.setOperatorName(adminUser.getUsername());
    		history.setOperatorType("企业申请");
    		history.setMemo("");
    		temp = createHistory(temp, history);
    		
    		temp.setCode(createTaskNo());
            Long id = taskService.create(temp);
            
            //保存申报图
        	List<ImageInfo> listPaths = applyItem.getImageInfoList();
        	updateImageInfoPath(listPaths);
        	createImageInfo(ImageType.TASK_LOCALE, id, listPaths);
        	
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/task/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("企业维修申报 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 维修申报评论
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/comment/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> comment(
            @NotNull @PathParam("id") final Long id,
            final CommentItem commentItem) {
    	try{
    		Task task = new Task();
    		
    		task.setId(id);
    		task.setIsComment(true);
    		task.setCommentBy(getSessionQuietly().getUserId());
    		task.setCommentTime(new Date());
    		task.setTaskStatus(TaskStatus.FINISH);
    		task.setCommentContent(commentItem.getCommentContent());
    		task.setCommentGrade(commentItem.getCommentGrade());
    		
    		taskService.update(task);
    		
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("企业评论维修申报 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 维修申报费用确认
     * @param id
     * @param obj
     * @return
     */
    @GET
    @Path("/verify/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> verify(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		Task task = new Task();

    		task.setId(id);
    		task.setCostIsVerify(true);
    		task.setVerifyBy(getSessionQuietly().getUserId());
    		task.setVeribyTime(new Date());
    		
    		taskService.update(task);
    		
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("维修费用确认 error:{}",e);
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
    		logger.error("根据 ID 查询任务详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 申报维修申报历史
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
            @QueryParam("parkId") Long parkId) {
		try{
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
			}
			
			Long companyId = session.getPlatformId();
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setCompanyId(companyId);
			query.setParkId(parkId);
			
			Page<Task> page = taskService.findHistoryByCondition(query);
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
			logger.error("企业 app 查询维修申报历史记录 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
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
    	Map<String, Object> infoMap = new HashMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	infoMap.put("taskStatus", notNull(item.getTaskStatus()));
    	infoMap.put("description", notNull(item.getDescription()));

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	infoMap.put("createTime", notNull(sdf.format(item.getCreateTime())));
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Task item){
    	
    	Map<String, Object> infoMap = packListInfo(item);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	//企业申报主图
    	List<ImageInfo> taskImageUri = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_LOCALE, item.getId());
		infoMap.put("taskImageUri", new ArrayList<Map<String, Object>>());
		if(CollectionUtils.isNotEmpty(taskImageUri)){
			infoMap.put("taskImageUri", imageInfoListToMap(taskImageUri));
		}

//		//园区物业维修信息封装
//		Long equTypeId = item.getEquTypeId();
//		String equipmentTypeName = null;
//		if(equTypeId != null){
//			EquipmentType equipmentType = equipmentTypeService.getById(equTypeId);
//			if(equipmentType != null){
//				equipmentTypeName = equipmentType.getName();
//			}
//		}
//		infoMap.put("equipmentTypeName", equipmentTypeName);
//		infoMap.put("operatorMemo", notNull(item.getOperatorMemo()));
//		Date operatorTime = item.getOperatorTime();
//		if(operatorTime != null){
//			infoMap.put("operatorTime", sdf.format(operatorTime));
//		}else{
//			infoMap.put("operatorTime", "");
//		}
		//执行现场图
		List<ImageInfo> operatorImage = imageInfoService.findAllByImageTypeAndTargetId(ImageType.TASK_OPERATOR, item.getId());
		infoMap.put("operatorImage", new ArrayList<Map<String, Object>>());
		if(CollectionUtils.isNotEmpty(operatorImage)){
			infoMap.put("operatorImage", imageInfoListToMap(operatorImage));
		}
		
		//评论信息封装
		Boolean hasCost = item.getHasCost();
		infoMap.put("hasCost", hasCost);
		infoMap.put("costIsVerify", item.getCostIsVerify());
		infoMap.put("taskCost", notNull(item.getTaskCost()));
		infoMap.put("payWay", notNull(item.getPayWay()));
		
		Boolean isComment = item.getIsComment();
		infoMap.put("isComment", isComment);
		if(isComment){
			infoMap.put("commentTime", sdf.format(item.getCommentTime()));
		}else{
			infoMap.put("commentTime", "");
		}
		infoMap.put("commentContent", notNull(item.getCommentContent()));
		infoMap.put("commentGrade", notNull(item.getCommentGrade()));

    	return infoMap;
    }
}
