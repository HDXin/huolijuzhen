drop table if exists service_pro_scane;

/*==============================================================*/
/* Table: service_pro_scane                                     */
/*==============================================================*/
create table service_pro_scane
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目 ID',
   serviceScaneId       bigint comment '服务场景 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   serviceProRelease	   int default 0 comment '服务项目版本号（从 0 开始）',
   isPast				   int default 0 comment '是否是历史版本（0：非，1:是）',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table service_pro_scane comment '服务项目场景表';
