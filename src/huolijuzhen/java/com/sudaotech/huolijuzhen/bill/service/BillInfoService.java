package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntity;
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordService.BillCollectionRecord;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.BillPayVoucherService.BillPayVoucher;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;

public interface BillInfoService extends BaseService {

    public BillInfo getById(Long id);

    public Long create(BillInfo obj);

    public void update(BillInfo obj);

    public Long save(BillInfo obj);

    public Page<BillInfo> find(Query query);
    
    public List<BillInfo> findByObj(BillInfoQuery billInfoQuery);
    
    public List<Map<String, Object>> statisticsByCostPro(Map<String, Object> params);
    
    public Page<BillInfo> findUrgeByPage(Query query,BillInfo bi);
    
    //获取企业名称、合同号
	public Page<BillInfo> findByCondition(QueryCondition queryConditions);
	//当前年应收总额
	public BigDecimal totalAmountYear(Map<String, Object> params);
    //累计欠款
    public BigDecimal addUpDebt(Map<String, Object> params);
    //当前年累计欠款
    public BigDecimal addUpDebtYear(Map<String, Object> params);
    
    //欠款本期到账
    public BigDecimal repayDebt(Map<String, Object> params);
    //本期应收总额
    public BigDecimal totalAmount(Map<String, Object> params);
    //本期已核销总额
    public BigDecimal alreadyVerification(Map<String, Object> params);
    //本期已挂起总额
    public BigDecimal suspendVerification(Map<String, Object> params);
    //本期待核销总额
    public BigDecimal waitVerification(Map<String, Object> params);
    
    //已核销账单金额
	public BigDecimal findAlreadyWrittenMoney(Map<String, Object> params);
	//已完结部分的核销金额
	public BigDecimal findAlreadyFinished(Map<String, Object> params);
	//已挂起部分的核销金额
	public BigDecimal findAlreadySuspen(Map<String, Object> params);
	//单月账单总额
	public BigDecimal findTotalMoney(Map<String, Object> params);

	
    /**
     * 描述：通过合同Id,账单月份查询账单
     * @param parkId
     * @param enterpriseId
     * @param month
     * @return
     */
    public BillInfo findBillByContractAndMonth(Long contractId,String billMonth);
    
    public static class Query extends Pagination {
    	
    	private Long parkId;
    	
        private String billNo;
        
        private Long companyId;
        
        private String companyName;
        
        private String billMonth;
        
        private Date validTime;

        private BillStatus billStatus;
        
        private BillSubmitStatus submitStatus;
        
        private BillApprovalStatus approvalStatus;
        
        private BillPushStatus pushStatus;
        
        private BillConfirmStatus confirmStatus;
        
        private BillVerificationStatus verificationStatus;
        
        private BillUrgePushStatus urgePushStatus;
        
        private boolean isSubmit;
        private boolean isApproval;
        private boolean isPush;
        private boolean isConfirm;
        private boolean isVerify;
        private boolean isUrge;
        
        
		public Long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}

		public String getBillNo() {
			return billNo;
		}

		public void setBillNo(String billNo) {
			this.billNo = billNo;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getBillMonth() {
			return billMonth;
		}

		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}

		public BillSubmitStatus getSubmitStatus() {
			return submitStatus;
		}

		public void setSubmitStatus(BillSubmitStatus submitStatus) {
			this.submitStatus = submitStatus;
		}

		public BillStatus getBillStatus() {
			return billStatus;
		}

		public void setBillStatus(BillStatus billStatus) {
			this.billStatus = billStatus;
		}

		public BillPushStatus getPushStatus() {
			return pushStatus;
		}

		public void setPushStatus(BillPushStatus pushStatus) {
			this.pushStatus = pushStatus;
		}

		public boolean isConfirm() {
			return isConfirm;
		}

		public void setConfirm(boolean isConfirm) {
			this.isConfirm = isConfirm;
		}

		public BillConfirmStatus getConfirmStatus() {
			return confirmStatus;
		}

