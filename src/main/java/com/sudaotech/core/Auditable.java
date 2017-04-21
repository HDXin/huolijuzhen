package com.sudaotech.core;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.enums.AuditStatus;
import com.sudaotech.core.web.serialize.DateSerializer;
import com.sudaotech.core.web.serialize.EnumTypeSerializer;

public abstract class Auditable extends Updatable {

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL, using=EnumTypeSerializer.class)
    private AuditStatus auditStatus;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private Integer auditBy;

    @JsonSerialize(using = DateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
    private Date auditTime;

    public Integer getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(Integer auditBy) {
        this.auditBy = auditBy;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((auditBy == null) ? 0 : auditBy.hashCode());
        result = prime * result + ((auditStatus == null) ? 0 : auditStatus.hashCode());
        result = prime * result + ((auditTime == null) ? 0 : auditTime.hashCode());
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

        Auditable other = (Auditable) obj;

        if (auditBy == null) {
            if (other.auditBy != null) {
                return false;
            }
        } else if (!auditBy.equals(other.auditBy)) {
            return false;
        }

        if (auditStatus != other.auditStatus) {
            return false;
        }

        if (auditTime == null) {
            if (other.auditTime != null) {
                return false;
            }
        } else if (!auditTime.equals(other.auditTime)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auditable [auditStatus=");
        builder.append(auditStatus);
        builder.append(", auditBy=");
        builder.append(auditBy);
        builder.append(", auditTime=");
        builder.append(auditTime);
        builder.append("]");
        return builder.toString();
    }

}