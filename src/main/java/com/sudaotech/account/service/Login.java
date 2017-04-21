package com.sudaotech.account.service;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.web.serialize.DateSerializer;
import com.sudaotech.core.web.serialize.PasswordSerializer;
import com.sudaotech.core.enums.PlatformSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

    private String username;
    private String cellphone;
    //登录来源
    private PlatformSource platformSource;

    private Long userId;
    
    // 第三方登陆的openid
    private String openid;

    @NotNull(message="password required")
    @JsonSerialize(using=PasswordSerializer.class)
    private String password;

    private String captcha;

    private Long userType;

    private String ip;
    private String lng;
    private String lat;

    private String systemId;

    private boolean remember = false;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public boolean isRemember() {
        return remember;
    }

    @JsonSerialize(using=DateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
    private Date loginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public boolean getRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

	public PlatformSource getPlatformSource() {
		return platformSource;
	}

	public void setPlatformSource(PlatformSource platformSource) {
		this.platformSource = platformSource;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((captcha == null) ? 0 : captcha.hashCode());
        result = prime * result + ((cellphone == null) ? 0 : cellphone.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((lat == null) ? 0 : lat.hashCode());
        result = prime * result + ((lng == null) ? 0 : lng.hashCode());
        result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (remember ? 1231 : 1237);
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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

        Login other = (Login) obj;

        if (captcha == null) {
            if (other.captcha != null) {
                return false;
            }
        } else if (!captcha.equals(other.captcha)) {
            return false;
        }

        if (cellphone == null) {
            if (other.cellphone != null) {
                return false;
            }
        } else if (!cellphone.equals(other.cellphone)) {
            return false;
        }

        if (ip == null) {
            if (other.ip != null) {
                return false;
            }
        } else if (!ip.equals(other.ip)) {
            return false;
        }

        if (lat == null) {
            if (other.lat != null) {
                return false;
            }
        } else if (!lat.equals(other.lat)) {
            return false;
        }

        if (lng == null) {
            if (other.lng != null) {
                return false;
            }
        } else if (!lng.equals(other.lng)) {
            return false;
        }

        if (loginTime == null) {
            if (other.loginTime != null) {
                return false;
            }
        } else if (!loginTime.equals(other.loginTime)) {
            return false;
        }

        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }

        if (remember != other.remember) {
            return false;
        }

        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }
        if (userType != other.userType) {
            return false;
        }

        return true;
    }
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Login [username=").append(username).append(", cellphone=").append(cellphone)
                .append(", userId=").append(userId).append(", openid=").append(openid).append(", password=")
                .append(password).append(", captcha=").append(captcha).append(", userType=").append(userType)
                .append(", ip=").append(ip).append(", lng=").append(lng).append(", lat=").append(lat)
                .append(", remember=").append(remember).append(", loginTime=").append(loginTime).append("]");
        return builder.toString();
    }
}
