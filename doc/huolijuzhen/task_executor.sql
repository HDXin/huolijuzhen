drop table if exists task_executor;

/*==============================================================*/
/* Table: task_executor                                         */
/*==============================================================*/
create table task_executor
(
   id                   bigint not null comment '主键',
   taskId               bigint comment '任务ID',
   executorId           bigint comment '执行人 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);
