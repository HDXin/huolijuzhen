drop table if exists bill_ccr_adj;

/*==============================================================*/
/* Table: bill_ccr_adj                                          */
/*==============================================================*/
create table bill_ccr_adj
(
   id                   bigint not null comment '主键Id',
   bccrId               bigint comment '计算规则Id',
   adjAmount            decimal(11,2) comment '调整金额',
   adjMonth             varchar(10) comment '调整月份',
   adjRemark            varchar(200) comment '调整备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_ccr_adj comment '计算规则月份调整记录';

alter table bill_ccr_adj add constraint FK_Reference_20 foreign key (bccrId)
      references bill_cost_cal_rules (id) on delete restrict on update restrict;
