package com.sudaotech.cache.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;
import com.sudaotech.cache.service.CacheService;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultSupport;

/**
 * Cache管理
 */
@Path("/cache")
public class CacheResource extends BaseResource {

    @Inject
    private CacheService cacheService;

    @GET
    @Path("/clear")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> clearCache() {
        this.cacheService.clearCache();
        return ResultSupport.ok();
    }
}
