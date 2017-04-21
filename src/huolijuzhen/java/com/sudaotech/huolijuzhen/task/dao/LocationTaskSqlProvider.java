package com.sudaotech.huolijuzhen.task.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.TaskStatus;
import com.sudaotech.huolijuzhen.enums.TaskType;
import com.sudaotech.huolijuzhen.task.service.TaskService.Query;
import com.sudaotech.huolijuzhen.util.ConvertUtils;
import com.sudaotech.huolijuzhen.util.SystemUtil;

public class LocationTaskSqlProvider {
	
	
	public String findByEquPlanIds(Map<String, Object> params){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id id,");
		sql.append("operatorTime operatorTime,");
		sql.append("operator operator,");
		sql.append("taskStatus taskStatus,");
		sql.append("operatorMemo operatorMemo, ");
		sql.append("taskType taskType ");
		sql.append(" from task_info");
		sql.append(" where 1=1 ");
		
		Integer taskType = (Integer)params.get("taskType");
		sql.append( " and taskType = " + taskType);

		Integer status = (Integer)params.get("status");
		sql.append(" and status = " + status);

		List<Long> equPlanIds = (List<Long>)params.get("equPlanIds");
		StringBuilder inSql = new StringBuilder("(");
		for(int i=0;i<equPlanIds.size();i++){
			inSql.append(equPlanIds.get(i));
			if(i < equPlanIds.size() - 1){
				inSql.append(",");
			}
		}
		inSql.append(")");
		sql.append( " and equPlanId in" + inSql);
		
		
		return sql.toString();
		
	}
	
	/**
	 * 获取任务数量
	 * @param query
	 * @return
	 */
	public String findByConfigCount(Query query){
		//1.统计数量
		StringBuilder countSql = new StringBuilder("select count(id) from task_info where 1=1 ");
		//2.查询子句
		StringBuilder whereSql = new StringBuilder();
		//2.1 未被删除
		whereSql.append(" and status = " + Status.NORMAL.code());
		//2.2 任务状态为待处理
		whereSql.append(" and taskStatus = " + TaskStatus.WAITEXECUTOR.code());
		//2.3 任务约束
		List<Long> taskIds = query.getTaskIds();
		if(CollectionUtils.isNotEmpty(taskIds)){
			whereSql.append(" and id in" + ConvertUtils.longListToStr(taskIds));
		}

		String flag = query.getFlag();
		whereSql.append(" and (");
		//2.4.1 企业申报
		List<String> orSqlList = new ArrayList<String>();
		Date companyCreateTime = query.getCompanyCreateTime();
		if(companyCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.COMPANYAPPLY.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(companyCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(companyCreateTime) + "'");
			}
			orSqlItem.append(")");
			
			orSqlList.add(orSqlItem.toString());
		}
		//2.4.2 园区创建
		Date parkCreateTime = query.getParkCreateTime();
		if(parkCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.PARKCREATE.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(parkCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(parkCreateTime) + "'");
			}
			orSqlItem.append(")");
			
