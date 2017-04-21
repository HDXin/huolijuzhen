package com.sudaotech.huolijuzhen.bill.web.app.enterprise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService.BillChangeLogs;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BillInfo;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.Query;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService.BillPayVoucher;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillOperType;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.huolijuzhen.util.SortUtil;
import com.sudaotech.huolijuzhen.util.SystemUtil;

@Path("/app/enterprise/billInfo")
public class BillInfoResource extends BusinessBaseResource{

    @Inject
    private BillInfoService billInfoService;
    
    @Inject
    private BillChangeLogsService billChangeLogsService;
    
    @Inject
    private BillPayVoucherService billPayVoucherService;
    
    @Inject
    private BillCostDetailService billCostDetailService;
    
    /**
     * 确认
     * @param id
     * @return
     */
    @PUT
    @Path("/confirm/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> push(
            @NotNull @PathParam("id") final Long id,
            @Valid final BillInfo obj
            ) {
    	
        Long userId = getSessionQuietly().getUserId();
        
        if(StringUtils.isEmpty(obj.getPaySerialNumber()) &&  CollectionUtils.isEmpty(obj.getBpvs())){
        	return new Result<String>(ResultCode.PAY_VOUCHER_IS_REQUIRED);
        }
        
        //验证账单是否存在
        BillInfo bi=billInfoService.getById(id);
        if(bi == null){
        	return new Result<String>(ResultCode.NOT_FOUND);
        }
        //校验状态为 已推送状态的账单
        if(bi.getBillStatus() != BillStatus.PAYMENT
        		||bi.getPushStatus() != BillPushStatus.ALREADY_PUSH){
        	 return new Result<String>(ResultCode.BILLSTATUS_UPDATE_ERROR);
        }
        
        
        //推送则主状态变更为核销，核销状态变更为 待核销状态，缴款确认状态变更为已确认
        obj.setId(id);
        obj.setBillStatus(BillStatus.WRITTEN);    
        obj.setVerificationStatus(BillVerificationStatus.WAIT_WRITTEN);
        obj.setConfirmStatus(BillConfirmStatus.ALREADY_CONFIRM);
        obj.setConfirmBy(userId);
        obj.setConfirmTime(new Date());
        
        billInfoService.update(obj);
        
        //插入凭证信息
        for (BillPayVoucher bpv : obj.getBpvs()) {
        	 bpv.setBillId(id);
        	 bpv.setOperator(userId);
        	 billPayVoucherService.create(bpv);
		}
        
        
        //插入操作日志
        BillChangeLogs bcl=new BillChangeLogs();
        bcl.setBillId(bi.getId());
        bcl.setOperator(userId);     
        bcl.setOperType(BillOperType.PAYMENT_CONFIRM);
        bcl.setOperExplain(BillOperType.PAYMENT_CONFIRM.text());
      
        billChangeLogsService.create(bcl);
        
        return ResultSupport.ok();
    }
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parkId") Long parkId
            ) {
        Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Page<BillInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
    	}
    	if(parkId == null || parkId ==0){
    		return new Result<Page<BillInfo>>(ResultCode.BAD_REQUEST);
    	}
    		
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
        query.setCompanyId(session.getPlatformId());
        query.setParkId(parkId);
		
		Page<BillInfo> page = billInfoService.find(query);
        return new Result<Page<BillInfo>>(ResultCode.OK, page);
    }
    /**
     *       查询已推送给企业的账单
     * @param offset
     * @param limit
     * @param pageNum
     * @param parkId
     * @return
     */
    @GET
    @Path("/pushed")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findPushedBill(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parkId") Long parkId
            ) {
        Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
    		return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<Map<String, Object>>(ResultCode.BAD_REQUEST);
    	}
    	if(parkId == null || parkId ==0){
    		return new Result<Map<String, Object>>(ResultCode.BAD_REQUEST);
    	}
    	
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
        query.setCompanyId(session.getPlatformId());
        query.setParkId(parkId);
        //确认交款状态
        query.setConfirm(true);
        
