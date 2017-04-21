drop table if exists order_template;

/*==============================================================*/
/* Table: order_template                                        */
/*==============================================================*/
create table order_template
(
   id                   bigint not null,
   serviceProId         bigint,
   supportAliPay        boolean comment '是否支持支付宝支付',
   supportWeChatPay     boolean comment '是否支持微信支付',
   priceTitleOne        varchar(30) comment '价格档标题_1',
   priceTitleTwo        varchar(30) comment '价格档标题_2',
   priceTitleThree      varchar(30) comment '价格档标题_3',
   discountTitleOne     varchar(30) comment '折扣价标题_1',
   discountTitleTwo     varchar(30) comment '折扣价标题_2',
   discountTitleThree   varchar(30) comment '折扣价标题_3',
   discountThree        double default 0 comment '折扣价价格_3',
   discountOne          double default 0 comment '折扣价价格_1',
   priceThree           double default 0 comment '价格档价格_3',
   priceOne             double default 0 comment '价格档价格_1',
   priceTwo             double default 0 comment '价格档价格_2',
   discountTwo          double default 0 comment '折扣价价格_2',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table order_template comment '订单模板表';
