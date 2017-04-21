package com.sudaotech.huolijuzhen.provider.web.admin.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.Query;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.TemplateLabel;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/templateLabel")
public class AdminPlatformTemplateLabelResource extends BusinessBaseResource {

    @Inject
    private TemplateLabelService templateLabelService;
    
    /**
     * 创建标签信息
     * @param obj
     * @return
     */
    @POST
    @Path("/createLabel")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> createLabel(@Valid final TemplateLabel obj) {
    	try{
    		Map<String, Object> dataMap = new HashedMap<String, Object>();
    		
    		dataMap.put("name", notNull(obj.getName()));
    		dataMap.put("labelHint", notNull(obj.getLabelHint()));
    		dataMap.put("labelType", notNull(obj.getLabelType()));

            return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    		
    	}catch(Exception e){
    		logger.error("平台创建申请模板标签 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    /**
     * 添加标签信息
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final TemplateLabel obj) {
    	try{
    		//1.获取表单信息
    		TemplateLabel temp = extractValidInfo(obj);
            // create
    		//2.维护特殊信息
            temp.setOperator(getSessionQuietly().getUserId());
            
            
            Long id = templateLabelService.create(temp);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/templateLabel/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("平台添加申请模板标签 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 上移动
     * @param id
     * @return
     */
    @GET
    @Path("/up/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> up(@PathParam("id") Long id) {
    	try{
    		
    		TemplateLabel templateLabel = templateLabelService.getById(id);
    		if(templateLabel == null){
    			return new Result<Map<String,Long>>(ResultCode.BAD_REQUEST);
    		}
    		Long tempLabelNo = templateLabel.getLabelNo();
    		List<TemplateLabel> targetLabels = templateLabelService.findUpItem(templateLabel);
    		if(CollectionUtils.isNotEmpty(targetLabels)){
    			TemplateLabel targetLabel = targetLabels.get(0);
    			Long targetLabelNo = targetLabel.getLabelNo();
    			templateLabel.setLabelNo(targetLabelNo);
    			targetLabel.setLabelNo(tempLabelNo);

    			templateLabelService.update(targetLabel);
    			templateLabelService.update(templateLabel);
    		}
    		
    		return new Result<Map<String,Long>>(ResultCode.OK);
    	}catch(Exception e){
    		logger.error("平台上移申请模板标签 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 下移动
     * @param id
     * @return
     */
    @GET
    @Path("/down/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> down(@PathParam("id") Long id) {
    	try{
    		TemplateLabel templateLabel = templateLabelService.getById(id);
    		if(templateLabel == null){
    			return new Result<Map<String,Long>>(ResultCode.BAD_REQUEST);
    		}
    		Long tempLabelNo = templateLabel.getLabelNo();
    		List<TemplateLabel> targetLabels = templateLabelService.findDownItem(templateLabel);
    		if(CollectionUtils.isNotEmpty(targetLabels)){
    			TemplateLabel targetLabel = targetLabels.get(0);
    			Long targetLabelNo = targetLabel.getLabelNo();
    			templateLabel.setLabelNo(targetLabelNo);
    			targetLabel.setLabelNo(tempLabelNo);

    			templateLabelService.update(targetLabel);
    			templateLabelService.update(templateLabel);
    		}
    		
    		return new Result<Map<String,Long>>(ResultCode.OK);
    	}catch(Exception e){
    		logger.error("平台下移申请模板标签 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	try{
            TemplateLabel obj = new TemplateLabel();
            obj.setId(id);
            obj.setStatus(Status.DELETED);
            templateLabelService.update(obj);
            return ResultSupport.ok();    		
    	}catch(Exception e){
    		logger.error("平台删除模板标签 error{}:",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("applyTemplateId") Long applyTemplateId
            ) {
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		query.setApplyTemplateId(applyTemplateId);
    		
    		Page<TemplateLabel> page = templateLabelService.find(query);
    		Map<String, Object> dataMap = packPageInfo(page);

    		return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("平台获取指定模板的标签 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private TemplateLabel extractValidInfo(TemplateLabel temp){
    	TemplateLabel obj = new TemplateLabel();
    	
    	obj.setName(temp.getName());
    	obj.setLabelHint(temp.getLabelHint());
    	obj.setLabelType(temp.getLabelType());
    	
    	return obj;
    }
    
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<TemplateLabel> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<TemplateLabel> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(TemplateLabel pc:list){
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
    private Map<String, Object> packListInfo(TemplateLabel item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(TemplateLabel item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("labelHint", notNull(item.getLabelHint()));
    	infoMap.put("labelType", notNull(item.getLabelType()));
    	infoMap.put("labelNo", notNull(item.getLabelNo()));
    	infoMap.put("isRequire", notNull(item.getIsRequire()));

    	return infoMap;
    }
    
}