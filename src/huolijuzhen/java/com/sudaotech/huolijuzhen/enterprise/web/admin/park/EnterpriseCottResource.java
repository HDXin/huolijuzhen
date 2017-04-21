package com.sudaotech.huolijuzhen.enterprise.web.admin.park;

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
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ContractResource;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService.EnterpriseCorrBusiness;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCottInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.Query;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import com.sudaotech.huolijuzhen.enums.CorrContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.ResourceInfo;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

/**
 * 
 * @Describe:       企业园区关联关系
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:47:23
 *
 */

@Path("/admin/park/ec")
public class EnterpriseCottResource extends BaseResource {

    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject
    private EnterpriseCorrBusinessService enterpriseCorrBusinessService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private MessageService messageService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject 
    private NoticeEnterpriseService noticeEnterpriseService;
    
    @Inject
    private ParkInfoService parkInfoService; 
    
    @Inject
    private ContractResourceService contractResourceService;
    
    @Inject
    private ResourceInfoService resourceInfoService;
    
    @Inject
    private ApprovalTypeService approvalTypeService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EnterpriseCott obj) {
    	
    	Long id=null;
    	
    	Session sessioin=getSessionQuietly();
    	
    	Long userId = sessioin.getUserId();
        // create
        obj.setOperator(userId);
        if(userId == null ){
        	return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
        }
        if(obj.getEnterpriseId() == null || obj.getEnterpriseId() ==0 ){
        	return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        }
        if(obj.getParkId() == null || obj.getCorrType() ==null){
        	return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        }
        //查询园区
        ParkInfo pi = parkInfoService.getById(obj.getParkId());
        if(pi == null){
        	return new Result<Map<String,Long>>(ResultCode.NOT_FOUND);
        }
        
        //合同关联
        if(obj.getCorrType() == CorrType.CONTRACT_RELATED){
        	if(CollectionUtils.isEmpty(obj.getCorrContract())){
        		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        	}
        	//已经入驻状态
            obj.setCorrStatus(CorrStatus.ALREADY_SETTLED);  
            obj.setCorrTime(new Date());
            id = enterpriseCottService.create(obj);
        	for (EnterpriseCorrContract corrCotract : obj.getCorrContract()) {
        		corrCotract.setEnterpriseCottId(id);
        		corrCotract.setContractStatus(CorrContractStatus.ONGOING.code());
        		enterpriseCorrContractService.create(corrCotract);
        		
//    	        //合同关联资源
//    	        if(CollectionUtils.isNotEmpty(corrCotract.getResourceInfos())){
//    	        	ContractResource contractResource = null;
//    	        	for(ResourceInfo resourceInfo:corrCotract.getResourceInfos()){
//    	        		contractResource = new ContractResource();
//    	        		
//    	        		contractResource.setContractId(corrCotract.getContractId());
//    	        		contractResource.setResourceId(resourceInfo.getId());
//    	        		contractResource.setStartDate(corrCotract.getStartDate());
//    	        		contractResource.setEndDate(corrCotract.getEndDate());
//    	        		contractResource.setUseStatus(UseStatus.NOUSE);
//    	        		contractResource.setOperator(obj.getOperator());
//    	        		
//    	        		contractResourceService.create(contractResource);
//    	        		
//    	        		//维护资源状态
//    	        		resourceInfo.setUseStatus(UseStatus.USE);
//    	        		resourceInfo.setOperator(userId);
//    	        		resourceInfoService.update(resourceInfo);
//    	        	}
//    	        }
			}
        }
        //业务关联
        if(obj.getCorrType() == CorrType.BUSINESS_RELATED){
        	
        	if(CollectionUtils.isEmpty(obj.getCorrBusiness())){
        		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        	}
        	//未知入驻状态（待企业管理员确认）
            obj.setCorrStatus(CorrStatus.UNKNOWN);  
            id = enterpriseCottService.create(obj);
            
        	for (EnterpriseCorrBusiness businessContract : obj.getCorrBusiness()) {
        		businessContract.setEnterpriseCottId(id);
        		businessContract.setCottStatus(1);      //待关联确认状态
        		enterpriseCorrBusinessService.create(businessContract);
			}
            
        	//查询管理员信息
        	List<AdminUser> adminUsers=adminUserService.getAdminByEnterpriseId(obj.getEnterpriseId());
        	if(CollectionUtils.isNotEmpty(adminUsers)){
	        	//给企业管理员发送关联信息
	        	Message message = new Message();
	        	message.setDst(adminUsers.get(0).getUserId());
	
	            message.setContent(String.format(NoticeConstants.Enterprise.Cott.COTT_ASK, pi.getName()));
	            message.setBizId(id);
	            message.setMsgType(MsgType.PARK_RELATION);
	            message.setMsgBizType(MsgBizType.CONFIRM);
	            message.setSourceType(SourceType.SYSTEM_MESSAGE);
	            message.setSrc(userId);   
	            message.setMsgStatus(MsgStatus.CREATE);
	            message.setOperator(userId);
	            message.setParkId(-1L);
	        	messageService.create(message);
	        	
	        	//推送到手机app
	        	noticeEnterpriseService.sendNoicMessage(userId.toString(), message.getContent());
        	
        	}
        	
        }
        
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/enterpriseCott/%s", id));
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
            @Valid final EnterpriseCott obj) {
    	
    	Long userId = getSessionQuietly().getUserId();
    	
    	if(userId == null || userId==0 ){
    		return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
	    if(obj.getCorrType() ==null ){
         	return new Result<String>(ResultCode.BAD_REQUEST);
        }
        if(obj.getParkId() == null || obj.getCorrType() ==null){
        	return new Result<String>(ResultCode.BAD_REQUEST);
        }
	    
	    //查询当前关联关系
	 	EnterpriseCott ec=enterpriseCottService.getById(id);  
	 	
	 	if(ec == null){
	 		return new Result<String>(ResultCode.NOT_FOUND);
	 	}
	 	//查询园区
        ParkInfo pi = parkInfoService.getById(obj.getParkId());
        if(pi == null){
        	return new Result<String>(ResultCode.NOT_FOUND);
        }
    	//合同关联
        if(obj.getCorrType() == CorrType.CONTRACT_RELATED){
        	if(CollectionUtils.isEmpty(obj.getCorrContract())){
        		return new Result<String>(ResultCode.BAD_REQUEST);
        	}
        	for (EnterpriseCorrContract corrCotract : obj.getCorrContract()){
        		//存在新的合同关联
        		if(corrCotract.getId() == null){
        		   corrCotract.setEnterpriseCottId(id);
        		   enterpriseCorrContractService.create(corrCotract);
        		   //当前关联状态不为 已入驻状态则 更新为 入驻状态
        		   if(ec.getCorrStatus() !=CorrStatus.ALREADY_SETTLED){
        			   ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);
        			   ec.setCorrTime(new Date());
        			   ec.setOperator(userId);
        			   enterpriseCottService.update(ec);
        		   }
        		}else{
        		   enterpriseCorrContractService.update(corrCotract);
        		}

        		//合同关联资源
       	        if(CollectionUtils.isNotEmpty(corrCotract.getResourceInfos())){
       	        	ContractResource contractResource = null;
       	        	for(ResourceInfo resourceInfo:corrCotract.getResourceInfos()){
       	        		contractResource = new ContractResource();
       	        		
       	        		contractResource.setContractId(corrCotract.getContractId());
       	        		contractResource.setResourceId(resourceInfo.getId());
       	        		contractResource.setOperator(obj.getOperator());
       	        		
       	        		contractResourceService.create(contractResource);
       	        		
       	        		//维护资源状态
       	        		resourceInfo.setUseStatus(UseStatus.USE);
       	        		resourceInfo.setOperator(userId);
       	        		resourceInfoService.update(resourceInfo);
       	        	}
       	        }
        	
        	}
        }
        //业务关联
        if(obj.getCorrType() == CorrType.BUSINESS_RELATED){
        	
        	if(CollectionUtils.isEmpty(obj.getCorrBusiness())){
        		return new Result<String>(ResultCode.BAD_REQUEST);
        	}
            EnterpriseCorrBusiness ecb =  obj.getCorrBusiness().get(0);
        	//当前关联状态不为 已入驻状态
	 		if(ec.getCorrStatus() !=CorrStatus.ALREADY_SETTLED && ecb.getCottStatus() != 2){
	        	//查询管理员信息
	        	List<AdminUser> adminUsers=adminUserService.getAdminByEnterpriseId(obj.getEnterpriseId());
	        	if(CollectionUtils.isNotEmpty(adminUsers)){
		        	//给企业管理员发送关联信息
		        	Message message = new Message();
		        	message.setDst(adminUsers.get(0).getUserId());
		            message.setContent(String.format(NoticeConstants.Enterprise.Cott.COTT_ASK, pi.getName()));
		            message.setBizId(id);
		            message.setMsgType(MsgType.PARK_RELATION);
		            message.setMsgBizType(MsgBizType.CONFIRM);
		            message.setSourceType(SourceType.SYSTEM_MESSAGE);
		            message.setSrc(userId);   
		            message.setMsgStatus(MsgStatus.CREATE);
		            message.setOperator(userId);
		            message.setParkId(-1L);
		        	messageService.create(message);
		        	 
		        	//推送到手机app
		        	noticeEnterpriseService.sendNoicMessage(userId.toString(), message.getContent());
	        	
	        	}	   
	 		}
        }
        
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        EnterpriseCott obj = new EnterpriseCott();
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
    public Result<EnterpriseCott> get(@NotNull @PathParam("id") final Long id) {
        EnterpriseCott obj = enterpriseCottService.getById(id);
        
        return new Result<EnterpriseCott>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    /**
     *        通过企业Id获取关联信息详情（包括合同关联信息或业务关联信息）
     * @param enterpriseId
     * @return
     */
    @GET
    @Path("/detail/{enterpriseId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<EnterpriseCott> getDetail(@NotNull @PathParam("enterpriseId") final Long enterpriseId) {
    	
    	Session session = getSessionQuietly();
    	if(session.getUserId() == null || session.getUserId() ==0){
    		return new Result<EnterpriseCottService.EnterpriseCott>(ResultCode.SESSION_IS_NULL);
    	}
     	if(session.getPlatformId() == null || session.getPlatformId() ==0){
    		return new Result<EnterpriseCottService.EnterpriseCott>(ResultCode.BAD_REQUEST);
    	}
    	
    	EnterpriseCott obj =null;
    	
    	try {
	    	//获取关联关系
    		List<EnterpriseCott> ecs= enterpriseCottService.getEnterPriseCottByEnterpriseId(enterpriseId,session.getPlatformId());
	    	
	        if(CollectionUtils.isNotEmpty(ecs)){
	        	
	        	obj=ecs.get(0);          //有且只有一个对应关系；
	        	
	        	//合同关联
	        	if(obj.getCorrType() ==  CorrType.CONTRACT_RELATED){
	        		EnterpriseCorrContract ecc =new EnterpriseCorrContract();
	        		ecc.setEnterpriseCottId(obj.getId());
	        		List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);
	        		if(CollectionUtils.isNotEmpty(eccList)){
	        			//添加合同信息
	        			for (EnterpriseCorrContract enterpriseCorrContract : eccList) {
	        				enterpriseCorrContract.setCi(contractInfoService.getById(enterpriseCorrContract.getContractId()));
						}
	        		}
	        		obj.setCorrContract(eccList);
	        	}
	        	//业务关联
	            if(obj.getCorrType() ==  CorrType.BUSINESS_RELATED){
	            	
	        		EnterpriseCorrBusiness ebc =new EnterpriseCorrBusiness();
	        		ebc.setEnterpriseCottId(obj.getId());
	        		obj.setCorrBusiness(enterpriseCorrBusinessService.findByObj(ebc));
	            	
	        	}
	            
	            //判断是否启用了合同审批流
	           	//1.1  获取当前有效的合同审批流程
	        	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
	        			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);
	     
	            obj.setApprovalEnableStatus(EnableStatus.ENABLE == approvalType.getEnableStatus() ? true:false);
	        }
	    	
		} catch (Exception e) {
				logger.error("通过企业Id查询关联信息详情异常：{}",e);
				return new Result<EnterpriseCott>(ResultCode.INTERNAL_SERVER_ERROR,obj);
		}
        
        return new Result<EnterpriseCott>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
        
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EnterpriseCottInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("enterpriseName") String  enterpriseName,
            @QueryParam("corrStatus")CorrStatus corrStatus
    		) {
    	Session session=getSessionQuietly();
    	if(session.getUserId() == null || session.getUserId()==0){
    		return new Result<Page<EnterpriseCottInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Page<EnterpriseCottInfo>>(ResultCode.BAD_REQUEST);
    	}
    	
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setEnterpriseName(enterpriseName);
		query.setCorrStatus(corrStatus);
		query.setParkId(session.getPlatformId());
		
		Page<EnterpriseCottInfo> page = enterpriseCottService.findByObj(query);
        return new Result<Page<EnterpriseCottInfo>>(ResultCode.OK, page);
    }
}
