package com.sudaotech.sms.service;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.sudaotech.core.Storable;

public class PhoneCode implements Storable {

    private String cellphone;

    private String phoneCode;

    public PhoneCode() {
        super();
    }

    public PhoneCode(String cellphone) {
        this.cellphone = cellphone;
    }

    public PhoneCode(String cellphone, String phoneCode) {
        this.cellphone = cellphone;
        this.phoneCode = phoneCode;
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

    @JsonIgnore
    @Override
    public String getStorableId() {
        return this.cellphone;
    }

    @JsonIgnore
    @Override
    public int getExpires() {
        return 1800;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cellphone == null) ? 0 : cellphone.hashCode());
        result = prime * result + ((phoneCode == null) ? 0 : phoneCode.hashCode());
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

        PhoneCode other = (PhoneCode) obj;

        if (cellphone == null) {
            if (other.cellphone != null) {
                return false;
            }
        } else if (!cellphone.equals(other.cellphone)) {
            return false;
        }

        if (phoneCode == null) {
            if (other.phoneCode != null) {
                return false;
            }
        } else if (!phoneCode.equals(other.phoneCode)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "PhoneCode [cellphone=" + cellphone + ", phoneCode=" + phoneCode + "]";
    }

}
