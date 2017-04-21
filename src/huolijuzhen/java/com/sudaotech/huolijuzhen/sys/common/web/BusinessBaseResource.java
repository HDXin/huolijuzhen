package com.sudaotech.huolijuzhen.sys.common.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.community.service.CommunityApplyService;
import com.sudaotech.huolijuzhen.community.service.CommunityService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.LabelType;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPreserveService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;
import com.sudaotech.huolijuzhen.notice.service.NoticeParkService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.payment.service.PaymentService;
import com.sudaotech.huolijuzhen.policy.service.PolicyService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService.ApplyLabel;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneService.ServiceProScane;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectHistoryService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectHistoryService.ServiceProjectHistory;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.user.service.AdminUserService;

public abstract class BusinessBaseResource extends BaseResource {
	
	
	@Inject
	protected ImageInfoService imageInfoService;
	
	@Inject
	protected GenCodeService genCodeService;
	
    @Inject
    protected EquipmentTypeService equipmentTypeService;
    
    @Inject
    protected EquipmentPreserveService equipmentPreserveService;
    
    @Inject
    protected ApplyOrderService applyOrderService;
    
    @Inject
    protected AdminUserService adminUserService;
    
    @Inject
    protected EnterpriseInfoService enterpriseInfoService;

    @Inject
    protected MessageService messageService;
    
    @Inject
    protected ApplyLabelService applyLabelService;
    
    @Inject
    protected ParkInfoService parkInfoService;
    
    @Inject
    protected ProviderService providerService;
    
    @Inject
    protected AreaService areaService;
    
    @Inject
    protected OrderTemplateService orderTemplateService;
    
    @Inject
    protected ServiceCommentService serviceCommentService;
    
    @Inject
    protected PaymentService paymentService;
    
    @Inject
    protected ServiceCollectService serviceCollectService;
    
    @Inject
    private NoticeEnterpriseService noticeEnterpriseService;
    
    @Inject
    protected NoticeParkService noticeParkService;
    
    @Inject
    protected AnnouncementService announcementService;
    
    @Inject
    protected PolicyService policyService;
    
    @Inject
    protected CommunityService communityService;
    
    @Inject
    protected CommunityApplyService communityApplyService;
    
    @Inject
    protected EquipmentPlanService equipmentPlanService;
    
    @Inject
    protected ResourceInfoService resourceInfoService;
    
    @Inject
    protected ResInfoService resInfoService;
    
    @Inject
    protected TaskService taskService;
    
    @Inject
    protected BillInfoService billInfoService;
    
    @Inject
    protected ServiceProScaneService serviceProScaneService;
    
    @Inject
    protected ServiceProjectService serviceProjectService;
    
    @Inject
    protected ServiceProjectHistoryService serviceProjectHistoryService;
    
    @Inject
    protected CostProService costProService;
    
    @Inject
    protected ContractInfoService contractInfoService;
    
    /**
     * 根据 list 生成对应的对象的属性 Map
     * @param str
     * @return
     */
	protected List<Map<String, Object>> imageInfoListToMap(List<ImageInfo> imageInfos){
    	List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
    	
    	Map<String, Object> dataMap = null;
    	if(CollectionUtils.isNotEmpty(imageInfos)){
    		for(ImageInfo item:imageInfos){
    			dataMap = new HashedMap<String, Object>();
    			dataMap.put("path", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getPath());
    			dataList.add(dataMap);
    		}
    	}
    	return dataList;
    }
    
	//保存图片信息到数据库(普通版)
    protected void createImageInfo(ImageType imageType,Long targetId,List<ImageInfo> imageInfos){
    	if(CollectionUtils.isNotEmpty(imageInfos)){
        	for(ImageInfo item:imageInfos){
        		String daomainUrl = HuolijuzhenConfig.getInstance().getDomainUrl();
        		String path = item.getPath();
        		if(StringUtils.startsWith(path, "http")){
        			path = path.substring(daomainUrl.length(), path.length());
        			item.setPath(path);
        		}
        		
        		item.setImageType(imageType);
        		item.setTargetId(targetId);
        		
        		item.setOperator(getSessionQuietly().getUserId());
        		
        		imageInfoService.create(item);
        	}
        }
    }

