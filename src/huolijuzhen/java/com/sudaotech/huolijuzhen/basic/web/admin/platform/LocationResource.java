package com.sudaotech.huolijuzhen.basic.web.admin.platform;

import java.util.ArrayList;
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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.LocationService;
import com.sudaotech.huolijuzhen.basic.service.LocationService.Location;
import com.sudaotech.huolijuzhen.basic.service.LocationService.Query;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/location")
public class LocationResource extends BusinessBaseResource {

    @Inject
    private LocationService locationService;
    @Inject
    private AreaService areaService;

    @Inject
    private ParkInfoService parkInfoService;

    /**
     * 添加行政位置
     *
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Location obj) {
        // create
        try {
        	if(sessionIsNull()){
        		return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
        	}
        	Session session = getSessionQuietly();
        	
            Location temp = extractValidInfo(obj);
            temp.setOperator(session.getUserId());

            Long id = locationService.create(obj);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/location/%s", id));
            result.setData(map);
            return result;

        } catch (Exception e) {
            logger.error("添加行政位置：{0}", e);
            return new Result<Map<String, Long>>(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 编辑行政位置信息
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
            @Valid final Location obj) {
    	
    	try{
    		if(sessionIsNull()){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
			Location temp = extractValidInfo(obj);
			temp.setId(id);
			temp.setOperator(session.getUserId());
            locationService.update(obj);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Location obj = new Location();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	if (!CollectionUtils.isEmpty(ids)) {
			for (Long id : ids) {
				delete(id);
			}
    	}
        return ResultSupport.ok();
    }

    /**
     * 根据 ID 获取行政区域的详细信息
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            Location obj = locationService.getById(id);
            
            Map<String, Object> dataMap = packItemInfo(obj);
            
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 根据 ID 获取行政区域的详细信息
     * @param id
     * @return
     */
    @POST
    @Path("/isExist")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> isExist(final Location location) {
    	try{
            Map<String, Object> dataMap = new HashMap<String, Object>();
            List<Long> ids = locationService.isExist(location);
            if(CollectionUtils.isEmpty(ids)){
            	dataMap.put("isExist", true);
            }else{
            	dataMap.put("isExist", false);
            }
            return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 启用
     * @param id
     * @return
     */
    @PUT
    @Path("/start/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> start(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		if(sessionIsNull()){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
    		Location obj = new Location();
        	Date now = new Date();
        	Long userId = session.getUserId();
        	obj.setOperator(userId);
            obj.setId(id);
            obj.setEnableStatus(EnableStatus.ENABLE);
            obj.setEnableBy(userId);
            obj.setEnableTime(now);
            locationService.update(obj);
            
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("启用 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 禁用
     * @param id
     * @return
     */
    @PUT
    @Path("/forbidden/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> forbidden(
            @NotNull @PathParam("id") final Long id) {
    	
    	try{
        	if(sessionIsNull()){
        		return new Result<String>(ResultCode.SESSION_IS_NULL);
        	}
        	Session session = getSessionQuietly();
    		
    		Location obj = new Location();
        	Date now = new Date();
        	Long userId = session.getUserId();
        	obj.setOperator(userId);
            obj.setId(id);
            obj.setEnableStatus(EnableStatus.DISABLE);
            obj.setDisableBy(userId);
            obj.setDisableTime(now);
            locationService.update(obj);

            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("警用 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    
    /**
     * 按条件查询
     *
     * @param offset
     * @param cityId
     * @param pages
     * @param limit
     * @param counId
     * @param proId
     * @return
     */
    @GET
    @Path("/parkInfoList")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<ParkInfoService.ParkInfo>> findParkInfoList(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("proId") Long proId,
            @QueryParam("cityId") Long cityId,
            @QueryParam("counId") Long counId,
            @QueryParam("locationId") Long locationId) {
    	
    	try{
            Query query = new Query();
            query.setOffset(offset);
            query.setLimit(limit);
            query.setPage(pages);
            query.setProId(proId);
            query.setCityId(cityId);
            query.setCounId(counId);
            query.setLocationId(locationId);
            Page<Location> locationPage = locationService.findByCondition(query);
            List<ParkInfoService.ParkInfo> parkInfoList = new ArrayList<>();
            if (locationPage.getItems() != null && locationPage.getItems().isEmpty() == false) {
                for (Location location : locationPage.getItems()) {
                    parkInfoList.add(this.parkInfoService.getByPositionId(location.getId()));//add obj to list
                }
            }
            return new Result<>(ResultCode.OK, parkInfoList);
    	}catch(Exception e){
    		logger.error("按条件搜索园区 error:{}",e);
    		return new Result<List<ParkInfoService.ParkInfo>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按条件查询
     *
     * @param query
     * @return
     */
    @GET
    @Path("/find")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("proId") Long proId,
            @QueryParam("cityId") Long cityId,
            @QueryParam("counId") Long counId,
            @QueryParam("enableStatus") String enableStatus) {
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);
    		query.setProId(proId);
    		query.setCityId(cityId);
    		query.setCounId(counId);
    		query.setEnableStatus(enableStatus);
    		
    		//1.按条件查询活动
    		Page<Location> page = locationService.findByCondition(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Location> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Location comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        		dataMap.put("items", items);
        	}
        	
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 按条件查询
     * @param query
     * @return
     */
    @POST
    @Path("/findByCondition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findByCondition(
            @Valid final Query query) {
    	try{
    		//1.按条件查询活动
    		Page<Location> page = locationService.findByCondition(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Location> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Location comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        		dataMap.put("items", items);
        	}
        	
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 获取行政区内所有的省份信息
     * @return
     */
    @GET
    @Path("/findProvince")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String, Object>>> findProvince(){
    	
    	try{
    	   	//1.获取当前行政区表中所包含的所有的省份的 ID
        	List<Long> ids = new ArrayList<Long>();
        	ids = locationService.findAllProvince();
        	if(CollectionUtils.isEmpty(ids)){
            	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
            }
        	//2.根据省份 ID 取 area 表获取所有的省份信息
        	List<Area> list = new ArrayList<Area>();
            Area area = null;
            for(Long id:ids){
            	area = this.areaService.getArea(Integer.parseInt(id.toString()));
            	list.add(area);
            }
        	
        	//3.将省份信息分装到结果集
            List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        	Map<String, Object> dataMap = null;
        	for(Area item:list){
        		dataMap = new HashedMap<String, Object>();
        		dataMap.put("id", Long.parseLong(item.getAreaId().toString()));
        		dataMap.put("name",item.getName());
        		
        		dataList.add(dataMap);
        	}
        	if(dataMap.size() > 0){
            	return new Result<List<Map<String,Object>>>(ResultCode.OK,dataList);    		
        	}
        	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
        		
    	}catch(Exception e){
    		logger.error("获取行政区内所有省份 error:{}",e);
    		return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 根据所选省份获取当前行政区表内的对应的所有的城市
     * @param proId
     * @return
     */
    @GET
    @Path("/findCity/{proId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String,Object>>> findCity(
    		@PathParam("proId") Long proId){
    	
    	try{
        	//1.获取当前行政区表中指定 省份(ID) 下的所有城市
        	List<Long> ids = new ArrayList<Long>();
        	ids = locationService.findCityByProvinceId(proId);
        	if(CollectionUtils.isEmpty(ids)){
            	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
            }
        	//2.根据城市 ID 去 area 表获取所对应的城市信息
        	List<Area> list = new ArrayList<Area>();
            Area area = null;
            for(Long id:ids){
            	area = this.areaService.getArea(Integer.parseInt(id.toString()));
            	list.add(area);
            }
        	
        	//3.将城市信息分装到结果集
            List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        	Map<String, Object> dataMap = null;
        	for(Area item:list){
        		dataMap = new HashedMap<String, Object>();
        		dataMap.put("id", Long.parseLong(item.getAreaId().toString()));
        		dataMap.put("name",item.getName());
        		
        		dataList.add(dataMap);
        	}
        	if(dataMap.size() > 0){
            	return new Result<List<Map<String,Object>>>(ResultCode.OK,dataList);    		
        	}
        	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
    		
    	}catch(Exception e){
    		logger.error("获取行政区内指定省份的所有城市 error:{}",e);
    		return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 根据所选城市，获取当前行政区表对应的所有的县区信息
     * @param cityId
     * @return
     */
    @GET
    @Path("/findCountory/{cityId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String, Object>>> findCountory(
    		@PathParam("cityId") Long cityId){
    	
    	try{
        	//1.获取当前行政区表中指定 城市(ID) 下的所有县区
        	List<Long> ids = new ArrayList<Long>();
        	ids = locationService.findCountoryBycityId(cityId);
        	if(CollectionUtils.isEmpty(ids)){
            	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
            }
        	//2.根据县区 ID 去 area 表获取所对应的县区信息
        	List<Area> list = new ArrayList<Area>();
            Area area = null;
            for(Long id:ids){
            	area = this.areaService.getArea(Integer.parseInt(id.toString()));
            	list.add(area);
            }
        	
        	//3.将县区信息分装到结果集
            List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        	Map<String, Object> dataMap = null;
        	for(Area item:list){
        		dataMap = new HashedMap<String, Object>();
        		dataMap.put("id", Long.parseLong(item.getAreaId().toString()));
        		dataMap.put("name",item.getName());
        		
        		dataList.add(dataMap);
        	}
        	if(dataMap.size() > 0){
            	return new Result<List<Map<String,Object>>>(ResultCode.OK,dataList);    		
        	}
        	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
    		
    	}catch(Exception e){
    		logger.error("获取行政区内指定城市的所有县区 error:{}",e);
    		return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
   
    /**
     * 据县区 ID 获取商业圈
     * @param counId
     * @return
     */
    @GET
    @Path("/findBusiness/{counId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String,Object>>> findBusiness(
    		@PathParam("counId") Long counId){
    	try{
        	//1.根据 县区 ID 获取当前行政区内属于该县区内所有的商业区
        	List<Map<String, Object>> locationList = new ArrayList<Map<String, Object>>();
        	locationList = locationService.findBusinessByCounId(counId);
        	
        	if(CollectionUtils.isNotEmpty(locationList)){
        		return new Result<List<Map<String,Object>>>(ResultCode.OK,locationList);
            }
        	return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
    		
    	}catch(Exception e){
    		logger.error("获取指定行政位置的信息 error:{}",e);
    		return new Result<List<Map<String,Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Location extractValidInfo(Location temp){
    	Location obj = new Location();

    	obj.setProId(temp.getProId());
    	obj.setCityId(temp.getCityId());
    	obj.setCounId(temp.getCounId());
    	obj.setBusiness(temp.getBusiness());
    	obj.setEnableStatus(temp.getEnableStatus());
    	if(temp.getEnableStatus() == EnableStatus.ENABLE){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else if(temp.getEnableStatus() == EnableStatus.DISABLE){
    		obj.setDisableBy(getSessionQuietly().getUserId());
    		obj.setDisableTime(new Date());
    	}
    	 
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Location item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Location item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	Area province = areaService.getByAreaId(Integer.parseInt(item.getProId().toString()));
    	infoMap.put("proId", notNull(province.getAreaId()));
    	infoMap.put("proName", province.getName());
    	
    	Area city = areaService.getByAreaId(Integer.parseInt(item.getCityId().toString()));
    	infoMap.put("cityId", notNull(city.getAreaId()));
    	infoMap.put("cityName", city.getName());

    	Area countory = areaService.getByAreaId(Integer.parseInt(item.getCounId().toString()));
    	infoMap.put("counId", notNull(countory.getAreaId()));
    	infoMap.put("counName", countory.getName());
    	
    	infoMap.put("business", notNull(item.getBusiness()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	
    	return infoMap;
    }
}
