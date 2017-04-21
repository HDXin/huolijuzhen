package com.sudaotech.huolijuzhen.bill.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BillInfo;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;

public class BillInfoSqlProvider extends BillInfoEntitySqlProvider {

    public String countByObj(BillInfo example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bill_info bi");
        
        StringBuffer sb =new StringBuffer("bi.status =1");
        if(StringUtils.isNotBlank(example.getBillNo())){
        	sb.append(" and billNo = "+example.getBillNo());
        }
        if(StringUtils.isNotBlank(example.getCompanyName())){
        	sb.append(" and companyName like %"+example.getCompanyName()+"%");
        }
        if(StringUtils.isNotBlank(example.getBillMonth())){
        	sb.append(" and billMonth = "+example.getBillMonth());
        }
        if(null != example.getParkId()){
        	sb.append(" and parkId = "+example.getParkId());
        }
        if(example.getBillStatus() != null){
        	sb.append(" and billStatus = "+example.getBillStatus().code());
        }
        if(example.getUrgePushStatus() != null){
        	if(example.getUrgePushStatus() == BillUrgePushStatus.ALREADY_URGE){
        		sb.append(" and urgePushStatus = "+example.getUrgePushStatus().code());
        	}else{
        		 sb.append(" and pushStatus ="+BillPushStatus.ALREADY_PUSH.code());
        		 sb.append(" and pushTime  <  #{pushTime,jdbcType=TIMESTAMP} ");
        	}
        }
        else{
        	 sb.append(" and pushStatus ="+BillPushStatus.ALREADY_PUSH.code());
	        sb.append(" and pushTime  < #{pushTime,jdbcType=TIMESTAMP} ");
	        sb.append(" or urgePushStatus = "+BillUrgePushStatus.ALREADY_URGE.code());
	    }
        WHERE(sb.toString());
        
        return SQL();
    }

    public String selectByPage(BillInfo example) {
        BEGIN();
        SELECT("id");
        SELECT("billNo");
        SELECT("parkId");
        SELECT("companyId");
        SELECT("companyName");
        SELECT("contractId");
        SELECT("contractNo");
        SELECT("billMonth");
        SELECT("totalMoney");
        SELECT("totalTaxMoney");
        SELECT("reliefMoney");
        SELECT("reliefRemark");
        SELECT("totalAmount");
        SELECT("billStatus");
        SELECT("submitStatus");
        SELECT("submitBy");
        SELECT("submitTime");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("pushStatus");
        SELECT("pushBy");
        SELECT("pushTime");
        SELECT("confirmStatus");
        SELECT("confirmBy");
        SELECT("confirmTime");
        SELECT("verificationStatus");
        SELECT("verificationBy");
        SELECT("verificationTime");
        SELECT("urgePushStatus");
        SELECT("urgeBy");
        SELECT("urgeTime");
        SELECT("payBank");
        SELECT("paySerialNumber");
        SELECT("nextAdjust");
        SELECT("adjustAmount");
        SELECT("adjustRemark");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("bill_info bi");
        
        StringBuffer sb =new StringBuffer("bi.status =1");
        if(StringUtils.isNotBlank(example.getBillNo())){
        	sb.append(" and billNo = "+example.getBillNo());
        }
        if(StringUtils.isNotBlank(example.getCompanyName())){
        	sb.append(" and companyName like %"+example.getCompanyName()+"%");
        }
        if(StringUtils.isNotBlank(example.getBillMonth())){
        	sb.append(" and billMonth = "+example.getBillMonth());
        }
        if(null != example.getParkId()){
        	sb.append(" and parkId = "+example.getParkId());
        }
        if(example.getBillStatus() != null){
        	sb.append(" and billStatus = "+example.getBillStatus().code());
        }
        if(example.getUrgePushStatus() != null){
        	if(example.getUrgePushStatus() == BillUrgePushStatus.ALREADY_URGE){
        		sb.append(" and urgePushStatus = "+example.getUrgePushStatus().code());
        	}else{
        		sb.append(" and pushStatus ="+BillPushStatus.ALREADY_PUSH.code());
        		sb.append(" and pushTime  <  #{pushTime,jdbcType=TIMESTAMP} ");
        	}
        }else{
        	sb.append(" and ( pushStatus ="+BillPushStatus.ALREADY_PUSH.code());
	        sb.append(" and pushTime  <  #{pushTime,jdbcType=TIMESTAMP} ");
	        sb.append(" or urgePushStatus = "+BillUrgePushStatus.ALREADY_URGE.code() +" )");
	    }
        WHERE(sb.toString());
        
        ORDER_BY("id DESC") ;
         
        return SQL();
    }
    
