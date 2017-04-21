DROP TABLE IF EXISTS sequence_banner;

CREATE TABLE `sequence_banner` (
  `sequenceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0',
  `serial` bigint(20) NOT NULL DEFAULT '0',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sequenceId`),
  KEY `idx_type_serial` (`type`,`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

