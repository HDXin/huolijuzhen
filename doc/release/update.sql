alter table equipment_plan add column planStatus int  DEFAULT 0 comment '计划状态（1.待分配，2.待处理，3.已完成）' ;

#huangdexin 20170327
 alter table admin_user modify column passwordStatus int default 2 comment '初始化密码是否被更改(2：未更改，1：已更改)';
 
 #huangdexin 20170405
 alter table system_config add column billIntroduction varchar(500) default NULL comment '账单引言';
 alter table system_config add column billPayWay varchar(300) default NULL comment '账单付款方式';
 alter table system_config add column billBankAccount varchar(300) default NULL comment '账单银行账户';
 alter table system_config add column billInscrible varchar(100) default NULL comment '账单落款';
 
 #huangdexin 20170418
 alter table contract_info add column approvalProcessId bigint default null comment '审批节点ID';
 alter table contract_info add column executorId bigint default null comment '待审批人';

 alter table bill_info add column approvalProcessId bigint default null comment '审批节点Id';
 alter table bill_info add column approvalExecutorId bigint default null comment '待审批人';
 alter table bill_info add column verifyProcessId bigint default null comment '核销节点Id';
 alter table bill_info add column verifyExecutorId bigint default null comment '待核销人';
 

 
 