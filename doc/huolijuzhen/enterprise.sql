drop table if exists enterprise_info;

/*==============================================================*/
/* Table: enterprise_info                                       */
/*==============================================================*/
create table enterprise_info
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '企业名称',
   type                 int comment '工商注册号/统一社会注册代码',
   code                 varchar(50) comment '注册码',
   contacts             varchar(30) comment '联系人姓名',
   phone                varchar(11) comment '联系人手机号',
   adminAccount         varchar(20) comment '管理员账号',
   createSource       int(3) NULL DEFAULT 0 COMMENT '创建来源平台(0：未知；1:平台；2:园区)' ,
   totalBala            double comment '总余额',
   ableBala             double comment '可用余额',
   freezeBala           double comment '冻结余额',
   bindBala             double comment '绑定余额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id),
   UNIQUE INDEX `code_unique` (`code`) USING BTREE 
);

alter table enterprise_info comment '企业信息管理';

drop table if exists enterprise_dossier;

/*==============================================================*/
/* Table: enterprise_dossier                                    */
/*==============================================================*/
create table enterprise_dossier
(
   id                   bigint not null comment 'id',
   businessId           bigint comment '企业Id',
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

alter table enterprise_dossier comment '企业档案表';
drop table if exists enterprise_cott;

/*==============================================================*/
/* Table: enterprise_cott                                       */
/*==============================================================*/
create table enterprise_cott
(
   id                   bigint not null comment '主键',
   corrStatus           int comment '关联状态(0:未知,1:已入住,2:历史入住)',
   corrType             int comment '关联关系(0:未知 1.合同关联,2:业务关联)',
   corrTime             datetime comment '关联时间',
   parkId               bigint comment '关联园区Id',
   enterpriseId         bigint comment '关联的企业Id',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enterprise_cott comment '企业关联表';


drop table if exists enterprise_corr_contract;

/*==============================================================*/
/* Table: enterprise_corr_contract                              */
/*==============================================================*/
create table enterprise_corr_contract
(
   id                   bigint not null,
   enterpriseCottId     bigint comment '园区企业关联关系Id',
   contractId           bigint comment '合同Id',
   contNo               varchar(50) comment '合同号',
   startDate            date comment '合同起始日期',
   endDate              date comment '合同截至日期',
   contractStatus       int comment '合同状态(0:)',
   terminateUser        bigint comment '终止人',
   terminate            datetime comment '终止时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enterprise_corr_contract comment '企业合同关联记录表';
drop table if exists enterprise_corr_business;

/*==============================================================*/
/* Table: enterprise_business_contract                          */
/*==============================================================*/
create table enterprise_corr_business
(
   id                   bigint not null comment '主键',
   enterpriseCottId     bigint comment '园区关联关系Id',
   cottTime             datetime comment '关联时间',
   cottUser             bigint comment '关联人',
   cottStatus           int comment '关联状态（0:未知,1:待确认2:已关联）',
   number               int comment '序号',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);
alter table enterprise_business_contract comment '企业业务关联记录表';

drop table if exists enterprise_display;

/*==============================================================*/
/* Table: enterprise_display                                    */
/*==============================================================*/
create table enterprise_display
(
   id                   bigint not null comment 'id',
   info                 varchar(200) comment '企业信息',
   details              text comment '信息详情',
   introduce            varchar(200) comment '企业介绍',
   thumbnailUrl         varchar(50) comment '缩略图',
   detailUrl            varchar(50) comment '详情图',
   version              int(11) not null  default 0 comment '版本号',
   status               int(11) not null  default 0 comment '通用状态',
   createBy             bigint(20) default 0 comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint(20) default 0 comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null default CURRENT_TIMESTAMP comment '最后修改时间',
   primary key (id)
);

