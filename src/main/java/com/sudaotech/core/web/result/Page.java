package com.sudaotech.core.web.result;

import java.util.LinkedList;
import java.util.List;

public class Page<T> extends Pagination {
    private List<T> items = new LinkedList<T>();

    public Page() {
    }

    public Page(Pagination pagination) {
        super(pagination);
    }

    public List<T> getItems() {
        return items;
    }

    public Page<T> addItem(T obj) {
        items.add(obj);
        return this;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page [items=" + items + ", super=" + super.toString() + "]";
    }

}
