package com.sudaotech.huolijuzhen.park.web.admin.platform;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
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
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalTypeQuery;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.basic.service.LocationService;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.Query;
import com.sudaotech.user.enums.UserAttributeType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/parkInfo")
public class ParkInfoResource extends BaseResource {

    @Inject
    private ParkInfoService parkInfoService;

    @Inject
    private AdminUserService adminUserService;

    @Inject
    private AccountService accountService;

    @Inject
    private AreaService areaService;

    @Inject
    private LocationService locationService;
    
    @Inject
    private CostProService costProService;
    
    @Inject
    private GenCodeService genCodeService;
    
    @Inject
    private ApprovalTypeService approvalTypeService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ParkInfo obj) {
    	
    	try{
            Long userId = getSessionQuietly().getUserId();
            
            if(userId == null || userId == 0){
            	return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
            }

            //默认禁用用
            
            if(obj.getEnableStatus() == null){
            	obj.setEnableStatus(EnableStatus.DISABLE);
            }
            obj.setStartBy(userId);
            obj.setStartTime(new Date());

            obj.setOperator(userId);

            Long parkId = parkInfoService.create(obj);

            //创建园区管理员用户
            AdminUser au = new AdminUser();
            au.setCellphone(obj.getMobilePhone());
            au.setUsername(obj.getAdminAccount());
            au.setPassword(Constants.Park.ADMIN_USER_PWD);
            //默认用户属性为园区管理
            au.setUserAttribute(UserAttributeType.PARK_MANAGE.code());
            au.setEmail(obj.getEmail());
            au.setTel(obj.getPhone());
            au.setPlatformSource(PlatformSource.PARK);
            au.setPlatformSourceId(parkId);
            au.setOperator(userId);

            Long newUserId = adminUserService.create(au);

            //赋值管理员角色
            Account account = new Account();
            account.setUserId(newUserId);
            account.setRoleIds(Arrays.asList(Constants.Park.ADMIN_ROLE_ID));
            accountService.createAccount(account);
            
            //初始化费用项目
            //查询平台基础费用项目配置
            CostPro cp=new CostPro();
            cp.setCreateSource(CreateSource.PLATFORM);
            cp.setEnableStatus(EnableStatus.ENABLE);
            List<CostPro> cps=costProService.findByObj(cp);
            
            if(CollectionUtils.isNotEmpty(cps)){
            	CostPro newCp=null;
            	for (CostPro costPro : cps) {
            		newCp=new CostPro();
            		newCp.setCode(costPro.getCode());
            		newCp.setName(costPro.getName());
            		newCp.setChargeMode(costPro.getChargeMode());
            		newCp.setChargePrice(costPro.getChargePrice());
            		newCp.setCostRate(costPro.getCostRate());
            		newCp.setEnableStatus(EnableStatus.DISABLE);
            		newCp.setEnableTime(new Date());
            		newCp.setEnableBy(userId);
            		newCp.setCreateSource(CreateSource.PARK);
            		newCp.setParkId(parkId);
            		newCp.setRecommendStatus(1);
            		costProService.create(newCp);
    			}
            }
            
            //添加维修申报类型的费用项目（固定）
            CostPro costPro = new CostPro();
            costPro.setCode(CostPro.STATIC_CODE);
            costPro.setName(CostPro.STATIC_NAME);
            costPro.setChargeMode(ChargeMode.AMOUNT);
            costPro.setCostRate(new BigDecimal(CostPro.STATIC_COST_RATE));
            costPro.setParkId(parkId);
            costPro.setEnableStatus(EnableStatus.ENABLE);
            costPro.setEnableBy(userId);
            costPro.setEnableTime(new Date());
            costPro.setOperator(userId);
            costProService.create(costPro);
            
            //初始化流程类型
            ApprovalTypeQuery approvalTypeQuery = new ApprovalTypeQuery();
            approvalTypeQuery.setParkId(0L);
            List<ApprovalType> approvalTypes = approvalTypeService.findByObjQuery(approvalTypeQuery);
            if(CollectionUtils.isNotEmpty(approvalTypes)){
            	for(ApprovalType item:approvalTypes){
            		item.setParkId(parkId);

            		approvalTypeService.create(item);
            	}
            }
            
            Map<String, Long> map = MapHelper.put("id", parkId).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/admin/parkInfo/%s", parkId));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("平台创建园区 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ParkInfo obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        parkInfoService.update(obj);
        return ResultSupport.ok();
    }

    @PUT
    @Path("/enable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> enable(
            @NotNull @PathParam("id") final Long id) {

        Long userId = getSession().getUserId();

        ParkInfo obj = new ParkInfo();
        obj.setId(id);
        obj.setOperator(userId);

        obj.setEnableStatus(EnableStatus.ENABLE);
        obj.setStartBy(userId);
        obj.setStartTime(new Date());

        parkInfoService.update(obj);
        return ResultSupport.ok();
    }

    @PUT
    @Path("/disable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> disable(
            @NotNull @PathParam("id") final Long id) {
        Long userId = getSession().getUserId();

        ParkInfo obj = new ParkInfo();
        obj.setId(id);
        obj.setOperator(userId);

        obj.setEnableStatus(EnableStatus.DISABLE);
        obj.setCloseBy(userId);
        obj.setCloseTime(new Date());


        parkInfoService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ParkInfo obj = new ParkInfo();
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

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<ParkInfo> get(@NotNull @PathParam("id") final Long id) {
        ParkInfo obj = parkInfoService.getById(id);

        return new Result<ParkInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    @GET
    @Path("/adminAccount/generate")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> getAdminUesr() {
    	
        String adminAccount = genCodeService.nextCodeByType(Constants.Park.ADMIN_USER_PREFIX);

        return new Result<String>(adminAccount == null ? ResultCode.NOT_FOUND : ResultCode.OK, adminAccount);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ParkInfo>> find(
            @QueryParam("page") Integer pageNum,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("proId") Long proId,
            @QueryParam("cityId") Long cityId,
            @QueryParam("counId") Long counId,
            @QueryParam("locationId") Long locationId,
            @QueryParam("parkname") String parkname,
            @QueryParam("enableStatus")EnableStatus enableStatus
    ) {
        Query query = new Query();
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setProvinceId(proId);
        query.setCityId(cityId);
        query.setCounId(counId);
        query.setLocationId(locationId);
        query.setName(parkname);
        query.setEnableStatus(enableStatus);

        Page<ParkInfo> page = parkInfoService.find(query);
        if (page.getItems() != null && !page.getItems().isEmpty()) {
            for (ParkInfo obj : page.getItems()) {
                if(obj.getProvinceId()!=null){
                    Area area = this.areaService.getByAreaId(obj.getProvinceId().intValue());
                    if (area != null)
                        obj.setPro(area.getName());
                }
                if(obj.getCityId()!=null){
                    Area area1 = this.areaService.getByAreaId(obj.getCityId().intValue());
                    if (area1 != null)
                        obj.setCity(area1.getName());
                }
                if(obj.getRegionId()!=null){
                    Area area2 = this.areaService.getByAreaId(obj.getRegionId().intValue());
                    if (area2 != null)
                        obj.setRegion(area2.getName());
                }
                if(obj.getPositionId()!=null){
                    LocationService.Location location = this.locationService.getById(obj.getPositionId());
                    if (location != null)
                        obj.setLocation(location.getBusiness());
                }
            }
        }
        return new Result<Page<ParkInfo>>(ResultCode.OK, page);
    }
    
    
    
}
