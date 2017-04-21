drop table if exists roll_period_info;

/*==============================================================*/
/* Table: roll_period_info                                      */
/*==============================================================*/
create table roll_period_info
(
   id                   bigint not null comment '主键',
   startDate            datetime comment '开始年月',
   endDate              datetime comment '结束年月',
   rollPeriod           int default 0 comment '滚动周期',
   rollRange            decimal(11,2) comment '滚动幅度',
   billCostCalRulesId   bigint comment '费用项目计算规则明细',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table roll_period_info comment '滚动周期表';
