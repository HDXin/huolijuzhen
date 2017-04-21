package com.sudaotech.huolijuzhen.community.web.admin.platform;

import java.util.ArrayList;
import java.util.Date;
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
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Query;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/community")
public class AdminPlatformCommunityResource extends BusinessBaseResource {

    @Inject
    private CommunityService communityService;

    /**
     * 新增活动
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Community obj) {
        // create
        Result<Map<String, Long>> result = null;
    	try{
    		
    		if(sessionIsNull()){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		Long userId = session.getUserId();
    		
    		//1.提取申请单中有效信息
    		Community temp = extractValidInfo(obj);
    		
    		//2.设置服务器端维护信息
        	temp.setOperator(userId);
        	temp.setCreateSide(CreateSide.PLATFORM);
        	
        	//3.记录操作记录
        	//TODO
        	
            //4.保存信息到数据库
            Long id = communityService.create(temp);
            
            //5.保存图片信息（主图）
            List<ImageInfo> mainImageInfos = obj.getMainImage();
            createImageInfo(ImageType.COMMUNITY_MAIN, id, mainImageInfos);
            //列表图
            List<ImageInfo> listImageInfos = obj.getListImage();
            createImageInfo(ImageType.COMMUNITY_LIST, id, listImageInfos);

            //5.设置响应信息
            Map<String, Long> map = MapHelper.put("id", id).getMap();
            result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/community/getInfoOfMap/%s", id));
            result.setData(map);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		result= new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
        return result;
    }

    /**
     * 编辑活动
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final Community obj) {
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		
    		//2.提取封装编辑表单提交的有效信息
        	Community temp = extractValidInfo(obj);
        	
        	//3.设置信息
            temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            
            //4.更新图片信息
            List<ImageInfo> mainImageInfos = obj.getMainImage();
            updateImageInfo(ImageType.COMMUNITY_MAIN, id, mainImageInfos);
            
            List<ImageInfo> listImageInfos = obj.getListImage();
            updateImageInfo(ImageType.COMMUNITY_LIST, id, listImageInfos);
            
            //5.保存操作记录
            //TODO
            
            //6.更新操作
            communityService.update(temp);
            
            return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
    		return  new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    
    /**
     * 删除指定 ID 的活动
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		//2.删除操作
            deleteItemById(id);
            
            //3.保存操作记录
            //TODO
            return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    }

    /**
     * 批量删除指定 List<Long> ids 的活动
     * @param ids
     * @return
     */
    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	
    	try{
    		//1.删除元素
	    	if (CollectionUtils.isNotEmpty(ids)) {
//				for (Long id:ids) {
		    		//1.判断当前用户是否有对当前内容编辑的权限
//		    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(item.getId(), getSession().getUserId());
//		    		if(!hasEditPrivilege){
//		    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//		    		}
//				}
				for (Long id:ids) {
					deleteItemById(id);
				}
	    	}
	    	//2.保存操作记录
	    	//TODO
	    	
	    	return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("批量删除活动 error:" , e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 删除指定ID元素
     * @param id
     */
    private void deleteItemById(Long id){
    	Community obj = new Community();
        
        obj.setDeleteBy(getSessionQuietly().getUserId());
        obj.setDeleteTime(new Date());
        obj.setStatus(Status.DELETED);
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        communityService.update(obj);
    }

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
     * 终止活动
     * @param id
     * @return
     */
    @PUT
    @Path("/termination/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> termination(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		//2.进行终止操作
        	Community obj = new Community();
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            
            obj.setTerminateBy(getSessionQuietly().getUserId());
            obj.setTerminateTime(new Date());
            obj.setApprovalStatus(ApprovalStatus.TERMINATION);
            
            //3.保存操作记录
            //TODO
            
            communityService.update(obj);
            return ResultSupport.ok();    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    }
    
    /**
     * 审批活动
     * @param id
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final Community obj) {
    	try{
    		//1.判断当前用户是否有对当前内容编辑的权限
//    		Boolean hasEditPrivilege = communityService.hasEditPrivilegeById(id, getSession().getUserId());
//    		if(!hasEditPrivilege){
//    			return new Result<String>(ResultCode.NOT_ITEM_EDIT_PRIVILEGE);
//    		}
    		//2.进行审批操作
        	Community comm = new Community();
            comm.setId(id);
            comm.setOperator(getSessionQuietly().getUserId());
            
            comm.setApprovalBy(getSessionQuietly().getUserId());
            if(obj.getApprovalStatus() == ApprovalStatus.ALREADYPASS || obj.getApprovalStatus() == ApprovalStatus.NOPASS){
                comm.setApprovalStatus(ApprovalStatus.ALREADYPASS);        	
            }else{
            	comm.setApprovalStatus(ApprovalStatus.NOPASS);
            }
            comm.setApprovalMemo(obj.getApprovalMemo());
            comm.setApprovalTime(new Date());
            
            //3.保存操作记录
            //TODO
            
            communityService.update(comm);
            return ResultSupport.ok();    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 按条件查询
     * @param query
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
    		@QueryParam("offset") Integer offset,
    		@QueryParam("limit") Integer limit,
    		@QueryParam("page") Integer pages,
    		@QueryParam("title") String title,
    		@QueryParam("startDate") String startDate,
    		@QueryParam("endDate") String endDate,
    		@QueryParam("approvalStatus") String approvalStatus) {
    	
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);
    		query.setTitle(title);
    		query.setStartDate(startDate);
    		query.setEndDate(endDate);
    		query.setApprovalStatus(approvalStatus);
    		
    		//1.按条件查询活动
        	Page<Community> page = communityService.find(query,CreateSide.PLATFORM,null);
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
			e.printStackTrace();
			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
		}
    	
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Community extractValidInfo(Community temp){
    	Community obj = new Community();
    	ApprovalStatus approvlStatus = temp.getApprovalStatus();
    	if(ApprovalStatus.WAITSUBMIT.equals(approvlStatus) || ApprovalStatus.WAITAPPROVAL.equals(approvlStatus)){
    		obj.setApprovalStatus(temp.getApprovalStatus());
    	}else{
    		obj.setApprovalStatus(ApprovalStatus.WAITSUBMIT);
    	}
    	
    	if(PublicGrade.ADMINISTRACTIVE.equals(temp.getPublicGrade())){
    		obj.setProId(temp.getProId());
    		obj.setCityId(temp.getCityId());
    		obj.setCounId(temp.getCounId());
    		obj.setLocationId(temp.getLocationId());
    	}else{
    		temp.setPublicGrade(PublicGrade.PLATFORM);
    	}
    	obj.setPublicGrade(temp.getPublicGrade());

    	obj.setTitle(temp.getTitle());
    	obj.setDiscrible(temp.getDiscrible());
    	obj.setContent(temp.getContent());
    	
    	return obj;
    }
    
   
    
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Community comm){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", comm.getId());
    	infoMap.put("title", notNull(comm.getTitle()));
    	infoMap.put("createBy", notNull(comm.getCreateBy()));
    	infoMap.put("createTime", notNull(comm.getCreateTime()));
    	infoMap.put("publicGrade", notNull(comm.getPublicGrade()));
    	infoMap.put("approvalStatus", notNull(comm.getApprovalStatus()));
    	
    	return infoMap;
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
    	infoMap.put("describle", notNull(comm.getDiscrible()));
    	infoMap.put("content", notNull(comm.getContent()));
    	infoMap.put("createBy", notNull(comm.getCreateBy()));
    	infoMap.put("createTime", notNull(comm.getCreateTime()));
    	infoMap.put("publicGrade", notNull(comm.getPublicGrade()));
    	infoMap.put("approvalStatus", notNull(comm.getApprovalStatus()));
    	
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
    	
    	return infoMap;
    }
}
