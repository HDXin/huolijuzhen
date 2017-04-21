package com.sudaotech.huolijuzhen.community.web.admin.enterprise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Query;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/admin/enterprise/community")
public class AdminEnterpriseCommunityResource extends BusinessBaseResource {

    @Inject
    private CommunityService communityService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    /**
     * 获取指定 ID 的活动信息
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> getInfoOfMap(@NotNull @PathParam("id") final Long id) {
    	
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		
        	Map<String,Object> dataMap = new HashedMap<String, Object>();
        	Community obj = communityService.getById(id);
            if(obj != null){
            	dataMap = packItemInfo(obj);            	
            }    	
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
        
    }
    
    /**
     * 获取当前用户有权限的活动
     * @param query
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findByCurrentUser(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parkId") Long parkId) {
    	
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		
    		//1.按条件查询活动
    		//TODO 
        	Page<Community> page = null;
        	ParkInfo parkInfo = null;
    		if(parkId != null && parkId != -1){
        		 parkInfo = parkInfoService.getById(parkId);
    		}
    		page = communityService.findByCurrentUser(query, parkInfo);
        	//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Community> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Community comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		}catch(Exception e){
			logger.error("企业获取社群活动列表 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
		}
    	
    }
    
//    /**
//     * 获取当前用户参与过的活动
//     * @param query
//     * @return
//     */
//    @GET
//    @Path("/historyCommunity")
//    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
//    public Result<Map<String, Object>> findHistoryCommunity(
//    		@QueryParam("offset") Integer offset,
//            @QueryParam("limit") Integer limit,
//            @QueryParam("page") Integer pageNum,
//            @QueryParam("parkId") Long parkId) {
//    	
//    	try{
//    		
//    		//1.Session 为空时返回
//    		if(sessionIsNull()){
//    			return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
//    		}
//    		Session session = getSessionQuietly();
//    		
//    		//2.parkId不能为空
//			Long companyId = session.getPlatformId();
//    		if(parkId == null){
//				return new Result<Map<String,Object>>(ResultCode.PARK_ID_NOT_NULL);
//			}
//    		//3.获取所有的社群活动ID
//    		List<Long> communityIds = communityApplyService.findAllByEnterpriseIdAndParkId(companyId, parkId);
//    		if(CollectionUtils.isEmpty(communityIds)){
//    			return new Result<Map<String,Object>>(ResultCode.OK,packPageInfo(new Page<Community>()));
//    		}
//
//    		//4.分页获取社群活动
//    		Query query = new Query();
//    		query.setOffset(offset);
//    		query.setLimit(limit);
//    		query.setPage(pageNum);
//    		query.setParkId(parkId);
//    		query.setCommunityIds(communityIds);
//    		
//    		//5.按条件查询活动
//        	Page<Community> page = communityService.find(query);
//        	//6.封装活动信息
//        	Map<String, Object> dataMap = packPageInfo(page);
//        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
//		}catch(Exception e){
//			logger.error("企业获取社群活动列表 error:{}",e);
//			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
//		}
//    	
//    }
    
//    /**
//     * 分装返回结果
//     * @return
//     */
//    private Map<String, Object> packPageInfo(Page<Community> page){
//    	Map<String, Object> dataMap = new HashMap<String, Object>();
//    	dataMap.put("offset", page.getOffset());
//    	dataMap.put("limit", page.getLimit());
//    	dataMap.put("total", page.getTotal());
//    	dataMap.put("sortField", page.getSortField());
//    	dataMap.put("sortOrder", page.getSortOrder());
//    	
//    	List<Community> list = page.getItems();
//    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
//    	Map<String, Object> item = new HashedMap<String, Object>();
//    	if(CollectionUtils.isNotEmpty(list)){
//    		for(Community pc:list){
//    			item = new HashedMap<String, Object>();
//    			item = packListInfo(pc);
//    			items.add(item);
//    		}
//    	}
//    	dataMap.put("items", items);
//    	return dataMap;
//    }
    
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Community comm){
    	
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.put("id", comm.getId());
    	infoMap.put("title", notNull(comm.getTitle()));
    	infoMap.put("discrible", notNull(comm.getDiscrible()));
    	infoMap.put("content", notNull(comm.getContent()));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	infoMap.put("approvalTime", sdf.format(comm.getApprovalTime()));

    	List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.COMMUNITY_MAIN, comm.getId());
    	infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
    	infoMap.put("detailUrl", HuolijuzhenConfig.getInstance().getDomainHtmlUrl() + "/static/community.html?id=" + comm.getId());
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Community comm){
    	
    	Map<String, Object> infoMap = packListInfo(comm);
    	
    	List<ImageInfo> listImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.COMMUNITY_LIST, comm.getId());
    	infoMap.put("listImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(listImageInfos)){
    		infoMap.put("listImage", imageInfoListToMap(listImageInfos));
    	}

    	return infoMap;
    }
    
}
