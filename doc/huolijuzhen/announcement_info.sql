drop table if exists announcement_info;

/*==============================================================*/
/* Table: announcement_info                                     */
/*==============================================================*/
create table announcement_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '公告标题',
   content              text comment '公告内容',
   publicGrade          int default 0 comment '公告对象级别（1.平台，2.按行政，3.园区）',
   parkId               bigint comment '对象园区（publicGrade 为 ”3 园区“  时使用）',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县区',
   locationId           bigint comment '对象行政位置（publicGrade 为 ”2.按行政“ 时使用）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   createSide           int comment '发布公告方',
   createSideId         bigint comment '发布公告',
   sendGrade            int default 0 comment '发送对象级别（1,全部，2.企业用户，3.园区用户）',
   primary key (id)
);

alter table announcement_info comment '系统公告信息';
