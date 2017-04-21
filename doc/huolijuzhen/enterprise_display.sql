drop table if exists enterprise_display;

/*==============================================================*/
/* Table: enterprise_display                                    */
/*==============================================================*/
create table enterprise_display
(
   id                   bigint not null comment '主键Id',
   enterpriseId         bigint not null comment '企业Id',
   parkId				bigint not null comment '园区id',
   info                 varchar(200) comment '企业信息',
   details              text comment '信息详情',
   introduce            varchar(200) comment '企业介绍',
   thumbnailUrl         varchar(200) comment '缩略图',
   publishLevel         int(2) comment '发布级别（1:平台；2:园区）',
   detailUrl            varchar(200) comment '详情图',
   approvalStatus       int(2) default 0 comment '审核状态(0:"未知",1:"待提交",2: "待审批",3: "已通过",4:"未通过,5:"已终止")',
   approvalDate         datetime comment '审核时间',
   approvalUser         int(11) comment '审核人',
   version              int(11) not null default 0 comment '版本号',
   status               int(11) not null default 0 comment '通用状态',
   createBy             bigint(20) default 0 comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint(20) default 0 comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null default CURRENT_TIMESTAMP comment '最后修改时间',
   primary key (id)
);

alter table enterprise_display comment '企业风采表';