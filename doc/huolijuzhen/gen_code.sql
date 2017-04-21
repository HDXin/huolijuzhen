CREATE TABLE `gen_code` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `codeType`   VARCHAR(200) NOT NULL DEFAULT 0
  COMMENT 'code的类型',
  `code`       BIGINT(20)   NOT NULL
  COMMENT 'code',
  `lastUpdate` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
    COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
    COMMENT ''
)
  COMMENT '流水号code表';