package com.sudaotech.huolijuzhen.community.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayEntity;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayEntityExtendsMapper;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayExtendsEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntity;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.huolijuzhen.util.StringUtils;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.util.BeanUtils;

public class EnterpriseDisplayServiceImpl extends BaseServiceImpl implements EnterpriseDisplayService {
	private static final String TRACKING_TYPE = "EnterpriseDisplay";

    @Inject
    private EnterpriseDisplayEntityExtendsMapper enterpriseDisplayEntityExtendsMapper;
    @Inject
    private EnterpriseCottService enterpriseCottService;
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    @Inject
    private AdminUserService adminUserService;
    

	@Override
	public EnterpriseDisplay getById(Long id) {
		EnterpriseDisplayEntity entity = this.enterpriseDisplayEntityExtendsMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseDisplay.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseDisplay obj) {
		logger.debug("Creating EnterpriseDisplay: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseDisplayEntity entity = BeanUtils.copyProperties(obj, EnterpriseDisplayEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseDisplayEntityExtendsMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseDisplay: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseDisplay obj) {
		logger.debug("Updating EnterpriseDisplay: {}", obj);

		EnterpriseDisplayEntity entity = BeanUtils.copyProperties(obj, EnterpriseDisplayEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseDisplayEntityExtendsMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseDisplay: {}", obj);
	}

	@Override
	public Long save(EnterpriseDisplay obj) {
		logger.debug("Saving EnterpriseDisplay: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	/*@Override
	public Page<EnterpriseDisplay> find(Query query) {
		Page<EnterpriseDisplay> page = new Page<EnterpriseDisplay>(query);
		EnterpriseDisplayEntityExample example = new EnterpriseDisplayEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseDisplayEntityExtendsMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseDisplayEntity> list = this.enterpriseDisplayEntityExtendsMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseDisplay.class));
		}
		
		return page;
	}*/
	
	@Override
	public Map<String, Object> findWithinParkId(Query query,
			ReqSourceType reqSourceType, EnterpriseDisplayExtends extendsEntity) {
		return findWithinParkId(query,0,reqSourceType, extendsEntity);
	}
	
	/**
	 * list处理
	 * */
	public List<Map<String, Object>> todoList(List<Map<String, Object>> dataList){
		if(CollectionUtils.isEmpty(dataList)){
			dataList = new ArrayList<Map<String,Object>>();
		}
		for(Map<String, Object> map : dataList){
			Set keySet = map.keySet();
			Iterator iterator = keySet.iterator();
			String enterpriseName = "";
			String userName = "";
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				Object value = map.get(key);
				if("approvalStatus".equals(key)){
					int approvalStatus = (int)value;
					if(approvalStatus==0){
						value = "UNKNOWN";
					}else if(approvalStatus==1){
						value = "WAITSUBMIT";
					}else if(approvalStatus==2){
						value = "WAITAPPROVAL";
					}else if(approvalStatus==3){
						value = "ALREADYPASS";
					}else if(approvalStatus==4){
						value = "NOPASS";
					}else if(approvalStatus==5){
						value = "TERMINATION";
					}
					map.put("approvalStatus", value);
				}else if("createTime".equals(key)){
					map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}else if("approvalDate".equals(key)){
					map.put("approvalDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}else if("updateTime".equals(key)){
					map.put("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}
				//获取企业name
				else if("enterpriseId".equals(key)){
					enterpriseName = enterpriseInfoService.getById((Long)value).getName();
				}
				//获取创建者name
				else if("createBy".equals(key)){
					userName = adminUserService.getById((Long)value).getUsername();
				}
			}
			map.put("enterpriseName", enterpriseName);
			map.put("userName", userName);
		}
		return dataList;
	}
	
	/**
	 * （企业用户专用方法）
	 * 根据园区id和企业id查询
	 * */
	@Override
	public Map<String, Object> findByParkIdAndEnterpriseId(Query query, long parkId, EnterpriseDisplayExtends extendsEntity){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//由于前端需求查询时间是闭区间，而mysql数据库将2016-12-06时间默认是2016-12-06 00:00:00，因而需要往后推一天
		try {
			if(extendsEntity.getEndTime()!=null){
				extendsEntity.setEndTime(addDate("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd").parse(extendsEntity.getEndTime()), 1));
			}
		} catch (ParseException e) {
		}
		
		
		HashMap<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("query", query);
		paramsMap.put("extendsEntity", extendsEntity);
		paramsMap.put("parkId", parkId);
		
		int total = total = this.enterpriseDisplayEntityExtendsMapper.findCountByParkidAndEnterpriseId(paramsMap);
		dataMap.put("offset", query.getOffset());
		dataMap.put("limit", query.getLimit());
		dataMap.put("total", total);
		
		List<Map<String, Object>> dataList = dataList = this.enterpriseDisplayEntityExtendsMapper.selectByEnterpriseIds(paramsMap);
		
		dataMap.put("items", todoList(dataList));
		return dataMap;
	}
	
	/**
	 * （企业用户专用接口）
     * 业端首页企业风采列表
     *（平台+当前园区的已审批的企业风采： 
     * CASE 1：当前企业未关联园区，那么只取平台已审批通过的； 
     *  CASE 2 ：当前园区关联园区，那么取平台+当前园区的已审批通过的）
     * */
	@Override
	public Map<String, Object> findForHomepage(Query query,
			EnterpriseDisplayExtends extendsEntity) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("offset", query.getOffset());
		dataMap.put("limit", query.getLimit());
		//判断当前企业关联的是园区还是平台
		String judge = createByParkOrPlatform(extendsEntity.getEnterpriseId());
		extendsEntity.setApprovalStatus(3);
		extendsEntity.setPublishLevel(1);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("query", query);
		paramsMap.put("extendsEntity", extendsEntity);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = this.enterpriseDisplayEntityExtendsMapper.selectByEnterpriseIds(paramsMap);
		if("park".equals(judge)){
			//根据企业id查询园区id，进而获取该园区下的所有企业id
			List<Long> enterpriseList = findAllParkIds(extendsEntity.getEnterpriseId());
			//查询所有与当前企业是兄弟关系的相关风采记录
			paramsMap.put("ids", enterpriseList);
			extendsEntity.setPublishLevel(2);	//园区级别
			extendsEntity.setEnterpriseId(null);
			paramsMap.put("extendsEntity", extendsEntity);
			List<Map<String, Object>> parkList = enterpriseDisplayEntityExtendsMapper.selectByEnterpriseIds(paramsMap);
			dataList.addAll(parkList);
		}
		dataMap.put("total", dataList.size());
		dataMap.put("items", todoList(dataList));
		return dataMap;
	}
	
	//针对企业用户登录后查询上传parkId下对应的企业列表
	@Override
	public Map<String, Object> findWithinParkId(Query query, long parkId, ReqSourceType reqSourceType, EnterpriseDisplayExtends extendsEntity){
		List<Long> enterpriseIdList = findEntIds(parkId, reqSourceType);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//由于前端需求查询时间是闭区间，而mysql数据库将2016-12-06时间默认是2016-12-06 00:00:00，因而需要往后推一天
		try {
			if(extendsEntity.getEndTime()!=null){
				extendsEntity.setEndTime(addDate("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd").parse(extendsEntity.getEndTime()), 1));
			}
		} catch (ParseException e) {
		}
		
		
		HashMap<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("query", query);
		paramsMap.put("extendsEntity", extendsEntity);
		paramsMap.put("ids", enterpriseIdList);
		
		int total = 0;
		if(enterpriseIdList!=null && enterpriseIdList.size()>0){
			total = this.enterpriseDisplayEntityExtendsMapper.findCountBySql(paramsMap);
		}
		dataMap.put("offset", query.getOffset());
		dataMap.put("limit", query.getLimit());
		dataMap.put("total", total);
		
		List<Map<String, Object>> dataList = null;
		if(enterpriseIdList!=null && enterpriseIdList.size()>0){
			dataList = this.enterpriseDisplayEntityExtendsMapper.selectByEnterpriseIds(paramsMap);
		}
		
		/*if(CollectionUtils.isEmpty(dataList)){
			dataList = new ArrayList<Map<String,Object>>();
		}
		
		for(Map<String, Object> map : dataList){
			Set keySet = map.keySet();
			Iterator iterator = keySet.iterator();
			String enterpriseName = "";
			String userName = "";
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				Object value = map.get(key);
				if("approvalStatus".equals(key)){
					int approvalStatus = (int)value;
					if(approvalStatus==0){
						value = "UNKNOWN";
					}else if(approvalStatus==1){
						value = "WAITSUBMIT";
					}else if(approvalStatus==2){
						value = "WAITAPPROVAL";
					}else if(approvalStatus==3){
						value = "ALREADYPASS";
					}else if(approvalStatus==4){
						value = "NOPASS";
					}else if(approvalStatus==5){
						value = "TERMINATION";
					}
					map.put("approvalStatus", value);
				}else if("createTime".equals(key)){
					map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}else if("approvalDate".equals(key)){
					map.put("approvalDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}else if("updateTime".equals(key)){
					map.put("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp)value));
				}
				//获取企业name
				else if("enterpriseId".equals(key)){
					enterpriseName = enterpriseInfoService.getById((Long)value).getName();
				}
				//获取创建者name
				else if("createBy".equals(key)){
					userName = adminUserService.getById((Long)value).getUsername();
				}
			}
			map.put("enterpriseName", enterpriseName);
			map.put("userName", userName);
		}*/
		
		dataMap.put("items", todoList(dataList));
		return dataMap;
	}
	
