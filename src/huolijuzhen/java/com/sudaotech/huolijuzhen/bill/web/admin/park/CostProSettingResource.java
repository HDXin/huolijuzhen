package com.sudaotech.huolijuzhen.bill.web.admin.park;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostProQuery;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.CostProSetting;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.NewCostProSetting;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.Query;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.costProSettingUpdate;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

@Path("/admin/park/costProSetting")
public class CostProSettingResource extends BaseResource {
	
	@Inject
	private CostProService costProService;

    @Inject
    private CostProSettingService costProSettingService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> create(@Valid final List<NewCostProSetting> newCostProSettings) {
        // create
        try{
        	if(CollectionUtils.isEmpty(newCostProSettings)){
        		return new Result<String>(ResultCode.BAD_REQUEST);
        	}
        	for(NewCostProSetting obj:newCostProSettings){
            	CostProSetting costProSetting = new CostProSetting();
    			List<CostPro> costPros = obj.getCostPros();
    			CostProSetting temp = null;
    			if(CollectionUtils.isNotEmpty(costPros)){
    				for(CostPro item:costPros){
    					costProSetting.setOperator(getSessionQuietly().getUserId());
    					costProSetting.setContractId(obj.getContractId());
    	    			costProSetting.setContractNo(obj.getContractNo());
    	    			costProSetting.setCostProType(obj.getCostProType());
    	    			costProSetting.setBillMonth(obj.getBillMonth());
    	    			costProSetting.setEnterpriseId(obj.getEnterpriseId());
    	    			costProSetting.setEnterpriseName(obj.getEnterpriseName());
    	    			
    	    			costProSetting.setDosage(item.getDosage());
    					costProSetting.setCostProType(item.getId());
    					
    					costProSetting.setEnableStatus(EnableStatus.ENABLE);
    					temp = costProSettingService.findByObject(costProSetting);
    					if(temp == null){
        	                costProSettingService.create(costProSetting);
    					}else{
    						costProSettingService.update(costProSetting);
    					}
    				}
    			}
        	}
            return new Result<String>(ResultCode.OK);
        	
        }catch(Exception e){
        	logger.error("费用项目用量新增 error:{}",e);
        	return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(@Valid final List<costProSettingUpdate> costProSettingUpdates) {
    	
    	if(CollectionUtils.isNotEmpty(costProSettingUpdates)){
    		for(costProSettingUpdate item:costProSettingUpdates){
    			
    			CostProSetting temp = new CostProSetting();
    			temp.setContractId(item.getContractId());
    			temp.setCostProType(item.getCostProType());
    			temp.setBillMonth(item.getBillMonth());
    			CostProSetting costProSetting = costProSettingService.findByObject(temp);
    		       
    			if(costProSetting != null){
    				costProSetting.setDosage(item.getDosage());
    				costProSettingService.update(costProSetting);
    			}else{
    				costProSetting = new CostProSetting();
    				
    				costProSetting.setOperator(getSessionQuietly().getUserId());
					
    				Long contractId = item.getContractId();
    				costProSetting.setContractId(contractId);
    				if(contractId != null){
        				ContractInfo contractInfo = contractInfoService.getById(contractId);
        				if(contractInfo != null){
        	    			costProSetting.setContractNo(contractInfo.getContNo());
        				}
    				}
	    			costProSetting.setCostProType(item.getCostProType());
	    			costProSetting.setBillMonth(item.getBillMonth());
	    			
	    			Long enterpriseId = item.getEnterpriseId();
	    			if(enterpriseId != null){
		    			costProSetting.setEnterpriseId(enterpriseId);
	    			}
	    			
	    			EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(enterpriseId);
	    			if(enterpriseInfo != null){
		    			costProSetting.setEnterpriseName(enterpriseInfo.getName());
	    			}
	    			costProSetting.setDosage(item.getDosage());
					costProSetting.setEnableStatus(EnableStatus.ENABLE);
    				
    				costProSettingService.create(costProSetting);
    			}
    		}
    	}
        return ResultSupport.ok();
    }

//    @DELETE
//    @Path("/{id}")
//    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Transactional
//    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
//        CostProSetting obj = new CostProSetting();
//        obj.setStatus(Status.DELETED);
//        return update(id, obj);
//    }
//
//    @DELETE
//    @Path("")
//    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Transactional
//    public Result<String> deleteMore(final List<Long> ids) {
//    	if (!CollectionUtils.isEmpty(ids)) {
//			for (Long id : ids) {
//				delete(id);
//			}
//    	}
//        return ResultSupport.ok();
//    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<CostProSetting> get(@NotNull @PathParam("id") final Long id) {
        CostProSetting obj = costProSettingService.getById(id);
        
        return new Result<CostProSetting>(obj == null ? ResultCode.NOT_FOUND_COST_PRO_SETTING_ITEM : ResultCode.OK, obj);
    }

    @GET
    @Path("/findByObject")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<CostProSetting> findByObject(
    		@QueryParam("contractId") Long contractId,
            @QueryParam("costProType") Long costProType,
            @QueryParam("billMonth") String billMonth) {
    	
    	CostProSetting costProSetting = new CostProSetting();
    	costProSetting.setContractId(contractId);
    	costProSetting.setCostProType(costProType);
    	costProSetting.setBillMonth(billMonth);
    	
        CostProSetting obj = costProSettingService.findByObject(costProSetting);
        
        return new Result<CostProSetting>(obj == null ? ResultCode.NOT_FOUND_COST_PRO_SETTING_ITEM : ResultCode.OK, obj);
    }
    
    /**
     * 费用项目（按用量计算）批量获取
     * @param offset
     * @param limit
     * @param pageNum
     * @param code
     * @param name
     * @param chargeMode
     * @param enableStatus
     * @param contractId
     * @param costProType
     * @param billMonth
     * @return
     */
    @GET
    @Path("/findAllCostPro")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String, Object>>> findAllCostPro(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
    		@QueryParam("contractId") Long contractId,
            @QueryParam("billMonth") String billMonth) {
    	
    	List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
    	
    	//1. 获取按量计算的费用项目
    	Session session = getSessionQuietly();
    	if(session == null){
    		return new Result<List<Map<String, Object>>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId()==null || session.getPlatformId()==0){
    		return new Result<List<Map<String, Object>>>(ResultCode.BAD_REQUEST);
    	}
    	CostProQuery query = new CostProQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setChargeMode(ChargeMode.DOSAGE);
		query.setEnableStatus(EnableStatus.ENABLE);
	
		//1.2 只能查询所属园区的
		query.setCreateSource(CreateSource.PARK);
		query.setParkId(session.getPlatformId());
		
		Page<CostPro> page = costProService.find(query);
    	List<CostPro> costPros = page.getItems();
    	if(CollectionUtils.isEmpty(costPros)){
    		return new Result<List<Map<String, Object>>>(ResultCode.NOT_FOUND_DOSAGE_COST_PRO, resultList);
    	}
    	
		for(CostPro costPro:costPros){
	    	CostProSetting costProSetting = new CostProSetting();
	    	costProSetting.setContractId(contractId);
	    	costProSetting.setCostProType(costPro.getId());
	    	costProSetting.setBillMonth(billMonth);
	    	
	        CostProSetting obj = costProSettingService.findByObject(costProSetting);
	        Map<String, Object> itemMap = new HashMap<String, Object>();
			itemMap.put("costProName", costPro.getName());
			BigDecimal unitPrise = costPro.getChargePrice();
			itemMap.put("unitPrise", unitPrise);
			BigDecimal costRate = costPro.getCostRate();
			itemMap.put("taxRate", costPro.getCostRate());
			itemMap.put("chargeMode", costPro.getChargeMode());
			
	        if(obj != null && obj.getDosage().compareTo(new BigDecimal(0)) > 0){
	        	//用量
	        	BigDecimal dosage = obj.getDosage();
				itemMap.put("dosage", dosage);
				//税后金额
				BigDecimal totalMoney = unitPrise.multiply(dosage).setScale(2,BigDecimal.ROUND_HALF_UP);
				itemMap.put("totalMoney", totalMoney);
				//税额
				BigDecimal taxMoney = totalMoney.divide(costRate.add(new BigDecimal(1)),2,BigDecimal.ROUND_HALF_UP)
												.multiply(costRate)
												.setScale(2,BigDecimal.ROUND_HALF_UP);
				itemMap.put("taxMoney", taxMoney);
				//税前
				BigDecimal cost = totalMoney.subtract(taxMoney);
				itemMap.put("cost", cost);
				
	        }else{
	        	itemMap.put("dosage", new BigDecimal(0));
	        	itemMap.put("cost", 0);
	        	itemMap.put("taxMoney", 0);
				itemMap.put("totalMoney", 0);
	        }
	        resultList.add(itemMap);
		}
    	//2.
        return new Result<List<Map<String, Object>>>(ResultCode.OK,resultList);
    }
    
    @Test
    public void testBigdecimal(){
    	
    	BigDecimal a = new BigDecimal("100");
    	BigDecimal b = new BigDecimal("3");
    	
    	BigDecimal c = a.divide(b,2,BigDecimal.ROUND_HALF_UP);
    	
    	System.out.println("-------->c:" + c);
    	
//    	BigDecimal d = c.setScale(2,BigDecimal.ROUND_HALF_UP);
//    	
//    	System.out.println("====>>>d:" + d);
    	
    	
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<CostProSetting>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billMonth") String billMonth
            ) {
		
		
		Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Page<CostProSetting>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Page<CostProSetting>>(ResultCode.BAD_REQUEST);
    	}
    	
    	
		//1.只能查询所属园区的所有按用量计算的费用项目
		CostPro cp = new CostPro();
		cp.setCreateSource(CreateSource.PARK);
		cp.setParkId(session.getPlatformId());
		cp.setChargeMode(ChargeMode.DOSAGE);
		cp.setEnableStatus(EnableStatus.ENABLE);
		List<CostPro> list = costProService.findByObj(cp);
		List<CostPro> costPros = new ArrayList<CostProService.CostPro>();
		for(CostPro item:list){
			if(EnableStatus.ENABLE.equals(item.getEnableStatus())){
				costPros.add(item);
			}
		}
		int num = 0;
		if(CollectionUtils.isNotEmpty(costPros)){
			num = costPros.size();
		}
		
		Query query = new Query();
		if(offset == null || offset == 0){
			query.setOffset(0);
		}else{
			query.setOffset(offset*num);
		}
		if(limit == null || limit ==  0){
			query.setLimit(num*16);
		}else{
			query.setLimit(limit*num);
		}
		if(pageNum == null || pageNum == 0){
			query.setPage(1);
		}else{
			query.setPage(pageNum);
		}
		query.setBillMonth(billMonth);
		Page<CostProSetting> page = costProSettingService.find(query);
		List<CostProSetting> items = page.getItems();
		if(CollectionUtils.isNotEmpty(items)){
			items = itemConverter(items,costPros);
		}
		page.setItems(items);
		page.setOffset(offset);
		page.setLimit(limit);
		int total = page.getTotal();
		if(total > 0){
			page.setTotal(total/num);
		}
        return new Result<Page<CostProSetting>>(ResultCode.OK, page);
    }
    
