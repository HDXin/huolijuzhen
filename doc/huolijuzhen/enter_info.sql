drop table if exists enter_info;

/*==============================================================*/
/* Table: enter_info                                             */
/*==============================================================*/
create table enter_info
(
   id                   bigint not null comment '主键',
   entryName           	varchar(200) comment '入驻(园区，服务商)名称',
   entryType			int not null default 0 comment '入驻类型',
   treatmentStatus		int not null default 0 comment '处理类型(0-未知，1-待处理，2-已处理)',
   contact         		varchar(50) comment '联系人',
   phoneNo              varchar(20) comment '联系方式',
   address              varchar(200) comment '详细地址',
   serviceScope			varchar(200) comment '服务范围',
   updateDescribe		varchar(200) comment '修改描述',
   reserve1				varchar(200) comment '预留字段1',
   reserve2				varchar(200) comment '预留字段2',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enter_info comment '入驻信息表';
