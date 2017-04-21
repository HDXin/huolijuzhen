package com.sudaotech.huolijuzhen.community.dao;

public class CommunityEntityWithBLOBs extends CommunityEntity {
    private String content;

    private String operatorHistory;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getOperatorHistory() {
        return operatorHistory;
    }

    public void setOperatorHistory(String operatorHistory) {
        this.operatorHistory = operatorHistory == null ? null : operatorHistory.trim();
    }
}