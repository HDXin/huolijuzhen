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
