package com.sudaotech.user.service;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.PasswordSerializer;
import com.sudaotech.user.dao.AppUserEntity;
import com.sudaotech.user.enums.UserStatus;

public interface AppUserService extends BaseService {
	
    public AppUser getById(Long userId);

    public Long create(AppUser obj);

    public void update(AppUser obj);

    public Page<AppUser> find(Query query);

    public AppUser getByCellphone(String cellphone);

    public AppUser getByUsername(String username);
    
    public Page<AppUser> queryByPage(Query query);
    
    public int getTotal();
    
    public static class Query extends Pagination {
    	private Long userId;
        private String cellphone;
        private String username;
        private String nickname;
        private String name;
        private Status status;
        private Long userType;
        public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
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
    }
    
    public static class AppUser extends AppUserEntity {
        
        private List<String> permissions;
        private List<Integer> roleIds;
        @JsonSerialize(using=PasswordSerializer.class)
        private String password;
        private String signature;//个性签名
        private String userTypeName;
        private String cityCode; //城市code
        private boolean received;  //是否已领单
        private Date  lastLoginTime;  //最后登录时间
        
		/*//用户扩展信息
    	private VcUserAttr vua;
    	//用户头像信息
    	private VcUserPhoto vup;
    	//用户图片信息
		private List<VcUserPhoto> vcUserPhotoList;
        
        public VcUserAttr getVua() {
			return vua;
		}
		public void setVua(VcUserAttr vua) {
			this.vua = vua;
		}
		public VcUserPhoto getVup() {
			return vup;
		}
		public void setVup(VcUserPhoto vup) {
			this.vup = vup;
		}*/
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
        public List<Integer> getRoleIds() {
            return roleIds;
        }
        public void setRoleIds(List<Integer> roleIds) {
            this.roleIds = roleIds;
        }
		public String getSignature() {
			return signature;
		}
		public void setSignature(String signature) {
			this.signature = signature;
		}
		public String getUserTypeName() {
			return userTypeName;
		}
		public void setUserTypeName(String userTypeName) {
			this.userTypeName = userTypeName;
		}
		
       	public String getCityCode() {
			return cityCode;
		}
		public boolean isReceived() {
			return received;
		}
		public void setReceived(boolean received) {
			this.received = received;
		}
		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}
	/*	public List<VcUserPhoto> getVcUserPhotoList() {
			return vcUserPhotoList;
		}
		public void setVcUserPhotoList(List<VcUserPhoto> vcUserPhotoList) {
			this.vcUserPhotoList = vcUserPhotoList;
		}*/
		public Date getLastLoginTime() {
			return lastLoginTime;
		}
		public void setLastLoginTime(Date lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}
		
    }
    
    public static class UserName {
        private Integer userId;
        private String name;
        public Integer getUserId() {
            return userId;
        }
        public void setUserId(Integer userId) {
            this.userId = userId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public static class AppUserIndex{
    	private Long userId;
    	private String photo;
    	private String cellphone;
    	private String nickname;
    	private Long userType;
    	private String userTypeName;
    	private Date createTime;
    	private UserStatus userStatus;
    	private Date lastLoginTime;
    	private String signature;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
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
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public UserStatus getUserStatus() {
			return userStatus;
		}
		public void setUserStatus(UserStatus userStatus) {
			this.userStatus = userStatus;
		}
		public String getUserTypeName() {
			return userTypeName;
		}
		public void setUserTypeName(String userTypeName) {
			this.userTypeName = userTypeName;
		}
		public Date getLastLoginTime() {
			return lastLoginTime;
		}
		public void setLastLoginTime(Date lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}
		public String getSignature() {
			return signature;
		}
		public void setSignature(String signature) {
			this.signature = signature;
		}
    }
}
