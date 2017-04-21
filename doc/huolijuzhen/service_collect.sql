drop table if exists service_collect;

/*==============================================================*/
/* Table: service_collect                                       */
/*==============================================================*/
create table service_collect
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目',
   parkId               bigint comment '园区',
   collectBy            bigint comment '收藏人',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table service_collect comment '服务项目收藏表';
