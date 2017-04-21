package com.sudaotech.huolijuzhen.equipment.web.admin.park;

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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.CycleType;
import com.sudaotech.huolijuzhen.enums.PlanStatus;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.BatchCreateItem;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlan;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.PlanItems;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.Query;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService.EquipmentPreserve;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.EquipmentType;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/admin/park/equipmentPlan")
public class EquipmentPlanResource extends BusinessBaseResource {

    
    @POST
    @Path("/batch")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> batch(@Valid final BatchCreateItem batchCreateItem) {
    	try{
            // create
        	Session session = getSessionQuietly();
        	if(session == null){
        		return new Result<String>(ResultCode.SESSION_IS_NULL);
        	}
        	
        	Long equId = batchCreateItem.getEquipmentId();
        	EquipmentPreserve equipmentPreserve = equipmentPreserveService.getById(equId);
        	List<EquipmentPlan> equipmentPlans = batchCreateItem.getEquipmentPlans();
        	
    		if(CollectionUtils.isEmpty(equipmentPlans) || equipmentPreserve == null){
    			return new Result<String>(ResultCode.BAD_REQUEST);
    		}
    		
        	for(EquipmentPlan equPlan:equipmentPlans){

        		equPlan.setPlanStatus(PlanStatus.WAITALLOT);
        		equPlan.setEnableStatus(equipmentPreserve.getEnableStatus());
        		
        		equPlan.setEquId(equipmentPreserve.getId());
        		equPlan.setEquName(equipmentPreserve.getName());
        		equPlan.setEquCode(equipmentPreserve.getCode());
        		equPlan.setEquTypeId(equipmentPreserve.getEquTypeId());
        		equPlan.setEquTypeName(equipmentPreserve.getEquTypeName());
        		
        		equPlan.setOperator(session.getUserId());
        		
           		equipmentPlanService.create(equPlan);
        	}

            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("批量添加维护计划 error：{}",e);
    		return new Result<String>(ResultCode.BATCH_ADD_FAILD);
    	}
    }
    
    /**
     * 根据维修项目周期、周期类型、启用日期生成计划
     * @param query
     * @return
     */
    @POST
    @Path("/createTempPlan")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String, Object>>> crateTempPlan(@Valid final PlanItems planItems) {
		try{
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");

			//周期开始日期
	    	Date cycStartDate = sdf.parse(planItems.getCycStartDate());
	    	//周期结束日期
	    	Date cycEndDate = sdf.parse(planItems.getCycEndDate());
	    	//類型
	    	CycleType cycleType = planItems.getCycleType();
	    	//描述
	    	String description = planItems.getDescription();
	    	//周期
	    	Integer preCycle = planItems.getPreCycle();
	    	//每月、每周 時使用
	    	List<Map<String, Object>> items = planItems.getItems();
	    	
	    	
	    	List<Date> planDates = new ArrayList<Date>();
	    	Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(cycStartDate);
	    	Date tempDate = cycStartDate;
	    	while(tempDate.getTime() < cycEndDate.getTime()){
	    		//日
	    		if(CycleType.DAYS.equals(cycleType)){
	        		calendar.add(Calendar.DAY_OF_MONTH, preCycle);
	        	}
	    		//月
	    		else if(CycleType.MONTHS.equals(cycleType)){
	        		calendar.add(Calendar.MONTH, preCycle);
	        	}
	    		//年
	    		else if(CycleType.YEARS.equals(cycleType)){
	        		calendar.add(Calendar.YEAR, preCycle);        		
	        	}
	    		//季度
	    		else if(CycleType.QUARTER.equals(cycleType)){
	        		calendar.add(Calendar.MONTH, preCycle*3);
	        	}
	        	//每周
	        	else if(CycleType.WEEKLY.equals(cycleType)){
	        		if(CollectionUtils.isNotEmpty(items)){
	        			calendar.add(Calendar.WEEK_OF_MONTH, 1);
	        			for(Map<String, Object> item:items){
	        				Integer val = (Integer)item.get("val");
	        				if(val < 1 || val > 7){
	        					continue;
	        				}
	        				calendar.set(Calendar.DAY_OF_WEEK, val);
	        				tempDate = calendar.getTime();
        		        	if(tempDate.getTime() < cycEndDate.getTime()){
        			        	planDates.add(tempDate);
        		        	}
	        			}
	        		}
	        	}
	        	//每月
	        	else if(CycleType.MONTHLY.equals(cycleType)){
	        		if(CollectionUtils.isNotEmpty(items)){
	        			calendar.add(Calendar.MONTH, 1);
	        			int min = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
	        	    	int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        				for(Map<String, Object> item:items){
        					Integer val = (Integer)item.get("val");
        					if(val < min || val > max){
        						continue;
        					}
        					calendar.set(Calendar.DAY_OF_MONTH, val);
        		        	tempDate = calendar.getTime();
        		        	if(tempDate.getTime() < cycEndDate.getTime()){
        			        	planDates.add(tempDate);
        		        	}
	        			}
	        		}
	        	}
	    		
	    		if(!CycleType.WEEKLY.equals(cycleType) && !CycleType.MONTHLY.equals(cycleType)){
		        	tempDate = calendar.getTime();
		        	if(tempDate.getTime() < cycEndDate.getTime()){
			        	planDates.add(tempDate);
		        	}
	    		}
	    	}
	    	
	    	if(CollectionUtils.isEmpty(planDates)){
				return new Result<List<Map<String,Object>>>(ResultCode.BAD_REQUEST);
			}
	    	Map<String, Object> planMap = null;
	    	List<Map<String, Object>> planList = new ArrayList<Map<String,Object>>();
	    	for(Date planDate:planDates){

	    		planMap = new HashedMap<String, Object>();
	    		
	    		planMap.put("planDate", sdf.format(planDate));
	    		planMap.put("description", description);
	    	
	    		planList.add(planMap);
	    	}
	        return new Result<List<Map<String,Object>>>(ResultCode.OK,planList);	
		}catch(Exception e){
			logger.error("通过规则生成维修设备维修计划 error:{}",e);
			return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
		}

	}
    
