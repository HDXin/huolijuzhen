package com.sudaotech.feedback.web.admin;

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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.util.DateUtils;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.feedback.service.FeedbackService;
import com.sudaotech.feedback.service.FeedbackService.Feedback;
import com.sudaotech.feedback.service.FeedbackService.Query;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.MapHelper;

@Path("/admin/feedback")
public class AdminFeedbackResource extends BaseResource {

    @Inject
    private FeedbackService feedbackService;
    @Inject
    private AppUserService userService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Feedback obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = feedbackService.create(obj);
        Map<String, Long> map = MapHelper.put("feedbackId", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/feedback/%s", id));
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
            @Valid final Feedback obj) {
        obj.setFeedbackId(id);
        obj.setOperator(getSession().getUserId());
        feedbackService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Feedback obj = new Feedback();
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
    public Result<FeedbackVo> get(@NotNull @PathParam("id") final Long id) {
        Feedback obj = feedbackService.getById(id);
        FeedbackVo vo = toFeedbackVo(obj);
        return new Result<FeedbackVo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, vo);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<FeedbackVo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("beginTime") String beginTime,
            @QueryParam("endTime") String endTime
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
        query.setBeginTime(DateUtils.parse(beginTime));
        query.setEndTime(DateUtils.parse(endTime));
		
		Page<Feedback> page = feedbackService.find(query);
		Page<FeedbackVo> voPage = new Page<FeedbackVo>(page);
		for (Feedback feedback : page.getItems()) {
		    voPage.addItem(this.toFeedbackVo(feedback));
		}
		
        return new Result<Page<FeedbackVo>>(ResultCode.OK, voPage);
    }

    private FeedbackVo toFeedbackVo(Feedback obj) {
        FeedbackVo vo = BeanUtils.copyProperties(obj, FeedbackVo.class);
        setNameAndNickname(vo);
        return vo;
    }

    private void setNameAndNickname(FeedbackVo obj) {
        if (obj != null && obj.getCreateBy() > 0) {
            AppUser appUser = userService.getById(obj.getCreateBy());
            if (appUser != null) {
                obj.setName(appUser.getName());
                obj.setNickname(appUser.getNickname());
            }
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class FeedbackVo extends Feedback {
        private String name;
        private String nickname;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getNickname() {
            return nickname;
        }
        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
