package com.sudaotech.huolijuzhen.park.service;

import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public interface ParkGroupParkInfoService extends BaseService {

    public ParkGroupParkInfo getById(Long id);

    public List<ParkGroupParkInfo> getByParkGroupId(Long id);

    public Long create(ParkGroupParkInfo obj);

    public void updateStatusByParkGroupIds(Status status, List<ParkGroupParkInfo> parkGroupIds);

    public void update(ParkGroupParkInfo obj);

    public Long save(ParkGroupParkInfo obj);

    public Page<ParkGroupParkInfo> find(Query query);

    public static class Query extends Pagination {
    }

    public static class ParkGroupParkInfo extends ParkGroupParkInfoEntity {

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
