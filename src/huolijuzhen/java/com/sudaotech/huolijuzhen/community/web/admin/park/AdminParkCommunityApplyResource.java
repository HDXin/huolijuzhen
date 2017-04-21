package com.sudaotech.huolijuzhen.community.web.admin.park;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
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
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService.CommunityApply;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService.Query;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;

@Path("/admin/park/communityApply")
public class AdminParkCommunityApplyResource extends BusinessBaseResource {

    @Inject
    private CommunityApplyService communityApplyService;
    
    @Inject
    private CommunityService communityService;
    
    /**
     * 审批申请单
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final CommunityApply obj) {
    	
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Long userId = session.getUserId();
    		//1.获取指定申请单
    		CommunityApply temp = communityApplyService.getById(id);
    		if(temp == null){
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		//2.根据当前登录用户获取当前用户所在园区
    		//TODO
    		
    		//3.判断所审批申请单是否属于该园区
    		//TODO
    		
    		//4.进行审批操作
        	CommunityApply comm = new CommunityApply();
            comm.setId(id);
            comm.setOperator(userId);
            
            ApprovalStatus approvalStatus = obj.getApprovalStatus();
            if(ApprovalStatus.ALREADYPASS.equals(approvalStatus) || ApprovalStatus.NOPASS.equals(approvalStatus)){
            	comm.setApprovalStatus(obj.getApprovalStatus());
            }else{
            	return new Result<String>(ResultCode.APPROVAL_CODE_INVALID);
            }
            comm.setApprovalBy(getSessionQuietly().getUserId());
            comm.setApplyTime(new Date());
            comm.setApprovalText(obj.getApprovalText());
            communityApplyService.update(obj);
            
           //5.推送消息
            CommunityApply tempCommunityApply = communityApplyService.getById(id);
            if(tempCommunityApply == null){
            	return new Result<String>(ResultCode.NOT_FOUND);
            }
            
            String content = NoticeConstants.Enterprise.Activity.APPLY_PASS;
        	if(ApprovalStatus.NOPASS.equals(approvalStatus)){
        		content = NoticeConstants.Enterprise.Activity.APPLY_FAIL;
        	}
        	
        	Message message = new Message();
            message.setMsgBizType(MsgBizType.ACTIVITY_APPLY);
            message.setBizId(id);
            message.setMsgType(MsgType.GROUP_ACTIVITY);
            message.setSrc(userId);
            message.setMsgStatus(MsgStatus.CREATE);
            message.setSourceType(SourceType.SYSTEM_NOTICE);
            message.setTitle(content);
            message.setContent(content);
            message.setParkId(tempCommunityApply.getParkId());
            
            List<Long> dstIds = new ArrayList<Long>();
            dstIds.add(tempCommunityApply.getCreateBy());
            
            sendMessageToUser(dstIds,message);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("园区审批活动申请单 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 根据 ID 获取申请活动订单的详细信息
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> get(@NotNull @PathParam("id") final Long id) {
        
    	try{
    		//1.获取指定申请单
        	CommunityApply comm = communityApplyService.getById(id);
        	//2.根据当前登录用户获取当前用户所在园区
    		//TODO
    		
    		//3.判断所查申请单是否属于该园区
        	
        	//4.返回查询结果
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	if(comm != null){
            	dataMap = packItemInfo(comm);        		
        	}

            return new Result<Map<String,Object>>(comm == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    		
    	}catch(Exception e){
    		logger.error("园区活动活动申请单详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 按条件查询
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("companyName") String companyName,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("communityName") String communityName) {
    	
		try{
			if(sessionIsNull()){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			Session session = getSessionQuietly();
			Long parkId = session.getPlatformId();
			
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pages);
			query.setCompanyName(companyName);
			query.setStartDate(startDate);
			query.setEndDate(endDate);
			query.setCommunityName(communityName);
			
			//1.获取当前用户所在的园区
			//TODO
			query.setCreateSide(CreateSide.PARK);
			query.setCreateParkId(parkId);
			
    		//2.按条件查询活动
        	Page<CommunityApply> page = communityApplyService.findByCondition(query);
        	//3.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<CommunityApply> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(CommunityApply comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		}catch(Exception e){
			logger.error("园区活动申请单列表 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
	}
    /**
     * 按条件查询
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @POST
    @Path("/findByCondition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findByCondition(
            @Valid final Query query) {
    	
		try{
			//1.获取当前用户所在的园区
			//TODO
			query.setCreateSide(CreateSide.PARK);
			query.setCreateParkId(123L);
			
    		//2.按条件查询活动
        	Page<CommunityApply> page = communityApplyService.findByCondition(query);
        	//3.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<CommunityApply> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(CommunityApply comm:list){
        			item = packListInfo(comm);
        			items.add(item);
        		}
        		dataMap.put("items", items);
        	}
        	
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
		}catch(Exception e){
			e.printStackTrace();
			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
		}
	}
    
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(CommunityApply comm){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", comm.getId());
    	infoMap.put("orderNo", notNull(comm.getOrderNo()));
    	infoMap.put("createTime", notNull(comm.getCreateTime()));
    	infoMap.put("comanyName", notNull(comm.getCompanyName()));
    	infoMap.put("proprser", notNull(comm.getProprser()));
    	infoMap.put("num", notNull(comm.getNum()));
    	infoMap.put("approvalStatus", comm.getApprovalStatus());
    	Long communityId = comm.getCommunityId();
    	Community community = communityService.getById(communityId);
    	infoMap.put("communityName", "");
    	if(community != null){
        	infoMap.put("communityName", notNull(community.getTitle()));
    	}
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(CommunityApply comm){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", comm.getId());
		infoMap.put("orderNo", notNull(comm.getOrderNo()));
		infoMap.put("applyTime", notNull(comm.getApplyTime()));
		infoMap.put("companyId", notNull(comm.getCompanyId()));
		infoMap.put("companyName", notNull(comm.getCompanyName()));
		infoMap.put("proprser", notNull(comm.getProprser()));
		infoMap.put("phone", notNull(comm.getPhone()));
		infoMap.put("describle", notNull(comm.getDescrible()));
		infoMap.put("num", notNull(comm.getNum()));
		infoMap.put("approvalStatus", comm.getApprovalStatus());
		
		Long parkId = comm.getParkId();
		infoMap.put("parkId", notNull(parkId));
		infoMap.put("parkName", "");
		if(parkId != null && parkId != -1){
			ParkInfo parkInfo = parkInfoService.getById(parkId);
			if(parkInfo != null){
				infoMap.put("parkName", parkInfo.getName());
			}
		}
		
    	return infoMap;
    }
}
