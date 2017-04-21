package com.sudaotech.huolijuzhen.park.service;

import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public interface ParkGroupUserInfoService extends BaseService {

    public ParkGroupUserInfo getById(Long id);

    public List<ParkGroupUserInfo> getByParkGroupId(Long parkGroupId);

    public Long create(ParkGroupUserInfo obj);

    public void update(ParkGroupUserInfo obj);

    public void updateStatusByParkGroupIds(Status status,List<ParkGroupUserInfo> parkGroupIds);

    public Long save(ParkGroupUserInfo obj);

    public Page<ParkGroupUserInfo> find(Query query);

    public static class Query extends Pagination {
    }

    public static class ParkGroupUserInfo extends ParkGroupUserInfoEntity {

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
