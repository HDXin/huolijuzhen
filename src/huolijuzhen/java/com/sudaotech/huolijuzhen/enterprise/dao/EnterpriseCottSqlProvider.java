package com.sudaotech.huolijuzhen.enterprise.dao;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;

public class EnterpriseCottSqlProvider  {
	
    public String countByObj(EnterpriseCott example) {
    	StringBuffer sb=new StringBuffer();
    	sb.append(" select count(1)");
        sb.append(" from enterprise_cott ec LEFT JOIN enterprise_info ei");
        sb.append(" on ec.enterpriseId = ei.id");
        sb.append(" LEFT JOIN park_info pi on ec.parkId=pi.id ");
        sb.append(" where 1=1 ");
        
        if(example.getParkId() != null && example.getParkId() !=0){
             sb.append(" and ec.parkId = "+example.getParkId());
        }
        if(example.getEnterpriseId() !=null && example.getEnterpriseId() !=0){
             sb.append(" and ec.enterpriseId = "+example.getEnterpriseId());	
        }
        if(StringUtils.isNotBlank(example.getEnterpriseName())){
        	 sb.append(" and ei.name like '%"+example.getEnterpriseName()+"%'");	
        }
        
        if(example.getCorrStatus() != null){
        	sb.append(" and ec.corrStatus = "+example.getCorrStatus().code());
        }else{
        	sb.append(" and ec.corrStatus between 1 and 2");
        }
        return sb.toString();
    }
    
    public String selectByObj(EnterpriseCott example) {
    	
    	StringBuffer sb=new StringBuffer();
    	sb.append(" select ec.id ,ec.corrType,ec.corrStatus,ec.parkId,ei.id as enterpriseId,ei.createSource,");
        sb.append(" ei.name,ei.contacts,ei.phone ,ei.type,ei.code ,pi.name as parkName");
        sb.append(" from enterprise_cott ec LEFT JOIN enterprise_info ei");
        sb.append(" on ec.enterpriseId = ei.id");
        sb.append(" LEFT JOIN park_info pi on ec.parkId=pi.id ");
        
        sb.append(" where 1=1 ");
        
        if(example.getParkId() != null && example.getParkId() !=0){
        	sb.append(" and ec.parkId = "+example.getParkId());
        }
        if(example.getEnterpriseId() !=null && example.getEnterpriseId() !=0){
            sb.append(" and ec.enterpriseId = "+example.getEnterpriseId());	
        }
        if(StringUtils.isNotBlank(example.getEnterpriseName())){
       	    sb.append(" and ei.name like '%"+example.getEnterpriseName()+"%'");	
        }
        
        if(example.getCorrStatus() != null){
        	sb.append(" and ec.corrStatus = "+example.getCorrStatus().code());
        }else{
        	sb.append(" and ec.corrStatus between 1 and 2");
        }
        
        return sb.toString();
        
    }


}