    /**
     * 根据 ID 删除指定计划 
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteById(
            @NotNull @PathParam("id") final Long id) {
    	try{

    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		EquipmentPlan obj = new EquipmentPlan();
    		
    		obj.setId(id);
            obj.setOperator(session.getUserId());
            obj.setStatus(Status.DELETED);
            obj.setDeleteBy(session.getUserId());
            obj.setDeleteTime(new Date());

            equipmentPlanService.update(obj);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("删除未被分配的计划 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<EquipmentPlan> get(@NotNull @PathParam("id") final Long id) {
        EquipmentPlan obj = equipmentPlanService.getById(id);
        
        return new Result<EquipmentPlan>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EquipmentPlan>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<EquipmentPlan> page = equipmentPlanService.find(query);
        return new Result<Page<EquipmentPlan>>(ResultCode.OK, page);
    }
    
    /**
     * 获取指定月份的所有计划
     * @param query
     * @return
     */
    @POST
    @Path("/findByMonth")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findByMonth(
            @Valid final Query query) {
		try{
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Long parkId = session.getPlatformId();
			List<Long> equIds = findValidEquIdsByParkId(parkId);
			query.setEquIds(equIds);
			
			List<EquipmentPlan> list = equipmentPlanService.findByMonth(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	
        	Map<String,Integer> items = new HashMap<String,Integer>();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	if(CollectionUtils.isNotEmpty(list)){
        		for(EquipmentPlan equPlan:list){
        			Date planExecutorDate = equPlan.getPlanExecutorDate();
        			String key = sdf.format(planExecutorDate);
        			
        			Integer num = items.get(key);
        			if(num == null){
        				num = 1;
        			}else{
        				num += 1;
        			}
        			items.put(key, num);
        		}
        	}
        	//封装结果街
        	List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        	Map<String, Object> itemMap = null;
        	if(items.size() > 0){
        		for(Map.Entry<String, Integer> entry:items.entrySet()){
        			itemMap = new HashedMap<String, Object>();
        			
        			itemMap.put("start", entry.getKey());
        			itemMap.put("title", entry.getValue());
        			
        			dataList.add(itemMap);
        		}
        	}
        	dataMap.put("items", dataList);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);	
		}catch(Exception e){
			logger.error("按月份查询维护计划 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}

	}
    /**
     * 获取指定日期的所有计划
     * @param query
     * @return
     */
    @POST
    @Path("/findByDate")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findByDate(
            @Valid final Query query) {
    	Page<EquipmentPlan> page = null;
		try{
			
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Long parkId = session.getPlatformId();
			List<Long> equIds = findValidEquIdsByParkId(parkId);
			query.setEquIds(equIds);
			
			page = equipmentPlanService.findByDate(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<EquipmentPlan> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(EquipmentPlan anno:list){
        			item = packListInfo(anno);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);	
		}catch(Exception e){
			logger.error("按日期条件查询维护计划 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}

	}   
    
    /**
     * 获取指定园区下所有启用的设备
     * @param parkId
     * @return
     */
    private List<Long> findValidEquIdsByParkId(Long parkId){
    	
    	List<Long> equIds = new ArrayList<Long>();
    	EquipmentPreserve equipmentPreserve = new EquipmentPreserve();
    	equipmentPreserve.setParkId(parkId);
    	List<EquipmentPreserve> items = equipmentPreserveService.findByObj(equipmentPreserve);
    	if(CollectionUtils.isNotEmpty(items)){
    		for(EquipmentPreserve item:items){
    			equIds.add(item.getId());
    		}
    	}
    	return equIds;
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
            @Valid final Query query) {
		try{
			//1.更新计划的状态为已生成任务
			
			//2.在任务表中添加任务

			Map<String,Object> dataMap = new HashedMap<String, Object>();
			
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);	
		}catch(Exception e){
			logger.error("通过维修计划生产维修任务 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
	}
    
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(EquipmentPlan item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("planStatus", notNull(item.getPlanStatus()));
    	
    	Long equId = item.getEquId();
    	EquipmentPreserve equ = equipmentPreserveService.getById(equId);
    	infoMap.put("equCode", notNull(equ.getCode()));
    	infoMap.put("equName", notNull(equ.getName()));
    	
    	Long equTypeId = equ.getEquTypeId();
    	if(equTypeId != null){
    		EquipmentType equipmentType = equipmentTypeService.getById(equTypeId);
    		infoMap.put("equTypeName",equipmentType.getName());
    	}

    	infoMap.put("lastDate", new Date());
    	return infoMap;
    }
}
