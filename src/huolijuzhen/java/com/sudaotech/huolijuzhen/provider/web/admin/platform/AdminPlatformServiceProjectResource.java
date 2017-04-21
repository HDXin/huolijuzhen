package com.sudaotech.huolijuzhen.provider.web.admin.platform;

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
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.ServiceType;
import com.sudaotech.huolijuzhen.enums.ChooseStatus;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.LabelType;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService.ApplyTemplate;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ServiceParkService;
import com.sudaotech.huolijuzhen.provider.service.ServiceParkService.ServicePark;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneService.ServiceProScane;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.Query;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.UpdateItemInfo;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.TemplateLabel;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/serviceProject")
public class AdminPlatformServiceProjectResource extends BusinessBaseResource {

    @Inject
    private ServiceParkService serviceParkService;
    
    @Inject
    private ServiceTypeService serviceTypeService;
    
    @Inject
    private ServiceScenarioService serviceScenarioService;
    
    @Inject
    private ProviderService providerService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private ApplyTemplateService applyTemplateService;
    
    @Inject
    private TemplateLabelService templateLabelService;
    
    @Inject
    private OrderTemplateService orderTemplateService;
    
    /**
     * 添加服务项目
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ServiceProject obj) {
    	try{
    		//1.提取表单数据，保存服务项目信息
    		ServiceProject temp = extractValidInfo(obj);
    		
    		//2.维护特殊信息
    		temp.setServiceGrade(ServiceGrade.PLATFORMSELF);
    		temp.setServiceGradeId(0L);
    		temp.setServiceGradeName("平台自营");
            temp.setOperator(getSessionQuietly().getUserId());
            //3.执行添加
            Long id = serviceProjectService.create(temp);
            
            //3.1维护服务场景信息
            temp.setId(id);
            temp.setReleases(0);
            updateServiceProScane(temp);

            //4.若服务对象是园区，保存园区ID
            ServerGrade serverGrade = temp.getServerGrade();
            if(ServerGrade.PARK.equals(serverGrade)){
                temp.setId(id);
                updateServicepark(temp);
            }
            
            //5.保存图片信息
            List<ImageInfo> mainImageInfos = obj.getMainImage();
            createImageInfo(ImageType.SERVICE_MAIN, id, mainImageInfos, 0);
            
            List<ImageInfo> listImageInfos = obj.getListImage();
            createImageInfo(ImageType.SERVICE_LIST, id, listImageInfos, 0);
            
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/serviceProject/%s", id));
            result.setData(map);
            return result;
    	}catch(Exception e){
    		logger.error("平台添加服务项目 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑服务项目
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
            @Valid final ServiceProject obj) {
    	try{
    		if(id == null){
    			return new Result<String>(ResultCode.ITEM_ID_IS_NULL);
    		}
    		
    		ServiceProject serviceProject = serviceProjectService.getById(id);
    		if(serviceProject == null){
    			return new Result<String>(ResultCode.NOT_FOUND_ITEM);
    		}
    		
    		//1.提取表单数据，保存服务项目信息
    		ServiceProject temp = extractValidInfo(obj);
    		
    		//2.维护特殊信息
            temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            
            //3.更新服务项目的基本信息
            serviceProjectService.update(temp);
            
            //3.1维护服务场景信息
            temp.setReleases(serviceProject.getReleases());
            updateServiceProScane(temp);
            
            //4.更新服务项目与园区的关系
            ServerGrade serverGrade = temp.getServerGrade();
            if(ServerGrade.PARK.equals(serverGrade)){
                updateServicepark(temp);
            }
            
            //5.更新图片信息
            List<ImageInfo> mainImageInfos = obj.getMainImage();
            updateImageInfo(ImageType.SERVICE_MAIN, id, mainImageInfos,serviceProject.getReleases());
            
            List<ImageInfo> listImageInfos = obj.getListImage();
            updateImageInfo(ImageType.SERVICE_LIST, id, listImageInfos,serviceProject.getReleases());
            
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台编辑服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 更新 服务项目与园区关系
     * @param temp
     * @throws Exception
     */
    private void updateServicepark(ServiceProject temp)throws Exception{
        ServerGrade serverGrade = temp.getServerGrade();
        
        serviceParkService.updateByServiceProIdAndRelease(temp.getId(),temp.getReleases());
        if(ServerGrade.PARK.equals(serverGrade)){
    		//TODO 指定园区可见
    		List<Long> parkIds = temp.getParkIds();
    		if(CollectionUtils.isNotEmpty(parkIds)){
    			ServicePark servicePark = null;
    			for(Long parkId:parkIds){
    				servicePark = new ServicePark();
    				
    				servicePark.setServiceId(temp.getId());
    				servicePark.setServiceProRelease(temp.getReleases());
    				servicePark.setParkId(parkId);
    				servicePark.setChooseStatus(ChooseStatus.CHOOSE);
    				
    				serviceParkService.create(servicePark);
    			}
    		}
    	}
    }
    
