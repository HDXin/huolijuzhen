package com.sudaotech.huolijuzhen.park.web.admin.platform;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoService.ParkGroupUserInfo;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoService.Query;
import com.sudaotech.util.MapHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

@Path("/admin/platform/parkGroupUserInfo")
public class ParkGroupUserInfoResource extends BaseResource {

    @Inject
    private ParkGroupUserInfoService parkGroupUserInfoService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ParkGroupUserInfo obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = parkGroupUserInfoService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/parkGroupUserInfo/%s", id));
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
            @Valid final ParkGroupUserInfo obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        parkGroupUserInfoService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ParkGroupUserInfo obj = new ParkGroupUserInfo();
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
    public Result<ParkGroupUserInfo> get(@NotNull @PathParam("id") final Long id) {
        ParkGroupUserInfo obj = parkGroupUserInfoService.getById(id);

        return new Result<ParkGroupUserInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ParkGroupUserInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
    ) {
        Query query = new Query();
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);

        Page<ParkGroupUserInfo> page = parkGroupUserInfoService.find(query);
        return new Result<Page<ParkGroupUserInfo>>(ResultCode.OK, page);
    }
}
