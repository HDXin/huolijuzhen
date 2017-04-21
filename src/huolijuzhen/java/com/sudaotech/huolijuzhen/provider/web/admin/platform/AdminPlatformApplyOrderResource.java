package com.sudaotech.huolijuzhen.provider.web.admin.platform;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.payment.domain.PaymentConstants;
import com.sudaotech.huolijuzhen.payment.domain.TradeREQ;
import com.sudaotech.huolijuzhen.payment.service.PaymentService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService.ApplyLabel;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.FindCondition;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.user.service.AdminUserService.AdminUser;

@Path("/admin/platform/applyOrder")
public class AdminPlatformApplyOrderResource extends BusinessBaseResource {
	@Inject
	private PaymentService paymentService;

    /**
     * 审批 订单或申请单
     * @param id
     * @param approvalItem
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            final ApplyOrder approvalItem) {
    	
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Long userId = session.getUserId();
    		//查询订单
    		ApplyOrder ao= applyOrderService.getById(id);
    		
    		//校验数据
    		if(ao == null){
    			
    			return new Result<String>(ResultCode.NOT_FOUND);
    		}
    		//校验状态
    		if(ao.getApplyOrderStatus() != ApplyOrderStatus.ORDERWAITEXECUTOR && 
    		   ao.getApplyOrderStatus() != ApplyOrderStatus.APPLYWAITEXECUTOR){
    			
    			return new Result<String>(ResultCode.APPLYORDER_UPDATE_ERROR);
    		}
    		//1.审批操作
    		String approvalText = approvalItem.getApplyOrderStatusMemo();
    		ApplyOrderStatus applyOrderStatus = approvalItem.getApplyOrderStatus();
    		ApplyOrder applyOrder = new ApplyOrder();
    		
    		applyOrder.setId(id);
    		applyOrder.setApplyOrderStatusMemo(approvalText);
    		applyOrder.setApplyOrderStatus(applyOrderStatus);
    		applyOrder.setOperator(userId);
    		
    		applyOrderService.update(applyOrder);
            
    		//2.确认是否是订单关闭操作
    		if(ApplyOrderStatus.TERMINATION.equals(applyOrderStatus)){
    			//为订单方可退款
    			if(ao.getApplyOrderType() == ApplyOrderType.ORDER){
    				//为订单方可退款
    				if(ao.getPayWay() == PayWay.WECHATPAY){
		    			//退款操作
			  	        TradeREQ req=new TradeREQ();
			  	        req.setChannel(PaymentConstants.Channel.WX);
			  	        req.setAmount(Arith.round(Arith.mul(ao.getPrice().toString(),"100"),0));  
			  	        req.setOrder_no(ao.getApplyOrderNo());
		    			paymentService.refund(req);
	    			}
    				if(ao.getPayWay() == PayWay.ALIPAY){
		    			//退款操作
			  	        TradeREQ req=new TradeREQ();
			  	        req.setChannel(PaymentConstants.Channel.ALIPAY);
			  	        req.setAmount(Arith.round(Arith.mul(ao.getPrice().toString(),"100"),0));  
			  	        req.setOrder_no(ao.getApplyOrderNo());
		    			paymentService.refund(req);
    				}
    			}
    		}
    		//3.推送审批消息
    		Message message = new Message();
    		ApplyOrder tempApplyOrder = applyOrderService.getById(id);
    		ApplyOrderType applyOrderType = tempApplyOrder.getApplyOrderType();
            String content="";
            if(ApplyOrderType.APPLY.equals(applyOrderType)){
                message.setMsgBizType(MsgBizType.APPLY_ORDER);
                if(ApplyOrderStatus.ALREADYPASS.equals(applyOrderStatus)){
                	content = NoticeConstants.Enterprise.Service.APPLY_PASS;
                }else if(ApplyOrderStatus.NOPASS.equals(applyOrderStatus)){
                	content = NoticeConstants.Enterprise.Service.APPLY_FAIL;
                }
            }else{
            	message.setMsgBizType(MsgBizType.ORDER);
            	if(ApplyOrderStatus.WAITCOMMENT.equals(applyOrderStatus)){
            		content = NoticeConstants.Enterprise.Service.TREATED;
            	}else if(ApplyOrderStatus.TERMINATION.equals(applyOrderStatus)){
            		content = NoticeConstants.Enterprise.Service.CLOSED;
            	}
            }
            message.setBizId(id);
            message.setMsgType(MsgType.ENTERPRISE_SERVICE);
            message.setSrc(userId);
            message.setMsgStatus(MsgStatus.CREATE);
            message.setSourceType(SourceType.SYSTEM_MESSAGE);
            message.setTitle(content);
            message.setContent(content);
            message.setParkId(-1L);
            
            List<Long> dstIds = new ArrayList<Long>();
            dstIds.add(tempApplyOrder.getCreateBy());
            
            sendMessageToUser(dstIds,message);
    		
    		//4.保存历史记录
    		//TODO
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台审批申请单或订单 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    /**
     * 获取订单、申请单详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{

    		Map<String, Object> dataMap = new HashMap<String, Object>();
            ApplyOrder applyOrder = applyOrderService.getById(id);
            
            if(applyOrder != null){
            	dataMap.put("applyOrder", applyOrder);
                dataMap.putAll(applyOrderDetail(applyOrder));
                
                List<ApplyLabel> applyLabels = applyLabelService.findAllByApplyOrderId(applyOrder);
                updateValue(applyLabels);
                dataMap.put("applyContent", new ArrayList<ApplyLabel>());
                if(CollectionUtils.isNotEmpty(applyLabels)){
                	dataMap.put("applyContent", applyLabels);
                }
            }
            
            return new Result<Map<String, Object>>(ResultCode.OK, dataMap);
    		
    	}catch(Exception e){
    		logger.error("平台根据 ID 获取申请单、订单详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 多条件查询
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("enterpriseName") String enterpriseName,
            @QueryParam("applyOrderNo") String applyOrderNo,
            @QueryParam("applyOrderType") String applyOrderTypeStr,
            @QueryParam("applyOrderStatus") String applyOrderStatusStr,
            @QueryParam("serviceGrade") String serviceGradeStr) {
    	try{
    		
    		FindCondition findCondition = new FindCondition();
    		
    		findCondition.setOffset(offset);
    		findCondition.setLimit(limit);
    		findCondition.setPage(pageNum);
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		if(StringUtils.isNotBlank(startDate)){
        		findCondition.setStartDate(sdf.parse(startDate));
    		}
    		if(StringUtils.isNotBlank(endDate)){
        		findCondition.setEndDate(sdf.parse(endDate));
    		}
    		findCondition.setEnterpriseName(enterpriseName);
    		findCondition.setApplyOrderNo(applyOrderNo);
    		if(StringUtils.isNotBlank(applyOrderTypeStr)){
        		ApplyOrderType applyOrderType = ApplyOrderType.valueOf(applyOrderTypeStr);
        		findCondition.setApplyOrderType(applyOrderType);
    		}
    		
    		//1.WAITEXECUTOR（未执行） 2.ALREADYEXECUTOR（已执行） 3.TERMINATION(已关闭)
    		List<ApplyOrderStatus> applyOrderStatusList = new ArrayList<ApplyOrderStatus>();
    		if(StringUtils.isNotBlank(applyOrderStatusStr)){
    				if(StringUtils.isBlank(applyOrderTypeStr)){
	        			if("WAITEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.APPLYWAITEXECUTOR);
	        				applyOrderStatusList.add(ApplyOrderStatus.ORDERWAITEXECUTOR);
	        			}else if("ALREADYEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.ALREADYPASS);
	        				applyOrderStatusList.add(ApplyOrderStatus.WAITCOMMENT);
	        				applyOrderStatusList.add(ApplyOrderStatus.FINISH);
	        			}else if("TERMINATION".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.TERMINATION);
	        				applyOrderStatusList.add(ApplyOrderStatus.NOPASS);
	        			}
        			else if(ApplyOrderType.APPLY.equals(ApplyOrderType.valueOf(applyOrderTypeStr))){
	        			if("WAITEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.APPLYWAITEXECUTOR);
	        			}else if("ALREADYEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.ALREADYPASS);
	        			}else if("TERMINATION".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.NOPASS);
	        			}
        			
	        		}else if(ApplyOrderType.ORDER.equals(ApplyOrderType.valueOf(applyOrderTypeStr))){
	        			if("WAITEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.ORDERWAITEXECUTOR);
	        			}else if("ALREADYEXECUTOR".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.WAITCOMMENT);
	        				applyOrderStatusList.add(ApplyOrderStatus.FINISH);
	        			}else if("TERMINATION".equals(applyOrderStatusStr)){
	        				applyOrderStatusList.add(ApplyOrderStatus.TERMINATION);
	        			}
	        		}
        		}
    		}else{
    			applyOrderStatusList.add(ApplyOrderStatus.APPLYWAITEXECUTOR);
    			applyOrderStatusList.add(ApplyOrderStatus.ALREADYPASS);
    			applyOrderStatusList.add(ApplyOrderStatus.NOPASS);

    			applyOrderStatusList.add(ApplyOrderStatus.ORDERWAITEXECUTOR);
    			applyOrderStatusList.add(ApplyOrderStatus.WAITCOMMENT);
    			applyOrderStatusList.add(ApplyOrderStatus.FINISH);
    			applyOrderStatusList.add(ApplyOrderStatus.TERMINATION);
    		}

    		if(StringUtils.isNotBlank(serviceGradeStr)){
    			ServiceGrade serviceGrade = ServiceGrade.valueOf(serviceGradeStr);
    			List<Long> serviceProIds = serviceProjectService.findServiceProIdByServiceGrade(serviceGrade);
    			findCondition.setServiceProIds(serviceProIds);
    		}
    		
    		findCondition.setApplyOrderStatusList(applyOrderStatusList);
    		findCondition.setIsPlatform(true);
    		Page<ApplyOrder> page = applyOrderService.findAll(findCondition);
    		Map<String, Object> dataMap = packPageInfo(page);
            return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("平台按条件查询申请单、订单 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ApplyOrder> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	
    	List<ApplyOrder> list = page.getItems();
    	if(CollectionUtils.isNotEmpty(list)){
    		Map<String, Object> itemMap = null;
    		for(ApplyOrder item:list){
    			itemMap = new HashMap<String, Object>();
    			
    			itemMap.put("applyOrder", item);
    			itemMap.putAll(applyOrderDetail(item));
    			
    			items.add(itemMap);
    		}
    	}
    	
    	dataMap.put("items", items);
    	return dataMap;
    }
    
    public Map<String, Object> applyOrderDetail(ApplyOrder applyOrder){
    	
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	
    	ServiceProject serviceProject = new ServiceProject();
        Long serviceProId = applyOrder.getServiceProId();
    	if(serviceProId != null){
    		serviceProject = serviceProjectService.getById(serviceProId);
    		if(serviceProject == null){
    			serviceProject = new ServiceProject();
    		}
    	}
        dataMap.put("serviceProject", serviceProject);
        
        Long operatorId = applyOrder.getCreateBy();
        AdminUser operator = adminUserService.getById(operatorId);
        dataMap.put("operator", notNull(operator));
        
        Long enterpriseId = operator.getPlatformSourceId();
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(enterpriseId);
        dataMap.put("enterpriseInfo", notNull(enterpriseInfo));
    	
        return dataMap;
    }

}
