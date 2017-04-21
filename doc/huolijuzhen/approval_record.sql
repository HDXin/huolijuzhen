drop table if exists approval_record;

/*==============================================================*/
/* Table: approval_record                                       */
/*==============================================================*/
create table approval_record
(
   id                   bigint not null comment '主键',
   approvalType         int default 0 comment '记录的审批类型（合同确认，账单审批，账单核销）',
   mainId               bigint comment '主信息ID（合同 ID、账单 ID）',
   approvalItemId       bigint comment '审批节点 ID',
   approvalItemName     varchar(30) comment '审批节点名称',
   approvalItemNo       int comment '审批节点顺序号',
   approvalItemVersion  int comment '审批节点的版本',
   approvalId           bigint comment '审批人ID',
   approvalName         varchar(30) comment '审批人名称',
   passStatus           tinyint(1) default 0 comment '审批是否通过（未通过：0,、通过：1）',
   approvalMemo         varchar(200) comment '审批备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_record comment '审批记录表';
