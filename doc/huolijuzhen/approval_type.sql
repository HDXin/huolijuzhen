drop table if exists approval_type;

/*==============================================================*/
/* Table: approval_type                                         */
/*==============================================================*/
create table approval_type
(
   id                   bigint not null comment '主键',
   parkId               bigint comment '所属园区',
   approvalType         int default 0 comment '审批类型（合同确认、账单审批、账单核销）',
   latestVersion        int default 0 comment '最新版本（默认：0）',
   enableStatus         int default 1 comment '启用禁用',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_type comment '审批类型表';
