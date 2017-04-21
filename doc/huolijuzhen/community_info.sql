drop table if exists community_info;

/*==============================================================*/
/* Table: community_info                                        */
/*==============================================================*/
create table community_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '活动标题',
   discrible            varchar(900) comment '介绍',
   content              text comment '活动内容',
   time                 datetime comment '活动时间',
   publicGrade          int default 0 comment '活动对象（1.平台，2.按行政区域，3.园区）',
   parkId               bigint comment '对象园区（grade 为 3 时用）',
   proId                char(10) comment '对象省份（grade 为 2 时用）',
   cityId               char(10) comment '对象城市（grade 为 2 时用）',
   counId               char(10) comment '对象县区（grade 为 2 时用）',
   locationId           bigint comment '对象行政位置（grade 为 2 时用）',
   approvalStatus       int default 0 comment '审批状态',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalMemo         varchar(300) comment '审批备注',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   operatorHistory      text comment '操作记录（用于操作记录的存储，备用）',
   createSide           int default 0 comment '创建方类型',
   createSideId         bigint comment '创建方',
   terminateBy          bigint comment '终止人',
   terminateTime        datetime comment '终止时间',
   primary key (id)
);

alter table community_info comment '社群活动信息表';
