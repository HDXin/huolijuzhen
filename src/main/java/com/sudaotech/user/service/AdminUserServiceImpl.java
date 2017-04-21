package com.sudaotech.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.account.dao.LoginHistoryEntity;
import com.sudaotech.account.dao.LoginHistoryEntityExample;
import com.sudaotech.account.dao.LoginHistoryEntityMapper;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountService.Account;
import com.sudaotech.core.crypt.PasswordCrypt;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.notice.service.NoticeEnterpriseService;
import com.sudaotech.huolijuzhen.notice.service.NoticeParkService;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.user.dao.AdminUserEntity;
import com.sudaotech.user.dao.AdminUserEntityExample;
import com.sudaotech.user.dao.AdminUserEntityExample.Criteria;
import com.sudaotech.user.dao.handler.LocationAdminUserEntityMapper;
import com.sudaotech.user.enums.UserAttributeType;
import com.sudaotech.user.enums.UserStatus;
import com.sudaotech.util.BeanUtils;

public class AdminUserServiceImpl extends BaseServiceImpl implements AdminUserService {
    private static final Long UNKNOWN = 0L;
    private static final String TRACKING_TYPE = "User";

    @Inject
    private AccountService accountService;
    
    @Inject
    private NoticeEnterpriseService noticeEnterpriseService;
    
    @Inject
    private NoticeParkService noticeParkService;
    
    
    @Inject
    private LoginHistoryEntityMapper loginHistoryEntityMapper;

    @Inject
    private LocationAdminUserEntityMapper userEntityMapper;
    

	@Override
	public AdminUser getById(Long userId) {
		AdminUserEntity entity = this.userEntityMapper.selectByPrimaryKey(userId);
		if (entity != null && !Status.DELETED.equals(entity.getStatus())) {
		    AdminUser user = BeanUtils.copyProperties(entity, AdminUser.class);
			user.setPermissions(this.accountService.getPermissionsByUserId(userId));
			user.setRoleIds(getRoleIdByUserId(userId));
            return user;
		}
		
		return null;
	}
	
	@Override
	public List<Long> getRoleIdByUserId(Long userId){
		return this.accountService.getRoleIdsByUserId(userId);
	}