	//保存图片信息到数据库(服务项目专用)
    protected void createImageInfo(ImageType imageType,Long targetId,List<ImageInfo> imageInfos,Integer serviceProRelease){
    	if(CollectionUtils.isNotEmpty(imageInfos)){
        	for(ImageInfo item:imageInfos){
        		String daomainUrl = HuolijuzhenConfig.getInstance().getDomainUrl();
        		String path = item.getPath();
        		if(StringUtils.startsWith(path, "http")){
        			path = path.substring(daomainUrl.length(), path.length());
        			item.setPath(path);
        		}
        		
        		item.setImageType(imageType);
        		item.setTargetId(targetId);
        		item.setServiceProRelease(serviceProRelease);
        		item.setOperator(getSessionQuietly().getUserId());
        		
        		imageInfoService.create(item);
        	}
        }
    }

    
    //更改 app 端上传图片的路径
    protected void updateImageInfoPath(List<ImageInfo> imageInfos) {
    	if(CollectionUtils.isNotEmpty(imageInfos)){
    		for(ImageInfo item:imageInfos){
    			item.setPath("/platform/image/" + item.getPath());
    		}
    	}
	}
    
    /**
     * 更新图片信息（普通版）
     * @param imageType
     * @param targetId
     * @param imageInfos
     */
    protected void updateImageInfo(ImageType imageType,Long targetId,List<ImageInfo> imageInfos){

    	//1.删除所有图片
		imageInfoService.deleteMore(imageType,targetId);
		
		//2.编辑时未添加图片
		if(CollectionUtils.isEmpty(imageInfos)){
        	return;
        }
    	
    	//3.获取所有历史图片
		ImageInfo imageInfo = new ImageInfo();
        imageInfo.setImageType(imageType);
        imageInfo.setTargetId(targetId);
        imageInfo.setIsAll(true);
        List<ImageInfo> imageInfoList = imageInfoService.findByObj(imageInfo);
        
        //4.未找到你历史图片
        if(CollectionUtils.isEmpty(imageInfoList)){
        	createImageInfo(imageType, targetId, imageInfos);
        	return;
        }
        
        //5.循环更新历史图片
    	for(int i=0;i<imageInfos.size();i++){
    		ImageInfo item = imageInfos.get(i);
    		String path = item.getPath();
    		String daomainUrl = HuolijuzhenConfig.getInstance().getDomainUrl();
    		if(StringUtils.startsWith(path, "http")){
    			path = path.substring(daomainUrl.length(), path.length());
    			item.setPath(path);
    		}
    		
    		if(i >= imageInfoList.size()){
        		item.setImageType(imageType);
        		item.setTargetId(targetId);
    			item.setOperator(getSessionQuietly().getUserId());
    		
    			imageInfoService.create(item);
    		}else{
    			ImageInfo temp = imageInfoList.get(i);
        		temp.setPath(item.getPath());
        		temp.setOperator(getSessionQuietly().getUserId());
        		temp.setStatus(Status.NORMAL);
        		
        		imageInfoService.update(temp);
    		}
    	}
    }
    /**
     * 服务项目图片更新
     * @param imageType
     * @param targetId
     * @param imageInfos
     * @param serviceProRelease
     */
    protected void updateImageInfo(ImageType imageType,Long targetId,List<ImageInfo> imageInfos,Integer serviceProRelease){
    	
    	//1.删除所有图片
    	imageInfoService.deleteMore(imageType,targetId);
    	//2.未添加图片
    	if(CollectionUtils.isEmpty(imageInfos)){
        	return;
        }
    	//3.获取所有历史图片
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setImageType(imageType);
        imageInfo.setTargetId(targetId);
        imageInfo.setServiceProRelease(serviceProRelease);
        imageInfo.setIsAll(true);
        List<ImageInfo> imageInfoList = imageInfoService.findByObj(imageInfo);

        //4.未找到历史图片
        if(CollectionUtils.isEmpty(imageInfoList)){
        	createImageInfo(imageType, targetId, imageInfos,serviceProRelease);
        	return;
        }
        
        //5.循环更新历史图片
    	for(int i=0;i<imageInfos.size();i++){
    		ImageInfo item = imageInfos.get(i);
    		String path = item.getPath();
    		String daomainUrl = HuolijuzhenConfig.getInstance().getDomainUrl();
    		if(StringUtils.startsWith(path, "http")){
    			path = path.substring(daomainUrl.length(), path.length());
    			item.setPath(path);
    		}
    		
    		if(i >= imageInfoList.size()){
        		item.setImageType(imageType);
        		item.setTargetId(targetId);
        		item.setServiceProRelease(serviceProRelease);
    			item.setOperator(getSessionQuietly().getUserId());
    		
    			imageInfoService.create(item);
    		}else{
    			ImageInfo temp = imageInfoList.get(i);
        		temp.setPath(item.getPath());
        		temp.setOperator(getSessionQuietly().getUserId());
        		temp.setStatus(Status.NORMAL);
        		
        		imageInfoService.update(temp);
    		}
    	}
    }
    
