drop table if exists equ_pre_info;

/*==============================================================*/
/* Table: equ_pre_info                                          */
/*==============================================================*/
create table equ_pre_info
(
   id                   bigint not null comment '主键',
   name                 varchar(300) comment '设备名称',
   preCycle             int default 0 comment '维护周期',
   cycleType            int default 0 comment '周期类型',
   parkId               bigint comment '所属园区',
   code                 varchar(300) comment '设备编码',
   equTypeId            bigint comment '设备类别',
   equTypeName          varchar(30) comment '设备类型名称（冗余字段）',
   preObj               varchar(60) comment '设备维护商',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '设备状态（启用状态）',
   enableDate           date comment '启用日期',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   isEnablePlan         boolean comment '是否启用设备维护计划',
   primary key (id)
);

alter table equ_pre_info comment '设备维护表';
