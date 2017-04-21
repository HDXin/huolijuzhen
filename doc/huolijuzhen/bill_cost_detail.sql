drop table if exists bill_cost_detail;

/*==============================================================*/
/* Table: bill_cost_detail                                      */
/*==============================================================*/
create table bill_cost_detail
(
   id                   bigint not null comment '主键',
   billId               bigint comment '费用账单',
   bccrId               bigint comment '费用计算规则',
   dosage               decimal(11,2) comment '项目用量',
   unitPrise            decimal(11,2) comment '项目用量单价',
   costProName          varchar(50) comment '费用项目名称',
   cost                 decimal(11,2) comment '费用金额',
   taxRate              decimal(11,2) comment '税率',
   taxMoney             decimal(11,2) comment '税额',
   totalMoney           decimal(11,2) comment '合计金额',
   verifyMoney          decimal(11,2) comment '核销金额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   isTask               int default 0 comment '是否是维修费（0：否，1：是）',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_detail comment '账单费用明细表';