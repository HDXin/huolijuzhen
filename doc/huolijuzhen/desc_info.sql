drop table if exists desc_info;

/*==============================================================*/
/* Table: desc_info                                             */
/*==============================================================*/
create table desc_info
(
   id                   bigint not null comment '主键',
   desciption           varchar(600) comment '描述',
   enableStatus         int default 0 comment '启用状态',
   parkId               bigint comment '所属园区',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   primary key (id)
);

alter table desc_info comment '常用描述表';
