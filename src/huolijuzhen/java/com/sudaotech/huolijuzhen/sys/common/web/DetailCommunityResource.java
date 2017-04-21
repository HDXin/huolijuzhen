package com.sudaotech.huolijuzhen.sys.common.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/detail/community")
public class DetailCommunityResource extends BusinessBaseResource {

    @Inject
    private CommunityService communityService;
    
    /**
     * 获取指定 ID 的活动信息
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> getInfoOfMap(@NotNull @PathParam("id") final Long id) {
    	Community obj;
    	Map<String,Object> dataMap = new HashedMap<String, Object>();
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		
            obj = communityService.getById(id);
            if(obj != null){
            	dataMap = packItemInfo(obj);            	
            }    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
        return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Community comm){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", comm.getId());
    	infoMap.put("title", notNull(comm.getTitle()));
    	infoMap.put("discrible", notNull(comm.getDiscrible()));
    	infoMap.put("content", notNull(comm.getContent()));
    	infoMap.put("createBy", notNull(comm.getCreateBy()));
    	infoMap.put("createTime", notNull(comm.getCreateTime()));
    	infoMap.put("publicGrade", notNull(comm.getPublicGrade()));
    	infoMap.put("approvalStatus", notNull(comm.getApprovalStatus()));
    	
    	infoMap.put("proId", notNull(comm.getProId()));
    	infoMap.put("cityId", notNull(comm.getCityId()));
    	infoMap.put("counId", notNull(comm.getCounId()));
    	infoMap.put("locationId", notNull(comm.getLocationId()));
    	
    	List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.COMMUNITY_MAIN, comm.getId());
    	infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
    	
    	List<ImageInfo> listImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.COMMUNITY_LIST, comm.getId());
    	infoMap.put("listImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(listImageInfos)){
    		infoMap.put("listImage", imageInfoListToMap(listImageInfos));
    	}
    	infoMap.put("detailUrl", HuolijuzhenConfig.getInstance().getDomainHtmlUrl() + "/static/activity.html?id=" + comm.getId());
    	
    	return infoMap;
    }
    
}
