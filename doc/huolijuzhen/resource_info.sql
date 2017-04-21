#园区管理平台- 物业管理资源相关表
DROP TABLE IF EXISTS res_info;

/*==============================================================*/
/* Table: res_info    物业资源类型表                              */
/*==============================================================*/
CREATE TABLE `res_info` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '物业资源类型名称',
  `code` varchar(100) DEFAULT NULL COMMENT '物业资源类型编码',
  `resType` int(11) DEFAULT NULL COMMENT '物业资源性质（1.普通资源，2.公共资源）',
  `enableStatus` int(11) DEFAULT NULL COMMENT '启用状态',
  `gardenId` bigint(20) DEFAULT NULL COMMENT '所属园区',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `status` int(11) NOT NULL COMMENT '状态',
  `createBy` bigint(20) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` bigint(20) DEFAULT NULL COMMENT '修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `startBy` bigint(20) DEFAULT NULL COMMENT '启用人',
  `startTime` datetime DEFAULT NULL COMMENT '启用时间',
  `closeBy` bigint(20) DEFAULT NULL COMMENT '禁用人',
  `closeTime` datetime DEFAULT NULL COMMENT '禁用时间',
  `calcDimension` int(11) DEFAULT NULL COMMENT '计算维度',
  `enableAvg` int(11) DEFAULT NULL COMMENT '启用均价计算',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物业资源类型表';

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
CREATE TABLE `resource_info` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `isRoot` tinyint(1) DEFAULT NULL COMMENT '是否是根资源',
  `resInfoId` bigint(20) DEFAULT NULL COMMENT '资源类型',
  `tierId` bigint(20) DEFAULT NULL COMMENT '资源层级(单位)',
  `tierName` varchar(100) DEFAULT NULL COMMENT '层级名称',
  `tierNum` int(11) DEFAULT NULL COMMENT '层级系数',
  `name` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `description` varchar(100) DEFAULT NULL COMMENT '资源描述',
  `gardenId` bigint(20) DEFAULT NULL COMMENT '所属园区',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父资源',
  `isSeat` tinyint(1) DEFAULT NULL COMMENT '是否是工位',
  `code` varchar(100) DEFAULT NULL COMMENT '资源编码',
  `area` double DEFAULT NULL COMMENT '资源面积',
  `deleteBy` bigint(20) DEFAULT NULL COMMENT '删除人',
  `deleteTime` datetime DEFAULT NULL COMMENT '删除时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `status` int(11) NOT NULL COMMENT '状态',
  `createBy` bigint(20) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` bigint(20) DEFAULT NULL COMMENT '修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `contId` bigint(20) DEFAULT NULL COMMENT '所属合同',
  `useStatus` int(11) DEFAULT NULL COMMENT '是否被租用',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格 1/天/m²',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表'

ALTER TABLE resource_info
  COMMENT '资源表';

DROP TABLE IF EXISTS resource_sequence;

CREATE TABLE `resource_sequence` (
  `sequenceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0',
  `serial` bigint(20) NOT NULL DEFAULT '0',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sequenceId`),
  KEY `idx_type_serial` (`type`,`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;