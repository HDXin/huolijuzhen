drop table if exists cost_pro_setting;

/*==============================================================*/
/* Table: cost_pro_setting                                      */
/*==============================================================*/
create table cost_pro_setting
(
   id                   bigint not null comment '主键',
   contractId           bigint comment '合同 ID',
   contractNo           varchar(50) comment '合同号',
   costProType          bigint comment '费用项目类型',
   billMonth            varchar(11) comment '账单期间',
   enterpriseId         bigint comment '企业 ID',
   enterpriseName       varchar(60) comment '企业名称',
   parkId               bigint comment '园区 ID',
   dosage               decimal(11,1) default 0 comment '用量',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table cost_pro_setting comment '费用项目用量表';
