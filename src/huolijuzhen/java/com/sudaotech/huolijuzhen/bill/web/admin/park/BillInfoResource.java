package com.sudaotech.huolijuzhen.bill.web.admin.park;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.template.TemplateConfig;
import com.sudaotech.core.template.TemplateKey;
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
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService.SystemConfig;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService.BillChangeLogs;
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordService;
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordService.BillCollectionRecord;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BatchBill;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BillInfo;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.Query;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService.BillPayVoucher;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService;
import com.sudaotech.huolijuzhen.bill.service.CostProSettingService.CostProSetting;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService.RollPeriod;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.commons.constant.notice.NoticeConstants;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.ContractBill;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillOperType;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.huolijuzhen.util.formula.FormulaParser;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import com.sudaotech.message.SourceType;
import com.sudaotech.sms.service.Sms;
import com.sudaotech.sms.service.SmsService;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/billInfo")
public class BillInfoResource extends BaseResource {

    @Inject
    private BillInfoService billInfoService;
    
    @Inject
    private GenCodeService genCodeService;
    
    @Inject
    private BillCostDetailService  billCostDetailService;
    
    @Inject
    private BillChangeLogsService billChangeLogsService;
    
    @Inject
    private BillPayVoucherService billPayVoucherService;
    
    @Inject
    private BillCollectionRecordService billCollectionRecordService;
    
    @Inject
    private SystemConfigService systemConfigService;
    
    @Inject
    private MessageService messageService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private NoticeEnterpriseService noticeService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private BillCostCalRulesService billCostCalRulesService;
    
    @Inject
    private CostProService costProService;
    
    @Inject
    private BillCcrAdjService billCcrAdjService;
    
    @Inject
    private CostProSettingService costProSettingService;
    
    @Inject
    private RollPeriodService rollPeriodService;
    
    @Inject
    private ContractBillService contractBillService;
    
    @Inject
    private TaskService taskService;
    
    @Inject
    private SmsService smsService;
    
    @Inject
    private ApprovalTypeService approvalTypeService;
    
    @Inject
    private ApprovalProcessService approvalProcessService;
    
    @Inject
    private ApprovalTypeItemService approvalTypeItemService;
    
