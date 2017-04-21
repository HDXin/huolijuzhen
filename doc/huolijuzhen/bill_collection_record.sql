drop table if exists bill_collection_record;

/*==============================================================*/
/* Table: bill_collection_record                                */
/*==============================================================*/
create table bill_collection_record
(
   id                   bigint not null comment 'id',
   billId               bigint comment '账单Id',
   collectionTime       datetime comment '收款时间',
   collectionBank       varchar(50) comment '收款银行',
   collectionAccount    varchar(50) comment '收款账户',
   collectionAmount     decimal(11,2) comment '收款金额',
   payChannels          varchar(50) comment '支付方式',
   paySerialNum         varchar(50) comment '支付流水号',
   remark               varchar(50) comment '备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_collection_record comment '账单收款纪录表';
