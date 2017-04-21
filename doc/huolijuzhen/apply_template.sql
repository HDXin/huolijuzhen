drop table if exists apply_template;

/*==============================================================*/
/* Table: apply_template                                        */
/*==============================================================*/
create table apply_template
(
   id                   bigint not null comment '主键',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_template comment '服务申请表模板';
