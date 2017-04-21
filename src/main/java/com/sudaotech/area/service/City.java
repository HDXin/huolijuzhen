package com.sudaotech.area.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class City extends Area {
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
    private List<Area> areas = new ArrayList<Area>();
    public List<Area> getAreas() {
        return areas;
    }
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
    public void addArea(Area area) {
        this.areas.add(area);
    }
}
