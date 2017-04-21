package com.sudaotech.area.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;


public class Area {
    private Integer areaId;

    private String adcode;

    private String name;

    private Integer parentId;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
    private List<Area> items = new ArrayList<Area>();

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Area> getItems() {
        return items;
    }

    public void setItems(List<Area> items) {
        this.items = items;
    }
    public void addItem(Area item) {
        this.items.add(item);
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adcode == null) ? 0 : adcode.hashCode());
        result = prime * result + ((areaId == null) ? 0 : areaId.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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

        Area other = (Area) obj;

        if (adcode == null) {
            if (other.adcode != null) {
                return false;
            }
        } else if (!adcode.equals(other.adcode)) {
            return false;
        }

        if (areaId == null) {
            if (other.areaId != null) {
                return false;
            }
        } else if (!areaId.equals(other.areaId)) {
            return false;
        }

        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (parentId == null) {
            if (other.parentId != null) {
                return false;
            }
        } else if (!parentId.equals(other.parentId)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Area [areaId=");
        builder.append(areaId);
        builder.append(", adcode=");
        builder.append(adcode);
        builder.append(", name=");
        builder.append(name);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", items=");
        builder.append(items);
        builder.append("]");
        return builder.toString();
    }

}