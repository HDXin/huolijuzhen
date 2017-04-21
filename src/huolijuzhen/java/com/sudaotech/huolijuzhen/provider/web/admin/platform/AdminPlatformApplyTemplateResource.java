package com.sudaotech.huolijuzhen.provider.web.admin.platform;

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

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.LabelType;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService.ApplyTemplate;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.TemplateLabel;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/applyTemplate")
public class AdminPlatformApplyTemplateResource extends BaseResource {

    @Inject
    private ApplyTemplateService applyTemplateService;
    
    @Inject
    private TemplateLabelService templateLabelService;
    
    /**
     * 创建申请单模板
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ApplyTemplate applyTemplate) {
		try{
			ApplyTemplate obj = extractValidInfo(applyTemplate);
			
			obj.setOperator(getSessionQuietly().getUserId());
		    Long id = applyTemplateService.create(obj);
		    
		    List<TemplateLabel> templateLabes = applyTemplate.getTemplateLabels();
            if(CollectionUtils.isNotEmpty(templateLabes)){
            	TemplateLabel templateLabel = null;
            	for(TemplateLabel item:templateLabes){
            		
            		templateLabel = new TemplateLabel();
            		
            		templateLabel.setApplyTemplateId(id);
            		templateLabel.setId(item.getId());
            		templateLabel.setLabelHint(item.getLabelHint());
            		templateLabel.setLabelType(item.getLabelType());
            		templateLabel.setName(item.getName());
            		templateLabel.setIsRequire(item.getIsRequire());
            		
            		templateLabel.setOperator(getSessionQuietly().getUserId());
            		
            		Long templateLabelId = item.getId();
            		if(templateLabelId != null){
                		templateLabelService.update(templateLabel);            			
            		}else{
            			templateLabelService.create(templateLabel);
            		}
            	}
            }
		    
		    
		    
		    Map<String, Long> map = MapHelper.put("id", id).getMap();
		
		    Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
		    result.setLocation(String.format("/applyTemplate/%s", id));
		    result.setData(map);
		    return result;
			
		}catch(Exception e){
			logger.error("平台创建申请单模板 error:{}",e);
			return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    /**
     * 编辑申请单模板信息
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
            final ApplyTemplate applyTemplate) {
    	try{
    		ApplyTemplate obj = new ApplyTemplate();
    		
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            applyTemplateService.update(obj);
            
            List<TemplateLabel> templateLabes = applyTemplate.getTemplateLabels();
            if(CollectionUtils.isNotEmpty(templateLabes)){
            	TemplateLabel templateLabel = null;
            	for(TemplateLabel item:templateLabes){

            		templateLabel = new TemplateLabel();
            		templateLabel.setId(item.getId());

            		templateLabel.setApplyTemplateId(id);
            		templateLabel.setLabelHint(item.getLabelHint());
            		templateLabel.setLabelType(item.getLabelType());
            		templateLabel.setName(item.getName());
            		templateLabel.setIsRequire(item.getIsRequire());
            		
            		templateLabel.setOperator(getSessionQuietly().getUserId());
            		
            		Long templateLabelId = item.getId();
            		if(templateLabelId != null){
                		templateLabelService.update(templateLabel);            			
            		}else{
            			templateLabelService.create(templateLabel);
            		}
            	}
            }
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("编辑申请单模板信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            ApplyTemplate obj = applyTemplateService.getById(id);
            if(obj == null){
            	return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
            }
            
            Map<String, Object> dataMap = packItemInfo(obj);
            List<Map<String, Object>> templateLabelList = templateLabelService.findByApplyTemplateId(id);
            if(CollectionUtils.isNotEmpty(templateLabelList)){
            	for(Map<String, Object> itemMap:templateLabelList){
            		Integer labelType = (Integer)itemMap.get("labelType");
            		
            		itemMap.put("labelType", LabelType.codeOf(labelType));
            	}
            }
            dataMap.put("templateLabels",templateLabelList);
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台获取申请单模板信息 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private ApplyTemplate extractValidInfo(ApplyTemplate temp){
    	
    	ApplyTemplate obj = new ApplyTemplate();
    	obj.setTemplateLabels(temp.getTemplateLabels());
    	return obj;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(ApplyTemplate item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());

    	return infoMap;
    }
}
