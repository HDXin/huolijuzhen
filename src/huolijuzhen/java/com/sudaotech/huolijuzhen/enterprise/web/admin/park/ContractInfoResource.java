package com.sudaotech.huolijuzhen.enterprise.web.admin.park;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.apache.commons.lang3.StringUtils;
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
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService.ApprovalProcess;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService.ApprovalProcessQuery;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService.ApprovalRecord;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItem;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItemQuery;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService.BillCcrAdj;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService.RollPeriod;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.ContractBill;
import com.sudaotech.huolijuzhen.enterprise.service.ContractDossierService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractDossierService.ContractDossier;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.Query;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ContractResource;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService.ResInfo;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.ResourceInfo;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.huolijuzhen.util.formula.FormulaParser;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.MapHelper;

/**
 * 
 * @Describe:       合同信息
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:48:05
 *
 */

@Path("/admin/park/contractInfo")
public class ContractInfoResource extends BaseResource {

    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private ContractDossierService contractDossierService;
    
    @Inject
    private BillCostCalRulesService  billCostCalRulesService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject
    private ContractResourceService contractResourceService;
    
    @Inject
    private ResourceInfoService resourceInfoService;
    
    @Inject
    private ResInfoService resInfoService;
    
    @Inject
    private BillCcrAdjService billCcrAdjService;
    
    @Inject
    private RollPeriodService rollPeriodService;
    
    @Inject
    private ContractBillService contractBillService;
    
    @Inject
    private ApprovalTypeService approvalTypeService;
    
    @Inject
    private ApprovalTypeItemService approvalTypeItemService;
    