	//根据园区ID查找与之关联的企业ID
	public List<Long> findEntIds(Long parkId, ReqSourceType reqSourceType){
		if(parkId==null) return null;
		List<Long> enterpriseIdList = new ArrayList<Long>();
		List<EnterpriseCott> cottList = null;
		if(ReqSourceType.ADMIN_ENTERPRISE.equals(reqSourceType)){
			if(parkId==-1){
				//若是园区id为-1，则查询所有平台发布级别数据
				List<EnterpriseDisplay> list = enterpriseDisplayEntityExtendsMapper.findByPublishLevel(1);
				for(EnterpriseDisplay entity : list){
					Long id = entity.getEnterpriseId();
					if(id!=null && !enterpriseIdList.contains(id))
						enterpriseIdList.add(id);
				}
			}else{
				cottList = enterpriseCottService.getEnterPriseCottByParkId(parkId);
			}
		}else if(ReqSourceType.ADMIN_PARK.equals(reqSourceType)){
			cottList = enterpriseCottService.getEnterPriseCottByParkId(parkId);
		}else if(ReqSourceType.ADMIN_PLATFORM.equals(reqSourceType)){
			enterpriseIdList = getAllIDs();
			return enterpriseIdList;
		}else{
			return null;
		}
		if(parkId!=-1){
			for(EnterpriseCott entity : cottList){
				Long id = entity.getEnterpriseId();
				if(id!=null && !enterpriseIdList.contains(id))
					enterpriseIdList.add(id);
			}
		}
		return enterpriseIdList;
	}

