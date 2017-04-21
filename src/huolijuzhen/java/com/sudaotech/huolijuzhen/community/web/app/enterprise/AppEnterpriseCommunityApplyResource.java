package com.sudaotech.huolijuzhen.community.web.app.enterprise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService.CommunityApply;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService.Query;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/app/enterprise/communityApply")
public class AppEnterpriseCommunityApplyResource extends BusinessBaseResource {

    @Inject
    private CommunityApplyService communityApplyService;
    
    @Inject
    private CommunityService CommunityService;
    
    /**
     * 提交申请单
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final CommunityApply obj) {
        // create
    	
    	try{
    		//1.session 为空时抛出异常
    		if(sessionIsNull()){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		
    		//2.提取有效数据
    		CommunityApply temp = extractValidInfo(obj);
    		
    		//3.根据活动 ID 获取活动的创建方
    		Long communityId = temp.getCommunityId();
    		Community community = CommunityService.getById(communityId);
    		if(community == null){
    			return new Result<Map<String,Long>>(ResultCode.PARAM_ERROR);
    		}
    		temp.setCommunityName(community.getTitle());
    		temp.setCreateSide(community.getCreateSide());
    		if(CreateSide.PARK.equals(temp.getCreateSide())){
    			//活动的创建方（园区 ID）
    			temp.setCreateSideId(community.getCreateSideId());
    		}

    		//4.根据当前提交表单的用户，活动当前用户所属企业
    		Long companyId = session.getPlatformId();
    		temp.setCompanyId(companyId);
    		EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(companyId);
    		if(enterpriseInfo != null){
    			temp.setCompanyName(enterpriseInfo.getName());
    		}
    		//5.生成申请单号
    		temp.setOrderNo(createApplyNo());
    		
    		temp.setOperator(session.getUserId());
            Long id = communityApplyService.create(temp);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/communityApply/%s", id));
            result.setData(map);
            return result;
	
    	}catch(Exception e){
    		logger.error("企业提交活动申请单 error:",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
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
        	CommunityApply comm = communityApplyService.getById(id);
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	if(comm != null){
            	dataMap = packItemInfo(comm);        		
        	}

            return new Result<Map<String,Object>>(comm == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    
    
    /**
     * 分页获取申请历史记录
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findHistory(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parkId") Long parkId) {
    	
		try{
			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setParkId(parkId);
			
			//1.根据当前登录用户，获取所属企业
			//
			Long companyId = getSessionQuietly().getPlatformId();
			query.setCompanyId(companyId);
    		//1.按条件查询活动
        	Page<CommunityApply> page = communityApplyService.findHistoryByCondition(query);
        	//2.封装活动信息
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
			e.printStackTrace();
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
	}

    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private CommunityApply extractValidInfo(CommunityApply temp){
    	CommunityApply obj = new CommunityApply();

    	//表单填写信息
    	obj.setProprser(temp.getProprser());
    	obj.setPhone(temp.getPhone());
    	obj.setNum(temp.getNum());
    	obj.setDescrible(temp.getDescrible());
    	obj.setParkId(temp.getParkId());
    	obj.setCommunityId(temp.getCommunityId());
    	obj.setApprovalStatus(ApprovalStatus.WAITAPPROVAL);

    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(CommunityApply comm){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	infoMap.put("id", comm.getId());
    	infoMap.put("createTime", notNull(sdf.format(comm.getCreateTime())));
    	infoMap.put("num", notNull(comm.getNum()));
    	infoMap.put("approvalStatus", comm.getApprovalStatus());
    	
    	Long communityId = comm.getCommunityId();
    	Community community = CommunityService.getById(communityId);
    	infoMap.put("communityTitle", notNull(community.getTitle()));
    	
    	List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.COMMUNITY_MAIN, comm.getCommunityId());
    	infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}	
    	
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(CommunityApply comm){
    	Map<String, Object> infoMap = packListInfo(comm);
    	
		infoMap.put("orderNo", notNull(comm.getOrderNo()));
		infoMap.put("proprser", notNull(comm.getProprser()));
		infoMap.put("phone", notNull(comm.getPhone()));
		infoMap.put("describle", notNull(comm.getDescrible()));
		infoMap.put("parkId", notNull(comm.getParkId()));

    	return infoMap;
    }
    
    
}
