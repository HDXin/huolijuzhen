package com.sudaotech.picture.web;

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
import com.sudaotech.core.annotation.RequirePermission;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.picture.PicturePermissionDef;
import com.sudaotech.picture.service.PictureService;
import com.sudaotech.picture.service.PictureService.Picture;
import com.sudaotech.picture.service.PictureService.Query;
import com.sudaotech.util.MapHelper;

@Path("/picture")
public class PictureResource extends BaseResource {

    @Inject
    private PictureService pictureService;
    
    @RequirePermission(PicturePermissionDef.CREATE_PICTURE)
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Picture obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = pictureService.create(obj);
        Map<String, Long> map = MapHelper.put("pictureId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/picture/%s", id));
        result.setData(map);
        return result;
    }

    @RequirePermission(PicturePermissionDef.UPDATE_PICTURE)
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final Picture obj) {
        obj.setPictureId(id);
        obj.setOperator(getSession().getUserId());
        pictureService.update(obj);
        return ResultSupport.ok();
    }

    @RequirePermission(PicturePermissionDef.DELETE_PICTURE)
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Picture obj = new Picture();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @RequirePermission(PicturePermissionDef.DELETE_PICTURE)
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

    @RequirePermission(PicturePermissionDef.RETRIEVE_PICTURE)
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Picture> get(@NotNull @PathParam("id") final Long id) {
        Picture obj = pictureService.getById(id);
        
        return new Result<Picture>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @RequirePermission(PicturePermissionDef.RETRIEVE_PICTURE)
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<Picture>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<Picture> page = pictureService.find(query);
        return new Result<Page<Picture>>(ResultCode.OK, page);
    }
}
