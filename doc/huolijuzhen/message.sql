DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msgId`      BIGINT(20)  NOT NULL COMMENT '消息ID',
  `msgBizType` INT(11)     NOT NULL COMMENT '消息业务类型   参见枚举BizType',
  `bizId`      BIGINT(20)  DEFAULT NULL COMMENT '消息对应的业务ID',
  `msgType`    INT(11)     NOT NULL COMMENT '消息类型   参见枚举msgType',
  `src`        BIGINT(20)  NOT NULL COMMENT '发送者ID',
  `dst`        BIGINT(20)  NOT NULL COMMENT '接受者ID',
  `msgStatus`  INT(11)     NOT NULL COMMENT '消息状态   参见枚举MsgStatus',
  `version`    INT(11)     NOT NULL DEFAULT '0',
  `status`     INT(11)             DEFAULT '0'   COMMENT '参考枚举：Status',
  `createBy`   BIGINT(20)          DEFAULT '0'   COMMENT '创建人', 
  `createTime` DATETIME            DEFAULT NULL    COMMENT '创建时间',
  `updateBy`   BIGINT(20)          DEFAULT '0'   COMMENT '修改人',
  `updateTime` DATETIME            DEFAULT NULL  COMMENT '修改时间',
  `lastUpdate` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content`    VARCHAR(1000)    COLLATE utf8_bin    DEFAULT NULL,
  `extId`      INT(11)             DEFAULT NULL COMMENT '关联id,备用',
  PRIMARY KEY (`msgId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
  ALTER TABLE message ADD sourceType INT(11) NULL COMMENT '来源类型,平台1,园区2,企业3';
  

