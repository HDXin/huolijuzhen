package com.sudaotech.huolijuzhen.provider.web.admin.enterprise;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService.Query;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService.ServiceComment;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/enterprise/serviceComment")
public class AdminEnterpriseServiceCommentResource extends BusinessBaseResource {

    @Inject
    private ServiceCommentService serviceCommentService;
    
    @Inject
    private ApplyOrderService applyOrderService;
    
    /**
     * app 评价服务项目
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ServiceComment obj) {
        // create
    	
    	try{
    		
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long applyOrderId = obj.getApplyOrderId();
    		obj.setApplyOrderId(applyOrderId);
            obj.setOperator(session.getUserId());
            Long id = serviceCommentService.create(obj);
            
            ApplyOrder applyOrder = new ApplyOrder();
            applyOrder.setId(applyOrderId);
            applyOrder.setApplyOrderStatus(ApplyOrderStatus.FINISH);
            applyOrder.setCommentId(id);
            applyOrder.setOperator(session.getUserId());
            
            applyOrderService.update(applyOrder);
            
            //2.更新服务项目评分
            updateServiceProject(obj);
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/serviceComment/%s", id));
            result.setData(map);
            return result;
    	}catch(Exception e){
    		logger.error("app 服务项目评价 error：{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<ServiceComment> get(@NotNull @PathParam("id") final Long id) {
        ServiceComment obj = serviceCommentService.getById(id);
        
        return new Result<ServiceComment>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("serviceProId") Long serviceProId
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setServiceProId(serviceProId);
		
		Page<ServiceComment> page = serviceCommentService.find(query);
		//1.封装元素信息
		Map<String,Object> dataMap = packPageInfo(page);
		//2.平均数
		ServiceProject serviceProject = serviceProjectService.getById(serviceProId);
    	dataMap.put("gradeNumAvg", serviceProject.getCommentNum());
		
        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    }
    
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ServiceComment> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	
    	//1.翻页信息
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	//2.封装元素信息
    	List<ServiceComment> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ServiceComment sc:list){
    			item = packListInfo(sc);
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
    private Map<String, Object> packListInfo(ServiceComment item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	infoMap.put("id", item.getId());
    	infoMap.put("createTime", sdf.format(item.getCreateTime()));
    	infoMap.put("commentText", notNull(item.getCommentText()));
    	infoMap.put("gradeNum", notNull(item.getGradeNum()));
    	infoMap.put("price", notNull(item.getPrice()));
    	
    	return infoMap;
    }
    
    /**
     * 更新服务项目的评分
     * @param serviceComment
     */
    private void updateServiceProject(ServiceComment serviceComment){
    	List<Integer> commentGradeSum = serviceCommentService.findGradeNum(serviceComment.getServiceProId());
    	
    	ServiceProject serviceProject = new ServiceProject();
    	serviceProject.setId(serviceComment.getServiceProId());
    	BigDecimal bigDecimal = new BigDecimal(getAvgToInteger(commentGradeSum));
    	serviceProject.setCommentNum(bigDecimal);
    	
    	serviceProject.setOperator(getSessionQuietly().getUserId());
    	serviceProjectService.update(serviceProject);
    }
    /**
     * 求平均数（0.5 的整数倍）
     * @param nums
     * @return
     */
    private float getAvgToInteger(List<Integer> nums){
    	float avg = 0;
    	if(CollectionUtils.isNotEmpty(nums)){
			Integer size = nums.size();
			Integer sum = 0;
			for(Integer gradeNum:nums){
				sum += gradeNum;
			}
			avg = (float)sum/(float)size;
			
			DecimalFormat df = new DecimalFormat("0.0");
			avg = Float.parseFloat(df.format(avg));
			avg = (avg*10 - avg*10%5)/10;
		}
    	return avg;
    	
    }
}
