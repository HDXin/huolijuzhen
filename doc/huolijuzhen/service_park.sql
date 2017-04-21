drop table if exists service_park;

/*==============================================================*/
/* Table: service_park                                          */
/*==============================================================*/
create table service_park
(
   id                   bigint not null comment '主键',
   serviceId            bigint comment '服务项目 ID',
   parkId               bigint comment '园区 ID',
   chooseStatus         int default 0 comment '选用状态',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);
