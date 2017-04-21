drop table if exists contract_dossier;

/*==============================================================*/
/* Table: contract_dossier                                      */
/*==============================================================*/
create table contract_dossier
(
   id                   bigint not null comment 'id',
   contractId           bigint comment '合同Id',
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

alter table contract_dossier comment '合同档案表';
