drop table if exists bill_change_logs;

/*==============================================================*/
/* Table: bill_change_logs                                      */
/*==============================================================*/
create table bill_change_logs
(
   id                   bigint not null comment '主键Id',
   billId               bigint comment '账单Id',
   operType             int comment '操作类型(创建，审核通过，审核不通过，)',
   operExplain          varchar(200) comment '操作说明',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_change_logs comment '账单变更日志';