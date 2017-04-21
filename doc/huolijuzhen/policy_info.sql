drop table if exists policy_info;

/*==============================================================*/
/* Table: policy_info                                           */
/*==============================================================*/
create table policy_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '政策标题',
   polUri               varchar(300) comment '政策链接',
   publicGrade          int default 0 comment '政策级别（1.平台，2.按行政）',
   parkId               bigint comment '对象园区（publicGrade 为 3 时时用，备用）',
   proId                bigint comment '省（publicGrade 为 2 时用）',
   cityId               bigint comment '城市（publicGrade 为 2 时用）',
   counId               bigint comment '县区（publicGrade 为 2 时用）',
   locationId           bigint comment '对象行政位置（publicGrade 为 2 时用）',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方类型（1.平台，2.园区，3.企业）',
   createSideId         bigint comment '创建方（园区 ID 或 企业 ID）',
   readNum              int default 0 comment '点击数',
   primary key (id)
);

alter table policy_info comment '政策信息表';
