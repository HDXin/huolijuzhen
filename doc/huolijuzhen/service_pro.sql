drop table if exists service_pro;

/*==============================================================*/
/* Table: service_pro                                           */
/*==============================================================*/
create table service_pro
(
   id                   bigint not null comment '主键',
   mainTitle            varchar(90) comment '主标题',
   subTitle             varchar(90) comment '副标题',
   serviceTypeId        bigint comment '服务商类型',
   serviceScenarioId    bigint comment '服务商场景',
   content              text comment '服务商详情描述',
   serverGrade          int default 0 comment '服务对象（1.平台，2.园区）',
   serviceGrade         int default 0 comment '服务项目级别（1.平台自营，2.园区自营，3.平台服务商，4.园区服务商）',
   serviceGradeId       bigint comment '服务级别名称（园区 ID、服务商 ID）',
   serviceGradeName     varchar(30) comment '服务级别名称（园区名、服务商名）',
   parkId               bigint comment '所属园区（serviceGrade 为园区自营、园区服务商 时用）',
   supportApply         boolean comment '是否支持申请单',
   applyViewId          bigint comment '申请单显示',
   supportOrder         boolean comment '是否支持订单',
   orderViewId          bigint comment '订单显示',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(100) comment '审批备注',
   parkProId            bigint comment '园区选择省份',
   parkCityId           bigint comment '园区选择城市',
   parkCounId           bigint comment '园区选择县区',
   parkLocationId       bigint comment '园区选择商业圈',
   applyOrderNum        int default 0 comment '申请单订单数',
   collectNum           int default 0 comment '收藏数',
   readNum              int default 0 comment '点击数',
   releases				int default 0 comment '服务项目版本号（从 0 开始）',
   commentNum           decimal(10,1) default 0 comment '评论星级',
   primary key (id)
);

alter table service_pro comment '服务项目信息表';
