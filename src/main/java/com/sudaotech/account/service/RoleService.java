package com.sudaotech.account.service;

import java.util.List;

import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.user.web.admin.AdminUserResource.RoleVo;

public interface RoleService extends BaseService {
    Role getById(Long roleId);
    
    List<RoleVo> getRoles(List<Long> roleIds);

    Long create(Role role);
    void update(Role role);

    public Page<Role> find(RoleQuery query);
    
    public static class RoleQuery extends Pagination {
    	private PlatformSource platformSource;
    	private Long platformSourceId ;
        private Integer scope;
        private String name;
        public Integer getScope() {
            return scope;
        }
        public void setScope(Integer scope) {
            this.scope = scope;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
		public PlatformSource getPlatformSource() {
			return platformSource;
		}
		public void setPlatformSource(PlatformSource platformSource) {
			this.platformSource = platformSource;
		}
		public Long getPlatformSourceId() {
			return platformSourceId;
		}
		public void setPlatformSourceId(Long platformSourceId) {
			this.platformSourceId = platformSourceId;
		}
		

        
    }

}
