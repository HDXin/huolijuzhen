package com.sudaotech.huolijuzhen.sys.common.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService.Announcement;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

@Path("/detail/announcement")
public class DetailAnnouncementResource extends BusinessBaseResource {

    @Inject
    private AnnouncementService announcementService;
    
    @Inject
    private AdminUserService adminUserService;

    /**
     * 根据 ID 获取制定公告
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
	        Announcement obj = announcementService.getById(id);
	        Map<String, Object> dataMap = new HashedMap<String, Object>();
	        if(obj != null){
	        	dataMap = packItemInfo(obj);
	        }
	        
	        return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台获取公告详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Announcement item){
    	Map<String, Object> infoMap = new HashMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	
    	AdminUser adminUser = adminUserService.getById(item.getCreateBy());
    	infoMap.put("createBy", notNull(adminUser.getUsername()));
    	infoMap.put("createTime", notNull(item.getCreateTime()));
		infoMap.put("approvalStatus", notNull(item.getApprovalStatus()));
    	infoMap.put("content", notNull(item.getContent()));
    	infoMap.put("sendGrade", notNull(item.getSendGrade()));
    	infoMap.put("publicGrade", notNull(item.getPublicGrade()));
    	infoMap.put("sendGrade", notNull(item.getSendGrade()));
		infoMap.put("proId", notNull(item.getProId()));
		infoMap.put("cityId", notNull(item.getCityId()));
		infoMap.put("counId", notNull(item.getCounId()));
		infoMap.put("locationId", notNull(item.getLocationId()));
		infoMap.put("detailUrl", HuolijuzhenConfig.getInstance().getDomainHtmlUrl() + "/static/notice.html?id=" + item.getId());
		
		return infoMap;
    }
}

