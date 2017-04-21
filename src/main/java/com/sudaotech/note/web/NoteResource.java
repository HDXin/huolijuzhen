package com.sudaotech.note.web;

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
import com.sudaotech.note.NotePermissionDef;
import com.sudaotech.note.service.NoteService;
import com.sudaotech.note.service.NoteService.Note;
import com.sudaotech.note.service.NoteService.Query;
import com.sudaotech.util.MapHelper;

@Path("/note")
public class NoteResource extends BaseResource {

    @Inject
    private NoteService noteService;
    
//    @RequirePermission(NotePermission.CREATE_NOTE)
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Note obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = noteService.create(obj);
        Map<String, Long> map = MapHelper.put("noteId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/note/%s", id));
        result.setData(map);
        return result;
    }

    @RequirePermission(NotePermissionDef.UPDATE_NOTE)
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final Note obj) {
        obj.setNoteId(id);
        obj.setOperator(getSession().getUserId());
        noteService.update(obj);
        return ResultSupport.ok();
    }

    @RequirePermission(NotePermissionDef.DELETE_NOTE)
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Note obj = new Note();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @RequirePermission(NotePermissionDef.DELETE_NOTE)
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

    @RequirePermission(NotePermissionDef.RETRIEVE_NOTE)
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Note> get(@NotNull @PathParam("id") final Long id) {
        Note obj = noteService.getById(id);
        
        return new Result<Note>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @RequirePermission(NotePermissionDef.RETRIEVE_NOTE)
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<Note>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<Note> page = noteService.find(query);
        return new Result<Page<Note>>(ResultCode.OK, page);
    }
}
