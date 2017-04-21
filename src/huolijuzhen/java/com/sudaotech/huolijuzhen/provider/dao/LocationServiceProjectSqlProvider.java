package com.sudaotech.huolijuzhen.provider.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ServerGrade;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.FindServiceProByCurrentUser;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.Query;

public class LocationServiceProjectSqlProvider {
	
	/**
	 * 获取服务商的服务项目
	 * @return
	 */
	public String findProviderServiceSql(){
		StringBuilder whereSql = new StringBuilder();
		return whereSql.toString();
	}


	/**
	 * 获取平台有权限看到的所有的服务项目
	 * @return
	 */
	public String findPlatformServiceIds(){
		
		//园区自营状态
		List<Integer> parkSelf = new ArrayList<Integer>();
		parkSelf.add(ServiceApprovalStatus.PUBLISH.code());
		parkSelf.add(ServiceApprovalStatus.UNPUBLISH.code());
		
		//平台服务商状态
		List<Integer> platformProvider = new ArrayList<Integer>();
		platformProvider.add(ServiceApprovalStatus.WAITAPPROVAL.code());
		platformProvider.add(ServiceApprovalStatus.PUBLISH.code());
		platformProvider.add(ServiceApprovalStatus.UNPUBLISH.code());
		
		//园区服务商状态
		List<Integer> parkProvider = new ArrayList<Integer>();
		parkProvider.add(ServiceApprovalStatus.PUBLISH.code());
		parkProvider.add(ServiceApprovalStatus.UNPUBLISH.code());
		
		StringBuilder countSql = new StringBuilder("select id from service_pro where 1=1 ");
		
		StringBuilder whereSql = new StringBuilder(); 
		whereSql.append(" and status = " + Status.NORMAL.code());
		whereSql.append(" and(");
		//平台自营（所有状态）
		whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSELF.code());
		
		//园区自营（已上架、已下架）
		whereSql.append(" or (");
		whereSql.append("serviceGrade = " + ServiceGrade.PARKSELF.code());
		whereSql.append(" and approvalStatus in" + strByStatusCodes(parkSelf));
		whereSql.append(")");
		
		//平台服务商创建（待审批、已上架、已下架）
		whereSql.append(" or (");
		whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSERVICE.code());
		whereSql.append(" and approvalStatus in" + strByStatusCodes(platformProvider));
		whereSql.append(")");
		
		//园区服务商创建
		whereSql.append(" or (");
		whereSql.append("serviceGrade = " + ServiceGrade.PARKSERVICE.code());
		whereSql.append(" and approvalStatus in" + strByStatusCodes(parkProvider));
		whereSql.append(")");
		
		whereSql.append(")");
		return countSql.append(whereSql).toString();
	}

	//平台下服务项目列表数量
	public String findPlatformServiceSqlCount(Query query){
		StringBuilder countSql = new StringBuilder("select count(id) from service_pro where 1=1 ");
		
		StringBuilder whereSql = new StringBuilder(); 
		//根据服务商名搜索服务项目
		whereSql.append(" and status = " + Status.NORMAL.code());
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			whereSql.append(" and serviceGradeName like '%" + providerName + "%'");
		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			whereSql.append(" and mainTitle like '%" + mainTitle + "%'");		
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}
		
