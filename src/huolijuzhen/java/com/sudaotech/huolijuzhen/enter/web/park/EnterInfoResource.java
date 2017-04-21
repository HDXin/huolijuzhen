package com.sudaotech.huolijuzhen.enter.web.park;

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
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enter.service.EnterInfoService;
import com.sudaotech.huolijuzhen.enter.service.EnterInfoService.EnterInfo;
import com.sudaotech.huolijuzhen.enter.service.EnterInfoService.Query;
import com.sudaotech.huolijuzhen.enums.EntryType;
import com.sudaotech.huolijuzhen.enums.TreatmentStatus;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.util.MapHelper;

@Path("/park/enterinfo")
public class EnterInfoResource extends BaseResource {

    @Inject
    private EnterInfoService enterInfoService;
    
    @Inject
    private PhoneCodeService phoneCodeService;
    
    @POST
    @Path("/{phonecode}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EnterInfo obj, @NotNull @PathParam("phonecode") final String phoneCode) {
        
    	Result<Map<String, Long>> result = null;
    	//验证短信验证码
    	if(obj==null){
    		result = new Result<Map<String, Long>>(ResultCode.ENTER_INFO_PARAMS_IS_EMPTY);
    		return result;
    	}
    	//校验短信验证码
    	if(!phoneCodeService.checkPhoneCode(obj.getPhoneNo(), phoneCode)){
    		result = new Result<Map<String, Long>>(ResultCode.ENTER_INFO_SMS_UNPASS);
    		return result;
    	}
        obj.setOperator(getSession().getUserId());
        obj.setTreatmentStatus(TreatmentStatus.PENDING_TREATMENT);
        obj.setEntryType(EntryType.PARK);
        Long id = enterInfoService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/EnterInfo/%s", id));
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
            @Valid final EnterInfo obj) {
    	Map<String,Object> map = auth(id);
    	if(!ResultCode.OK.equals((ResultCode)map.get("code"))){
    		return new Result<String>((ResultCode)map.get("code"));
    	}
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        enterInfoService.update(obj);
        return ResultSupport.ok();
    }
    
    @PUT
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateTreatmentStatus(@Valid final Query query) {
    	Long id = query.getId();
    	String treatmentStatus = query.getTreatmentStatus();
    	String updateDescribe = query.getUpdateDescribe();
    	Map<String,Object> map = auth(id);
    	if(!ResultCode.OK.equals((ResultCode)map.get("code"))){
    		return new Result<String>((ResultCode)map.get("code"));
    	}
    	EnterInfo info = (EnterInfo) map.get("info");
    	info.setUpdateDescribe(updateDescribe);
        info.setOperator(getSession().getUserId());
        if(TreatmentStatus.ALREADY_PROCESSED.name().equals(treatmentStatus.trim().toUpperCase()))
        	info.setTreatmentStatus(TreatmentStatus.ALREADY_PROCESSED);
        else if(TreatmentStatus.PENDING_TREATMENT.name().equals(treatmentStatus.trim().toUpperCase()))
        	info.setTreatmentStatus(TreatmentStatus.PENDING_TREATMENT);
        else
        	return new Result<String>(ResultCode.ENTER_INFO_TREATMENTSTATUS_IS_WRONG);
        enterInfoService.update(info);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	Map<String,Object> map = auth(id);
    	ResultCode c = (ResultCode)map.get("code");
    	if(!ResultCode.OK.equals((ResultCode)map.get("code")) && !ResultCode.ENTER_INFO_IS_NOT_FOUND.equals((ResultCode)map.get("code"))){
    		return new Result<String>((ResultCode)map.get("code"));
    	}
    	EnterInfo info = new EnterInfo();
    	info.setId(id);
    	info.setStatus(Status.DELETED);
    	info.setOperator(getSession().getUserId());
        enterInfoService.update(info);
        return ResultSupport.ok();
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
    public Result<EnterInfo> get(@NotNull @PathParam("id") final Long id) {
        EnterInfo obj = enterInfoService.getById(id);
        //校验请求合法性
        if(obj==null){
        	return new Result<EnterInfo>(ResultCode.NOT_FOUND, null);
        }else if(!EntryType.PARK.equals(obj.getEntryType())){
        	return new Result<EnterInfo>(ResultCode.ENTER_INFO_ILLEGAL_REQUEST, null);
        }
        return new Result<EnterInfo>(ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EnterInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<EnterInfo> page = enterInfoService.find(query, EntryType.PARK);
        return new Result<Page<EnterInfo>>(ResultCode.OK, page);
    }
    
    /**
     * 权限校验
     * */
    public Map<String,Object> auth(Long id){
    	EnterInfo info = enterInfoService.getById(id);
    	Map<String,Object> map = new HashMap<String, Object>();
    	if(info==null){
    		map.put("code", ResultCode.ENTER_INFO_IS_NOT_FOUND);
    		return map;
    	}
    	if(!EntryType.PARK.equals(info.getEntryType())){
    		map.put("code", ResultCode.ENTER_INFO_ILLEGAL_REQUEST);
    		return map;
    	}
    	map.put("info", info);
    	map.put("code", ResultCode.OK);
    	return map;
    }
}