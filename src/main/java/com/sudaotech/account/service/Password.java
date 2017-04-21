package com.sudaotech.account.service;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.sudaotech.core.Constants;
import com.sudaotech.core.Storable;

public class Password implements Storable {

    private Integer userId;
    private String password;

    public Password() {
        super();
    }

    public Password(Integer userId) {
        this.userId = userId;
    }

    public Password(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
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

    @JsonIgnore
    @Override
    public Integer getStorableId() {
        return this.userId;
    }

    @JsonIgnore
    @Override
    public int getExpires() {
        return Constants.ONE_HOUR_TIME;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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

        Password other = (Password) obj;

        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }

        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Password [userId=" + userId + ", password=" + password + "]";
    }

}
