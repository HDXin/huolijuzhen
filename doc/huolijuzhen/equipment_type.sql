drop table if exists equipment_type;

/*==============================================================*/
/* Table: equipment_type                                        */
/*==============================================================*/
create table equipment_type
(
   id                   bigint not null comment '主键',
   code                 varchar(300) comment '设备类别代码',
   name                 varchar(300) comment '设备类别名称',
   parkId               bigint comment '所属园区',
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
   deleteTime           datetime comment '删除时间',
   deleteBy             bigint comment '删除人',
   primary key (id)
);

alter table equipment_type comment '设备类型表';