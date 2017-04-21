package com.sudaotech.account.web.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CellphoneChange {

    private String oldCellphone;

    private String oldPhoneCode;

    private String newCellphone;

    private String newPhoneCode;

    public String getOldCellphone() {
        return oldCellphone;
    }

    public void setOldCellphone(String oldCellphone) {
        this.oldCellphone = oldCellphone;
    }

    public String getOldPhoneCode() {
        return oldPhoneCode;
    }

    public void setOldPhoneCode(String oldPhoneCode) {
        this.oldPhoneCode = oldPhoneCode;
    }

    public String getNewCellphone() {
        return newCellphone;
    }

    public void setNewCellphone(String newCellphone) {
        this.newCellphone = newCellphone;
    }

    public String getNewPhoneCode() {
        return newPhoneCode;
    }

    public void setNewPhoneCode(String newPhoneCode) {
        this.newPhoneCode = newPhoneCode;
    }

}
