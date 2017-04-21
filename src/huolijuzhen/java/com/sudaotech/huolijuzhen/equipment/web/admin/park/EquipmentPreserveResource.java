package com.sudaotech.huolijuzhen.equipment.web.admin.park;

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
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlan;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService.EquipmentPreserve;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService.Query;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.EquipmentType;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

/**
 * 设备维护
 * @author admin
 *
 */
@Path("/admin/park/equipmentPreserve")
public class EquipmentPreserveResource extends BaseResource {

    @Inject
    private EquipmentPreserveService equipmentPreserveService;
    
    @Inject
    private EquipmentPlanService equipmentPlanService;
    
    @Inject
    private EquipmentTypeService equipmentTypeService;
    
    @Inject
    private TaskService taskService;
    
    @Inject
    private AdminUserService adminUserService;
    
    /**
     * 新增维护设备项目
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EquipmentPreserve obj) {
    	try{
    		EquipmentPreserve temp = extractValidInfo(obj);
    		// 1.新增设备维护项目
            temp.setOperator(getSessionQuietly().getUserId());
            Long parkId = getSessionQuietly().getPlatformId();
            temp.setParkId(parkId);
            
            Long id = equipmentPreserveService.create(temp);
            temp.setId(id);
            //2.若为启用状态生成维护计划
            if(temp.getIsEnablePlan()){
            	createPlan(temp);
            }

            Map<String, Long> map = MapHelper.put("id", id).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/equipmentPreserve/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("新增维护设备项目 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
	/**
	 * 编制指定维护设备项目
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
            @Valid final EquipmentPreserve obj) {
    	try{
    		//1.新增维护项目
    		EquipmentPreserve temp = extractValidInfo(obj);

    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            equipmentPreserveService.update(temp);
            
            //2.维护计划信息
            if(temp.getIsEnablePlan()){
            	createPlan(temp);
            }
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("编辑指定维护设备项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 启用指定维护项目
     * @param id
     * @return
     */
    @PUT
    @Path("/enable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> enable(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		//1.修改设备维护项目的详细信息
    		EquipmentPreserve temp = new EquipmentPreserve();

    		//启用时重新维护启用时间、维护周期、设备寿命、周期类型等
    		//TODO
    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());

            temp.setEnableStatus(EnableStatus.ENABLE);
            temp.setEnableBy(getSessionQuietly().getUserId());
            temp.setEnableTime(new Date());
            equipmentPreserveService.update(temp);
            
