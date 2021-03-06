package com.sudaotech.tag.web.admin;

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
import com.sudaotech.tag.service.TagService;
import com.sudaotech.tag.service.TagService.Tag;
import com.sudaotech.tag.service.TagService.TagQuery;
import com.sudaotech.util.MapHelper;

@Path("/admin/tag")
public class TagResource extends BaseResource {

    @Inject
    private TagService tagService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Tag obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = tagService.create(obj);
        Map<String, Long> map = MapHelper.put("tagId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/tag/%s", id));
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
            @Valid final Tag obj) {
        obj.setTagId(id);
        obj.setOperator(getSession().getUserId());
        tagService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Tag obj = new Tag();
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
    public Result<Tag> get(@NotNull @PathParam("id") final Long id) {
        Tag obj = tagService.getById(id);
        
        return new Result<Tag>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<Tag>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		TagQuery query = new TagQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<Tag> page = tagService.find(query);
        return new Result<Page<Tag>>(ResultCode.OK, page);
    }
}
