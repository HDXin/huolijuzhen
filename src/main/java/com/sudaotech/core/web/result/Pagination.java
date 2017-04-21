package com.sudaotech.core.web.result;

public class Pagination {
    public static final int MAX_LIMIT = 1000; // 单页最大
    private Integer offset = 0;
    private Integer limit = 16;
    private Integer total = 0;
    
    // TODO remove the following unused fields
    private String sortField = "lastUpdate";
    private String sortOrder = "DESC";

    public Pagination() {
    }

    public Pagination(Integer offset, Integer limit) {
        this.setOffset(offset);
        this.setLimit(limit);
    }

    public Pagination(Pagination pagination) {
        if (pagination == null) {
            throw new NullPointerException("pagination is null");
        }
        this.offset = pagination.offset;
        this.limit = pagination.limit;
        this.total = pagination.total;
        if (pagination.getSortField() != null) {
        	this.sortField = pagination.getSortField();
        }
        if (pagination.getSortOrder() != null) {
        	this.sortOrder = pagination.getSortOrder();
        }
    }
    
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if (offset != null && offset >= 0) {
            this.offset = offset;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit != null && limit > 0) {
            if (limit > MAX_LIMIT) {
                limit = MAX_LIMIT;
            }
            this.limit = limit;
        }
    }

    public void setPage(Integer page) {
        if (page != null && page > 0) {
        	this.setOffset((page - 1) * this.limit);
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if (total != null) {
            this.total = total;
        }
    }

    public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
    
    public Integer getStartPage(){
    	return offset / limit + 1;
    }

	@Override
    public String toString() {
        return "Pagination [offset=" + offset + ", limit=" + limit + ", total=" + total + "]";
    }
}
