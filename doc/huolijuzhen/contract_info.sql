drop table if exists contract_info;

/*==============================================================*/
/* Table: contract_info                                         */
/*==============================================================*/
create table contract_info
(
   id                   bigint not null comment '主键',
   businessNum          varchar(50) comment '工商号',
   enterpriseName       varchar(200) comment '企业名称',
   contNo               varchar(50) comment '合同号',
   startDate            date comment '合同起始日期',
   endDate              date comment '合同截至日期',
   proAddr              varchar(200) comment '项目详细地址',
   area                 decimal(16,3) comment '物业面积',
   totalMoney           decimal(16,2) comment '合同金额',
   deposit              decimal(16,2) comment '押金总额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   contractStatus       int not null default 0 comment '合同状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   lastUpdateBy         bigint comment '最后编辑人',
   lastUpdateTime       datetime comment '最后编辑时间',
   approvalProcessId    bigint not null comment '审批流程 ID',
   executorId           bigint not null comment '待执行人ID',
      
   primary key (id)
);

alter table contract_info comment '合同信息表';
