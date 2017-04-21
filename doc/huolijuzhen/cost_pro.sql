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
   parkId               bigint default 0 comment '所属园区',
   isDefault            int default 0 comment '是否系统默认(0:不是，1：是)，系统默认不可禁用启用',
   enableStatus      int comment '费用项目状态（1：启用，2：禁用）',
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