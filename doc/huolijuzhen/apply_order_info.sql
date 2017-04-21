drop table if exists apply_order_info;

/*==============================================================*/
/* Table: apply_order_info                                      */
/*==============================================================*/
create table apply_order_info
(
   id                   bigint not null comment '主键',
   applyOrderNo         varchar(60) comment '单据编号',
   applyOrderType       int default 0 comment '申请单订单类型（1.订单,2.申请单）',
   applyOrderStatus     int default 0 comment '申请单订单状态（0.未知，1.待处理，2.已通过，3.未通过，4.待支付，5.待评价，6.已完成，7.已取消，8.已关闭）',
   serviceProId         bigint comment '所属服务项目',
   enterpriseId         bigint comment '单据企业ID',
   enterpriseName       varchar(30) comment '单据企业名称',
   content              text comment '表单信息',
   applyOrderStatusMemo varchar(300) comment '申请单订单备注',
   billHistoryId        bigint comment '流水账记录',
   orderMemo            varchar(100) comment '订单备注',
   priceTitle           varchar(30) comment '选用的价格名称',
   price                decimal comment '选用的价格',
   commentId            bigint comment '评价内容',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   payWay               int default 0 comment '支付方式',
   primary key (id)
);

alter table apply_order_info comment '申请单订单信息';