    @Inject
    private ApprovalProcessService approvalProcessService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private ApprovalRecordService approvalRecordService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ContractInfo obj) {
    	
	    try {
				
	        obj.setOperator(getSessionQuietly().getUserId());
	        obj.setContractStatus(ContractStatus.WAITSUBMIT);
	        Long id = contractInfoService.create(obj);
	        
	        //费用账单
	        if(CollectionUtils.isNotEmpty(obj.getBccrs())){
	        	//更新计算规则关联关系
	        	for (BillCostCalRules  bccr : obj.getBccrs()) {
	        		bccr.setContractId(id);
	        		bccr.setOperator(getSessionQuietly().getUserId());
	        		billCostCalRulesService.update(bccr);	        		
	        		//更新预览与合同的关系
	        		List<ContractBill> contractBills = bccr.getContractBills();
	        		if(CollectionUtils.isNotEmpty(contractBills)){
	        			for(ContractBill item:contractBills){
	        				item.setContractId(id);
	        				item.setOperator(getSessionQuietly().getUserId());
	        				
	        				contractBillService.update(item);
	        			}
	        		}
				}
	        }
	        //合同附件
	        if(CollectionUtils.isNotEmpty(obj.getContractDossiers())){
	        	
	        	for (ContractDossier cd : obj.getContractDossiers()) {
	        		cd.setContractId(id);
	        		contractDossierService.create(cd);
				}
	        }
	        
	        //合同关联资源
	        if(CollectionUtils.isNotEmpty(obj.getResourceInfos())){
	        	ContractResource contractResource = null;
	        	for(ResourceInfo resourceInfo:obj.getResourceInfos()){
	        		contractResource = new ContractResource();

	        		contractResource.setContractId(id);
	        		contractResource.setResourceId(resourceInfo.getId());
	        		contractResource.setStartDate(obj.getStartDate());
	        		contractResource.setEndDate(obj.getEndDate());
	        		contractResource.setUseStatus(UseStatus.NOUSE);
	        		contractResource.setOperator(obj.getOperator());
	        		
	        		contractResourceService.create(contractResource);
	        	}
	        }
	        
	        Map<String, Long> map = MapHelper.put("id", id).getMap();
	
	        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
	        result.setLocation(String.format("/contractInfo/%s", id));
	        result.setData(map);
	        
	        return result;
	        
    	} catch (Exception e) {
    		
		    logger.error("保存合同信息异常：{}",e.getMessage());
		    return new  Result<Map<String, Long>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
       
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ContractInfo obj) {
    	//1.保存合同主信息
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        obj.setContractStatus(ContractStatus.WAITSUBMIT);
        //最后编辑人
        obj.setLastUpdateBy(getSessionQuietly().getUserId());
        //最后编辑时间
        obj.setLastUpdateTime(new Date());
        contractInfoService.update(obj);
        
        //3.合同附件
        ContractDossier contractDossier = new ContractDossier();
        contractDossier.setContractId(id);
        List<ContractDossier> contractDossiers = contractDossierService.findByObj(contractDossier);
        if(CollectionUtils.isNotEmpty(contractDossiers)){
        	for(ContractDossier item:contractDossiers){
        		item.setStatus(Status.DELETED);
        		item.setUpdateBy(getSessionQuietly().getUserId());
        		contractDossierService.update(item);
        	}
        }
        if(CollectionUtils.isNotEmpty(obj.getContractDossiers())){
        	for (ContractDossier cd : obj.getContractDossiers()) {
        		Long fileId = cd.getId();
        		if(fileId == null){
            		cd.setContractId(id);
            		cd.setOperator(getSessionQuietly().getUserId());
            		contractDossierService.create(cd);
        		}else{
        			cd.setStatus(Status.NORMAL);
        			cd.setUpdateBy(getSessionQuietly().getUserId());
        			contractDossierService.update(cd);
        		}
			}
        }
        
        //合同关联资源
        if(CollectionUtils.isNotEmpty(obj.getResourceInfos())){
        	Map<Long, Long> contractResourceIdMap = obj.getContractResourceIdMap();
        	ContractResource contractResource = null;
        	for(ResourceInfo resourceInfo:obj.getResourceInfos()){
        		Long resourceId = resourceInfo.getId();
        		if(contractResourceIdMap.get(resourceId) != null){
        			continue;
        		}
        		contractResource = new ContractResource();

        		contractResource.setContractId(id);
        		contractResource.setResourceId(resourceInfo.getId());
        		contractResource.setStartDate(obj.getStartDate());
        		contractResource.setEndDate(obj.getEndDate());
        		contractResource.setUseStatus(UseStatus.NOUSE);
        		contractResource.setOperator(obj.getOperator());
        		
        		contractResourceService.create(contractResource);
        	}
        }
        
        
        return ResultSupport.ok();
    }
    
    
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final ContractInfo obj) {
    
       	//1.1  获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);
 
    	if(EnableStatus.DISABLE == approvalType.getEnableStatus()){
    		//不启用流程
    		if(obj.isPassStatus()){
    			obj.setContractStatus(ContractStatus.SUCCESS);
    		}else{
    			obj.setContractStatus(ContractStatus.WAITSUBMIT);
    		}
    		return updateContractStatus(obj);
    	}else{
    		//启用流程
    		//1.判断当前用户是否有权限审批(无权限审批给予提示)
    		ContractInfo contractInfo = contractInfoService.getById(id);
    		Long approvalProcessId = contractInfo.getApprovalProcessId();
    		ApprovalProcess approvalProcess = approvalProcessService.getById(approvalProcessId);
    		if(getSession().getUserId() != contractInfo.getExecutorId() || approvalProcess.getIsHistory()){
    			return new Result<String>(ResultCode.CONTRACT_APPROVAL_ERROR);
    		}

    		//2.写入审批记录
    		ApprovalRecord approvalRecord = BeanUtils.copyProperties(approvalProcess, ApprovalRecord.class);
    		ApprovalTypeItem approvalTypeItem = approvalTypeItemService.getById(approvalProcess.getApprovalItemId());
    		approvalRecord.setApprovalItemName(approvalTypeItem == null ? "":StringUtils.isBlank(approvalTypeItem.getName()) ? "":approvalTypeItem.getName());
    		AdminUser adminUser = adminUserService.getById(approvalProcess.getApprovalId());
    		approvalRecord.setApprovalName(adminUser == null?"":StringUtils.isBlank(adminUser.getUsername())?"":adminUser.getUsername());
    		approvalRecord.setPassStatus(obj.isPassStatus());
    		approvalRecord.setOperator(getSession().getUserId());
    		
    		approvalRecordService.create(approvalRecord);
    		
    		
			//3.更新当前节点状态
			approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.APPROVALED);
			approvalProcess.setOperator(getSession().getUserId());
			approvalProcessService.update(approvalProcess);
			
    		//4.审批合同（通过查下一审批人，未通过相当于退回）
    		if(obj.isPassStatus()){//通过
    			
    			//获取下一节点
    			ApprovalProcess itemNode = approvalProcessService.findNextNodeByObj(approvalProcess);
    			if(itemNode == null){
    				contractInfo.setContractStatus(ContractStatus.SUCCESS);
    				return updateContractStatus(contractInfo);
    			}
    			
    			//维护流程节点状态
    			itemNode.setApprovalProcessStatus(ApprovalProcessStatus.ONAPPROVAL);
    			itemNode.setOperator(getSession().getUserId());
    			approvalProcessService.update(approvalProcess);
    			
    			//更新合同下一处理人
    			contractInfo.setApprovalProcessId(itemNode.getId());
    			contractInfo.setExecutorId(itemNode.getApprovalId());
    			contractInfo.setOperator(getSession().getUserId());
    			contractInfoService.update(contractInfo);
    			
    			
    		}else{//不通过
    			obj.setContractStatus(ContractStatus.WAITSUBMIT);
    			contractInfoService.update(contractInfo);
    		}
    		
    	}
    	
    	return ResultSupport.ok();
    }

    /**
     * 1.撤回，2.退回，3.确认
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/updateContractStatus")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateContractStatus(
            @Valid final ContractInfo contractInfo) {
    	
        contractInfo.setOperator(getSessionQuietly().getUserId());
        
        //1.不是合同生效操作时直接更改合同状态
        ContractStatus contractStatus = contractInfo.getContractStatus();
        //合同状态为待确认时，写入审批流程
        if(ContractStatus.WAITVERIFY == contractStatus){
        	processContractInfoApproval(contractInfo);
        }else if(ContractStatus.WAITSUBMIT == contractInfo.getContractStatus()){
        	//撤回、退回，删除该合同对应的审批流
        	cancleApproval(contractInfo);
        }

        if(!ContractStatus.SUCCESS.equals(contractStatus)){
            contractInfoService.update(contractInfo);
            return ResultSupport.ok();
        }        
        
    	//2.获取合同所有的合同资源关系
        ContractResource contractResource = new ContractResource();
        contractResource.setContractId(contractInfo.getId());
        List<ContractResource> contractResources = contractResourceService.findByObj(contractResource);
        if(CollectionUtils.isEmpty(contractResources)){
            contractInfoService.update(contractInfo);
            return ResultSupport.ok();
        }

        //3.获取该合同所选资源已被占用的情况
        List<Long> resourceIds = new ArrayList<Long>();
    	for(ContractResource item:contractResources){
    		resourceIds.add(item.getResourceId());
    	}
    	contractResource.setNotInResourceIds(resourceIds);

    	//4.合同所选资源已有被占用
    	List<ContractResource> inValidContractResources = contractResourceService.findByObj(contractResource);
    	if(CollectionUtils.isNotEmpty(inValidContractResources)){
    		return new Result<String>(ResultCode.RES_CHOOSE_BAD);
    	}
    	
    	for(ContractResource item:contractResources){
    		item.setUseStatus(UseStatus.USE);
    		contractResourceService.update(item);
    	}
    	contractInfoService.update(contractInfo);
    	
        return ResultSupport.ok();
    }
    
    /**
     * 合同到待确认节点生成合同审批流程
     * @param contractInfo
     * @return
     */
    private ContractInfo processContractInfoApproval(ContractInfo contractInfo){
    	
    	//1.1  获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);
    	
    	if(approvalType == null){
    		return contractInfo;
    	}
    	
    	//1.2 获取流程节点
    	ApprovalTypeItemQuery approvalTypeItemQuery = new ApprovalTypeItemQuery();
    	approvalTypeItemQuery.setApprovalTypeId(approvalType.getId());
    	approvalTypeItemQuery.setCurrentVersion(approvalType.getLatestVersion());
    	List<ApprovalTypeItem> approvalTypeItemList = approvalTypeItemService.findByObjQuery(approvalTypeItemQuery);
    	
    	//1.3 写入合同流程
    	if(CollectionUtils.isEmpty(approvalTypeItemList)){
    		return contractInfo;
    	}
	
		ApprovalProcess approvalProcess = null;
		Long approvalProcessId = null;
		for(int i=0;i<approvalTypeItemList.size();i++){
			ApprovalTypeItem item = approvalTypeItemList.get(i);
			
			approvalProcess = new ApprovalProcess();
			
			approvalProcess.setApprovalTypeId(approvalType.getId());
			approvalProcess.setApprovalTypeVersion(approvalType.getLatestVersion());

			approvalProcess.setApprovalType(ApprovalType.CONTRACTAPPROVAL);
			approvalProcess.setMainId(contractInfo.getId());
			
			approvalProcess.setApprovalItemId(item.getId());
			approvalProcess.setApprovalItemNo(item.getApprovalNo());
			approvalProcess.setApprovalItemVersion(item.getCurrentVersion());
			approvalProcess.setApprovalId(item.getApprovalId());
			
			//将第一个节更改为审批中
			if(i == 0){
				approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.ONAPPROVAL);
			}else{
				approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.WAITAPPROVAL);
			}
			
			approvalProcess.setOperator(getSession().getUserId());
			approvalProcessId = approvalProcessService.create(approvalProcess);
			
			//更新合同审批节点信息
			contractInfo.setExecutorId(item.getApprovalId());
			contractInfo.setApprovalProcessId(approvalProcessId);
		}
    	return contractInfo;
    }

    /**
     * 作废合同流程
     * @param contractInfo
     * @return
     */
    private int cancleApproval(ContractInfo contractInfo){
    	
    	//获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);
    	
    	ApprovalProcessQuery approvalProcessQuery = new ApprovalProcessQuery();
    	approvalProcessQuery.setApprovalTypeId(approvalType.getId());
    	approvalProcessQuery.setApprovalTypeVersion(approvalType.getLatestVersion());
    	approvalProcessQuery.setApprovalType(ApprovalType.CONTRACTAPPROVAL);
    	approvalProcessQuery.setMainId(contractInfo.getId());
    	
    	return approvalProcessService.cancleByObjQuery(approvalProcessQuery);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ContractInfo obj = new ContractInfo();
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
    public Result<ContractInfo> get(@NotNull @PathParam("id") final Long id) {
        ContractInfo obj = contractInfoService.getById(id);
        
        return new Result<ContractInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    /**
     * 通过合同Id查询合同详情（包括档案信息）
     * @param id
     * @return
     */
    
    @GET
    @Path("/detail/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<ContractInfo> getDetail(@NotNull @PathParam("id") final Long id) {
    	try{
            ContractInfo obj = contractInfoService.getById(id);
            
            if(obj  != null ){
            	//获取档案信息
            	ContractDossier cd= new ContractDossier();
            	cd.setContractId(obj.getId());
            	obj.setContractDossiers(contractDossierService.findByObj(cd));
            	
            	//费用账单
            	BillCostCalRules bccr=new BillCostCalRules();
            	bccr.setContractId(id);
            	
            	//费用项目明细
            	List<BillCostCalRules> billCostCalRules = billCostCalRulesService.findByObj(bccr);
            	if(CollectionUtils.isNotEmpty(billCostCalRules)){
            		for(BillCostCalRules item:billCostCalRules){
            			List<BillCcrAdj> billCcrAdjs = billCcrAdjService.findByBccrId(item.getId());
            			if(CollectionUtils.isNotEmpty(billCcrAdjs)){
                			item.setBillCcrAdjs(billCcrAdjs);
            			}
            			
            			//获取计算规则对应的滚动计算列表（全部）
            			BillCostCalRules billCostCalRule = new BillCostCalRules();
            			billCostCalRule.setId(item.getId());
            	        List<RollPeriod> rollPeriods = rollPeriodService.findByObj(billCostCalRule);
            	        if(CollectionUtils.isNotEmpty(rollPeriods)){
            	        	item.setRollPeriods(rollPeriods);
            	        }
            		}
            	}
            	obj.setBccrs(billCostCalRules);
            	
            	//获取资源明细 
            	ContractResource cr = new ContractResource();
            	cr.setContractId(id);
            	List<ContractResource> contractResources = contractResourceService.findByObj(cr);
            	List<ResourceInfo> resourceInfos = new ArrayList<ResourceInfoService.ResourceInfo>();
            	if(CollectionUtils.isNotEmpty(contractResources)){
            		//1.获取有效的资源
            		resourceInfos = convertorContractResource(contractResources, true,obj);
            		
            		//2.获取无效的资源
            		List<Long> resInfoIds = new ArrayList<Long>();
            		for(ContractResource item:contractResources){
            			resInfoIds.add(item.getResourceId());
            		}
            		ContractResource  contractResource = new ContractResource();
            		contractResource.setContractId(id);
            		contractResource.setNotInResourceIds(resInfoIds);
//            		List<ContractResource> invalidContractResources = contractResourceService.findInvalid(id,resInfoIds);
            		List<ContractResource> invalidContractResources = contractResourceService.findByObj(contractResource);

            		//3.整合无效的资源
            		if(CollectionUtils.isNotEmpty(invalidContractResources)){
            			convertorContractResource(invalidContractResources, false,obj);
            		}
            	}
            	if(CollectionUtils.isNotEmpty(resourceInfos)){
            		for(ResourceInfo o:resourceInfos){
                		if (o.getIsSeat() != null && o.getIsSeat()) {//如果是基础层级,就设置其类型(web要显示)
                            ResInfoService.ResInfo resInfo = this.resInfoService.getById(o.getResInfoId());
                            if (resInfo != null) {
                                o.setResInfoName(resInfo.getName());
                                o.setCalcDimension(resInfo.getCalcDimension());
                                o.setEnableAvg(resInfo.getEnableAvg());
                            }
                        }
            		}
            	}
            	
            	obj.setResourceInfos(resourceInfos);
            	
            	//TODO
            	//1.1  获取当前有效的合同审批流程
            	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
            			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);

            	obj.setApprovalEnabelStatus(approvalType == null? false:EnableStatus.ENABLE == approvalType.getEnableStatus() ? true:false);
            }
            
            return new Result<ContractInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    		
    	}catch(Exception e){
    		logger.error("查询合同详情 error：{}",e);
    		return new Result<ContractInfoService.ContractInfo>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    /**
     * 根据资源合同关系获取资源
     * @param contractResources
     * @param isValid
     * @return
     */
    private List<ResourceInfo> convertorContractResource(List<ContractResource> contractResources,Boolean isValid,ContractInfo contractInfo){
    	//1.直接返回 null
    	if(CollectionUtils.isEmpty(contractResources)){
    		return null;
    	}
    	
    	//2.获取所有的资源
    	Date contractStartDate = contractInfo.getStartDate();
		Date contractEndDate = contractInfo.getEndDate();

		//资源是否可用
		Map<Long,Boolean> resourceInfoIsValidMap = contractInfo.getResourceInfoIsValidMap();
		//合同资源关联关系 ID 对应列表
		Map<Long, Long> contractResourceIdMap = contractInfo.getContractResourceIdMap();
    	List<Long> resInfoIds = new ArrayList<Long>();
		for(ContractResource item:contractResources){
			contractResourceIdMap.put(item.getResourceId(), item.getId());
			
			if(isValid){
				resourceInfoIsValidMap.put(item.getResourceId(), (item.getUseStatus().code() == 1)? false:true);
			}else{
				Date startDate = item.getStartDate();
				Date endDate = item.getEndDate();
				if(endDate.before(contractStartDate)){
					resourceInfoIsValidMap.put(item.getResourceId(), true);
				}else if(contractEndDate.before(startDate)){
					resourceInfoIsValidMap.put(item.getResourceId(), true);
				}else{
					resourceInfoIsValidMap.put(item.getResourceId(), false);
				}
			}

			resInfoIds.add(item.getResourceId());
			contractResourceIdMap.put(item.getResourceId(), item.getId());
		}
		List<ResourceInfo> resourceInfos = resourceInfoService.getByResInfoIds(resInfoIds);
		if(CollectionUtils.isEmpty(resourceInfos)){
			return null;
		}
		
		//3.封装资源
		for(ResourceInfo item:resourceInfos){
			Long resInfoId = item.getResInfoId();
			ResInfo resInfo = resInfoService.getById(resInfoId);
			item.setResInfoName(resInfo.getName());
			
		}
    	return resourceInfos;
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ContractInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<ContractInfo> page = contractInfoService.find(query);
        return new Result<Page<ContractInfo>>(ResultCode.OK, page);
    }
    
    /**
     * 通过企业Id获取合同
     * @param id
     * @return
     */
    @GET
    @Path("/listAll/condition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<ContractInfo>> getListAll(
    		@QueryParam("enterpriseId") Long enterpriseId
    		){
    	Session session=getSessionQuietly();
    	
    	List<ContractInfo> ciList=null;
    	
    	if(session ==null){
    		return new Result<List<ContractInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<List<ContractInfo>>(ResultCode.BAD_REQUEST);
    	}
    	
    	//寻找园区企业关联关系
    	Long ecId=null;
    	if(enterpriseId !=null){
    	  List<EnterpriseCott> ecList=enterpriseCottService.getEnterPriseCottByEnterpriseId(enterpriseId, session.getPlatformId());
	    	if(CollectionUtils.isEmpty(ecList)){
	    		return new Result<List<ContractInfo>>(ResultCode.OK,ciList);
	    	}
	    	ecId=ecList.get(0).getId();
        }
    	//寻找合同关联关系
    	EnterpriseCorrContract ecc=new EnterpriseCorrContract();
    	ecc.setEnterpriseCottId(ecId);
    	List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);
    	if(CollectionUtils.isEmpty(eccList)){
    		return new Result<List<ContractInfo>>(ResultCode.OK,ciList);
    	}
    	List<Long> contractIds=new ArrayList<Long>();
    	for (EnterpriseCorrContract enterpriseCorrContract : eccList) {
    		contractIds.add(enterpriseCorrContract.getContractId());
		}
    	//查询合同信息
    	ContractInfo ci= new ContractInfo();
    	ci.setIds(contractIds);
        ciList = contractInfoService.findByObj(ci);
        
        return new Result<List<ContractInfo>>(ResultCode.OK, ciList);
    }
    
    /**
     * 获取当前园区所有的待提交合同
     * @param id
     * @return
     */
    @GET
    @Path("/indexContractInfo")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ContractInfo>> getIndexContractInfo(){
    	Session session=getSessionQuietly();
    	if(session ==null){
    		return new Result<Page<ContractInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Page<ContractInfo>>(ResultCode.BAD_REQUEST);
    	}

    	//寻找园区企业关联关系
    	List<EnterpriseCott> ecList=enterpriseCottService.getEnterPriseCottByParkId(session.getPlatformId());
    	if(CollectionUtils.isEmpty(ecList)){
    		return new Result<Page<ContractInfo>>(ResultCode.OK);
    	}
    	//获取当前园区企业关联IDs
    	List<Long> ecIds = new ArrayList<Long>();
    	//园区企业关联关系ID,企业ID
    	Map<Long, Long> enterpriseMap = new HashMap<Long, Long>();
    	for(EnterpriseCott item:ecList){
    		if(CorrType.CONTRACT_RELATED != item.getCorrType())
    			continue;
    		ecIds.add(item.getId());
    		enterpriseMap.put(item.getId(), item.getEnterpriseId());
    	}
    	if(CollectionUtils.isEmpty(ecIds)){
    		return new Result<Page<ContractInfo>>(ResultCode.OK);
    	}
    	
    	//寻找合同关联关系
    	EnterpriseCorrContract ecc=new EnterpriseCorrContract();
    	ecc.setEnterpriseCottIds(ecIds);
    	List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);
    	if(CollectionUtils.isEmpty(eccList)){
    		return new Result<Page<ContractInfo>>(ResultCode.OK);
    	}

    	//当前园区所有的合同IDs
    	List<Long> contractInfoIds = new ArrayList<Long>();
    	//合同ID,园区企业关联关系ID
    	Map<Long, Long> enterpriseCorrContractMap = new HashMap<Long, Long>();
    	for(EnterpriseCorrContract item:eccList){
    		contractInfoIds.add(item.getContractId());
    		
    		enterpriseCorrContractMap.put(item.getContractId(), enterpriseMap.get(item.getEnterpriseCottId()));
    	}
    	
    	Query query = new Query();
		query.setOffset(0);
		query.setLimit(5);
		query.setContractInfoIds(contractInfoIds);
		query.setContractStatus(ContractStatus.WAITSUBMIT);
		
		Page<ContractInfo> page = contractInfoService.find(query);
		//封装企业ID
		if(CollectionUtils.isNotEmpty(page.getItems())){
			for(ContractInfo item:page.getItems()){
				item.setEnterpriseId(enterpriseCorrContractMap.get(item.getId()));
			}
		}
		
        return new Result<Page<ContractInfo>>(ResultCode.OK, page);
    }
    
    /**
     * 根据计算规则 ID 获取预览列表
     * @param id
     * @return
     */
    private List<Map<String,String>> createPreview(Long id) {
    	
        //规则详情
        BillCostCalRules obj = billCostCalRulesService.getById(id);
        
        if(obj == null ){
        	 return null;
        }
        if(obj.getContractId() == null){
        	 return null;
        }
        //查询规则对应合同
        ContractInfo ci = contractInfoService.getById(obj.getContractId());
        
        if(ci == null){
        	 return null;
        }
        if(ci.getStartDate() == null ){
        	 return null;
        }
        if(ci.getEndDate() == null ){
        	 return null;
        }
    
        //预览账单列表
        List<Map<String,String>> previewList = new ArrayList<Map<String,String>>();;
    	//获取时间段的月份
    	List<String> months=SystemUtil.getMonthsBetweenTimes(ci.getStartDate(), ci.getEndDate());
    	//获取调整月份金额
    	Map<String, Object> billCcrAdjMap = billCcrAdjService.findByBccrIdAndMonth(id, months);
    	//获取账单月份
    	List<String> billMonths = SystemUtil.getBillMonthsBetweenTimes(ci, obj);
    	//滚动月份、幅度
    	Map<String,BigDecimal> rollRangeMap = convertorContractToRange(obj, ci);
      
		//计算方式不能为空
		ComputeMode computeMode = obj.getComputeMode();
		if(!ComputeMode.FIXED_AMOUNT.equals(computeMode) && !ComputeMode.CUSTOME_CAL.equals(computeMode)){
			return previewList;
		}
		
		Map<String, String> monthRecord =null;
		//费用预收月数(预收月数大于等于 1)
		Integer advanceMonth = obj.getAdvanceMonth();
		if(advanceMonth == null || advanceMonth == 0){
			advanceMonth = 1;
		}
    	for (int i = 0; i < months.size(); i++) {
    		monthRecord=new HashMap<String, String>();
    		String month=months.get(i);
    		//非账单月份
 			if(!billMonths.contains(month)){
 				monthRecord.put("month", month);
 				monthRecord.put("billAmount", "");
 				//费账单月
 				monthRecord.put("isBillMonth", "0");
 				
 				previewList.add(monthRecord);
 				continue;
 			}
 			//是账单月
			monthRecord.put("isBillMonth", "1");
    		
    		//免收月数处理
 			Integer freeMonth = obj.getFreeMonth();
 			if(freeMonth == null || freeMonth < 1){
 				freeMonth = 0;
 			}
     		if(i < freeMonth-1){
     			monthRecord.put("month",month);
     			if(i > 0){
         			monthRecord.put("billAmount","");
     				continue;
     			}
     			//获取对应的调整项（有可能为空）
     			BigDecimal temp = new BigDecimal(0);
 				for(int z=0;z<freeMonth;z++){
 					String tempMonth = months.get(z);
 					Object adjAmount = billCcrAdjMap.get(tempMonth);
 					if(adjAmount != null){
 						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
 						temp=new BigDecimal(Arith.add(adjAmountBigDecimal, temp));
 					}		
     			}
 				monthRecord.put("billAmount",temp.toString());
     		}
     		//固定金额
     		else if(ComputeMode.FIXED_AMOUNT.equals(obj.getComputeMode())){
     			
     			//账单月份
     			BigDecimal currentAmount=new BigDecimal("0");
				BigDecimal amount=obj.getFixedAmount();
				for (int j = i + 1; j < obj.getAdvanceMonth() + i + 1 && j< months.size(); j++) {
					//获取对应的调整项（有可能为空）
 					String currentMonth = months.get(j);
 					Object adjAmount = billCcrAdjMap.get(currentMonth);
 					if(adjAmount != null){
 						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
 						currentAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, amount));
 					}else{
 						currentAmount=new BigDecimal(Arith.add(currentAmount, amount));
 					}
			     }
            	monthRecord.put("month",month);
 				monthRecord.put("billAmount",currentAmount.toString());	
         	}
    		//自定义计算
     		else if(ComputeMode.CUSTOME_CAL.equals(obj.getComputeMode())){
     			
     			//通过计算公式获得指定月份费用项目金额        	
                Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
                values.put("area", ci.getArea());
                values.put("amount", ci.getTotalMoney());
                
                BigDecimal billAmount = new BigDecimal(0);
                BigDecimal billInitAmount = new BigDecimal(0);
    			 //启用滚动计算的
    			if(obj.getIsRollingCal() == 1){
					//10000*(1+m)^n
					//计算下n个月份的
					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
						String currentMonth = months.get(j);
						//項目金额
						values.put("days", new BigDecimal(SystemUtil.getDaysByMonth(currentMonth)));
		                billInitAmount = FormulaParser.parse(obj.getFormula(), values);
						
		                //当前月份的幅度
						BigDecimal currentRange = rollRangeMap.get(currentMonth);
						Double Idempotent = currentRange.doubleValue();
						//项目金额 * 当前月份的滚动幅度
						BigDecimal currentBill=new BigDecimal(Arith.mul(billInitAmount.doubleValue(),Idempotent));
						//金额取小数点后两位
						currentBill = currentBill.setScale(2, BigDecimal.ROUND_HALF_UP);
						billAmount=new BigDecimal(Arith.add(billAmount.doubleValue(), currentBill.doubleValue()));
					}
					//添加调整项
					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
						//获取对应的调整项（有可能为空）
     					String currentMonth = months.get(j);
     					Object adjAmount = billCcrAdjMap.get(currentMonth);
     					if(adjAmount != null){
     						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
     						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
     					}
					}
					monthRecord.put("month",month);
                	monthRecord.put("billAmount",Arith.round(billAmount.toString(),2));
    		   }
    			//未启用滚动计算
    			else{
					//添加调整项
					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
						//获取对应的调整项（有可能为空）
     					String currentMonth = months.get(j);
     					
     					//項目金額
						values.put("days", new BigDecimal(SystemUtil.getDaysByMonth(currentMonth)));
		                billInitAmount = FormulaParser.parse(obj.getFormula(), values);
		                billAmount = billAmount.add(billInitAmount);
     					
     					Object adjAmount = billCcrAdjMap.get(currentMonth);
     					if(adjAmount != null){
     						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
     						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
     					}
					}
					monthRecord.put("month",month);
					monthRecord.put("billAmount",Arith.round(billAmount,2));
    			}
    	   }
     		logger.info("{}月份账单：{}",monthRecord.get("month"),monthRecord.get("billAmount"));
     		previewList.add(monthRecord);
    	}        
    	return previewList;
    }
    
    /**
     * 根据合同计算规则算出合同对应的每月滚动幅度
     * @param contractInfo
     * @return
     */
    private Map<String, BigDecimal> convertorContractToRange(BillCostCalRules billCostCalRules,ContractInfo contractInfo){
    	
    	//1.当合同不存在是返回空
    	if(contractInfo == null){
    		return null;
    	}
    	
    	//2.获取合同时间范围内的月份
    	Map<String, BigDecimal> rollRangeMap = new HashMap<String, BigDecimal>();
    	Date startDate = contractInfo.getStartDate();
    	
    	Date endDate = contractInfo.getEndDate();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(startDate);
    	List<String> rollRanges = SystemUtil.getMonthsBetweenTimes(startDate, endDate);
    	if(CollectionUtils.isEmpty(rollRanges)){
    		return null;
    	}
		for(String rollRange:rollRanges){
			rollRangeMap.put(rollRange, new BigDecimal(1));
		}

    	
    	//3.根据计算规则没有的滚动幅度
    	List<RollPeriod> rollPeriods = rollPeriodService.findByObj(billCostCalRules);
    	Map<String, BigDecimal> rollMap = convertorRollPeriod(rollPeriods);
    	if(rollMap != null){
        	rollRangeMap.putAll(rollMap);
    	}
    	
    	//4.循环遍历，填补 1
    	for(int i=1;i< rollRanges.size();i++){
    		String month = rollRanges.get(i);
    		BigDecimal range = rollRangeMap.get(month);
    		if(new BigDecimal(1).compareTo(range) == 0){
    			String preMonth = rollRanges.get(i-1);
    			BigDecimal preRange = rollRangeMap.get(preMonth);
    			if(new BigDecimal(1).compareTo(preRange) != 0){
    				rollRangeMap.put(month, preRange);
    			}
    		}
    	}
    	return rollRangeMap;
    }
    
    /**
     * 根据滚动周期记录获取合同期内月份对应的幅度
     * @param rollPeriods
     * @return
     */
    private Map<String, BigDecimal> convertorRollPeriod(List<RollPeriod> rollPeriods){
    	if(CollectionUtils.isEmpty(rollPeriods)){
    		return null;
    	}
    	Map<String, BigDecimal> rollMap = new HashMap<String, BigDecimal>();
    	
    	BigDecimal currentRange = new BigDecimal(1);
    	for(RollPeriod rollPeriod:rollPeriods){
    		//调整幅度
    		BigDecimal range = rollPeriod.getRollRange().divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
    		//滚动开始时间
    		Date startDate = rollPeriod.getStartDate();
    		//滚动结束时间
    		Date endDate = rollPeriod.getEndDate();
    		//滚动周期（月）
    		int rollCycle = rollPeriod.getRollPeriod();
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(startDate);
    		Date currentTime = calendar.getTime();
    		int months = 1;
    		BigDecimal baseRange = range.add(new BigDecimal(1));
    		while(currentTime.before(endDate)){
    			
    			if((months-1)%rollCycle == 0){
    				currentRange = currentRange.multiply(baseRange);
    			}
    			rollMap.put(SystemUtil.dateFormat(calendar.getTime(), "yyyy-MM"), currentRange);
    			
    			calendar.add(Calendar.MONTH, 1);
    			currentTime = calendar.getTime();
    			months++;
    		}
    	}
    	
    	return rollMap;
    }
}
