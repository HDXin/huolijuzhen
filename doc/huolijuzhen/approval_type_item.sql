drop table if exists approval_type_item;

/*==============================================================*/
/* Table: approval_type_item                                    */
/*==============================================================*/
create table approval_type_item
(
   id                   bigint not null comment '主键',
   approvalTypeId       bigint comment '所属审批类型',
   currentVersion       int default 0 comment '当前版本',
   name                 varchar(30) comment '节点名称',
   approvalId           bigint comment '审批人ID',
   approvalNo           int default 100 comment '流程序列',
   isHistory            tinyint(1) default 0 comment '是否是历史版本',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_type_item comment '审批类型详情表';
