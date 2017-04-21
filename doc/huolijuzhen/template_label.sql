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
