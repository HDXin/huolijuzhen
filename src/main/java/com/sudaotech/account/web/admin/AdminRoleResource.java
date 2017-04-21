package com.sudaotech.account.web.admin;

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
import com.sudaotech.account.service.Role;
import com.sudaotech.account.service.RoleService;
import com.sudaotech.account.service.RoleService.RoleQuery;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.util.MapHelper;

@Path("/{platformSource}/admin/role")
public class AdminRoleResource extends BaseResource {

    @Inject
    private RoleService roleService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Role obj, @NotNull @PathParam("platformSource") String platformSource) {
        // create
    	Session session=getSession();
    	
        obj.setOperator(session.getUserId());
        obj.setPlatformSource(PlatformSource.codeOf(platformSource.toUpperCase()));
        obj.setPlatformSourceId(session.getPlatformId());
        
        Long id = roleService.create(obj);
        Map<String, Long> map = MapHelper.put("roleId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/role/%s", id));
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
            @Valid final Role obj) {
        obj.setRoleId(id);
        obj.setOperator(getSession().getUserId());
        roleService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Role obj = new Role();
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
    public Result<Role> get(@NotNull @PathParam("id") final Long id) {
        Role obj = roleService.getById(id);
        
        return new Result<Role>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<Role>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @NotNull @PathParam("platformSource") String platformSource
            ) {
    	
		RoleQuery query = new RoleQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setPlatformSource(PlatformSource.codeOf(platformSource.toUpperCase()));
		query.setPlatformSourceId(getSessionQuietly().getPlatformId());
		
		Page<Role> page = roleService.find(query);
        return new Result<Page<Role>>(ResultCode.OK, page);
    }
}
