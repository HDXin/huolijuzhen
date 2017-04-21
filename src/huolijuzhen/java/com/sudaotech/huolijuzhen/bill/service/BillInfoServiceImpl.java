package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillInfoMapper;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.user.dao.AdminUserEntity;
import com.sudaotech.user.dao.handler.LocationAdminUserEntityMapper;
import com.sudaotech.util.BeanUtils;

public class BillInfoServiceImpl extends BaseServiceImpl implements BillInfoService {
	private static final String TRACKING_TYPE = "BillInfo";

    @Inject
    private BillInfoMapper billInfoMapper;
    
    @Inject
    private LocationAdminUserEntityMapper adminUserEntityMapper;

	@Override
	public BillInfo getById(Long id) {
		BillInfoEntity entity = this.billInfoMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillInfo.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillInfo obj) {
		logger.debug("Creating BillInfo: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL));
		
		BillInfoEntity entity = BeanUtils.copyProperties(obj, BillInfoEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billInfoMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillInfo: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillInfo obj) {
		logger.debug("Updating BillInfo: {}", obj);

		BillInfoEntity entity = BeanUtils.copyProperties(obj, BillInfoEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billInfoMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillInfo: {}", obj);
	}

	@Override
	public Long save(BillInfo obj) {
		logger.debug("Saving BillInfo: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillInfo> find(Query query) {
		Page<BillInfo> page = new Page<BillInfo>(query);
		BillInfoEntityExample example = new BillInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(query.getParkId() !=null){
		  criteria.andParkIdEqualTo(query.getParkId());	
		}
		if(query.getCompanyId() !=null){
		  criteria.andCompanyIdEqualTo(query.getCompanyId());	
		}
		if(StringUtils.isNotBlank(query.getBillNo())){
          criteria.andBillNoEqualTo(query.getBillNo());			
		}
		if(StringUtils.isNotBlank(query.getCompanyName())){
	      criteria.andCompanyNameLike("%"+query.getCompanyName()+"%");			
		}
		if(StringUtils.isNotBlank(query.getBillMonth())){
	      criteria.andBillMonthEqualTo(query.getBillMonth());			
		}
		if(query.getBillStatus() !=null){
		  criteria.andBillStatusEqualTo(query.getBillStatus());			
		}
		
		//提交
		if(query.isSubmit()){
			if(query.getSubmitStatus() !=null){
				  criteria.andSubmitStatusEqualTo(query.getSubmitStatus());			
			}
		}
		
		//审核
		if(query.isApproval()){
			List<BillApprovalStatus> list=new ArrayList<BillApprovalStatus>();
			list.add(BillApprovalStatus.APPROVAL_FAIL);
			list.add(BillApprovalStatus.APPROVAL_PASS);
			list.add(BillApprovalStatus.PENDING_APPROVAL);
			criteria.andApprovalStatusIn(list);	
			if(query.getApprovalStatus() !=null){
				  criteria.andApprovalStatusEqualTo(query.getApprovalStatus());			
			}
		}
		//推送
		if(query.isPush()){
			if(query.getPushStatus() == null){
				List<BillPushStatus> list=new ArrayList<BillPushStatus>();
				list.add(BillPushStatus.ALREADY_PUSH);
				list.add(BillPushStatus.WAIT_PUSH);
				criteria.andPushStatusIn(list);	
			}else{
				//账单状态为 推送、缴款确认、核销
				List<BillStatus> billStatusList = new ArrayList<BillStatus>();
				billStatusList.add(BillStatus.PUSH);
				billStatusList.add(BillStatus.PAYMENT);
				billStatusList.add(BillStatus.WRITTEN);
				criteria.andBillStatusIn(billStatusList);

				//账单推送状态： 已推送
				criteria.andPushStatusEqualTo(query.getPushStatus());			
		    }
		}
		//缴款确认
		if(query.isConfirm()){
			List<BillConfirmStatus> list=new ArrayList<BillConfirmStatus>();
			list.add(BillConfirmStatus.WAIT_CONFIRM);
			list.add(BillConfirmStatus.ALREADY_CONFIRM);
			criteria.andConfirmStatusIn(list);	
			//主状态必须不为已经作废
			criteria.andBillStatusNotEqualTo(BillStatus.INVALID);
			
			if(query.getConfirmStatus() !=null){
				  criteria.andConfirmStatusEqualTo(query.getConfirmStatus());			
			}
			
		}
		//核销
		if(query.isVerify()){

			if(query.getVerificationStatus() !=null){
				criteria.andBillStatusEqualTo(BillStatus.WRITTEN);
				criteria.andVerificationStatusEqualTo(query.getVerificationStatus());			
			}else {
				List<BillStatus> billStatusList = new ArrayList<BillStatus>();
				billStatusList.add(BillStatus.PAYMENT);
				billStatusList.add(BillStatus.WRITTEN);
				criteria.andBillStatusIn(billStatusList);

				List<BillVerificationStatus> list=new ArrayList<BillVerificationStatus>();
				list.add(BillVerificationStatus.WAIT_WRITTEN);
				list.add(BillVerificationStatus.ALREADY_WRITTEN);
				list.add(BillVerificationStatus.ALREADY_SUSPEND);
				list.add(BillVerificationStatus.ALREADY_FINISHED);
				criteria.andVerificationStatusIn(list);	
			}
		}
		//催缴
		if(query.isUrge()){
			
		}
		
		example.setOrderByClause("id DESC");
		
		
		page.setTotal(this.billInfoMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillInfoEntity> list = this.billInfoMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			List<BillInfo> billList= BeanUtils.copyListProperties(list, BillInfo.class);
			for (BillInfo billInfo : billList) {
				//创建人
				AdminUserEntity au=adminUserEntityMapper.selectByPrimaryKey(billInfo.getCreateBy());
				billInfo.setCreateUserName(au == null ?null:au.getUsername());
			}
			page.setItems(billList);
			
		}
		
		return page;
	}

	@Override
	public BillInfo findBillByContractAndMonth(Long contractId,String billMonth) {
		
		BillInfoEntityExample example = new BillInfoEntityExample();
		
		if(contractId == null || StringUtils.isBlank(billMonth)){
		   return null;
		}
		
		Criteria criteria = example.createCriteria();
		
		criteria.andStatusEqualTo(Status.NORMAL);
		
		criteria.andContractIdEqualTo(contractId);
		
		criteria.andBillMonthEqualTo(billMonth);
		
		criteria.andBillStatusNotEqualTo(BillStatus.INVALID);
		
		example.setOrderByClause("id DESC");
		List<BillInfoEntity> list = this.billInfoMapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(list)){
			return BeanUtils.copyListProperties(list, BillInfo.class).get(0);
		}
		
		return null;
		
	}

	@Override
	public Page<BillInfo> findUrgeByPage(Query query,BillInfo bi) {
		
		Page<BillInfo> page = new Page<BillInfo>(query);
		
		page.setTotal(this.billInfoMapper.countByObj(bi));
		
		if (page.getTotal() > query.getOffset()) {
			
			List<BillInfoEntity> lists = this.billInfoMapper.selectByPage(bi, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(lists, BillInfo.class));
		}
		return page;
		
	}

	@Override
	public List<Map<String, Object>> statisticsByCostPro(
			Map<String, Object> params) {
		return this.billInfoMapper.statisticsByCostPro(params);
	}

	/**
	 * 累计欠款
	 */
	@Override
	public BigDecimal addUpDebt(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		//1.待支付
		BigDecimal waitPay = this.billInfoMapper.waitPayBillTotalAmount(params);
		waitPay = valideDecimal(waitPay);
		
		//2.待核销
		BigDecimal waitVerificationTotal = this.billInfoMapper.waitVerificationBillTotalAmount(params);
		BigDecimal waitVerificationAlreadyCollection = this.billInfoMapper.waitVerificationBillAlreadyCollection(params);
		waitVerificationTotal = sub(waitVerificationTotal, waitVerificationAlreadyCollection);
		
		//3.已挂起
		BigDecimal alreadySuspendTotal = this.billInfoMapper.alreadySuspendBillTotalAmount(params);
		BigDecimal alreadySuspendAlreadyCollection = this.billInfoMapper.alreadySuspendBillAlreadyCollection(params);
		alreadySuspendTotal = sub(alreadySuspendTotal, alreadySuspendAlreadyCollection);
		
		BigDecimal addUpDebt = waitPay.add(waitVerificationTotal).add(alreadySuspendTotal);
		return addUpDebt;
	}
	
	/**
	 * 当前年累计欠款
	 */
	@Override
	public BigDecimal addUpDebtYear(Map<String, Object> params) {

		//1.待支付
		BigDecimal waitPay = this.billInfoMapper.waitPayBillTotalAmountYear(params);
		waitPay = valideDecimal(waitPay);
		
		//2.待核销
		BigDecimal waitVerificationTotal = this.billInfoMapper.waitVerificationBillTotalAmountYear(params);
		BigDecimal waitVerificationAlreadyCollection = this.billInfoMapper.waitVerificationBillAlreadyCollectionYear(params);
		waitVerificationTotal = sub(waitVerificationTotal, waitVerificationAlreadyCollection);
		
		//3.已挂起
		BigDecimal alreadySuspendTotal = this.billInfoMapper.alreadySuspendBillTotalAmountYear(params);
		BigDecimal alreadySuspendAlreadyCollection = this.billInfoMapper.alreadySuspendBillAlreadyCollectionYear(params);
		alreadySuspendTotal = sub(alreadySuspendTotal, alreadySuspendAlreadyCollection);
		
		BigDecimal addUpDebt = waitPay.add(waitVerificationTotal).add(alreadySuspendTotal);
		return addUpDebt;
	}
	
	
	/**
	 * 欠款本期到账
	 */
	@Override
	public BigDecimal repayDebt(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		BigDecimal repayDebt = this.billInfoMapper.alreadyDebtBillCurrentRepayment(params);
		repayDebt = valideDecimal(repayDebt);
		return repayDebt;
	}
	/**
	 * 本期应收总额
	 */
	@Override
	public BigDecimal totalAmount(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		//本期账单总额
		BigDecimal totalAmount = this.billInfoMapper.currentAllBillTotalAmount(params);
		//本期账单已收金额
		BigDecimal alreadyCollection = this.billInfoMapper.currentAllBillAlreadyCollection(params);
		totalAmount = sub(totalAmount, alreadyCollection);
		return totalAmount;
	}
	
	/**
	 * 当前年应收总额
	 */
	@Override
	public BigDecimal totalAmountYear(Map<String, Object> params) {
		//本期账单总额
		BigDecimal totalAmount = this.billInfoMapper.currentAllBillTotalAmountYear(params);
		//本期账单已收金额
		BigDecimal alreadyCollection = this.billInfoMapper.currentAllBillAlreadyCollectionYear(params);
		totalAmount = sub(totalAmount, alreadyCollection);
		return totalAmount;
	}
	
	/**
	 * 本期已核销总额
	 */
	@Override
	public BigDecimal alreadyVerification(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		BigDecimal alreadyVerification = this.billInfoMapper.currentAllBillAlreadyVerification(params);
		alreadyVerification = valideDecimal(alreadyVerification);
		return alreadyVerification;
	}
	/**
	 * 本期已挂起总额
	 */
	@Override
	public BigDecimal suspendVerification(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		//1.已挂起账单总额
		BigDecimal total = this.billInfoMapper.currentSuspendBillTotalAmount(params);
		//2.已挂起账单已收金额
		BigDecimal alreadyCollection = this.billInfoMapper.currentSuspendBillAlreadyCollection(params);

		BigDecimal suspendVerification = sub(total, alreadyCollection);
		return suspendVerification;
	}
	/**
	 * 本期待核销总额
	 */
	@Override
	public BigDecimal waitVerification(Map<String, Object> params) {
		Object billMonth = params.get("billMonth");
		if(billMonth == null || StringUtils.isBlank((String)billMonth)){
			params.put("billMonth", SystemUtil.dateFormat(new Date(), "yyyy-MM"));
		}
		//1.待核销账单总额
		BigDecimal total = this.billInfoMapper.currentWaitVerificationBillTotalAmount(params);
		//2.待核销账单已收款金额
		BigDecimal alreadyCollection = this.billInfoMapper.currentWaitVerificationBillAlreadyCollection(params);
		
		BigDecimal waitVerification = sub(total, alreadyCollection);
		return waitVerification;
	}
	
	/**
	 * 求差
	 * @param minuend
	 * @param subtrahend
	 * @return
	 */
	private BigDecimal sub(BigDecimal minuend,BigDecimal subtrahend){
		
		BigDecimal zero = new BigDecimal("0");
		//2.待核销
		if(minuend != null){
			if(subtrahend != null){
				minuend = minuend.subtract(subtrahend);
			}
		}else{
			minuend = zero;
		}
		return minuend;
	}
	
	private BigDecimal valideDecimal(BigDecimal bigDecimal){
		if(bigDecimal == null){
			bigDecimal = new BigDecimal("0");
		}
		return bigDecimal;
	}

	@Override
	public Page<BillInfo> findByCondition(
			QueryCondition queryConditions) {
		Page<BillInfo> page = new Page<BillInfo>(queryConditions);
		BillInfoEntityExample example = new BillInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		//企业名称不为空
		Long companyId = queryConditions.getCompanyId();
		if(companyId != null){
			criteria.andCompanyIdEqualTo(companyId);
		}

		//合同号不为空
		Long contractId = queryConditions.getContractId();
		if(contractId != null){
			criteria.andContractIdEqualTo(contractId);
		}
		
		//账单期间不为空
		String billMonth = queryConditions.getBillMonth();
		if(StringUtils.isNotBlank(billMonth)){
			criteria.andBillMonthEqualTo(billMonth);
		}
		
		example.setOrderByClause("companyId DESC");
		page.setTotal(this.billInfoMapper.countByExample(example));
		page.setSortField("companyId");
		if (page.getTotal() > queryConditions.getOffset()) {
			List<BillInfoEntity> list = this.billInfoMapper.selectByExampleWithRowbounds(example, this.toRowBounds(queryConditions));
			List<BillInfo> billList= BeanUtils.copyListProperties(list, BillInfo.class);
			for (BillInfo billInfo : billList) {
				//创建人
				AdminUserEntity au=adminUserEntityMapper.selectByPrimaryKey(billInfo.getCreateBy());
				billInfo.setCreateUserName(au == null ?null:au.getUsername());
			}
			page.setItems(billList);
		}
		return page;
	}

	@Override
	public BigDecimal findAlreadyWrittenMoney(Map<String, Object> params) {
		
		BillInfoEntityExample example = new BillInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		//账单期间不为空
		String billMonth = (String)params.get("billMonth");
		if(StringUtils.isNotBlank(billMonth)){
			criteria.andBillMonthEqualTo(billMonth);
		}
		
		//当前园区
		Long parkId = (Long)params.get("parkId");
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		List<BillInfo> billInfos = BeanUtils.copyListProperties(this.billInfoMapper.selectByExample(example), BillInfo.class);
		if(CollectionUtils.isEmpty(billInfos)){
			return new BigDecimal(0);
		}
		
		//账单状态为已核销
		criteria.andBillStatusEqualTo(BillStatus.WRITTEN);
		criteria.andVerificationStatusEqualTo(BillVerificationStatus.ALREADY_WRITTEN);
		
		BigDecimal alreadyWrttenMoney = new BigDecimal(0);
		for(BillInfo billInfo:billInfos){
			alreadyWrttenMoney = alreadyWrttenMoney.add(billInfo.getTotalAmount());
		}
		return alreadyWrttenMoney;
		
	}

	@Override
	public BigDecimal findAlreadyFinished(Map<String, Object> params) {
		BigDecimal alreadyFinished = this.billInfoMapper.findAlreadyFinished(params);
		if(alreadyFinished == null || alreadyFinished.compareTo(new BigDecimal(0)) != 1){
			return new BigDecimal(0);
		}
		return alreadyFinished;
	}

	@Override
	public BigDecimal findAlreadySuspen(Map<String, Object> params) {
		BigDecimal alreadySuspen = this.billInfoMapper.findAlreadySuspen(params);
		if(alreadySuspen == null || alreadySuspen.compareTo(new BigDecimal(0)) != 1){
			return new BigDecimal(0);
		}
		return alreadySuspen;
	}

	@Override
	public BigDecimal findTotalMoney(Map<String, Object> params) {

		BillInfoEntityExample example = new BillInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		//账单期间不为空
		String billMonth = (String)params.get("billMonth");
		if(StringUtils.isNotBlank(billMonth)){
			criteria.andBillMonthEqualTo(billMonth);
		}
		
		//当前园区
		Long parkId = (Long)params.get("parkId");
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		List<BillInfo> billInfos = BeanUtils.copyListProperties(this.billInfoMapper.selectByExample(example), BillInfo.class);
		if(CollectionUtils.isEmpty(billInfos)){
			return new BigDecimal(0);
		}
		//账单状态为已核销
		criteria.andBillStatusEqualTo(BillStatus.WRITTEN);
		BigDecimal alreadyWrttenMoney = new BigDecimal(0);
		for(BillInfo billInfo:billInfos){
			alreadyWrttenMoney = alreadyWrttenMoney.add(billInfo.getTotalAmount());
		}
		return alreadyWrttenMoney;
	}

	@Override
	public List<BillInfo> findByObj(BillInfoQuery billInfoQuery) {
		BillInfoEntityExample example = new BillInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		//企业名称不为空
		Long companyId = billInfoQuery.getCompanyId();
		if(companyId != null){
			criteria.andCompanyIdEqualTo(companyId);
		}

		//合同号不为空
		Long contractId = billInfoQuery.getContractId();
		if(contractId != null){
			criteria.andContractIdEqualTo(contractId);
		}
		
		//账单期间不为空
		String billMonth = billInfoQuery.getBillMonth();
		if(StringUtils.isNotBlank(billMonth)){
			criteria.andBillMonthEqualTo(billMonth);
		}
		example.setOrderByClause("companyId DESC");
		return BeanUtils.copyListProperties(this.billInfoMapper.selectByExample(example), BillInfo.class);
	}
}
