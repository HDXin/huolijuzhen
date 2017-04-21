package com.sudaotech.huolijuzhen.announcement.web.admin.platform;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService.Announcement;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService.Query;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.enums.SendGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/announcement")
public class AdminPlatformAnnouncementResource extends BusinessBaseResource {

    @Inject
    private AnnouncementService announcementService;
    
    @Inject
    private AdminUserService adminUserService;
 
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;

    /**
     * 添加公告
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Announcement obj) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		Announcement temp = extractValidInfo(obj);
    		
    		temp.setOperator(session.getUserId());
	        Long id = announcementService.create(temp);
	        Map<String, Long> map = MapHelper.put("id", id).getMap();
	
	        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
	        result.setLocation(String.format("/announcement/%s", id));
	        result.setData(map);
	        return result;
    	}catch(Exception e){
    		logger.error("平台创建公告 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑公告
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
            @Valid final Announcement obj) {
    	try{
    		if(sessionIsNull()){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
    		Announcement temp = extractValidInfo(obj);
	        temp.setId(id);
	        temp.setOperator(session.getUserId());
	        announcementService.update(temp);
	        return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台编辑公告 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 删除指定 ID 的公告
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
    		if(sessionIsNull()){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
	        Announcement obj = new Announcement();
	        obj.setId(id);
	        obj.setStatus(Status.DELETED);
	        obj.setDeleteBy(session.getUserId());
	        obj.setDeleteTime(new Date());
	        announcementService.update(obj);
	        return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台删除公告 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 批量删除公告
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
    		if(sessionIsNull()){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
        	if (CollectionUtils.isNotEmpty(ids)) {
        		Announcement obj = null;
    			for (Long id : ids) {
    				obj = new Announcement();
    				obj.setId(id);
    				obj.setStatus(Status.DELETED);
    				obj.setDeleteBy(session.getUserId());
    				obj.setDeleteTime(new Date());
    				
    				announcementService.update(obj);
    			}
        	}
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("平台批量删除公告 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

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
     * 审批公告
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final Announcement obj) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Long userId = session.getUserId();
        	Announcement temp = new Announcement();
        	
        	temp.setId(id);
            temp.setOperator(userId);
            
            if(obj.getApprovalStatus() == ApprovalStatus.ALREADYPASS || obj.getApprovalStatus() == ApprovalStatus.NOPASS){
                temp.setApprovalBy(session.getUserId());
                temp.setApprovalTime(new Date());
                temp.setApprovalStatus(obj.getApprovalStatus());
                temp.setApprovalText(obj.getApprovalText());
                announcementService.update(temp);
                
                //2.审批通过发送公告通知、并插入消息到数据库
                Announcement announcement = announcementService.getById(id);
                if(announcement == null){
                	return new Result<String>(ResultCode.NOT_FOUND);
                }
                List<Long> userIds = findAllValidUserIds(id);
                if(CollectionUtils.isEmpty(userIds)){
                	return new Result<String>(ResultCode.NOT_FOUND);
                }
                
                Message message = new Message();
                message.setMsgBizType(MsgBizType.NOTICE);
                message.setBizId(id);
                message.setMsgType(MsgType.SYSTEM_NOTICE);
                message.setSrc(userId);
                message.setMsgStatus(MsgStatus.CREATE);
                message.setSourceType(SourceType.SYSTEM_NOTICE);
                message.setTitle(announcement.getTitle());
                message.setContent(announcement.getTitle());
                message.setParkId(-1L);
                
                sendMessageToUser(userIds,message);
                
                return ResultSupport.ok();	
            }else{
            	return new Result<String>(ResultCode.APPROVAL_CODE_INVALID);
            }    		
    	}catch(Exception e){
    		logger.error("平台审批公告 error:{}" + e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    private List<Long> findAllValidUserIds(Long id){
    	List<Long> userIds = new ArrayList<Long>();
    	Announcement announcement = announcementService.getById(id);
    	PublicGrade publicGrade = announcement.getPublicGrade();
    	SendGrade sendGrade = announcement.getSendGrade();
    	
    	//1.用户范围为：平台
    	if(PublicGrade.PLATFORM.equals(publicGrade)){
    		//1.1 所有的企业用户、园区用户
    		if(SendGrade.ALLUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllParkEnterpriseUserId();
    		}
    		//1.2所有的园区用户（服务商用户除外）
    		else if(SendGrade.PARKUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllParkUserId();
    		}
    		//1.3所有的企业用户
    		else if(SendGrade.ENTERPRISEUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllEnterpriseUerId();
    		}
    	}
    	//2.用户范围为：行政区
    	else if(PublicGrade.ADMINISTRACTIVE.equals(publicGrade)){
    		Long proId = announcement.getProId();
    		Long cityId = announcement.getCityId();
    		Long counId = announcement.getCounId();
    		Long locationId = announcement.getLocationId();
    		
			Map<String, Object> locationIds = new HashedMap<String, Object>();
			locationIds.put("proId", proId);
			locationIds.put("cityId", cityId);
			locationIds.put("counId", counId);
			locationIds.put("locationIds", locationId);

    		List<Long> parkIds = parkInfoService.findAllParkIds(locationIds);
    		
    		List<Long> enterpriseIds = new ArrayList<Long>();
    		if(CollectionUtils.isNotEmpty(parkIds)){

    			for(Long parkId:parkIds){
        			List<EnterpriseCott> tempEnterpriseCotts = enterpriseCottService.getEnterPriseCottByParkId(parkId);
    				if(CollectionUtils.isNotEmpty(tempEnterpriseCotts)){
    					for(EnterpriseCott item:tempEnterpriseCotts){
    						enterpriseIds.add(item.getEnterpriseId());
    					}
    				}
    			}
    		}
    		
    		//2.1指定行政区内的所有的园区用户、企业用户
    		if(SendGrade.ALLUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(parkIds,enterpriseIds);
    			
    		}
    		//2.2 指定行政区内所有的园区用户
    		else if(SendGrade.PARKUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllParkUserIdByParkIds(parkIds);
    		}
    		//2.3指定行政区内所有的企业用户
    		else if(SendGrade.ENTERPRISEUSER.equals(sendGrade)){
    			userIds = adminUserService.findAllEnterpriseUserIdByEnterpriseIds(enterpriseIds);
    		}
    	}
    	return userIds;
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
            @QueryParam("endDate") String endDate) {

    	Page<Announcement> page = null;
		try {
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pages);
			query.setStartDate(startDate);
			query.setEndDate(endDate);
			query.setTitle(title);
			query.setQuerySide(CreateSide.PLATFORM);
			
			page = announcementService.findByCondition(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Announcement> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Announcement anno:list){
        			item = packListInfo(anno);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		} catch (ParseException e) {
			logger.error("平台获取公告列表 error:{}",e);
			return new Result<Map<String, Object>>(ResultCode.BAD_REQUEST);
		}
    } 
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Announcement extractValidInfo(Announcement temp){
    	Announcement obj = new Announcement();

    	obj.setTitle(temp.getTitle());
    	obj.setContent(temp.getContent());
    	obj.setCreateSide(CreateSide.PLATFORM);
    	obj.setSendGrade(temp.getSendGrade());
    	PublicGrade publicGrade = temp.getPublicGrade();
    	obj.setPublicGrade(publicGrade);
    	if(PublicGrade.ADMINISTRACTIVE.equals(publicGrade)){
    		obj.setParkId(temp.getParkId());
    		obj.setCityId(temp.getCityId());
    		obj.setCounId(temp.getCounId());
    		obj.setLocationId(temp.getLocationId());
    	}
    	
    	if(temp.getApprovalStatus().equals(ApprovalStatus.WAITSUBMIT) || temp.getApprovalStatus().equals(ApprovalStatus.WAITAPPROVAL)){
    		obj.setApprovalStatus(temp.getApprovalStatus());
    	}else{
    		obj.setApprovalStatus(ApprovalStatus.WAITSUBMIT);
    	}
    	 
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Announcement item){
    	Map<String, Object> infoMap = new HashMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	
    	AdminUser adminUser = adminUserService.getById(item.getCreateBy());
    	infoMap.put("createBy", notNull(adminUser.getUsername()));
    	infoMap.put("createTime", notNull(item.getCreateTime()));
		infoMap.put("sendGrade", notNull(item.getSendGrade()));
		infoMap.put("approvalStatus", notNull(item.getApprovalStatus()));
    	
		return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Announcement item){
    	Map<String, Object> infoMap = packListInfo(item);
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("content", notNull(item.getContent()));
    	infoMap.put("sendGrade", notNull(item.getSendGrade()));
    	infoMap.put("publicGrade", notNull(item.getPublicGrade()));
    	infoMap.put("sendGrade", notNull(item.getSendGrade()));
		infoMap.put("proId", notNull(item.getProId()));
		infoMap.put("cityId", notNull(item.getCityId()));
		infoMap.put("counId", notNull(item.getCounId()));
		infoMap.put("locationId", notNull(item.getLocationId()));

		return infoMap;
    }
}

