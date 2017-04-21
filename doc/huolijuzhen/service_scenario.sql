drop table if exists service_scenario;

/*==============================================================*/
/* Table: service_scenario                                      */
/*==============================================================*/
create table service_scenario
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '场景名称',
   serverGrade          int default 0 comment '服务场景级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '场景描述',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   scaneLogo            varchar(300) comment '图标',
   recoLogo             varchar(300) comment '推荐图标',
   primary key (id)
);

alter table service_scenario comment '服务场景表';
