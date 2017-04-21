package com.sudaotech.huolijuzhen.sys.common.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.community.service.CommunityService.StatisticsCondition;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfoQuery;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlan;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlanQuery;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService.ByParkIdQuery;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService.EquipmentPreserve;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Policy;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Query;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService.ResInfo;
import com.sudaotech.huolijuzhen.util.SystemUtil;

@Path("/statistics")
public class Statistics extends BusinessBaseResource {
	
	/**
	 * 费用项目
	 */
	private static final String SERVICE_PROJECT = "SERVICEPROJECT";
	/**
	 * 账单统计
	 */
	private static final String BILL_INFO = "BILLINFO";
	
	private static final String TOTAL_MONEY = "总额";
	
	private static final String GATHERING_MONEY = "已收款";
	/**
	 * 按周统计
	 */
	private static final String WEEKS = "WEEKS";

	/**
	 * 按月统计
	 */
	private static final String MONTHS = "MONTHS";
	/**
     * 按服务类型、点击数统计服务项目(运营平台 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/serviceByServiceType")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> serviceByServiceType() {
		try{
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<Map<String, Object>> items = serviceProjectService.statisticsByServiceType();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());
    		if(CollectionUtils.isNotEmpty(items)){
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("服务项目 -- 运营平台 Web 按服务类型点击数统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    /**
     * 按点击数统计服务项目(运营平台 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/serviceByReadNum")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> serviceByReadNum() {
		try{
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<Map<String, Object>> items = serviceProjectService.statisticsByReadNum();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());
    		if(CollectionUtils.isNotEmpty(items)){
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("服务项目 --- 运营平台 Web 按点击数统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
  
	/**
     * 按服务类型、点击数统计服务项目(运营平台 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/serviceToPlatform")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> serviceToPlatform(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("type") String type,
    		@QueryParam("data") String data) {
		try{
			/**
			 * type:
			 * 	服务商：PROVIDER
			 * 	服务类型：SERVICETYPE
			 * 	服务项目：SERVICEPROJECT
			 *data:
			 *	点击量：READNUM
			 *	订单量：APPLYORDERNUM
			 *	收藏量：COLLECTNUM
			 */
			
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("type", type);
			paramsMap.put("data", data);
			paramsMap.put("offset", offset);
			paramsMap.put("limit", limit);
			
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<Map<String, Object>> items = serviceProjectService.statisticsToPlatform(paramsMap);
	    	dataMap.put("offset", offset);
	    	dataMap.put("limit", limit);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());
    		if(CollectionUtils.isNotEmpty(items)){
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("服务项目 --- 运营平台 Web 按服务类型、点击数统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 社群活动统计（运营平台 Web）
     * @param query
     * @return
     */
    @GET
    @Path("/community")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> community(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("page") Integer pageNum,
    		@QueryParam("title") String title,
    		@QueryParam("createSide") String createSideStr) {
    	
    	try{
    		StatisticsCondition condition = new StatisticsCondition();
    		condition.setOffset(offset);
    		condition.setLimit(limit);
    		condition.setPage(pageNum);
    		condition.setTitle(title);
    		if(StringUtils.isNotBlank(createSideStr)){
    			condition.setCreateSide(CreateSide.valueOf(createSideStr));
    		}
    		
    		//1.按条件查询活动
        	Page<Community> page = communityService.statistics(condition);
        	//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Community> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		//获取所有的园区 ID
        		List<Long> parkIds = new ArrayList<Long>();
    			Map<Long, String> parkInfoMap = new HashMap<Long, String>();
        		for(Community comm:list){
        			Long createSideId = comm.getCreateSideId();
        			if(createSideId != null){
        				parkIds.add(createSideId);
        			}

        			//获取所有的园区信息
        			if(CollectionUtils.isNotEmpty(parkIds)){
            			List<ParkInfo> parkInfos = parkInfoService.findParkInfosByParkIds(parkIds);
            			if(CollectionUtils.isNotEmpty(parkInfos)){
            				for(ParkInfo parkInfo:parkInfos){
            					parkInfoMap.put(parkInfo.getId(), parkInfo.getName());
            				}
            			}
        			}
        		}
        		//获取所有的社群活动 ID
        		List<Long> communityIds = new ArrayList<Long>();
        		for(Community comm:list){
        			communityIds.add(comm.getId());
        		}
        		List<Map<String, Object>> communityApplys = communityApplyService.statistics(communityIds);
        		Map<Long, Map<String, Object>> communityApplyMap = new HashedMap<Long, Map<String, Object>>();
        		if(CollectionUtils.isNotEmpty(communityApplys)){
        			for(Map<String, Object> itemMap:communityApplys){
        				communityApplyMap.put((Long)itemMap.get("communityId"), itemMap);
        			}
        		}
        		
        		for(Community comm:list){
        			item = new HashMap<String, Object>();
        			item.put("title", comm.getTitle());
        			CreateSide createSide = comm.getCreateSide();
        			if(CreateSide.PLATFORM.equals(createSide)){
        				item.put("createSide", "平台发布");
        			}else{
            			item.put("createSide", parkInfoMap.get(comm.getCreateSideId()));
        			}
        			item.putAll(communityApplyMap.get(comm.getId()));

        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		}catch(Exception e){
			logger.error("社群活动 --- 运营平台 Web 统计社群活动 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
		}
    	
    }
    
    /**
     * 政策点击量统计(运营平台 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/policy")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> policy(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("title") String title) {
    	
    	Page<Policy> page = null;
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		query.setTitle(title);
    		
    		//1.
    		page = policyService.statistics(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Policy> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Policy pc:list){
        			item = new HashedMap<String, Object>();
        			item.put("id", pc.getId());
        			item.put("title", pc.getTitle());
        			item.put("polUrl", notNull(pc.getPolUri()));
        			item.put("readNum", pc.getReadNum());
        			
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("政策 --- 运营平台 Web 按点击量统计政策 error:{}",e);
    		//日期字符串转换日期格式异常
    		return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
    }
    
    
    /**
     * 任务计划提醒(园区管理 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/equipmentPlan")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> equipmentPlan() {
    	Page<EquipmentPlan> page = null;
		try{
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Long parkId = session.getPlatformId();
			List<Long> equIds = findValidEquIdsByParkId(parkId);
			
			EquipmentPlanQuery equipmentPlanQuery = new EquipmentPlanQuery();
			equipmentPlanQuery.setEquIds(equIds);
			equipmentPlanQuery.setStartDate(new Date());
			equipmentPlanQuery.setOffset(0);
			equipmentPlanQuery.setLimit(5);
			
			page = equipmentPlanService.equipmentPlanStatistics(equipmentPlanQuery);
			
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<EquipmentPlan> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> itemMap = null;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(EquipmentPlan item:list){
        			itemMap = new HashedMap<String, Object>();
        			
        			itemMap.put("equPlanId", item.getId());
        			itemMap.put("equCode", notNull(item.getEquCode()));
        			itemMap.put("equName",notNull(item.getEquName()));
        			itemMap.put("description", notNull(item.getDescription()));
        			
        			Date planExecutorDate = item.getPlanExecutorDate();
        			if(planExecutorDate != null){
        				itemMap.put("planExecutorDate", SystemUtil.dateFormatYYMMDD(planExecutorDate));
        			}else{
            			itemMap.put("planExecutorDate", planExecutorDate);
        			}
        			
        			items.add(itemMap);
        		}
        	}
        	dataMap.put("items", items);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);	
		}catch(Exception e){
			logger.error("任务计划 --- 统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}

	}
    
    private List<Long> findValidEquIdsByParkId(Long parkId){
    	
    	List<Long> equIds = new ArrayList<Long>();
    	
    	ByParkIdQuery query = new ByParkIdQuery();
    	query.setParkId(parkId);
    	query.setEnableStatus("ENABLE");
    	Page<EquipmentPreserve> equipPage = equipmentPreserveService.find(query);
    	List<EquipmentPreserve> items = equipPage.getItems();
    	if(CollectionUtils.isNotEmpty(items)){
    		for(EquipmentPreserve item:items){
    			equIds.add(item.getId());
    		}
    	}
    	return equIds;
    }
    
    /**
     * 按服务类型、点击数统计服务项目(运营平台 Web)
     * @param query
     * @return
     */
    @GET
    @Path("/serviceToPark")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> serviceToPark(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("type") String type,
    		@QueryParam("data") String data) {
		try{
			/**
			 * type:
			 * 	服务商：PROVIDER
			 * 	服务类型：SERVICETYPE
			 * 	服务项目：SERVICEPROJECT
			 * data:
			 *	点击量：READNUM
			 *	订单量：APPLYORDERNUM
			 *	收藏量：COLLECTNUM
			 */
			
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("type", type);
			paramsMap.put("data", data);
			paramsMap.put("offset", offset);
			paramsMap.put("limit", limit);
			paramsMap.put("parkId", parkId);
			
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<Map<String, Object>> items = serviceProjectService.statisticsToPark(paramsMap);
	    	dataMap.put("offset", offset);
	    	dataMap.put("limit", limit);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());
    		if(CollectionUtils.isNotEmpty(items)){
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("服务项目 --- 园区管理 Web 按服务类型、点击量统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    /**
     * 任务统计（园区管理 Web）
     * @param type
     * 		任务类型：TASKTYPE
     * 		设备类型：EQUTYPE
     * 		执行人：EXECUTOR
     * 
     * @return
     */
    @GET
    @Path("/task")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> task(
    		@QueryParam("type") String type,
    		@QueryParam("startDate") String startDate,
    		@QueryParam("endDate") String endDate) {
		try{
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
	    	paramsMap.put("parkId", parkId);
	    	paramsMap.put("type", type);
			paramsMap.put("startDate", startDate);
			paramsMap.put("endDate", endDate);

	    	List<Map<String, Object>> items = taskService.statisticsTask(paramsMap);

	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("items", new ArrayList<Map<String,Object>>());
	    	if(CollectionUtils.isNotEmpty(items)){
		    	percentAuth(items);
		    	dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("任务 --- 园区管理 Web 统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    /**
     * 计算任务量占比
     * @param items
     */
    private void percentAuth(List<Map<String, Object>> items){
    	
    	if(CollectionUtils.isEmpty(items)){
    		return;
    	}
    	
		Long total = 0L;
		for(Map<String, Object> item:items){
			Long taskNum = (Long)item.get("num");
			total += taskNum;
		}
    	
    	BigDecimal totlaBigDecimal = new BigDecimal(total.toString());
		BigDecimal bigDecimal = new BigDecimal(0);
		BigDecimal percentBigDecimal = null;
		for(int i=0;i<items.size();i++){
			Map<String,Object> item = items.get(i);
			if(i < items.size() - 1){
				Long taskNum = (Long)item.get("num");
				percentBigDecimal = new BigDecimal(taskNum.toString());
				percentBigDecimal = percentBigDecimal.divide(totlaBigDecimal,4,BigDecimal.ROUND_HALF_UP);
				percentBigDecimal = percentBigDecimal.multiply(new BigDecimal(100));
				percentBigDecimal = percentBigDecimal.setScale(2);
				
				bigDecimal = bigDecimal.add(percentBigDecimal);
				item.put("percent", percentBigDecimal.toString());
			}else{
				bigDecimal = bigDecimal.subtract(new BigDecimal(100));
				bigDecimal = bigDecimal.multiply(new BigDecimal(-1));
				item.put("percent", bigDecimal.toString());
			}
			item.put("total", total);
		}
    }
    
    /**
     * 资源出租率（园区管理 Web 按数量）
     * @param query
     * @return
     */
    @GET
    @Path("/resourceByNum")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> resourceByNum() {
    	try{
			//1.判断是否登录
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("parkId", parkId);

			//2.按数量统计
	    	List<Map<String, Object>> itemsAll = resourceInfoService.resOfNumAll(paramsMap);
	    	List<Map<String, Object>> itemsUse = resourceInfoService.resOfNumUse(paramsMap);
    		Map<Long, Map<String, Object>> tempMap = new HashedMap<Long, Map<String,Object>>();
    		//2.1 已使用数量
    		if(CollectionUtils.isNotEmpty(itemsUse)){
    			for(Map<String, Object> itemMap:itemsUse){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				tempMap.put(resTypeId, itemMap);
    			}
	    	}
    		//2.2 总数量
    		if(CollectionUtils.isNotEmpty(itemsAll)){
    			for(Map<String, Object> itemMap:itemsAll){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				Map<String, Object> map = tempMap.get(resTypeId);
    				if(map != null){
        				itemMap.putAll(map);
    				}else{
    					itemMap.put("sumNumUse", 0);
    				}

					tempMap.put(resTypeId, itemMap);
    			}
    		}
    		//2.3 封装统计结果
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());

    		if(CollectionUtils.isNotEmpty(itemsAll)){
        		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    			for(Map.Entry<Long, Map<String, Object>> entity:tempMap.entrySet()){
        			items.add(entity.getValue());
        		}
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
    		}
    		
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 园区管理 Web 按数量统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 资源出租率（园区管理 Web 按面积）
     * @param query
     * @return
     */
    @GET
    @Path("/resourceByArea")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> resourceByArea() {
		try{
			//1.判断是否登录
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("parkId", parkId);

			//2.按面积统计
	    	List<Map<String, Object>> itemsAll = resourceInfoService.resOfAreaAll(paramsMap);
	    	List<Map<String, Object>> itemsUse = resourceInfoService.resOfAreaUse(paramsMap);
    		Map<Long, Map<String, Object>> tempMap = new HashedMap<Long, Map<String,Object>>();
    		//2.1 已使用面积
    		if(CollectionUtils.isNotEmpty(itemsUse)){
    			for(Map<String, Object> itemMap:itemsUse){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				tempMap.put(resTypeId, itemMap);
    			}
	    	}
    		//2.2 总面积
    		if(CollectionUtils.isNotEmpty(itemsAll)){
    			for(Map<String, Object> itemMap:itemsAll){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				Map<String, Object> map = tempMap.get(resTypeId);
    				if(map != null){
        				itemMap.putAll(map);
    				}else{
    					itemMap.put("sumAreaUse", 0);
    				}
    				tempMap.put(resTypeId, itemMap);
    			}
    		}
    		//2.3 封装统计结果
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());

    		if(CollectionUtils.isNotEmpty(itemsAll)){
        		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    			for(Map.Entry<Long, Map<String, Object>> entity:tempMap.entrySet()){
        			items.add(entity.getValue());
        		}
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
    		}
    		
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 园区管理 Web 按面积统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    /**
     * 资源均价统计（园区管理 Web）
     * @param query
     * @return
     */
    @GET
    @Path("/resourceAvgPrice")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> resourceAvgPrice(@QueryParam("resInfoId") Long resTypeId) {
		try{
			//1.判断是否登录
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("parkId", parkId);
			
			//资源类型不能为空
			if(resTypeId == null){
				return new Result<Map<String,Object>>(ResultCode.BAD_ITEM_ID);
			}
			paramsMap.put("resTypeId", resTypeId);

			Map<String, Object> dataMap = new HashedMap<String, Object>();
			//2.计算平均价
			//2.1 资源平均基价
			Map<String,Object> resAvgBasicPriceMap = resourceInfoService.resAvgBasicPrice(paramsMap);
			dataMap.put("resAvgBasicPriceMap", new HashedMap<String, Object>());
			if(resAvgBasicPriceMap != null){
				//求均价
				Double sumArea = (Double)resAvgBasicPriceMap.get("sumArea");
				Double sumPrice = (Double)resAvgBasicPriceMap.get("sumPrice");
				BigDecimal sumAreaBigDecimal = new BigDecimal(sumArea.toString());
				BigDecimal sumPriceBigDecimal = new BigDecimal(sumPrice.toString());
				
				BigDecimal avgPrice = sumPriceBigDecimal.divide(sumAreaBigDecimal,2,BigDecimal.ROUND_HALF_UP);
				resAvgBasicPriceMap.put("avgPrice", avgPrice);
				dataMap.put("resAvgBasicPriceMap", resAvgBasicPriceMap);
			}
			//2.2 已出租资源平均价
			Map<String, Object> resAvgRentPriceMap = resourceInfoService.resAvgRentPrice(paramsMap);
			dataMap.put("resAvgRentPriceMap", new HashedMap<String, Object>());
			if(resAvgRentPriceMap != null){
				//求均价
				BigDecimal sumAreaBigDecimal = (BigDecimal)resAvgRentPriceMap.get("sumArea");
				BigDecimal sumPriceBigDecimal = (BigDecimal)resAvgRentPriceMap.get("sumPrice");
				
				BigDecimal avgPrice = sumPriceBigDecimal.divide(sumAreaBigDecimal,2,BigDecimal.ROUND_HALF_UP);
				resAvgRentPriceMap.put("avgPrice", avgPrice);
				
				dataMap.put("resAvgRentPriceMap", resAvgRentPriceMap);
			}
			//2.3 加权平均价
			Map<String, Object> resNoRentInfoMap = resourceInfoService.resNoRentInfo(paramsMap);
			Map<String, Object> resWeiAvgPriceMap = new HashedMap<String, Object>();
			if(resNoRentInfoMap != null && resAvgRentPriceMap != null){
				//求均价
				Double sumArea1 = (Double)resNoRentInfoMap.get("sumArea");
				BigDecimal sumArea2 = (BigDecimal)resAvgRentPriceMap.get("sumArea");
				BigDecimal sumArea3 = new BigDecimal(sumArea1);
				BigDecimal sumAreaBigDecimal = sumArea2.add(sumArea3);
				resWeiAvgPriceMap.put("sumArea", sumAreaBigDecimal);

				BigDecimal sumPrice1 = (BigDecimal)resNoRentInfoMap.get("sumPrice");
				BigDecimal sumPrice2 = (BigDecimal)resAvgRentPriceMap.get("sumPrice");
				BigDecimal sumPriceBigDecimal = sumPrice1.add(sumPrice2);
				resWeiAvgPriceMap.put("sumPrice", sumPriceBigDecimal);
				
				BigDecimal avgPrice = sumPriceBigDecimal.divide(sumAreaBigDecimal,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(365));
				resWeiAvgPriceMap.put("avgPrice", avgPrice);
			}else if(resNoRentInfoMap == null && resAvgRentPriceMap != null){
				//求均价
				BigDecimal sumAreaBigDecimal = (BigDecimal)resAvgRentPriceMap.get("sumArea");
				BigDecimal sumPriceBigDecimal = (BigDecimal)resAvgRentPriceMap.get("sumPrice");
				BigDecimal avgPrice = sumPriceBigDecimal.divide(sumAreaBigDecimal,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(365));
				resAvgRentPriceMap.put("avgPrice", avgPrice);
				
				resWeiAvgPriceMap.putAll(resAvgRentPriceMap);
			}else if(resNoRentInfoMap != null && resAvgRentPriceMap == null){
				//求均价
				Double sumArea = (Double)resNoRentInfoMap.get("sumArea");
				BigDecimal sumAreaBigDecimal = new BigDecimal(sumArea.toString());
				BigDecimal sumPriceBigDecimal = (BigDecimal)resNoRentInfoMap.get("sumPrice");
				BigDecimal avgPrice = sumPriceBigDecimal.divide(sumAreaBigDecimal,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(365));
				resNoRentInfoMap.put("avgPrice", avgPrice);
				
				resWeiAvgPriceMap.putAll(resNoRentInfoMap);
			}
			dataMap.put("resWeiAvgPriceMap", resWeiAvgPriceMap);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 园区管理 Web 按面积统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 园区获取其资源类型
     * @param parkId
     * @return
     */
    @GET
    @Path("/resInfos")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  resInfo(){
    	
	    try{
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Session session = getSessionQuietly();
	    	Long parkId = session.getPlatformId();
	    	if(parkId == null){
	    		return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
	    	}
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<ResInfo> resInfos = resInfoService.findAllByParkId(parkId);
	    	List<Map<String, Object>> resInfoList = new ArrayList<Map<String,Object>>();
	    	if(CollectionUtils.isNotEmpty(resInfos)){
	    		Map<String, Object> resInfoMap = null;
	    		for(ResInfo resInfo:resInfos){
	    			resInfoMap = new HashedMap<String, Object>();
	    			
	    			resInfoMap.put("id", resInfo.getId());
	    			resInfoMap.put("name", notNull(resInfo.getName()));
	    			
	    			resInfoList.add(resInfoMap);
	    		}
	    	}
	    	dataMap.put("items", resInfoList);
	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("园区获取其资源类型 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    /**
     * 园区入驻统计
     * @param parkId
     * @return
     */
    @GET
    @Path("/parkInfo")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  parkInfo(@QueryParam("type") String type){
    	/**
    	 * type:
    	 * 	按周统计：WEEKS
    	 * 	按月统计：MONTHS
    	 */
	    try{
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Map<String,Object> dataMap = new HashMap<String, Object>();
	    	List<Map<String, String>> dateList = providerTime(type);
	    	Map<String, Object> params = null;
	    	for(Map<String, String> itemMap:dateList){
	    		params = new HashedMap<String, Object>();
	    		params.put("startDate", itemMap.get("startDate"));
	    		params.put("endDate", itemMap.get("endDate"));
	    		
	    		Integer parkNum = parkInfoService.statisticsPark(params);
	    		dateConvert(itemMap);
	    		itemMap.put("parkNum", new Integer(0).toString());
	    		if(parkNum != null){
	    			itemMap.put("parkNum", parkNum.toString());
	    		}
	    	}
	    	dataMap.put("items", dateList);	    		
	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("园区获取其资源类型 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    /**
     * 园区入驻统计
     * @param parkId
     * @return
     */
    @GET
    @Path("/enterpriseInfo")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  enterpriseInfo(@QueryParam("type") String type){
    	/**
    	 * type:
    	 * 	按周统计：WEEKS
    	 * 	按月统计：MONTHS
    	 */
	    try{
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Map<String,Object> dataMap = new HashMap<String, Object>();
	    	List<Map<String, String>> dateList = providerTime(type);
	    	Map<String, Object> params = null;
	    	for(Map<String, String> itemMap:dateList){
	    		params = new HashedMap<String, Object>();
	    		params.put("startDate", itemMap.get("startDate"));
	    		params.put("endDate", itemMap.get("endDate"));
	    		Integer parkNum = enterpriseInfoService.enterpriseInfoStatistics(params);
	    		dateConvert(itemMap);
	    		itemMap.put("parkNum", new Integer(0).toString());
	    		if(parkNum != null){
	    			itemMap.put("parkNum", parkNum.toString());
	    		}
	    	}
	    	dataMap.put("items", dateList);	    		
	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("园区获取其资源类型 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    /**
     * 日期格式转换yyyy-MM-dd -> MM.dd
     * @param itemMap
     * @param targetMap
     * @throws Exception
     */
    private void dateConvert(Map<String,String> itemMap)throws Exception{
    	String startDateStr = itemMap.get("startDate");
		String endDateStr = itemMap.get("endDate");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(startDateStr);
		Date endDate = sdf.parse(endDateStr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd");
		startDateStr = dateFormat.format(startDate);
		endDateStr = dateFormat.format(endDate);
		itemMap.put("startDate", startDateStr);
		itemMap.put("endDate", endDateStr);
    }
    
    /**
     * 根据参数生成最近四周或四个月的日期区间
     * @param type
     * @return
     */
    private List<Map<String, String>> providerTime(String type){
    	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
    	Date now = new Date();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(now);
    	Map<String, String> map = null;
    	Date startDate = null;
    	Date endDate = null;
    	if(WEEKS.equals(type)){
    		map = new HashedMap<String, String>();
    		map.put("endDate", SystemUtil.dateFormatYYMMDD(now));
    		calendar.add(Calendar.DAY_OF_MONTH, -6);
    		startDate = calendar.getTime();
    		map.put("startDate", SystemUtil.dateFormatYYMMDD(startDate));
    		list.add(map);

    		for(int i=0;i<3;i++){
        		map = new HashedMap<String, String>();
        		calendar.add(Calendar.DAY_OF_MONTH, -1);
        		endDate = calendar.getTime();
        		map.put("endDate", SystemUtil.dateFormatYYMMDD(endDate));
        		calendar.add(Calendar.DAY_OF_MONTH,-6);
        		startDate = calendar.getTime();
        		map.put("startDate", SystemUtil.dateFormatYYMMDD(startDate));
        		list.add(map);
    		}
    	}else if(MONTHS.equals(type)){
    		map = new HashedMap<String, String>();
    		map.put("endDate", SystemUtil.dateFormatYYMMDD(now));
    		calendar.add(Calendar.DAY_OF_MONTH, -29);
    		startDate = calendar.getTime();
    		map.put("startDate", SystemUtil.dateFormatYYMMDD(startDate));
    		list.add(map);

    		for(int i=0;i<3;i++){
        		map = new HashedMap<String, String>();
        		calendar.add(Calendar.DAY_OF_MONTH, -1);
        		endDate = calendar.getTime();
        		map.put("endDate", SystemUtil.dateFormatYYMMDD(endDate));
        		calendar.add(Calendar.DAY_OF_MONTH,-29);
        		startDate = calendar.getTime();
        		map.put("startDate", SystemUtil.dateFormatYYMMDD(startDate));
        		list.add(map);
    		}
    	}
    	return list;
    }
    
    /**
     * 账单汇总统计
     * 		1.账单
     * 		2.费用项目
     * @param parkId
     * @return
     */
    @GET
    @Path("/billInfoCollect")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  billInfoCollect(
    		@QueryParam("type") String type,
    		@QueryParam("billMonth") String billMonth,
    		@QueryParam("companyId") Long companyId,
    		@QueryParam("contractId") Long contractId){
    	/**
    	 * type:
    	 * 	按账单统计：BILLINFO
    	 * 	按费用项目统计：SERVICEPROJECT
    	 */
	    try{
	    	//1.判断是否登录
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Session session = getSessionQuietly();
	    	Long parkId = session.getPlatformId();
	    	Map<String,Object> params = new HashMap<String, Object>(); 
	    	params.put("parkId", parkId);
	    	params.put("billMonth", billMonth);
	    	params.put("companyId", companyId);
	    	params.put("contractId", contractId);
	    	
	    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	    	Map<String, Object> item = null;
	    	//1.按账单统计
	    	if(BILL_INFO.equals(type)){
	    		BigDecimal percent = new BigDecimal(0);
	    		//累计欠款
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "累计欠款");
	    		BigDecimal addUpDebt = billInfoService.addUpDebt(params);
	    		item.put("totalMoney", addUpDebt);
	    		item.put("percent", 1);
	    		items.add(item);
	    		
	    		//欠款本期到账
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "欠款本期到账");
	    		BigDecimal repayDebt = billInfoService.repayDebt(params);
	    		item.put("totalMoney", repayDebt);
	    		if(addUpDebt.compareTo(percent) == 1){
		    		percent = repayDebt.divide(addUpDebt,2,BigDecimal.ROUND_HALF_UP);
	    		}
	    		item.put("percent", percent);
	    		items.add(item);
	    		
	    		//本期应收总额
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "本期应收总额");
	    		BigDecimal totalAmount = billInfoService.totalAmount(params);
	    		item.put("totalMoney", totalAmount);
	    		item.put("percent", 1);
	    		items.add(item);
	    		
	    		//本期已核销总额
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "本期已核销总额");
	    		BigDecimal alreadyVerification = billInfoService.alreadyVerification(params);
	    		item.put("totalMoney", alreadyVerification);
	    		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
		    		percent = alreadyVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
	    		}else{
	    			percent = new BigDecimal(0);
	    		}
	    		item.put("percent", percent);
	    		items.add(item);
	    		
	    		//本期已挂起总额
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "本期已挂起总额");
	    		BigDecimal suspendVerification = billInfoService.suspendVerification(params);
	    		item.put("totalMoney", suspendVerification);
	    		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
		    		percent = suspendVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
	    		}else{
	    			percent = new BigDecimal(0);
	    		}
	    		item.put("percent", percent);
	    		items.add(item);

	    		//本期待核销总额
	    		item = new HashedMap<String, Object>();
	    		item.put("title", "本期待核销总额");
	    		BigDecimal waitVerification = billInfoService.waitVerification(params);
	    		item.put("totalMoney", waitVerification);
	    		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
		    		percent = waitVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
	    		}else{
	    			percent = new BigDecimal(0);
	    		}
	    		item.put("percent", percent);
	    		items.add(item);
	    	}
	    	//2.按费用项目统计
	    	else if(SERVICE_PROJECT.equals(type)){
	    		//1.获取当前园区所有的费用项目项（不区分启用、禁用）
	    		CostPro costProQuery = new CostPro();
	    		costProQuery.setParkId(parkId);
	    		List<CostPro> costProList = costProService.findByObj(costProQuery);
	    		Map<String, Map<String, Object>> itemsMap = new HashedMap<String, Map<String,Object>>();
	    		if(CollectionUtils.isNotEmpty(costProList)){
	    			Map<String, Object> itemMap = null;
	    			for(CostPro costPro:costProList){
	    				itemMap = new HashedMap<String, Object>();
	    				itemMap.put("title", costPro.getName());
	    				itemMap.put("totalMoney", new BigDecimal(0));
	    				itemMap.put("percent",  new BigDecimal(0));
	    				itemMap.put("verificationMoney",  new BigDecimal(0));

	    				itemsMap.put(costPro.getName(), itemMap);
	    			}
	    		}
	    		//2.统计已生成账单的费用项目项
		    	items = billInfoService.statisticsByCostPro(params);
		    	if(CollectionUtils.isNotEmpty(items)){
		    		BigDecimal percent;
		    		for(Map<String, Object> itemMap:items){
		    			BigDecimal totalMoney = (BigDecimal)itemMap.get("totalMoney");
		    			BigDecimal verifyMoney = (BigDecimal)itemMap.get("verifyMoney");
		    			if(totalMoney != null && verifyMoney != null && totalMoney.compareTo(new BigDecimal(0)) == 1){
			    			percent = verifyMoney.divide(totalMoney,2,BigDecimal.ROUND_HALF_UP);
		    			}else{
		    				percent = new BigDecimal(0);
		    			}
		    			itemMap.put("percent", percent);
		    			
		    			//3.更新列表数据
		    			itemsMap.put((String)itemMap.get("title"), itemMap);
		    		}
		    	}
		    	
		    	//4.合并数据
		    	List<Map<String, Object>> newItems = new ArrayList<Map<String,Object>>();
		    	for(Map.Entry<String, Map<String, Object>> entry:itemsMap.entrySet()){
		    		newItems.add(entry.getValue());
		    	}
		    	items = newItems;
		    	
	    	}
	    	Map<String,Object> dataMap = new HashMap<String, Object>();
	    	dataMap.put("items", items);
	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("园区获取其资源类型 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    /**
     * 账单明细统计
     * 		1.账单
     * 		2.费用项目
     * @param parkId
     * @return
     */
    @GET
    @Path("/billInfoDetail")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  billInfoDetail(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("page") Integer pageNum,
    		@QueryParam("type") String type,
    		@QueryParam("billMonth") String billMonth,
    		@QueryParam("companyId") Long companyId,
    		@QueryParam("contractId") Long contractId){
    	/**
    	 * type:
    	 * 	按账单统计：BILLINFO
    	 * 	按费用项目统计：SERVICEPROJECT
    	 */
	    try{
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	//1.判断是否登录
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Session session = getSessionQuietly();
	    	Long parkId = session.getPlatformId();
	    	
	    	//2.分页获取合同号
    		ContractInfoQuery contractInfoQuery = new ContractInfoQuery();
    		contractInfoQuery.setParkId(parkId);
    		contractInfoQuery.setBillMonth(billMonth);
    		contractInfoQuery.setCompanyId(companyId);
    		contractInfoQuery.setContractId(companyId);
    		contractInfoQuery.setLimit(limit);
    		contractInfoQuery.setOffset(offset);
    		contractInfoQuery.setPage(pageNum);
    		Page<Map<String, Object>> page = contractInfoService.findByBillMonthAndEnterpriseIdAndContractId(contractInfoQuery);

    		dataMap.put("limit", page.getLimit());
			dataMap.put("offset", page.getOffset());
			dataMap.put("total", page.getTotal());
		
    		//3.当合同为空时
    		List<Map<String, Object>> itemsMap = page.getItems();
    		if(CollectionUtils.isEmpty(itemsMap)){
				dataMap.put("items", new ArrayList<Map<String, Object>>());
				return new Result<Map<String,Object>>(ResultCode.STATISTICS_ITEM_NULL,dataMap);
    			
    		}

    		//3.分别获取合同对应的（账单、费用项目）（账单日期）
    		for(Map<String, Object> itemMap:itemsMap){
        		//1.按账单统计
    			contractId = (Long)itemMap.get("contractId");
    			companyId = (Long)itemMap.get("companyId");
    	    	if(BILL_INFO.equals(type)){
    				Map<String,Object> temp = getContractBills(parkId, billMonth, contractId, companyId);
    				itemMap.putAll(temp);
    	    	}	    	//2.按费用项目统计
    	    	else if(SERVICE_PROJECT.equals(type)){
    	    		List<Map<String,Object>> tempList = getContractCostPro(parkId, billMonth, contractId, companyId);	
    	    		itemMap.put("costProList", tempList);
    	    	}
    		}
	    	dataMap.put("items", itemsMap);
    		
    		//4.当为费用项目类型时获取所有费用项目的排序
    		if(SERVICE_PROJECT.equals(type)){
    	    	//1.获取当前园区所有的费用项目项（不区分启用、禁用）
    			CostPro costProQuery = new CostPro();
    			costProQuery.setParkId(parkId);
    			List<CostPro> costProList = costProService.findByObj(costProQuery);
    			if(CollectionUtils.isNotEmpty(costProList)){
    				List<String> tableTitle = new ArrayList<String>();
    				for(CostPro costPro:costProList){
    					tableTitle.add(costPro.getName() + TOTAL_MONEY);
    					tableTitle.add("已收款金额");
    				}
    				
    				dataMap.put("tableTitle", tableTitle);
    			}
    		}
	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("账单明细统计 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    /**
     * 指定期间的应收/已核销占比饼图展示
     * @return
     */
    @GET
    @Path("/web/billInfo")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  billInfo(
    		@NotNull @QueryParam("billMonth") String billMonth){

    	Map<String, Object> dataMap = new HashedMap<String, Object>();
    	
    	//1.判断是否登录
    	if(sessionIsNull()){
    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
    	}
    	Session session = getSessionQuietly();
    	Long parkId = session.getPlatformId();
    	Map<String,Object> params = new HashMap<String, Object>(); 
    	params.put("parkId", parkId);
    	params.put("billMonth", billMonth);
    	
		//本期应收总额
		BigDecimal totalAmount = billInfoService.totalAmount(params);
		dataMap.put("totalAmount", totalAmount);
		
		//本期已核销总额
		BigDecimal alreadyVerification = billInfoService.alreadyVerification(params);
		dataMap.put("alreadyVerification", alreadyVerification);

		BigDecimal percent = new BigDecimal(0);
		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
    		percent = alreadyVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
		}else{
			percent = new BigDecimal(0);
		}
		dataMap.put("percent", percent);
    
    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    }

    /**
     * 当前年1月 ~ 截止当前月份的累计应收/欠款占比饼图展示
     * @return
     */
    @GET
    @Path("/web/billInfos")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  billInfos(){

    	Map<String, Object> dataMap = new HashedMap<String, Object>();
    	//1.判断是否登录
    	if(sessionIsNull()){
    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
    	}

    	Session session = getSessionQuietly();
    	Long parkId = session.getPlatformId();
    	Map<String,Object> params = new HashMap<String, Object>(); 
    	params.put("parkId", parkId);
    	params.put("billMonth", getMonthStr(getMonths()));
    	
		//当前年应收总额
		BigDecimal totalAmount = billInfoService.totalAmountYear(params);
		dataMap.put("totalAmountMoney", totalAmount);
		
		
		//当前年累计欠款
		BigDecimal addUpDebt = billInfoService.addUpDebtYear(params);
    	dataMap.put("addUpDebtMoney", addUpDebt);

    	BigDecimal percent = new BigDecimal(0);
    	if(addUpDebt != null && totalAmount != null && percent.compareTo(addUpDebt) == -1){
    		percent = addUpDebt.divide(totalAmount, 2, BigDecimal.ROUND_HALF_UP);
    	}
    	dataMap.put("percent", percent);
    
    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    }
    
    private List<Map<String, Object>> getContractCostPro(Long parkId,String billMonth,Long contractId,Long companyId){
    	//1.获取当前园区所有的费用项目项（不区分启用、禁用）
		CostPro costProQuery = new CostPro();
		costProQuery.setParkId(parkId);
		List<CostPro> costProList = costProService.findByObj(costProQuery);
		Map<String, Map<String, Object>> costProAllMap = new HashedMap<String, Map<String,Object>>();
		List<Map<String, Object>> costProAllList = new ArrayList<Map<String,Object>>();
		if(CollectionUtils.isNotEmpty(costProList)){
			Map<String, Object> costProMap = null;
			for(CostPro costPro:costProList){
				costProMap = new HashedMap<String, Object>();
				costProMap.put("title", costPro.getName() + TOTAL_MONEY);
				costProMap.put("money", new BigDecimal(0));

				costProAllMap.put(costPro.getName() + TOTAL_MONEY, costProMap);
				costProAllList.add(costProMap);

				
				costProMap = new HashedMap<String, Object>();
				costProMap.put("title",  costPro.getName() + GATHERING_MONEY);
				costProMap.put("money",  new BigDecimal(0));

				costProAllMap.put(costPro.getName() + GATHERING_MONEY, costProMap);
				costProAllList.add(costProMap);
			}
			
//			for(CostPro costPro:costProList){
//				costProMap = new HashedMap<String, Object>();
//				costProMap.put("title", costPro.getName());
//				costProMap.put("totalMoney", new BigDecimal(0));
//				costProMap.put("percent",  new BigDecimal(0));
//				costProMap.put("verificationMoney",  new BigDecimal(0));
//
//				costProAllMap.put(costPro.getName(), costProMap);
//				costProAllList.add(costProMap);
//			}
		}
		
		//2.统计已生成账单的费用项目
		Map<String,Object> params = new HashMap<String, Object>(); 
    	params.put("parkId", parkId);
    	params.put("billMonth", billMonth);
    	params.put("companyId", companyId);
    	params.put("contractId", contractId);
    	List<Map<String, Object>> itemListMap = billInfoService.statisticsByCostPro(params);
    	
    	//3.当为空时
    	if(CollectionUtils.isEmpty(itemListMap)){
    		return costProAllList;
    	}

    	//4.
    	Map<String, Object> tempMap = null;
    	for(Map<String, Object> item:itemListMap){
    		tempMap = new HashedMap<String, Object>();
			BigDecimal totalMoney = (BigDecimal)item.get("totalMoney");
			tempMap.put("title", item.get("title") + TOTAL_MONEY);
			tempMap.put("money", totalMoney);
			costProAllMap.put((String)item.get("title")+TOTAL_MONEY, item);

			tempMap = new HashedMap<String, Object>();
			BigDecimal verifyMoney = (BigDecimal)item.get("verifyMoney");
			tempMap.put("title", item.get("title") + GATHERING_MONEY);
			tempMap.put("money", verifyMoney);
			costProAllMap.put((String)item.get("title") + GATHERING_MONEY, item);
			
//			BigDecimal percent = new BigDecimal(0);
//			if(totalMoney != null && verifyMoney != null && totalMoney.compareTo(percent) == 1){
//    			percent = verifyMoney.divide(totalMoney,2,BigDecimal.ROUND_HALF_UP);
//			}
//			item.put("percent", percent);
			
			//3.更新列表数据
		}
		
    	//4.合并数据
    	List<Map<String, Object>> newItems = new ArrayList<Map<String,Object>>();
    	for(Map.Entry<String, Map<String, Object>> entry:costProAllMap.entrySet()){
    		newItems.add(entry.getValue());
    	}
    	return newItems;
    }
    
    //获取单个账单的情况
    private Map<String, Object> getContractBills(Long parkId,String billMonth,Long contractId,Long companyId){
    	
    	Map<String, Object> params = new HashMap<String, Object>(); 
    	params.put("parkId", parkId);
    	params.put("billMonth", billMonth);
    	params.put("companyId", companyId);
    	params.put("contractId", contractId);
    	
    	BigDecimal percent = new BigDecimal(0);
		//累计欠款
		Map<String, Object> item = new HashedMap<String, Object>();
		item.put("addUpDebtTitle", "累计欠款");
		BigDecimal addUpDebt = billInfoService.addUpDebt(params);
		item.put("addUpDebtMoney", addUpDebt);
		item.put("addUpDebtPercent", 1);
		
		//欠款本期到账
		item.put("repayDebtTitle", "欠款本期到账");
		BigDecimal repayDebt = billInfoService.repayDebt(params);
		item.put("repayDebtMoney", repayDebt);
		if(addUpDebt.compareTo(percent) == 1){
    		percent = repayDebt.divide(addUpDebt,2,BigDecimal.ROUND_HALF_UP);
		}
		item.put("repayDebtPercent", percent);
		
		//本期应收总额
		item.put("totalAmountTitle", "本期应收总额");
		BigDecimal totalAmount = billInfoService.totalAmount(params);
		item.put("totalAmountMoney", totalAmount);
		item.put("totalAmountPercent", 1);
		
		//本期已核销总额
		item.put("alreadyVerificationTitle", "本期已核销总额");
		BigDecimal alreadyVerification = billInfoService.alreadyVerification(params);
		item.put("alreadyVerificationMoney", alreadyVerification);
		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
    		percent = alreadyVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
		}else{
			percent = new BigDecimal(0);
		}
		item.put("alreadyVerificationPercent", percent);
		
		//本期已挂起总额
		item.put("suspendVerificationTitle", "本期已挂起总额");
		BigDecimal suspendVerification = billInfoService.suspendVerification(params);
		item.put("suspendVerificationMoney", suspendVerification);
		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
    		percent = suspendVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
		}else{
			percent = new BigDecimal(0);
		}
		item.put("suspendVerificationPercent", percent);

		//本期待核销总额
		item.put("waitVerificationTitle", "本期待核销总额");
		BigDecimal waitVerification = billInfoService.waitVerification(params);
		item.put("waitVerificationMoney", waitVerification);
		if(totalAmount.compareTo(new BigDecimal(0)) == 1){
    		percent = waitVerification.divide(totalAmount,2,BigDecimal.ROUND_HALF_UP);
		}else{
			percent = new BigDecimal(0);
		}
		item.put("waitVerificationPercent", percent);
		
		return item;
    }
    
    
    /**
     * 收缴完成率
     * @param parkId
     * @return
     */
    @GET
    @Path("/app/payment")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>>  payment(@QueryParam("page") Integer pageNum){
	    try{
	    	Map<String, Object> dataMap = new HashMap<String, Object>();
	    	//1.判断是否登录
	    	if(sessionIsNull()){
	    		return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	    	}
	    	Session session = getSessionQuietly();
	    	Long parkId = session.getPlatformId();
	    	
	    	//2.pageNum 不能为空，默认为 1
	    	if(pageNum == null || !(pageNum > 0)){
	    		pageNum = 1;
	    	}
	    	
	    	//3.获取月份
	    	List<Map<String, String>> billMonths = providerMonths(pageNum);

	    	//4.
	    	dataMap.put("page", pageNum);
	    	List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
	    	Map<String, Object> resultMap = null;
	    	Map<String, Object> params = null;
	    	for(Map<String, String> monthMap:billMonths){
	    		params = new HashedMap<String, Object>();
	    		params.put("billMonth", monthMap.get("billMonth"));
	    		params.put("parkId", parkId);
	    		
	    		//已核销账单金额
	    		BigDecimal alreadyWrittenMoney = billInfoService.findAlreadyWrittenMoney(params);
	    		
	    		//已挂起部分的核销金额
	    		BigDecimal alreadySuspen = billInfoService.findAlreadySuspen(params);
	    		
	    		//已完结部分的核销金额
	    		BigDecimal alreadyFinished = billInfoService.findAlreadyFinished(params);
	    		
	    		//单月账单总额
	    		BigDecimal totalMoney = billInfoService.findTotalMoney(params);
	    		
	    		//占比
	    		BigDecimal percent = new BigDecimal(0);
	    		if(totalMoney.compareTo(new BigDecimal(0)) == 1){
		    		percent = totalMoney.divide(alreadyWrittenMoney.add(alreadySuspen).add(alreadyFinished),2,BigDecimal.ROUND_HALF_UP);
	    		}
	    		
	    		resultMap = new HashMap<String, Object>();
	    		resultMap.put("billMonth", monthMap.get("billMonth"));
	    		resultMap.put("dateTitle", monthMap.get("dateTitle"));
	    		resultMap.put("percent", percent);
	    		resultList.add(resultMap);
	    	}
	    	dataMap.put("items", resultList);

	    	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
	    }catch(Exception e){
	    	logger.error("园区获取其资源类型 error：{}",e);
	    	return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
	    }
    }
    
    private List<Map<String,String>> providerMonths(Integer pageNum){
    	List<Map<String, String>> months = new ArrayList<Map<String,String>>();
    	if(pageNum == null || !(pageNum > 0)){
    		pageNum = 1;
    	}
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, 1);
    	
    	String dateStr;
    	String dateTitle;
    	int offset = 4*(pageNum - 1);
    	calendar.add(Calendar.MONTH, offset*(-1));
    	Map<String, String> monthMap = null;
    	for(int i=0;i<4;i++){
    		monthMap = new HashedMap<String, String>();
    		calendar.add(Calendar.MONTH, -1);
    		dateStr = SystemUtil.dateFormat(calendar.getTime(), "yyyy-MM");
    		monthMap.put("billMonth", dateStr);
    		dateTitle = SystemUtil.dateFormat(calendar.getTime(), "MM");
    		monthMap.put("dateTitle", dateTitle);
    		
    		months.add(monthMap);
    	}
    	return months;
    }
    
    /**
     * 资源出租率（园区管理 App 首页）
     * @param query
     * @return
     */
    @GET
    @Path("/app/resourceByAreaAndNum")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> appResourceByAreaAndNum() {
		try{
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	List<Map<String, Object>> items = serviceProjectService.statisticsByReadNum();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());
    		if(CollectionUtils.isNotEmpty(items)){
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
	    	}
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 园区管理 Web 按面积统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 资源出租率（企业 app 按数量）
     * @param query
     * @return
     */
    @GET
    @Path("/app/resourceByNum")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> appResourceByNum() {
    	try{
			//1.判断是否登录
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("parkId", parkId);

			//2.按面积统计
	    	List<Map<String, Object>> itemsAll = resourceInfoService.resOfNumAll(paramsMap);
	    	List<Map<String, Object>> itemsUse = resourceInfoService.resOfNumUse(paramsMap);
    		Map<Long, Map<String, Object>> tempMap = new HashedMap<Long, Map<String,Object>>();
    		//2.1 已使用面积
    		if(CollectionUtils.isNotEmpty(itemsUse)){
    			for(Map<String, Object> itemMap:itemsUse){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				tempMap.put(resTypeId, itemMap);
    			}
	    	}
    		//2.2 总数量
    		if(CollectionUtils.isNotEmpty(itemsAll)){
    			for(Map<String, Object> itemMap:itemsAll){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				Map<String, Object> map = tempMap.get(resTypeId);
    				if(map != null){
        				itemMap.putAll(map);
        				
        				Long sumNumAllLong = (Long)itemMap.get("sumNumAll");
        				Long sumNumUseLong = (Long)itemMap.get("sumNumUse");
        				
        				BigDecimal sumNumAll = new BigDecimal(sumNumAllLong.toString());
        				BigDecimal sumNumUse = new BigDecimal(sumNumUseLong.toString());
        				
        				if(sumNumAll != null && sumNumAll.compareTo(new BigDecimal(0)) == 1){
        					itemMap.put("percent", sumNumUse.divide(sumNumAll,2,BigDecimal.ROUND_HALF_UP));
        					itemMap.put("avgPrice", 0);
        				}else{
        					itemMap.put("percent", 0);
        					itemMap.put("avgPrice", 0);
        				}
    				}else{
    					itemMap.put("sumNumUse", 0);
    					itemMap.put("percent", 0);
    					itemMap.put("avgPrice", 0);
    				}
					tempMap.put(resTypeId, itemMap);
    			}
    		}
    		//2.3 封装统计结果
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());

    		if(CollectionUtils.isNotEmpty(itemsAll)){
        		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    			for(Map.Entry<Long, Map<String, Object>> entity:tempMap.entrySet()){
        			items.add(entity.getValue());
        		}
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
    		}
    		
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 企业 app 按数量统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 资源出租率（企业 app 按面积）
     * @param query
     * @return
     */
    @GET
    @Path("/app/resourceByArea")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> appResourceByArea() {
		try{
			//1.判断是否登录
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			if(parkId == null){
				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
			}
			Map<String, Object> paramsMap = new HashedMap<String, Object>();
			paramsMap.put("parkId", parkId);

			//2.按面积统计
	    	List<Map<String, Object>> itemsAll = resourceInfoService.resOfAreaAll(paramsMap);
	    	List<Map<String, Object>> itemsUse = resourceInfoService.resOfAreaUse(paramsMap);
    		Map<Long, Map<String, Object>> tempMap = new HashedMap<Long, Map<String,Object>>();
    		//2.1 已使用面积
    		if(CollectionUtils.isNotEmpty(itemsUse)){
    			for(Map<String, Object> itemMap:itemsUse){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				tempMap.put(resTypeId, itemMap);
    			}
	    	}
    		//2.2 总面积
    		if(CollectionUtils.isNotEmpty(itemsAll)){
    			for(Map<String, Object> itemMap:itemsAll){
    				Long resTypeId = (Long)itemMap.get("resTypeId");
    				Map<String, Object> map = tempMap.get(resTypeId);
    				if(map != null){
        				itemMap.putAll(map);
        				
        				Double sumAreaAllDouble = (Double)itemMap.get("sumAreaAll");
        				Double sumAreaUseDouble = (Double)itemMap.get("sumAreaUse");
        				
        				BigDecimal sumAreaAll = new BigDecimal(sumAreaAllDouble.toString());
        				BigDecimal sumAreaUse = new BigDecimal(sumAreaUseDouble.toString());
        				
        				if(sumAreaAll != null && sumAreaAll.compareTo(new BigDecimal(0)) == 1){
        					itemMap.put("percent", sumAreaUse.divide(sumAreaAll,2,BigDecimal.ROUND_HALF_UP));
        				}else{
        					itemMap.put("percent", 0);
        				}
    				}else{
    					itemMap.put("sumAreaUse", 0);
    					itemMap.put("percent", 0);
    				}
    				tempMap.put(resTypeId, itemMap);
    			}
    		}
    		//2.3 封装统计结果
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("offset", 0);
	    	dataMap.put("limit", 10);
    		dataMap.put("total", 0);
    		dataMap.put("items", new ArrayList<Map<String,Object>>());

    		if(CollectionUtils.isNotEmpty(itemsAll)){
        		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    			for(Map.Entry<Long, Map<String, Object>> entity:tempMap.entrySet()){
        			items.add(entity.getValue());
        		}
    			dataMap.put("total", items.size());
    			dataMap.put("items", items);
    		}
    		
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			logger.error("资源 --- 企业 App 按面积统计 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 获取当前年当前月份之前的月份
     * @return
     */
	private List<String> getMonths(){
		List<String> months = new ArrayList<String>();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int monthNum = calendar.get(Calendar.MONTH);
		months.add(SystemUtil.dateFormat(calendar.getTime(), "yyyy-MM"));
		for(;monthNum>0;monthNum--){
			calendar.add(Calendar.MONTH, -1);
			months.add(SystemUtil.dateFormat(calendar.getTime(), "yyyy-MM"));
		}
		return months;
	}
	
	/**
	 * 获取月份的字符串
	 * @param months
	 * @return
	 */
	private String getMonthStr(List<String> months){
		if(CollectionUtils.isEmpty(months)){
			return null;
		}
		StringBuilder monthStr = new StringBuilder("(");
		for(int i=0;i<months.size();i++){
			monthStr.append("'");
			monthStr.append(months.get(i));
			monthStr.append("'");
			
			if(i != months.size()-1)
				monthStr.append(",");
		}
		monthStr.append(")");

		return monthStr.toString();
	}
}
