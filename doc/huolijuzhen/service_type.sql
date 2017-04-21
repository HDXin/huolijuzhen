drop table if exists service_type;

/*==============================================================*/
/* Table: service_type                                          */
/*==============================================================*/
create table service_type
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '服务名称',
   isReco               boolean comment '是否是推荐服务',
   serverGrade          int default 0 comment '服务级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '类型描述',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   recoBy               bigint comment '推荐人',
   recoTime             datetime comment '推荐时间',
   unRecoBy             bigint comment '取消推荐人',
   unRecoTime           datetime comment '取消推荐时间',
   typeLogo             varchar(300) comment '服务类型图标（用于服务分类展示页面上显示）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   recoLogo             varchar(300) comment '推荐类型图标（企业端首页显示）',
   primary key (id)
);

alter table service_type comment '服务类型表';
