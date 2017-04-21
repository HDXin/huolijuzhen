package com.sudaotech.huolijuzhen.bill.web.admin.park;
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
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService.BillCcrAdj;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.Query;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService.RollPeriod;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.ContractBill;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.huolijuzhen.util.formula.FormulaParser;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/billCostCalRules")
public class BillCostCalRulesResource extends BaseResource {

    @Inject
    private BillCostCalRulesService billCostCalRulesService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private CostProService costProService;
    
    @Inject
    private BillCcrAdjService billCcrAdjService;
    
    @Inject
    private RollPeriodService rollPeriodService;
    
    @Inject
    private ContractBillService contractBillService;
    
    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private TaskService taskService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BillCostCalRules obj) {
    	
        //1.保存计算规则
        obj.setOperator(getSessionQuietly().getUserId());
        Long id = billCostCalRulesService.create(obj);
        
        //2.保存调整项信息
        List<BillCcrAdj> billCcrAdjs = obj.getBillCcrAdjs();
        if(CollectionUtils.isNotEmpty(billCcrAdjs)){
        	for(BillCcrAdj item:billCcrAdjs){
        		item.setBccrId(id);
        		
        		billCcrAdjService.create(item);
        	}
        }
        
        //3.保存滚动列表
        List<RollPeriod> rollPeriods = obj.getRollPeriods();
        if(CollectionUtils.isNotEmpty(rollPeriods)){
        	for(RollPeriod rollPeriod:rollPeriods){
        		rollPeriod.setOperator(getSessionQuietly().getUserId());
        		rollPeriod.setBillCostCalRulesId(id);
       			rollPeriodService.create(rollPeriod);
        	}
        }
        
        Map<String, Long> map = MapHelper.put("id", id).getMap();
        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/billCostCalRules/%s", id));
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
            @Valid BillCostCalRules obj) {
    	
    	//1.计算规则主信息
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        billCostCalRulesService.update(obj);
        
        //2.更新调整项
        List<BillCcrAdj> billCcrAdjs = obj.getBillCcrAdjs();
        if(CollectionUtils.isNotEmpty(billCcrAdjs)){
        	for(BillCcrAdj item:billCcrAdjs){
        		Long itemId = item.getId();
        		if(itemId == null){
            		item.setBccrId(id);
            		item.setOperator(getSessionQuietly().getUserId());
            		billCcrAdjService.create(item);
        		}else{
        			item.setUpdateBy(getSessionQuietly().getUserId());
        			billCcrAdjService.update(item);
        		}
        	}
        }
        
        //3.保存滚动列表
        List<RollPeriod> rollPeriods = obj.getRollPeriods();
        if(CollectionUtils.isNotEmpty(rollPeriods)){
        	for(RollPeriod rollPeriod:rollPeriods){
        		Long rollPeriodId = rollPeriod.getId();
        		rollPeriod.setBillCostCalRulesId(id);
        		if(rollPeriodId == null){
        			rollPeriod.setOperator(getSessionQuietly().getUserId());
        			rollPeriodService.create(rollPeriod);
        		}else{
        			rollPeriod.setUpdateBy(getSessionQuietly().getUserId());
        			rollPeriodService.update(rollPeriod);
        		}
        	}
        }
        
        return ResultSupport.ok();
    }
    
    /**
     * 计算规则生成预览
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/billCostCalRulesToPerview/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> billCostCalRulesToPerview(
            @PathParam("id") Long id,
    		@Valid final BillCostCalRules billCostCalRules) {
    	Map<String, Object> dataMap = new HashMap<String, Object>();

    	//1.计算规则是否存在
    	BillCostCalRules temp = billCostCalRulesService.getById(id);
    	if(temp == null){
    		return new Result<Map<String, Object>>(ResultCode.NOT_FOUND_ITEM);
    	}
    	
    	//2.获取该计算规则对应的所有的月份账单
    	if(temp.getContractId() != null){
	      ContractBill currentContractBill = new ContractBill();
	      currentContractBill.setContractId(temp.getContractId());
	      currentContractBill.setCostProId(temp.getCostProId());
	      List<ContractBill> contractBIlls = contractBillService.findAllPast(currentContractBill);
	      
	      //5.删除所有的月份账单
	      if(CollectionUtils.isNotEmpty(contractBIlls)){
	      	for(ContractBill item:contractBIlls){
	      		item.setOperator(getSessionQuietly().getUserId());
	      		item.setStatus(Status.DELETED);
	      		contractBillService.update(item);
	      	}
	      }
    	}

    	//预览集
    	List<ContractBill> previews = new ArrayList<ContractBill>();
    	List<Map<String,String>> previewList = createPreview(id);
    	if(CollectionUtils.isNotEmpty(previewList)){
        	ContractBill contractBill = null;
        	Long previewId = null;
        	for(Map<String, String> itemMap:previewList){
        		String month = itemMap.get("month");
        		String isBillMonth = itemMap.get("isBillMonth");
        		String billAmount = itemMap.get("billAmount");
        		BigDecimal billAmountBigDecimal = null;
        		if(StringUtils.isBlank(billAmount)){
        			billAmountBigDecimal = new BigDecimal("0");
        		}else{
        			billAmountBigDecimal = new BigDecimal(billAmount);
        		}
        		
        		contractBill = new ContractBill();
        		contractBill.setContractId(temp.getContractId());
        		contractBill.setCostProId(temp.getCostProId());
        		contractBill.setMonth(month);
        		contractBill.setBillAmount(billAmountBigDecimal);
        		contractBill.setIsBillMonth(Integer.parseInt(isBillMonth));
        		
        		previewId = contractBillService.create(contractBill);
        		contractBill.setId(previewId);
        		if(temp.getContractId() == null){
        			previews.add(contractBill);
        		}
        	}
        }
        dataMap.put("previews", previews);
        return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    }
    

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	try{
            BillCostCalRules obj = billCostCalRulesService.getById(id);
            if(obj == null){
            	return new Result<String>(ResultCode.NOT_FOUND_ITEM);
            }
            obj.setStatus(Status.DELETED);
            
            //删除计算规则对应的滚动列表
            BillCostCalRules billCostCalRules = new BillCostCalRules();
            billCostCalRules.setId(id);
            List<RollPeriod> rollPeriods = rollPeriodService.findByObj(billCostCalRules);
            if(CollectionUtils.isNotEmpty(rollPeriods)){
            	for(RollPeriod rollPeriod:rollPeriods){
            		rollPeriod.setStatus(Status.DELETED);
            		rollPeriodService.update(rollPeriod);
            	}
            }
            
            return update(id, obj);
    	}catch(Exception e){
    		logger.error("费用项目计算规则删除 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
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
    public Result<BillCostCalRules> get(@NotNull @PathParam("id") final Long id) {
        BillCostCalRules obj = billCostCalRulesService.getById(id);

        
        return new Result<BillCostCalRules>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillCostCalRules>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<BillCostCalRules> page = billCostCalRulesService.find(query);
        return new Result<Page<BillCostCalRules>>(ResultCode.OK, page);
    }
    
    /**
     * 通过合同Id和账单月 计算出账单明细
     * @param id
     * @return
     */
    @GET
    @Path("/new/billCostDetail/condition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<BillCostDetail>> newGetBillCostDetail(
            @QueryParam("contractId") Long contractId,
            @QueryParam("month") String month) {
    	
    	List<BillCostDetail> bcds=null;
    	
	    try {
	    		
	    	bcds=new ArrayList<BillCostDetail>();
	    	
	    	if(contractId == null || StringUtils.isBlank(month)){
	    		 return new Result<List<BillCostDetail>>(ResultCode.BAD_REQUEST);
	    	}
	    	
	    	Date argMonth=SystemUtil.getDateYYYYMM(month); 
	    	
	    	if(argMonth ==null){
	    		return new Result<List<BillCostDetail>>(ResultCode.BAD_REQUEST);
	    	}
	    	 //查询规则对应合同
	        ContractInfo ci = contractInfoService.getById(contractId);
	        
	    	if(ci == null){
	   		     return new Result<List<BillCostDetail>>(ResultCode.NOT_FOUND_CONTRACT);
	       	}
	    	if(ci.getStartDate() ==null){
	    		 return new Result<List<BillCostDetail>>(ResultCode.START_DATE_IS_REQUIRED);
	    	}
	    	if(ci.getEndDate() ==null){
	    		 return new Result<List<BillCostDetail>>(ResultCode.END_DATE_IS_REQUIRED);
	    	}
	    	
	    	//判断月份
	    	if(SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getStartDate(), "yyyy-MM")).getTime() > argMonth.getTime()){
	    		 return new Result<List<BillCostDetail>>(ResultCode.MONTH_NON_COMPLIANT);
	    	}
	    	if(SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getEndDate(), "yyyy-MM")).getTime() < argMonth.getTime()){
	   		     return new Result<List<BillCostDetail>>(ResultCode.MONTH_NON_COMPLIANT);
	   	    }
	    	
	    	BillCostCalRules bccr=new BillCostCalRules();
	    	bccr.setContractId(contractId);
	    	//查询费用计算规则
	    	List<BillCostCalRules> bccrList=billCostCalRulesService.findByObj(bccr);
	    	if(CollectionUtils.isEmpty(bccrList)){
	    		return new Result<List<BillCostDetail>>(ResultCode.OK,bcds);
	    	}
	    	
	    	 //通过计算公式获得 费用项目金额        	
	        Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
	        values.put("area", ci.getArea());
	        values.put("amount", ci.getTotalMoney());
	        
	    	BillCostDetail bcd=null;
	        for (BillCostCalRules obj : bccrList) {
	        	bcd = new BillCostDetail();
	        	//费用项目
	        	CostPro cp=costProService.getById(obj.getCostProId());
     	        
     	        ContractBill contractBill = new ContractBill();
	        	contractBill.setContractId(contractId);
	        	contractBill.setCostProId(obj.getCostProId());
	        	contractBill.setMonth(month);
	        	
	        	List<ContractBill> contractBills = contractBillService.findAllPast(contractBill);
	        	BigDecimal costMoney = new BigDecimal(0);
	        	if(CollectionUtils.isNotEmpty(contractBills)){
	        		contractBill = contractBills.get(0);
	        		BigDecimal currentCostMoney = contractBill.getBillAmount();
	        		if(currentCostMoney != null && currentCostMoney.compareTo(costMoney) == 1){
	        			costMoney = currentCostMoney;
	        		}
	        	}

	        	bcd=new BillCostDetail();
	    	    bcd.setBccrId(obj.getId());
	    	    bcd.setCostProName(cp.getName());
	    	    bcd.setChargeMode(cp.getChargeMode());

        		//税率
        		bcd.setTaxRate(cp.getCostRate()); 
        		//税额
        		BigDecimal taxMoneyBigDecimal = totalToTaxMoney(costMoney, cp.getCostRate());
        		bcd.setTaxMoney(taxMoneyBigDecimal);      
        		//项目金额
        		BigDecimal costBigDecimal = costMoney.subtract(taxMoneyBigDecimal);
        		bcd.setCost(costBigDecimal);        
        		//总金额
        		bcd.setTotalMoney(costMoney);   
        		logger.info("{}月份账单：{}",month,bcd.getTotalMoney());
        		bcds.add(bcd);
	        }
	        
	        //获取指定企业的维修申报任务
	        EnterpriseCorrContract enterpriseCorrContract = new EnterpriseCorrContract();
	        enterpriseCorrContract.setContractId(contractId);
	        List<EnterpriseCorrContract> eccs = enterpriseCorrContractService.findByObj(enterpriseCorrContract);
	        Long enterpriseId = null;
	        if(CollectionUtils.isNotEmpty(eccs)){
	        	Long enterpriseCottId = eccs.get(0).getEnterpriseCottId();
	        	
	        	EnterpriseCott enterpriseCott = enterpriseCottService.getById(enterpriseCottId);
	        	if(enterpriseCott != null){
	        		enterpriseId = enterpriseCott.getEnterpriseId();
	        	}
	        }
 
	        //获取维修申报月结金额
	        BigDecimal taskCostAmount = new BigDecimal(0);
	        List<Long> taskIds = new ArrayList<Long>();
	        if(enterpriseId != null){
		        Task task = new Task();
		        task.setTaskType(TaskType.COMPANYAPPLY);
		        task.setIsChoose(0);
		        task.setHasCost(true);
		        task.setPayWay(PayWay.MONTH);
		        task.setEquPlanId(enterpriseId);
		        task.setCostIsVerify(true);
		        
		        List<Task> tasks = taskService.findByObj(task);
		        if(CollectionUtils.isNotEmpty(tasks)){
		        	BigDecimal taskCost = null;
		        	for(Task item:tasks){
		        		//获取任务ID
		        		taskIds.add(item.getId());
		        		//获取月结任务金额
		        		taskCost = item.getTaskCost();
		        		if(new BigDecimal(0).compareTo(taskCost) == -1){
			        		taskCostAmount = taskCostAmount.add(taskCost);
		        		}
		        	}
		        }
	        }

	        //当企业维修申报类型总额大于零时
	        if(new BigDecimal(0).compareTo(taskCostAmount) == -1){
	        	
	        	BillCostDetail taskCostPro = new BillCostDetail();
	        	taskCostPro.setCostProName("维修费");
	        	taskCostPro.setIsTask(1);

        		//税率
	        	taskCostPro.setTaxRate(new BigDecimal(0.06)); 
        		//税额
        		BigDecimal taxMoneyBigDecimal = totalToTaxMoney(taskCostAmount, new BigDecimal(0.06));
        		taskCostPro.setTaxMoney(taxMoneyBigDecimal);      
        		//项目金额
        		BigDecimal costBigDecimal = taskCostAmount.subtract(taxMoneyBigDecimal);
        		taskCostPro.setCost(costBigDecimal);        
        		//总金额
        		taskCostPro.setTotalMoney(taskCostAmount); 
	        	
        		taskCostPro.setTaskIds(taskIds);
        		bcds.add(taskCostPro);
	        }
		} catch (Exception e) {
			logger.error("获取合同费用项目异常：{}",e);
			return new Result<List<BillCostDetail>>(ResultCode.OK,null);
		}
    	return new Result<List<BillCostDetail>>(ResultCode.OK,bcds);
    	
    }
    
    /**
     * 税后算出税额
     * @param costMoney
     * @param taxRate
     * @return
     */
    private BigDecimal totalToTaxMoney(BigDecimal costMoney,BigDecimal taxRate){
    	BigDecimal newTaxRate = taxRate.add(new BigDecimal(1));
    	costMoney = costMoney.divide(newTaxRate,4,BigDecimal.ROUND_HALF_UP);
    	return costMoney.multiply(taxRate);
    }
    
    /**
     * 预览()
     * @param id
     * @return
     */
    @GET
    @Path("/new/preview/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String,Object>>> newPreview(@NotNull @PathParam("id") final Long id) {
    	
        //规则详情
        BillCostCalRules obj = billCostCalRulesService.getById(id);
        
        if(obj == null ){
        	 return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
        }
        if(obj.getContractId() == null){
        	 return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND_CONTRACT);
        }
        //查询规则对应合同
        ContractInfo ci = contractInfoService.getById(obj.getContractId());
        
        if(ci == null){
        	 return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
        }
        if(ci.getStartDate() == null ){
        	 return new Result<List<Map<String,Object>>>(ResultCode.START_DATE_IS_REQUIRED);
        }
        if(ci.getEndDate() == null ){
        	 return new Result<List<Map<String,Object>>>(ResultCode.END_DATE_IS_REQUIRED);
        }
        
        ContractBill contractBill = new ContractBill();
        contractBill.setContractId(obj.getContractId());
        contractBill.setCostProId(obj.getCostProId());
        List<ContractBill> contractBills = contractBillService.findAllPast(contractBill);

        //预览账单列表
        List<Map<String,Object>> previewList = new ArrayList<Map<String,Object>>();;
        if(CollectionUtils.isNotEmpty(contractBills)){
        	Map<String, Object> itemMap = null;
        	for(ContractBill item:contractBills){
        		itemMap = new HashMap<String, Object>();
        		
        		itemMap.put("id", item.getId());
        		itemMap.put("contractId", obj.getContractId());
        		itemMap.put("costProId", obj.getCostProId());
        		itemMap.put("month", item.getMonth());
        		itemMap.put("billAmount", item.getBillAmount());
        		
        		previewList.add(itemMap);
        	}
        }
    	       
    	return new Result<List<Map<String,Object>>>(ResultCode.OK,previewList);
    }
    