    /**
     * 账单汇总统计（费用项目）
     * @param params
     * @return
     */
    public String statisticsByCostPro(Map<String, Object> params){
    	StringBuilder sql = new StringBuilder();
    	Object billMonthObj = params.get("billMonth");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Long parkId = (Long)params.get("parkId");
    	
    	
    	sql.append("select bcd.costProName title,sum(bcd.totalMoney) totalMoney,sum(bcd.verifyMoney) verifyMoney  from bill_cost_detail bcd");
    	sql.append(" LEFT JOIN bill_info bi ON bi.id = bcd.billId");
    	sql.append(" where 1=1 ");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonthObj != null && StringUtils.isNotBlank((String)billMonthObj)){
    		sql.append(" and bi.billMonth = '" + (String)billMonthObj + "'");
    	}
    	sql.append(" group by bcd.costProName");
    	sql.append(" order by bcd.costProName");
    	
    	return sql.toString();
    }
    
    /**
     * 累计欠款
     * 
     * 待支付确认：账单总额
     * 
     * @param params
     * @return
     */
    public String waitPayBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.PAYMENT.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("累计欠款 -> 待支付确认 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 累计欠款
     * 
     * 待核销部分：账单总额 - 已收款金额
     * 
     * 待核销账单总额
     * @param params
     * @return
     */
    public String waitVerificationBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.WAIT_WRITTEN.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("累计欠款 -> 待核销部分 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 累计欠款
     * 
     * 待核销部分：账单总额 - 已收款金额
     * 
     * 待核销账单已收总额
     * @param params
     * @return
     */
    public String waitVerificationBillAlreadyCollection(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
    		sql.append(" and DATE_FORMAT(bcr.collectionTime,'%Y-%m') < '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billid in(");
    	
    	sql.append("select distinct(bi.id) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.WAIT_WRITTEN.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	sql.append(")");
    	System.out.println("累计欠款 -> 待核销部分 -> 已收款金额：" + sql.toString());
    	return sql.toString();
    }
    
    
    /**
     * 累计欠款
     * 
     * 已挂起部分：账单总额 - 已收款金额
     * 
     * 已挂起账单已收款
     * @param params
     * @return
     */
    public String alreadySuspendBillAlreadyCollection(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
    		sql.append(" and DATE_FORMAT(bcr.collectionTime,'%Y-%m') < '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billid in(");
    	
    	sql.append("select distinct(bi.id) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_SUSPEND.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	sql.append(")");
    	System.out.println("累计欠款 -> 已挂起部分 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 累计欠款
     * 
     * 已挂起部分：账单总额 - 已收款金额
     * 
     * 已挂起账单总额
     * @param params
     * @return
     */
    public String alreadySuspendBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select distinct(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_SUSPEND.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("累计欠款 -> 已挂起部分 -> 已收款金额：" + sql.toString());
    	return sql.toString();
    }
    
    
    /**
     * 欠款本期还款
     * 
     * 欠款本期还款账单的本月收款总额
     * 
     * @param params
     * @return
     */
    public String alreadyDebtBillCurrentRepayment(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount)  from bill_collection_record bcr ");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and DATE_FORMAT(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
    	sql.append("select DISTINCT(bi.id) from bill_info bi");
    	sql.append(" where 1=1 ");
    	sql.append(" and bi.status = 1");
    	sql.append(" and (");
    	sql.append("(bi.billStatus = 5 and bi.verificationStatus = 1)");
    	sql.append(" or ");
    	sql.append("(bi.billStatus = 5 and bi.verificationStatus = 2)");
    	sql.append(")");
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth < '" + billMonth + "'");
    	}
    	sql.append(")");
    	System.out.println("欠款本期到账：" + sql.toString());
    	return sql.toString();
    }
    
    
    /**
     * 本期应收总额
     * 
     * 本期所有账单应收总额
     * 
     * @param params
     * @return
     */
    public String currentAllBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth = '" + billMonth + "'");
    	}
    	sql.append(" and (");
    	sql.append("bi.billStatus = 3");
    	sql.append(" or bi.billStatus = 4");
    	sql.append(" or (bi.billStatus = 2 and bi.approvalStatus = 2)");
    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus != 4)");
    	
    	sql.append(")");
    	System.out.println("本期所有账单应收总额：" + sql.toString());
   	
    	return sql.toString();
    }
    
    /**
     * 本期应收总额
     * 
     * 本期所有账单已收总额
     * 
     * @param params
     * @return
     */
    public String currentAllBillAlreadyCollection(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
    	
	    	sql.append("select distinct(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(companyId != null){
	    		sql.append(" and bi.companyId = " + companyId);
	    	}
	    	if(contractId != null){
	        	sql.append(" and bi.contractId = " + contractId);
	    	}
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
	    	sql.append(" and (");
	    	sql.append("bi.billStatus = 3");
	    	sql.append(" or bi.billStatus = 4");
	    	sql.append(" or (bi.billStatus = 2 and bi.approvalStatus = 2)");
	    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus != 4)");
	    	
	    	sql.append(")");
    	
    	sql.append(")");
    	System.out.println("本期所有账单已收总额" + sql.toString());
    	return sql.toString();
    }
    

    /**
     * 本期已核销总额
     * 
     * 本期所有账单已核销总额
     * 
     * @param params
     * @return
     */
    public String currentAllBillAlreadyVerification(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
    	
	    	sql.append("select DISTINCT(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(companyId != null){
	    		sql.append(" and bi.companyId = " + companyId);
	    	}
	    	if(contractId != null){
	        	sql.append(" and bi.contractId = " + contractId);
	    	}
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
    	sql.append(")");
    	System.out.println("本期所有账单已核销总额:" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 本期已挂起账单总额
     * 
     * 本期已挂起的所有账单总额
     * 
     * @param params
     * @return
     */
    public String currentSuspendBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select SUM(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth = '" + billMonth + "'");
    	}
    	sql.append(" and bi.billStatus = 5");
    	sql.append(" and bi.verificationStatus = 3");
    	System.out.println("本期已挂起的所有账单总额：" + sql.toString());
    	
    	return sql.toString();
    }
    
    /**
     * 本期已挂起账单总额
     * 
     * 本期已挂起的所有账单已收款总额
     * 
     * @param params
     * @return
     */
    public String currentSuspendBillAlreadyCollection(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr ");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
    	
	    	sql.append("select DISTINCT(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(companyId != null){
	    		sql.append(" and bi.companyId = " + companyId);
	    	}
	    	if(contractId != null){
	        	sql.append(" and bi.contractId = " + contractId);
	    	}
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
	    	sql.append(" and bi.billStatus = 5");
	    	sql.append(" and bi.verificationStatus = 3");
    	sql.append(")");
    	System.out.println(" 本期已挂起的所有账单已收款总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 本期待核销账单总额
     * 
     * 本期待核销的所有账单总额
     * 
     * @param params
     * @return
     */
    public String currentWaitVerificationBillTotalAmount(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select SUM(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth = '" + billMonth + "'");
    	}
    	sql.append(" and (bi.billStatus = 4");
    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus = 1))");
    	System.out.println("本期待核销的所有账单总额:" + sql.toString());
    	
    	return sql.toString();
    }
    
    /**
     * 本期待核销账单总额
     * 
     * 本期待核销的所有账单的已收款总额
     * 
     * @param params
     * @return
     */
    public String currentWaitVerificationBillAlreadyCollection(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
	    	sql.append("select DISTINCT(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(companyId != null){
	    		sql.append(" and bi.companyId = " + companyId);
	    	}
	    	if(contractId != null){
	        	sql.append(" and bi.contractId = " + contractId);
	    	}
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
	    	sql.append(" and (bi.billStatus = 4");
	    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus = 1))");
    	sql.append(")");
    	System.out.println("本期待核销的所有账单的已收款总额:" + sql.toString());

    	return sql.toString();
    }
    
    
    /**
     * 已完结部分的核销金额
     * 
     * @param params
     * @return
     */
    public String findAlreadyFinished(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
	    	sql.append("select DISTINCT(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
	    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
	    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_FINISHED.code());
    	sql.append(")");
    	System.out.println("已完结部分的核销金额:" + sql.toString());

    	return sql.toString();
    }
    
    /**
     * 已挂起部分的核销金额
     * 
     * @param params
     * @return
     */
    public String findAlreadySuspen(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') = '" + billMonth + "'");
    	}
    	sql.append(" and bcr.billId in(");
	    	sql.append("select DISTINCT(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth = '" + billMonth + "'");
	    	}
	    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
	    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_SUSPEND.code());
    	sql.append(")");
    	System.out.println("已挂起部分的核销金额:" + sql.toString());

    	return sql.toString();
    }
    
    /**
     * 当前年应收总额
     * 
     * 当前年所有账单应收总额
     * 
     * @param params
     * @return
     */
    public String currentAllBillTotalAmountYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	sql.append(" and (");
    	sql.append("bi.billStatus = 3");
    	sql.append(" or bi.billStatus = 4");
    	sql.append(" or (bi.billStatus = 2 and bi.approvalStatus = 2)");
    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus != 4)");
    	
    	sql.append(")");
    	System.out.println("当前年 -> 本期所有账单应收总额：" + sql.toString());
   	
    	return sql.toString();
    }
    
    /**
     * 当前年应收总额
     * 
     * 当前年所有账单已收总额
     * 
     * @param params
     * @return
     */
    public String currentAllBillAlreadyCollectionYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and date_format(bcr.collectionTime,'%Y-%m') in" + billMonth);
    	}
    	sql.append(" and bcr.billId in(");
    	
	    	sql.append("select distinct(bi.id) from bill_info bi");
	    	sql.append(" where 1=1");
	    	sql.append(" and bi.status = " + Status.NORMAL.code());
	    	sql.append(" and bi.parkId = " + parkId);
	    	if(companyId != null){
	    		sql.append(" and bi.companyId = " + companyId);
	    	}
	    	if(contractId != null){
	        	sql.append(" and bi.contractId = " + contractId);
	    	}
	    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
	        	sql.append(" and bi.billMonth in" + billMonth);
	    	}
	    	sql.append(" and (");
	    	sql.append("bi.billStatus = 3");
	    	sql.append(" or bi.billStatus = 4");
	    	sql.append(" or (bi.billStatus = 2 and bi.approvalStatus = 2)");
	    	sql.append(" or (bi.billStatus = 5 and bi.verificationStatus != 4)");
	    	
	    	sql.append(")");
    	
    	sql.append(")");
    	System.out.println("当前年 -> 本期所有账单已收总额" + sql.toString());
    	return sql.toString();
    }
    
    
    /**
     * 当前年累计欠款
     * 
     * 待支付确认：账单总额
     * 
     * @param params
     * @return
     */
    public String waitPayBillTotalAmountYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.PAYMENT.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("当前年 -> 累计欠款 -> 待支付确认 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 当前年累计欠款
     * 
     * 待核销部分：账单总额 - 已收款金额
     * 
     * 待核销账单总额
     * @param params
     * @return
     */
    public String waitVerificationBillTotalAmountYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.WAIT_WRITTEN.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("当前年 -> 累计欠款 -> 待核销部分 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 当前年累计欠款
     * 
     * 待核销部分：账单总额 - 已收款金额
     * 
     * 待核销账单已收总额
     * @param params
     * @return
     */
    public String waitVerificationBillAlreadyCollectionYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
    		sql.append(" and DATE_FORMAT(bcr.collectionTime,'%Y-%m') in" + billMonth);
    	}
    	sql.append(" and bcr.billid in(");
    	
    	sql.append("select distinct(bi.id) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.WAIT_WRITTEN.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	sql.append(")");
    	System.out.println("当前年 -> 累计欠款 -> 待核销部分 -> 已收款金额：" + sql.toString());
    	return sql.toString();
    }
    
    
    /**
     * 当前年累计欠款
     * 
     * 已挂起部分：账单总额 - 已收款金额
     * 
     * 已挂起账单已收款
     * @param params
     * @return
     */
    public String alreadySuspendBillAlreadyCollectionYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	sql.append("select sum(bcr.collectionAmount) from bill_collection_record bcr");
    	sql.append(" where 1=1");
    	sql.append(" and bcr.status = " + Status.NORMAL.code());
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
    		sql.append(" and DATE_FORMAT(bcr.collectionTime,'%Y-%m') in" + billMonth);
    	}
    	sql.append(" and bcr.billid in(");
    	
    	sql.append("select distinct(bi.id) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_SUSPEND.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	sql.append(")");
    	System.out.println("当前年 -> 累计欠款 -> 已挂起部分 -> 账单总额：" + sql.toString());
    	return sql.toString();
    }
    
    /**
     * 当前年累计欠款
     * 
     * 已挂起部分：账单总额 - 已收款金额
     * 
     * 已挂起账单总额
     * @param params
     * @return
     */
    public String alreadySuspendBillTotalAmountYear(Map<String, Object> params){
    	
    	Long parkId = (Long)params.get("parkId");
    	Object companyId = params.get("companyId");
    	Object contractId = params.get("contractId");
    	Object billMonth = params.get("billMonth");
    	StringBuilder sql = new StringBuilder();
    	
    	sql.append("select distinct(bi.totalAmount) from bill_info bi");
    	sql.append(" where 1=1");
    	sql.append(" and bi.status = " + Status.NORMAL.code());
    	sql.append(" and bi.billStatus = " + BillStatus.WRITTEN.code());
    	sql.append(" and bi.verificationStatus = " + BillVerificationStatus.ALREADY_SUSPEND.code());
    	sql.append(" and bi.parkId = " + parkId);
    	if(billMonth != null && StringUtils.isNotBlank((String)billMonth)){
        	sql.append(" and bi.billMonth in" + billMonth);
    	}
    	if(companyId != null){
    		sql.append(" and bi.companyId = " + companyId);
    	}
    	if(contractId != null){
        	sql.append(" and bi.contractId = " + contractId);
    	}
    	System.out.println("当前年 -> 累计欠款 -> 已挂起部分 -> 已收款金额：" + sql.toString());
    	return sql.toString();
    }
}