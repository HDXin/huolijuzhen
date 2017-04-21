package com.sudaotech.huolijuzhen.bill.web.admin.park;
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
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.basic.service.CostProService.Query;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.CostProSetting;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/costPro")
public class CostProResource extends BaseResource {

    @Inject
    private CostProService costProService;
    
    @Inject
    private CostProSettingService costProSettingService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final CostPro obj) {
    	Session session=getSessionQuietly();
    	if(session == null){
    		return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
    	}
    	Long userId = session.getUserId();
        // create
    	if(obj.getEnableStatus() == null){
    		obj.setEnableStatus(EnableStatus.DISABLE);
    		obj.setEnableTime(new Date());
    		obj.setEnableBy(userId);
    	}
    	
        obj.setOperator(userId);
        obj.setCreateSource(CreateSource.PARK);
        obj.setParkId(session.getPlatformId());
        Long id = costProService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/costPro/%s", id));
        result.setData(map);
        return result;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final CostPro obj) {
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        obj.setRecommendStatus(0);
        costProService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        CostPro obj = new CostPro();
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
    public Result<CostPro> get(@NotNull @PathParam("id") final Long id) {
        CostPro obj = costProService.getById(id);
        
        return new Result<CostPro>(obj == null ? ResultCode.NOT_FOUND_COST_PRO : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<CostPro>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("code") String code,
            @QueryParam("name") String name,
            @QueryParam("chargeMode") ChargeMode chargeMode,
            @QueryParam("enableStatus") EnableStatus enableStatus
            ) {
    	Session session = getSessionQuietly();
    	
    	if(session == null){
    		return new Result<Page<CostPro>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId()==null || session.getPlatformId()==0){
    		return new Result<Page<CostPro>>(ResultCode.BAD_REQUEST);
    	}
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setCode(code);
		query.setName(name);
		query.setChargeMode(chargeMode);
		query.setEnableStatus(enableStatus);
	
		//只能查询所属园区的
		query.setCreateSource(CreateSource.PARK);
		query.setParkId(session.getPlatformId());
		
		Page<CostPro> page = costProService.find(query);
        return new Result<Page<CostPro>>(ResultCode.OK, page);
    }
    
    @GET
    @Path("/moneyCal")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<CostPro>> findCostPro( @QueryParam("chargeMode") ChargeMode chargeMode) {
          
    	Session session = getSessionQuietly();
    	
    	if(session == null){
    		return new Result<List<CostPro>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId()==null || session.getPlatformId()== 0){
    		return new Result<List<CostPro>>(ResultCode.BAD_REQUEST);
    	}
		//只能查询所属园区的
		CostPro cp = new CostPro();
		cp.setCreateSource(CreateSource.PARK);
		cp.setParkId(session.getPlatformId());
		cp.setChargeMode(chargeMode);
		cp.setEnableStatus(EnableStatus.ENABLE);
		
        return new Result<List<CostPro>>(ResultCode.OK,  costProService.findByObj(cp));
    }
    
    @PUT
    @Path("/enable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> enable(
            @NotNull @PathParam("id") final Long id) {

        Long userId = getSessionQuietly().getUserId();

        //更新费用项目基本信息
        CostPro obj = new CostPro();
        obj.setId(id);
        obj.setOperator(userId);

        obj.setEnableStatus(EnableStatus.ENABLE);
        obj.setEnableBy(userId);
        obj.setEnableTime(new Date());
        
        obj.setRecommendStatus(0);
        costProService.update(obj);
        
        //更新费用项目用量录入的信息
        CostProSetting costProSetting = new CostProSetting();
        costProSetting.setCostProType(id);
        List<CostProSetting> costProSettings = costProSettingService.findAllByObject(costProSetting);
        if(CollectionUtils.isNotEmpty(costProSettings)){
        	for(CostProSetting item:costProSettings){
        		costProSetting = new CostProSetting();
        		
        		costProSetting.setId(item.getId());
        		costProSetting.setEnableStatus(EnableStatus.ENABLE);
        		
        		costProSettingService.update(costProSetting);
        	}
        	
        	
        }
        
        return ResultSupport.ok();
    }
    
    @PUT
    @Path("/disable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> disable(
            @NotNull @PathParam("id") final Long id) {

        Long userId = getSessionQuietly().getUserId();

        //更新费用项目基本信息
        CostPro obj = new CostPro();
        obj.setId(id);
        obj.setOperator(userId);

        obj.setEnableStatus(EnableStatus.DISABLE);
        obj.setDisableBy(userId);
        obj.setDisableTime(new Date());
        
        obj.setRecommendStatus(0);
        costProService.update(obj);

        //更新费用项目用量录入的信息
        CostProSetting costProSetting = new CostProSetting();
        costProSetting.setCostProType(id);
        List<CostProSetting> costProSettings = costProSettingService.findAllByObject(costProSetting);
        if(CollectionUtils.isNotEmpty(costProSettings)){
        	for(CostProSetting item:costProSettings){
        		costProSetting = new CostProSetting();
        		
        		costProSetting.setId(item.getId());
        		costProSetting.setEnableStatus(EnableStatus.DISABLE);
        		
        		costProSettingService.update(costProSetting);
        	}
        	
        	
        }
        
        
        return ResultSupport.ok();
    }
}