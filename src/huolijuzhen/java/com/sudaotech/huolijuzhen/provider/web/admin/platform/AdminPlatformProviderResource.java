package com.sudaotech.huolijuzhen.provider.web.admin.platform;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountService.Account;
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Query;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/provider")
public class AdminPlatformProviderResource extends BaseResource {

    @Inject
    private ProviderService providerService;
    @Inject
    private AreaService areaService;
    @Inject
    private AdminUserService adminUserService;
    @Inject
    private AccountService accountService;
    @Inject
    private GenCodeService genCodeService;
    
    /**
     * 添加服务商
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Provider obj) {
    	try{
    		Long userId=getSessionQuietly().getUserId();
    		
    		//1.提取表单数据
    		Provider temp = extractValidInfo(obj);
            
    		temp.setCreateSide(CreateSide.PLATFORM);
    		temp.setOperator(userId);
            Long id = providerService.create(temp);
            
            //2.创建服务商登录账号
            obj.setId(id);
            createProviderAdminUser(obj);
           
            Map<String, Long> map = MapHelper.put("id", id).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/provider/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("平台添加服务商 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑服务商
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
            @Valid final Provider obj) {
    	try{
    		//1.提取表单数据
    		Provider temp = extractValidInfo(obj);
    		
    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            providerService.update(temp);
            
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("编辑服务商 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 
     */
    private void createProviderAdminUser(Provider obj)throws Exception{
    	
    	Long userId = getSessionQuietly().getUserId();
    	 //服務商管理员用户
        AdminUser au = new AdminUser();
        
        au.setCellphone(obj.getPhone());
        au.setUsername(obj.getAccount());
        au.setPassword(Constants.Park.SERVER_USER_PWD);
        au.setPlatformSource(PlatformSource.PARK);
        au.setProviderId(obj.getId());
        au.setUserType(UserType.SERVICE_PROVIDER_USER);
       
        au.setPlatformSourceId(getSessionQuietly().getPlatformId());
        au.setOperator(userId);
        
        Long newUserId = adminUserService.create(au);

        //赋值管理员角色
        Account account = new Account();
        account.setUserId(newUserId);
        account.setRoleIds(Arrays.asList(Constants.Park.SERVICE_PROVIDER_ROLE_ID));
        accountService.createAccount(account);
    	
    }
    
    /**
     * 启用
     * @param id
     * @param obj
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
    		Provider obj = new Provider();
    		
    		obj.setId(id);
    		obj.setOperator(getSessionQuietly().getUserId());

    		obj.setEnableStatus(EnableStatus.ENABLE);
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    		providerService.update(obj);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("平台服务商启用 error：{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 禁用
     * @param id
     * @param obj
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
    		Provider obj = new Provider();
    		
    		obj.setId(id);
    		obj.setOperator(getSessionQuietly().getUserId());

    		obj.setEnableStatus(EnableStatus.DISABLE);
			obj.setDisableBy(getSessionQuietly().getUserId());
			obj.setDisableTime(new Date());

			providerService.update(obj);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("平台服务商禁用 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	try{
            Provider obj = new Provider();
            obj.setOperator(getSessionQuietly().getUserId());
            obj.setStatus(Status.DELETED);
            return update(id, obj);
    	}catch(Exception e){
    		logger.error("平台删除服务商 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	try{
        	if (CollectionUtils.isNotEmpty(ids)) {
        		Provider obj = null;
    			for (Long id : ids) {
    				obj = new Provider();
    				obj.setId(id);
    				obj.setOperator(getSessionQuietly().getUserId());
    				obj.setStatus(Status.DELETED);
    				providerService.update(obj);
    			}
                return ResultSupport.ok();
        	}else{
        		return new Result<String>(ResultCode.NOT_FOUND);
        	}
    	}catch(Exception e){
    		logger.error("",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 获取服务商详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try {
            Provider obj = providerService.getById(id);
            Map<String, Object> dataMap = new HashedMap<String, Object>();
            if(obj != null){
            	dataMap = packItemInfo(obj);
            }
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
		} catch (Exception e) {
			logger.error("平台获取服务商详情 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    /**
     * 按条件查询
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("providerName") String providerName,
            @QueryParam("providerGrade") String createSide,
            @QueryParam("enableStatus") String enableStatus,
       		@QueryParam("proId") Long proId,
       		@QueryParam("cityId") Long cityId,
       		@QueryParam("counId") Long counId){
		
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		query.setProviderName(providerName);
    		query.setCreateSide(createSide);
    		query.setEnableStatus(enableStatus);
    		query.setProId(proId);
    		query.setCityId(cityId);
    		query.setCounId(counId);
    		
    		Page<Provider> page = providerService.find(query);
    		Map<String, Object> dataMap = packPageInfo(page);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("平台按条件查询服务商 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GET
    @Path("/adminAccount/generate")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> getAdminUesr() {
    	
        String adminAccount = genCodeService.nextCodeByType(Constants.Platform.SERVER_USER_PREFIX);

        return new Result<String>(adminAccount == null ? ResultCode.NOT_FOUND : ResultCode.OK, adminAccount);
    }
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Provider extractValidInfo(Provider temp){
    	Provider obj = new Provider();
    	
    	obj.setName(temp.getName());
    	obj.setProId(temp.getProId());
    	obj.setCityId(temp.getCityId());
    	obj.setCounId(temp.getCounId());
    	obj.setContacts(temp.getContacts());
    	obj.setPhone(temp.getPhone());
    	obj.setDescription(temp.getDescription());
    	obj.setAccount(temp.getAccount());
    	EnableStatus enableStatus = temp.getEnableStatus();
    	if(EnableStatus.ENABLE.equals(enableStatus)){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else{
    		obj.setDisableBy(getSessionQuietly().getUserId());
    		obj.setDisableTime(new Date());
    	}
		obj.setEnableStatus(enableStatus);    	
    	
    	return obj;
    }
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<Provider> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<Provider> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(Provider pc:list){
    			item = packListInfo(pc);
    			items.add(item);
    		}
    	}
    	dataMap.put("items", items);
    	return dataMap;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Provider item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Provider item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("providerGrade", notNull(item.getCreateSide()));
    	infoMap.put("providerName", notNull(item.getName()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	infoMap.put("contacts", notNull(item.getContacts()));
    	infoMap.put("phone", notNull(item.getPhone()));
    	infoMap.put("account", notNull(item.getAccount()));
    	infoMap.put("description", notNull(item.getDescription()));
    	
    	//获取省份信息
    	Long proId = item.getProId();
    	String proName = "";
    	if(proId != null){
    		Area province = areaService.getByAreaId(Integer.parseInt(proId.toString()));
    		proName = province.getName();
    	}else{
    		proId = -1L;
    	}
    	infoMap.put("proId", proId);
    	infoMap.put("proName", proName);
    	
    	//获取城市信息
    	Long cityId = item.getCityId();
    	String cityName = "";
    	if(cityId != null){
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		cityName = city.getName();
    	}else{
    		cityId = -1L;
    	}
    	infoMap.put("cityId", cityId);
    	infoMap.put("cityName", cityName);
    	
    	//获取县区信息
    	Long counId = item.getCounId();
    	String counName = "";
    	if(counId != null){
    		Area countory = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		counName = countory.getName();
    	}else{
    		counId = -1L;
    	}
    	infoMap.put("counId", counId);
    	infoMap.put("counName", counName);

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
