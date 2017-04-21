drop table if exists approval_process;

/*==============================================================*/
/* Table: approval_process                                      */
/*==============================================================*/
create table approval_process
(
   id                   bigint not null comment '主键',
   approvalTypeId       bigint comment '流程类型ID',
   approvalTypeVersion  int comment '流程类型版本',
   approvalType         int default 0 comment '记录的审批类型（合同确认，账单审批，账单核销）',
   mainId               bigint comment '主信息ID（合同 ID、账单 ID）',
   approvalItemId       bigint comment '审批节点 ID',
   approvalItemNo       int comment '审批节点顺序号',
   approvalItemVersion  int comment '审批节点的版本',
   approvalId           bigint comment '审批人ID',
   approvalProcessStatus int default 10 comment '审批处理状态（待审批：10、审批中：20、已审批：30）',
   isHistory            tinyint(1) default 0 comment '是否是历史流程（版本升级流程作废）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_process comment '审批流程表';