			orSqlList.add(orSqlItem.toString());
		}
		//2.4.3 计划生成
		Date equCreateTime = query.getEquiCreateTime();
		if(equCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.EQUI.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(equCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(equCreateTime) + "'");
			}
			orSqlItem.append(")");	
			
			orSqlList.add(orSqlItem.toString());
		}
		String orSqlStr = toOrSql(orSqlList);
		if(StringUtils.isNotBlank(orSqlStr)){
			whereSql.append(orSqlStr);
		}else{
			whereSql.append(" 1 = 1 ");
		}
		
		whereSql.append(")");
		
		String sql = countSql.append(whereSql).toString();
		
		System.out.println("------------>>>>sql:" + sql);
		return sql;
	}
	
	/**
	 * 获取任务（分页）
	 * @param query
	 * @return
	 */
	public String findByConfig(Query query){
		//1.查询元素
		StringBuilder itemSql = 
		new StringBuilder("select "
				+ "id, title, code, taskType, equPlanId, equId, description, enableStatus, taskStatus, "
				+ "isAdjust, adjustBy, adjustTime, adjustMemo, operator, operatorMemo, operatorTime, "
				+ "payWay, executor, parkId, allBy, allTime, closeBy, closeTime, version, status, "
				+ "createBy, createTime, createName, updateBy, updateTime, lastUpdate, hasCost, "
				+ "costIsVerify, taskCost, verifyBy, veribyTime, veribyMemo, isComment, commentBy, "
				+ "commentTime, commentGrade, commentContent, commentStarGrade, equTypeId, updateMemo, "
				+ "history from task_info where 1=1 ");
		//2.查询子句
		StringBuilder whereSql = new StringBuilder();
		//2.1 未被删除
		whereSql.append(" and status = " + Status.NORMAL.code());
		//2.2 任务状态为待处理
		whereSql.append(" and taskStatus = " + TaskStatus.WAITEXECUTOR.code());
		//2.3 任务约束
		List<Long> taskIds = query.getTaskIds();
		if(CollectionUtils.isNotEmpty(taskIds)){
			whereSql.append(" and id in" + ConvertUtils.longListToStr(taskIds));
		}

		String flag = query.getFlag();
		whereSql.append(" and (");
		//2.4.1 企业申报
		//2.4.1 企业申报
		List<String> orSqlList = new ArrayList<String>();
		Date companyCreateTime = query.getCompanyCreateTime();
		if(companyCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.COMPANYAPPLY.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(companyCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(companyCreateTime) + "'");
			}
			orSqlItem.append(")");
			
			orSqlList.add(orSqlItem.toString());
		}
		//2.4.2 园区创建
		Date parkCreateTime = query.getParkCreateTime();
		if(parkCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.PARKCREATE.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(parkCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(parkCreateTime) + "'");
			}
			orSqlItem.append(")");
			
			orSqlList.add(orSqlItem.toString());
		}
		//2.4.3 计划生成
		Date equCreateTime = query.getEquiCreateTime();
		if(equCreateTime != null){
			StringBuilder orSqlItem = new StringBuilder();
			orSqlItem.append("(");
			orSqlItem.append("taskType =" + TaskType.EQUI.code());
			if("GL".equals(flag)){
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') > '" + SystemUtil.dateFormatHHMMSS(equCreateTime) + "'");
			}else{
				orSqlItem.append(" and date_format(createTime,'%Y-%m-%d %H:%i:%s') < '" + SystemUtil.dateFormatHHMMSS(equCreateTime) + "'");
			}
			orSqlItem.append(")");	
			
			orSqlList.add(orSqlItem.toString());
		}
		String orSqlStr = toOrSql(orSqlList);
		if(StringUtils.isNotBlank(orSqlStr)){
			whereSql.append(orSqlStr);
		}else{
			whereSql.append(" 1 = 1 ");
		}
		whereSql.append(")");
		
		StringBuilder orderSql = new StringBuilder(" order by createTime DESC ");
		
		int offset = query.getOffset();
		int limit = query.getLimit();
		
		StringBuilder limitSql = new StringBuilder();
		limitSql.append(" limit ");
		limitSql.append(offset);
		limitSql.append(",");
		limitSql.append(limit);
		
		String sql = itemSql.append(whereSql).append(orderSql).append(limitSql).toString();
		
		System.out.println("------------>>>>sql:" + sql);
		return sql;
	}

	/**
	 * 园区端任务统计
	 * @param params
	 * @return
	 */
	public String statisticsTask(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		String type = (String)params.get("type");
		String startDate = (String)params.get("startDate");
		String endDate = (String)params.get("endDate");
		StringBuilder sql = new StringBuilder();
		if("TASKTYPE".equals(type)){
			sql.append("select taskType name,count(id) num from task_info");
			sql.append(" where 1=1 ");
			sql.append(" and parkId = " + parkId);
			sql.append(" and status = " + Status.NORMAL.code());
			sql.append(" and taskStatus in(3,4)");
			if(StringUtils.isNotBlank(startDate)){
				sql.append(" and date_format(createTime,'%Y-%m-%d') >= '" + startDate + "'");
			}
			if(StringUtils.isNotBlank(endDate)){
				sql.append(" and date_format(createTime,'%Y-%m-%d') <= '" + endDate + "'");
			}
			sql.append(" group by taskType");
			sql.append(" order by taskType");
		}else if("EQUTYPE".equals(type)){
			sql.append("select et.name name,count(ti.id) num from task_info ti");
			sql.append(" left join equipment_type et on et.id = ti.equTypeId");
			sql.append(" where 1=1");
			sql.append(" and ti.parkId = " + parkId);
			sql.append(" and ti.status = " + Status.NORMAL.code());
			sql.append(" and ti.taskStatus in(3,4)");
			if(StringUtils.isNotBlank(startDate)){
				sql.append(" and date_format(ti.createTime,'%Y-%m-%d') >= '" + startDate + "'");
			}
			if(StringUtils.isNotBlank(endDate)){
				sql.append(" and date_format(ti.createTime,'%Y-%m-%d') <= '" + endDate + "'");
			}
			sql.append(" group by ti.equTypeId");
			sql.append(" order by ti.equTypeId");
		}else if("EXECUTOR".equals(type)){
			sql.append("select au.name name,count(ti.id) num from task_info ti");
			sql.append(" left join task_executor te on te.taskId = ti.id");
			sql.append(" left join admin_user au on au.userId = te.executorId");
			sql.append(" where 1=1 ");
			sql.append(" and ti.parkId = " + parkId);
			sql.append(" and ti.status = " + Status.NORMAL.code());
			sql.append(" and ti.taskStatus in(3,4)");
			if(StringUtils.isNotBlank(startDate)){
				sql.append(" and date_format(ti.createTime,'%Y-%m-%d') >= '" + startDate + "'");
			}
			if(StringUtils.isNotBlank(endDate)){
				sql.append(" and date_format(ti.createTime,'%Y-%m-%d') <= '" + endDate + "'");
			}
			sql.append(" group by te.executorId");
		}
		return sql.toString();
	}
	
	
	/**
	 * 封装 or 子句
	 * @param orSqlList
	 * @return
	 */
	private String toOrSql(List<String> orSqlList){
		
		if(CollectionUtils.isEmpty(orSqlList)){
			return null;
		}
		
		StringBuilder orSqlStr = new StringBuilder();
		for(int i=0;i<orSqlList.size();i++){
			if(i != 0){
				orSqlStr.append(" or ");
			}
			orSqlStr.append(orSqlList.get(i));
		}

		return orSqlStr.toString();
	}
}
