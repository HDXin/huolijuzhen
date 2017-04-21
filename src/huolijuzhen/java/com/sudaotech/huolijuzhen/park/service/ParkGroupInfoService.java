package com.sudaotech.huolijuzhen.park.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntity;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.user.service.AdminUserService;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public interface ParkGroupInfoService extends BaseService {

    public ParkGroupInfo getById(Long id);

    public Long create(ParkGroupInfo obj);

    public void update(ParkGroupInfo obj);

    public Long save(ParkGroupInfo obj);

    public ParkGroupInfo findByQuery(Query query);

    public Page<ParkGroupInfo> find(Query query);

    public static class Query extends Pagination {
        private String name;
        private EnableStatus enableStatus;

        public EnableStatus getEnableStatus() {
            return enableStatus;
        }

        public void setEnableStatus(EnableStatus enableStatus) {
            this.enableStatus = enableStatus;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ParkGroupInfo extends ParkGroupInfoEntity {

        private List<AdminUserService.AdminUser> adminUserList;

        private List<ParkInfoService.ParkInfo> parkInfoList;

        List<ParkGroupUserInfoService.ParkGroupUserInfo> parkGroupUserInfoList;

        List<ParkGroupParkInfoService.ParkGroupParkInfo> parkGroupParkInfoList;

        public List<ParkGroupUserInfoService.ParkGroupUserInfo> getParkGroupUserInfoList() {
            return parkGroupUserInfoList;
        }

        public void setParkGroupUserInfoList(List<ParkGroupUserInfoService.ParkGroupUserInfo> parkGroupUserInfoList) {
            this.parkGroupUserInfoList = parkGroupUserInfoList;
        }

        public List<ParkGroupParkInfoService.ParkGroupParkInfo> getParkGroupParkInfoList() {
            return parkGroupParkInfoList;
        }

        public void setParkGroupParkInfoList(List<ParkGroupParkInfoService.ParkGroupParkInfo> parkGroupParkInfoList) {
            this.parkGroupParkInfoList = parkGroupParkInfoList;
        }

        public List<AdminUserService.AdminUser> getAdminUserList() {
            return adminUserList;
        }

        public void setAdminUserList(List<AdminUserService.AdminUser> adminUserList) {
            this.adminUserList = adminUserList;
        }

        public List<ParkInfoService.ParkInfo> getParkInfoList() {
            return parkInfoList;
        }

        public void setParkInfoList(List<ParkInfoService.ParkInfo> parkInfoList) {
            this.parkInfoList = parkInfoList;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