            //2.启用对应的计划
            updatePlan(id,EnableStatus.ENABLE);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("启用指定维护设备项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 禁用指定维护项目
     * @param id
     * @return
     */
    @PUT
    @Path("/disable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> disable(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		//1.修改设备维护项目的详细信息
    		EquipmentPreserve temp = new EquipmentPreserve();

    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            
            temp.setEnableStatus(EnableStatus.DISABLE);
            temp.setDisableBy(getSessionQuietly().getUserId());
            temp.setDisableTime(new Date());
            equipmentPreserveService.update(temp);
           
            //2.启用、禁用未执行的维护计划
            updatePlan(id,EnableStatus.DISABLE);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("启用指定维护设备项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 获取指定设备维护项目
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> get(@NotNull @PathParam("id") final Long id) {
		try{
			//1.获取维护项目的基本信息
			EquipmentPreserve obj = equipmentPreserveService.getById(id);
		    Map<String, Object> dataMap = new HashedMap<String, Object>();
		    if(obj != null){
		    	dataMap = packItemInfo(obj);
		    }
		    //获取任务信息
		    //TODO 获取与之对应的所有任务
		    
		    return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("获取指定设备维护项目 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    /**
     * 按条件获取设备维护项目
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("page") Integer pageNum,
    		@QueryParam("name") String name,
    		@QueryParam("code") String code,
    		@QueryParam("enableStatus") String enableStatus,
    		@QueryParam("equTypeId") Long equTypeId) {
    	Page<EquipmentPreserve> page = null;
		try {
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setName(name);
			query.setCode(code);
			query.setEnableStatus(enableStatus);
			query.setEquTypeId(equTypeId);
			
			Long parkId = getSessionQuietly().getPlatformId();
			query.setParkId(parkId);
			
			page = equipmentPreserveService.find(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<EquipmentPreserve> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item = new HashedMap<String, Object>();
        	if(CollectionUtils.isNotEmpty(list)){
        		for(EquipmentPreserve equPreserve:list){
        			item = packListInfo(equPreserve);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		} catch (Exception e) {
			logger.error("按条件分页查询设备维护项目 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
			
		}		
    }
    
    /**
     * 通过维修项目生产维修计划
     * @param equPre
     */
    private void createPlan(EquipmentPreserve obj){

    	EquipmentPreserve equipmentPreserve = equipmentPreserveService.getById(obj.getId());
    	List<EquipmentPlan> equipmentPlans = obj.getEquipmentPlanList();
    	
		if(CollectionUtils.isEmpty(equipmentPlans) || equipmentPlans == null){
			return;
		}
    	for(EquipmentPlan equPlan:equipmentPlans){

    		equPlan.setPlanStatus(PlanStatus.WAITALLOT);
    		equPlan.setEnableStatus(equipmentPreserve.getEnableStatus());
    		
    		equPlan.setEquId(equipmentPreserve.getId());
    		equPlan.setEquName(equipmentPreserve.getName());
    		equPlan.setEquCode(equipmentPreserve.getCode());
    		equPlan.setEquTypeId(equipmentPreserve.getEquTypeId());
    		equPlan.setEquTypeName(equipmentPreserve.getEquTypeName());
    		
    		equPlan.setOperator(getSessionQuietly().getUserId());
    		
    		if(equPlan.getId() == null){
        		equipmentPlanService.create(equPlan);
    		}else{
    			equipmentPlanService.update(equPlan);
    		}
    		
    	}
    }
    
    /**
     * 通过维修项目更新维修计划启用、禁用状态
     * @param equPre
     */
    private void updatePlan(Long equPreId,EnableStatus enableStatus){
    	//1.获取此后的所有对应的几乎
    	List<Long> ids = equipmentPlanService.getByEquPreId(equPreId);
    	
    	//2.启用、禁用在此之后的所有计划
    	if(CollectionUtils.isNotEmpty(ids)){
    		for(Long id:ids){
    			EquipmentPlan obj = new EquipmentPlan();
    			obj.setId(id);
    			obj.setOperator(getSessionQuietly().getUserId());
    			obj.setEnableStatus(enableStatus);
    			obj.setDeleteBy(getSessionQuietly().getUserId());
    			obj.setDeleteTime(new Date());
    			equipmentPlanService.update(obj);
    		}
    	}
    }
    
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private EquipmentPreserve extractValidInfo(EquipmentPreserve temp)throws Exception{
    	EquipmentPreserve obj = new EquipmentPreserve();
    	
    	obj.setName(temp.getName());
    	obj.setCode(temp.getCode());
    	obj.setEquTypeId(temp.getEquTypeId());
    	obj.setPreObj(temp.getPreObj());
    	obj.setIsEnablePlan(temp.getIsEnablePlan());
    	
    	EnableStatus enableStatus = temp.getEnableStatus();
    	if(EnableStatus.ENABLE.equals(enableStatus)){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else{
    		obj.setDisableBy(getSessionQuietly().getUserId());
    		obj.setDisableTime(new Date());
    	}
    	obj.setEnableStatus(enableStatus);
    	
    	obj.setEquipmentPlanList(temp.getEquipmentPlanList());
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(EquipmentPreserve item){
    	Map<String, Object> infoMap = new HashMap<String, Object>();

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("code", notNull(item.getCode()));
    	
    	Long equTypeId = item.getEquTypeId();
    	infoMap.put("equTypeId", notNull(equTypeId));
    	EquipmentType equipmentType = equipmentTypeService.getById(equTypeId);
    	
    	infoMap.put("equTypeName", notNull(equipmentType.getName()));
    	infoMap.put("isEnablePlan", notNull(item.getIsEnablePlan()));
    	infoMap.put("preObj", notNull(item.getPreObj()));
    	
    	EnableStatus enableStatus = item.getEnableStatus();
    	infoMap.put("enableStatus", enableStatus);
    	if(EnableStatus.ENABLE.equals(enableStatus)){
    		infoMap.put("enableTimeStr", notNull(sdf.format(item.getEnableTime())));
    	}else{
    		infoMap.put("enableTimeStr", "");
    	}
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(EquipmentPreserve item){
    	
    	Map<String, Object> infoMap = packListInfo(item);
    	
    	Map<String, Object> params = new HashedMap<String, Object>();
    	params.put("equPreId", item.getId());
    	params.put("status", Status.NORMAL.code());
    	
    	//查询对应的未完成未执行
    	List<Map<String, Object>> planMaps = equipmentPlanService.findByEquId(params);
    	List<Map<String, Object>> dataPlan= new ArrayList<Map<String,Object>>();
    	List<Long> equPlanIds = new ArrayList<Long>();
    	if(CollectionUtils.isNotEmpty(planMaps)){
    		for(Map<String, Object> equPlan:planMaps){
    			Integer planStatus = (Integer)equPlan.get("planStatus");
    			if(PlanStatus.WAITALLOT.code() == planStatus){
    				equPlan.put("planStatus", PlanStatus.WAITALLOT);
    				dataPlan.add(equPlan);
    			}else{
    				Long equPlanId = (Long)equPlan.get("id");
    				equPlanIds.add(equPlanId);
    			}
    		}
    		
    	}
    	infoMap.put("dataPlan", dataPlan);    	
    	//查询对应的已完成的任务
    	List<Map<String, Object>> dataTask = new ArrayList<Map<String,Object>>();
    	if(CollectionUtils.isNotEmpty(equPlanIds)){
    		List<Map<String, Object>> taskListMap = taskService.findByEquPlanIds(equPlanIds);
    		if(CollectionUtils.isNotEmpty(taskListMap)){
    			for(Map<String, Object> map:taskListMap){
    				Integer taskType = (Integer)map.get("taskType");
    				map.put("taskType", TaskType.codeOf(taskType));
    				
    				Integer taskStatus = (Integer)map.get("taskStatus");
    				map.put("taskStatus", TaskStatus.codeOf(taskStatus));

    				if(TaskStatus.FINISH.code() == taskStatus){
        				Long operator = (Long)map.get("operator");
        				AdminUser user = adminUserService.getById(operator);
        				if(user != null){
        					map.put("operator", user.getName());
        				}
        				Date operatorTime = (Date)map.get("operatorTime");
        				map.put("operatorTime", SystemUtil.dateFormat(operatorTime, "yyyy-MM-dd"));
    				}else{
    					map.put("operator", "");
    					map.put("operatorTime", "");
    				}
    				
    				dataTask.add(map);
    			}
    		}
    		infoMap.put("historyTask", dataTask);    		
    		
    	}else{
    		infoMap.put("historyTask",new ArrayList<Map<String, Object>>());
    	}
    	
    	return infoMap;
    }
    
    /**
     * 判断是否为空，为空返回空串
     * @param obj
     * @return
     */
    private Object notNull(Object obj){
    	if(obj == null){
    		return "";
    	}else{
    		return obj;
    	}
    }
}