    @Inject
    private ApprovalRecordService approvalRecordService;
    
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BillInfo obj) {
        // create
    	
    	Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    	}
        if(obj.getCompanyId() == null || obj.getContractId() == null || StringUtils.isBlank(obj.getBillMonth())){
        	return  new  Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        }
        if(CollectionUtils.isEmpty(obj.getBcds())){
        	return new  Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
        }
        if(obj.getSubmitStatus() == null || obj.getSubmitStatus() == BillSubmitStatus.WAIT_SUBMIT){
        	obj.setSubmitStatus(BillSubmitStatus.WAIT_SUBMIT);
        	  //主状态为提交
        	obj.setBillStatus(BillStatus.SUBMIT);
        }
        if(obj.getSubmitStatus() == BillSubmitStatus.ALREADY_SUBMIT){
        	//主状态为审核，审核状态为待审核
        	obj.setBillStatus(BillStatus.APPROVAL);
        	obj.setApprovalStatus(BillApprovalStatus.PENDING_APPROVAL);
        }
        //校验是否已生成账单
        BillInfo bi = billInfoService.findBillByContractAndMonth(obj.getContractId(), obj.getBillMonth());
       
        if(bi != null){
        	return new  Result<Map<String, Long>>(ResultCode.BILL_ALREADY_EXISTS);
        } 
    	
        obj.setParkId(session.getPlatformId());
        obj.setOperator(session.getUserId());
        
        //查询
        Long billId = billInfoService.create(obj);
        
        //关联费用详情
        for (BillCostDetail bcd : obj.getBcds()) {
        	
        	//费用项目
    		bcd.setBillId(billId);
        	bcd.setOperator(session.getUserId());
        	billCostDetailService.create(bcd);
        	
        	if(bcd.getIsTask() != null && bcd.getIsTask() == 1){
        		//维修费用
        		List<Long> taskIds = bcd.getTaskIds();
        		if(CollectionUtils.isEmpty(taskIds)){
        			continue;
        		}
    			Task temp = null;
    			for(Long itemId:taskIds){
    				temp = new Task();
    				
    				temp.setId(itemId);
    				temp.setBillId(billId);
    				temp.setIsChoose(1);
    				temp.setOperator(getSessionQuietly().getUserId());
    				
    				taskService.update(temp);
    			}
        	}
    		
		} 
     	//插入操作日志（创建）
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(billId);
        bcl.setOperator(session.getUserId());       
        
        bcl.setOperType(BillOperType.CREATE);
        bcl.setOperExplain(BillOperType.CREATE.text());
        billChangeLogsService.create(bcl);
        
        if(obj.getSubmitStatus() !=null && obj.getSubmitStatus() == BillSubmitStatus.ALREADY_SUBMIT){
	        //插入操作日志（提交）
	        bcl.setOperType(BillOperType.SUBMIT);
	        bcl.setOperExplain(BillOperType.SUBMIT.text());
	        billChangeLogsService.create(bcl);
        }
        
        Map<String, Long> map = MapHelper.put("id", billId).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/billInfo/%s", billId));
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
            @Valid final BillInfo obj) {
    	Session session = getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL) ; 
    	}
        if(obj.getSubmitStatus() == null || obj.getSubmitStatus() == BillSubmitStatus.WAIT_SUBMIT){
        	obj.setSubmitStatus(BillSubmitStatus.WAIT_SUBMIT);
        	  //主状态为提交
        	obj.setBillStatus(BillStatus.SUBMIT);
        }
        if(obj.getSubmitStatus() == BillSubmitStatus.ALREADY_SUBMIT){
        	//主状态为审核，审核状态为待审核
        	obj.setBillStatus(BillStatus.APPROVAL);
        	obj.setApprovalStatus(BillApprovalStatus.PENDING_APPROVAL);
        }
        
        obj.setId(id);
        obj.setOperator(session.getUserId());
        billInfoService.update(obj);
        
        //关联费用详情
        BillCostDetail billCostDetail = new BillCostDetail();
        billCostDetail.setBillId(id);
        List<BillCostDetail> billCostDetails = obj.getBcds();
        if(CollectionUtils.isNotEmpty(billCostDetails)){
            for (BillCostDetail bcd : billCostDetails) {
            	
              	bcd.setOperator(session.getUserId());
            	if(bcd.getId() == null){
            	   bcd.setBillId(id);
            	   billCostDetailService.create(bcd);
            	}
            	else{
            	   billCostDetailService.update(bcd);	
            	}
    		} 
        }
        
     	//插入操作日志（创建）
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(id);
        bcl.setOperator(session.getUserId());       
        bcl.setOperType(BillOperType.UPDATE);
        bcl.setOperExplain(BillOperType.UPDATE.text());
        billChangeLogsService.create(bcl);
        
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {

    	if(id == null){
    		return new Result<String>(ResultCode.ITEM_ID_IS_NULL);
    	}
    	BillInfo temp = billInfoService.getById(id);
    	if(temp == null){
    		return new Result<String>(ResultCode.NOT_FOUND_ITEM);
    	}
    	
    	//删除对应的费用项目详情
    	BillCostDetail billCostDetail = new BillCostDetail();
        billCostDetail.setBillId(id);
        List<BillCostDetail> billCostDetails = billCostDetailService.findByObj(billCostDetail);
        if(CollectionUtils.isNotEmpty(billCostDetails)){
        	for(BillCostDetail item:billCostDetails){
        		item.setStatus(Status.DELETED);
        		item.setOperator(getSessionQuietly().getUserId());
        		
        		billCostDetailService.update(item);
        	}
        }
    	
        //删除对应的维修费用
    	Task task = new Task();
    	task.setBillId(id);
    	List<Task> tasks = taskService.findByObj(task);
    	if(CollectionUtils.isNotEmpty(tasks)){
    		for(Task item:tasks){
    			item.setIsChoose(0);
    			item.setBillId(null);
    			item.setOperator(getSessionQuietly().getUserId());
    			
    			taskService.update(item);
    		}
    	}
    	
        BillInfo obj = new BillInfo();
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
    public Result<BillInfo> get(@NotNull @PathParam("id") final Long id) {
        BillInfo obj = billInfoService.getById(id);
        
        return new Result<BillInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    /**
     * 查询 下期调整的
     * @param contractId
     * @param billMonth
     * @return
     */
    @GET
    @Path("/adjustment")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> adjustment(@QueryParam("contractId") Long contractId,
    		                                     @QueryParam("billMonth") String billMonth) {
    	
    	if(contractId == null || billMonth == null){
    	   return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
    	
    	//下一月份
    	String prevMonth=SystemUtil.getDateBySubMonth(SystemUtil.getDateYYYYMM(billMonth),1);
    	
        //校验是否已生成账单
        BillInfo bi = billInfoService.findBillByContractAndMonth(contractId, prevMonth);
        
        //下期调整的
        if(bi != null && bi.getNextAdjust() ==1){
        	Map<String, Object> map=new HashMap<String, Object>();
        	
        	map.put("adjustAmount", bi.getAdjustAmount());
        	map.put("adjustRemark", bi.getAdjustRemark());
        	
        	return new Result<Map<String,Object>>(ResultCode.OK,map);
        }
        
        return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
    }
    

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("billStatus") BillStatus billStatus,
            @QueryParam("submitStatus") BillSubmitStatus  submitStatus,
            @QueryParam("approvalStatus") BillApprovalStatus approvalStatus,
            @QueryParam("pushStatus") BillPushStatus pushStatus,
            @QueryParam("confirmStatus")   BillConfirmStatus confirmStatus,
            @QueryParam("verificatioinStatus") BillVerificationStatus verificatioinStatus
            ) {
    	
	    	try {
	    	
		        Session session=getSessionQuietly();
		    	
		    	if(session.getUserId() == null || session.getUserId() == 0){
		    		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
		    	}
		    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
		    		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
		    	}
		    		
				Query query = new Query();
				query.setOffset(offset);
				query.setLimit(limit);
				query.setPage(pageNum);
				query.setBillNo(billNo);
		        query.setCompanyName(companyName);
		        query.setBillMonth(billMonth);
		        query.setParkId(session.getPlatformId());
		        query.setBillStatus(billStatus);
		        
		        if(billStatus == BillStatus.SUBMIT){
		        	query.setSubmit(true);
		        	query.setSubmitStatus(submitStatus);
		        }
		        if(billStatus == BillStatus.APPROVAL){
		        	query.setApproval(true);
		        	query.setApprovalStatus(approvalStatus);
		        }
		        if(billStatus == BillStatus.PUSH){
		        	query.setPush(true);
		        	query.setPushStatus(pushStatus);
		        }
		        if(billStatus == BillStatus.PAYMENT){
		        	query.setConfirm(true);
		        	query.setConfirmStatus(confirmStatus);
		        }
		        if(billStatus == BillStatus.WRITTEN){
		        	query.setVerify(true);
		        	query.setVerificationStatus(verificatioinStatus);
		        }
		        if(billStatus == BillStatus.INVALID){
		        	//todo
		        }
				
				Page<BillInfo> page = billInfoService.find(query);
				
		        return new Result<Page<BillInfo>>(ResultCode.OK, page);
		
			} catch (Exception e) {
				logger.error("查询异常：{}",e);
				return new Result<Page<BillInfo>>(ResultCode.INTERNAL_SERVER_ERROR);
			}
		        		
    }

    @GET
    @Path("/excel")
    @Produces("application/vnd.ms-excel; charset=UTF-8")
    public Response excel(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("billStatus") BillStatus billStatus,
            @QueryParam("submitStatus") BillSubmitStatus  submitStatus,
            @QueryParam("approvalStatus") BillApprovalStatus approvalStatus,
            @QueryParam("pushStatus") BillPushStatus pushStatus,
            @QueryParam("confirmStatus")   BillConfirmStatus confirmStatus,
            @QueryParam("verificatioinStatus") BillVerificationStatus verificatioinStatus
            ) {
    		ResponseBuilder response = null;
	    	try {
		        Session session=getSessionQuietly();
		    	if(session.getUserId() == null || session.getUserId() == 0){
					response = Response.status(Response.Status.BAD_REQUEST);
					return response.build();
		    	}
		    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
					response = Response.status(Response.Status.BAD_REQUEST);
					return response.build();
		    	}
		    		
				Query query = new Query();
				query.setOffset(offset);
				query.setLimit(limit);
				query.setPage(pageNum);
				query.setBillNo(billNo);
		        query.setCompanyName(companyName);
		        query.setBillMonth(billMonth);
		        query.setParkId(session.getPlatformId());
		        query.setBillStatus(billStatus);
		        
		        if(billStatus == BillStatus.SUBMIT){
		        	query.setSubmit(true);
		        	query.setSubmitStatus(submitStatus);
		        }
		        if(billStatus == BillStatus.APPROVAL){
		        	query.setApproval(true);
		        	query.setApprovalStatus(approvalStatus);
		        }
		        if(billStatus == BillStatus.PUSH){
		        	query.setPush(true);
		        	query.setPushStatus(pushStatus);
		        }
		        if(billStatus == BillStatus.PAYMENT){
		        	query.setConfirm(true);
		        	query.setConfirmStatus(confirmStatus);
		        }
		        if(billStatus == BillStatus.WRITTEN){
		        	query.setVerify(true);
		        	query.setVerificationStatus(verificatioinStatus);
		        }
		        if(billStatus == BillStatus.INVALID){
		        	//todo
		        }
				
				//创建临时文件
				String filePath = createNewExcelFile();

				//将查询的临时数据插入到 Excel 文件中
				createExcel(query,filePath);
				
				File file = new File(filePath);
				if(!file.exists()){
					response = Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND);
					return response.build();
				}
				
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] arr = new byte[1024*1024]; 
				int len = 0;
	        	while((len = fis.read(arr)) != -1){
	        		bos.write(arr, 0, len);
	        	}
	        	fis.close();
	        	file.delete();
	        	
	        	response = Response.ok(bos.toByteArray());
	            response.header("Content-Disposition","attachment; filename=\"bill.xls\"");
	            
	            return response.build();
		
			} catch (Exception e) {
				logger.error("园区 Web按条件导出账单列表 error：{}",e);
				response = Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR);
				return response.build();
			}
    }

    
    /**
     * 描述：账单审核
     * @return
     */

    @GET
    @Path("/approval")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> findApprovalList(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("approvalStatus") BillApprovalStatus approvalStatus){
    	
    	    Session session=getSessionQuietly();
       	
	       	if(session.getUserId() == null || session.getUserId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
	       	}
	       	if(session.getPlatformId() == null || session.getPlatformId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
	       	}
	       		
	   		Query query = new Query();
	   		query.setApproval(true);
	   		query.setOffset(offset);
	   		query.setLimit(limit);
	   		query.setPage(pageNum);
	   		query.setBillNo(billNo);
	        query.setCompanyName(companyName);
	        query.setBillMonth(billMonth);
	        query.setParkId(session.getPlatformId());
	        query.setApprovalStatus(approvalStatus);
	   		
	   		Page<BillInfo> page = billInfoService.find(query);
	        return new Result<Page<BillInfo>>(ResultCode.OK, page);
    
    }
    /**
     * 描述：推送列表
     * @return
     */
    @GET
    @Path("/push")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> findpushList(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("pushStatus") BillPushStatus pushStatus){
    	    
    	    Session session=getSessionQuietly();
    	
	    	if(session.getUserId() == null || session.getUserId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
	       	}
	       	if(session.getPlatformId() == null || session.getPlatformId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
	       	}
	       		
	   		Query query = new Query();
	   		query.setPush(true);
	   		query.setOffset(offset);
	   		query.setLimit(limit);
	   		query.setPage(pageNum);
	   		query.setBillNo(billNo);
	        query.setCompanyName(companyName);
	        query.setBillMonth(billMonth);
	        query.setParkId(session.getPlatformId());
	        query.setPushStatus(pushStatus);
	   		
	   		Page<BillInfo> page = billInfoService.find(query);
	   		
	        return new Result<Page<BillInfo>>(ResultCode.OK, page);
    }
    /**
     * 描述：核销列表
     * @return
     */
    @GET
    @Path("/verify")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> findpushList(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("verificatioinStatus") BillVerificationStatus verificatioinStatus){
    	    
    	    Session session=getSessionQuietly();
    	
	    	if(session.getUserId() == null || session.getUserId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
	       	}
	       	if(session.getPlatformId() == null || session.getPlatformId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
	       	}
	       	
	    	Query query = new Query();
	   		query.setVerify(true);
	   		query.setOffset(offset);
	   		query.setLimit(limit);
	   		query.setPage(pageNum);
	   		query.setBillNo(billNo);
	        query.setCompanyName(companyName);
	        query.setBillMonth(billMonth);
	        query.setParkId(session.getPlatformId());
	        query.setVerificationStatus(verificatioinStatus);
	   		
	   		Page<BillInfo> page = billInfoService.find(query);
	   		
	        return new Result<Page<BillInfo>>(ResultCode.OK, page);
   
    }
    
    /**
     * 描述：催缴列表
     * 在系统中可配置，【按账单日X天后未缴款执行催缴】，在账单催缴功能中，可读取该参数，
     * 进行待催缴账单列表展示，向企业端推送消息进行催缴；且催缴信息可读取催缴信息模版的定义。
     * @return
     */
    @GET
    @Path("/urge")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> findpushList(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("billNo") String billNo,
            @QueryParam("companyName") String companyName,
            @QueryParam("billMonth") String billMonth,
            @QueryParam("urgePushStatus") BillUrgePushStatus urgePushStatus){
    	    
    	    Session session=getSessionQuietly();
    	
	    	if(session.getUserId() == null || session.getUserId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
	       	}
	       	if(session.getPlatformId() == null || session.getPlatformId() == 0){
	       		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
	       	}
	        //查询模板
	        List<SystemConfig> scList= systemConfigService.getByParkId(session.getPlatformId());
	        SystemConfig sc=null;
	        if(CollectionUtils.isNotEmpty(scList)){
	    	   sc=scList.get(0);
	        } 
	        //判断催缴功能是否启用
	        if(sc == null || sc.getUrgeTermSign() != EnableStatus.ENABLE){
	    	   return new Result<Page<BillInfo>>(ResultCode.URGE_NOT_ENABLED,new Page<BillInfo>());
	        }	
	       	
	   		Query query = new Query();
	   		query.setUrge(true);
	   		query.setOffset(offset);
	   		query.setLimit(limit);
	   		query.setPage(pageNum);
	   		
	   		BillInfo bi = new BillInfo();
	   		bi.setParkId(session.getPlatformId());
	   		bi.setBillNo(billNo);
	   		bi.setCompanyName(companyName);
	   		bi.setBillMonth(billMonth);
	   		bi.setBillStatus(BillStatus.PAYMENT);
	   		bi.setUrgePushStatus(urgePushStatus);
	        
	        Date validDate = SystemUtil.getSubDate(sc.getUrgeTermDays());
	        bi.setPushTime(validDate);
	   		
	   		Page<BillInfo> page = billInfoService.findUrgeByPage(query, bi);	  
	   		
	   		//封装创建人信息
	   		List<BillInfo> items = page.getItems();
	   		if(CollectionUtils.isNotEmpty(items)){
	   			Long createBy = null;
	   			AdminUser adminUser = null;
	   			for(BillInfo item:items){
	   				createBy = item.getCreateBy();
	   				if(createBy == null){
	   					item.setCreateUserName("");
	   					continue;
	   				}
	   				adminUser = adminUserService.getById(createBy);
	   				item.setCreateUserName(adminUser == null?"":StringUtils.isBlank(adminUser.getUsername())? "":adminUser.getUsername());
	   			}
	   		}
	        return new Result<Page<BillInfo>>(ResultCode.OK, page);
    }
    
    @GET
    @Path("/billNo/generate")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> getbillNoCode() {
    	
        String billNo = getGenBillNo();

        return new Result<String>(billNo == null ? ResultCode.NOT_FOUND : ResultCode.OK, billNo);
    }
    
    /**
     * 作废
     * @param id
     * @return
     */
    @PUT
    @Path("/invalid/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> invalid(
            @NotNull @PathParam("id") final Long id) {
        Long userId = getSessionQuietly().getUserId();

        //验证账单是否存在
        BillInfo bi=billInfoService.getById(id);
        if(bi == null){
        	return new Result<String>(ResultCode.NOT_FOUND);
        }
        //校验状态是否为待推送、待缴款确认的账单
        if(bi.getBillStatus()== BillStatus.INVALID || (bi.getPushStatus() != BillPushStatus.WAIT_PUSH && bi.getConfirmStatus() != BillConfirmStatus.WAIT_CONFIRM)){
        	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR,bi.getPushStatus().text());
        }
        
        //作废账单流程(审批流程、核销流程)
        cancleApproval(bi, ApprovalType.BILLAPPROVAL);
        cancleApproval(bi, ApprovalType.BILLVERIFY);
        
        BillInfo obj =new BillInfo();
        obj.setId(id);
        obj.setOperator(userId);
        obj.setBillStatus(BillStatus.INVALID);

        billInfoService.update(obj);
        
        //插入操作日志
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(bi.getId());
        bcl.setOperator(userId);       
        bcl.setOperExplain(BillOperType.INVALID.text());
        bcl.setOperType(BillOperType.INVALID);
        billChangeLogsService.create(bcl);
        return ResultSupport.ok();
    }
    /**
     * 提交
     * @param id
     * @return
     */
    @PUT
    @Path("/submit/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> submit(
            @NotNull @PathParam("id") final Long id
            ) {
    	
        Long userId = getSessionQuietly().getUserId();

        //验证账单是否存在
        BillInfo bi=billInfoService.getById(id);
        if(bi == null){
        	return new Result<String>(ResultCode.NOT_FOUND);
        }
        //校验状态为 待待提交状态的账单
        if(bi.getBillStatus() != BillStatus.SUBMIT ||bi.getSubmitStatus() != BillSubmitStatus.WAIT_SUBMIT){
        	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
        }
        
        //制定账单审批流程、账单核销流程
        processBillInfoApproval(bi, ApprovalType.BILLAPPROVAL);
        processBillInfoApproval(bi, ApprovalType.BILLVERIFY);
        
        
        bi.setSubmitBy(userId);
        bi.setSubmitTime(new Date());   
        //主状态为 审核，审核状态为待审核，提交状态为已提交
        bi.setSubmitStatus(BillSubmitStatus.ALREADY_SUBMIT);
        bi.setBillStatus(BillStatus.APPROVAL);
        bi.setApprovalStatus(BillApprovalStatus.PENDING_APPROVAL);
        
        billInfoService.update(bi);
        
        //插入操作日志
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(bi.getId());
        bcl.setOperator(userId);       
        bcl.setOperType(BillOperType.SUBMIT);
        bcl.setOperExplain(BillOperType.SUBMIT.text());
        
        billChangeLogsService.create(bcl);
        
        return ResultSupport.ok();
    }
    
    
    /**
     * 账单提交确定账单审批流程
     * @param contractInfo
     * @return
     */
    private BillInfo processBillInfoApproval(BillInfo billInfo,ApprovalType billType){
    	
    	//1.1  获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),billType);
    	
    	if(approvalType == null){
    		return billInfo;
    	}
    	
    	//1.2 获取流程节点
    	ApprovalTypeItemQuery approvalTypeItemQuery = new ApprovalTypeItemQuery();
    	approvalTypeItemQuery.setApprovalTypeId(approvalType.getId());
    	approvalTypeItemQuery.setCurrentVersion(approvalType.getLatestVersion());
    	List<ApprovalTypeItem> approvalTypeItemList = approvalTypeItemService.findByObjQuery(approvalTypeItemQuery);
    	
    	//1.3 写入合同流程
    	if(CollectionUtils.isEmpty(approvalTypeItemList)){
    		return billInfo;
    	}
	
		ApprovalProcess approvalProcess = null;
		Long approvalProcessId = null;
		for(int i=0;i<approvalTypeItemList.size();i++){
			ApprovalTypeItem item = approvalTypeItemList.get(i);
			
			approvalProcess = new ApprovalProcess();
			
			approvalProcess.setApprovalTypeId(approvalType.getId());
			approvalProcess.setApprovalTypeVersion(approvalType.getLatestVersion());

			approvalProcess.setApprovalType(billType);
			approvalProcess.setMainId(billInfo.getId());
			
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
			if(ApprovalType.BILLAPPROVAL == billType){
				billInfo.setApprovalProcessId(approvalProcessId);
				billInfo.setApprovalExecutorId(item.getApprovalId());
			}else if(ApprovalType.BILLVERIFY == billType){
				billInfo.setVerifyProcessId(approvalProcessId);
				billInfo.setVerifyExecutorId(item.getApprovalId());
			}
			
		}
    	return billInfo;
    }
    
    /**
     * 作废账单流程
     * @param contractInfo
     * @return
     */
    private int cancleApproval(BillInfo billInfo,ApprovalType billType){
    	
    	//获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),billType);
    	
    	ApprovalProcessQuery approvalProcessQuery = new ApprovalProcessQuery();
    	approvalProcessQuery.setApprovalTypeId(approvalType.getId());
    	approvalProcessQuery.setApprovalTypeVersion(approvalType.getLatestVersion());
    	approvalProcessQuery.setApprovalType(billType);
    	approvalProcessQuery.setMainId(billInfo.getId());
    	
    	return approvalProcessService.cancleByObjQuery(approvalProcessQuery);
    }


    
    /**
     * 审批
     * @param id
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final BillInfo obj
            ) {
    	
        Long userId = getSessionQuietly().getUserId();
        
        if(obj.getApprovalStatus() ==null){

           return new Result<String>(ResultCode.BAD_REQUEST);
        }
        
        //验证账单是否存在
        BillInfo bi=billInfoService.getById(id);
        if(bi == null){
           return new Result<String>(ResultCode.NOT_FOUND);
        }
        //校验状态为 待审核、审核不通过状态的账单
        if(bi.getBillStatus() != BillStatus.APPROVAL || (bi.getApprovalStatus() != BillApprovalStatus.PENDING_APPROVAL &&
        		obj.getApprovalStatus() != BillApprovalStatus.APPROVAL_FAIL)){
           return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
        }
        
      	//1.1  获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalType = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),ApprovalType.CONTRACTAPPROVAL);
 
    	if(EnableStatus.DISABLE == approvalType.getEnableStatus()){//不启用审核流程
            //审核通过
            if(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_PASS){
            	//审批通过，则主状态变更为推送，推送状态变为待推送状态
            	obj.setBillStatus(BillStatus.PUSH);    
            	obj.setPushStatus(BillPushStatus.WAIT_PUSH);    
            	
            	//再次验证前端页面 计算金额是否正确
            	if(bi.getReliefMoney() !=null){
            		String totalAmount=Arith.add(obj.getTotalAmount(),obj.getReliefMoney());
            		if(bi.getTotalAmount().compareTo(new BigDecimal(totalAmount)) !=0){
            			 return new Result<String>(ResultCode.AMOUNT_CAL_ERR);
            		}
            		
            	}
            	
            }
            //审核不通过
            if(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_FAIL){
            	//审批通过，则主状态变更为推送，提交状态变为待提交状态
            	obj.setBillStatus(BillStatus.SUBMIT);    
            	obj.setSubmitStatus(BillSubmitStatus.WAIT_SUBMIT);    
            	//不可减免
            	obj.setReliefMoney(null);
            	obj.setReliefRemark(null);
            	obj.setTotalAmount(null);
            }
            
            obj.setId(id);
            obj.setApprovalBy(userId);
            obj.setApprovalTime(new Date());
            
            billInfoService.update(obj);
    	}else{//启用审核流程
 
    		
       		//启用流程
    		//1.判断当前用户是否有权限审批(无权限审批给予提示)
    		BillInfo billInfo = billInfoService.getById(id);
    		Long approvalProcessId = billInfo.getApprovalProcessId();
    		ApprovalProcess approvalProcess = approvalProcessService.getById(approvalProcessId);
    		if(getSession().getUserId() != billInfo.getApprovalExecutorId() || approvalProcess.getIsHistory()){
    			return new Result<String>(ResultCode.BILL_APPROVAL_ERROR);
    		}

    		//2.写入审批记录
    		ApprovalRecord approvalRecord = BeanUtils.copyProperties(approvalProcess, ApprovalRecord.class);
    		ApprovalTypeItem approvalTypeItem = approvalTypeItemService.getById(approvalProcess.getApprovalItemId());
    		approvalRecord.setApprovalItemName(approvalTypeItem == null ? "":StringUtils.isBlank(approvalTypeItem.getName()) ? "":approvalTypeItem.getName());
    		AdminUser adminUser = adminUserService.getById(approvalProcess.getApprovalId());
    		approvalRecord.setApprovalName(adminUser == null?"":StringUtils.isBlank(adminUser.getUsername())?"":adminUser.getUsername());
    		approvalRecord.setPassStatus(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_PASS);
    		approvalRecord.setOperator(getSession().getUserId());
    		
    		approvalRecordService.create(approvalRecord);
    		
    		
			//3.更新当前节点状态
			approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.APPROVALED);
			approvalProcess.setOperator(getSession().getUserId());
			approvalProcessService.update(approvalProcess);
			
	   		//4.审批合同（通过查下一审批人，未通过相当于退回）
    		if(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_PASS){//通过
    			
    			//获取下一节点
    			ApprovalProcess itemNode = approvalProcessService.findNextNodeByObj(approvalProcess);
    			if(itemNode == null){
                	//审批通过，则主状态变更为推送，推送状态变为待推送状态
                	obj.setBillStatus(BillStatus.PUSH);    
                	obj.setPushStatus(BillPushStatus.WAIT_PUSH);    
                	
                	//再次验证前端页面 计算金额是否正确
                	if(bi.getReliefMoney() !=null){
                		String totalAmount=Arith.add(obj.getTotalAmount(),obj.getReliefMoney());
                		if(bi.getTotalAmount().compareTo(new BigDecimal(totalAmount)) !=0){
                			 return new Result<String>(ResultCode.AMOUNT_CAL_ERR);
                		}
                		
                	}
    			}else{
        			
        			//维护流程节点状态
        			itemNode.setApprovalProcessStatus(ApprovalProcessStatus.ONAPPROVAL);
        			itemNode.setOperator(getSession().getUserId());
        			approvalProcessService.update(approvalProcess);
        			
        			//更新合同下一处理人
        			billInfo.setApprovalProcessId(approvalProcessId);
        			billInfo.setApprovalExecutorId(itemNode.getApprovalId());
        			billInfo.setOperator(getSession().getUserId());

        			billInfoService.update(billInfo);
    			}
    			
    		}else{//不通过

               	//审批通过，则主状态变更为提交，提交状态变为待提交状态
            	obj.setBillStatus(BillStatus.SUBMIT);    
            	obj.setSubmitStatus(BillSubmitStatus.WAIT_SUBMIT);    
            	//不可减免
            	obj.setReliefMoney(null);
            	obj.setReliefRemark(null);
            	obj.setTotalAmount(null);
 
    		}
    	}
        
        
        
        obj.setId(id);
        obj.setApprovalBy(userId);
        obj.setApprovalTime(new Date());
        
        billInfoService.update(obj);
        
        //插入操作日志
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(bi.getId());
        bcl.setOperator(userId);       
        if(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_PASS ){
    	    bcl.setOperExplain(BillOperType.APPROVAL_PASS.text());
            bcl.setOperType(BillOperType.APPROVAL_PASS);
        }
        if(obj.getApprovalStatus() == BillApprovalStatus.APPROVAL_FAIL){
      	    bcl.setOperExplain(BillOperType.APPROVAL_FAIL.text());
            bcl.setOperType(BillOperType.APPROVAL_FAIL);
        }
      
        billChangeLogsService.create(bcl);
        
        return ResultSupport.ok();
    }
    
    /**
     * 推送
     * @param id
     * @return
     */
    @PUT
    @Path("/push/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> push(
            @NotNull @PathParam("id") final Long id
            ) {
    	
        Long userId = getSessionQuietly().getUserId();

        //验证账单是否存在
        BillInfo bi=billInfoService.getById(id);
        if(bi == null){
        	return new Result<String>(ResultCode.NOT_FOUND);
        }
        //校验状态为 审核通过状态的账单
        if(bi.getBillStatus() != BillStatus.PUSH || bi.getApprovalStatus() != BillApprovalStatus.APPROVAL_PASS){
        	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
        }
        //推送则账单主状态变更为缴款确认，用户缴款确认状态变为待待确认状态,推送状态变为已推送
        bi.setBillStatus(BillStatus.PAYMENT);    
        bi.setConfirmStatus(BillConfirmStatus.WAIT_CONFIRM);
        bi.setPushStatus(BillPushStatus.ALREADY_PUSH);
        bi.setPushBy(userId);
        bi.setPushTime(new Date());
        billInfoService.update(bi);
        
        //发送信息给账单企业管理员
        List<AdminUser> admins = new ArrayList<AdminUserService.AdminUser>();
        if(bi.getCompanyId() != null)
        	admins = adminUserService.getAdminByEnterpriseId(bi.getCompanyId());
        
        //发送消息
        if(CollectionUtils.isNotEmpty(admins)){
            for(AdminUser admin:admins){
                Sms sms = new Sms();
                sms.setPhoneNum(admin.getCellphone());
                String content = TemplateConfig.format(TemplateKey.PARK_BILL_PUSH, bi.getBillNo());
                sms.setContent(content);
            	smsService.sendSms(sms, getSession());
            }
        }

        //执行消息推送
	    Message message = new Message();
        message.setContent(NoticeConstants.Enterprise.Bill.RECEIVED);
        message.setBizId(bi.getId());
        message.setMsgType(MsgType.ENTERPRISE_ORDER);
        message.setMsgBizType(MsgBizType.BILL);
        message.setSourceType(SourceType.SYSTEM_MESSAGE);
        message.setSrc(userId);    
        message.setMsgStatus(MsgStatus.CREATE);
        message.setOperator(userId);
        message.setParkId(getSessionQuietly().getPlatformId());
       
        //发送给企业下所有用户
        List<Long> adminUsers=adminUserService.findAllEnterpriseUserIdByEnterpriseIds(Arrays.asList(new Long[]{bi.getCompanyId()}));
       
        for (Long uid : adminUsers) {
        	//插入到消息
    	    message.setDst(uid);
    	    messageService.save(message);
    	    
    	    //推送到手机app
    	    noticeService.sendNoicMessage(uid.toString(), message.getContent());
    	    
	    }
        
        //插入操作日志
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(bi.getId());
        bcl.setOperator(userId);     
        bcl.setOperType(BillOperType.PUSHED);
        bcl.setOperExplain(BillOperType.PUSHED.text());

      
        billChangeLogsService.create(bcl);
        
        return ResultSupport.ok();
    }
    
    @GET
    @Path("/detail/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<BillInfo> getDetail(@NotNull @PathParam("id") final Long id) {
        
    	 BillInfo obj = billInfoService.getById(id);
    	 
    	 if(obj == null){
    		 return new Result<BillInfoService.BillInfo>(ResultCode.NOT_FOUND);
    	 }
    	 
         //查询账单明细
    	 BillCostDetail bcd =new BillCostDetail();
    	 bcd.setBillId(obj.getId());
    	 obj.setBcds(billCostDetailService.findByObj(bcd));

    	 //订单打印页面地址
    	 obj.setPrintUrl(PLATFORM_URL_H5 + "/static/callNotice.html?parkId=" + getSessionQuietly().getPlatformId() + "&billId=" + id);
    	 
        return new Result<BillInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    /**
     * 描述：核销账单详情
     * @param id
     * @return
     */
    @GET
    @Path("/verify/detail/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<BillInfo> getVerifyDetail(@NotNull @PathParam("id") final Long id) {
        
    	 BillInfo obj = billInfoService.getById(id);
    	 
    	 if(obj == null){
    		 return new Result<BillInfoService.BillInfo>(ResultCode.NOT_FOUND);
    	 }
    	 
         //查询账单明细
    	 BillCostDetail bcd =new BillCostDetail();
    	 bcd.setBillId(obj.getId());
    	 obj.setBcds(billCostDetailService.findByObj(bcd));
    	 
    	 //查询凭证信息
    	 BillPayVoucher bpv=new BillPayVoucher();
    	 bpv.setBillId(obj.getId());
    	 
    	 
    	 List<BillPayVoucher> bpvs = billPayVoucherService.findByObj(bpv);
    	 if(CollectionUtils.isNotEmpty(bpvs)){
    		 for(BillPayVoucher item:bpvs){
    			 String fileUrl = item.getFileUrl();
    			 
    			 if(StringUtils.isNoneBlank(fileUrl) && !fileUrl.startsWith("/platform/image")){
        			 item.setFileUrl("/platform/image/" + item.getFileUrl());
    			 }
    		 }
    	 }else{
    		 bpvs = new ArrayList<BillPayVoucherService.BillPayVoucher>();
    	 }
    	 obj.setBpvs(bpvs);
    	 
    	 //查询收款记录
    	 BillCollectionRecord bcr=new BillCollectionRecord();
    	 bcr.setBillId(obj.getId());
    	 
    	 obj.setBcrs(billCollectionRecordService.findByOBj(bcr));
    	 
        
        return new Result<BillInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    /**
     * 账单核销 修改账单(下期调整)
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateBcr(@NotNull @PathParam("id") final long id ,
    		                        @Valid final BillInfo obj) {
    	
        Session session=getSessionQuietly();
        
    	if(session.getUserId() == null || session.getUserId() == 0){
    		 return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
    	//必须为下期调整的
    	if(obj.getNextAdjust() ==null ||obj.getNextAdjust() != 1){
    		 return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    	//调整金额不为空
    	if(obj.getAdjustAmount() ==null){
    		 return new Result<String>(ResultCode.ADJUST_AMOUNT_IS_NULL);
    	}
    	
    	obj.setOperator(session.getUserId());
    	obj.setId(id);
    		
    	//查询账单信息
    	BillInfo bi=billInfoService.getById(id);
    	if(bi == null){
    		 return new Result<String>(ResultCode.NOT_FOUND_BILL);
    	}
    	//校验状态为 未核销状态,主状态不为作废
    	if(bi.getBillStatus() != BillStatus.WRITTEN ||bi.getVerificationStatus() != BillVerificationStatus.WAIT_WRITTEN){
    		 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
    	}
        billInfoService.update(obj);
        
    	//插入操作日志（创建）
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(id);
        bcl.setOperator(session.getUserId());       
        
        bcl.setOperType(BillOperType.WARITTEN_ADJUST);
        bcl.setOperExplain(BillOperType.WARITTEN_ADJUST.text());
        billChangeLogsService.create(bcl);
    	
        return ResultSupport.ok();
        
    }
    
    /**
     * 账单核销 挂起账单
     * 当实际业务中，该账单无法有效进行收款，则可将账单挂起，进一步确认是否为坏账，同事更新账单状态为已挂起；
     * 若存在部分收款且后续不可收缴，则进行挂起时，需要对已收款金额进行分摊，分摊到具体的账单费用项目；
     * 当账单收到款后，可取消挂起，进行添加收款记录。
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/suspend/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> hangBcr(@NotNull @PathParam("id") final long id ,
    		                        @Valid final BillInfo obj) {
    	
    	   Long userId = getSessionQuietly().getUserId();

           //验证账单是否存在
           BillInfo bi=billInfoService.getById(id);
           if(bi == null){
           	return new Result<String>(ResultCode.NOT_FOUND);
           }
           //校验状态为 待核销状态的账单
           if(bi.getBillStatus() != BillStatus.WRITTEN || bi.getVerificationStatus() != BillVerificationStatus.WAIT_WRITTEN){
           	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
           }
           //挂起
           bi.setVerificationStatus(BillVerificationStatus.ALREADY_SUSPEND);
           bi.setVerificationBy(userId);
           bi.setVerificationTime(new Date());
           
           billInfoService.update(bi);
           
           //插入操作日志
           BillChangeLogs bcl=new BillChangeLogs();
           bcl.setBillId(bi.getId());
           bcl.setOperator(userId);     
           bcl.setOperType(BillOperType.HANG_UP);
           bcl.setOperExplain(BillOperType.HANG_UP.text());
         
           billChangeLogsService.create(bcl);
           
           return ResultSupport.ok();
        
    }
    
    /**
     * 账单核销 取消挂起
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/release/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> releaseBcr(@NotNull @PathParam("id") final long id ,
    		                        @Valid final BillInfo obj) {
    	
    	   Long userId = getSessionQuietly().getUserId();

           //验证账单是否存在
           BillInfo bi=billInfoService.getById(id);
           if(bi == null){
             return new Result<String>(ResultCode.NOT_FOUND);
           }
           //校验状态为 挂起状态的账单
           if(bi.getBillStatus() != BillStatus.WRITTEN || bi.getVerificationStatus() != BillVerificationStatus.ALREADY_SUSPEND){
           	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
           }
           //取消挂起，则状态变更为待核销状态
           bi.setVerificationStatus(BillVerificationStatus.WAIT_WRITTEN);
           bi.setVerificationBy(userId);
           bi.setVerificationTime(new Date());
           
           billInfoService.update(bi);
           
           //插入操作日志
           BillChangeLogs bcl=new BillChangeLogs();
           bcl.setBillId(bi.getId());
           bcl.setOperator(userId);     
           bcl.setOperType(BillOperType.RELEASE);
           bcl.setOperExplain(BillOperType.RELEASE.text());
         
           billChangeLogsService.create(bcl);
           
           return ResultSupport.ok();
        
    }
    
    /**
     * 描述：账单核销 账单完结
     * 当已挂起的账单，确认为坏账时，可进行完结，将该账单识别为坏账，同时更新账单状态为已完结。
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/finish/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> finishBcr(@NotNull @PathParam("id") final long id ,
    		                        @Valid final BillInfo obj) {
    	
    	   Long userId = getSessionQuietly().getUserId();

           //验证账单是否存在
           BillInfo bi=billInfoService.getById(id);
           if(bi == null){
             return new Result<String>(ResultCode.NOT_FOUND);
           }
           //校验状态为 挂起状态的账单
           if(bi.getBillStatus() != BillStatus.WRITTEN || bi.getVerificationStatus() != BillVerificationStatus.ALREADY_SUSPEND){
           	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
           }
           //完结，则状态变更为完结状态
           bi.setVerificationStatus(BillVerificationStatus.ALREADY_FINISHED);
           bi.setVerificationBy(userId);
           bi.setVerificationTime(new Date());
           
           billInfoService.update(bi);
           
           //插入操作日志
           BillChangeLogs bcl=new BillChangeLogs();
           bcl.setBillId(bi.getId());
           bcl.setOperator(userId);     
           bcl.setOperType(BillOperType.FINISHED);
           bcl.setOperExplain(BillOperType.FINISHED.text());
         
           billChangeLogsService.create(bcl);
           
           return ResultSupport.ok();
        
    }
    
    /**
     * 账单核销 添加收款记录
     * @param obj
     * @return
     */
    @POST
    @Path("/verify/bcr")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BillCollectionRecord obj) {
    	
        Session session=getSessionQuietly();
        
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    	}
    	obj.setOperator(session.getUserId());
    	//校验必填项
    	if( obj.getBillId() == null ||obj.getCollectionAmount() == null
    			                    ||obj.getCollectionTime()   == null){
    		
    		 return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    	}
    	//查询账单信息
    	BillInfo bi=billInfoService.getById(obj.getBillId());
    	if(bi == null){
    		 return new Result<Map<String, Long>>(ResultCode.NOT_FOUND_BILL);
    	}
    	
    	//校验状态为 未核销状态
    	if(bi.getVerificationStatus() != BillVerificationStatus.WAIT_WRITTEN){
    		 return new Result<Map<String, Long>>(ResultCode.BILLSTATUS_UPDATE_ERROR);
    	}

    	//账单状态更改为已确认
    	bi.setConfirmStatus(BillConfirmStatus.ALREADY_CONFIRM);
    	
    	//账单主状态更变为核销
    	bi.setBillStatus(BillStatus.WRITTEN);
    	bi.setOperator(getSessionQuietly().getUserId());
    	bi.setUpdateTime(new Date());
    	billInfoService.update(bi);
    	
    	//查询已有的收款记录
    	BillCollectionRecord bcr =new BillCollectionRecord();
    	bcr.setBillId(obj.getBillId());
    	List<BillCollectionRecord> bcds=billCollectionRecordService.findByOBj(bcr);
    	
    	//统计已有的收款记录的合计收款金额
		BigDecimal totalAmount=new BigDecimal("0");
    	if(CollectionUtils.isNotEmpty(bcds)){
    		for (BillCollectionRecord bcd : bcds) {
    			totalAmount=new BigDecimal(Arith.add(bcd.getCollectionAmount(), totalAmount));
			}
    		
    	}
    	
    	//账单总额减去合计的收款金额得到可以添加的收款金额
		BigDecimal waitWrittenAmount=new BigDecimal(Arith.sub(bi.getTotalAmount(),totalAmount));
		
		//当前收款金额大于 可以添加的收款金额，则不予保存
		if(obj.getCollectionAmount().compareTo(waitWrittenAmount) ==1 ){
			
			 return new Result<Map<String, Long>>(ResultCode.COLLECTION_AMOUNT_TOO_LARGE); 
		}
		//刚好等于待核销的金额，则直接将核销状态变更难为已核销状态并保存信息
		if(obj.getCollectionAmount().compareTo(waitWrittenAmount) ==0){
			
	         billCollectionRecordService.create(obj);
	     
		     BillInfo bill = new BillInfo();
		     bill.setId(obj.getBillId());
		     bill.setVerificationStatus(BillVerificationStatus.ALREADY_WRITTEN);
		     bill.setVerificationBy(session.getUserId());
		     bill.setVerificationTime(new Date());
		     
		     billInfoService.update(bill);
		     
	    	//插入操作日志（创建）
	        BillChangeLogs bcl=new BillChangeLogs();
	        bcl.setBillId(obj.getBillId());
	        bcl.setOperator(session.getUserId());       
	        
	        bcl.setOperType(BillOperType.HAS_BEEN_WRITTEN);
	        bcl.setOperExplain(BillOperType.HAS_BEEN_WRITTEN.text());
	        billChangeLogsService.create(bcl);
		     
		    return new Result<Map<String, Long>>(ResultCode.BILL_IS_WRITTEN);
		}
    	
    	Long id =billCollectionRecordService.create(obj);
    	
	    Map<String, Long> map = MapHelper.put("id",id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/billInfo/%s", id));
        result.setData(map);
        return result;
        
    }
    
    /**
     * 账单核销 修改收款记录
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/bcr/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateBcr(@NotNull @PathParam("id") final long id ,
    		                                   @Valid final BillCollectionRecord obj) {
    	
        Session session=getSessionQuietly();
        
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    	obj.setOperator(session.getUserId());
    	obj.setId(id);
    	//校验必填项
    	if(obj.getBillId() == null ||obj.getCollectionAmount() == null
    			                    ||obj.getCollectionBank()   == null){
    		
    		 return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    	//查询账单信息
    	BillInfo bi=billInfoService.getById(obj.getBillId());
    	if(bi == null){
    		 return new Result<String>(ResultCode.NOT_FOUND_BILL);
    	}
    	//校验状态为 未核销状态
    	if(bi.getVerificationStatus() != BillVerificationStatus.WAIT_WRITTEN){
    		 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
    	}
    	//查询已有的收款记录
    	BillCollectionRecord bcr =new BillCollectionRecord();
    	bcr.setBillId(obj.getBillId());
    	List<BillCollectionRecord> bcds=billCollectionRecordService.findByOBj(bcr);
    	
    	//统计已有的收款记录的合计收款金额
		BigDecimal totalAmount=new BigDecimal("0");
    	if(CollectionUtils.isNotEmpty(bcds)){
    		for (BillCollectionRecord bcd : bcds) {
    			//排除自己
    			if(bcd.getId() != id){
    			   totalAmount=new BigDecimal(Arith.add(bcd.getCollectionAmount(), totalAmount));
    			}
			}
    		
    	}
    	
    	//账单总额减去合计的收款金额得到可以添加的收款金额
		BigDecimal waitWrittenAmount=new BigDecimal(Arith.sub(bi.getTotalAmount(),totalAmount));
		
		//当前收款金额大于 可以添加的收款金额，则不予保存
		if(obj.getCollectionAmount().compareTo(waitWrittenAmount) ==1 ){
			
			 return new Result<String>(ResultCode.COLLECTION_AMOUNT_TOO_LARGE); 
		}
		//刚好等于待核销的金额，则直接将核销状态变更难为已核销状态并保存信息
		if(obj.getCollectionAmount().compareTo(waitWrittenAmount) ==0){
			 obj.setId(id);
	         billCollectionRecordService.update(obj);
	     
		     BillInfo bill = new BillInfo();
		     bill.setId(obj.getBillId());
		     bill.setVerificationStatus(BillVerificationStatus.ALREADY_WRITTEN);
		     bill.setVerificationBy(session.getUserId());
		     bill.setVerificationTime(new Date());
		     
		     billInfoService.update(bill);
		     
	    	 //插入操作日志（创建）
	         BillChangeLogs bcl=new BillChangeLogs();
	         bcl.setBillId(obj.getBillId());
	         bcl.setOperator(session.getUserId());       
	        
	         bcl.setOperType(BillOperType.HAS_BEEN_WRITTEN);
	         bcl.setOperExplain(BillOperType.HAS_BEEN_WRITTEN.text());
	         billChangeLogsService.create(bcl);
		     
		     return new Result<String>(ResultCode.BILL_IS_WRITTEN);
		}
    	
        billCollectionRecordService.update(obj);
    	
        return ResultSupport.ok();
        
    }
    
    /**
     * 描述：账单催缴
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/urge/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> urgeBcr(@NotNull @PathParam("id") final long id ,
    		                      @Valid final BillInfo obj) {
    	
		try {
		
		   Session session = getSessionQuietly();
		   
		   if(session == null || session.getUserId() == null || session.getPlatformId() ==null){
			   return new Result<String>(ResultCode.SESSION_IS_NULL);
		   }
	     
	       //验证账单是否存在
	       BillInfo bi=billInfoService.getById(id);
	       if(bi == null){
	         return new Result<String>(ResultCode.NOT_FOUND);
	       }
	       //校验状态为 待支付确认状态的账单
	       if(bi.getBillStatus() != BillStatus.PAYMENT || bi.getConfirmStatus() != BillConfirmStatus.WAIT_CONFIRM){
	       	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
	       }
	       
	       //查询模板
	       List<SystemConfig> scList= systemConfigService.getByParkId(session.getPlatformId());
	       SystemConfig sc=null;
	       if(CollectionUtils.isNotEmpty(scList)){
	    	   sc=scList.get(0);
	       } 
	       //判断催缴功能是否启用
	       if(sc == null || sc.getUrgeTermSign() != EnableStatus.ENABLE){
	    	   
	    	 return new Result<String>(ResultCode.URGE_NOT_ENABLED);
	       }
	       //执行消息推送
	       Message message = new Message();
	       //无需催缴的有效期限
	       Date validDate = SystemUtil.getDateAddDay(bi.getPushTime(), sc.getUrgeTermDays());
	       int validDay=SystemUtil.daysBetween(validDate, new Date());
	       String content= sc.getUrgeContentTemplate().replace(Constants.Park.CONFIG_BILL_PERIOD, bi.getBillMonth()).
	    		           replace(Constants.Park.CONFIG_OVER_TIME,validDay+"");
	       message.setContent(content);
	       message.setBizId(bi.getId());
	       message.setMsgType(MsgType.ENTERPRISE_ORDER);
	       message.setMsgBizType(MsgBizType.BILL);
	       message.setSourceType(SourceType.SYSTEM_MESSAGE);
	       message.setSrc(session.getUserId());    
	       message.setMsgStatus(MsgStatus.CREATE);
	       message.setOperator(session.getUserId());
	       message.setParkId(getSessionQuietly().getPlatformId());
	       
	       //发送给企业下所有用户
	       List<Long> adminUsers=adminUserService.findAllEnterpriseUserIdByEnterpriseIds(Arrays.asList(new Long[]{bi.getCompanyId()}));
	       
	       for (Long userId : adminUsers) {
	    	    message.setDst(userId);
	    	    messageService.save(message);
	    	    
	    	    //推送到手机app
	    	    noticeService.sendNoicMessage(userId.toString(), message.getContent());
		   }
	       
	       //催缴，则状态变更为已催缴状态
	       bi.setUrgePushStatus(BillUrgePushStatus.ALREADY_URGE);
	       bi.setUrgeBy(session.getUserId());
	       bi.setUrgeTime(new Date());
	       
	       billInfoService.update(bi);
	       
	       //插入操作日志
	       BillChangeLogs bcl=new BillChangeLogs();
	       bcl.setBillId(bi.getId());
	       bcl.setOperator(session.getUserId());     
	       bcl.setOperType(BillOperType.URGE);
	       bcl.setOperExplain(BillOperType.URGE.text());
	     
	       billChangeLogsService.create(bcl);
           
		} catch (Exception e) {
			logger.error("催缴异常：{}",e);
		}
    	
    	return ResultSupport.ok();
    }
    
    /**
     * 描述：账单重置
     * @param obj
     * @return
     */
    @PUT
    @Path("/verify/restoration/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> restBcr(@NotNull @PathParam("id") final long id ) {
    		                    
		try {
			
		   Session session = getSessionQuietly();
		   if(session == null || session.getUserId() == null || session.getPlatformId() ==null){
			   return new Result<String>(ResultCode.SESSION_IS_NULL);
		   }
	       //验证账单是否存在
	       BillInfo bi=billInfoService.getById(id);
	       if(bi == null){
	         return new Result<String>(ResultCode.NOT_FOUND);
	       }
	       //校验状态为 已核销or已完结 状态的账单
	       if(bi.getBillStatus() != BillStatus.WRITTEN || 
	    		    (bi.getVerificationStatus() != BillVerificationStatus.ALREADY_WRITTEN &&
	    		     bi.getVerificationStatus() != BillVerificationStatus.ALREADY_FINISHED)){
	       	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
	       }
	       
	       BillChangeLogs bcl=new BillChangeLogs();
	       //已经核销
	       if(bi.getVerificationStatus() == BillVerificationStatus.ALREADY_WRITTEN){
	    	   //1.状态变更为待核销
		       bi.setVerificationStatus(BillVerificationStatus.WAIT_WRITTEN); 
	    	   //2.清除核销明细
		       BillCollectionRecord bcr= new BillCollectionRecord();
		       bcr.setOperator(session.getUserId());
		       bcr.setBillId(bi.getId());
		       billCollectionRecordService.deteleByBillId(bcr);
		       //3.清除费用明细的核销金额
		       BillCostDetail bcd =new BillCostDetail();
		       bcd.setBillId(bi.getId());
		       bcd.setVerifyMoney(new BigDecimal("0"));
		       
		       billCostDetailService.updateObj(bcd);
		       //4.记录日志
		       bcl.setOperType(BillOperType.WRITTEN_REST);
		       bcl.setOperExplain(BillOperType.WRITTEN_REST.text());
	    	   
	       }
	       
	       //已经完结
	       if(bi.getVerificationStatus() == BillVerificationStatus.ALREADY_FINISHED){
	    	   //1.状态变更为已经完结
		       bi.setVerificationStatus(BillVerificationStatus.ALREADY_SUSPEND); 
		       //3.记录日志
		       bcl.setOperType(BillOperType.FINISHED_REST);
		       bcl.setOperExplain(BillOperType.FINISHED_REST.text());
	    	   
	       }
	       //修改状态
	       billInfoService.update(bi);
	       
	       //插入操作日志
	       bcl.setBillId(bi.getId());
	       bcl.setOperator(session.getUserId());     
	     
	       billChangeLogsService.create(bcl);
           
		} catch (Exception e) {
			logger.error("重置状态异常：{}",e);
		}
    	
    	return ResultSupport.ok();
    }
    
    /**
     * 描述：通过账单月份获取，待出账单的公司
     * @param offset
     * @param limit
     * @return
     */
    @GET
    @Path("/months")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String,Object>>> findByMonth(
            @QueryParam("billMonth") String billMonth
            ) {
        Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<List<Map<String,Object>>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<List<Map<String,Object>>>(ResultCode.BAD_REQUEST);
    	}
    	
    	//查询当前园区关联的企业
    	EnterpriseCott ec =new EnterpriseCott();
    	
        ec.setParkId(session.getPlatformId());
        ec.setCorrType(CorrType.CONTRACT_RELATED);            //合同关联的
        ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);         //已经关联的
        
    	List<EnterpriseCott> ecList = enterpriseCottService.findList(ec);
    	
    	if(CollectionUtils.isEmpty(ecList)){
    		return new Result<List<Map<String,Object>>>(ResultCode.OK);
    	}
    	
    	List<Map<String,Object>> lists=new ArrayList<Map<String, Object>>(); 
    	
    	for (EnterpriseCott enterpriseCott : ecList) {
    		//查询每个关联关系 关联的合同
    		EnterpriseCorrContract ecc=new EnterpriseCorrContract();
    	    ecc.setEnterpriseCottId(enterpriseCott.getId());
    	    ecc.setContractStatus(1);
    		List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);
    		if(CollectionUtils.isEmpty(eccList)){
    			continue;
    		}
			//通过合同查询账单
    		//查询企业信息
    		EnterpriseInfo ei=enterpriseInfoService.getById(enterpriseCott.getEnterpriseId());
			for (EnterpriseCorrContract eccObj : eccList) {
				
				ContractInfo ci= contractInfoService.getById(eccObj.getContractId());
				if(!ContractStatus.SUCCESS.equals(ci.getContractStatus())){
					continue;
				}

				BillInfo bi = billInfoService.findBillByContractAndMonth(eccObj.getContractId(), billMonth);
				//未生成账单的并且合同截止时间大于等于当前时间
				if(bi == null && new Date().before(ci.getEndDate())){
					
					Map<String, Object> needMap=new HashMap<String, Object>();
					needMap.put("companyId", ei.getId());
					needMap.put("companyName", ei.getName());
					needMap.put("contractId", eccObj.getContractId());
					needMap.put("contractNo", eccObj.getContNo());
					needMap.put("billMonth", billMonth);
					lists.add(needMap);
					
				}
			}
		}
		
        return new Result<List<Map<String,Object>>>(ResultCode.OK,lists);
        
    }
    
    @POST
    @Path("/batch")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> batchCreate(@Valid final List<BatchBill> bis) {
    	
    	Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    	}
    	if(CollectionUtils.isEmpty(bis)){
    		return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    	}
    	//批量处理
    	for (BatchBill batchBill : bis) {
    		
    		//校验数据
    		if (batchBill.getCompanyId() == null
    				|| batchBill.getContractId() == null
    				|| StringUtils.isBlank(batchBill.getBillMonth())) {
    			return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    		}

    		// 校验是否已生成账单
    		BillInfo billInfo = billInfoService.findBillByContractAndMonth(batchBill.getContractId(), batchBill.getBillMonth());
    		if (billInfo != null) {
    			return new Result<Map<String, Long>>(ResultCode.BILL_ALREADY_EXISTS);
    		}
    		Date argMonth = SystemUtil.getDateYYYYMM(batchBill.getBillMonth());
    		if (argMonth == null) {
    			return new Result<Map<String, Long>>(ResultCode.BAD_REQUEST);
    		}
    		// 查询规则对应合同
    		ContractInfo ci = contractInfoService.getById(batchBill.getContractId());
    		if (ci == null) {
    			return new Result<Map<String, Long>>(ResultCode.NOT_FOUND_CONTRACT);
    		}
    		if (ci.getStartDate() == null) {
    			return new Result<Map<String, Long>>(ResultCode.START_DATE_IS_REQUIRED);
    		}
    		if (ci.getEndDate() == null) {
    			return new Result<Map<String, Long>>(ResultCode.END_DATE_IS_REQUIRED);
    		}
    		// 判断月份
    		if (SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getStartDate(),"yyyy-MM")).getTime() > argMonth.getTime()) {
    			return new Result<Map<String, Long>>(ResultCode.MONTH_NON_COMPLIANT);
    		}
    		if (SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getEndDate(),"yyyy-MM")).getTime() <= argMonth.getTime()) {
    			return new Result<Map<String, Long>>(ResultCode.MONTH_NON_COMPLIANT);
    		}
    		//通过计算公式计算合同的查询费用详情
            List<BillCostDetail> bcds=getBillCostDetail(ci, argMonth);
            
            //获取维修费用
            //获取指定企业的维修申报任务
	        EnterpriseCorrContract enterpriseCorrContract = new EnterpriseCorrContract();
	        enterpriseCorrContract.setContractId(ci.getId());
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
            
            //计算费用总额，合计税额，合计金额
            BigDecimal totalMoney=new BigDecimal("0");
            BigDecimal totalTaxMoney=new BigDecimal("0");
            BigDecimal totalAmount=new BigDecimal("0");
            
            if(CollectionUtils.isNotEmpty(bcds)){
	            for (BillCostDetail billCostDetail : bcds) {
	            	
	            	totalMoney = new BigDecimal(Arith.add(billCostDetail.getCost(), totalMoney));
	            	totalTaxMoney = new BigDecimal(Arith.add(billCostDetail.getTaxMoney(),totalTaxMoney));
	            	totalAmount   = new BigDecimal(Arith.add(billCostDetail.getTotalMoney(),totalAmount));
					
				}
            }
            //新增
            BillInfo bi = new BillInfo();
            bi.setOperator(session.getUserId());
            bi.setBillNo(getGenBillNo());
            bi.setParkId(session.getPlatformId());
            bi.setCompanyId(batchBill.getCompanyId());
            bi.setCompanyName(batchBill.getCompanyName());
            bi.setContractId(batchBill.getContractId());
            bi.setContractNo(batchBill.getContractNo());
            bi.setBillMonth(batchBill.getBillMonth());
            bi.setTotalMoney(totalMoney);
            bi.setTotalTaxMoney(totalTaxMoney);
            bi.setTotalAmount(totalAmount);
            bi.setBillStatus(BillStatus.SUBMIT);
            bi.setSubmitStatus(BillSubmitStatus.WAIT_SUBMIT);
            
            Long billId = billInfoService.create(bi);
            
            if(CollectionUtils.isNotEmpty(bcds)){
	             //关联费用详情
	            for (BillCostDetail bcd : bcds) {
	            	bcd.setBillId(billId);
	            	bcd.setOperator(session.getUserId());
	            	billCostDetailService.create(bcd);
	    		} 
            }
            
            //维护维修任务表
            if(CollectionUtils.isNotEmpty(taskIds)){
            	Task task = new Task();
            	for(Long itemId:taskIds){
            		task.setId(itemId);
            		task.setBillId(billId);
            		task.setIsChoose(1);
            		
            		task.setOperator(getSessionQuietly().getUserId());
            		taskService.update(task);
            	}
            }
            
         	//插入操作日志（创建）
            BillChangeLogs bcl=new BillChangeLogs();
            bcl.setBillId(billId);
            bcl.setOperator(session.getUserId());       
            
            bcl.setOperType(BillOperType.CREATE);
            bcl.setOperExplain(BillOperType.CREATE.text());
            billChangeLogsService.create(bcl);
			
		}
    	
        return new Result<Map<String,Long>>(ResultCode.OK);
    }
    
	public List<BillCostDetail> getBillCostDetail(ContractInfo ci,Date argMonth){
		
		List<BillCostDetail> bcds = new ArrayList<BillCostDetail>();
	    	
		Long contractId = ci.getId();
		String month = SystemUtil.dateFormat(argMonth, "yyyy-MM");
		
    	if(contractId == null || StringUtils.isBlank(month)){
    		 return bcds;
    	}

    	if(argMonth == null){
    		return bcds;
    	}
    	if(ci.getStartDate() ==null){
    		 return bcds;
    	}
    	if(ci.getEndDate() ==null){
    		 return bcds;
    	}
    	
    	//判断月份
    	if(SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getStartDate(), "yyyy-MM")).getTime() > argMonth.getTime()){
    		 return bcds;
    	}
    	if(SystemUtil.getDateYYYYMM(SystemUtil.dateFormat(ci.getEndDate(), "yyyy-MM")).getTime() < argMonth.getTime()){
   		     return bcds;
   	    }
    	
    	BillCostCalRules bccr=new BillCostCalRules();
    	bccr.setContractId(contractId);
    	//查询费用计算规则
    	List<BillCostCalRules> bccrList=billCostCalRulesService.findByObj(bccr);
    	if(CollectionUtils.isEmpty(bccrList)){
    		return bcds;
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
		return bcds;
	}
    
    public List<BillCostDetail> getBillCostDetailOld(ContractInfo ci,Date argMonth){
    	
    	List<BillCostDetail> bcds= new ArrayList<BillCostDetail>();
    	
    	String month = SystemUtil.dateFormat(argMonth, "yyyy-MM");
    	//中间的月份(包括起始和截止)
    	List<String> diffMonths=SystemUtil.getMonthsBetweenTimes(ci.getStartDate(), argMonth);
    	
    	//当前合同与费用项目明细表
    	List<String> months = SystemUtil.getMonthsBetweenTimes(ci.getStartDate(), ci.getEndDate());
    	
    	//当前月份
    	Integer i=diffMonths.size();
    	
    	BillCostCalRules bccr=new BillCostCalRules();
    	bccr.setContractId(ci.getId());
    	//查询费用计算规则
    	List<BillCostCalRules> bccrList=billCostCalRulesService.findByObj(bccr);
    	if(CollectionUtils.isEmpty(bccrList)){
    		return null;
    	}
    	
    	 //通过计算公式获得 费用项目金额        	
        Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
        values.put("area", ci.getArea());
        values.put("amount", ci.getTotalMoney());
        values.put("days", new BigDecimal(SystemUtil.getDaysByMonth(month)));
    	
    	BillCostDetail bcd=null;
    
        for (BillCostCalRules obj : bccrList) {
        	
        	//获取账单月份
        	List<String> billMonths = SystemUtil.getBillMonthsBetweenTimes(ci, obj);
        	//获取调整月份金额
        	Map<String, Object> billCcrAdjMap = billCcrAdjService.findByBccrIdAndMonth(obj.getId(), months);
        	//费用项目
        	CostPro cp=costProService.getById(obj.getCostProId());
        	//获取起始月
        	BigDecimal costMoney=new BigDecimal("0");
            
    	    bcd=new BillCostDetail();
    	    bcd.setBccrId(obj.getId());
    	    bcd.setCostProName(cp.getName());
    	    bcd.setChargeMode(cp.getChargeMode());
    	  
	    	//计算方式不为空
    	    ComputeMode computeMode = obj.getComputeMode();
   		    //免收月数处理
    		if(computeMode != null && obj.getFreeMonth() != null && i< obj.getFreeMonth()){
    			if(i == 1){
         			//免收月数
         			Integer freeMonth = obj.getFreeMonth();
         			if(freeMonth != null && freeMonth > 0){
         				for(int z=0;z<freeMonth;z++){
         					String tempMonth = months.get(z);
         					Object adjAmount = billCcrAdjMap.get(tempMonth);
         					if(adjAmount != null){
         						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
         						costMoney=new BigDecimal(Arith.add(adjAmountBigDecimal, costMoney));
         					}		
         				}
         			}
     			}else{
     				costMoney = new BigDecimal("0");
     			}
    		}
    		//固定金额
    		else if(computeMode != null && ComputeMode.FIXED_AMOUNT.equals(computeMode)){
            		//费用预收月数
        			if(obj.getAdvanceMonth() !=null){
        				if(billMonths.contains(month)){
        					//判断当前月与后预收的n个月是否有账单调整的
         					BigDecimal currentAmount=new BigDecimal("0");
        					for (int j = 1; j < obj.getAdvanceMonth(); j++) {
        						
								BigDecimal amount=obj.getFixedAmount();
								String nextMonth=SystemUtil.getDateByAddMonth(argMonth,j);
								//必须小于合同截至日期
								if(ci.getEndDate() ==null || (SystemUtil.getDate(nextMonth, "yyyy-MM").getTime() <= ci.getEndDate().getTime())){
								
									//获取
									Object adjAmount = billCcrAdjMap.get(nextMonth);
	             					if(adjAmount != null){
	             						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
	             						currentAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, amount));
	             					}
									
								}
                            	currentAmount=new BigDecimal(Arith.add(currentAmount, amount));
            			     }
        					costMoney=currentAmount;	
        				}else{
        					
        					//todo
            			}
        			}else{ 
        				
        				costMoney=obj.getFixedAmount()==null?new BigDecimal(""):obj.getFixedAmount();
        				//获取对应的调整项（有可能为空）
	 					Object adjAmount = billCcrAdjMap.get(argMonth);
	 					if(adjAmount != null){
	 						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
	 						costMoney=new BigDecimal(Arith.add(adjAmountBigDecimal, costMoney));
	 					}
        		  }
    		}
   		    //自定义计算
    		else if(computeMode != null && ComputeMode.CUSTOME_CAL.equals(computeMode)){
	            
	            //项目金额
	            BigDecimal billInitAmount=  FormulaParser.parse(obj.getFormula(), values);
	            //new BigDecimal(10000);
	            BigDecimal billAmount=billInitAmount;
	            
	            //预收月份的滚动项目金额
	            BigDecimal rollingAmount=null;
       			    //启用滚动计算的
	       			if(obj.getIsRollingCal() == 1){
	       			//滚动月份、幅度
             	        Map<String,BigDecimal> rollRangeMap = convertorContractToRange(obj, ci);
	       			    
	       				//费用预收月数
		             	if(obj.getAdvanceMonth() !=null){
		             				
	        				if(billMonths.contains(month)){
	        					//算滚动的
        						//10000*(1+m)^n
        						//计算下n个月份的
        						rollingAmount=new BigDecimal("0");
        						for (int j = i; j < i+obj.getAdvanceMonth(); j++) {
        							
        							String currentMonth = months.get(j);
        							
        							BigDecimal currentRange = rollRangeMap.get(currentMonth);
        							Double Idempotent = currentRange.doubleValue();
        							
        							BigDecimal currentBill=new BigDecimal(Arith.mul(billInitAmount.doubleValue(),Idempotent));
	        						rollingAmount=new BigDecimal(Arith.add(rollingAmount.doubleValue(), currentBill.doubleValue()));
        							
    	        				}
        						for (int j = i; j < i+obj.getAdvanceMonth(); j++) {
        							//获取对应的调整项（有可能为空）
	             					Object adjAmount = billCcrAdjMap.get(months.get(j));
	             					if(adjAmount != null){
	             						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
	             						rollingAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, rollingAmount));
	             					}			        							
        						}
        						costMoney=new BigDecimal(Arith.round(rollingAmount.toString(),2));
	        				}else{
	        					//todo
	        			    }
	       			   }else{
	       				//费用调整
			       			Object adjAmount = billCcrAdjMap.get(argMonth);
		   					if(adjAmount != null){
		   						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
		   						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
		   					}
		                   	costMoney = billAmount;
	       			   }
	       		  }else{
	       			//费用调整
	       			Object adjAmount = billCcrAdjMap.get(argMonth);
   					if(adjAmount != null){
   						BigDecimal adjAmountBigDecimal = (BigDecimal)adjAmount;
   						billAmount=new BigDecimal(Arith.add(adjAmountBigDecimal, billAmount));
   					}
                	costMoney = billAmount;
	       		  }
   	         }
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
        return bcds;
      }
    
    /**
     * 描述：通过账单月份获取，待出账单的公司
     * @param offset
     * @param limit
     * @return
     */
    @GET
    @Path("/costProSetting/months")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Map<String,Object>>> costProSettingFindByMonth(
            @QueryParam("billMonth") String billMonth,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum) {
    	
        Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<List<Map<String,Object>>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<List<Map<String,Object>>>(ResultCode.BAD_REQUEST);
    	}
    	
    	//1.只能查询所属园区的所有按用量计算的费用项目
		CostPro cp = new CostPro();
		cp.setCreateSource(CreateSource.PARK);
		cp.setParkId(session.getPlatformId());
		cp.setChargeMode(ChargeMode.DOSAGE);
		cp.setEnableStatus(EnableStatus.ENABLE);
		List<CostPro> items = costProService.findByObj(cp);
		List<CostPro> costPros = new ArrayList<CostProService.CostPro>();
		for(CostPro item:items){
			if(EnableStatus.ENABLE.equals(item.getEnableStatus())){
				costPros.add(item);
			}
		}
    	
    	//查询当前园区关联的企业
    	EnterpriseCott ec =new EnterpriseCott();
    	
        ec.setParkId(session.getPlatformId());
        ec.setCorrType(CorrType.CONTRACT_RELATED);            //合同关联的
        ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);         //已经关联的
        
    	List<EnterpriseCott> ecList = enterpriseCottService.findList(ec);
    	
    	if(CollectionUtils.isEmpty(ecList)){
    		return new Result<List<Map<String,Object>>>(ResultCode.OK);
    	}
    	
    	List<Map<String,Object>> lists=new ArrayList<Map<String, Object>>(); 
    	
    	for (EnterpriseCott enterpriseCott : ecList) {
    		//查询每个关联关系 关联的合同
    		EnterpriseCorrContract ecc=new EnterpriseCorrContract();
    	    ecc.setEnterpriseCottId(enterpriseCott.getId());
    	    ecc.setContractStatus(1);
    		List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);
    		//查询企业信息
    		EnterpriseInfo ei=enterpriseInfoService.getById(enterpriseCott.getEnterpriseId());
    		
    		if(CollectionUtils.isNotEmpty(eccList)){
    			//通过合同查询账单
    			for (EnterpriseCorrContract eccObj : eccList) {
    				
					BillInfo bi = billInfoService.findBillByContractAndMonth(eccObj.getContractId(), billMonth);
					ContractInfo ci= contractInfoService.getById(eccObj.getContractId());
					
					//为生效的合同不做任何处理
					if(!ContractStatus.SUCCESS.equals(ci.getContractStatus())){
						continue;
					}
					            
					//未生成账单的并且合同截止时间大于等于当前时间
					if(bi == null && (ci.getEndDate().getTime() >= SystemUtil.formatYYMMDD(new Date()).getTime())){
						Map<String, Object> needMap=new HashMap<String, Object>();
						needMap.put("enterpriseId", ei.getId());
						needMap.put("enterpriseName", ei.getName());
						needMap.put("contractId", eccObj.getContractId());
						needMap.put("contractNo", eccObj.getContNo());
						needMap.put("billMonth", billMonth);
						
						List<CostPro> newCostPros = new ArrayList<CostProService.CostPro>();
						if(CollectionUtils.isNotEmpty(costPros)){
							CostProSetting costProSetting = null;
							for(CostPro item:costPros){
								costProSetting = new CostProSetting();
								costProSetting.setContractId(eccObj.getContractId());
								costProSetting.setCostProType(item.getId());
								costProSetting.setBillMonth(billMonth);
								
								CostProSetting temp = costProSettingService.findByObject(costProSetting);
								if(temp != null){
									item.setDosage(temp.getDosage());
								}
							
								newCostPros.add(item);
							}
						}
						needMap.put("costPros", newCostPros);
						lists.add(needMap);
					}
				}
    		}
		}
        return new Result<List<Map<String,Object>>>(ResultCode.OK,lists);
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
     * 获取自动生成的订单编号
     * @return
     */
    public String getGenBillNo(){
    	
         String type =Constants.Park.BILL_NO_PREFIX+"_"+SystemUtil.getYearAndMonth(new Date());
         
    	 return  genCodeService.nextCodeByType(type);
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
    		BigDecimal range = rollPeriod.getRollRange().divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
    		//滚动开始时间
    		Date startDate = rollPeriod.getStartDate();
    		//滚动结束时间
    		Date endDate = rollPeriod.getEndDate();
    		//滚动周期（天）
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
    
    private String createNewExcelFile(){
    	try{
            // 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet("账单表一");  
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = sheet.createRow(0);  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
           //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
           HSSFCell cell=row.createCell(0);  
           //设置单元格内容  
           cell.setCellValue("账单列表");  
           cell.setCellStyle(style); 
           //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
           sheet.addMergedRegion(new CellRangeAddress(0,0,0,7)); 
            
	        row = sheet.createRow(1);
	        cell = row.createCell(0);
	        cell.setCellValue("账单ID ");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(1);  
	        cell.setCellValue("账单编号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(2);  
	        cell.setCellValue("账单期间");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(3);  
	        cell.setCellValue("合同号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(4);  
	        cell.setCellValue("企业名称");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(5);  
	        cell.setCellValue("账单总额");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(6);  
	        cell.setCellValue("创建人");  
	        cell.setCellStyle(style);  
	        cell = row.createCell(7);  
	        cell.setCellValue("账单状态");  
	        cell.setCellStyle(style);  
	        
	        HuolijuzhenConfig huolijuzhenConfig = HuolijuzhenConfig.getInstance();
	        String filePath = huolijuzhenConfig.getFilePath();
	        
	        // 第六步，将文件存到指定位置  
	        String fileName = ((Long)System.currentTimeMillis()).toString();
	        String path = filePath + "账单列表-" + getSessionQuietly().getUserId() + "-" + fileName + ".xls";
	        FileOutputStream fout = new FileOutputStream(path);  
	        wb.write(fout);  
	        fout.close();
	        wb.close();
	        return path;
    	}catch(Exception e){
    		logger.error("账单列表导出 excel error:{}",e);
    		return null;
    	}
    }
    
    
    
    /**
     * 分页查询数据
     * @param query
     */
    private void createExcel(Query query,String filePath){
    	
    	Page<BillInfo> page = billInfoService.find(query);
    	Integer offset = page.getOffset();
		Integer limit = page.getLimit();
		Integer total = page.getTotal();
    	
		List<BillInfo> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(BillInfo comm:list){
    			item = packListInfo(comm);
    			items.add(item);
    		}
    	}
    	//将数据写入 Excel 文件中
    	writerIntoExcel(items,filePath,offset);
		offset += limit;
    	if(offset < total){
    		query.setOffset(offset);
    		createExcel(query,filePath);
    	}
    }

    /**
     * 將数据写入 excel 文件中
     * @param items
     */
    private void writerIntoExcel(List<Map<String, Object>> items,String filePath,Integer offset){

    	try{
    		
    		FileInputStream fis = new FileInputStream(new File(filePath));
    		// 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            //关闭输入流
            fis.close();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.getSheetAt(0);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = null;  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
            if(CollectionUtils.isEmpty(items)){
            	wb.close();
            	return ;
            }
           
            HSSFCellStyle totalAmountStyle = wb.createCellStyle();
            totalAmountStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 创建一个居中格式  

            Map<String, Object> itemMap = null;
            HSSFCell cell = null;
            for (int i = 0; i < items.size(); i++)  
            {
            	itemMap = items.get(i);
	            row = sheet.createRow(offset + i + 2);  
	            //ID
	            row.createCell(0).setCellValue(itemMap.get("id").toString());
	            //账单编号
	            row.createCell(1).setCellValue((String)itemMap.get("billNo"));
	            //账单期间
	            row.createCell(2).setCellValue((String)itemMap.get("billMonth"));
	            //合同号
	            row.createCell(3).setCellValue((String)itemMap.get("contractNo"));
	            //企业名称
	            row.createCell(4).setCellValue((String)itemMap.get("companyName"));
	            //账单总额
	            cell = row.createCell(5);
	            cell.setCellValue(itemMap.get("totalAmount").toString());
	            cell.setCellStyle(totalAmountStyle);
	            //创建人
	            row.createCell(6).setCellValue((String)itemMap.get("createUserName"));
	            //账单状态
	            row.createCell(7).setCellValue((String)itemMap.get("billStatus"));
            }  
            
            //写入到 Excel 文件中
            FileOutputStream fos = new FileOutputStream(filePath);
    		wb.write(fos);
    		fos.flush();
    		fos.close();
    		wb.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(BillInfo item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("billNo", item.getBillNo());
    	infoMap.put("billMonth", item.getBillMonth());
    	infoMap.put("contractNo", item.getContractNo());
    	infoMap.put("companyName", item.getCompanyName());
    	infoMap.put("totalAmount", item.getTotalAmount());
    	infoMap.put("createUserName", item.getCreateUserName());   
    	infoMap.put("billStatus", item.getBillStatus().text());
    	return infoMap;
    }

    
}
