drop table if exists apply_info;

/*==============================================================*/
/* Table: apply_info                                            */
/*==============================================================*/
create table apply_info
(
   id                   bigint not null comment '主键',
   content              text comment '表单信息',
   serviceProId         bigint comment '所属服务项目',
   serviceProTitle      varchar(30) comment '所属服务项目名称',
   enterpriseId         bigint comment '所属企业',
   enterpriseName       varchar(30) comment '企业名称',
   parkId               bigint comment '所属园区',
   parkName             varchar(30) comment '园区名称',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_info comment '申请单信息';
