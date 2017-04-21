package com.sudaotech.huolijuzhen.bill.service;

import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntity;
import com.sudaotech.huolijuzhen.bill.service.BillCcrAdjService.BillCcrAdj;
import com.sudaotech.huolijuzhen.bill.service.RollPeriodService.RollPeriod;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.ContractBill;

public interface BillCostCalRulesService extends BaseService {

    public BillCostCalRules getById(Long id);

    public Long create(BillCostCalRules obj);

    public void update(BillCostCalRules obj);

    public Long save(BillCostCalRules obj);

    public Page<BillCostCalRules> find(Query query);
    
    public List<BillCostCalRules> findByObj(BillCostCalRules bccr);
    
    public static class Query extends Pagination {
    }
    
    public static class BillCostCalRules extends BillCostCalRulesEntity {
    	
    	private List<BillCcrAdj> billCcrAdjs = new ArrayList<BillCcrAdjService.BillCcrAdj>();
    	
    	private List<RollPeriod> rollPeriods = new ArrayList<RollPeriodService.RollPeriod>();
    	
    	private List<ContractBill> contractBills = new ArrayList<ContractBillService.ContractBill>();

		public List<BillCcrAdj> getBillCcrAdjs() {
			return billCcrAdjs;
		}

		public void setBillCcrAdjs(List<BillCcrAdj> billCcrAdjs) {
			this.billCcrAdjs = billCcrAdjs;
		}

		public List<RollPeriod> getRollPeriods() {
			return rollPeriods;
		}

		public void setRollPeriods(List<RollPeriod> rollPeriods) {
			this.rollPeriods = rollPeriods;
		}

		public List<ContractBill> getContractBills() {
			return contractBills;
		}

		public void setContractBills(List<ContractBill> contractBills) {
			this.contractBills = contractBills;
		}

    }
    
    public static class ContractResourceInfo extends ResourceInfoEntity{
    	
    }
}
