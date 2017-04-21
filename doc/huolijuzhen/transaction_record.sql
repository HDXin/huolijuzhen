drop table if exists transaction_record;

/*==============================================================*/
/* Table: transaction_record                                    */
/*==============================================================*/

create table transaction_record

(
   id                   bigint comment '主键',
   userId               bigint comment '用户 ID',
   transactionAmount    decimal(16,2) comment '交易金额',
   transactionTime      datetime comment '交易日期',
   transactionDirection int default 0 comment '交易方向',
   transactionType      int default 0 comment '交易类型',
   transactionStatus    int default 0 comment '交易状态',
   payChannel           int default 0 comment '支付渠道',
   transferFromType     int default 0 comment '转入来源类型',
   transferFromId       bigint comment '转入来源 ID',
   transferToType       int default 0 comment '转出类型',
   transferToId         bigint comment '转出 ID',
   bizType              int default 0 comment '业务类型',
   bizId                varchar(20) comment '业务 ID',
   orderNo              varchar(50) comment '订单号',
   explanation          varchar(300) comment '交易说明',
   tradeNo              varchar(100) comment '第三放支付交易号',
   buyerEmail           varchar(100) comment '支付账号',
   buyerId              varchar(50) comment '支付Id',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   createName           varchar(30) comment '创建人姓名（冗余字段）',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
   
);

alter table transaction_record comment '支付交易记录表';