    /**
     * 审批服务项目
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
            @Valid final UpdateItemInfo updateItemInfo) {
    	try{

    		//1.判断参数中 id 是否为空
    		if(id == null){
    			return new Result<String>(ResultCode.PARAM_ERROR);
    		}
    		//2.判断是否有权限操作
    		//TODO
    		
    		//3.进行审批操作
    		ServiceProject obj = new ServiceProject();
    		
    		obj.setId(id);
    		obj.setApprovalBy(getSessionQuietly().getUserId());
    		obj.setApprovalStatus(updateItemInfo.getApprovalStatus());
    		obj.setApprovalText(updateItemInfo.getApprovalText());
    		obj.setApprovalTime(new Date());

    		serviceProjectService.update(obj);
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台编辑服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 上架服务项目
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/publish/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> publish(
            @NotNull @PathParam("id") final Long id) {
    	try{

    		//1.判断参数中 id 是否为空
    		if(id == null){
    			return new Result<String>(ResultCode.PARAM_ERROR);
    		}
    		//2.判断是否有权限操作
    		//TODO
    		
    		//3.进行审批操作
    		ServiceProject obj = new ServiceProject();
    		
    		obj.setId(id);
    		obj.setApprovalBy(getSessionQuietly().getUserId());
    		obj.setApprovalStatus(ServiceApprovalStatus.PUBLISH);
    		obj.setApprovalTime(new Date());

    		serviceProjectService.update(obj);
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台编辑服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 下架服务项目
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/unpublish/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> unpublish(
            @NotNull @PathParam("id") final Long id) {
    	try{

    		//1.判断参数中 id 是否为空
    		if(id == null){
    			return new Result<String>(ResultCode.ITEM_ID_IS_NULL);
    		}
    		//2.判断数据库中是否有对应信息
    		ServiceProject serviceProject = serviceProjectService.getById(id);
    		if(serviceProject == null){
    			return new Result<String>(ResultCode.NOT_FOUND_ITEM);
    		}
    		
    		//3.判断是否有权限操作
    		//TODO
    		
    		//4.将当前服务项目信息写入历史记录表
    		copyServiceProjectToHistory(serviceProject);
//    		ServiceProjectHistory serviceProjectHistory = BeanUtils.copyProperties(serviceProject, ServiceProjectHistory.class);
//    		serviceProjectHistoryService.create(serviceProjectHistory);
    		
    		
    		Integer currentRelease = serviceProject.getReleases();
    		serviceProject.setReleases(currentRelease + 1);
    		
    		//5.复制费用项目当前版本适用的服务场景
    		ServiceProScane serviceProScane = new ServiceProScane();
    		serviceProScane.setServiceProId(id);
    		serviceProScane.setServiceProRelease(currentRelease);
    		List<ServiceProScane> serviceProScanes = serviceProScaneService.findByObj(serviceProScane);
    		
    		if(CollectionUtils.isNotEmpty(serviceProScanes)){
    			List<ServiceScenario> serviceScenarios = new ArrayList<ServiceScenarioService.ServiceScenario>();
    			ServiceScenario serviceScenario = null;
    			for(ServiceProScane item:serviceProScanes){
    				serviceScenario = new ServiceScenario();
    				serviceScenario.setId(item.getServiceScaneId());
    				
    				serviceScenarios.add(serviceScenario);
    				
    				//将适用场景标记为过去版本
    				item.setIsPast(1);
    				item.setOperator(getSessionQuietly().getUserId());
    				serviceProScaneService.update(item);
    			}
    			
    			serviceProject.setServiceScenarios(serviceScenarios);
    			
    		}
    		updateServiceProScane(serviceProject);

            //6.若服务对象是园区，复制园区ID
            ServerGrade serverGrade = serviceProject.getServerGrade();
            if(ServerGrade.PARK.equals(serverGrade)){
                List<Long> parkIds = serviceParkService.findAllParkIdsByServiceProIdAndRelease(id,currentRelease);
                serviceProject.setParkIds(parkIds);
            	
            	updateServicepark(serviceProject);
            }
            
            //7.保存图片信息
            ImageInfo mainImageInfo = new ImageInfo();
            mainImageInfo.setTargetId(id);
            mainImageInfo.setImageType(ImageType.SERVICE_MAIN);
            mainImageInfo.setServiceProRelease(currentRelease);
            List<ImageInfo> mainImageInfos = imageInfoService.findByObj(mainImageInfo);
            createImageInfo(ImageType.SERVICE_MAIN, id, mainImageInfos, serviceProject.getReleases());
            
            ImageInfo listImageInfo = new ImageInfo();
            listImageInfo.setTargetId(id);
            listImageInfo.setImageType(ImageType.SERVICE_LIST);
            listImageInfo.setServiceProRelease(currentRelease);
            List<ImageInfo> listImageInfos = imageInfoService.findByObj(listImageInfo);
            createImageInfo(ImageType.SERVICE_LIST, id, listImageInfos, serviceProject.getReleases());

            //8.复制申请单模板
            if(serviceProject.getSupportApply() && serviceProject.getApplyViewId() != null){
            	Long currentApplyViewId = serviceProject.getApplyViewId();
            	ApplyTemplate applyTemplate = applyTemplateService.getById(currentApplyViewId);
            	applyTemplate.setId(null);
            	applyTemplate.setOperator(getSessionQuietly().getUserId());
            	Long applyViewId = applyTemplateService.create(applyTemplate);
            	serviceProject.setApplyViewId(applyViewId);
            	if(applyTemplate != null){
            		TemplateLabel templateLabel = new TemplateLabel();
            		templateLabel.setApplyTemplateId(currentApplyViewId);
            		List<TemplateLabel> templateLabels = templateLabelService.findByObj(templateLabel);
            		if(CollectionUtils.isNotEmpty(templateLabels)){
            			for(TemplateLabel item:templateLabels){
            				item.setId(null);
            				item.setApplyTemplateId(applyViewId);
            				item.setOperator(getSessionQuietly().getUserId());
            				
            				templateLabelService.create(item);
            			}
            		}
            	}
            }
            
            //9.复制订单模板
            if(serviceProject.getSupportOrder() && serviceProject.getOrderViewId() != null){
                Long orderViewId = serviceProject.getOrderViewId();
                OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
                if(orderTemplate != null){
                    orderTemplate.setId(null);
                    orderTemplate.setOperator(getSessionQuietly().getUserId());
                    orderViewId = orderTemplateService.create(orderTemplate);
                    
                    serviceProject.setOrderViewId(orderViewId);
                }
            }
    		//10.进行审批操作
            serviceProject.setApprovalBy(getSessionQuietly().getUserId());
            serviceProject.setApprovalStatus(ServiceApprovalStatus.UNPUBLISH);
            serviceProject.setApprovalTime(new Date());

    		serviceProjectService.update(serviceProject);
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台编辑服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提交服务项目（用于列表便捷操作）
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/submit/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> submit(
            @NotNull @PathParam("id") final Long id) {
    	try{

    		//1.判断参数中 id 是否为空
    		if(id == null){
    			return new Result<String>(ResultCode.PARAM_ERROR);
    		}
    		//2.判断是否有权限操作
    		//TODO
    		
    		//3.进行审批操作
    		ServiceProject obj = new ServiceProject();
    		
    		obj.setId(id);
    		obj.setApprovalBy(getSessionQuietly().getUserId());
    		obj.setApprovalStatus(ServiceApprovalStatus.WAITAPPROVAL);
    		obj.setApprovalTime(new Date());

    		serviceProjectService.update(obj);
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("园区下架服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按 ID 删除服务项目
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
    		
//            ServiceProject obj = new ServiceProject();
//            obj.setStatus(Status.DELETED);
//            return update(id, obj);
    		
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("平台按 ID 删除服务项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 批量删除服务项目
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
//        	if (!CollectionUtils.isEmpty(ids)) {
//    			for (Long id : ids) {
//    				delete(id);
//    			}
//        	}
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("平台批量删除服务项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按 ID 获取服务项目详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
	        ServiceProject obj = serviceProjectService.getById(id);
	        Map<String, Object> dataMap = null;
	        if(obj != null){
	        	dataMap = packItemInfo(obj);
	        }
	        
	        return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台按 ID 获取服务项目详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 按条件获取服务项目
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
            @QueryParam("providerName") String providerName,
            @QueryParam("mainTitle") String mainTitle,
            @QueryParam("serviceGrade") String serviceGrade,
            @QueryParam("approvalStatus") String approvalStatus,
            @QueryParam("serviceTypeId") Long serviceTypeId,
            @QueryParam("serviceScenarioId") Long serviceScenarioId){
    	
    	try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setMainTitle(mainTitle);
			query.setProviderName(providerName);
			if(StringUtils.isNotBlank(serviceGrade)){
				query.setServiceGrade(ServiceGrade.valueOf(serviceGrade));
			}
			if(StringUtils.isNotBlank(approvalStatus)){
				query.setApprovalStatu(approvalStatus);
			}
			query.setServiceTypeId(serviceTypeId);
			
			//1.获取平台有权限显示的所有的服务项目
			List<Long> ids = serviceProjectService.findPlatformServiceIds();
			if(CollectionUtils.isEmpty(ids)){
				return new Result<Map<String,Object>>(ResultCode.OK,packPageInfo(new Page<ServiceProject>()));
			}

			//2.获取符合服务场景的所有的服务项目(当条件中包含场景时才作为条件)
			if(serviceScenarioId != null){
				ServiceProScane serviceProScane = new ServiceProScane();
				serviceProScane.setServiceScaneId(serviceScenarioId);
				serviceProScane.setIsPast(0);
				List<ServiceProScane> serviceProScanes = serviceProScaneService.findByObj(serviceProScane);
				if(CollectionUtils.isEmpty(serviceProScanes)){
					return new Result<Map<String,Object>>(ResultCode.OK,packPageInfo(new Page<ServiceProject>()));
				}
				List<Long> serviceProIds = new ArrayList<Long>();
				for(ServiceProScane item:serviceProScanes){
					serviceProIds.add(item.getServiceProId());
				}
				if(CollectionUtils.isNotEmpty(serviceProIds)){
					ids.retainAll(serviceProIds);
				}
			}
			
			//3.按条件分页获取平台下的服务项目
			query.setIds(ids);
			Page<ServiceProject> page = serviceProjectService.findPlatformService(query);
			
			Map<String, Object> dataMap = packPageInfo(page);
			
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台按条件获取服务项目 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private ServiceProject extractValidInfo(ServiceProject temp){
    	ServiceProject obj = new ServiceProject();
    	
    	obj.setMainTitle(temp.getMainTitle());
    	obj.setSubTitle(temp.getSubTitle());
    	
    	obj.setServiceTypeId(temp.getServiceTypeId());
    	//服务对象
    	obj.setServerGrade(temp.getServerGrade());
    	obj.setParkIds(temp.getParkIds());
    	
    	obj.setContent(temp.getContent());
    	
    	Boolean supportApply = temp.getSupportApply();
    	obj.setSupportApply(supportApply);
    	obj.setApplyViewId(temp.getApplyViewId());
    	
    	Boolean supportOrder = temp.getSupportOrder();
    	obj.setSupportOrder(supportOrder);
   		obj.setOrderViewId(temp.getOrderViewId());
    	//保存服务项目状态
    	ServiceApprovalStatus approvalStatus = temp.getApprovalStatus();
    	if(ServiceApprovalStatus.WAITSUBMIT.equals(approvalStatus) || ServiceApprovalStatus.WAITAPPROVAL.equals(approvalStatus)){
    		obj.setApprovalStatus(approvalStatus);
    	}else {
			obj.setApprovalStatus(ServiceApprovalStatus.WAITSUBMIT);
		}
    	
    	obj.setParkProId(temp.getParkProId());
    	obj.setParkCityId(temp.getParkCityId());
    	obj.setParkCounId(temp.getParkCounId());
    	obj.setParkLocationId(temp.getParkLocationId());
    	
    	//适用的场景
    	obj.setServiceScenarios(temp.getServiceScenarios());
    	
    	return obj;
    }
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ServiceProject> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<ServiceProject> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ServiceProject pc:list){
    			item = packListInfo(pc);
    			items.add(item);
    		}
    	}
    	dataMap.put("items", items);
    	return dataMap;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(ServiceProject item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("mainTitle", notNull(item.getMainTitle()));
    	//审批状态
    	infoMap.put("approvalStatus", notNull(item.getApprovalStatus()));
    	Long serviceTypeId = item.getServiceTypeId();
    	infoMap.put("serviceTypeId", serviceTypeId);
    	infoMap.put("serviceTypeName", "");
    	if(serviceTypeId != null){
    		ServiceType serviceType = serviceTypeService.getById(serviceTypeId);
    		String serviceTypeName = "";
    		if(serviceType != null){
    			serviceTypeName = serviceType.getName();
    		}
    		infoMap.put("serviceTypeName", notNull(serviceTypeName));
    	}
    	
    	//封装适用的场景
    	List<ServiceScenario> serviceScenarios = new ArrayList<ServiceScenarioService.ServiceScenario>();
    	Long serviceProId = item.getId();
    	ServiceProScane serviceProScane = new ServiceProScane();
    	serviceProScane.setServiceProId(serviceProId);
    	serviceProScane.setServiceProRelease(item.getReleases());
    	List<ServiceProScane> serviceProScanes = serviceProScaneService.findByObj(serviceProScane);
    	if(CollectionUtils.isNotEmpty(serviceProScanes)){
    		ServiceScenario serviceScenario = null;
    		for(ServiceProScane obj:serviceProScanes){
    			if(obj.getServiceScaneId() != null){
        			serviceScenario = serviceScenarioService.getById(obj.getServiceScaneId());
        			if(serviceScenario != null){
        				serviceScenarios.add(serviceScenario);
        			}
    			}
    		}
    	}
    	infoMap.put("serviceScenarios",serviceScenarios);
    	

    	//平台自营、园区自营、平台服务商、园区服务商
    	ServiceGrade serviceGrade = item.getServiceGrade();
    	infoMap.put("serviceGrade", notNull(serviceGrade));
    	if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
    		infoMap.put("providerType", "平台自营");
    		infoMap.put("providerName", "平台发布");
    	}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
    		infoMap.put("providerType", "园区自营");
    		String providerName = "";
    		Long parkId = item.getParkId();
    		if(parkId != null){
    			ParkInfo parkInfo = parkInfoService.getById(parkId);
    			if(parkInfo != null){
    				providerName = parkInfo.getName();
    			}
    		}
    		infoMap.put("providerName", providerName);
    	}else{
    		if(ServiceGrade.PARKSERVICE.equals(serviceGrade)){
    			infoMap.put("providerType", "园区服务商");
    		}else{
    			infoMap.put("providerType", "平台服务商");
    		}
    		
    		Long parkServiceId = item.getServiceGradeId();
    		Provider provider = providerService.getById(parkServiceId);
    		if(provider != null){
        		infoMap.put("providerName", notNull(provider.getName()));
    		}else{
    			infoMap.put("providerName", "");
    		}
    	}
    	
    	//是否支持申请单
    	Boolean supportApply = item.getSupportApply();
    	infoMap.put("supportApply", supportApply);
    	if(supportApply){
        	infoMap.put("applyViewId", item.getApplyViewId());
            infoMap.put("applyTemplate", new HashedMap<String, Object>());
        	Long applyTemplateId = item.getApplyViewId();
        	ApplyTemplate obj = applyTemplateService.getById(applyTemplateId);
            if(obj != null){
                Map<String, Object> applyTemplate = new HashMap<String, Object>();
                applyTemplate.put("id", obj.getId());
                
                List<Map<String, Object>> templateLabelList = templateLabelService.findByApplyTemplateId(applyTemplateId);
                if(CollectionUtils.isNotEmpty(templateLabelList)){
                	for(Map<String, Object> itemMap:templateLabelList){
                		Integer labelType = (Integer)itemMap.get("labelType");
                		
                		itemMap.put("labelType", LabelType.codeOf(labelType));
                	}
                }
                applyTemplate.put("templateLabels",templateLabelList);
                
                infoMap.put("applyTemplate", applyTemplate);
            }
    	}
    	
    	//是否支持订单
    	Boolean supportOrder = item.getSupportOrder();
    	infoMap.put("supportOrder", supportOrder);
    	if(supportOrder){
        	infoMap.put("orderViewId", item.getOrderViewId());
        	infoMap.put("orderTemplate", new HashedMap<String, Object>());
        	Long orderTemplateId = item.getOrderViewId();
    		OrderTemplate obj = orderTemplateService.getById(orderTemplateId);
            if(obj != null){
            	Map<String, Object> orderTemplateMap = packOrderTemplateItemInfo(obj);
            	
            	infoMap.put("orderTemplate", orderTemplateMap);
            }
    	}
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packOrderTemplateItemInfo(OrderTemplate item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	
    	infoMap.put("supportAliPay", item.getSupportAliPay());
    	infoMap.put("supportWeChatPay", item.getSupportWeChatPay());
    	
    	infoMap.put("priceTitleOne", notNull(item.getPriceTitleOne()));
    	infoMap.put("pricesOne", notNull(item.getPriceOne()));
    	infoMap.put("priceTitleTwo", notNull(item.getPriceTitleTwo()));
    	infoMap.put("pricesTwo", notNull(item.getPriceTwo()));
    	infoMap.put("priceTitleThree", notNull(item.getPriceTitleThree()));
    	infoMap.put("pricesThree", notNull(item.getPriceThree()));
    	
    	infoMap.put("discountTitleOne", notNull(item.getDiscountTitleOne()));
    	infoMap.put("discountsOne", notNull(item.getDiscountOne()));
    	infoMap.put("discountTitleTwo", notNull(item.getDiscountTitleTwo()));
    	infoMap.put("discountsTwo", notNull(item.getDiscountTwo()));
    	infoMap.put("discountTitleThree", notNull(item.getDiscountTitleThree()));
    	infoMap.put("discountsThree", notNull(item.getDiscountThree()));

    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(ServiceProject item){
    	Map<String, Object> infoMap = packListInfo(item);
    	
    	infoMap.put("serverGrade", notNull(item.getServerGrade()));
    	infoMap.put("subTitle", notNull(item.getSubTitle()));
    	
    	//主图
    	ImageInfo imageInfo = new ImageInfo();
    	imageInfo.setTargetId(item.getId());
    	imageInfo.setImageType(ImageType.SERVICE_MAIN);
    	imageInfo.setServiceProRelease(item.getReleases());
    	List<ImageInfo> mainImageInfos = imageInfoService.findByObj(imageInfo);
		infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}

    	//轮播图
    	imageInfo.setImageType(ImageType.SERVICE_LIST);
    	List<ImageInfo> listImageInfos = imageInfoService.findByObj(imageInfo);
    	infoMap.put("listImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(listImageInfos)){
    		infoMap.put("listImage", imageInfoListToMap(listImageInfos));
    	}

    	//详细描述
    	infoMap.put("content", notNull(item.getContent()));
    	
    	List<Map<String, Object>> parkInfos = new ArrayList<Map<String,Object>>();
    	List<Long> parkIds = serviceParkService.findAllParkIdsByServiceProIdAndRelease(item.getId(),item.getReleases());
    	infoMap.put("parkInfos", parkInfos);
		if(CollectionUtils.isNotEmpty(parkIds)){
			List<ParkInfo> parkInfoList = parkInfoService.findParkInfosByParkIds(parkIds);
			if(CollectionUtils.isNotEmpty(parkInfoList)){
				Map<String, Object> parkInfoMap = null;
				for(ParkInfo parkInfo:parkInfoList){
					parkInfoMap = new HashedMap<String, Object>();
					
					parkInfoMap.put("parkId", parkInfo.getId());
					parkInfoMap.put("parkName", parkInfo.getName());
					
					parkInfos.add(parkInfoMap);
				}
				infoMap.put("parkInfos", parkInfos);
			}
		}
    	infoMap.put("parkProviceId", notNull(item.getParkProId()));
    	infoMap.put("parkCityId", notNull(item.getParkCityId()));
    	infoMap.put("parkCounId", notNull(item.getParkCounId()));
    	infoMap.put("parkLocationId", notNull(item.getParkLocationId()));
    	
    	return infoMap;
    }
}
