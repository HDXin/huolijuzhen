drop table if exists image_info;

/*==============================================================*/
/* Table: image_info                                            */
/*==============================================================*/
create table image_info
(
   id                   bigint not null comment '主键',
   imageType            int default 0 comment '图片所属业务类型',
   targetId             bigint comment '所属业务 ID',
   path                 varchar(200) comment '图片路径',
   title                varchar(100) comment '图片标题',
   describle            varchar(200) comment '图片描述',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   createName           varchar(30) comment '创建人姓名（冗余字段）',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table image_info comment '图片表';
