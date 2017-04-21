drop table if exists contract_bill;

/*==============================================================*/
/* Table: contract_bill                                         */
/*==============================================================*/
create table contract_bill
(
   id                   bigint not null comment '主键',
   contractId           bigint comment '合同 ID',
   month            varchar(50) comment '账单月份',
   billAmount               decimal(11,2) comment '当月账单金额',
   isBillMonth          int default 0 comment '是否是账单月（0：否，1：是）',
   costProId            bigint comment '费用项目 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table contract_bill comment '合同账单表';