//    @GET
//    @Path("/new/preview/{id}")
//    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
//    public Result<List<Map<String,String>>> newPreview(@NotNull @PathParam("id") final Long id) {
//    	
//        //规则详情
//        BillCostCalRules obj = billCostCalRulesService.getById(id);
//        
//        if(obj == null ){
//        	 return new Result<List<Map<String,String>>>(ResultCode.NOT_FOUND);
//        }
//        if(obj.getContractId() == null){
//        	 return new Result<List<Map<String,String>>>(ResultCode.NOT_FOUND_CONTRACT);
//        }
//        //查询规则对应合同
//        ContractInfo ci = contractInfoService.getById(obj.getContractId());
//        
//        if(ci == null){
//        	 return new Result<List<Map<String,String>>>(ResultCode.NOT_FOUND);
//        }
//        if(ci.getStartDate() == null ){
//        	 return new Result<List<Map<String,String>>>(ResultCode.START_DATE_IS_REQUIRED);
//        }
//        if(ci.getEndDate() == null ){
//        	 return new Result<List<Map<String,String>>>(ResultCode.END_DATE_IS_REQUIRED);
//        }
//    
//        //预览账单列表
//        List<Map<String,String>> previewList = new ArrayList<Map<String,String>>();;
//    	//获取时间段的月份
//    	List<String> months=SystemUtil.getMonthsBetweenTimes(ci.getStartDate(), ci.getEndDate());
//    	//获取调整月份金额
//    	Map<String, Object> billCcrAdjMap = billCcrAdjService.findByBccrIdAndMonth(id, months);
//    	//获取账单月份
//    	List<String> billMonths = SystemUtil.getBillMonthsBetweenTimes(ci, obj);
//    	//滚动月份、幅度
//    	Map<String,BigDecimal> rollRangeMap = convertorContractToRange(obj, ci);
//      
//		//计算方式不能为空
//		ComputeMode computeMode = obj.getComputeMode();
//		if(!ComputeMode.FIXED_AMOUNT.equals(computeMode) && !ComputeMode.CUSTOME_CAL.equals(computeMode)){
//			return new Result<List<Map<String,String>>>(ResultCode.OK,previewList);
//		}
//		
//		Map<String, String> monthRecord =null;
//		//费用预收月数(预收月数大于等于 1)
//		Integer advanceMonth = obj.getAdvanceMonth();
//		if(advanceMonth == null || advanceMonth == 0){
//			advanceMonth = 1;
//		}
//    	for (int i = 0; i < months.size(); i++) {
//    		monthRecord=new HashMap<String, String>();
//    		String month=months.get(i);
//    		//非账单月份
// 			if(!billMonths.contains(month)){
// 				monthRecord.put("month", month);
// 				monthRecord.put("billAmount", "");
// 				
// 				previewList.add(monthRecord);
// 				continue;
// 			}
//    		
//    		//免收月数处理
// 			Integer freeMonth = obj.getFreeMonth();
// 			if(freeMonth == null || freeMonth < 1){
// 				freeMonth = 0;
// 			}
//     		if(i < freeMonth-1){
//     			monthRecord.put("month",month);
//     			if(i > 0){
//         			monthRecord.put("billAmount","");
//     				continue;
//     			}
//     			//获取对应的调整项（有可能为空）
//     			BigDecimal temp = new BigDecimal(0);
// 				for(int z=0;z<freeMonth;z++){
// 					String tempMonth = months.get(z);
// 					Object adjAmount = billCcrAdjMap.get(tempMonth);
// 					if(adjAmount != null){
// 						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
// 						temp=new BigDecimal(Arith.add(adjAmountBigDecimal, temp));
// 					}		
//     			}
// 				monthRecord.put("billAmount",temp.toString());
//     		}
//     		//固定金额
//     		else if(ComputeMode.FIXED_AMOUNT.equals(obj.getComputeMode())){
//     			
//     			//账单月份
//     			BigDecimal currentAmount=new BigDecimal("0");
//				BigDecimal amount=obj.getFixedAmount();
//				for (int j = i + 1; j < obj.getAdvanceMonth() + i + 1 && j< months.size(); j++) {
//					//获取对应的调整项（有可能为空）
// 					String currentMonth = months.get(j);
// 					Object adjAmount = billCcrAdjMap.get(currentMonth);
// 					if(adjAmount != null){
// 						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
// 						currentAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, amount));
// 					}else{
// 						currentAmount=new BigDecimal(Arith.add(currentAmount, amount));
// 					}
//			     }
//            	monthRecord.put("month",month);
// 				monthRecord.put("billAmount",currentAmount.toString());	
//         	}
//    		//自定义计算
//     		else if(ComputeMode.CUSTOME_CAL.equals(obj.getComputeMode())){
//     			
//     			//通过计算公式获得指定月份费用项目金额        	
//                Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
//                values.put("area", ci.getArea());
//                values.put("amount", ci.getTotalMoney());
//                
//                BigDecimal billAmount = new BigDecimal(0);
//                BigDecimal billInitAmount = new BigDecimal(0);
//    			 //启用滚动计算的
//    			if(obj.getIsRollingCal() == 1){
//					//10000*(1+m)^n
//					//计算下n个月份的
//					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
//						String currentMonth = months.get(j);
//						//項目金额
//						values.put("days", new BigDecimal(SystemUtil.getDaysByMonth(currentMonth)));
//		                billInitAmount = FormulaParser.parse(obj.getFormula(), values);
//						
//		                //当前月份的幅度
//						BigDecimal currentRange = rollRangeMap.get(currentMonth);
//						Double Idempotent = currentRange.doubleValue();
//						//项目金额 * 当前月份的滚动幅度
//						BigDecimal currentBill=new BigDecimal(Arith.mul(billInitAmount.doubleValue(),Idempotent));
//						//金额取小数点后两位
//						currentBill = currentBill.setScale(2, BigDecimal.ROUND_HALF_UP);
//						billAmount=new BigDecimal(Arith.add(billAmount.doubleValue(), currentBill.doubleValue()));
//					}
//					//添加调整项
//					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
//						//获取对应的调整项（有可能为空）
//     					String currentMonth = months.get(j);
//     					Object adjAmount = billCcrAdjMap.get(currentMonth);
//     					if(adjAmount != null){
//     						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
//     						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
//     					}
//					}
//					monthRecord.put("month",month);
//                	monthRecord.put("billAmount",Arith.round(billAmount.toString(),2));
//    		   }
//    			//未启用滚动计算
//    			else{
//					//添加调整项
//					for (int j = i + 1; j < i+obj.getAdvanceMonth() + 1 && j< months.size(); j++) {
//						//获取对应的调整项（有可能为空）
//     					String currentMonth = months.get(j);
//     					
//     					//項目金額
//						values.put("days", new BigDecimal(SystemUtil.getDaysByMonth(currentMonth)));
//		                billInitAmount = FormulaParser.parse(obj.getFormula(), values);
//		                billAmount = billAmount.add(billInitAmount);
//     					
//     					Object adjAmount = billCcrAdjMap.get(currentMonth);
//     					if(adjAmount != null){
//     						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
//     						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
//     					}
//					}
//					monthRecord.put("month",month);
//					monthRecord.put("billAmount",Arith.round(billAmount,2));
//    			}
//    	   }
//     		logger.info("{}月份账单：{}",monthRecord.get("month"),monthRecord.get("billAmount"));
//     		previewList.add(monthRecord);
//    	}        
//    	return new Result<List<Map<String,String>>>(ResultCode.OK,previewList);
//    }
    
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
//	        if(obj.getContractId() == null){
//	        	 return null;
//	        }
//	        
	        
	        //查询规则对应合同
//	        ContractInfo ci = contractInfoService.getById(obj.getContractId());
	        ContractInfo ci = new ContractInfo();
	        ci.setStartDate(obj.getStartDate());
	        ci.setEndDate(obj.getEndDate());
	        ci.setArea(new BigDecimal(0));
	        ci.setTotalMoney(new BigDecimal(0));

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
	 				//非账单月
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