		public void setConfirmStatus(BillConfirmStatus confirmStatus) {
			this.confirmStatus = confirmStatus;
		}

		public BillVerificationStatus getVerificationStatus() {
			return verificationStatus;
		}

		public void setVerificationStatus(BillVerificationStatus verificationStatus) {
			this.verificationStatus = verificationStatus;
		}

		public BillUrgePushStatus getUrgePushStatus() {
			return urgePushStatus;
		}

		public void setUrgePushStatus(BillUrgePushStatus urgePushStatus) {
			this.urgePushStatus = urgePushStatus;
		}

		public BillApprovalStatus getApprovalStatus() {
			return approvalStatus;
		}

		public void setApprovalStatus(BillApprovalStatus approvalStatus) {
			this.approvalStatus = approvalStatus;
		}

		public boolean isSubmit() {
			return isSubmit;
		}

		public void setSubmit(boolean isSubmit) {
			this.isSubmit = isSubmit;
		}

		public boolean isApproval() {
			return isApproval;
		}

		public void setApproval(boolean isApproval) {
			this.isApproval = isApproval;
		}

		public boolean isPush() {
			return isPush;
		}

		public void setPush(boolean isPush) {
			this.isPush = isPush;
		}

		public boolean isVerify() {
			return isVerify;
		}

		public void setVerify(boolean isVerify) {
			this.isVerify = isVerify;
		}

		public boolean isUrge() {
			return isUrge;
		}

		public void setUrge(boolean isUrge) {
			this.isUrge = isUrge;
		}

		public Date getValidTime() {
			return validTime;
		}

		public void setValidTime(Date validTime) {
			this.validTime = validTime;
		}
    }
    
    public static class QueryCondition extends Pagination {
    	
    	private Long companyId;
    	private Long contractId;
    	private String billMonth;
		public Long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		public Long getContractId() {
			return contractId;
		}

		public void setContractId(Long contractId) {
			this.contractId = contractId;
		}

		public String getBillMonth() {
			return billMonth;
		}

		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}
    }
    
    public static class BillInfoQuery extends BillInfo{
    	
    }
    
    //批量账单生成使用
    
    public static class BatchBill{
    	
    	private Long  companyId;
    	private String  companyName;
    	private Long  contractId;
    	
    	private String  contractNo;
    	private String  billMonth;
    	
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Long getContractId() {
			return contractId;
		}
		public void setContractId(Long contractId) {
			this.contractId = contractId;
		}
		public String getContractNo() {
			return contractNo;
		}
		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}
		public String getBillMonth() {
			return billMonth;
		}
		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}
    	
    	
    	
    }
    
    
    public static class BillInfo extends BillInfoEntity {
    	
    	//账单打印地址
    	private String printUrl;
    	//费用详情
    	public List<BillCostDetail> bcds;

    	//支付凭证
    	public List<BillPayVoucher> bpvs;
    	
    	//收款记录
    	public List<BillCollectionRecord> bcrs;
    	
    	//创建人
    	public String createUserName;
    	
    	
		public List<BillPayVoucher> getBpvs() {
			return bpvs;
		}

		public void setBpvs(List<BillPayVoucher> bpvs) {
			this.bpvs = bpvs;
		}

		public List<BillCostDetail> getBcds() {
			return bcds;
		}

		public void setBcds(List<BillCostDetail> bcds) {
			this.bcds = bcds;
		}

		public List<BillCollectionRecord> getBcrs() {
			return bcrs;
		}

		public void setBcrs(List<BillCollectionRecord> bcrs) {
			this.bcrs = bcrs;
		}

		public String getCreateUserName() {
			return createUserName;
		}

		public void setCreateUserName(String createUserName) {
			this.createUserName = createUserName;
		}

		public String getPrintUrl() {
			return printUrl;
		}

		public void setPrintUrl(String printUrl) {
			this.printUrl = printUrl;
		}
		
    }



}
