drop table if exists bill_info;

/*==============================================================*/
/* Table: bill_info                                             */
/*==============================================================*/
create table bill_info
(
   id                   bigint not null comment '主键',
   billNo               varchar(50) comment '单据编号',
   parkId               bigint comment '所属园区',
   companyId            bigint comment '所属企业',
   companyName          varchar(200) comment '企业名称',
   contractId           bigint comment '关联合同',
   contractNo           varchar(50) comment '合同号',
   billMonth            varchar(10) comment '账单月份',
   totalMoney           decimal(11,2) comment '合计费用总额',
   totalTaxMoney        decimal(11,2) comment '合计税额',
   reliefMoney          decimal(11,2) comment '减免金额',
   reliefRemark         varchar(200) comment '减免备注',
   totalAmount          decimal(11,2) comment '合计总额',
   billStatus           int(2) comment '账单状态',
   submitStatus         int(2) comment '提交状态',
   submitBy             bigint comment '提交人',
   submitTime           datetime comment '提交时间',
   approvalStatus       int(2) default 0 comment '账单审核状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   pushStatus           int(2) default 0 comment '账单推送状态',
   pushBy               bigint comment '推送人',
   pushTime             datetime comment '推送时间',
   confirmStatus        int(2) comment '账单确认状态',
   confirmBy            bigint comment '确认人',
   confirmTime          datetime comment '确认时间',
   verificationStatus   int(2) comment '账单核销状态',
   verificationBy       bigint comment '账单核销人',
   verificationTime     datetime comment '核销时间',
   urgePushStatus       int(2) default 0 comment '账单催缴推送状态',
   urgeBy               bigint comment '催缴人',
   urgeTime             datetime comment '催缴时间',
   payBank              varchar(100) comment '支付银行（预留）',
   paySerialNumber      varchar(50) comment '支付流水号',
   nextAdjust           int(1) default 0 comment '下期调整',
   adjustAmount         decimal(11,2) comment '调整金额',
   adjustRemark         varchar(200) comment '调整备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id),
   unique key AK_uq_billNo (billNo)
);

alter table bill_info comment '账单信息表';