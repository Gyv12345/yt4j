/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : nacos_config

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 25/02/2021 11:30:22
*/
USE nacos_config;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'application.yml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    host: yt4j-redis\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  jwt:\n    filter:\n      ignored-url:\n        - /doc.html\n        - /swagger-ui.html\n        - /swagger-resources/**\n        - /swagger/**\n        - /**/v2/api-docs\n        - /**/*.js\n        - /**/*.css\n        - /**/*.png\n        - /**/*.ico\n        - /webjars/springfox-swagger-ui/**\n        - /actuator/**\n        - /user/login\n      header: \'Access-Token\'\n      token-head: \'\'\n  swagger:\n    enabled: true\njasypt:\n  encryptor:\n    password: yt4j\n', 'b645c401fc2aaff318144be29129b489', '2020-12-31 00:39:55', '2021-02-09 01:54:12', NULL, '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (2, 'yt4j-sys.yml', 'DEFAULT_GROUP', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root', '71b0a283b138eb7c28c12e71c6ebc57b', '2020-12-31 00:40:56', '2021-02-04 03:03:22', NULL, '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (3, 'yt4j-gateway.yml', 'DEFAULT_GROUP', 'spring:\n  cloud:\n    gateway:\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1\n      - id: yt4j-ding\n        uri: lb://yt4j-ding\n        predicates:\n        - Path=/ding/**\n        filters:\n        - StripPrefix=1', '88e6133675a03e4e3df053bb3d77c723', '2020-12-31 00:58:55', '2021-02-22 06:28:30', NULL, '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (21, 'yt4j-ding.yml', 'DEFAULT_GROUP', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j-dingtalk?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    username: root\r\n    password: ENC(J4sCVXaoXyijS3Vf6vCqng==) #root\r\n  redis:\r\n    host: yt4j-redis\r\nmybatis-plus:\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\r\njasypt:\r\n  encryptor:\r\n    password: yt4j', '3986e2a7a97f248c2bb1f343fecdafe7', '2021-02-22 06:22:25', '2021-02-22 06:22:25', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `nid` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (1, 11, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  redis:\r\n    host: yt4j-redis\r\nmybatis-plus:\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\r\nyt4j:\r\n  jwt:\r\n    filter:\r\n      ignored-url:\r\n        - /doc.html\r\n        - /swagger-ui.html\r\n        - /swagger-resources/**\r\n        - /swagger/**\r\n        - /**/v2/api-docs\r\n        - /**/*.js\r\n        - /**/*.css\r\n        - /**/*.png\r\n        - /**/*.ico\r\n        - /webjars/springfox-swagger-ui/**\r\n        - /actuator/**\r\n        - /user/login\r\n      header: \'Access-Token\'\r\n      token-head: \'\'\r\n  swagger:\r\n    enabled: true\r\njasypt:\r\n  encryptor:\r\n    password: yt4j', '108c3a4aaa4073a7a2ac9b0600c85cb8', '2021-02-04 11:02:05', '2021-02-04 03:02:06', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (2, 12, 'yt4j-sys.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    username: root\r\n    password: ENC(J4sCVXaoXyijS3Vf6vCqng==) #root', 'd2f7e99bc8f01994262bb339196574d9', '2021-02-04 11:03:21', '2021-02-04 03:03:22', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (1, 13, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: yt4j-redis\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  jwt:\n    filter:\n      ignored-url:\n        - /doc.html\n        - /swagger-ui.html\n        - /swagger-resources/**\n        - /swagger/**\n        - /**/v2/api-docs\n        - /**/*.js\n        - /**/*.css\n        - /**/*.png\n        - /**/*.ico\n        - /webjars/springfox-swagger-ui/**\n        - /actuator/**\n        - /user/login\n      header: \'Access-Token\'\n      token-head: \'\'\n  swagger:\n    enabled: true\njasypt:\n  encryptor:\n    password: mbs', '4c9c71c5ade68e67762c8d96dd3bf259', '2021-02-09 09:53:43', '2021-02-09 01:53:43', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (1, 14, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: yt4j-redis\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  jwt:\n    filter:\n      ignored-url:\n        - /doc.html\n        - /swagger-ui.html\n        - /swagger-resources/**\n        - /swagger/**\n        - /**/v2/api-docs\n        - /**/*.js\n        - /**/*.css\n        - /**/*.png\n        - /**/*.ico\n        - /webjars/springfox-swagger-ui/**\n        - /actuator/**\n        - /sys/user/login\n      header: \'Access-Token\'\n      token-head: \'\'\n  swagger:\n    enabled: true\njasypt:\n  encryptor:\n    password: yt4j\n', '12e66fca181f060f1562d23c8ce06f4d', '2021-02-09 09:54:12', '2021-02-09 01:54:12', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 15, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  cloud:\r\n    gateway:\r\n      routes:\r\n      - id: yt4j-sys\r\n        uri: lb://yt4j-sys\r\n        predicates:\r\n        - Path=/sys/**\r\n        filters:\r\n        - StripPrefix=1', '4e6b85b93fdb1b08b5ab628c1184d619', '2021-02-09 14:21:37', '2021-02-09 06:21:38', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 16, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      globalcors:\n        add-to-simple-url-handler-mapping: true\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', 'cb28b670fe6e64d58984dc60acef2885', '2021-02-09 14:34:55', '2021-02-09 06:34:55', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 17, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      globalcors:\n        add-to-simple-url-handler-mapping: false\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', 'ec29b0f9e39101e9147f00d173830f79', '2021-02-09 14:52:20', '2021-02-09 06:52:20', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 18, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      globalcors:\n        add-to-simple-url-handler-mapping: true\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', 'cb28b670fe6e64d58984dc60acef2885', '2021-02-09 15:00:43', '2021-02-09 07:00:44', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 19, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      globalcors:\n        add-to-simple-url-handler-mapping: true\n        cors-configurations:\n          \'[/**]\': \n            # 允许携带认证信息\n            # 允许跨域的源(网站域名/ip)，设置*为全部\n            # 允许跨域请求里的head字段，设置*为全部\n            # 允许跨域的method， 默认为GET和OPTIONS，设置*为全部\n            # 跨域允许的有效期\n            allow-credentials: true\n            allowed-origins: \n            - \"*\"\n            allowed-headers: \"*\"\n            allowed-methods: \n            - OPTIONS\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', '52ef0dbcfac068e1493f2e488ed39273', '2021-02-09 15:02:42', '2021-02-09 07:02:43', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (3, 20, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      globalcors:\n        add-to-simple-url-handler-mapping: true\n        cors-configurations:\n          \'[/**]\': \n            allow-credentials: true\n            allowed-origins: \n            - \"*\"\n            allowed-headers: \"*\"\n            allowed-methods: \n            - OPTIONS\n            - GET\n            - POST\n            - PUT\n            - DELETE\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', '9eb00290dd138f2464f7c8131054acf6', '2021-02-09 15:04:33', '2021-02-09 07:04:33', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 21, 'yt4j-ding.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j-dingtalk?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    username: root\r\n    password: ENC(J4sCVXaoXyijS3Vf6vCqng==) #root\r\n  redis:\r\n    host: yt4j-redis\r\nmybatis-plus:\r\n  configuration:\r\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\r\njasypt:\r\n  encryptor:\r\n    password: yt4j', '3986e2a7a97f248c2bb1f343fecdafe7', '2021-02-22 14:22:24', '2021-02-22 06:22:25', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (3, 22, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      routes:\n      - id: yt4j-sys\n        uri: lb://yt4j-sys\n        predicates:\n        - Path=/sys/**\n        filters:\n        - StripPrefix=1', '67c2169e3bc827da32686f38bd4fc2aa', '2021-02-22 14:28:30', '2021-02-22 06:28:30', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 23, 'test.yml', 'test', '', '1111', 'b59c67bf196a4758191e42f76670ceba', '2021-02-22 15:19:44', '2021-02-22 07:19:44', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 24, 'yt4j-sys.yml', 'yt4j', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-02-22 15:20:14', '2021-02-22 07:20:15', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (24, 25, 'yt4j-sys.yml', 'yt4j', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-02-22 15:20:33', '2021-02-22 07:20:33', NULL, '0:0:0:0:0:0:0:1', 'U', '');
INSERT INTO `his_config_info` VALUES (23, 26, 'test.yml', 'test', '', '1111', 'b59c67bf196a4758191e42f76670ceba', '2021-02-23 14:26:10', '2021-02-23 06:26:10', NULL, '0:0:0:0:0:0:0:1', 'D', '');
INSERT INTO `his_config_info` VALUES (24, 27, 'yt4j-sys.yml', 'yt4j', '', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root', '71b0a283b138eb7c28c12e71c6ebc57b', '2021-02-23 14:26:12', '2021-02-23 06:26:13', NULL, '0:0:0:0:0:0:0:1', 'D', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
