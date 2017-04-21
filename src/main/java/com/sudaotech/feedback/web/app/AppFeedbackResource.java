package com.sudaotech.feedback.web.app;

import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.feedback.service.FeedbackService;
import com.sudaotech.feedback.service.FeedbackService.Feedback;
import com.sudaotech.util.MapHelper;

@Path("/app/feedback")
public class AppFeedbackResource extends BaseResource {

    @Inject
    private FeedbackService feedbackService;
    
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
        result.setLocation(String.format("/app/feedback/%s", id));
        result.setData(map);
        return result;
    }
}
