DROP TABLE IF EXISTS sequence_bill_ccr_adj;

CREATE TABLE `sequence_bill_ccr_adj` (
  `sequenceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0',
  `serial` bigint(20) NOT NULL DEFAULT '0',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sequenceId`),
  KEY `idx_type_serial` (`type`,`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

