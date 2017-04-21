drop table if exists banner_sources;
/*==============================================================*/
/* Table: banner_sources                                         */
/*==============================================================*/
create table banner_sources
(
   id                   bigint not null comment '主键',
   imageUrl				varchar(200) comment '图片路径',
   reqSourceType		int not null comment '请求来源  0-园区app, 1-企业app 参见ReqSourceType枚举',
   jumpTo				varchar(200) comment '图片跳转链接',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);
alter table banner_sources comment '图片资源表';