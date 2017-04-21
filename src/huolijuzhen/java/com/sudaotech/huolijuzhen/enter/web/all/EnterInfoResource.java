package com.sudaotech.huolijuzhen.enter.web.all;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
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

@Path("/all/enterinfo")
public class EnterInfoResource extends BaseResource {

    @Inject
    private EnterInfoService enterInfoService;
    
    @PUT
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateTreatmentStatus(@Valid final Query query) {
    	Long id = query.getId();
    	String treatmentStatus = query.getTreatmentStatus();
    	String updateDescribe = query.getUpdateDescribe();
    	EnterInfo info = enterInfoService.getById(id);
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
		
		Page<EnterInfo> page = enterInfoService.find(query, EntryType.UNKNOWN);
        return new Result<Page<EnterInfo>>(ResultCode.OK, page);
    }
    
}
