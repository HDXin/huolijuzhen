package com.sudaotech.area.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Province extends Area {
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
    private List<City> cities = new ArrayList<City>();
    public List<City> getCities() {
        return cities;
    }
    public void addCity(City city) {
        this.cities.add(city);
    }
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}