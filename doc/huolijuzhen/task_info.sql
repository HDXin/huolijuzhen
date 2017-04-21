drop table if exists task_info;

/*==============================================================*/
/* Table: task_info                                             */
/*==============================================================*/
create table task_info
(
   id                   bigint not null comment '主键',
   title                varchar(60) comment '任务标题',
   code                 varchar(300) comment '任务编号',
   taskType             int default 0 comment '任务类型（1.计划任务，2.园区创建，3.企业申请）',
   equPlanId            bigint comment '所属的维护计划',
   equId                bigint comment '所属设备（taskType 为计划任务时使用）',
   description          varchar(600) comment '任务描述',
   enableStatus         int default 0 comment '启用状态（1.启用，2.禁用）',
   taskStatus           int default 0 comment '任务状态(1.待分配，2.待执行，3.已完成)',
   isAdjust             boolean default false comment '是否已被调整',
   adjustBy             bigint comment '调整人',
   adjustTime           datetime comment '调整时间',
   adjustMemo           varchar(2048) comment '调整备注',
   operator             bigint comment '实际执行人',
   operatorMemo         varchar(600) comment '实际执行人备注',
   operatorTime         datetime comment '实际执行时间',
   payWay               int default 0 comment '付费方式（1.现付，2.月结）',
   executor             varchar(2048) comment '执行人（执行人1;执行人2;执行人3;）',
   parkId               bigint comment '所属园区',
   allBy                bigint comment '分配人',
   allTime              datetime comment '分配时间',
   closeBy              bigint comment '关闭人',
   closeTime            datetime comment '关闭时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   createName           varchar(30) comment '创建人姓名（冗余字段）',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   hasCost              boolean default false comment '是否有费用',
   costIsVerify         boolean default false comment '任务费用确认',
   taskCost             decimal(11,2) comment '任务费用',
   verifyBy             bigint comment '费用确认人',
   veribyTime           datetime comment '费用确认时间',
   veribyMemo           varchar(600) comment '费用确认备注',
   isComment            boolean comment '是否已评价',
   commentBy            bigint comment '评价人',
   commentTime          datetime comment '评价时间',
   commentGrade         int default 0 comment '评价级别',
   commentContent       varchar(900) comment '评价内容',
   commentStarGrade     int default 0 comment '评价星级（直接保存星级数）',
   equTypeId            bigint comment '设备类型',
   updateMemo           varchar(200) comment '修改备注',
   history              varchar(10240) comment '操作记录（创建、修改、分配、调整记录）',
   isChoose             int default 0 comment '是否已被账单选用（0：否，1:是）',
   billId               bigint default NULL comment '被账单 ID 选用',
   primary key (id)
);

alter table task_info comment '任务表';
