drop table if exists `ad_format`;

CREATE TABLE `ad_format` (
                 `id` int(11) unsigned NOT NULL,
                 `name` varchar(100) NOT NULL,
                 `created_at` datetime NOT NULL,
                 `description` mediumtext,
                 `visible` tinyint(1) DEFAULT NULL,
                 `type` varchar(30) NOT NULL,
                 `old_ad_format_id` int(11) NOT NULL,
                 `supports_html` tinyint(1) DEFAULT '0',
                 `supports_js` tinyint(1) DEFAULT '0',
                 PRIMARY KEY (`id`)
               ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (1,'Static Interstitial','2013-08-06 16:28:26','Full page interactive unit displays between content pages/views within the app and offers a takeover experience.',1,'static',10,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (2,'Rich Interstitial','2013-08-06 16:28:26','Full page interactive unit displays between content pages/views within the app and offers a takeover experience.',1,'rich',11,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (3,'Static Banner','2013-08-06 16:28:26','Rich experience occurs within boundaries of ad placement and does not require expanding. Commonly used for tablet sizes.',1,'static',20,1,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (4,'Rich Banner','2013-08-06 16:28:26','Rich experience occurs within boundaries of ad placement and does not require expanding. Commonly used for tablet sizes.',1,'rich',21,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (5,'Fourth Party Banner','2013-08-06 16:28:26','',1,'fourthparty',50,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (6,'Rich Expandable','2013-08-06 16:28:26','Units can expand to a full or partial screen rich media panel. Expansion can occur upon a user action or automatically.',1,'rich',31,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (7,'VAST','2013-08-06 16:28:26','Video can be embedded within the rich media unit or viewed via a mobile video player. Includes embedded, custom, and in-stream.',1,'video',41,1,0);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (9,'Impression','2013-08-06 16:28:26','1x1 tracking pixel',1,'tracking',60,1,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (11,'Click','2013-08-06 16:28:26','',1,'tracking',61,1,0);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (12,'Impression/Click','2013-08-06 16:28:26','1x1 tracking pixel',1,'tracking',62,1,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (14,'Fourth Party Interstitial','2013-08-06 16:28:26','',1,'fourthparty',50,0,1);
INSERT INTO `ad_format` (`id`,`name`,`created_at`,`description`,`visible`,`type`,`old_ad_format_id`,`supports_html`,`supports_js`) VALUES (15,'Fourth Party Expandable','2013-08-06 16:28:26','',1,'fourthparty',50,0,1);

drop table if exists `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT '',
  `email` varchar(100) NOT NULL DEFAULT '',
  `crypted_password` varchar(40) DEFAULT NULL,
  `salt` varchar(40) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `remember_token` varchar(40) DEFAULT NULL,
  `remember_token_expires_at` datetime DEFAULT NULL,
  `activation_code` varchar(40) DEFAULT NULL,
  `activated_at` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT 'passive',
  `deleted_at` datetime DEFAULT NULL,
  `base_user_id` int(11) DEFAULT NULL,
  `password_reset_code` varchar(255) DEFAULT NULL,
  `api_key` varchar(255) DEFAULT NULL,
  `converted_at` datetime DEFAULT NULL,
  `penultimate_login` datetime DEFAULT NULL,
  `last_login_at` datetime DEFAULT NULL,
  `first_name` varchar(255) NOT NULL DEFAULT '',
  `last_name` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `phone_number` varchar(255) NOT NULL DEFAULT '',
  `email_opt_in` tinyint(1) DEFAULT NULL,
  `demo_company_id` int(11) unsigned DEFAULT NULL,
  `desired_team_name` varchar(255) DEFAULT NULL,
  `gmt_offset` int(11) DEFAULT NULL,
  `campaign_id` int(11) unsigned DEFAULT NULL,
  `digested_at` datetime DEFAULT NULL,
  `phfp` varchar(255) DEFAULT NULL,
  `psfp` varchar(255) DEFAULT NULL,
  `pupr` varchar(255) DEFAULT NULL,
  `purt` datetime DEFAULT NULL,
  `avatar_file_name` varchar(255) DEFAULT NULL,
  `avatar_content_type` varchar(255) DEFAULT NULL,
  `avatar_file_size` int(11) DEFAULT NULL,
  `avatar_updated_at` datetime DEFAULT NULL,
  `remote_session` char(40) DEFAULT NULL,
  `remote_session_expiration_time` datetime DEFAULT NULL,
  `avatar_uploaded_file_id` varchar(255) DEFAULT NULL,
  `is_admin` tinyint(4) unsigned DEFAULT '0',
  `is_medialets` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `integration_application_id` int(11) unsigned DEFAULT NULL,
  `active` tinyint(4) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_users_on_login` (`login`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10797 DEFAULT CHARSET=utf8;

INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (1,'mladmin@medialets.com','ds','mladmin@medialets.com','81c850edd40740c2634ed087aa161bba859977ad','8341bd7852650d5d5f70f788a0d014e1dfc0e1a1','2013-10-21 22:08:58','2016-05-16 09:31:53',NULL,NULL,'4e0ffbf839d2bf21623980190c0fa4c7deecb418','2012-08-21 17:53:42','active',NULL,NULL,NULL,'4be06e68976b47aeff93a82cd5a1ea23b6daebf3',NULL,NULL,NULL,'Eric','Litman','CEO','(555) 328 8914',NULL,NULL,'Medialets',NULL,NULL,NULL,'DhQ10dLfh6okQo+w6NrCHKCqI6g=','ZQNGXWWZ4XDHB4L0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5b850c6f-1ffc-487d-b852-117e276abe68',1,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (2,'ray.matos@medialets.com','','ray.matos@medialets.com','f3f73714aa1331c6835ccafb78c91172b3153b8d','a6b6bc02b36b1294d9b1ba990eee33490c5753d5','2013-10-21 22:08:58','2015-08-11 20:31:44',NULL,NULL,NULL,'2011-05-26 14:37:47','active',NULL,NULL,NULL,'388746ffe4aec06544b5b411cf2ad6cfac673b5f',NULL,'2013-05-08 22:26:54','2013-05-14 14:01:31','Ray','Matos','Director of ME','484-868-6771',0,3,'Medialets',-8,1105,NULL,'HZvC0mOLePlhmdJCqJtTCLKin/g=','ZMYLUYJ4IJLS345J',NULL,NULL,NULL,NULL,NULL,NULL,'90b742e67a9f4eac8c6213acf5b49211','2013-07-12 03:01:40','1e67b81b-601d-4096-b84c-e66d175e61a0',1,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (3,'sysops@medialets.com','','sysops@medialets.com',NULL,NULL,'2013-10-21 22:08:58','2014-06-10 20:50:20',NULL,NULL,NULL,'2014-01-10 12:28:29','passive',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'sys','ops','','',NULL,NULL,NULL,NULL,NULL,NULL,'0T7zAGlDNt0bLUaY+pWgvYWWuFU=','22PE4oztDNf7iCmr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (4,'anthony.acquanita@medialets.com','','anthony.acquanita@medialets.com','85dc733e92c5dc03dab41a267fd853a4a0b5a113','4d37a8b2077d5665e8f39d4f23cb4c09fce59a93','2013-10-21 22:08:58','2015-07-15 18:58:24',NULL,NULL,NULL,'2011-06-03 18:32:37','active',NULL,NULL,NULL,'274dddb7cb662511d44119032de161ab26d4da3e',NULL,'2013-05-02 17:09:44','2013-05-02 20:57:59','Anthony','Acquanita','','',0,NULL,'Medialets',-6,1049,NULL,'nm27MWQKeEAZwIDAtT4kEGmj/SU=','uqy9emcTxq50trhh',NULL,NULL,NULL,NULL,NULL,NULL,'8e571a064983422ea6849cd591d9028d','2013-05-06 21:56:47',NULL,1,1,NULL,0);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (5,'ryan.petrich@medialets.com','','ryan.petrich@medialets.com','8e7fcadcde3bc3fee74703f10ca6e1c1afd3fc67','52a8eddbb62f46031ae01167290d7eb513cb86d1','2013-10-21 22:08:58','2015-05-10 01:42:36',NULL,NULL,NULL,'2010-09-15 18:44:36','active',NULL,NULL,'','cc2a0da318151c689b87bb286a97c568e6221608',NULL,'2013-04-23 22:04:27','2013-05-01 16:50:10','Ryan','Petrich','Engineering Director','',0,3,'Medialets',-7,2623,'2013-05-14 05:32:18','jJn/jkNaMUkq+wuGxuh6Q5r8oGY=','BF4vRQm1Ui8gPqrW',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'7150bc70-7530-4292-a1a5-aa9b42e8e113',0,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (6,'alvaro.carrasco@medialets.com','','alvaro.carrasco@medialets.com','658b10b332e0598282c302917c2716910ecf1814','883fef38d86294a038240bfc8a2769d2f34a13d6','2013-10-21 22:08:58','2015-07-15 18:58:12',NULL,NULL,NULL,'2013-05-06 17:58:39','active',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Alvaro','Carrasco','','',NULL,NULL,'Medialets',-5,NULL,NULL,'Vw8VZxPTpd2fLdILk+Mo4qpLf0o=','QwlJXTJMu1s7mgnh',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,0);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (7,'paulina.riera@medialets.com','','paulina.riera@medialets.com',NULL,NULL,'2013-10-21 22:08:58','2015-06-01 17:09:35',NULL,NULL,NULL,'2013-10-21 11:05:42','passive',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Paulina','Riera','','',NULL,NULL,NULL,NULL,NULL,NULL,'WbwhLhdFTlHhp69rBMgBFPU3QsQ=','a3xhz5jNmDG5jRKU',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (8,'khalah.jones-golden@medialets.com','','khalah.jones-golden@medialets.com',NULL,NULL,'2013-10-21 22:08:58','2014-06-10 20:50:20',NULL,NULL,NULL,NULL,'passive',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,'vLkT1WoaJsfZkQg2pmVinrlZQlM=','ORfuHFZwWMhJB0Ys',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (9,'craig.pottinger@medialets.com','','craig.pottinger@medialets.com',NULL,NULL,'2013-10-21 22:08:58','2014-06-10 20:50:20',NULL,NULL,NULL,NULL,'passive',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,NULL,1);
INSERT INTO `users` (`id`,`login`,`name`,`email`,`crypted_password`,`salt`,`created_at`,`updated_at`,`remember_token`,`remember_token_expires_at`,`activation_code`,`activated_at`,`state`,`deleted_at`,`base_user_id`,`password_reset_code`,`api_key`,`converted_at`,`penultimate_login`,`last_login_at`,`first_name`,`last_name`,`title`,`phone_number`,`email_opt_in`,`demo_company_id`,`desired_team_name`,`gmt_offset`,`campaign_id`,`digested_at`,`phfp`,`psfp`,`pupr`,`purt`,`avatar_file_name`,`avatar_content_type`,`avatar_file_size`,`avatar_updated_at`,`remote_session`,`remote_session_expiration_time`,`avatar_uploaded_file_id`,`is_admin`,`is_medialets`,`integration_application_id`,`active`) VALUES (10,'derek.kan@medialets.com','','derek.kan@medialets.com',NULL,NULL,'2013-10-21 22:08:58','2015-07-15 18:58:45',NULL,NULL,NULL,'2013-10-22 08:30:34','passive','2014-04-30 14:58:53',NULL,NULL,NULL,NULL,NULL,NULL,'Derek','Kan','Product Director','',NULL,NULL,NULL,NULL,NULL,NULL,'wLZIOVgch5DuSxkHAC6K0VmPAgY=','Mi8QNpFMAQU5nLHR',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,1,NULL,0);

drop table if exists `publisher`;

CREATE TABLE `publisher` (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 `user_group_id` int(11) DEFAULT NULL,
 `logo` varchar(2000) DEFAULT NULL,
 `name` varchar(255) NOT NULL,
 `created_at` datetime DEFAULT NULL,
 `created_by` int(11) unsigned NOT NULL,
 `updated_at` datetime DEFAULT NULL,
 `updated_by` int(11) unsigned NOT NULL,
 `deleted_at` datetime DEFAULT NULL,
 `deleted_by` int(11) unsigned DEFAULT NULL,
 `deleted_reason` varchar(255) DEFAULT NULL,
 `requested_by` int(11) unsigned DEFAULT NULL,
 `is_certified` int(11) DEFAULT '0',
 `address1` varchar(255) DEFAULT '',
 `address2` varchar(255) DEFAULT '',
 `city` varchar(255) DEFAULT '',
 `state` varchar(255) DEFAULT '',
 `zip` varchar(255) DEFAULT '',
 `default_timezone` varchar(50) NOT NULL DEFAULT 'America/New_York',
 PRIMARY KEY (`id`),
 CONSTRAINT `publisher_ibfk_1` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_10` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_2` FOREIGN KEY (`deleted_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_3` FOREIGN KEY (`requested_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_5` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_6` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_7` FOREIGN KEY (`deleted_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `publisher_ibfk_8` FOREIGN KEY (`requested_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=985 DEFAULT CHARSET=utf8;

INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (1,NULL,NULL,'Dev Ops Publisher','2013-10-21 22:27:02',1,'2013-10-21 22:27:02',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','','NY','New York','01001','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (2,NULL,NULL,'Sunday Pub Name','2013-10-20 15:01:55',4,'2013-10-20 15:01:55',4,NULL,NULL,NULL,NULL,0,'80 8th Avenue -- 5th Floor','','New York','New York','10011','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (3,NULL,NULL,'4Info','2013-10-21 15:24:43',1,'2013-10-22 14:54:06',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (527,NULL,NULL,'Test Publisher','2013-10-21 22:27:02',1,'2013-10-21 22:27:02',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','','NY','New York','01001','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (528,NULL,NULL,'Millennial Media','2013-10-22 08:10:13',1,'2013-10-22 08:10:13',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (529,NULL,NULL,'Yahoo!','2013-10-22 12:24:44',10,'2013-10-22 12:24:44',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (530,NULL,NULL,'Mojiva','2013-10-22 12:29:54',10,'2013-10-22 12:29:54',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (531,NULL,NULL,'The Weather Channel','2013-10-22 13:04:10',10,'2013-10-22 15:49:01',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (532,NULL,NULL,'Jumptap','2013-10-22 13:12:45',10,'2013-10-22 13:12:45',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
INSERT INTO `publisher` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (533,NULL,NULL,'Verve Mobile','2013-10-22 13:15:24',10,'2013-10-22 15:58:04',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');

drop table if exists `publisher_property`;

CREATE TABLE `publisher_property` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `publisher_id` int(11) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `publisher_property_ibfk_5` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1541 DEFAULT CHARSET=utf8;

INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (1,1,'Preprod_Property',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (2,2,'Sunday Property 1',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (596,528,'Millennial Media Mydas - Site',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (599,528,'Millennial Media Mydas - App',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (600,529,'Yahoo! Fantasy Football - App',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (601,530,'Mojiva - Site',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (602,530,'Mojiva - App',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (603,531,'Weather Channel - Site',NULL);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (604,531,'Weather Channel - App',NULL,);
INSERT INTO `publisher_property` (`id`,`publisher_id`,`name`,`deleted_at`) VALUES (605,532,'Jumptap - Site',NULL);