drop table if exists provider_info;

/*==============================================================*/
/* Table: provider_info                                         */
/*==============================================================*/
create table provider_info
(
   id                   bigint not null comment '主键',
   name                 varchar(60) comment '服务商名称',
   proId                bigint comment '所属省份',
   cityId               bigint comment '所属城市',
   counId               bigint comment '所属县/区',
   contacts             varchar(30) comment '联系人',
   phone                varchar(11) comment '联系电话',
   account              varchar(60) comment '服务商账号',
   description          varchar(300) comment '服务商简介',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方（1.平台，2.园区）',
   parkId               bigint comment '创建方为园区时使用',
   enableStatus         int default 0 comment '启用状态（1.已启用，2.已禁用）',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   primary key (id)
);

alter table provider_info comment '服务商信息表';