    /**
     * 更新图片路径
     * @param applyLabels
     * @return
     */
    protected void updateValue(List<ApplyLabel> applyLabels){
    	if(CollectionUtils.isNotEmpty(applyLabels)){
    		for(ApplyLabel item:applyLabels){
    			LabelType labelType = item.getLabelType();
    			String value = item.getValue();
    			if(LabelType.FILE.equals(labelType) && StringUtils.isNotBlank(value)){
    				item.setValue(HuolijuzhenConfig.getInstance().getDomainUrl() + value);
    			}
    		}
    	}
    }

    /**
     * 推送消息、插入消息到数据库
     * @param userIds
     * @param message
     * @param dataMap
     */
    protected void sendMessageToUser(List<Long> userIds,Message message){
    	
    	if(CollectionUtils.isEmpty(userIds)){
    		return;
    	}
    	/*******************************消息推送 old******************************/
//        //1.发送异步消息到消息中间件
//        MessageService.Middleware middleware = new MessageService.Middleware();
//        Map<String, Object> extMap = new HashedMap<String, Object>();
//        //消息标题
//        extMap.put("title", notNull(message.getTitle()));
//        //消息内容
//        String content = message.getContent();
//        extMap.put("content", notNull(content));
//        //业务类型
//        extMap.put("msgBizType", notNull(message.getMsgBizType()));
//        //业务ID
//        extMap.put("bizId", notNull(message.getBizId()));
//        //消息类型
//        extMap.put("msgType", notNull(message.getMsgType()));
//        //消息状态
//        extMap.put("msgStatus", notNull(message.getMsgStatus()));
//        //系统消息类型
//        extMap.put("sourceType", notNull(message.getSourceType()));
//
//        MsgBizType msgBizType = message.getMsgBizType();
//		if(MsgBizType.NOTICE.equals(msgBizType)){
//		    //详情页面（h5）
//		    extMap.put("detailUrl", BaseUrl.HTTP + BaseUrl.DOMAIN + "/static/notice.html?id=" + message.getBizId());
//		}else if(MsgBizType.ACTIVITY_APPLY.equals(msgBizType)){
//			extMap.put("detailUrl", BaseUrl.HTTP + BaseUrl.DOMAIN + "/static/activity.html?id=" + message.getBizId());
//		}else if(MsgBizType.APPLY_ORDER.equals(msgBizType) || MsgBizType.ORDER.equals(msgBizType)){
//			extMap.put("detailUrl", BaseUrl.HTTP + BaseUrl.DOMAIN + "/static/service.html?id=" + message.getBizId());
//		}
//        middleware.setNotifyContent(content);
//
//        middleware.setExtMap(extMap);
//        middleware.setUserIdList(userIds);
//        messageService.sendToMiddleware(middleware);
    	
        //2.插入消息到数据库
		Message tempMessage = null;
		for(Long dstId:userIds){
			tempMessage = new Message();
			tempMessage.setMsgBizType(message.getMsgBizType());
			tempMessage.setBizId(message.getBizId());
			tempMessage.setMsgType(message.getMsgType());
			tempMessage.setSrc(message.getSrc());
			tempMessage.setDst(dstId);
			tempMessage.setParkId(message.getParkId());
			
			tempMessage.setMsgStatus(message.getMsgStatus());
			tempMessage.setContent(message.getContent());
			tempMessage.setExtId(message.getExtId());
			tempMessage.setSourceType(message.getSourceType());
			
			tempMessage.setTitle(message.getTitle());
			tempMessage.setContent(message.getContent());
			tempMessage.setOperator(message.getSrc());
			
			//1.插入消息到数据库
			messageService.create(tempMessage);
			
			//2.推送消息到 app
			Boolean toPark = message.getToPark();
			if(toPark){
				noticeParkService.sendNoicMessage(dstId.toString(), tempMessage.getTitle());
			}else{
				noticeEnterpriseService.sendNoicMessage(dstId.toString(), tempMessage.getTitle());
			}
		}
        
    }
    
    
    /**
     * 判断 session 是否为空
     * @return
     */
    protected Boolean sessionIsNull(){
    	Session session = getSessionQuietly();
    	if(session == null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 获取任务编码
     * @return
     */
    protected String createTaskNo(){
    	StringBuilder type = new StringBuilder("Task_");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	type.append(sdf.format(new Date()));
    	String taskNo = genCodeService.nextCodeByType(type.toString());

    	return taskNo;
    }
    

    /**
     * 活动申请单号
     * @return
     */
    protected String createApplyNo(){
    	StringBuilder type = new StringBuilder("");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	type.append(sdf.format(new Date()));
    	String applyNo = genCodeService.nextCodeByType(type.toString());

    	return applyNo;
    }
    
    protected void updateServiceProScane(ServiceProject serviceProject){
    	
    	//3.1维护服务场景信息
        ServiceProScane serviceProScane = new ServiceProScane();
        serviceProScane.setServiceProId(serviceProject.getId());
        serviceProScane.setServiceProRelease(serviceProject.getReleases());
        List<ServiceProScane> validServiceProScanes = serviceProScaneService.findByObj(serviceProScane);
        //3.1.2 删除已有的所有适用场景
        if(CollectionUtils.isNotEmpty(validServiceProScanes)){
        	for(ServiceProScane item:validServiceProScanes){
        		item.setStatus(Status.DELETED);
        		item.setOperator(getSessionQuietly().getUserId());
        		
        		serviceProScaneService.update(item);
        	}
        }
        //3.1.2 保存所有的已选适用场景
        List<ServiceScenario> serviceScenarios = serviceProject.getServiceScenarios();
        if(CollectionUtils.isNotEmpty(serviceScenarios)){
        	ServiceProScane obj = null;
        	for(ServiceScenario item:serviceScenarios){
        		obj = new ServiceProScane();
        		
        		obj.setServiceProId(serviceProject.getId());
        		obj.setServiceProRelease(serviceProject.getReleases());
        		obj.setServiceScaneId(item.getId());
        		obj.setOperator(getSessionQuietly().getUserId());
        		
        		serviceProScaneService.create(obj);
        	}
        }
    }
    
	//获取对应版本的服务项目信息
    protected ServiceProject getValidServiceProject(ApplyOrder applyOrder){
    	
    	if(applyOrder == null){
    		return null;
    	}
       	Long serviceProId = applyOrder.getServiceProId();
        if(serviceProId == null){
        	return null;
        }
    	
        ServiceProject tempQuery = new ServiceProject();
        tempQuery.setId(serviceProId);
        Integer serviceProRelease = applyOrder.getServiceProRelease();
        tempQuery.setReleases(serviceProRelease);
        List<ServiceProject> serviceProjects = serviceProjectService.findByObj(tempQuery);
        if(CollectionUtils.isNotEmpty(serviceProjects)){
        	return serviceProjects.get(0);
        }else{
        	ServiceProjectHistory serviceProjectHistory = new ServiceProjectHistory();
        	serviceProjectHistory.setServiceProId(serviceProId);
        	serviceProjectHistory.setServiceProRelease(serviceProRelease);
        	
        	List<ServiceProjectHistory> list = serviceProjectHistoryService.findByObj(serviceProjectHistory);
        	if(CollectionUtils.isNotEmpty(list)){
        		return copyServiceProjectHistoryToClass(list.get(0));
        	}else{
        		return null;
        	}
        }
    }
    
    /**
     * 服务项目申请单订单号
     * @return
     */
    protected String createApplyOrderNo(String applyOrderType){
    	StringBuilder type = new StringBuilder("");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	type.append(sdf.format(new Date()));
    	type.append(applyOrderType);
    	
    	String applyOrderNo = genCodeService.nextCodeByType(type.toString());
    	return applyOrderNo;
    }
    
    /**
     * 判断是否为空，为空返回空串
     * @param obj
     * @return
     */
    protected Object notNull(Object obj){
    	if(obj == null){
    		return "";
    	}else{
    		return obj;
    	}
    }
    
    /**
     * 将服务项目信息拷入历史表中
     * @param serviceProject
     */
    protected void copyServiceProjectToHistory(ServiceProject serviceProject){
    	ServiceProjectHistory serviceProjectHistory = new ServiceProjectHistory();
    	
    	serviceProjectHistory.setApplyOrderNum(serviceProject.getApplyOrderNum());
    	serviceProjectHistory.setApplyViewId(serviceProject.getApplyViewId());
    	serviceProjectHistory.setApprovalBy(serviceProject.getApprovalBy());
    	serviceProjectHistory.setApprovalStatus(serviceProject.getApprovalStatus());
    	serviceProjectHistory.setApprovalText(serviceProject.getApprovalText());
    	serviceProjectHistory.setApprovalTime(serviceProject.getApprovalTime());
    	
    	serviceProjectHistory.setCollectNum(serviceProject.getCollectNum());
    	serviceProjectHistory.setCommentNum(serviceProject.getCommentNum());
    	serviceProjectHistory.setContent(serviceProject.getContent());
    	serviceProjectHistory.setCreateBy(serviceProject.getCreateBy());
    	serviceProjectHistory.setCreateTime(serviceProject.getCreateTime());
    	
    	serviceProjectHistory.setDisplayOrder(serviceProject.getDisplayOrder());
    	
    	serviceProjectHistory.setLastUpdate(serviceProject.getLastUpdate());
    	
    	serviceProjectHistory.setMainTitle(serviceProject.getMainTitle());
    	serviceProjectHistory.setOperator(serviceProject.getOperator());
		serviceProjectHistory.setOrderViewId(serviceProject.getOrderViewId());
		
		serviceProjectHistory.setParkCityId(serviceProject.getParkCityId());
		serviceProjectHistory.setParkCounId(serviceProject.getParkCounId());
		serviceProjectHistory.setParkId(serviceProject.getParkId());
		serviceProjectHistory.setParkLocationId(serviceProject.getParkLocationId());
		serviceProjectHistory.setParkProId(serviceProject.getParkProId());
		
		serviceProjectHistory.setReadNum(serviceProject.getReadNum());

		serviceProjectHistory.setServerGrade(serviceProject.getServerGrade());
		serviceProjectHistory.setServiceGrade(serviceProject.getServiceGrade());
		serviceProjectHistory.setServiceGradeId(serviceProject.getServiceGradeId());
		serviceProjectHistory.setServiceGradeName(serviceProject.getServiceGradeName());
		serviceProjectHistory.setServiceProId(serviceProject.getId());
		serviceProjectHistory.setServiceProRelease(serviceProject.getReleases());
		serviceProjectHistory.setServiceTypeId(serviceProject.getServiceTypeId());
		serviceProjectHistory.setStatus(serviceProject.getStatus());
		serviceProjectHistory.setSubTitle(serviceProject.getSubTitle());
		serviceProjectHistory.setSupportApply(serviceProject.getSupportApply());
		serviceProjectHistory.setSupportOrder(serviceProject.getSupportOrder());

		serviceProjectHistory.setUpdateBy(serviceProject.getUpdateBy());
		serviceProjectHistory.setUpdateTime(serviceProject.getUpdateTime());

		serviceProjectHistory.setVersion(serviceProject.getVersion());

		serviceProjectHistoryService.create(serviceProjectHistory);
    }
    
    /**
     * 将服务项目信息拷入历史表中
     * @param serviceProject
     */
    protected ServiceProject copyServiceProjectHistoryToClass(ServiceProjectHistory serviceProject){
    	ServiceProject serviceProjectHistory = new ServiceProject();
    	
    	serviceProjectHistory.setApplyOrderNum(serviceProject.getApplyOrderNum());
    	serviceProjectHistory.setApplyViewId(serviceProject.getApplyViewId());
    	serviceProjectHistory.setApprovalBy(serviceProject.getApprovalBy());
    	serviceProjectHistory.setApprovalStatus(serviceProject.getApprovalStatus());
    	serviceProjectHistory.setApprovalText(serviceProject.getApprovalText());
    	serviceProjectHistory.setApprovalTime(serviceProject.getApprovalTime());
    	
    	serviceProjectHistory.setCollectNum(serviceProject.getCollectNum());
    	serviceProjectHistory.setCommentNum(serviceProject.getCommentNum());
    	serviceProjectHistory.setContent(serviceProject.getContent());
    	serviceProjectHistory.setCreateBy(serviceProject.getCreateBy());
    	serviceProjectHistory.setCreateTime(serviceProject.getCreateTime());
    	
    	serviceProjectHistory.setDisplayOrder(serviceProject.getDisplayOrder());
    	
    	serviceProjectHistory.setLastUpdate(serviceProject.getLastUpdate());
    	
    	serviceProjectHistory.setMainTitle(serviceProject.getMainTitle());
    	serviceProjectHistory.setOperator(serviceProject.getOperator());
		serviceProjectHistory.setOrderViewId(serviceProject.getOrderViewId());
		
		serviceProjectHistory.setParkCityId(serviceProject.getParkCityId());
		serviceProjectHistory.setParkCounId(serviceProject.getParkCounId());
		serviceProjectHistory.setParkId(serviceProject.getParkId());
		serviceProjectHistory.setParkLocationId(serviceProject.getParkLocationId());
		serviceProjectHistory.setParkProId(serviceProject.getParkProId());
		
		serviceProjectHistory.setReadNum(serviceProject.getReadNum());

		serviceProjectHistory.setServerGrade(serviceProject.getServerGrade());
		serviceProjectHistory.setServiceGrade(serviceProject.getServiceGrade());
		serviceProjectHistory.setServiceGradeId(serviceProject.getServiceGradeId());
		serviceProjectHistory.setServiceGradeName(serviceProject.getServiceGradeName());
		
		serviceProjectHistory.setId(serviceProject.getServiceProId());
		serviceProjectHistory.setReleases(serviceProject.getServiceProRelease());		
		
		serviceProjectHistory.setServiceTypeId(serviceProject.getServiceTypeId());
		serviceProjectHistory.setStatus(serviceProject.getStatus());
		serviceProjectHistory.setSubTitle(serviceProject.getSubTitle());
		serviceProjectHistory.setSupportApply(serviceProject.getSupportApply());
		serviceProjectHistory.setSupportOrder(serviceProject.getSupportOrder());

		serviceProjectHistory.setUpdateBy(serviceProject.getUpdateBy());
		serviceProjectHistory.setUpdateTime(serviceProject.getUpdateTime());

		serviceProjectHistory.setVersion(serviceProject.getVersion());

		return serviceProjectHistory;
    }
}
