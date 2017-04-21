package com.sudaotech.user.service;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.PasswordSerializer;
import com.sudaotech.user.dao.AdminUserEntity;
import com.sudaotech.user.enums.UserStatus;

public interface AdminUserService extends BaseService {

    public AdminUser getById(Long userId);

    public Long create(AdminUser obj) throws Exception;

    public void update(AdminUser obj);
    
    public void enableUserByObj(EnableAdminUser obj);

    public Page<AdminUser> find(Query query);

    public AdminUser getByUsername(String username);

    public List<AdminUser> getByCellphone(String cellphone);

    public AdminUser getByCellphoneAndPlatformSource(String cellphone,PlatformSource platformSource);

    public AdminUser getByUsernameAndPlatformSource(String username,PlatformSource platformSource);
    
    public List<Long> getRoleIdByUserId(Long userId);
    
    public List<AdminUser> getPropertyMGByParkId(Long parkId);
    
    public List<AdminUser> getAdminByEnterpriseId(Long enterpriseId);
    
    
    public static class EnableAdminUser{
    	
    	private Long platformSourceId;
    	
    	private UserStatus userStatus;

		public Long getPlatformSourceId() {
			return platformSourceId;
		}

		public void setPlatformSourceId(Long platformSourceId) {
			this.platformSourceId = platformSourceId;
		}

		public UserStatus getUserStatus() {
			return userStatus;
		}

		public void setUserStatus(UserStatus userStatus) {
			this.userStatus = userStatus;
		}

    	
    	
    	
    }
    
    public static class Query extends Pagination {
    	
    	//业务平台
      	private PlatformSource platformSource; 
    	//平台所属Id,
    	private Long platformId;
    	
        private String cellphone;
        private String username;
        private String nickname;
        private String name;
        private Status status;
        private Long userType;
        public String getCellphone() {
            return cellphone;
        }
        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }
        public String getNickname() {
            return nickname;
        }
        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
        public Long getUserType() {
            return userType;
        }
        public void setUserType(Long userType) {
            this.userType = userType;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public Status getStatus() {
            return status;
        }
        public void setStatus(Status status) {
            this.status = status;
        }
		public Long getPlatformId() {
			return platformId;
		}
		public void setPlatformId(Long platformId) {
			this.platformId = platformId;
		}
		public PlatformSource getPlatformSource() {
			return platformSource;
		}
		public void setPlatformSource(PlatformSource platformSource) {
			this.platformSource = platformSource;
		}
        
        
        
    }
    
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class AdminUser extends AdminUserEntity {
    	
        private List<String> permissions;
        
        private List<Long> roleIds;
        
        private Date lastLoginTime;

        private Long parkGroupId;
        
        private List<BindPark> bindParks;
		
		public List<BindPark> getBindParks() {
			return bindParks;
		}
		public void setBindPark(List<BindPark> bindParks) {
			this.bindParks = bindParks;
		}
		@JsonSerialize(using=PasswordSerializer.class)
        private String password;
        
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public List<String> getPermissions() {
            return permissions;
        }
        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }
        public List<Long> getRoleIds() {
            return roleIds;
        }
        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }
		public Date getLastLoginTime() {
			return lastLoginTime;
		}
		public void setLastLoginTime(Date lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}
        public Long getParkGroupId() {
            return parkGroupId;
        }
        public void setParkGroupId(Long parkGroupId) {
            this.parkGroupId = parkGroupId;
        }
        
        
        
    }
    
    public static class UserName {
        private Long userId;
        private String name;
        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public static class BindPark {
        private Long parkId;
        private Long cottId;
        
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public Long getCottId() {
			return cottId;
		}
		public void setCottId(Long cottId) {
			this.cottId = cottId;
		}
        
    }
    //获取平台下所有园区用户、企业用户
	public List<Long> findAllParkEnterpriseUserId();

	//获取平台下所有园区用户
	public List<Long> findAllParkUserId();

	//获取平台下所有企业用户
	public List<Long> findAllEnterpriseUerId();

	//获取行政区下所有园区用户、企业用户
	public List<Long> findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(
			List<Long> parkIds, List<Long> enterpriseIds);

	//获取行政区下所有园区用户
	public List<Long> findAllParkUserIdByParkIds(List<Long> parkIds);

	//获取行政区下所有企业用户
	public List<Long> findAllEnterpriseUserIdByEnterpriseIds(
			List<Long> enterpriseIds);

}