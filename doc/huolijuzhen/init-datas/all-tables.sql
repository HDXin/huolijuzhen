drop table if exists announcement_info;

/*==============================================================*/
/* Table: announcement_info                                     */
/*==============================================================*/
create table announcement_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '公告标题',
   content              text comment '公告内容',
   publicGrade          int default 0 comment '公告对象级别（1.平台，2.按行政，3.园区）',
   parkId               bigint comment '对象园区（publicGrade 为 ”3 园区“  时使用）',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县区',
   locationId           bigint comment '对象行政位置（publicGrade 为 ”2.按行政“ 时使用）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   createSide           int comment '发布公告方',
   createSideId         bigint comment '发布公告',
   sendGrade            int default 0 comment '发送对象级别（1,全部，2.企业用户，3.园区用户）',
   primary key (id)
);

alter table announcement_info comment '系统公告信息';


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



drop table if exists community_apply;

/*==============================================================*/
/* Table: community_apply                                       */
/*==============================================================*/
create table community_apply
(
   id                   bigint not null comment '主键',
   orderNo              varchar(60) comment '单据编号',
   companyId            bigint comment '所属企业',
   companyName          varchar(60) comment '企业名称',
   parkId               bigint comment '所属园区',
   applyTime            datetime comment '申请日期',
   proprser             varchar(30) comment '申请人',
   phone                varchar(11) comment '联系方式',
   num                  int default 0 comment '申请参与人数',
   describle            varchar(300) comment '备注',
   communityId          bigint comment '申请的活动',
   communityName        varchar(60) comment '活动名称',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   createSide           int default 0 comment '活动创建方（用与活动查询）',
   createSideId         bigint comment '活动创建方ID',
   primary key (id)
);

alter table community_apply comment '社群活动申请表';



drop table if exists location_info;

/*==============================================================*/
/* Table: location_info                                         */
/*==============================================================*/
create table location_info
(
   id                   bigint not null comment '主键',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县/区',
   business             varchar(45) comment '商业圈',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   primary key (id)
);

alter table location_info comment '行政位置表';

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
   startStatus          int comment '启用状态',
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

DROP TABLE IF EXISTS park_sequence;


drop table if exists policy_info;

/*==============================================================*/
/* Table: policy_info                                           */
/*==============================================================*/
create table policy_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '政策标题',
   polUri               varchar(300) comment '政策链接',
   publicGrade          int default 0 comment '政策级别（1.平台，2.按行政）',
   parkId               bigint comment '对象园区（publicGrade 为 3 时时用，备用）',
   proId                bigint comment '省（publicGrade 为 2 时用）',
   cityId               bigint comment '城市（publicGrade 为 2 时用）',
   counId               bigint comment '县区（publicGrade 为 2 时用）',
   locationId           bigint comment '对象行政位置（publicGrade 为 2 时用）',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方类型（1.平台，2.园区，3.企业）',
   createSideId         bigint comment '创建方（园区 ID 或 企业 ID）',
   readNum              int default 0 comment '点击数',
   primary key (id)
);

alter table policy_info comment '政策信息表';


alter table policy_info comment '政策信息表';
drop table if exists service_scenario;

/*==============================================================*/
/* Table: service_scenario                                      */
/*==============================================================*/
create table service_scenario
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '场景名称',
   serverGrade          int default 0 comment '服务场景级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '场景描述',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   scaneLogo            varchar(300) comment '图标',
   recoLogo             varchar(300) comment '推荐图标',
   primary key (id)
);

alter table service_scenario comment '服务场景表';
drop table if exists service_type;

/*==============================================================*/
/* Table: service_type                                          */
/*==============================================================*/
create table service_type
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '服务名称',
   isReco               boolean comment '是否是推荐服务',
   serverGrade          int default 0 comment '服务级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '类型描述',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   recoBy               bigint comment '推荐人',
   recoTime             datetime comment '推荐时间',
   unRecoBy             bigint comment '取消推荐人',
   unRecoTime           datetime comment '取消推荐时间',
   typeLogo             varchar(300) comment '服务类型图标（用于服务分类展示页面上显示）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   recoLogo             varchar(300) comment '推荐类型图标（企业端首页显示）',
   primary key (id)
);

alter table service_type comment '服务类型表';


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
   primary key (id)
);

alter table task_info comment '任务表';


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



drop table if exists task_executor;

/*==============================================================*/
/* Table: task_executor                                         */
/*==============================================================*/
create table task_executor
(
   id                   bigint not null comment '主键',
   taskId               bigint comment '任务ID',
   executorId           bigint comment '执行人 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);


drop table if exists desc_info;

/*==============================================================*/
/* Table: desc_info                                             */
/*==============================================================*/
create table desc_info
(
   id                   bigint not null comment '主键',
   desciption           varchar(600) comment '描述',
   enableStatus         int default 0 comment '启用状态',
   parkId               bigint comment '所属园区',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   primary key (id)
);

alter table desc_info comment '常用描述表';

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



drop table if exists equipment_type;

/*==============================================================*/
/* Table: equipment_type                                        */
/*==============================================================*/
create table equipment_type
(
   id                   bigint not null comment '主键',
   code                 varchar(300) comment '设备类别代码',
   name                 varchar(300) comment '设备类别名称',
   parkId               bigint comment '所属园区',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   deleteTime           datetime comment '删除时间',
   deleteBy             bigint comment '删除人',
   primary key (id)
);

alter table equipment_type comment '设备类型表';


drop table if exists provider_info;

/*==============================================================*/
/* Table: provider_info                                         */
/*==============================================================*/
create table provider_info
(
   id                   bigint not null comment '主键',
   name                 varchar(60) comment '服务商名称',
   proId                bigint comment '所属省份',
   cityId               bigint comment '所属城市',
   counId               bigint comment '所属县/区',
   contacts             varchar(30) comment '联系人',
   phone                varchar(11) comment '联系电话',
   account              varchar(60) comment '服务商账号',
   description          varchar(300) comment '服务商简介',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方（1.平台，2.园区）',
   parkId               bigint comment '创建方为园区时使用',
   enableStatus         int default 0 comment '启用状态（1.已启用，2.已禁用）',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   primary key (id)
);

alter table provider_info comment '服务商信息表';



#园区管理平台- 物业管理资源相关表
DROP TABLE IF EXISTS res_info;

/*==============================================================*/
/* Table: res_info    物业资源类型表                              */
/*==============================================================*/
CREATE TABLE res_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  name        VARCHAR(100) COMMENT '物业资源类型名称',
  code        VARCHAR(100) COMMENT '物业资源类型编码',
  resType     INT COMMENT '物业资源性质（1.普通资源，2.公共资源）',
  enableStatus INT COMMENT '启用状态',
  gardenId    BIGINT default 0 COMMENT '所属园区',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  startBy     BIGINT COMMENT '启用人',
  startTime   DATETIME COMMENT '启用时间',
  closeBy     BIGINT COMMENT '禁用人',
  closeTime   DATETIME COMMENT '禁用时间',
  PRIMARY KEY (id)
);

ALTER TABLE res_info
  COMMENT '物业资源类型表';

DROP TABLE IF EXISTS unit_tier_info;

/*==============================================================*/
/* Table: unit_tier_info  单位层级表                             */
/*==============================================================*/
CREATE TABLE unit_tier_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  name        VARCHAR(100) COMMENT '层级名称',
  code        VARCHAR(100) COMMENT '层级编码',
  isBase      BOOLEAN COMMENT '是否是基础层级',
  tierNum     INT COMMENT '层级系数',
  resInfoId   BIGINT COMMENT '资源类型,对应物业资源类型表.Id',
  resInfoName VARCHAR(100) COMMENT '资源类型名称',
  enableStatus INT COMMENT '启用状态',
  gardenId    BIGINT COMMENT '所属园区',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  startBy     BIGINT COMMENT '启用人',
  startTime   DATETIME COMMENT '启用时间',
  closeBy     BIGINT COMMENT '禁用人',
  closeTime   DATETIME COMMENT '禁用时间',
  PRIMARY KEY (id)
);
ALTER TABLE unit_tier_info
  COMMENT '单位层级表';

