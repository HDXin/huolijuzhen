package com.sudaotech.huolijuzhen.community.dao;

import java.util.List;
import java.util.Map;

import com.sudaotech.huolijuzhen.util.ConvertUtils;

public class LocationCommunityApplyEntitySqlProvider {

    public String statistics(Map<String,Object> params){
    	List<Long> communityIds = (List<Long>)params.get("communityIds");
    	StringBuilder selectSql = new StringBuilder();
    	selectSql.append("SELECT communityId communityId,COUNT(id) applyCount,SUM(num) totalNum FROM community_apply");
    	selectSql.append(" WHERE communityId IN" + ConvertUtils.toStr(communityIds));
    	selectSql.append(" GROUP BY communityId");
    	return selectSql.toString();
    }
}