//		Long serviceScenarioId = query.getServiceScenarioId();
//		if(serviceScenarioId != null){
//			whereSql.append(" and serviceScenarioId = " + serviceScenarioId);
//		}
//		
		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			whereSql.append(" and serviceGrade = " + serviceGrade.code());
		}
		
		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				whereSql.append(" and approvalStatus = " + approvalStatus.code());
			}
		}
		
		//平台下所有服务项目
		List<Long> ids = query.getIds();
		if(CollectionUtils.isNotEmpty(ids)){
			whereSql.append(" and id in" + strByIds(ids));
		}
		String sql = countSql.append(whereSql).toString();
		System.out.println("----------------------sql:" + sql);
		return sql;
	}
	
	//平台下服务项目列表元素
	public String findPlatformServiceSql(Query query){
		StringBuilder itemSql = new StringBuilder("select "
				+ "id id,"
				+ "mainTitle mainTitle,"
				+ "subTitle subTitle,"
				+ "serviceTypeId serviceTypeId,"
				+ "content content,"
				+ "serverGrade serverGrade,"
				+ "serviceGrade serviceGrade,"
				+ "serviceGradeId serviceGradeId,"
				+ "serviceGradeName serviceGradeName,"
				+ "parkId parkId,"
				+ "supportApply supportApply,"
				+ "applyViewId applyViewId,"
				+ "supportOrder supportOrder,"
				+ "orderViewId orderViewId,"
				+ "version version,"
				+ "status status,"
				+ "createBy createBy,"
				+ "createTime createTime,"
				+ "updateBy updateBy,"
				+ "updateTime updateTime,"
				+ "lastUpdate lastUpdate,"
				+ "approvalStatus approvalStatus,"
				+ "approvalBy approvalBy,"
				+ "approvalTime approvalTime,"
				+ "approvalText approvalText,"
				+ "applyOrderNum applyOrderNum,"
				+ "collectNum collectNum,"
				+ "readNum readNum,"
				+ "releases releases,"
				+ "commentNum commentNum"
				+ " from service_pro"
				+ " where 1 = 1 ");
		
		StringBuilder whereSql = new StringBuilder(); 
		//根据服务商名搜索服务项目
		whereSql.append(" and status = " + Status.NORMAL.code());
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			whereSql.append(" and serviceGradeName like '%" + providerName + "%'");
		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			whereSql.append(" and mainTitle like '%" + mainTitle + "%'");		
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}
		
		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			whereSql.append(" and serviceGrade = " + serviceGrade.code());
		}
		
		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				whereSql.append(" and approvalStatus = " + approvalStatus.code());
			}
		}
		
		//平台下所有服务项目
		List<Long> ids = query.getIds();
		if(CollectionUtils.isNotEmpty(ids)){
			whereSql.append(" and id in" + strByIds(ids));
		}
		
		//排序
		StringBuilder orderSql = new StringBuilder();
		orderSql.append(" order by ");
		orderSql.append("applyOrderNum desc,");
		orderSql.append("collectNum desc,");
		orderSql.append("readNum desc ");
		
		//分页
		int offset = query.getOffset();
		int limit = query.getLimit();
		
		StringBuilder limitSql = new StringBuilder();
		limitSql.append(" limit ");
		limitSql.append(offset);
		limitSql.append(",");
		limitSql.append(limit);
		
		String sql = itemSql.append(whereSql).append(orderSql).append(limitSql).toString();
		
		System.out.println("----------------------sql:" + sql);
		return sql;
	}
	
	/**
	 * 获取数量
	 * @param query
	 * @param parkId
	 * @param ids
	 * @return
	 */
	public String findParkServiceSqlCount(Query query){
		
		StringBuilder countSql = new StringBuilder("select count(id) from service_pro where 1=1 ");
		
		StringBuilder whereSql = new StringBuilder(); 
		//根据服务商名搜索服务项目
		whereSql.append(" and (status = " + Status.NORMAL.code());
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			whereSql.append(" and serviceGradeName like '%" + providerName + "%'");
		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			whereSql.append(" and mainTitle like '%" + mainTitle + "%'");		
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}

		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			whereSql.append(" and serviceGrade = " + serviceGrade.code());
		}
		
		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				whereSql.append(" and approvalStatus = " + approvalStatus.code());
			}
		}
		whereSql.append(")");

		//根据适用场景筛选
		List<Long> serviceProIds = query.getServiceProIds();
		if(CollectionUtils.isNotEmpty(serviceProIds)){
			whereSql.append(" and (");
			whereSql.append("id in" + strByIds(serviceProIds));
			whereSql.append(")");
		}
		
		ServiceGrade currentServiceGrade = query.getCurrentServiceGrade();
		if(ServiceGrade.PLATFORMSERVICE.equals(currentServiceGrade) || ServiceGrade.PARKSERVICE.equals(currentServiceGrade)){
			whereSql.append(" and( serviceGrade = " + currentServiceGrade.code());
			whereSql.append(" and serviceGradeId = " + query.getServiceGradeId() + ")");
		}else if(ServiceGrade.PARKSELF.equals(currentServiceGrade)){
			Long parkId = query.getParkId();
			List<Long> ids = query.getIds();
			String idsStr = null;
			if(CollectionUtils.isNotEmpty(ids)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<ids.size();i++){
					sql.append(ids.get(i));
					if(i<(ids.size() - 1)){
						sql.append(",");
					}
				}
				sql.append(")");
				
				idsStr = sql.toString();
			}
			
			List<ServiceApprovalStatus> parkServiceInApprovalStatus = new ArrayList<ServiceApprovalStatus>();
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.WAITAPPROVAL);
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.PUBLISH);
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.UNPUBLISH);
			
			String parkServiceInApprovalStatusStr = null;
			if(CollectionUtils.isNotEmpty(parkServiceInApprovalStatus)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<parkServiceInApprovalStatus.size();i++){
					sql.append(parkServiceInApprovalStatus.get(i).code());
					if(i<(parkServiceInApprovalStatus.size() - 1)){
						sql.append(",");
					}
				}
				sql.append(")");
				
				parkServiceInApprovalStatusStr = sql.toString();
			}
			
			List<ServiceApprovalStatus> inApprovalStatus = new ArrayList<ServiceApprovalStatus>();
			inApprovalStatus.add(ServiceApprovalStatus.PUBLISH);
			inApprovalStatus.add(ServiceApprovalStatus.UNPUBLISH);
			
			String inApprovalStatusStr = null;
			if(CollectionUtils.isNotEmpty(inApprovalStatus)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<inApprovalStatus.size();i++){
					sql.append(inApprovalStatus.get(i).code());
					if(i<(inApprovalStatus.size() - 1)){
						sql.append(",");
					}
				}
				sql.append(")");
				
				inApprovalStatusStr = sql.toString();
			}
			
			
			
			whereSql.append(" and(");

			whereSql.append("(");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSELF.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(")");
		
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSERVICE.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus in" + parkServiceInApprovalStatusStr);
			whereSql.append(")");
			
			whereSql.append(" or (");
			whereSql.append("serverGrade = "+ ServerGrade.PLATFORM.code());
			whereSql.append(" and approvalStatus = "+ ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");

			if(CollectionUtils.isNotEmpty(ids)){
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSELF.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idsStr);
				whereSql.append(" and approvalStatus in" + inApprovalStatusStr);
				whereSql.append(")");
				
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSERVICE.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idsStr);
				whereSql.append(" and approvalStatus in" + inApprovalStatusStr);
				whereSql.append(")");			}
			
			whereSql.append(")");
		}
		
		String sql = countSql.append(whereSql).toString();
		
		System.out.println("----------------------sql:" + sql);
		return sql;
	}
	
	/**
	 * 获取园区的服务项目
	 * @param query
	 * @param parkId
	 * @param ids
	 * @return
	 */
	public String findParkServiceSql(Query query){

		StringBuilder itemSql = new StringBuilder();
		itemSql.append("select "
				+ "id id,"
				+ "mainTitle mainTitle,"
				+ "subTitle subTitle,"
				+ "serviceTypeId serviceTypeId,"
				+ "content content,"
				+ "serverGrade serverGrade,"
				+ "serviceGrade serviceGrade,"
				+ "serviceGradeId serviceGradeId,"
				+ "serviceGradeName serviceGradeName,"
				+ "parkId parkId,"
				+ "supportApply supportApply,"
				+ "applyViewId applyViewId,"
				+ "supportOrder supportOrder,"
				+ "orderViewId orderViewId,"
				+ "version version,"
				+ "status status,"
				+ "createBy createBy,"
				+ "createTime createTime,"
				+ "updateBy updateBy,"
				+ "updateTime updateTime,"
				+ "lastUpdate lastUpdate,"
				+ "approvalStatus approvalStatus,"
				+ "approvalBy approvalBy,"
				+ "approvalTime approvalTime,"
				+ "approvalText approvalText,"
				+ "applyOrderNum applyOrderNum,"
				+ "collectNum collectNum,"
				+ "readNum readNum,"
				+ "releases releases,"
				+ "commentNum commentNum"
				+ " from service_pro"
				+ " where 1 = 1 ");

		StringBuilder whereSql = new StringBuilder(); 
		//根据服务商名搜索服务项目
		whereSql.append(" and (status = " + Status.NORMAL.code());
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			whereSql.append(" and serviceGradeName like '%" + providerName + "%'");
		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			whereSql.append(" and mainTitle like '%" + mainTitle + "%'");		
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}
		
		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			whereSql.append(" and serviceGrade = " + serviceGrade.code());
		}
		
		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				whereSql.append(" and approvalStatus = " + approvalStatus.code());
			}
		}
		whereSql.append(")");
		
		//根据适用场景筛选
		List<Long> serviceProIds = query.getServiceProIds();
		if(CollectionUtils.isNotEmpty(serviceProIds)){
			whereSql.append(" and (");
			whereSql.append("id in" + strByIds(serviceProIds));
			whereSql.append(")");
		}

		
		ServiceGrade currentServiceGrade = query.getCurrentServiceGrade();
		if(ServiceGrade.PLATFORMSERVICE.equals(currentServiceGrade) || ServiceGrade.PARKSERVICE.equals(currentServiceGrade)){
			whereSql.append(" and(serviceGrade = " + currentServiceGrade.code());
			whereSql.append(" and serviceGradeId = " + query.getServiceGradeId() + ")");
		}else if(ServiceGrade.PARKSELF.equals(currentServiceGrade)){
			Long parkId = query.getParkId();
			List<Long> ids = query.getIds();
			String idsStr = null;
			if(CollectionUtils.isNotEmpty(ids)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<ids.size();i++){
					sql.append(ids.get(i));
					if(i<ids.size() - 1){
						sql.append(",");
					}
				}
				sql.append(")");
				
				idsStr = sql.toString();
			}

			List<ServiceApprovalStatus> parkServiceInApprovalStatus = new ArrayList<ServiceApprovalStatus>();
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.WAITAPPROVAL);
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.PUBLISH);
			parkServiceInApprovalStatus.add(ServiceApprovalStatus.UNPUBLISH);
			
			String parkServiceInApprovalStatusStr = null;
			if(CollectionUtils.isNotEmpty(parkServiceInApprovalStatus)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<parkServiceInApprovalStatus.size();i++){
					sql.append(parkServiceInApprovalStatus.get(i).code());
					if(i<parkServiceInApprovalStatus.size() - 1){
						sql.append(",");
					}
				}
				sql.append(")");
				
				parkServiceInApprovalStatusStr = sql.toString();
			}
			
			List<ServiceApprovalStatus> inApprovalStatus = new ArrayList<ServiceApprovalStatus>();
			inApprovalStatus.add(ServiceApprovalStatus.PUBLISH);
			inApprovalStatus.add(ServiceApprovalStatus.UNPUBLISH);
			String inApprovalStatusStr = null;
			if(CollectionUtils.isNotEmpty(inApprovalStatus)){
				StringBuilder sql = new StringBuilder("(");
				for(int i=0;i<inApprovalStatus.size();i++){
					sql.append(inApprovalStatus.get(i).code());
					if(i<inApprovalStatus.size() - 1){
						sql.append(",");
					}
				}
				sql.append(")");
				
				inApprovalStatusStr = sql.toString();
			}
			
			
			whereSql.append(" and(");

			whereSql.append("(");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSELF.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(")");
		
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSERVICE.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus in" + parkServiceInApprovalStatusStr);
			whereSql.append(")");
			
			whereSql.append(" or (");
			whereSql.append("serverGrade = "+ ServerGrade.PLATFORM.code());
			whereSql.append(" and approvalStatus = "+ ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");

			if(CollectionUtils.isNotEmpty(ids)){
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSELF.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idsStr);
				whereSql.append(" and approvalStatus in" + inApprovalStatusStr);
				whereSql.append(")");
				
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSERVICE.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idsStr);
				whereSql.append(" and approvalStatus in" + inApprovalStatusStr);
				whereSql.append(")");			}
			
			whereSql.append(")");
		}
		
		//排序
		StringBuilder orderSql = new StringBuilder();
		orderSql.append(" order by ");
		orderSql.append("applyOrderNum desc,");
		orderSql.append("collectNum desc,");
		orderSql.append("readNum desc ");
		
		//分页
		int offset = query.getOffset();
		int limit = query.getLimit();
		
		StringBuilder limitSql = new StringBuilder();
		limitSql.append(" limit ");
		limitSql.append(offset);
		limitSql.append(",");
		limitSql.append(limit);
		
		String sql = itemSql.append(whereSql).append(orderSql).append(limitSql).toString();
		
		System.out.println("----------------------sql:" + sql);
		return sql;
	}
	
	public String findServiceProByCurrentUser(FindServiceProByCurrentUser condition){
		
		ServiceGrade currentUserGrade = condition.getCurrentGrade();
		
		List<ServiceGrade> serviceGradeList = condition.getServiceGradeList();
		
		Long serviceGradeId = condition.getServiceGradeId();
		
		Long parkId = condition.getParkId();
		
		StringBuilder sql = new StringBuilder("select id from service_pro where 1=1 ");
		
		//1.服务商类型
		if(ServiceGrade.PARKSERVICE.equals(currentUserGrade) || ServiceGrade.PLATFORMSERVICE.equals(currentUserGrade)){
			sql.append(" and serviceGrade = " + currentUserGrade.code());
			sql.append(" and serviceGradeId = " + serviceGradeId);
		}
		//2.园区类型
		else{
			//2.1 园区自营
			if(serviceGradeList.size() == 1 && ServiceGrade.PARKSELF.equals(serviceGradeList.get(0))){
				sql.append(" and serviceGrade = " + ServiceGrade.PARKSELF.code());
				sql.append(" and parkId = " + parkId);
			}
			//2.2 园区服务商
			else if(serviceGradeList.size() == 1 && ServiceGrade.PARKSERVICE.equals(serviceGradeList.get(0))){
				sql.append(" and serviceGrade = " + ServiceGrade.PARKSERVICE.code());
				sql.append(" and serviceGradeId = " + serviceGradeId);
				sql.append(" and parkId = " + parkId);
			}
			//2.3 全部
			else{
				sql.append(" and(");
				sql.append("(serviceGrade = " + ServiceGrade.PARKSELF.code());
				sql.append(" and parkId = " + parkId);
				sql.append(")");

				sql.append(" or (serviceGrade = " + ServiceGrade.PARKSERVICE.code());
				sql.append(" and serviceGradeId = " + serviceGradeId);
				sql.append(" and parkId = " + parkId);
				sql.append(")");

				sql.append(")");

			}
		}
		System.out.println("------------------->>>>>>>" + sql.toString());
		
		return sql.toString();
	}
	
	/**
	 * 获取园区有效的的服务项目（用于 app 显示）
	 * @param query
	 * @param parkId
	 * @param ids
	 * @return
	 */
	public String findParkValidServiceProCount(Map<String, Object> paramsMap){

		Query query = (Query)paramsMap.get("query");
		Long parkId = (Long)paramsMap.get("parkId");
		List<Long> ids = (List<Long>)paramsMap.get("ids");

		StringBuilder itemSql = new StringBuilder();
		itemSql.append("select count(id) "
				+ "from service_pro"
				+ " where 1 = 1 ");

		StringBuilder whereSql = new StringBuilder(); 
		
		whereSql.append(" and (status = " + Status.NORMAL.code());
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}
		
		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			whereSql.append(" and(");
			whereSql.append("mainTitle like '%" + title + "%'");
			whereSql.append(" or ");
			whereSql.append("subTitle like '%" + title + "%'");
			whereSql.append(")");
		}
		
		whereSql.append(")");
		
		//根据适用场景筛选
		List<Long> serviceProIds = query.getServiceProIds();
		if(CollectionUtils.isNotEmpty(serviceProIds)){
			whereSql.append(" and (");
			whereSql.append("id in" + strByIds(serviceProIds));
			whereSql.append(")");
		}
		
		//平台自营、平台服务商服务对象是平台
		whereSql.append(" and (");
		whereSql.append("(");
		whereSql.append(" serverGrade = " + ServerGrade.PLATFORM.code());
		whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
		whereSql.append(")");
		//园区自营服务
		if(parkId != null){
			if(CollectionUtils.isNotEmpty(ids)){
				StringBuilder idStr = new StringBuilder("(");
				for(int i=0;i<ids.size();i++){
					idStr.append(ids.get(i));
					if(i < ids.size()-1){
						idStr.append(",");
					}
				}
				idStr.append(")");
				
				//平台自营 服务对象是园区
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSELF.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idStr.toString());
				whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
				whereSql.append(")");
				//平台服务商 服务对象是园区
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSERVICE.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idStr.toString());
				whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
				whereSql.append(")");
			}
			
			//园区自营项目
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSELF.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");
			
			//园区服务商
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSERVICE.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");
			
		}
		whereSql.append(")");
		
		String sqlStr  = itemSql.append(whereSql).toString();
		System.out.println("----------------------------------" + sqlStr);
		
		//平台服务商
		return sqlStr;
	}
	/**
	 * 获取园区有效的的服务项目（用于 app 显示）
	 * @param query
	 * @param parkId
	 * @param ids
	 * @return
	 */
	public String findParkValidServicePro(Map<String, Object> paramsMap){

		Query query = (Query)paramsMap.get("query");
		Long parkId = (Long)paramsMap.get("parkId");
		List<Long> ids = (List<Long>)paramsMap.get("ids");

		
		StringBuilder itemSql = new StringBuilder();
		itemSql.append("select "
				+ "id id,"
				+ "mainTitle mainTitle,"
				+ "subTitle subTitle,"
				+ "serviceTypeId serviceTypeId,"
				+ "content content,"
				+ "serverGrade serverGrade,"
				+ "serviceGrade serviceGrade,"
				+ "serviceGradeId serviceGradeId,"
				+ "serviceGradeName serviceGradeName,"
				+ "parkId parkId,"
				+ "supportApply supportApply,"
				+ "applyViewId applyViewId,"
				+ "supportOrder supportOrder,"
				+ "orderViewId orderViewId,"
				+ "version version,"
				+ "status status,"
				+ "createBy createBy,"
				+ "createTime createTime,"
				+ "updateBy updateBy,"
				+ "updateTime updateTime,"
				+ "lastUpdate lastUpdate,"
				+ "approvalStatus approvalStatus,"
				+ "approvalBy approvalBy,"
				+ "approvalTime approvalTime,"
				+ "approvalText approvalText,"
				+ "applyOrderNum applyOrderNum,"
				+ "collectNum collectNum,"
				+ "readNum readNum,"
				+ "releases releases,"
				+ "commentNum commentNum"
				+ " from service_pro"
				+ " where 1 = 1 ");

		StringBuilder whereSql = new StringBuilder(); 
		
		whereSql.append(" and (status = " + Status.NORMAL.code());
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			whereSql.append(" and serviceTypeId = " + serviceTypeId);
		}
		
		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			whereSql.append(" and(");
			whereSql.append("mainTitle like '%" + title + "%'");
			whereSql.append(" or ");
			whereSql.append("subTitle like '%" + title + "%'");
			whereSql.append(")");
		}
		whereSql.append(")");
		
		//根据适用场景筛选
		List<Long> serviceProIds = query.getServiceProIds();
		if(CollectionUtils.isNotEmpty(serviceProIds)){
			whereSql.append(" and (");
			whereSql.append("id in" + strByIds(serviceProIds));
			whereSql.append(")");
		}
		
		//平台自营、平台服务商服务对象是平台
		whereSql.append(" and (");
		whereSql.append("(");
		whereSql.append(" serverGrade = " + ServerGrade.PLATFORM.code());
		whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
		whereSql.append(")");
		//园区自营服务
		if(parkId != null){
			if(CollectionUtils.isNotEmpty(ids)){
				StringBuilder idStr = new StringBuilder("(");
				for(int i=0;i<ids.size();i++){
					idStr.append(ids.get(i));
					if(i < ids.size()-1){
						idStr.append(",");
					}
				}
				idStr.append(")");
				
				//平台自营 服务对象是园区
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSELF.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idStr.toString());
				whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
				whereSql.append(")");
				//平台服务商 服务对象是园区
				whereSql.append(" or (");
				whereSql.append("serviceGrade = " + ServiceGrade.PLATFORMSERVICE.code());
				whereSql.append(" and serverGrade = " + ServerGrade.PARK.code());
				whereSql.append(" and id in" + idStr.toString());
				whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
				whereSql.append(")");
			}
			
			//园区自营项目
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSELF.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");
			
			//园区服务商
			whereSql.append(" or (");
			whereSql.append("serviceGrade = " + ServiceGrade.PARKSERVICE.code());
			whereSql.append(" and parkId = " + parkId);
			whereSql.append(" and approvalStatus = " + ServiceApprovalStatus.PUBLISH.code());
			whereSql.append(")");
			
		}
		whereSql.append(")");
		
		//排序
		StringBuilder orderSql = new StringBuilder();
		orderSql.append(" order by ");
		orderSql.append("applyOrderNum desc,");
		orderSql.append("collectNum desc,");
		orderSql.append("readNum desc ");
		
		//分页
		Integer offset = query.getOffset();
		Integer limit = query.getLimit();
		
		StringBuilder limitSql = new StringBuilder();
		limitSql.append(" limit ");
		limitSql.append(offset);
		limitSql.append(",");
		limitSql.append(limit);
		
		String sqlStr  = itemSql.append(whereSql).append(orderSql).append(limitSql).toString();
		//平台服务商
		return sqlStr;
	}
	//将状态码列表转换成字符串
	private String strByStatusCodes(List<Integer> statusCodes){
		if(CollectionUtils.isEmpty(statusCodes)){
			return null;
		}
		StringBuilder idStr = new StringBuilder();
		idStr.append("(");
		for(int i=0;i<statusCodes.size();i++){
			idStr.append(statusCodes.get(i));
			if(i<statusCodes.size()-1){
				idStr.append(",");
			}
		}
		idStr.append(")");
		return idStr.toString();
	}
	
	//将状态码列表转换成字符串
	private String strByIds(List<Long> ids){
		if(CollectionUtils.isEmpty(ids)){
			return null;
		}
		StringBuilder idStr = new StringBuilder();
		idStr.append("(");
		for(int i=0;i<ids.size();i++){
			idStr.append(ids.get(i));
			if(i<ids.size()-1){
				idStr.append(",");
			}
		}
		idStr.append(")");
		return idStr.toString();
	}
	
	/**
	 * 运营平台服务项目统计
	 * @param paramsMap
	 * @return
	 */
	public String statisticsToPlatform(Map<String, Object> paramsMap){
		
		String type = (String)paramsMap.get("type");
		String data = (String)paramsMap.get("data");
		Integer offset = (Integer)paramsMap.get("offset");
		Integer limit = (Integer)paramsMap.get("limit");
		StringBuilder sql = new StringBuilder();
		//服务商 点击量
		if("PROVIDER".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(readNum) num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务商 订单量
		else if("PROVIDER".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(applyOrderNum) num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务商 收藏量
		else if("PROVIDER".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(collectNum) num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务类型 点击量
		else if("SERVICETYPE".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.readNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1");
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务类型 订单量
		else if("SERVICETYPE".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.applyOrderNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1");
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务类型 收藏量
		else if("SERVICETYPE".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.collectNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1");
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务项目 点击量
		else if("SERVICEPROJECT".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT mainTitle name,readNum num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		//服务项目 订单量
		else if("SERVICEPROJECT".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT mainTitle name,applyOrderNum num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		//服务项目 收藏量
		else if("SERVICEPROJECT".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT mainTitle name,collectNum num FROM service_pro");
			sql.append(" WHERE status = 1");
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		if(offset == null || offset < 0 || limit == null || limit < 0){
			offset = 0;
			limit = 16;
		}
		sql.append(" limit ");
		sql.append(offset);
		sql.append(",");
		sql.append(limit);
		
		return sql.toString();
	}
	
	/**
	 * 园区管理 Web 服务项目统计
	 * @param paramsMap
	 * @return
	 */
	public String statisticsToPark(Map<String, Object> paramsMap){
		
		String type = (String)paramsMap.get("type");
		String data = (String)paramsMap.get("data");
		Integer offset = (Integer)paramsMap.get("offset");
		Integer limit = (Integer)paramsMap.get("limit");
		Long parkId = (Long)paramsMap.get("parkId");
		StringBuilder sql = new StringBuilder();
		//服务商 点击量
		if("PROVIDER".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(readNum) num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务商 订单量
		else if("PROVIDER".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(applyOrderNum) num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务商 收藏量
		else if("PROVIDER".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT serviceGradeName name,SUM(collectNum) num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY name");
			sql.append(" ORDER BY num DESC,serviceGradeName DESC");
		}
		//服务类型 点击量
		else if("SERVICETYPE".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.readNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务类型 订单量
		else if("SERVICETYPE".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.applyOrderNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务类型 收藏量
		else if("SERVICETYPE".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT st.name name,SUM(sp.collectNum) num FROM service_pro sp");
			sql.append(" LEFT JOIN service_type st ON sp.serviceTypeId = st.id");
			sql.append(" WHERE sp.status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY sp.serviceTypeId");
			sql.append(" ORDER BY num DESC,st.name DESC");
		}
		//服务项目 点击量
		else if("SERVICEPROJECT".equals(type) && "READNUM".equals(data)){
			sql.append("SELECT mainTitle name,readNum num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		//服务项目 订单量
		else if("SERVICEPROJECT".equals(type) && "APPLYORDERNUM".equals(data)){
			sql.append("SELECT mainTitle name,applyOrderNum num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		//服务项目 收藏量
		else if("SERVICEPROJECT".equals(type) && "COLLECTNUM".equals(data)){
			sql.append("SELECT mainTitle name,collectNum num FROM service_pro");
			sql.append(" WHERE status = 1 and parkId = " + parkId);
			sql.append(" GROUP BY id");
			sql.append(" ORDER BY num DESC,mainTitle DESC");
		}
		if(offset == null || offset < 0 || limit == null || limit < 0){
			offset = 0;
			limit = 16;
		}
		sql.append(" limit ");
		sql.append(offset);
		sql.append(",");
		sql.append(limit);
		
		return sql.toString();
	}

}
