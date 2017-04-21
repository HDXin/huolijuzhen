drop table if exists park_info;

/*==============================================================*/
/* Table: garden_info                                           */
/*==============================================================*/
create table park_info
(
   id                   bigint not null comment '主键',
   name                 varchar(60) comment '园区名称',
   provinceId           bigint comment '省',
   cityId               bigint comment '市',
   regionId             bigint comment '区县',
   positionId           bigint comment '行政位置',
   contacts             varchar(20) comment '联系人姓名',
   mobilePhone          varchar(11) comment '联系人手机号',
   phone                varchar(11) comment '联系人座机号',
   email                varchar(50) comment '联系邮箱',
   adminAccount         varchar(20) comment '管理者账号',
   adminUserId          bigint comment '管理登录用户Id',
   isGroup              int comment '是否隶属集团',
   closeBy              bigint comment '禁用人',
   closeTime            datetime comment '禁用时间',
   enableStatus          int comment '启用状态',
   startBy              bigint comment '启用人',
   startTime            datetime comment '启用时间',
   accountManager       varchar(50)  DEFAULT NULL comment '客户经理' ,
   managerPhone         varchar(13)   DEFAULT NULL comment '经理手机号',
   version              int(11) NOT NULL DEFAULT 0 comment '版本号',
   status                int(11) NOT NULL DEFAULT 0 comment '通用状态 Status' ,
   createBy              bigint(20) NULL DEFAULT 0  comment '创建人',
   createTime            datetime   NULL DEFAULT NULL          comment '创建时间',
   updateBy              bigint(20) NULL DEFAULT 0  comment '修改人',
   updateTime            datetime   NULL DEFAULT NULL comment '修改时间',
   lastUpdate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
   primary key (id)
);

alter table park_info comment '园区信息表';


drop table if exists park_group_info;

/*==============================================================*/
/* Table: 园区组表                                           */
/*==============================================================*/
create table park_group_info
(
   id                   bigint not null comment '主键',
   name                 varchar(60) comment '园区组名称',
   contacts             varchar(20) comment '联系人姓名',
   mobilePhone          varchar(11) comment '联系人手机号',
   closeBy              bigint comment '禁用人',
   closeTime            datetime comment '禁用时间',
   enableStatus          int comment '启用状态',
   startBy              bigint comment '启用人',
   startTime            datetime comment '启用时间',
   version              int(11) NOT NULL DEFAULT 0 comment '版本号',
   status                int(11) NOT NULL DEFAULT 0 comment '通用状态 Status' ,
   createBy              bigint(20) NULL DEFAULT 0  comment '创建人',
   createTime            datetime   NULL DEFAULT NULL          comment '创建时间',
   updateBy              bigint(20) NULL DEFAULT 0  comment '修改人',
   updateTime            datetime   NULL DEFAULT NULL comment '修改时间',
   lastUpdate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
   primary key (id)
);
alter table park_group_info comment '园区信息表';

drop table if exists park_group_user_info;

/*==============================================================*/
/* Table: 园区组账号表                                         */
/*==============================================================*/
create table park_group_user_info
(
  id                   bigint not null comment '主键',
  parkGroupId          bigint not null comment '园区组id',
  adminUserId          bigint not null comment '账户id',
  username             varchar(60) comment '账号',
  contacts             varchar(20) comment '联系人姓名',
  mobilePhone          varchar(11) comment '联系人手机号',
  version              int(11) NOT NULL DEFAULT 0 comment '版本号',
  status                int(11) NOT NULL DEFAULT 0 comment '通用状态 Status' ,
  createBy              bigint(20) NULL DEFAULT 0  comment '创建人',
  createTime            datetime   NULL DEFAULT NULL          comment '创建时间',
  updateBy              bigint(20) NULL DEFAULT 0  comment '修改人',
  updateTime            datetime   NULL DEFAULT NULL comment '修改时间',
  lastUpdate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
  primary key (id)
);
alter table park_group_user_info comment '园区组账号表';

drop table if exists park_group_park_info;

/*==============================================================*/
/* Table: 园区组关联表                                         */
/*==============================================================*/
create table park_group_park_info
(
  id                   bigint not null comment '主键',
  parkGroupId          bigint not null comment '园区组id',
  parkId          bigint not null comment '账户id',
  parkname             varchar(100) comment '园区名称',
  position             varchar(100) comment '行政位置',
  version              int(11) NOT NULL DEFAULT 0 comment '版本号',
  status                int(11) NOT NULL DEFAULT 0 comment '通用状态 Status' ,
  createBy              bigint(20) NULL DEFAULT 0  comment '创建人',
  createTime            datetime   NULL DEFAULT NULL          comment '创建时间',
  updateBy              bigint(20) NULL DEFAULT 0  comment '修改人',
  updateTime            datetime   NULL DEFAULT NULL comment '修改时间',
  lastUpdate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
  primary key (id)
);
alter table park_group_park_info comment '园区组关联表';

#2016-12-03
ALTER TABLE res_info
  ADD calcDimension INT(11) NULL
COMMENT '计算维度';




