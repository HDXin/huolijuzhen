drop table if exists enterprise_user_cott;

/*==============================================================*/
/* Table: enterprise_user_cott                                     */
/*==============================================================*/
create table enterprise_user_cott
(
   id                   bigint not null comment '主键',
   parkId				bigint not null comment '园区id',
   enterpriseUserId		bigint not null comment '企业用户id',
   cottId				bigint not null comment '关联关系id',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enterprise_user_cott comment '企业用户园区关联关系表';