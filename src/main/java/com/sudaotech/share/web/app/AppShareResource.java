package com.sudaotech.share.web.app;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.exception.PermissionException;
import com.sudaotech.share.service.ShareService;
import com.sudaotech.share.service.ShareService.Share;
import com.sudaotech.util.MapHelper;

@Path("/app/share")
public class AppShareResource extends BaseResource {

    @Inject
    private ShareService shareService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Share obj) {
        // create
        final Long userId = getSession().getUserId();
        obj.setOperator(userId);
        obj.setUserId(userId);
        Long id = shareService.create(obj);
        Map<String, Long> map = MapHelper.put("shareId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/share/%s", id));
        result.setData(map);
        return result;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        final Long userId = getSession().getUserId();
        
        Share share = this.shareService.getById(id);
        if (share == null || !share.getUserId().equals(userId)) {
            throw new PermissionException();
        }
        
        Share obj = new Share();
        obj.setStatus(Status.DELETED);
        obj.setShareId(id);
        obj.setOperator(userId);
        shareService.update(obj);
        return ResultSupport.ok();
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
    public Result<Share> get(@NotNull @PathParam("id") final Long id) {
        final Long userId = getSession().getUserId();
        Share share = shareService.getById(id);
        if (share == null || !share.getUserId().equals(userId)) {
            throw new PermissionException();
        }
        
        return new Result<Share>(share == null ? ResultCode.NOT_FOUND : ResultCode.OK, share);
    }

    public static final class ShareVo {
        private Long shareId;
        private Integer type;
        
        public Long getShareId() {
            return shareId;
        }
        public void setShareId(Long shareId) {
            this.shareId = shareId;
        }
        public Integer getType() {
            return type;
        }
        public void setType(Integer type) {
            this.type = type;
        }
    }
}
