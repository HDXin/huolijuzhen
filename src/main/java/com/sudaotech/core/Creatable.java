package com.sudaotech.core;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.web.serialize.DateSerializer;

public abstract class Creatable {

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private Integer createBy;

    @JsonSerialize(using=DateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
    private Date createTime;

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
        result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
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

        Creatable other = (Creatable) obj;

        if (createBy == null) {
            if (other.createBy != null) {
                return false;
            }
        } else if (!createBy.equals(other.createBy)) {
            return false;
        }

        if (createTime == null) {
            if (other.createTime != null) {
                return false;
            }
        } else if (!createTime.equals(other.createTime)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Creatable [createBy=");
        builder.append(createBy);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append("]");
        return builder.toString();
    }

}