	@Override
	public List<Long> getAllIDs() {
		List<Map<String, Object>> list = enterpriseDisplayEntityExtendsMapper.selectAllIDs();
		List<Long> resList = new ArrayList<Long>();
		for(Map<String, Object> map : list){
			Set keySet = map.keySet();
			Iterator iterator = keySet.iterator();
			while(iterator.hasNext()){
				String key = (String) iterator.next();
				resList.add((Long)map.get(key));
			}
		}
		return resList;
	}
	
	/**
	 * 按照某种format将指定日期增加N天
	 * */
	public static String addDate(String format, Date date, int days){
		if(StringUtils.isEmpty(format)) format = "yyyyMMdd";
		if(date==null) date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return new SimpleDateFormat(format).format(calendar.getTime());
	}

	/**
	 * 根据企业id判断其创建者是园区用户还是平台用户
	 * */
	public String createByParkOrPlatform(Long enterpriseId){
		if(enterpriseId==null) return "unknown";
		//查询企业信息
		EnterpriseInfo ei = enterpriseInfoService.getById(enterpriseId);
		if(ei!=null){
			CreateSource source = ei.getCreateSource();
			if(CreateSource.PARK.equals(source))
				return "park";
			else if(CreateSource.PLATFORM.equals(source))
				return "platform";
		}
		return "unknown";
	}
	
	/**
	 * 根据企业id查询与之关联的所有园区id集合
	 * */
	public List<Long> findAllParkIds(Long enterpriseId){
		List<EnterpriseCott> list = enterpriseCottService.getEnterPriseCottByEnterpriseId(enterpriseId, null);
		List<Long> idList = new ArrayList<Long>();
		if(list!=null){
			for(EnterpriseCott cott : list){
				Long id = cott.getParkId();
				List<EnterpriseCott> resultList = enterpriseCottService.getEnterPriseCottByParkId(id);
				if(resultList!=null){
					for(EnterpriseCott c : resultList){
						Long idd = c.getEnterpriseId();
						if(!idList.contains(idd))
							idList.add(idd);
					}
				}
			}
		}
		return idList;
	}

}