	@Override
	public Long create(AdminUser obj) throws Exception {
		logger.debug("Creating User: {}", obj);
		
		if (obj.getUserType() == null) {
	        obj.setUserType(UNKNOWN);
		}
		
		// 密码加密
        obj.setPassword(PasswordCrypt.encrypt(obj.getPassword()));

        obj.setUserId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_USER));
        
		// register an account at first
        Account account = BeanUtils.copyProperties(obj, Account.class);
        this.accountService.createAccount(account);

        // create user
        obj.setUserStatus(UserStatus.NORMAL);
        obj.setStatus(Status.NORMAL);
        obj.setCreateBy(obj.getOperator());
        obj.setCreateTime(new Date());
		
		AdminUserEntity entity = BeanUtils.copyProperties(obj, AdminUserEntity.class);

		this.userEntityMapper.insertSelective(entity);
		
		this.getTrackingService().save(TRACKING_TYPE, entity.getUserId(), "create", entity);
		
		
		//将用户注册入消息服务器(排除平台用户)
        //TODO
		Long id = obj.getUserId();
		Long platformSourceId = obj.getPlatformSourceId();
		PlatformSource platform = obj.getPlatformSource();
		
		if(platformSourceId == 0 || platform == PlatformSource.PLATFORM){
			return obj.getUserId();
		}
		if(platform == PlatformSource.ENTERPRISE){
			noticeEnterpriseService.registerUser(id);
		}
		if(platform == PlatformSource.PARK){
			noticeParkService.registerUser(id);
		}
        
		logger.info("Created User: {}", obj);
		
		return obj.getUserId();
	}

	@Override
	public void update(AdminUser obj) {
		logger.debug("Updating User: {}", obj);
		if (StringUtils.isBlank(obj.getPassword())) {
		    obj.setPassword(null);
		} else {
            // 密码加密
            obj.setPassword(PasswordCrypt.encrypt(obj.getPassword()));
		}

		AdminUserEntity entity = BeanUtils.copyProperties(obj, AdminUserEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.userEntityMapper.updateByPrimaryKeySelective(entity);
		this.accountService.updateAccount(BeanUtils.copyProperties(obj, Account.class));

		this.getTrackingService().save(TRACKING_TYPE, entity.getUserId(), "update", entity);

		logger.info("Updated User: {}", obj);
	}

	@Override
	public Page<AdminUser> find(Query query) {
		Page<AdminUser> page = new Page<AdminUser>(query);
		AdminUserEntityExample example = new AdminUserEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andHiddenEqualTo(0); // 非隐藏用户
		
		if(query.getPlatformSource() !=null ){
			criteria.andPlatformSourceEqualTo(query.getPlatformSource());
		}
		
		if(query.getPlatformId() !=null ){
			criteria.andPlatformSourceIdEqualTo(query.getPlatformId());
		}
		
		if (query.getUserType() != null) {
	        criteria.andUserTypeEqualTo(query.getUserType());
		}
		
		if (query.getStatus() == null || query.getStatus() == Status.DELETED) {
	        criteria.andStatusNotEqualTo(Status.DELETED);
		} else {
		    criteria.andStatusEqualTo(query.getStatus());
		}
        if (StringUtils.isNotBlank(query.getUsername())) {
            criteria.andUsernameLike("%" + StringUtils.trim(query.getUsername()) + "%");
        }
        if (StringUtils.isNotBlank(query.getNickname())) {
            criteria.andNicknameLike("%" + StringUtils.trim(query.getNickname()) + "%");
        }
        if (StringUtils.isNotBlank(query.getName())) {
            criteria.andNameLike("%" + StringUtils.trim(query.getName()) + "%");
        }
        if (StringUtils.isNotBlank(query.getCellphone())) {
            criteria.andCellphoneEqualTo(StringUtils.trim(query.getCellphone()));
        }
		
		example.setOrderByClause("userId DESC");
		page.setTotal(this.userEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<AdminUserEntity> list = this.userEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			List<AdminUser> adminUserList = BeanUtils.copyListProperties(list, AdminUser.class);
			if (CollectionUtils.isNotEmpty(adminUserList)) {
				for (AdminUser adminUser : adminUserList) {
					getLastLoginTime(adminUser);
				}
			}
			page.setItems(adminUserList);
		}
		
		return page;
	}

	@Override
    public AdminUser getByUsername(String username) {
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusNotEqualTo(Status.DELETED);
        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);

        return CollectionUtils.isEmpty(list) ? null : BeanUtils.copyProperties(list.get(0), AdminUser.class);
    }

    @Override
    public List<AdminUser> getByCellphone(String cellphone) {
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED);
        criteria.andCellphoneEqualTo(cellphone);
        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);

        return CollectionUtils.isEmpty(list) ? null : BeanUtils.copyListProperties(list, AdminUser.class);
    }
    
    @Override
    public AdminUser getByCellphoneAndPlatformSource(String cellphone,PlatformSource platformSource) {
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED);
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPlatformSourceEqualTo(platformSource);
        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);

        return CollectionUtils.isEmpty(list) ? null : BeanUtils.copyProperties(list.get(0), AdminUser.class);
    }

    @Override
    public AdminUser getByUsernameAndPlatformSource(String username,PlatformSource platformSource) {
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusNotEqualTo(Status.DELETED);
        criteria.andPlatformSourceEqualTo(platformSource);
        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);

        return CollectionUtils.isEmpty(list) ? null : BeanUtils.copyProperties(list.get(0), AdminUser.class);
    }
    
    public void getLastLoginTime(AdminUser adminUser) {
		if (adminUser == null) {
			return;
		}
		LoginHistoryEntityExample example = new LoginHistoryEntityExample();
		example.createCriteria().andUserIdEqualTo(adminUser.getUserId());
		example.setOrderByClause("id DESC");
		List<LoginHistoryEntity> loginHistoryEntitieList = loginHistoryEntityMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(loginHistoryEntitieList)) {
			adminUser.setLastLoginTime(loginHistoryEntitieList.get(0).getLastUpdate());
		}
	}

	@Override
	public void enableUserByObj(EnableAdminUser obj) {
	
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED);
        
        criteria.andPlatformSourceIdEqualTo(obj.getPlatformSourceId());
        
        
        this.userEntityMapper.updateByExampleSelective(BeanUtils.copyProperties(obj, AdminUser.class), example);
        
		
	}

	@Override
	public List<AdminUser> getPropertyMGByParkId(Long parkId) {
		
        AdminUserEntityExample example = new AdminUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED);
        criteria.andPlatformSourceEqualTo(PlatformSource.PARK);
        criteria.andPlatformSourceIdEqualTo(parkId);
        criteria.andUserAttributeEqualTo(UserAttributeType.PROPERTY_MANAGE.code());
        
        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);
        return BeanUtils.copyListProperties(list, AdminUser.class);
	}

	@Override
	public List<AdminUser> getAdminByEnterpriseId(Long enterpriseId) {
		   AdminUserEntityExample example = new AdminUserEntityExample();
	        Criteria criteria = example.createCriteria();
	        criteria.andStatusNotEqualTo(Status.DELETED);
	        //管理员身份
	        criteria.andUserTypeEqualTo(10L);
	        //企业平台
	        criteria.andPlatformSourceEqualTo(PlatformSource.ENTERPRISE);
	        //企业Id
	        criteria.andPlatformSourceIdEqualTo(enterpriseId);
	        
	        List<AdminUserEntity> list = this.userEntityMapper.selectByExample(example);
	        return BeanUtils.copyListProperties(list, AdminUser.class);
	}

	/**
	 * 获取平台下所有的园区用户、企业用户
	 */
	@Override
	public List<Long> findAllParkEnterpriseUserId() {
		
		List<Long> adminUserIds = userEntityMapper.findAllParkEnterpriseUserId();

		return adminUserIds;
	}

	/**
	 * 获取平台下所有的园区用户
	 */
	@Override
	public List<Long> findAllParkUserId() {
		List<Long> adminUserIds = userEntityMapper.findAllParkUserId();

		return adminUserIds;
	}

	/**
	 * 获取平台下所有的企业用户
	 */
	@Override
	public List<Long> findAllEnterpriseUerId() {
		List<Long> adminUserIds = userEntityMapper.findAllEnterpriseUerId();

		return adminUserIds;
	}

	/**
	 * 获取行政区下所有的园区用户、企业用户
	 */
	@Override
	public List<Long> findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(
			List<Long> parkIds, List<Long> enterpriseIds) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parkIds", parkIds);
		params.put("enterpriseIds", enterpriseIds);
		
		List<Long> adminUserIds = userEntityMapper.findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(params);
		
		return adminUserIds;
	}

	/**
	 * 获取行政区下所有的园区用户
	 */
	@Override
	public List<Long> findAllParkUserIdByParkIds(List<Long> parkIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parkIds", parkIds);
		
		List<Long> adminUserIds = userEntityMapper.findAllParkUserIdByParkIds(params);
		
		return adminUserIds;
	}

	/**
	 * 获取行政区下所有的企业用户
	 */
	@Override
	public List<Long> findAllEnterpriseUserIdByEnterpriseIds(
			List<Long> enterpriseIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("enterpriseIds", enterpriseIds);
		
		List<Long> adminUserIds = userEntityMapper.findAllEnterpriseUserIdByEnterpriseIds(params);
		
		return adminUserIds;
	}
}
