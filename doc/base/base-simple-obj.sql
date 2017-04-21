CREATE TABLE `permission` (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL COMMENT '权限代码，全局唯一',
  `name` varchar(64) NOT NULL COMMENT '权限名',
  `description` varchar(200) DEFAULT '' COMMENT '权限描述',
  `scope` int(11) DEFAULT '0' COMMENT '适用范围',
  `module` varchar(64) DEFAULT null COMMENT '所属模块，用于分组管理，容易区分',
  `menuCode` varchar(64) DEFAULT null COMMENT '所属菜单Code',
  `menuName` varchar(64) DEFAULT null COMMENT '所属菜单名称',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`permissionId`),
  UNIQUE KEY `idx_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `userId` bigint(20) NOT NULL COMMENT 'userId',
  `companyId` bigint(20) NOT NULL DEFAULT '0' COMMENT 'companyId',
  `providerId`  bigint(20) NOT NULL DEFAULT 0 COMMENT '服务商Id' ,
  `userType` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户类别 UserType',
  `platformSource` int(3) DEFAULT '0' COMMENT '用户所属平台（1.平台；2.园区;3.企业）',
  `platformSourceId` bigint(20) DEFAULT '0' COMMENT '所属平台Id(通过userSource区分，园区Id，企业Id)',
  `userAttribute` int(3) DEFAULT '0' COMMENT '用户属性，主要针对园区管理平台（1.园区管理；2.物业管理）；拥有此属性的用户',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `passwordStatus` int(11) NOT NULL DEFAULT '0' COMMENT '是否修改过默认密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `photo` varchar(200) DEFAULT NULL COMMENT '头像 URL',
  `name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `gender` int(11) DEFAULT '0' COMMENT '性别 Gender',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `cellphone` varchar(20) DEFAULT NULL COMMENT '手机',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件',
  `hidden` int(11) DEFAULT '0' COMMENT '是否为隐藏用户',
  `userStatus` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` bigint(20) NOT NULL,
  `platformSource` int(3) DEFAULT '0' COMMENT '用户所属平台（1.平台；2.园区;3.企业）',
  `platformSourceId` bigint(20) DEFAULT '0' COMMENT '所属平台Id(通过userSource区分，园区Id，企业Id)，默认角色为0',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `description` varchar(200) DEFAULT '0' COMMENT '角色描述',
  `scope` int(11) DEFAULT '0' COMMENT '适用范围',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`roleId`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL DEFAULT '0',
  `permissionCode` varchar(64) NOT NULL COMMENT '权限代码，全局唯一',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_roleId` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL DEFAULT '0',
  `permissionCode` varchar(64) NOT NULL COMMENT '权限代码，全局唯一',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL DEFAULT '0',
  `roleId` bigint(20) NOT NULL DEFAULT '0',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userId_roleId` (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `login_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '登陆用户名',
  `userId` bigint(20) DEFAULT '0' COMMENT '登陆用户Id，若登陆成功',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IPv4, IPv6',
  `lng` varchar(30) DEFAULT NULL COMMENT '经度',
  `lat` varchar(30) DEFAULT NULL COMMENT '纬度',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `area` (
  `areaId` int(11) NOT NULL,
  `parentId` int(11) NOT NULL DEFAULT '0' COMMENT '父节点  0表示根节点',
  `adcode` varchar(20) NOT NULL COMMENT '行政区划代码',
  `name` varchar(100) NOT NULL COMMENT '行政区名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`areaId`),
  KEY `idx_parentId` (`parentId`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `app_user` (
  `userId` bigint(20) NOT NULL COMMENT 'userId',
  `companyId` bigint(20) NOT NULL DEFAULT '0' COMMENT 'companyId',
  `userType` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户类别 UserType',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `passwordStatus` int(11) NOT NULL DEFAULT '0' COMMENT '密码状态',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `photo` varchar(200) DEFAULT NULL COMMENT '头像 URL',
  `name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `gender` int(11) DEFAULT '0' COMMENT '性别 Gender',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `cellphone` varchar(20) DEFAULT NULL COMMENT '手机',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件',
  `hidden` int(11) DEFAULT '0' COMMENT '是否为隐藏用户',
  `userStatus` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tracking`;
CREATE TABLE `tracking` (
  `trackingId` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(64) NOT NULL COMMENT '类型',
  `resourceId` varchar(128) NOT NULL COMMENT '资源标示',
  `action` varchar(64) NOT NULL COMMENT '操作行为',
  `data` longtext COMMENT '数据',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`trackingId`)
) ENGINE=InnoDB AUTO_INCREMENT=1337 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history` (
  `smsId` bigint(20) NOT NULL,
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '发送电话号码',
  `content` varchar(500) DEFAULT NULL COMMENT '发送内容',
  `smsStatus` int(11) DEFAULT '0',
  `displayOrder` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status',
  `createBy` bigint(20) DEFAULT '0',
  `createTime` datetime DEFAULT NULL,
  `updateBy` bigint(20) DEFAULT '0',
  `updateTime` datetime DEFAULT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`smsId`),
  KEY `idx_phoneNum` (`phoneNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


