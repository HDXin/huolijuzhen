package com.sudaotech.account.web.admin;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;
import com.sudaotech.account.service.Permission;
import com.sudaotech.account.service.PermissionService;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;

/**
 * 权限
 */
@Path("/admin/permission")
public class AdminPermissionResource extends BaseResource {
    @Inject
    private PermissionService permissionService;

    /**
     * 获取权限列表
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Permission>> getPermissions() {
        List<Permission> permissions = this.permissionService.listPermissions(null);
        
        return new Result<List<Permission>>(ResultCode.OK, permissions);
    }
}
