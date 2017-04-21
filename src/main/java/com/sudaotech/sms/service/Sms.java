package com.sudaotech.sms.service;

import com.sudaotech.core.Updatable;
import com.sudaotech.core.enums.Status;
import com.sudaotech.sms.SmsStatus;


public class Sms extends Updatable {

    private Long smsId;

    /**
     * 发送电话号码
     */
    private String phoneNum;

    private String content;

    /**
     * 定时发送时间
     * 格式 2014-11-07 17:10:00
     */
    private String sendTimeOut;

    private SmsStatus smsStatus;

    private Status status;

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTimeOut() {
        return sendTimeOut;
    }

    public void setSendTimeOut(String sendTimeOut) {
        this.sendTimeOut = sendTimeOut;
    }

    public SmsStatus getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(SmsStatus smsStatus) {
        this.smsStatus = smsStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
        result = prime * result + ((sendTimeOut == null) ? 0 : sendTimeOut.hashCode());
        result = prime * result + ((smsId == null) ? 0 : smsId.hashCode());
        result = prime * result + ((smsStatus == null) ? 0 : smsStatus.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sms other = (Sms) obj;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (phoneNum == null) {
            if (other.phoneNum != null)
                return false;
        } else if (!phoneNum.equals(other.phoneNum))
            return false;
        if (sendTimeOut == null) {
            if (other.sendTimeOut != null)
                return false;
        } else if (!sendTimeOut.equals(other.sendTimeOut))
            return false;
        if (smsId == null) {
            if (other.smsId != null)
                return false;
        } else if (!smsId.equals(other.smsId))
            return false;
        if (smsStatus != other.smsStatus)
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sms [smsId=" + smsId + ", phoneNum=" + phoneNum + ", content=" + content + ", sendTimeOut="
                + sendTimeOut + ", smsStatus=" + smsStatus + ", status=" + status + "]";
    }
    
}
