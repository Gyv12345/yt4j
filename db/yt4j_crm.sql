/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.196
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 192.168.0.196:3306
 Source Schema         : yt4j_crm

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 15/08/2022 15:58:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crm_customer
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户名称',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
INSERT INTO `crm_customer` VALUES (1, '头始感者或号', '18111186700', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `crm_customer` VALUES (2, '头始感者或号', '18111186700', 1, NULL, NULL, NULL, NULL);
INSERT INTO `crm_customer` VALUES (3, '外选来技机', '18630256624', 1, '2022-08-06 11:19:19', 1, '2022-08-06 11:20:29', NULL);

SET FOREIGN_KEY_CHECKS = 1;