DROP TABLE IF EXISTS resource_info;

/*==============================================================*/
/* Table: resource_info      资源表                              */
/*==============================================================*/
CREATE TABLE resource_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  isRoot      BOOLEAN COMMENT '是否是根资源',
  resInfoId   BIGINT COMMENT '资源类型',
  tierId      BIGINT COMMENT '资源层级(单位)',
  tierName    VARCHAR(100) COMMENT '层级名称',
  tierNum     INT COMMENT '层级系数',
  name        VARCHAR(100) COMMENT '资源名称',
  description VARCHAR(100) COMMENT '资源描述',
  gardenId    BIGINT COMMENT '所属园区',
  parentId    BIGINT COMMENT '父资源',
  isSeat      BOOLEAN COMMENT '是否是工位',
  code        VARCHAR(100) COMMENT '资源编码',
  area        DOUBLE COMMENT '资源面积',
  deleteBy    BIGINT COMMENT '删除人',
  deleteTime  DATETIME COMMENT '删除时间',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  contId      BIGINT COMMENT '所属合同',
  useStatus   INT COMMENT '是否被租用',
  PRIMARY KEY (id)
);

ALTER TABLE resource_info
  COMMENT '资源表';
  
 DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msgId`      BIGINT(20) NOT NULL
  COMMENT '消息ID',
  `msgBizType` INT(11)    NOT NULL
  COMMENT '消息业务类型   参见枚举BizType',
  `bizId`      BIGINT(20)          DEFAULT NULL
  COMMENT '消息对应的业务ID',
  `msgType`    INT(11)    NOT NULL
  COMMENT '消息类型   参见枚举msgType',
  `src`        BIGINT(20) NOT NULL
  COMMENT '发送者ID',
  `dst`        BIGINT(20) NOT NULL
  COMMENT '接受者ID',
  `msgStatus`  INT(11)    NOT NULL
  COMMENT '消息状态   参见枚举MsgStatus',
  `version`    INT(11)    NOT NULL DEFAULT '0',
  `status`     INT(11)             DEFAULT '0'
  COMMENT '参考枚举：Status',
  `createBy`   BIGINT(20)          DEFAULT '0'
  COMMENT '创建人',
  `createTime` DATETIME            DEFAULT NULL
  COMMENT '创建时间',
  `updateBy`   BIGINT(20)          DEFAULT '0'
  COMMENT '修改人',
  `updateTime` DATETIME            DEFAULT NULL
  COMMENT '修改时间',
  `lastUpdate` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content`    VARCHAR(1000)
               COLLATE utf8_bin    DEFAULT NULL,
  `extId`      INT(11)             DEFAULT NULL
  COMMENT '关联id,备用',
  PRIMARY KEY (`msgId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
ALTER TABLE message
  ADD sourceType INT(11) NULL
COMMENT '来源类型,平台1,园区2,企业3';

drop table if exists service_pro;

/*==============================================================*/
/* Table: service_pro                                           */
/*==============================================================*/
create table service_pro
(
   id                   bigint not null comment '主键',
   mainTitle            varchar(90) comment '主标题',
   subTitle             varchar(90) comment '副标题',
   serviceTypeId        bigint comment '服务商类型',
   serviceScenarioId    bigint comment '服务商场景',
   content              text comment '服务商详情描述',
   serverGrade          int default 0 comment '服务对象（1.平台，2.园区）',
   serviceGrade         int default 0 comment '服务项目级别（1.平台自营，2.园区自营，3.平台服务商，4.园区服务商）',
   serviceGradeId       bigint comment '服务级别名称（园区 ID、服务商 ID）',
   serviceGradeName     varchar(30) comment '服务级别名称（园区名、服务商名）',
   parkId               bigint comment '所属园区（serviceGrade 为园区自营、园区服务商 时用）',
   supportApply         boolean comment '是否支持申请单',
   applyViewId          bigint comment '申请单显示',
   supportOrder         boolean comment '是否支持订单',
   orderViewId          bigint comment '订单显示',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(100) comment '审批备注',
   parkProId            bigint comment '园区选择省份',
   parkCityId           bigint comment '园区选择城市',
   parkCounId           bigint comment '园区选择县区',
   parkLocationId       bigint comment '园区选择商业圈',
   applyOrderNum        int default 0 comment '申请单订单数',
   collectNum           int default 0 comment '收藏数',
   readNum              int default 0 comment '点击数',
   releases				int default 0 comment '服务项目版本号（从 0 开始）',
   commentNum           decimal(10,1) default 0 comment '评论星级',
   primary key (id)
);

alter table service_pro comment '服务项目信息表';






drop table if exists service_park;

/*==============================================================*/
/* Table: service_park                                          */
/*==============================================================*/
create table service_park
(
   id                   bigint not null comment '主键',
   serviceId            bigint comment '服务项目 ID',
   parkId               bigint comment '园区 ID',
   chooseStatus         int default 0 comment '选用状态',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

drop table if exists apply_template;

/*==============================================================*/
/* Table: apply_template                                        */
/*==============================================================*/
create table apply_template
(
   id                   bigint not null comment '主键',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_template comment '服务申请表模板';

drop table if exists template_label;

/*==============================================================*/
/* Table: template_label                                        */
/*==============================================================*/
create table template_label
(
   id                   bigint not null comment '主键',
   name                 varchar(15) comment '名称（企业名称）',
   labelHint            varchar(30) comment '输入框提示（请输入姓名）',
   labelType            int default 0 comment '输入框类型（1.text,2.file,3.checkbox）',
   labelNo              bigint comment '排列顺序号',
   applyTemplateId      bigint comment '申请模板 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table template_label comment '模板标签描述';

drop table if exists order_template;

/*==============================================================*/
/* Table: order_template                                        */
/*==============================================================*/
create table order_template
(
   id                   bigint not null,
   serviceProId         bigint,
   supportAliPay        boolean comment '是否支持支付宝支付',
   supportWeChatPay     boolean comment '是否支持微信支付',
   priceTitleOne        varchar(30) comment '价格档标题_1',
   priceTitleTwo        varchar(30) comment '价格档标题_2',
   priceTitleThree      varchar(30) comment '价格档标题_3',
   discountTitleOne     varchar(30) comment '折扣价标题_1',
   discountTitleTwo     varchar(30) comment '折扣价标题_2',
   discountTitleThree   varchar(30) comment '折扣价标题_3',
   discountThree        double default 0 comment '折扣价价格_3',
   discountOne          double default 0 comment '折扣价价格_1',
   priceThree           double default 0 comment '价格档价格_3',
   priceOne             double default 0 comment '价格档价格_1',
   priceTwo             double default 0 comment '价格档价格_2',
   discountTwo          double default 0 comment '折扣价价格_2',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table order_template comment '订单模板表';





drop table if exists apply_info;

/*==============================================================*/
/* Table: apply_info                                            */
/*==============================================================*/
create table apply_info
(
   id                   bigint not null comment '主键',
   content              text comment '表单信息',
   serviceProId         bigint comment '所属服务项目',
   serviceProTitle      varchar(30) comment '所属服务项目名称',
   enterpriseId         bigint comment '所属企业',
   enterpriseName       varchar(30) comment '企业名称',
   parkId               bigint comment '所属园区',
   parkName             varchar(30) comment '园区名称',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_info comment '申请单信息';
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
   imgName              varchar(256) comment '图片名称',
   imgUrl               varchar(256) comment '图片地址',
   imgLink              char(10) comment '图片链接',
   imgDesc              varchar(256) comment '图片描述',
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
drop table if exists enterprise_business_contract;

/*==============================================================*/
/* Table: enterprise_business_contract                          */
/*==============================================================*/
create table enterprise_business_contract
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


drop table if exists contract_info;

/*==============================================================*/
/* Table: contract_info                                         */
/*==============================================================*/
create table contract_info
(
   id                   bigint not null comment '主键',
   businessNum          varchar(50) comment '工商号',
   enterpriseName       varchar(200) comment '企业名称',
   contNo               varchar(50) comment '合同号',
   startDate            date comment '合同起始日期',
   endDate              date comment '合同截至日期',
   proAddr              varchar(200) comment '项目详细地址',
   area                 double(3,0) comment '物业面积',
   totalMoney           double(2,0) comment '合同金额',
   deposit              double(2,0) comment '押金总额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   contractStatus       int not null default 0 comment '合同状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table contract_info comment '合同信息表';

drop table if exists contract_dossier;

/*==============================================================*/
/* Table: contract_dossier                                      */
/*==============================================================*/
create table contract_dossier
(
   id                   bigint not null comment 'id',
   contractId           bigint comment '合同Id',
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

alter table contract_dossier comment '合同档案表';

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

drop table if exists apply_order_info;

/*==============================================================*/
/* Table: apply_order_info                                      */
/*==============================================================*/
create table apply_order_info
(
   id                   bigint not null comment '主键',
   applyOrderNo         varchar(60) comment '单据编号',
   applyOrderType       int default 0 comment '申请单订单类型（1.订单,2.申请单）',
   applyOrderStatus     int default 0 comment '申请单订单状态（0.未知，1.待处理，2.已通过，3.未通过，4.待支付，5.待评价，6.已完成，7.已取消，8.已关闭）',
   serviceProId         bigint comment '所属服务项目',
   enterpriseId         bigint comment '单据企业ID',
   enterpriseName       varchar(30) comment '单据企业名称',
   content              text comment '表单信息',
   applyOrderStatusMemo varchar(300) comment '申请单订单备注',
   billHistoryId        bigint comment '流水账记录',
   orderMemo            varchar(100) comment '订单备注',
   priceTitle           varchar(30) comment '选用的价格名称',
   price                decimal comment '选用的价格',
   commentId            bigint comment '评价内容',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   payWay               int default 0 comment '支付方式',
   primary key (id)
);

alter table apply_order_info comment '申请单订单信息';


/*========================================费用账单===========================================*/
/*========================================start==============================================*/

drop table if exists bill_info;

/*==============================================================*/
/* Table: bill_info                                             */
/*==============================================================*/
create table bill_info
(
   id                   bigint not null comment '主键',
   billNo               varchar(50) comment '单据编号',
   parkId               bigint comment '所属园区',
   companyId            bigint comment '所属企业',
   companyName          varchar(200) comment '企业名称',
   contractId           bigint comment '关联合同',
   contractNo           varchar(50) comment '合同号',
   billMonth            varchar(10) comment '账单月份',
   totalMoney           decimal(11,2) comment '合计费用总额',
   totalTaxMoney        decimal(11,2) comment '合计税额',
   reliefMoney          decimal(11,2) comment '减免金额',
   reliefRemark         varchar(200) comment '减免备注',
   totalAmount          decimal(11,2) comment '合计总额',
   billStatus           int(2) comment '账单状态',
   submitStatus         int(2) comment '提交状态',
   submitBy             bigint comment '提交人',
   submitTime           datetime comment '提交时间',
   approvalStatus       int(2) default 0 comment '账单审核状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   pushStatus           int(2) default 0 comment '账单推送状态',
   pushBy               bigint comment '推送人',
   pushTime             datetime comment '推送时间',
   confirmStatus        int(2) comment '账单确认状态',
   confirmBy            bigint comment '确认人',
   confirmTime          datetime comment '确认时间',
   verificationStatus   int(2) comment '账单核销状态',
   verificationBy       bigint comment '账单核销人',
   verificationTime     datetime comment '核销时间',
   urgePushStatus       int(2) default 0 comment '账单催缴推送状态',
   urgeBy               bigint comment '催缴人',
   urgeTime             datetime comment '催缴时间',
   payBank              varchar(100) comment '支付银行（预留）',
   paySerialNumber      varchar(50) comment '支付流水号',
   nextAdjust           int(1) default 0 comment '下期调整',
   adjustAmount         decimal(11,2) comment '调整金额',
   adjustRemark         varchar(200) comment '调整备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id),
   unique key AK_uq_billNo (billNo)
);

alter table bill_info comment '账单信息表';


drop table if exists cost_pro;

/*==============================================================*/
/* Table: cost_pro                                              */
/*==============================================================*/
create table cost_pro
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '项目名称',
   code                 varchar(30) comment '项目编码',
   chargeMode           int(2) comment '计费方式(1：按照用量计费，2：按照金额计费)',
   chargePrice          decimal(11,2) comment '计费单价（当chargeMode为按用量计费时启用此字段）',
   costRate             decimal(11,2) DEFAULT 0.00 comment '项目税率',
   createSource         int comment '级别（1,平台模板，2.园区自建）',
   gardenId             bigint comment '所属园区',
   isDefault            int default 0 comment '是否系统默认(0:不是，1：是)，系统默认不可禁用启用',
   enableStatus         int default 0 comment '费用项目状态（1：启用，2：禁用）',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   recommendStatus    int DEFAULT 0 COMMENT '是否是平台默认费用项目',
   primary key (id)
);

alter table cost_pro comment '费用项目表';

drop table if exists bill_cost_detail;

/*==============================================================*/
/* Table: bill_cost_detail                                      */
/*==============================================================*/
create table bill_cost_detail
(
   id                   bigint not null comment '主键',
   billId               bigint comment '费用账单',
   bccrId               bigint comment '费用计算规则',
   dosage               decimal(11,2) comment '项目用量',
   unitPrise            decimal(11,2) comment '项目用量单价',
   costProName          varchar(50) comment '费用项目名称',
   cost                 decimal(11,2) comment '费用金额',
   taxRate              decimal(11,2) comment '税率',
   taxMoney             decimal(11,2) comment '税额',
   totalMoney           decimal(11,2) comment '合计金额',
   verifyMoney          decimal(11,2) comment '核销金额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   isTask               int default 0 comment '是否是维修费（0：否，1：是）',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_detail comment '账单费用明细表';

drop table if exists service_comment;

/*==============================================================*/
/* Table: service_comment                                       */
/*==============================================================*/
create table service_comment
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目',
   gradeNum             int comment '评论星级',
   commentText          varchar(300) comment '评论内容',
   price                decimal(11,2) comment '价格',
   applyOrderId         bigint comment '订单申请单',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   Column_14            char(10),
   primary key (id)
);

alter table service_comment comment '服务项目评论表';

 
drop table if exists bill_change_logs;

/*==============================================================*/
/* Table: bill_change_logs                                      */
/*==============================================================*/
create table bill_change_logs
(
   id                   bigint not null comment '主键Id',
   billId               bigint comment '账单Id',
   operType             int comment '操作类型(创建，审核通过，审核不通过，)',
   operExplain          varchar(200) comment '操作说明',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_change_logs comment '账单变更日志';

alter table bill_change_logs comment '账单变更日志';
drop table if exists bill_cost_cal_rules;

/*==============================================================*/
/* Table: bill_cost_cal_rules                                   */
/*==============================================================*/
create table bill_cost_cal_rules
(
   id                   bigint not null comment 'id',
   contractId            bigint comment '所属合同',
   costProId            bigint comment '所属费用项目',
   costProName          varchar(60) NULL DEFAULT NULL COMMENT '费用账单名' ,
   computeMode          int(2) comment '计算方式（0：未知，1：固定金额，2：自定义计算）',
   freeMonth            int(2) comment '免收月数',
   advanceMonth         int(2) comment '费用预收月数',
   fixedAmount          decimal(11,2) comment '(固定金额)固定金额',
   startAdjAmount       decimal(11,2) comment '(固定金额)起始调整金额',
   startAdjMonth        varchar(10) comment '(固定金额)起始调整账单期间',
   endAdjAmount         decimal(11,2) comment '(固定金额)截止调整金额',
   endAdjMonth          varchar(10) comment '(固定金额)截止调整账单期间',
   leaseAreaCal         int default 0 comment '(自定义计算)租赁面积参与计算状态',
   contAmountCal        int default 0 comment '(自定义计算)合同总额参与计算状态',
   daysCal              int default 0 comment '(自定义计算)天数参与计算状态',
   isRollingCal         int default 0 comment '(自定义计算)是否启用滚动计算',
   rollingStartMonth    int comment '(自定义计算)合同起始后开始滚动月',
   rollingPeriod        int comment '(自定义计算)滚动周期',
   rollingRange         decimal(11,2) comment '(自定义计算)滚动幅度',
   formula              varchar(50) comment '(自定义计算)费用项目金额计算公式',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_cal_rules comment '费用项目计算明细表';

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

/*=============================================end============================================*/
drop table if exists transaction_record;

/*==============================================================*/
/* Table: transaction_record                                    */
/*==============================================================*/

create table transaction_record

(
   id                   bigint comment '主键',
   userId               bigint comment '用户 ID',
   transactionAmount    decimal(16,2) comment '交易金额',
   transactionTime      datetime comment '交易日期',
   transactionDirection int default 0 comment '交易方向',
   transactionType      int default 0 comment '交易类型',
   transactionStatus    int default 0 comment '交易状态',
   payChannel           int default 0 comment '支付渠道',
   transferFromType     int default 0 comment '转入来源类型',
   transferFromId       bigint comment '转入来源 ID',
   transferToType       int default 0 comment '转出类型',
   transferToId         bigint comment '转出 ID',
   bizType              int default 0 comment '业务类型',
   bizId                varchar(20) comment '业务 ID',
   orderNo              varchar(50) comment '订单号',
   explanation          varchar(300) comment '交易说明',
   tradeNo              varchar(100) comment '第三放支付交易号',
   buyerEmail           varchar(100) comment '支付账号',
   buyerId              varchar(50) comment '支付Id',
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

alter table transaction_record comment '支付交易记录表';

drop table if exists apply_label;

/*==============================================================*/
/* Table: apply_label                                           */
/*==============================================================*/
create table apply_label
(
   id                   bigint not null comment '主键',
   name                 varchar(15) comment '名称（企业名称）',
   labelHint            varchar(30) comment '输入框提示（请输入姓名）',
   labelType            int default 0 comment '输入框类型（1.text,2.file,3.checkbox）',
   labelNo              bigint comment '排列顺序号',
   value                varchar(300) comment '输入内容',
   applyOrderId         bigint comment '申请单订单 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   isRequire			int default 0 comment '是否必填（0：非必填，1：必填）',
   primary key (id)
);

alter table apply_label comment '申请单详情表';

drop table if exists enterprise_user_cott;

/*==============================================================*/
/* Table: enterprise_user_cott                                     */
/*==============================================================*/
create table enterprise_user_cott
(
   id                   bigint not null comment '主键',
   parkId				bigint not null comment '园区id',
   enterpriseUserId		bigint not null comment '企业用户id',
   cottId				bigint not null comment '关联关系id',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enterprise_user_cott comment '企业用户园区关联关系表';

drop table if exists bill_collection_record;

/*==============================================================*/
/* Table: bill_collection_record                                */
/*==============================================================*/
create table bill_collection_record
(
   id                   bigint not null comment 'id',
   billId               bigint comment '账单Id',
   collectionTime       datetime comment '收款时间',
   collectionBank       varchar(50) comment '收款银行',
   collectionAccount    varchar(50) comment '收款账户',
   collectionAmount     decimal(11,2) comment '收款金额',
   payChannels          varchar(50) comment '支付方式',
   paySerialNum         varchar(50) comment '支付流水号',
   remark               varchar(50) comment '备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_collection_record comment '账单收款纪录表';

=======
drop table if exists announcement_info;

/*==============================================================*/
/* Table: announcement_info                                     */
/*==============================================================*/
create table announcement_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '公告标题',
   content              text comment '公告内容',
   publicGrade          int default 0 comment '公告对象级别（1.平台，2.按行政，3.园区）',
   parkId               bigint comment '对象园区（publicGrade 为 ”3 园区“  时使用）',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县区',
   locationId           bigint comment '对象行政位置（publicGrade 为 ”2.按行政“ 时使用）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   createSide           int comment '发布公告方',
   createSideId         bigint comment '发布公告',
   sendGrade            int default 0 comment '发送对象级别（1,全部，2.企业用户，3.园区用户）',
   primary key (id)
);

alter table announcement_info comment '系统公告信息';


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



drop table if exists community_apply;

/*==============================================================*/
/* Table: community_apply                                       */
/*==============================================================*/
create table community_apply
(
   id                   bigint not null comment '主键',
   orderNo              varchar(60) comment '单据编号',
   companyId            bigint comment '所属企业',
   companyName          varchar(60) comment '企业名称',
   parkId               bigint comment '所属园区',
   applyTime            datetime comment '申请日期',
   proprser             varchar(30) comment '申请人',
   phone                varchar(11) comment '联系方式',
   num                  int default 0 comment '申请参与人数',
   describle            varchar(300) comment '备注',
   communityId          bigint comment '申请的活动',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   createSide           int default 0 comment '活动创建方（用与活动查询）',
   createSideId         bigint comment '活动创建方ID',
   primary key (id)
);

alter table community_apply comment '社群活动申请表';


drop table if exists location_info;

/*==============================================================*/
/* Table: location_info                                         */
/*==============================================================*/
create table location_info
(
   id                   bigint not null comment '主键',
   proId                bigint comment '省份',
   cityId               bigint comment '城市',
   counId               bigint comment '县/区',
   business             varchar(45) comment '商业圈',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   primary key (id)
);

alter table location_info comment '行政位置表';

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
   startStatus          int comment '启用状态',
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

DROP TABLE IF EXISTS park_sequence;


drop table if exists policy_info;

/*==============================================================*/
/* Table: policy_info                                           */
/*==============================================================*/
create table policy_info
(
   id                   bigint not null comment '主键',
   title                varchar(300) comment '政策标题',
   polUri               varchar(300) comment '政策链接',
   publicGrade          int default 0 comment '政策级别（1.平台，2.按行政）',
   parkId               bigint comment '对象园区（publicGrade 为 3 时时用，备用）',
   proId                bigint comment '省（publicGrade 为 2 时用）',
   cityId               bigint comment '城市（publicGrade 为 2 时用）',
   counId               bigint comment '县区（publicGrade 为 2 时用）',
   locationId           bigint comment '对象行政位置（publicGrade 为 2 时用）',
   approvalStatus       int default 0 comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(300) comment '审批备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方类型（1.平台，2.园区，3.企业）',
   createSideId         bigint comment '创建方（园区 ID 或 企业 ID）',
   primary key (id)
);

alter table policy_info comment '政策信息表';
drop table if exists service_scenario;

/*==============================================================*/
/* Table: service_scenario                                      */
/*==============================================================*/
create table service_scenario
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '场景名称',
   serverGrade          int default 0 comment '服务场景级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '场景描述',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   scaneLogo            varchar(300) comment '图标',
   recoLogo             varchar(300) comment '推荐图标',
   primary key (id)
);

alter table service_scenario comment '服务场景表';
drop table if exists service_type;

/*==============================================================*/
/* Table: service_type                                          */
/*==============================================================*/
create table service_type
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '服务名称',
   isReco               boolean comment '是否是推荐服务',
   serverGrade          int default 0 comment '服务级别（1.平台，2.园区，3.平台/园区）',
   describle            varchar(300) comment '类型描述',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   recoBy               bigint comment '推荐人',
   recoTime             datetime comment '推荐时间',
   unRecoBy             bigint comment '取消推荐人',
   unRecoTime           datetime comment '取消推荐时间',
   typeLogo             varchar(300) comment '服务类型图标（用于服务分类展示页面上显示）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   recoLogo             varchar(300) comment '推荐类型图标（企业端首页显示）',
   primary key (id)
);

alter table service_type comment '服务类型表';


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



drop table if exists task_executor;

/*==============================================================*/
/* Table: task_executor                                         */
/*==============================================================*/
create table task_executor
(
   id                   bigint not null comment '主键',
   taskId               bigint comment '任务ID',
   executorId           bigint comment '执行人 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);


drop table if exists desc_info;

/*==============================================================*/
/* Table: desc_info                                             */
/*==============================================================*/
create table desc_info
(
   id                   bigint not null comment '主键',
   desciption           varchar(600) comment '描述',
   enableStatus         int default 0 comment '启用状态',
   parkId               bigint comment '所属园区',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   deleteBy             bigint comment '删除人',
   deleteTime           datetime comment '删除时间',
   primary key (id)
);

alter table desc_info comment '常用描述表';

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



drop table if exists equipment_type;

/*==============================================================*/
/* Table: equipment_type                                        */
/*==============================================================*/
create table equipment_type
(
   id                   bigint not null comment '主键',
   code                 varchar(300) comment '设备类别代码',
   name                 varchar(300) comment '设备类别名称',
   parkId               bigint comment '所属园区',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   enableStatus         int default 0 comment '启用状态',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   deleteTime           datetime comment '删除时间',
   deleteBy             bigint comment '删除人',
   primary key (id)
);

alter table equipment_type comment '设备类型表';


drop table if exists provider_info;

/*==============================================================*/
/* Table: provider_info                                         */
/*==============================================================*/
create table provider_info
(
   id                   bigint not null comment '主键',
   name                 varchar(60) comment '服务商名称',
   proId                bigint comment '所属省份',
   cityId               bigint comment '所属城市',
   counId               bigint comment '所属县/区',
   contacts             varchar(30) comment '联系人',
   phone                varchar(11) comment '联系电话',
   account              varchar(60) comment '服务商账号',
   description          varchar(300) comment '服务商简介',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   createSide           int default 0 comment '创建方（1.平台，2.园区）',
   parkId               bigint comment '创建方为园区时使用',
   enableStatus         int default 0 comment '启用状态（1.已启用，2.已禁用）',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   primary key (id)
);

alter table provider_info comment '服务商信息表';



#园区管理平台- 物业管理资源相关表
DROP TABLE IF EXISTS res_info;

/*==============================================================*/
/* Table: res_info    物业资源类型表                              */
/*==============================================================*/
CREATE TABLE res_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  name        VARCHAR(100) COMMENT '物业资源类型名称',
  code        VARCHAR(100) COMMENT '物业资源类型编码',
  resType     INT COMMENT '物业资源性质（1.普通资源，2.公共资源）',
  enableStatus INT COMMENT '启用状态',
  gardenId    BIGINT default 0 COMMENT '所属园区',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  startBy     BIGINT COMMENT '启用人',
  startTime   DATETIME COMMENT '启用时间',
  closeBy     BIGINT COMMENT '禁用人',
  closeTime   DATETIME COMMENT '禁用时间',
  PRIMARY KEY (id)
);

ALTER TABLE res_info
  COMMENT '物业资源类型表';

DROP TABLE IF EXISTS unit_tier_info;

/*==============================================================*/
/* Table: unit_tier_info  单位层级表                             */
/*==============================================================*/
CREATE TABLE unit_tier_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  name        VARCHAR(100) COMMENT '层级名称',
  code        VARCHAR(100) COMMENT '层级编码',
  isBase      BOOLEAN COMMENT '是否是基础层级',
  tierNum     INT COMMENT '层级系数',
  resInfoId   BIGINT COMMENT '资源类型,对应物业资源类型表.Id',
  resInfoName VARCHAR(100) COMMENT '资源类型名称',
  enableStatus INT COMMENT '启用状态',
  gardenId    BIGINT COMMENT '所属园区',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  startBy     BIGINT COMMENT '启用人',
  startTime   DATETIME COMMENT '启用时间',
  closeBy     BIGINT COMMENT '禁用人',
  closeTime   DATETIME COMMENT '禁用时间',
  PRIMARY KEY (id)
);
ALTER TABLE unit_tier_info
  COMMENT '单位层级表';

DROP TABLE IF EXISTS resource_info;

/*==============================================================*/
/* Table: resource_info      资源表                              */
/*==============================================================*/
CREATE TABLE resource_info
(
  id          BIGINT    NOT NULL
  COMMENT '主键',
  isRoot      BOOLEAN COMMENT '是否是根资源',
  resInfoId   BIGINT COMMENT '资源类型',
  tierId      BIGINT COMMENT '资源层级(单位)',
  tierName    VARCHAR(100) COMMENT '层级名称',
  tierNum     INT COMMENT '层级系数',
  name        VARCHAR(100) COMMENT '资源名称',
  description VARCHAR(100) COMMENT '资源描述',
  gardenId    BIGINT COMMENT '所属园区',
  parentId    BIGINT COMMENT '父资源',
  isSeat      BOOLEAN COMMENT '是否是工位',
  code        VARCHAR(100) COMMENT '资源编码',
  area        DOUBLE COMMENT '资源面积',
  deleteBy    BIGINT COMMENT '删除人',
  deleteTime  DATETIME COMMENT '删除时间',
  version     INT       NOT NULL DEFAULT 0
  COMMENT '版本号',
  status      INT       NOT NULL
  COMMENT '状态',
  createBy    BIGINT COMMENT '创建人',
  createTime  DATETIME COMMENT '创建时间',
  updateBy    BIGINT COMMENT '修改人',
  updateTime  DATETIME COMMENT '修改时间',
  lastUpdate  TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  contId      BIGINT COMMENT '所属合同',
  useStatus   INT COMMENT '是否被租用',
  PRIMARY KEY (id)
);

ALTER TABLE resource_info
  COMMENT '资源表';
  
 DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msgId`      BIGINT(20) NOT NULL
  COMMENT '消息ID',
  `msgBizType` INT(11)    NOT NULL
  COMMENT '消息业务类型   参见枚举BizType',
  `bizId`      BIGINT(20)          DEFAULT NULL
  COMMENT '消息对应的业务ID',
  `msgType`    INT(11)    NOT NULL
  COMMENT '消息类型   参见枚举msgType',
  `src`        BIGINT(20) NOT NULL
  COMMENT '发送者ID',
  `dst`        BIGINT(20) NOT NULL
  COMMENT '接受者ID',
  `msgStatus`  INT(11)    NOT NULL
  COMMENT '消息状态   参见枚举MsgStatus',
  `version`    INT(11)    NOT NULL DEFAULT '0',
  `status`     INT(11)             DEFAULT '0'
  COMMENT '参考枚举：Status',
  `createBy`   BIGINT(20)          DEFAULT '0'
  COMMENT '创建人',
  `createTime` DATETIME            DEFAULT NULL
  COMMENT '创建时间',
  `updateBy`   BIGINT(20)          DEFAULT '0'
  COMMENT '修改人',
  `updateTime` DATETIME            DEFAULT NULL
  COMMENT '修改时间',
  `lastUpdate` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content`    VARCHAR(1000)
               COLLATE utf8_bin    DEFAULT NULL,
  `extId`      INT(11)             DEFAULT NULL
  COMMENT '关联id,备用',
  PRIMARY KEY (`msgId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
ALTER TABLE message
  ADD sourceType INT(11) NULL
COMMENT '来源类型,平台1,园区2,企业3';

drop table if exists service_pro;

/*==============================================================*/
/* Table: service_pro                                           */
/*==============================================================*/
create table service_pro
(
   id                   bigint not null comment '主键',
   mainTitle            varchar(90) comment '主标题',
   subTitle             varchar(90) comment '副标题',
   serviceTypeId        bigint comment '服务商类型',
   serviceScenarioId    bigint comment '服务商场景',
   content              text comment '服务商详情描述',
   serverGrade          int default 0 comment '服务对象（1.平台，2.园区）',
   serviceGrade         int default 0 comment '服务项目级别（1.平台自营，2.园区自营，3.平台服务商，4.园区服务商）',
   serviceGradeId       bigint comment '服务级别名称（园区 ID、服务商 ID）',
   serviceGradeName     varchar(30) comment '服务级别名称（园区名、服务商名）',
   parkId               bigint comment '所属园区（serviceGrade 为园区自营、园区服务商 时用）',
   supportApply         boolean comment '是否支持申请单',
   applyViewId          bigint comment '申请单显示',
   supportOrder         boolean comment '是否支持订单',
   orderViewId          bigint comment '订单显示',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(100) comment '审批备注',
   parkProId            bigint comment '园区选择省份',
   parkCityId           bigint comment '园区选择城市',
   parkCounId           bigint comment '园区选择县区',
   parkLocationId       bigint comment '园区选择商业圈',
   primary key (id)
);

alter table service_pro comment '服务项目信息表';





drop table if exists service_park;

/*==============================================================*/
/* Table: service_park                                          */
/*==============================================================*/
create table service_park
(
   id                   bigint not null comment '主键',
   serviceId            bigint comment '服务项目 ID',
   parkId               bigint comment '园区 ID',
   chooseStatus         int default 0 comment '选用状态',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

drop table if exists apply_template;

/*==============================================================*/
/* Table: apply_template                                        */
/*==============================================================*/
create table apply_template
(
   id                   bigint not null comment '主键',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_template comment '服务申请表模板';

drop table if exists template_label;

/*==============================================================*/
/* Table: template_label                                        */
/*==============================================================*/
create table template_label
(
   id                   bigint not null comment '主键',
   name                 varchar(15) comment '名称（企业名称）',
   labelHint            varchar(30) comment '输入框提示（请输入姓名）',
   labelType            int default 0 comment '输入框类型（1.text,2.file,3.checkbox）',
   labelNo              bigint comment '排列顺序号',
   applyTemplateId      bigint comment '申请模板 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   isRequire			int default 0 comment '是否必填（0：非必填，1：必填）',
   primary key (id)
);

alter table template_label comment '模板标签描述';

drop table if exists order_template;

/*==============================================================*/
/* Table: order_template                                        */
/*==============================================================*/
create table order_template
(
   id                   bigint not null,
   serviceProId         bigint,
   supportAliPay        boolean comment '是否支持支付宝支付',
   supportWeChatPay     boolean comment '是否支持微信支付',
   priceTitleOne        varchar(30) comment '价格档标题_1',
   priceTitleTwo        varchar(30) comment '价格档标题_2',
   priceTitleThree      varchar(30) comment '价格档标题_3',
   discountTitleOne     varchar(30) comment '折扣价标题_1',
   discountTitleTwo     varchar(30) comment '折扣价标题_2',
   discountTitleThree   varchar(30) comment '折扣价标题_3',
   discountThree        double default 0 comment '折扣价价格_3',
   discountOne          double default 0 comment '折扣价价格_1',
   priceThree           double default 0 comment '价格档价格_3',
   priceOne             double default 0 comment '价格档价格_1',
   priceTwo             double default 0 comment '价格档价格_2',
   discountTwo          double default 0 comment '折扣价价格_2',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table order_template comment '订单模板表';





drop table if exists apply_info;

/*==============================================================*/
/* Table: apply_info                                            */
/*==============================================================*/
create table apply_info
(
   id                   bigint not null comment '主键',
   content              text comment '表单信息',
   serviceProId         bigint comment '所属服务项目',
   serviceProTitle      varchar(30) comment '所属服务项目名称',
   enterpriseId         bigint comment '所属企业',
   enterpriseName       varchar(30) comment '企业名称',
   parkId               bigint comment '所属园区',
   parkName             varchar(30) comment '园区名称',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_info comment '申请单信息';
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
   imgName              varchar(256) comment '图片名称',
   imgUrl               varchar(256) comment '图片地址',
   imgLink              char(10) comment '图片链接',
   imgDesc              varchar(256) comment '图片描述',
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
drop table if exists enterprise_business_contract;

/*==============================================================*/
/* Table: enterprise_business_contract                          */
/*==============================================================*/
create table enterprise_business_contract
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
--增长字段长度
alter table enterprise_display modify thumbnailUrl varchar(200);
alter table enterprise_display modify detailUrl varchar(200);


drop table if exists contract_info;

/*==============================================================*/
/* Table: contract_info                                         */
/*==============================================================*/
create table contract_info
(
   id                   bigint not null comment '主键',
   businessNum          varchar(50) comment '工商号',
   enterpriseName       varchar(200) comment '企业名称',
   contNo               varchar(50) comment '合同号',
   startDate            date comment '合同起始日期',
   endDate              date comment '合同截至日期',
   proAddr              varchar(200) comment '项目详细地址',
   area                 double(3,0) comment '物业面积',
   totalMoney           double(2,0) comment '合同金额',
   deposit              double(2,0) comment '押金总额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table contract_info comment '合同信息表';

drop table if exists contract_dossier;

/*==============================================================*/
/* Table: contract_dossier                                      */
/*==============================================================*/
create table contract_dossier
(
   id                   bigint not null comment 'id',
   contractId           bigint comment '合同Id',
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

alter table contract_dossier comment '合同档案表';

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

drop table if exists apply_order_info;

/*==============================================================*/
/* Table: apply_order_info                                      */
/*==============================================================*/
create table apply_order_info
(
   id                   bigint not null comment '主键',
   applyOrderNo         varchar(60) comment '单据编号',
   applyOrderType       int default 0 comment '申请单订单类型（1.订单,2.申请单）',
   applyOrderStatus     int default 0 comment '申请单订单状态（0.未知，1.待处理，2.已通过，3.未通过，4.待支付，5.待评价，6.已完成，7.已取消，8.已关闭）',
   serviceProId         bigint comment '所属服务项目',
   enterpriseId         bigint comment '单据企业ID',
   enterpriseName       varchar(30) comment '单据企业名称',
   content              text comment '表单信息',
   applyOrderStatusMemo varchar(300) comment '申请单订单备注',
   billHistoryId        bigint comment '流水账记录',
   orderMemo            varchar(100) comment '订单备注',
   priceTitle           varchar(30) comment '选用的价格名称',
   price                decimal comment '选用的价格',
   commentId            bigint comment '评价内容',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   payWay               int default 0 comment '支付方式',
   primary key (id)
);

alter table apply_order_info comment '申请单订单信息';


/*========================================费用账单===========================================*/
/*========================================start==============================================*/

drop table if exists bill_info;

/*==============================================================*/
/* Table: bill_info                                             */
/*==============================================================*/
create table bill_info
(
   id                   bigint not null comment '主键',
   billNo               varchar(50) comment '单据编号',
   parkId               bigint comment '所属园区',
   companyId            bigint comment '所属企业',
   companyName          varchar(200) comment '企业名称',
   contractId           bigint comment '关联合同',
   contractNo           varchar(50) comment '合同号',
   billMonth            varchar(10) comment '账单月份',
   totalMoney           decimal(11,2) comment '合计费用总额',
   totalTaxMoney        decimal(11,2) comment '合计税额',
   reliefMoney          decimal(11,2) comment '减免金额',
   reliefRemark         varchar(200) comment '减免备注',
   totalAmount          decimal(11,2) comment '合计总额',
   billStatus           int(2) comment '账单状态',
   submitStatus         int(2) comment '提交状态',
   submitBy             bigint comment '提交人',
   submitTime           datetime comment '提交时间',
   approvalStatus       int(2) default 0 comment '账单审核状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   pushStatus           int(2) default 0 comment '账单推送状态',
   pushBy               bigint comment '推送人',
   pushTime             datetime comment '推送时间',
   confirmStatus        int(2) comment '账单确认状态',
   confirmBy            bigint comment '确认人',
   confirmTime          datetime comment '确认时间',
   verificationStatus   int(2) comment '账单核销状态',
   verificationBy       bigint comment '账单核销人',
   verificationTime     datetime comment '核销时间',
   urgePushStatus       int(2) default 0 comment '账单催缴推送状态',
   urgeBy               bigint comment '催缴人',
   urgeTime             datetime comment '催缴时间',
   payBank              varchar(100) comment '支付银行（预留）',
   paySerialNumber      varchar(50) comment '支付流水号',
   nextAdjust           int(1) default 0 comment '下期调整',
   adjustAmount         decimal(11,2) comment '调整金额',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id),
   unique key AK_uq_billNo (billNo)
);

alter table bill_info comment '账单信息表';


drop table if exists cost_pro;

/*==============================================================*/
/* Table: cost_pro                                              */
/*==============================================================*/
create table cost_pro
(
   id                   bigint not null comment '主键',
   name                 varchar(30) comment '项目名称',
   code                 varchar(30) comment '项目编码',
   chargeMode           int(2) comment '计费方式(1：按照用量计费，2：按照金额计费)',
   chargePrice          decimal(11,2) comment '计费单价（当chargeMode为按用量计费时启用此字段）',
   costRate             decimal(11,2) comment '项目税率',
   createSource         int comment '级别（1,平台模板，2.园区自建）',
   gardenId             bigint comment '所属园区',
   isDefault            int default 0 comment '是否系统默认(0:不是，1：是)，系统默认不可禁用启用',
   enableStatus         int default 0 comment '费用项目状态（1：启用，2：禁用）',
   enableBy             bigint comment '启用人',
   enableTime           datetime comment '启用时间',
   disableBy            bigint comment '禁用人',
   disableTime          datetime comment '禁用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table cost_pro comment '费用项目表';

drop table if exists bill_cost_detail;

/*==============================================================*/
/* Table: bill_cost_detail                                      */
/*==============================================================*/
create table bill_cost_detail
(
   id                   bigint not null comment '主键',
   billId               bigint comment '费用账单',
   bccrId               bigint comment '费用计算规则',
   dosage               decimal(11,2) comment '项目用量',
   unitPrise            decimal(11,2) comment '项目用量单价',
   costProName          varchar(50) comment '费用项目名称',
   cost                 decimal(11,2) comment '费用金额',
   taxRate              decimal(11,2) comment '税率',
   taxMoney             decimal(11,2) comment '税额',
   totalMoney           decimal(11,2) comment '合计金额',
   costProType          int comment '费用项目类型（1.合同的费用项目，2.园区的普通费用项目）',
   useStatus            int comment '使用状态（默认情况下合同费用项目单未使用，选择后为使用）',
   useBy                bigint comment '费用单使用人',
   useTime              datetime comment '费用单使用时间',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_detail comment '账单费用明细表';

drop table if exists service_comment;

/*==============================================================*/
/* Table: service_comment                                       */
/*==============================================================*/
create table service_comment
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目',
   gradeNum             int comment '评论星级',
   commentText          varchar(300) comment '评论内容',
   price                decimal(11,2) comment '价格',
   applyOrderId         bigint comment '订单申请单',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   Column_14            char(10),
   primary key (id)
);

alter table service_comment comment '服务项目评论表';

 
drop table if exists bill_change_logs;

/*==============================================================*/
/* Table: bill_change_logs                                      */
/*==============================================================*/
create table bill_change_logs
(
   id                   bigint not null comment '主键Id',
   billId               bigint comment '账单Id',
   operType             int comment '操作类型(创建，审核通过，审核不通过，)',
   operExplain          varchar(200) comment '操作说明',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_change_logs comment '账单变更日志';

alter table bill_change_logs comment '账单变更日志';
drop table if exists bill_cost_cal_rules;

/*==============================================================*/
/* Table: bill_cost_cal_rules                                   */
/*==============================================================*/
create table bill_cost_cal_rules
(
   id                   bigint not null comment 'id',
   contractId            bigint comment '所属合同',
   costProId            bigint comment '所属费用项目',
   costProName          varchar(60) NULL DEFAULT NULL COMMENT '费用账单名' ,
   computeMode          int(2) comment '计算方式（0：未知，1：固定金额，2：自定义计算）',
   freeMonth            int(2) comment '免收月数',
   advanceMonth         int(2) comment '费用预收月数',
   fixedAmount          decimal(11,2) comment '(固定金额)固定金额',
   startAdjAmount       decimal(11,2) comment '(固定金额)起始调整金额',
   startAdjMonth        varchar(10) comment '(固定金额)起始调整账单期间',
   endAdjAmount         decimal(11,2) comment '(固定金额)截止调整金额',
   endAdjMonth          varchar(10) comment '(固定金额)截止调整账单期间',
   leaseAreaCal         int default 0 comment '(自定义计算)租赁面积参与计算状态',
   contAmountCal        int default 0 comment '(自定义计算)合同总额参与计算状态',
   daysCal              int default 0 comment '(自定义计算)天数参与计算状态',
   isRollingCal         int default 0 comment '(自定义计算)是否启用滚动计算',
   rollingStartMonth    int comment '(自定义计算)合同起始后开始滚动月',
   rollingPeriod        int comment '(自定义计算)滚动周期',
   rollingRange         decimal(11,2) comment '(自定义计算)滚动幅度',
   formula              varchar(50) comment '(自定义计算)费用项目金额计算公式',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_cost_cal_rules comment '费用项目计算明细表';

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

/*=============================================end============================================*/
drop table if exists transaction_record;

/*==============================================================*/
/* Table: transaction_record                                    */
/*==============================================================*/

create table transaction_record

(
   id                   bigint comment '主键',
   userId               bigint comment '用户 ID',
   transactionAmount    decimal(16,2) comment '交易金额',
   transactionTime      datetime comment '交易日期',
   transactionDirection int default 0 comment '交易方向',
   transactionType      int default 0 comment '交易类型',
   transactionStatus    int default 0 comment '交易状态',
   payChannel           int default 0 comment '支付渠道',
   transferFromType     int default 0 comment '转入来源类型',
   transferFromId       bigint comment '转入来源 ID',
   transferToType       int default 0 comment '转出类型',
   transferToId         bigint comment '转出 ID',
   bizType              int default 0 comment '业务类型',
   bizId                varchar(20) comment '业务 ID',
   orderNo              varchar(50) comment '订单号',
   explanation          varchar(300) comment '交易说明',
   tradeNo              varchar(100) comment '第三放支付交易号',
   buyerEmail           varchar(100) comment '支付账号',
   buyerId              varchar(50) comment '支付Id',
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

alter table transaction_record comment '支付交易记录表';

drop table if exists apply_label;

/*==============================================================*/
/* Table: apply_label                                           */
/*==============================================================*/
create table apply_label
(
   id                   bigint not null comment '主键',
   name                 varchar(15) comment '名称（企业名称）',
   labelHint            varchar(30) comment '输入框提示（请输入姓名）',
   labelType            int default 0 comment '输入框类型（1.text,2.file,3.checkbox）',
   labelNo              bigint comment '排列顺序号',
   value                varchar(300) comment '输入内容',
   applyOrderId         bigint comment '申请单订单 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table apply_label comment '申请单详情表';

drop table if exists enterprise_user_cott;

/*==============================================================*/
/* Table: enterprise_user_cott                                     */
/*==============================================================*/
create table enterprise_user_cott
(
   id                   bigint not null comment '主键',
   parkId				bigint not null comment '园区id',
   enterpriseUserId		bigint not null comment '企业用户id',
   cottId				bigint not null comment '关联关系id',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table enterprise_user_cott comment '企业用户园区关联关系表';

drop table if exists bill_collection_record;

/*==============================================================*/
/* Table: bill_collection_record                                */
/*==============================================================*/
create table bill_collection_record
(
   id                   bigint not null comment 'id',
   billId               bigint comment '账单Id',
   collectionTime       datetime comment '收款时间',
   collectionBank       varchar(50) comment '收款银行',
   collectionAccount    varchar(50) comment '收款账户',
   collectionAmount     decimal(11,2) comment '收款金额',
   payChannels          varchar(50) comment '支付方式',
   paySerialNum         varchar(50) comment '支付流水号',
   remark               varchar(50) comment '备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_collection_record comment '账单收款纪录表';

drop table if exists service_collect;

/*==============================================================*/
/* Table: service_collect                                       */
/*==============================================================*/
create table service_collect
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目',
   parkId               bigint comment '园区',
   collectBy            bigint comment '收藏人',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table service_collect comment '服务项目收藏表';

drop table if exists bill_ccr_adj;

/*==============================================================*/
/* Table: bill_ccr_adj                                          */
/*==============================================================*/
create table bill_ccr_adj
(
   id                   bigint not null comment '主键Id',
   bccrId               bigint comment '计算规则Id',
   adjAmount            decimal(11,2) comment '调整金额',
   adjMonth             varchar(10) comment '调整月份',
   adjRemark            varchar(200) comment '调整备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table bill_ccr_adj comment '计算规则月份调整记录';

alter table bill_ccr_adj add constraint FK_Reference_20 foreign key (bccrId)
      references bill_cost_cal_rules (id) on delete restrict on update restrict;

      
drop table if exists roll_period_info;

/*==============================================================*/
/* Table: roll_period_info                                      */
/*==============================================================*/
create table roll_period_info
(
   id                   bigint not null comment '主键',
   startDate            datetime comment '开始年月',
   endDate              datetime comment '结束年月',
   rollPeriod           int default 0 comment '滚动周期',
   rollRange            decimal(11,2) comment '滚动幅度',
   billCostCalRulesId   bigint comment '费用项目计算规则明细',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table roll_period_info comment '滚动周期表';

drop table if exists service_pro_scane;

/*==============================================================*/
/* Table: service_pro_scane                                     */
/*==============================================================*/
create table service_pro_scane
(
   id                   bigint not null comment '主键',
   serviceProId         bigint comment '服务项目 ID',
   serviceScaneId       bigint comment '服务场景 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   serviceProRelease	int default 0 comment '服务项目版本号（从 0 开始）',
   isPast				int default 0 comment '是否是历史版本（0：非，1:是）',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table service_pro_scane comment '服务项目场景表';

drop table if exists contract_bill;

/*==============================================================*/
/* Table: contract_bill                                         */
/*==============================================================*/
create table contract_bill
(
   id                   bigint not null comment '主键',
   contractId           bigint comment '合同 ID',
   month            varchar(50) comment '账单月份',
   billAmount               decimal(11,2) comment '当月账单金额',
   isBillMonth          int default 0 comment '是否是账单月（0：否，1：是）',
   costProId            bigint comment '费用项目 ID',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table contract_bill comment '合同账单表';

drop table if exists service_pro;

/*==============================================================*/
/* Table: service_pro                                           */
/*==============================================================*/
create table service_pro
(
   id                   bigint not null comment '主键',
   serviceProId                   bigint not null comment '服务项目',
   mainTitle            varchar(90) comment '主标题',
   subTitle             varchar(90) comment '副标题',
   serviceTypeId        bigint comment '服务商类型',
   serviceScenarioId    bigint comment '服务商场景',
   content              text comment '服务商详情描述',
   serverGrade          int default 0 comment '服务对象（1.平台，2.园区）',
   serviceGrade         int default 0 comment '服务项目级别（1.平台自营，2.园区自营，3.平台服务商，4.园区服务商）',
   serviceGradeId       bigint comment '服务级别名称（园区 ID、服务商 ID）',
   serviceGradeName     varchar(30) comment '服务级别名称（园区名、服务商名）',
   parkId               bigint comment '所属园区（serviceGrade 为园区自营、园区服务商 时用）',
   supportApply         boolean comment '是否支持申请单',
   applyViewId          bigint comment '申请单显示',
   supportOrder         boolean comment '是否支持订单',
   orderViewId          bigint comment '订单显示',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   approvalStatus       int comment '审批状态',
   approvalBy           bigint comment '审批人',
   approvalTime         datetime comment '审批时间',
   approvalText         varchar(100) comment '审批备注',
   parkProId            bigint comment '园区选择省份',
   parkCityId           bigint comment '园区选择城市',
   parkCounId           bigint comment '园区选择县区',
   parkLocationId       bigint comment '园区选择商业圈',
   applyOrderNum        int default 0 comment '申请单订单数',
   collectNum           int default 0 comment '收藏数',
   readNum              int default 0 comment '点击数',
   serviceProRelease				int default 0 comment '服务项目版本号（从 0 开始）',
   commentNum           decimal(10,1) default 0 comment '评论星级',
   primary key (id)
);

alter table service_pro comment '服务项目信息表';


drop table if exists system_config;

/*==============================================================*/
/* Table: announcement_info                                     */
/*==============================================================*/
create table system_config
(
   id                   	bigint not null comment '主键',
   parkId					bigint not null comment '园区id，一个园区有且最多只能拥有一条配置信息',
   maintenanceReportSign    int not null default 0 comment '维修申报 0-未知 1-启用 2-禁用',
   maintenanceReportDays	int not null default 0 comment '触发维修申报的天数',
   createParkSign			int not null default 0 comment '园区创建 0-未知 1-启用 2-禁用',
   createParkDays			int not null default 0 comment '触发园区创建的天数',
   equipmentMaintainSign	int not null default 0 comment '设备维护 0-未知 1-启用 2-禁用',
   equipmentMaintainDays	int not null default 0 comment '触发设备维护的天数',
   urgeTermSign				int not null default 0 comment '催缴功能 0-未知 1-启用 2-禁用',
   urgeTermDays				int not null default 0 comment '触发催缴功能 的天数',
   urgeContentTemplate		varchar(200) default '' comment '催缴内容模板',
   billIntroduction 		varchar(500) default NULL comment '账单引言';
   billPayWay 				varchar(300) default NULL comment '账单付款方式';
   billBankAccount 			varchar(300) default NULL comment '账单银行账户';
   billInscrible 			varchar(100) default NULL comment '账单落款';
   version              	int not null default 0 comment '版本号',
   status               	int not null default 0 comment '状态',
   createBy             	bigint comment '创建人',
   createTime           	datetime comment '创建时间',
   updateBy             	bigint comment '修改人',
   updateTime           	datetime comment '修改时间',
   lastUpdate           	timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table system_config comment '系统参数配置';

drop table if exists approval_type;

/*==============================================================*/
/* Table: approval_type                                         */
/*==============================================================*/
create table approval_type
(
   id                   bigint not null comment '主键',
   parkId               bigint comment '所属园区',
   approvalType         int default 0 comment '审批类型（合同确认、账单审批、账单核销）',
   latestVersion        int default 0 comment '最新版本（默认：0）',
   enableStatus         int default 1 comment '启用禁用',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_type comment '审批类型表';

drop table if exists approval_type_item;

/*==============================================================*/
/* Table: approval_type_item                                    */
/*==============================================================*/
create table approval_type_item
(
   id                   bigint not null comment '主键',
   approvalTypeId       bigint comment '所属审批类型',
   currentVersion       int default 0 comment '当前版本',
   name                 varchar(30) comment '节点名称',
   approvalId           bigint comment '审批人ID',
   approvalNo           int default 100 comment '流程序列',
   isHistory            tinyint(1) default 0 comment '是否是历史版本',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_type_item comment '审批类型详情表';


drop table if exists approval_record;

/*==============================================================*/
/* Table: approval_record                                       */
/*==============================================================*/
create table approval_record
(
   id                   bigint not null comment '主键',
   approvalType         int default 0 comment '记录的审批类型（合同确认，账单审批，账单核销）',
   mainId               bigint comment '主信息ID（合同 ID、账单 ID）',
   approvalItemId       bigint comment '审批节点 ID',
   approvalItemName     varchar(30) comment '审批节点名称',
   approvalItemNo       int comment '审批节点顺序号',
   approvalItemVersion  int comment '审批节点的版本',
   approvalId           bigint comment '审批人ID',
   approvalName         varchar(30) comment '审批人名称',
   passStatus           tinyint(1) default 0 comment '审批是否通过（未通过：0,、通过：1）',
   approvalMemo         varchar(200) comment '审批备注',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_record comment '审批记录表';

drop table if exists approval_process;

/*==============================================================*/
/* Table: approval_process                                      */
/*==============================================================*/
create table approval_process
(
   id                   bigint not null comment '主键',
   approvalTypeId       bigint comment '流程类型ID',
   approvalTypeVersion  int comment '流程类型版本',
   approvalType         int default 0 comment '记录的审批类型（合同确认，账单审批，账单核销）',
   mainId               bigint comment '主信息ID（合同 ID、账单 ID）',
   approvalItemId       bigint comment '审批节点 ID',
   approvalItemNo       int comment '审批节点顺序号',
   approvalItemVersion  int comment '审批节点的版本',
   approvalId           bigint comment '审批人ID',
   approvalProcessStatus int default 10 comment '审批处理状态（待审批：10、审批中：20、已审批：30）',
   isHistory            tinyint(1) default 0 comment '是否是历史流程（版本升级流程作废）',
   version              int not null default 0 comment '版本号',
   status               int not null default 0 comment '状态',
   createBy             bigint comment '创建人',
   createTime           datetime comment '创建时间',
   updateBy             bigint comment '修改人',
   updateTime           datetime comment '修改时间',
   lastUpdate           timestamp not null comment '最后更新时间',
   primary key (id)
);

alter table approval_process comment '审批流程表';






