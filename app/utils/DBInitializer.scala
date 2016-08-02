package utils

import scalikejdbc._

object DBInitializer {

  def run() {

    DB readOnly {
      implicit s =>

        try {
          sql"select 1 from ad_formats limit 1".map(_.long(1)).single.apply()
        } catch {
          case e: java.sql.SQLException =>
            DB autoCommit {
              implicit s =>

                sql"""drop table if exists `ad_format`;
                      
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
                      
 drop table if exists `publishers`;
                      
 CREATE TABLE `publishers` (
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
                       UNIQUE KEY `publisherName` (`name`) USING BTREE,
                       KEY `updated_by` (`updated_by`) USING BTREE,
                       KEY `deleted_by` (`deleted_by`) USING BTREE,
                       KEY `requested_by` (`requested_by`) USING BTREE,
                       KEY `created_by` (`created_by`) USING BTREE,
                       CONSTRAINT `publishers_ibfk_1` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_10` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_2` FOREIGN KEY (`deleted_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_3` FOREIGN KEY (`requested_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_5` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_6` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_7` FOREIGN KEY (`deleted_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT `publishers_ibfk_8` FOREIGN KEY (`requested_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
                      ) ENGINE=InnoDB AUTO_INCREMENT=985 DEFAULT CHARSET=utf8;
                      
 INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (1,NULL,NULL,'Dev Ops Publisher','2013-10-21 22:27:02',1,'2013-10-21 22:27:02',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','','NY','New York','01001','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (2,NULL,NULL,'Sunday Pub Name','2013-10-20 15:01:55',4,'2013-10-20 15:01:55',4,NULL,NULL,NULL,NULL,0,'80 8th Avenue -- 5th Floor','','New York','New York','10011','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (3,NULL,NULL,'4Info','2013-10-21 15:24:43',1,'2013-10-22 14:54:06',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (527,NULL,NULL,'Test Publisher','2013-10-21 22:27:02',1,'2013-10-21 22:27:02',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','','NY','New York','01001','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (528,NULL,NULL,'Millennial Media','2013-10-22 08:10:13',1,'2013-10-22 08:10:13',1,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (529,NULL,NULL,'Yahoo!','2013-10-22 12:24:44',10,'2013-10-22 12:24:44',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (530,NULL,NULL,'Mojiva','2013-10-22 12:29:54',10,'2013-10-22 12:29:54',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (531,NULL,NULL,'The Weather Channel','2013-10-22 13:04:10',10,'2013-10-22 15:49:01',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (532,NULL,NULL,'Jumptap','2013-10-22 13:12:45',10,'2013-10-22 13:12:45',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      INSERT INTO `publishers` (`id`,`user_group_id`,`logo`,`name`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`deleted_reason`,`requested_by`,`is_certified`,`address1`,`address2`,`city`,`state`,`zip`,`default_timezone`) VALUES (533,NULL,NULL,'Verve Mobile','2013-10-22 13:15:24',10,'2013-10-22 15:58:04',10,NULL,NULL,NULL,NULL,0,'80 8th Ave','5th Floor','NY','New York','11109','America/New_York');
                      
 drop table if exists `publisher_properties`;
                      
 CREATE TABLE `publisher_properties` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `publisher_id` int(11) unsigned NOT NULL,
                        `name` varchar(255) NOT NULL,
                        `client_site_id` int(11) unsigned DEFAULT NULL,
                        `client_realtime_app_id` int(11) unsigned DEFAULT NULL,
                        `client_app_category_id` int(11) unsigned DEFAULT NULL,
                        `certified_at` datetime DEFAULT NULL,
                        `certified_by` int(11) unsigned DEFAULT NULL,
                        `created_at` datetime DEFAULT NULL,
                        `created_by` int(11) unsigned NOT NULL,
                        `updated_at` datetime NOT NULL,
                        `updated_by` int(11) unsigned NOT NULL,
                        `deleted_at` datetime DEFAULT NULL,
                        `deleted_by` int(11) unsigned DEFAULT NULL,
                        `logo_uploaded_file_id` varchar(255) DEFAULT NULL,
                        `business_type_id` int(11) unsigned NOT NULL DEFAULT '1',
                        `creative_api_type_id` int(11) unsigned NOT NULL DEFAULT '1',
                        `click` varchar(255) DEFAULT NULL,
                        `impPx` varchar(255) DEFAULT NULL,
                        `cache_buster` varchar(255) DEFAULT NULL,
                        `video_play` varchar(255) DEFAULT NULL,
                        `expand` varchar(255) DEFAULT NULL,
                        `notes` text NOT NULL,
                        `dimensions` text NOT NULL,
                        `formats` text,
                        `exchange_id` varchar(255) DEFAULT NULL,
                        `site_id` varchar(255) DEFAULT NULL,
                        `attribution_supported` tinyint(1) NOT NULL DEFAULT '0',
                        `client_ad_tag_code_id` int(10) unsigned NOT NULL DEFAULT '0',
                        `postback_enabled` tinyint(1) unsigned NOT NULL DEFAULT '0',
                        `postback_url` varchar(2048) DEFAULT NULL,
                        `local_storage_enabled` tinyint(1) unsigned NOT NULL DEFAULT '0',
                        `additional_params` text,
                        `destination_type` enum('initial','app','site') NOT NULL DEFAULT 'initial',
                        `original_ad_server_template` varchar(255) NOT NULL DEFAULT '',
                        `publisher_property_ad_server_id` int(10) unsigned NOT NULL DEFAULT '0',
                        `os_device_id` varchar(255) DEFAULT NULL,
                        `os_opt_out` varchar(255) DEFAULT NULL,
                        `pub_impression_id` varchar(255) DEFAULT NULL,
                        `internal_comments` text,
                        `external_comments` text,
                        `contact_email` varchar(100) DEFAULT NULL,
                        `contact_name` varchar(100) DEFAULT NULL,
                        `cost_method` enum('CPM','CPC','CPA') DEFAULT NULL,
                        `cost` decimal(20,2) DEFAULT NULL,
                        `secure_tag` tinyint(1) DEFAULT '0',
                        `requires_tag_override` tinyint(1) unsigned NOT NULL DEFAULT '0',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `unique_name` (`name`) USING BTREE,
                        UNIQUE KEY `publisher_property_name` (`name`,`client_site_id`,`client_realtime_app_id`),
                        KEY `creative_api_type_id` (`creative_api_type_id`),
                        KEY `certified_by` (`certified_by`),
                        KEY `created_by` (`created_by`),
                        KEY `updated_by` (`updated_by`),
                        KEY `publisher_id` (`publisher_id`),
                        CONSTRAINT `publisher_properties_ibfk_2` FOREIGN KEY (`certified_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT `publisher_properties_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT `publisher_properties_ibfk_4` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                        CONSTRAINT `publisher_properties_ibfk_5` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
                      ) ENGINE=InnoDB AUTO_INCREMENT=1541 DEFAULT CHARSET=utf8;
                      
 INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (1,1,'Preprod_Property',1,NULL,1,NULL,1,'2013-10-21 22:08:58',1,'2016-01-25 21:41:36',1,NULL,NULL,'1a880a36-73e6-4cfa-8863-099060f84662',1,1,'','','','','','','[]','[]','','',0,2,0,'',1,'{}','site','custom',1,'','','','','','','','CPM',0.00,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (2,2,'Sunday Property 1',2,NULL,1,NULL,1,'2013-10-21 22:08:58',1,'2015-05-19 03:26:45',9775,NULL,NULL,'354c7a91-586d-4c3f-82d0-041a8fc471ed',1,1,'','','','','','','[]','[]','','',0,2,0,'',1,'','site','custom',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (596,528,'Millennial Media Mydas - Site',3000360,NULL,1,'2013-10-22 00:00:00',9724,'2013-10-22 12:03:23',10,'2015-09-01 18:52:10',9829,NULL,NULL,'bfab6b52-7f8b-4905-9537-3462532255e5',2,1,'','','<?=$$ts?>','','','','[]','[]','','<?=$$apid?>',0,16,1,'http://cvt.mydas.mobi/handleConversion?goalid=$$$$_IMP_goalID_$$$$&urid=$$$$_IMP_pubimpid_$$$$&hdid=$$$$_IMP_osdevid_$$$$',1,'{\"goalID\":\"GOAL_ID\",\"eventTracker\":\"MMAdClickthrough\",\"eventTrackerURL\":\"<?=$$click_url?>\"}','site','custom',1,'','','','','','','','CPM',0.00,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (599,528,'Millennial Media Mydas - App',NULL,4000258,1,'2013-10-22 00:00:00',9724,'2013-10-22 12:24:13',10,'2015-09-13 13:28:18',9829,NULL,NULL,'e3b0c923-86ed-498c-9041-5f331755aa98',2,2,'','','<?=$$ts?>','','','alternate click macro: JT_CLICKURL&r=\r\n\r\n1x1s not supported at time of certification','[]','[]','','<?=$$apid?>',0,2,1,'http://cvt.mydas.mobi/handleConversion?goalid=$$$$_IMP_goalID_$$$$&urid=$$$$_IMP_pubimpid_$$$$&hdid=$$$$_IMP_osdevid_$$$$',0,'{\"goalD\":\"GOAL_ID\",\"eventTracker\":\"MMAdClickthrough\",\"eventTrackerURL\":\"<?=$$click_url?>\"}','app','custom',1,'<?=$$uaid?><?=$$aaid?>','','<?=$$urid?>','','','','','CPM',0.00,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (600,529,'Yahoo! Fantasy Football - App',NULL,4000259,1,'2013-10-22 00:00:00',9724,'2013-10-22 12:28:22',10,'2015-05-19 03:26:45',9775,NULL,NULL,'12c63ee3-823f-4696-af7e-489d7ef4f1f2',1,2,'','','','','','','[]','[]','','',0,2,0,'',0,'','app','',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (601,530,'Mojiva - Site',3000361,NULL,1,'2013-10-22 00:00:00',9724,'2013-10-22 12:32:50',10,'2015-05-19 03:26:45',9775,NULL,NULL,'ccf212fc-c21b-4a3d-81b5-71e9a768b01d',2,1,'','','','','','','[]','[]','','',0,2,0,'',1,'','site','',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (602,530,'Mojiva - App',NULL,4000260,1,'2013-10-22 00:00:00',9724,'2013-10-22 13:03:44',10,'2015-05-19 03:26:45',9775,NULL,NULL,'8597159d-17f6-41c4-bebb-f74b5090c11f',2,2,'','','','','','','[]','[]','','',0,2,0,'',0,'','app','',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (603,531,'Weather Channel - Site',3000362,NULL,1,'2013-10-22 00:00:00',9724,'2013-10-22 13:09:00',10,'2015-06-10 19:18:54',9773,NULL,NULL,'dce70195-1709-4c4e-a3ac-df5ef2952c2a',1,1,'','','','','','No expandable for Tablet','[]','[]','','',0,16,0,'',1,'{}','site','custom',2,'','','','','','','','CPM',0.00,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (604,531,'Weather Channel - App',NULL,4000261,1,'2013-10-22 00:00:00',9724,'2013-10-22 13:10:42',10,'2015-06-10 19:19:12',9773,NULL,NULL,NULL,1,2,'%%CLICK_URL_ESC_ESC%%','','%%CACHEBUSTER%%','','','No expandable on tablet','[]','[]','','',0,2,0,'',0,'{}','app','custom',2,'','','','','','','','CPM',0.00,0,0);
                      INSERT INTO `publisher_properties` (`id`,`publisher_id`,`name`,`client_site_id`,`client_realtime_app_id`,`client_app_category_id`,`certified_at`,`certified_by`,`created_at`,`created_by`,`updated_at`,`updated_by`,`deleted_at`,`deleted_by`,`logo_uploaded_file_id`,`business_type_id`,`creative_api_type_id`,`click`,`impPx`,`cache_buster`,`video_play`,`expand`,`notes`,`dimensions`,`formats`,`exchange_id`,`site_id`,`attribution_supported`,`client_ad_tag_code_id`,`postback_enabled`,`postback_url`,`local_storage_enabled`,`additional_params`,`destination_type`,`original_ad_server_template`,`publisher_property_ad_server_id`,`os_device_id`,`os_opt_out`,`pub_impression_id`,`internal_comments`,`external_comments`,`contact_email`,`contact_name`,`cost_method`,`cost`,`secure_tag`,`requires_tag_override`) VALUES (605,532,'Jumptap - Site',3000363,NULL,1,'2013-10-22 00:00:00',9727,'2013-10-22 13:13:49',10,'2015-05-19 03:26:45',9775,NULL,NULL,'6061db80-6ecf-4a49-9852-b004a2626318',2,1,'','','','','','','[]','[]','','',0,2,0,'',1,'','site','',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);"""
                  .execute
                  .apply()

            }
        }

    }

  }

}