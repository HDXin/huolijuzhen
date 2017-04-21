drop table if exists equipment_plan;

/*==============================================================*/
/* Table: equipment_plan                                        */
/*==============================================================*/
create table equipment_plan
(
   id                   bigint not null comment '主键',
   equId                bigint comment '所属设备',
   equCode              varchar(30) comment '设备编号（冗余字段）',
   equName              varchar(30) comment '设备名称（冗余字段）',
   equTypeId            bigint comment '设备类别',
   upkeepTime           datetime comment '最近保养时间',
   equTypeName          varchar(30) comment '设备类别名称（冗余字段）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   planStatus           int comment '计划状态（1.待分配，2.待处理，3.已完成）',
   assignerId           bigint comment '分配人',
   assignerTime         datetime comment '分配时间',
   planExecutorDate     date comment '计划执行时间',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   deleteMemo           varchar(300) comment '删除备注',
   enableStatus         int comment '启用状态（1,启用：ENABLE，2.禁用：DISABLE）',
   description          varchar(600) comment '描述',
   primary key (id)
);

alter table equipment_plan comment '设备维修计划表';
