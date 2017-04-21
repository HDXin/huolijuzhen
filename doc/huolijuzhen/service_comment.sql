drop table if exists service_comment;

/*==============================================================*/
/* Table: service_comment                                       */
/*==============================================================*/
create table service_comment
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目',
   gradeNum             int comment '评论星级',
   commentText          varchar(300) comment '评论内容',
   price                decimal(11,2) comment '价格',
   applyOrderId         bigint comment '订单申请单',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   Column_14            char(10),
   primary key (id)
);

alter table service_comment comment '服务项目评论表';
