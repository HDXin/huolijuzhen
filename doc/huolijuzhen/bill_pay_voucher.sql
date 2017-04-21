drop table if exists bill_pay_voucher;

/*==============================================================*/
/* Table: bill_pay_voucher                                      */
/*==============================================================*/
create table bill_pay_voucher
(
   id                   bigint not null comment 'id',
   billId               bigint comment '账单Id',
   fileType             int(2) default 0 comment '文件类型',
   fileName             varchar(256) comment '文件名称',
   fileUrl              varchar(256) comment '文件地址',
   imgLink              varchar(256) comment '图片链接（针对图片）',
   fileDesc             varchar(256) comment '文件描述',
   version              int(11) not null default 0 comment '版本号',
   status               int(11) not null default 0 comment '通用状态 Status',
   createBy             bigint(20) default 0 comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint(20) default 0 comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null default CURRENT_TIMESTAMP comment '最后修改时间',
   primary key (id)
);
alter table bill_pay_voucher comment '账单支付凭证';