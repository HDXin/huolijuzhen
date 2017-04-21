package com.sudaotech.suggest.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.suggest.service.SuggestService;

/**
 * 智能提示
 */
@Path("/suggest")
public class SuggestResource extends BaseResource {

    @Inject
    private SuggestService suggestService;
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<String>> getSuggest(
            @QueryParam("input") String input
            ) {
        logger.debug("Getting suggest: {}", input);
        List<String> list = null;
        try {
            list = suggestService.getSuggest(input, this.getSession());
        } catch (Exception e) {
            logger.error("Getting suggest failed: {}", e);
        }
        return ResultSupport.ok(list);
    }
}
