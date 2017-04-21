package com.sudaotech.huolijuzhen.bill.web.admin.park;

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
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService.BillChangeLogs;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService.Query;
import com.sudaotech.util.MapHelper;

@Path("/billChangeLogs")
public class BillChangeLogsResource extends BaseResource {

    @Inject
    private BillChangeLogsService billChangeLogsService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BillChangeLogs obj) {
        // create
        obj.setOperator(getSessionQuietly().getUserId());
        Long id = billChangeLogsService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/billChangeLogs/%s", id));
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
            @Valid final BillChangeLogs obj) {
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        billChangeLogsService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        BillChangeLogs obj = new BillChangeLogs();
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
    public Result<BillChangeLogs> get(@NotNull @PathParam("id") final Long id) {
        BillChangeLogs obj = billChangeLogsService.getById(id);
        
        return new Result<BillChangeLogs>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillChangeLogs>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<BillChangeLogs> page = billChangeLogsService.find(query);
        return new Result<Page<BillChangeLogs>>(ResultCode.OK, page);
    }
}
