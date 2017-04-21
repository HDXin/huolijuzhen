package com.sudaotech.account.service;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.Updatable;
import com.sudaotech.core.enums.PlatformSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends Updatable {
    private Long roleId;

    private String name;

    private String description;

    private Integer scope;
    
    //所属平台
    private PlatformSource platformSource;
    //所属平台Id
    private Long platformSourceId ;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private List<String> permissions;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
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

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Role other = (Role) obj;

        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (permissions == null) {
            if (other.permissions != null) {
                return false;
            }
        } else if (!permissions.equals(other.permissions)) {
            return false;
        }

        if (roleId == null) {
            if (other.roleId != null) {
                return false;
            }
        } else if (!roleId.equals(other.roleId)) {
            return false;
        }

        if (scope != other.scope) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [roleId=");
        builder.append(roleId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", scope=");
        builder.append(scope);
        builder.append(", permissions=");
        builder.append(permissions);
        builder.append("]");
        return builder.toString();
    }

}