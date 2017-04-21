drop table if exists bill_cost_cal_rules;

/*==============================================================*/
/* Table: bill_cost_cal_rules                                   */
/*==============================================================*/
create table bill_cost_cal_rules
(
   id                   bigint not null comment 'id',
   contractId            bigint comment '所属合同',
   costProId            bigint comment '所属费用项目',
   costProName          varchar(60) NULL DEFAULT NULL COMMENT '费用账单名' ,
   computeMode          int(2) comment '计算方式（0：未知，1：固定金额，2：自定义计算）',
   freeMonth            int(2) comment '免收月数',
   advanceMonth         int(2) comment '费用预收月数',
   fixedAmount          decimal(11,2) comment '(固定金额)固定金额',
   startAdjAmount       decimal(11,2) comment '(固定金额)起始调整金额',
   startAdjMonth        varchar(10) comment '(固定金额)起始调整账单期间',
   endAdjAmount         decimal(11,2) comment '(固定金额)截止调整金额',
   endAdjMonth          varchar(10) comment '(固定金额)截止调整账单期间',
   leaseAreaCal         int default 0 comment '(自定义计算)租赁面积参与计算状态',
   contAmountCal        int default 0 comment '(自定义计算)合同总额参与计算状态',
   daysCal              int default 0 comment '(自定义计算)天数参与计算状态',
   isRollingCal         int default 0 comment '(自定义计算)是否启用滚动计算',
   rollingStartMonth    int comment '(自定义计算)合同起始后开始滚动月',
   rollingPeriod        int comment '(自定义计算)滚动周期',
   rollingRange         decimal(11,2) comment '(自定义计算)滚动幅度',
   formula              varchar(50) comment '(自定义计算)费用项目金额计算公式',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_cal_rules comment '费用项目计算明细表';
