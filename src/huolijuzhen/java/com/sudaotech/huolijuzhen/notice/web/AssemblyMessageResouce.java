package com.sudaotech.huolijuzhen.notice.web;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.notice.service.NoticeParkService;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;


@Path("/{platformSource}/assembly/message")
public class AssemblyMessageResouce extends BaseResource {
	
	@Inject
	private NoticeEnterpriseService noticeEnterpriseService;
	
	@Inject
	private NoticeParkService noticeParkService;
	
	
    @POST
    @Path("/sendMsg")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> sendMsg(@Valid final Message  obj,
    		@NotNull @PathParam("platformSource") String platformSource){
    	
    	if(platformSource.equals("park")){
    		noticeParkService.sendNoicMessage(obj.getDst().toString(), obj.getContent().toString());
    	}
    	if(platformSource.equals("enterprise")){
    		noticeEnterpriseService.sendNoicMessage(obj.getDst().toString(), obj.getContent().toString());
    	}
    
	    return new Result<String>(ResultCode.OK);
   }
    
    @POST
    @Path("/users")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> sendMsg(@Valid List<Long>  ids,
    		@NotNull @PathParam("platformSource") String platformSource){
    	if(platformSource.equals("park")){
    	if(CollectionUtils.isNotEmpty(ids)){
    		for (Long userId : ids) {
    			noticeParkService.registerUser(userId);
			}
    		
    	}
    	}
    	if(platformSource.equals("enterprise")){
    		for (Long userId : ids) {
    			noticeEnterpriseService.registerUser(userId);
			}
    		
    	}
    
	    return new Result<String>(ResultCode.OK);
   }
   
}
