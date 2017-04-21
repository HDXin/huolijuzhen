drop table if exists location_info;

/*==============================================================*/
/* Table: location_info                                         */
/*==============================================================*/
create table location_info
(
   id                   bigint not null comment '主键',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县/区',
   business             varchar(45) comment '商业圈',
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
   primary key (id)
);

alter table location_info comment '行政位置表';
