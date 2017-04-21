package com.sudaotech.huolijuzhen.basic.web.admin.enterprise;

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
import com.sudaotech.huolijuzhen.basic.service.BannerSourcesService;
import com.sudaotech.huolijuzhen.basic.service.BannerSourcesService.BannerSources;
import com.sudaotech.huolijuzhen.basic.service.BannerSourcesService.Query;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.util.MapHelper;

@Path("/banner/admin/enterprise/sources")
public class BannerSourcesResource extends BaseResource {

    @Inject
    private BannerSourcesService bannerSourcesService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BannerSources obj) {
    	if(!obj.getReqSourceType().equals(ReqSourceType.APP_ENTERPRISE)){
    		logger.error("企业banner [create] 服务接收到非法请求");
    		Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    		return result;
    	}
        // create
        obj.setOperator(getSession().getUserId());
        Long id = bannerSourcesService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/banner/web/enterprise/sources/%s", id));
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
            @Valid final BannerSources obj) {
    	if(obj.getReqSourceType()!=null && !obj.getReqSourceType().equals(ReqSourceType.APP_ENTERPRISE)){
    		logger.error("企业banner [update] 服务接收到非法请求");
    		return new Result<String>(ResultCode.BAD_REQUEST);
    	}
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        bannerSourcesService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        BannerSources obj = new BannerSources();
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
    public Result<BannerSources> get(@NotNull @PathParam("id") final Long id) {
        BannerSources obj = bannerSourcesService.getById(id, ReqSourceType.ADMIN_ENTERPRISE);
        
        return new Result<BannerSources>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BannerSources>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<BannerSources> page = bannerSourcesService.find(query, ReqSourceType.ADMIN_ENTERPRISE);
        return new Result<Page<BannerSources>>(ResultCode.OK, page);
    }
}
