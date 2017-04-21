package com.sudaotech.user.service;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountService.Account;
import com.sudaotech.core.crypt.PasswordCrypt;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.user.dao.AppUserEntity;
import com.sudaotech.user.dao.AppUserEntityExample;
import com.sudaotech.user.dao.AppUserEntityExample.Criteria;
import com.sudaotech.user.dao.AppUserEntityMapper;
import com.sudaotech.user.enums.UserStatus;
import com.sudaotech.util.BeanUtils;

public class AppUserServiceImpl extends BaseServiceImpl implements AppUserService {
//    private static final Long UNKNOWN = 0L;
    private static final String TRACKING_TYPE = "User";

    @Inject
    private AccountService accountService;

    @Inject
    private AppUserEntityMapper userEntityMapper;
    
    /*@Inject
    private MqService mqService;*/
    
	@Override
	public AppUser getById(Long userId) {
		AppUserEntity entity = this.userEntityMapper.selectByPrimaryKey(userId);
		if (entity != null && !Status.DELETED.equals(entity.getStatus())) {
		    AppUser user = BeanUtils.copyProperties(entity, AppUser.class);
			user.setPermissions(this.accountService.getPermissionsByUserId(userId));
			return this.handleEncoding(user);
		}
		
		return null;
	}

	@Override
	public Long create(AppUser obj) {
		logger.debug("Creating User: {}", obj);
		
		if (obj.getUserType() == null) {
			//用户类型空时，默认为普通用户
	       // obj.setUserType(UserType.NORMAL_USER_TYPE_ID.code());
		}
		
		// 密码加密
        obj.setPassword(PasswordCrypt.encrypt(obj.getPassword()));

        obj.setUserId(this.getSequenceService().nextLong());
        
		// register an account at first
        Account account = BeanUtils.copyProperties(obj, Account.class);
        this.accountService.createAccount(account);

        // create user
        obj.setUserStatus(UserStatus.NORMAL);
        obj.setStatus(Status.NORMAL);
        obj.setCreateBy(obj.getOperator());
        obj.setCreateTime(new Date());
		
		AppUserEntity entity = BeanUtils.copyProperties(obj, AppUserEntity.class);

		this.userEntityMapper.insertSelective(entity);
		
		this.getTrackingService().save(TRACKING_TYPE, entity.getUserId(), "create", entity);
		
		/*mqService.sendMqMsg(RoutingKey.APPUSER_CREATE.sendKey(), JsonUtil.toJson(obj));*/
		
		logger.info("Created User: {}", obj);
		
		return obj.getUserId();
	}

	@Override
	public void update(AppUser obj) {
		logger.debug("Updating User: {}", obj);
		if (StringUtils.isBlank(obj.getPassword())) {
		    obj.setPassword(null);
		} else {
            // 密码加密
            obj.setPassword(PasswordCrypt.encrypt(obj.getPassword()));
		}

		AppUserEntity entity = BeanUtils.copyProperties(obj, AppUserEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.userEntityMapper.updateByPrimaryKeySelective(entity);
		
		this.accountService.updateAccount(BeanUtils.copyProperties(obj, Account.class));

		this.getTrackingService().save(TRACKING_TYPE, entity.getUserId(), "update", entity);

		logger.info("Updated User: {}", obj);
	}

	@Override
	public Page<AppUser> find(Query query) {
		Page<AppUser> page = new Page<AppUser>(query);
		AppUserEntityExample example = new AppUserEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andHiddenEqualTo(0); // 非隐藏用户
		
		if (query.getUserType() != null) {
	        criteria.andUserTypeEqualTo(query.getUserType());
		}
		
		if (query.getStatus() != null) {
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
			List<AppUserEntity> list = this.userEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(this.handleEncoding(BeanUtils.copyListProperties(list, AppUser.class)));
		}
		
		return page;
	}

    @Override
    public AppUser getByCellphone(String cellphone) {
        AppUserEntityExample example = new AppUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED).andCellphoneEqualTo(cellphone);
        List<AppUserEntity> list = this.userEntityMapper.selectByExample(example);

        AppUser appUser = CollectionUtils.isEmpty(list) ? null : BeanUtils.copyProperties(list.get(0), AppUser.class);
        return this.handleEncoding(appUser);
    }

    @Override
    public AppUser getByUsername(String username) {
        AppUserEntityExample example = new AppUserEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(Status.DELETED).andUsernameEqualTo(username);
        List<AppUserEntity> list = this.userEntityMapper.selectByExample(example);

        AppUser appUser = CollectionUtils.isEmpty(list) ? null : BeanUtils.copyProperties(list.get(0), AppUser.class);
        return this.handleEncoding(appUser);
    }
    
    /**
     * 处理名字、昵称中乱码的问题
     * @param user
     * @return
     */
    private AppUser handleEncoding(AppUser user) {
        if (user != null) {
            try {
                if (StringUtils.isNotBlank(user.getNickname())) {
                    user.setNickname(URLDecoder.decode(user.getNickname(), "utf8"));
                }
                if (StringUtils.isNotBlank(user.getName())) {
                    user.setName(URLDecoder.decode(user.getName(), "utf8"));
                }
            } catch (Exception e) {
                this.logger.error(e.getMessage(), e);
            }
        }
        
        return user;
    }
    private List<AppUser> handleEncoding(List<AppUser> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (AppUser user : list) {
                this.handleEncoding(user);
            }
        }
        
        return list;
    }
    
	@Override
	public Page<AppUser> queryByPage(Query query) {
		Page<AppUser> page = new Page<AppUser>(query);
		AppUserEntityExample example = new AppUserEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
		List<AppUserEntity> list = this.userEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
		page.setItems(BeanUtils.copyListProperties(list, AppUser.class));
		
		return page;
	}

	@Override
	public int getTotal() {
		AppUserEntityExample example = new AppUserEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		return userEntityMapper.countByExample(example);
	}
}
