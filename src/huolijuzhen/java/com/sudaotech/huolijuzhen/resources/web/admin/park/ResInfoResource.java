package com.sudaotech.huolijuzhen.resources.web.admin.park;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.annotation.RequirePermission;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.CalcDimension;
import com.sudaotech.huolijuzhen.enums.EnableAvg;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ResType;
import com.sudaotech.huolijuzhen.resources.ResInfoPermissionDef;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService.Query;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService.ResInfo;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.util.MapHelper;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Path("/admin/park/resInfo")
public class ResInfoResource extends BaseResource {

    @Inject
    private ResInfoService resInfoService;

    @Inject
    private ResourceInfoService resourceInfoService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    @RequirePermission(ResInfoPermissionDef.CREATE_RESINFO)
    public Result<Map<String, Long>> create(@Valid final ResInfo obj) {
        Session session = getSession();
        // create
        obj.setOperator(session.getUserId());

        obj.setGardenId(session.getPlatformId());
        if (EnableStatus.DISABLE.equals(obj.getEnableStatus())) {
            obj.setCloseBy(session.getUserId());
            obj.setCloseTime(new Date());
        } else if (EnableStatus.ENABLE.equals(obj.getEnableStatus())) {
            obj.setStartBy(session.getUserId());
            obj.setStartTime(new Date());
        } else {
            return new Result<Map<String, Long>>(ResultCode.PARAM_ERROR);
        }
        
        //当资源类型为按用量计算时不启用均价计算
        CalcDimension calcDimension = obj.getCalcDimension();
        if(CalcDimension.BY_NUMS.equals(calcDimension)){
        	obj.setEnableAvg(EnableAvg.DISABLE);
        }
        EnableAvg enableAvg = obj.getEnableAvg();
        if(enableAvg == null || EnableAvg.DISABLE.equals(enableAvg)){
        	obj.setEnableAvg(EnableAvg.DISABLE);
        }
        
        Long id = resInfoService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/resInfo/%s", id));
        result.setData(map);
        return result;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @RequirePermission(ResInfoPermissionDef.UPDATE_RESINFO)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ResInfo obj) {
        Long userId = getSession().getUserId();

        if (EnableStatus.DISABLE.equals(obj.getEnableStatus())) {
            obj.setCloseBy(userId);
            obj.setCloseTime(new Date());
            //禁用检测是否已经被引用了
            ResourceInfoService.Query query = new ResourceInfoService.Query();
            query.setResInfoId(id);
            List<ResourceInfoService.ResourceInfo> resourceInfoList = this.resourceInfoService.getByQuery(query);
            if (resourceInfoList != null) {
                return new Result<String>(ResultCode.RES_CAN_NOT_DISBALE);
            }

        } else if (EnableStatus.ENABLE.equals(obj.getEnableStatus())) {
            obj.setStartBy(userId);
            obj.setStartTime(new Date());
        } else {
            return new Result<>(ResultCode.PARAM_ERROR);
        }
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        
        //当资源类型为按用量计算时不启用均价计算
        CalcDimension calcDimension = obj.getCalcDimension();
        if(CalcDimension.BY_NUMS.equals(calcDimension)){
        	obj.setEnableAvg(EnableAvg.DISABLE);
        }
        EnableAvg enableAvg = obj.getEnableAvg();
        if(enableAvg == null || EnableAvg.DISABLE.equals(enableAvg)){
        	obj.setEnableAvg(EnableAvg.DISABLE);
        }

        
        resInfoService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ResInfo obj = new ResInfo();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @RequirePermission(ResInfoPermissionDef.DELETE_RESINFO)
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
    @RequirePermission(ResInfoPermissionDef.RETRIEVE_RESINFO)
    public Result<ResInfo> get(@NotNull @PathParam("id") final Long id) {
        ResInfo obj = resInfoService.getById(id);

        return new Result<ResInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @RequirePermission(ResInfoPermissionDef.RETRIEVE_RESINFO)
    public Result<Page<ResInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("name") String name,
            @QueryParam("enableStatus") EnableStatus enableStatus,
            @QueryParam("resType") ResType resType
    ) {
        Query query = new Query();
        query.setName(name);
        query.setEnableStatus(enableStatus);
        query.setResType(resType);
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setParkInfoId(getSession().getPlatformId());

        Page<ResInfo> page = resInfoService.find(query);
        return new Result<Page<ResInfo>>(ResultCode.OK, page);
    }
}
