package com.sudaotech.user.dao.handler;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;

public class LocationAdminUserEntitySqlProvider {

	 //获取平台下所有园区用户、企业用户
		public String findAllParkEnterpriseUserId(){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			
			sql.append(" and (");
			sql.append("(");
			sql.append("platformSource = " + PlatformSource.PARK.code());
			sql.append(" and platformSourceId != 0)");
			
			sql.append(" or ");
			sql.append("platformSource = "+ PlatformSource.ENTERPRISE.code());
			sql.append(")");
			sql.append(" and status = " + Status.NORMAL.code());
			return sql.toString();
		}
		//获取平台下所有园区用户
		public String findAllParkUserId(){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			sql.append(" and platformSource = " + PlatformSource.PARK.code());
			sql.append(" and platformSourceId != 0");
			sql.append(" and status = " + Status.NORMAL.code());
			return sql.toString();
		}

		//获取平台下所有企业用户
		public String findAllEnterpriseUerId(){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			sql.append(" and platformSource = " + PlatformSource.ENTERPRISE.code());
			sql.append(" and status = " + Status.NORMAL.code());
			return sql.toString();
		}

		//获取行政区下所有园区用户、企业用户
		public String findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(Map<String,Object> params){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			sql.append(" and status = " + Status.NORMAL.code());
			
			List<Long> parkIds = (List<Long>)params.get("parkIds");
			String parkIdStr = null;
			if(CollectionUtils.isNotEmpty(parkIds)){
				StringBuilder str = new StringBuilder();
				str.append("(");
				for(int i=0;i<parkIds.size();i++){
					str.append(parkIds.get(i));
					if(i<parkIds.size()-1){
						str.append(",");
					}
				}
				str.append(")");
				parkIdStr = str.toString();
			}
			
			List<Long> enterpriseIds = (List<Long>)params.get("enterpriseIds");
			String enterpriseIdStr = null;
			if(CollectionUtils.isNotEmpty(enterpriseIds)){
				StringBuilder str = new StringBuilder();
				str.append("(");
				for(int i=0;i<enterpriseIds.size();i++){
					str.append(enterpriseIds.get(i));
					if(i<enterpriseIds.size()-1){
						str.append(",");
					}
				}
				str.append(")");
				enterpriseIdStr = str.toString();
			}
			if(StringUtils.isNotBlank(parkIdStr) && StringUtils.isNotBlank(enterpriseIdStr)){
				sql.append(" and (");

				sql.append("(");
				sql.append("platformSource = " + PlatformSource.PARK.code());
				sql.append(" and platformSourceId in" + parkIdStr);
				sql.append(")");
				
				sql.append(" or (");
				sql.append("platformSource = " + PlatformSource.ENTERPRISE.code());
				sql.append(" and platformSourceId in" + enterpriseIdStr);				
				sql.append(")");
				
				sql.append(")");
			}else if(StringUtils.isNotBlank(parkIdStr)){
				sql.append(" and platformSource = " + PlatformSource.PARK.code());
				sql.append(" and platformSourceId in" + parkIdStr);
			}else if(StringUtils.isNotBlank(enterpriseIdStr)){
				sql.append(" and platformSource = " + PlatformSource.ENTERPRISE.code());
				sql.append(" and platformSourceId in" + enterpriseIdStr);	
			}
			return sql.toString();
		}

		//获取行政区下所有园区用户
		public String findAllParkUserIdByParkIds(Map<String,Object> params){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			sql.append(" and status = " + Status.NORMAL.code());

			List<Long> parkIds = (List<Long>)params.get("parkIds");
			String parkIdStr = null;
			if(CollectionUtils.isNotEmpty(parkIds)){
				StringBuilder str = new StringBuilder();
				str.append("(");
				for(int i=0;i<parkIds.size();i++){
					str.append(parkIds.get(i));
					if(i<parkIds.size()-1){
						str.append(",");
					}
				}
				str.append(")");
				parkIdStr = str.toString();
			}
			if(StringUtils.isNotBlank(parkIdStr)){
				sql.append(" and platformSource = " + PlatformSource.PARK.code());
				sql.append(" and platformSourceId in" + parkIdStr);
			}
			return sql.toString();
		}

		//获取行政区下所有企业用户
		public String findAllEnterpriseUserIdByEnterpriseIds(Map<String,Object> params){
			StringBuilder sql = new StringBuilder("select userId from admin_user where 1=1 ");
			sql.append(" and status = " + Status.NORMAL.code());

			List<Long> enterpriseIds = (List<Long>)params.get("enterpriseIds");
			String enterpriseIdStr = null;
			if(CollectionUtils.isNotEmpty(enterpriseIds)){
				StringBuilder str = new StringBuilder();
				str.append("(");
				for(int i=0;i<enterpriseIds.size();i++){
					str.append(enterpriseIds.get(i));
					if(i<enterpriseIds.size()-1){
						str.append(",");
					}
				}
				str.append(")");
				enterpriseIdStr = str.toString();
			}
			if(StringUtils.isNotBlank(enterpriseIdStr)){
				sql.append(" and platformSource = " + PlatformSource.ENTERPRISE.code());
				sql.append(" and platformSourceId in" + enterpriseIdStr);
			}
			return sql.toString();
		}
	
    
}