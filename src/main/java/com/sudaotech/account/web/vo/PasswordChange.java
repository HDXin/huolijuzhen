package com.sudaotech.account.web.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sudaotech.core.enums.Type;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordChange {

	private Integer userId;

	private String password;

	private String newPassword;

	private String cellphone;

	private String phoneCode;
	
	private Type userType;

	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type userType) {
		this.userType = userType;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "PasswordChange [userId=" + userId + ", password=" + password + ", newPassword=" + newPassword + "]";
	}

}
