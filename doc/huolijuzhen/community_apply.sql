drop table if exists community_apply;

/*==============================================================*/
/* Table: community_apply                                       */
/*==============================================================*/
create table community_apply
(
   id                   bigint not null comment '主键',
   orderNo              varchar(60) comment '单据编号',
   companyId            bigint comment '所属企业',
   companyName          varchar(60) comment '企业名称',
   parkId               bigint comment '所属园区',
   applyTime            datetime comment '申请日期',
   proprser             varchar(30) comment '申请人',
   phone                varchar(11) comment '联系方式',
   num                  int default 0 comment '申请参与人数',
   describle            varchar(300) comment '备注',
   communityId          bigint comment '申请的活动',
   communityName        varchar(60) comment '活动名称',
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
   createSide           int default 0 comment '活动创建方（用与活动查询）',
   createSideId         bigint comment '活动创建方ID',
   primary key (id)
);

alter table community_apply comment '社群活动申请表';