//        query.setcon(BillPushStatus.ALREADY_PUSH);
		
		Page<BillInfo> page = billInfoService.find(query);
		
		//封装响应信息
    	Map<String, Object> dataMap = new HashedMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<BillInfo> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(BillInfo comm:list){
    			item = packListInfo(comm);
    			items.add(item);
    		}
    	}
    	dataMap.put("items", items);
		
        return new Result<Map<String, Object>>(ResultCode.OK, dataMap);
        
    }
    
    Map<String, Object> packListInfo(BillInfo bi){
    	
    	Map<String, Object> returnMap= new HashMap<String, Object>();
    	
    	returnMap.put("id", bi.getId());
    	returnMap.put("contractNo", bi.getContractNo());
    	returnMap.put("billNo", bi.getBillNo());
    	returnMap.put("billMonth", bi.getBillMonth());
    	returnMap.put("billMonthShow", SystemUtil.getDateStrYYYYMM(bi.getBillMonth())+"账单");
    	returnMap.put("pushTime", SystemUtil.dateFormat(bi.getPushTime(),"yyyy-MM-dd HH:mm"));
    	returnMap.put("billStatus", bi.getBillStatus());
    	returnMap.put("confirmStatus",bi.getConfirmStatus());
    	returnMap.put("confirmStatusShow",bi.getConfirmStatus().text());
    	
    	return returnMap;
    }
    
    
    @GET
    @Path("/detail/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> getDetail(@NotNull @PathParam("id") final Long id) {
    	
    	 BillInfo obj = billInfoService.getById(id);
    	 
    	 if(obj == null){
    		 return new Result<Map<String, Object>>(ResultCode.NOT_FOUND);
    	 }
    	 
         //查询账单明细
    	 BillCostDetail bcd =new BillCostDetail();
    	 bcd.setBillId(obj.getId());
    	 obj.setBcds(billCostDetailService.findByObj(bcd));
        
        return new Result<Map<String, Object>>(ResultCode.OK, packDetailInfo(obj));
    }
    
    /**
     * 包装 响应信息
     * @param bi
     * @return
     */
    
    public  Map<String, Object> packDetailInfo(BillInfo bi){
		    	
		    	Map<String, Object> returnMap= new HashMap<String, Object>();
		    	returnMap.put("id", bi.getId());
		    	returnMap.put("contractNo", bi.getContractNo());
		    	returnMap.put("billMonth", bi.getBillMonth());
		    	returnMap.put("billNo", bi.getBillNo());
		    	returnMap.put("billMonthShow", SystemUtil.getDateStrYYYYMM(bi.getBillMonth()));
		    	returnMap.put("billStatus", bi.getBillStatus());
		    	returnMap.put("confirmStatus",bi.getConfirmStatus());
		    	returnMap.put("totalTaxMoney",bi.getTotalTaxMoney());
		    	returnMap.put("reliefMoney",bi.getReliefMoney());
		    	returnMap.put("totalAmount",bi.getTotalAmount());
		    	returnMap.put("confirmStatusShow",bi.getConfirmStatus().text());
		    	//账单明细（包括账单百分比）
		    	List<Map<String, Object>>  list =null;
	    		
		    	if(CollectionUtils.isNotEmpty(bi.getBcds())){
		    		
		    		List<BillCostDetail> bcds=bi.getBcds();
		    		SortUtil.sortList(bcds, "totalMoney", "DESC");
		    		
		    		list=new ArrayList<Map<String,Object>>();
		    		BigDecimal totalCostMoney=new BigDecimal("0");
		    		BigDecimal otherCostMoney=new BigDecimal("0");
		    		
		    		for (int i = 0; i < bcds.size(); i++) {
		    			BillCostDetail bcd=bi.getBcds().get(i);
		    			totalCostMoney=new BigDecimal(Arith.add(bcd.getTotalMoney(), totalCostMoney));
		    			//第三个费用账单以后的金额 统一合并到 其他项目
		    			if(i>=3){
		    				otherCostMoney =new BigDecimal(Arith.add(bcd.getTotalMoney(), otherCostMoney));
		    			}
					}
		    		
		    		list=new ArrayList<Map<String,Object>>();
		    		Map<String,Object> percentMap=null;
		    		for (int i = 0; i < bcds.size(); i++) {
		    			percentMap = new HashMap<String, Object>();
		    			BillCostDetail bcd=bi.getBcds().get(i);
		    			if(i<3){
		    				percentMap.put("proName",bcd.getCostProName());
		    				percentMap.put("totalMoney",Arith.round(bcd.getTotalMoney(),2));
		    				if(bcd.getTotalMoney().compareTo(new BigDecimal("0"))==1 && totalCostMoney .compareTo(new BigDecimal("0"))==1 ){
		    				percentMap.put("percent", SystemUtil.getPercent(bcd.getTotalMoney().doubleValue(), totalCostMoney.doubleValue()));
		    				percentMap.put("percentDec", Arith.round(SystemUtil.getPercentDec(bcd.getTotalMoney().doubleValue(), totalCostMoney.doubleValue()),2));
		    				}else{
		    					percentMap.put("percent","");
			    				percentMap.put("percentDec","");
		    				}
		    				list.add(percentMap);
		    			}else{
		    				percentMap.put("proName","其他");
		    				percentMap.put("totalMoney",Arith.round(otherCostMoney,2));
		    				if(bcd.getTotalMoney().compareTo(new BigDecimal("0"))==1 && totalCostMoney .compareTo(new BigDecimal("0"))==1 ){
		    				percentMap.put("percent", SystemUtil.getPercent(otherCostMoney.doubleValue(), totalCostMoney.doubleValue()));
		    				percentMap.put("percentDec", Arith.round(SystemUtil.getPercentDec(otherCostMoney.doubleValue(), totalCostMoney.doubleValue()),2));
		    				}else{
		    					percentMap.put("percent","");
			    				percentMap.put("percentDec","");
		    				}
		    				list.add(percentMap);
		    				break;
		    			}
					}
		    		returnMap.put("totalCost",totalCostMoney);
		    	}
		    	returnMap.put("bcds",list);
		    	return returnMap;
         }
     
    
    
}