    /**
     * 数据结构转换
     * @param items
     * @return
     */
    private List<CostProSetting> itemConverter(List<CostProSetting> items,List<CostPro> validCostPro){
    	//1.分组
    	Map<String, List<CostProSetting>> groups = new HashMap<String, List<CostProSetting>>();
    	List<CostProSetting> groupItems = null;
    	for(CostProSetting item:items){
    		String key = providerKey(item);
    		groupItems = groups.get(key);
    		if(CollectionUtils.isEmpty(groupItems)){
    			groupItems = new ArrayList<CostProSettingService.CostProSetting>();
    		}
    		groupItems.add(item);
    		groups.put(key, groupItems);
    	}
    	
    	
    	
    	//2.每组进行数据组装
    	List<CostProSetting> result = new ArrayList<CostProSettingService.CostProSetting>();
    	for(Map.Entry<String, List<CostProSetting>> entity:groups.entrySet()){
    		
    		List<CostProSetting> costProSettings = entity.getValue();
    		CostProSetting costProSetting = costProSettings.get(0);
    		//排序费用项目
    		CostPro costPro = null;
    		Map<Long, CostPro> costProMap = new HashMap<Long, CostProService.CostPro>();
    		for(CostProSetting item:costProSettings){
    			costPro = costProService.getById(item.getCostProType());
    			if(costPro == null){
    				costPro = new CostPro();
    			}
    			costPro.setDosage(item.getDosage());
    			costProMap.put(item.getCostProType(), costPro);
    		}

    		//封装费用项目
    		List<CostPro> costPros = new ArrayList<CostProService.CostPro>();
    	    for(Map.Entry<Long, CostPro> costProEntity:costProMap.entrySet()){
    	    	costPros.add(costProEntity.getValue());
    	    }
    	    
    	    //获取所有已经启用费用项目
	    	Map<Long,CostPro> currentCostProMap = new HashMap<Long, CostProService.CostPro>();
    	    for(CostPro item:costPros){
	    		currentCostProMap.put(item.getId(), item);
	    	}
    	    
    	    //判断该费用项目是否已存在
    	    List<CostPro> costProsList = new ArrayList<CostProService.CostPro>();
    	    for(CostPro item:validCostPro){
    	    	Long costProId = item.getId();
    	    	CostPro tempCostPro = currentCostProMap.get(costProId);
    	    	if(tempCostPro != null){
    	    		costProsList.add(tempCostPro);
    	    	}else{
    	    		costProsList.add(item);
    	    	}
    	    }
    		
    		costProSetting.setCostPros(costProsList);
    		result.add(costProSetting);
    	}
    	
    	
    	
    	return result;
    }
    
    private String providerKey(CostProSetting item){
		StringBuilder keyStr = new StringBuilder();
		keyStr.append(item.getContractId());
		keyStr.append("-");
		keyStr.append(item.getBillMonth());

		return keyStr.toString();
    }
}
