/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : yt4j

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 26/11/2020 11:49:51
*/
USE yt4j;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父级ID',
  `label` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门名称',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '排序',
  `state` tinyint(0) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
begin;
INSERT INTO `sys_dept` VALUES (1, 0, '总部', 1, NULL, '2020-08-19 16:24:53', NULL);
INSERT INTO `sys_dept` VALUES (2, 1, '洛阳分部', 2, NULL, '2020-08-19 16:25:15', '2020-08-19 16:26:25');
INSERT INTO `sys_dept` VALUES (4, 1, '郑州分部', 2, NULL, '2020-09-06 11:13:48', '2020-09-06 11:46:56');
commit ;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典关键字',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典名称',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
begin ;
INSERT INTO `sys_dict` VALUES (1, 'data_scop', '数据权限', NULL, '2020-08-19 17:13:46', NULL);
INSERT INTO `sys_dict` VALUES (2, 'system_active', '通用状态', NULL, '2020-08-20 09:14:10', NULL);
INSERT INTO `sys_dict` VALUES (9, 'menu_level', '菜单级别', NULL, '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict` VALUES (10, 'data_scope_type', '角色权限等级', NULL, '2020-09-10 10:40:08', NULL);
INSERT INTO `sys_dict` VALUES (11, 'test1234', '测试数据2', NULL, '2020-09-17 10:52:28', '2020-09-17 10:52:28');
INSERT INTO `sys_dict` VALUES (12, 'test_data', '测试数据444', NULL, '2020-09-17 10:52:58', '2020-09-17 10:52:58');
commit ;
-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典编码',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '值',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
begin ;
INSERT INTO `sys_dict_item` VALUES (1, 'data_scop', '本级及子集', '1', '2020-08-19 17:15:36', NULL);
INSERT INTO `sys_dict_item` VALUES (2, 'data_scop', '本级', '2', '2020-08-19 17:15:45', NULL);
INSERT INTO `sys_dict_item` VALUES (3, 'data_scop', '自己', '3', '2020-08-19 17:15:54', NULL);
INSERT INTO `sys_dict_item` VALUES (4, 'system_active', '有效', '1', '2020-08-20 09:14:31', NULL);
INSERT INTO `sys_dict_item` VALUES (5, 'system_active', '无效', '0', '2020-08-20 09:14:38', NULL);
INSERT INTO `sys_dict_item` VALUES (16, 'menu_level', '应用', '1', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` VALUES (17, 'menu_level', '菜单', '2', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` VALUES (18, 'menu_level', '按钮', '3', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` VALUES (19, 'data_scope_type', '部门以及下属部门所有信息', '1', '2020-09-10 10:40:40', '2020-09-10 10:41:04');
INSERT INTO `sys_dict_item` VALUES (20, 'data_scope_type', '本部门', '2', '2020-09-10 10:41:10', '2020-09-10 10:41:20');
INSERT INTO `sys_dict_item` VALUES (21, 'data_scope_type', '本人', '3', '2020-09-10 10:41:29', '2020-09-10 10:41:32');
INSERT INTO `sys_dict_item` VALUES (22, 'test_data2', '测试item2', '2', '2020-09-10 16:24:12', '2020-09-10 16:25:43');
INSERT INTO `sys_dict_item` VALUES (23, 'test_data', 'item1', '1', '2020-09-10 16:26:15', NULL);
INSERT INTO `sys_dict_item` VALUES (24, 'test_data', 'item2', '2', '2020-09-10 16:26:20', NULL);
commit ;
-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(0) NOT NULL COMMENT '类型 1系统 2菜单 3按钮',
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父级ID',
  `label` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '路由名称 不能重复',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由标题',
  `permission` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限标识',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标',
  `layer` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '层级',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '排序',
  `hidden` tinyint(0) NULL DEFAULT NULL COMMENT '是否显示在左侧',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '重定向',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求地址',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件地址',
  `keepalive` tinyint(0) NULL DEFAULT NULL COMMENT '保持不变',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '资源权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
begin ;
INSERT INTO `sys_menu` VALUES (1, 1, 0, 'System', '基础系统', 'sys_system', 'heat-map', '[0]', 1, 0, '/dashboard/workplace', '/', 'RouteView', 1, '2020-08-11 13:43:54', '2020-09-11 14:14:05');
INSERT INTO `sys_menu` VALUES (2, 1, 0, 'dashboard', '仪表盘', 'dashboard', NULL, '[0]', 1, 0, '/dashboard/workplace', '', 'RouteView', 1, '2020-08-14 15:39:33', '2020-09-21 11:46:39');
INSERT INTO `sys_menu` VALUES (3, 2, 2, 'workplace', '工作台', 'workplace', NULL, '[0],[2]', 1, 0, NULL, NULL, 'Workplace', 1, '2020-08-14 15:42:57', '2020-09-16 09:18:29');
INSERT INTO `sys_menu` VALUES (4, 2, 2, 'Analysis', '分析页', 'Analysis', NULL, '[0],[2]', 1, 0, NULL, 'dashboard/analysis', 'Analysis', 1, '2020-08-14 15:44:55', '2020-09-16 22:32:07');
INSERT INTO `sys_menu` VALUES (5, 2, 2, 'table-list', '表格', 'table', NULL, '[0],[2]', 1, 0, NULL, '/list/table-list', 'TableList', 1, '2020-08-17 09:35:53', '2020-09-11 12:01:12');
INSERT INTO `sys_menu` VALUES (6, 2, 1, 'sys_user', '用户管理', 'sys_user', 'copy', '[0],[1]', 1, 0, NULL, '/sys-user/list', 'sys/user/index', 1, '2020-08-17 15:05:11', '2020-09-17 10:32:44');
INSERT INTO `sys_menu` VALUES (7, 2, 1, 'sys_menu', '菜单管理', 'sys_menu', 'file-add', '[0],[1]', 1, 0, NULL, '/sys-menu/list', 'sys/menu/index', 1, '2020-08-25 15:48:04', '2020-09-17 10:32:56');
INSERT INTO `sys_menu` VALUES (8, 2, 1, 'sys_role', '角色管理', 'sys_role', 'user', '[0],[1]', 1, 0, NULL, '/sys-role/list', 'sys/role/index', 1, '2020-08-25 15:56:50', '2020-09-17 10:33:08');
INSERT INTO `sys_menu` VALUES (9, 2, 1, 'sys_dept', '部门管理', 'sys_dept', 'table', '[0],[1]', 1, 0, NULL, '/sys-dept/list', 'sys/dept/index', 1, '2020-08-25 15:58:22', '2020-09-17 10:33:23');
INSERT INTO `sys_menu` VALUES (10, 2, 1, 'sys_dict', '字典管理', 'sys_dict', 'project', '[0],[1]', 1, 1, NULL, '/sys-dict/list', 'sys/dict/index', NULL, '2020-09-08 23:11:43', '2020-09-17 10:33:37');
INSERT INTO `sys_menu` VALUES (11, 1, 0, 'test', '测试应用', 'test', NULL, '[0]', 100, 1, NULL, 'ccc', 'TestView', NULL, '2020-09-10 08:52:56', '2020-09-17 08:57:14');
INSERT INTO `sys_menu` VALUES (12, 2, 11, 'test_01', '测试菜单一级1', ' test_1', NULL, '[0],[11]', 100, 1, NULL, 'aaa', 'RouteView', NULL, '2020-09-10 08:55:55', '2020-09-16 22:32:22');
INSERT INTO `sys_menu` VALUES (13, 2, 12, 'test_1_1', '测试菜单二级', ' test_2', 'fast-forward', '[0],[11],[12]', 100, 1, NULL, ' /bbb', 'list/TableList', NULL, '2020-09-10 09:00:57', '2020-09-17 09:04:05');
INSERT INTO `sys_menu` VALUES (14, 1, 13, 'test_1_1_1', '测试按钮', ' 434', NULL, '[0],[11],[12],[13]', 100, 1, NULL, ' 3434', 'PageView', NULL, '2020-09-10 09:03:41', '2020-09-11 11:51:29');
INSERT INTO `sys_menu` VALUES (15, 3, 13, 'test21', '测试按钮2', '  12', NULL, '[0],[11],[12],[13]', 100, 1, NULL, NULL, ' 12', NULL, '2020-09-10 09:13:02', '2020-09-11 11:51:32');
commit ;
-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色标识',
  `level` smallint(0) NULL DEFAULT NULL COMMENT '角色权限等级 1部门及下属部门所有信息 2本部门 3本人',
  `state` smallint(0) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
begin ;
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROLE_ADMIN', 1, 1, '2020-08-11 13:43:20', '2020-09-10 10:48:45');
commit ;
-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(0) NULL DEFAULT NULL COMMENT '权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
begin ;
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
commit ;
-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门ID',
  `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `id_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` tinyint(0) NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `state` smallint(0) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
begin ;
INSERT INTO `sys_user` VALUES (1, 1, '超级管理员', 'admin', '$2a$10$ctfu9KkAOkfR9vNcl41PSOKu6LP0d03pvQmARBhmUNPLBtdkKzK3S', '410303198911282511', 'https://s1.ax1x.com/2020/08/14/dCRXDg.jpg', 1, 'gyv12345@163.com', '15139960649', 1, '2020-08-11 13:42:53', '2020-08-19 16:15:01');
commit ;
-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(0) NOT NULL,
  `role_id` bigint(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
begin ;
INSERT INTO `sys_user_role` VALUES (2, 1);
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (5, 1);
INSERT INTO `sys_user_role` VALUES (5, 3);
INSERT INTO `sys_user_role` VALUES (6, 1);
INSERT INTO `sys_user_role` VALUES (6, 3);
INSERT INTO `sys_user_role` VALUES (6, 4);
INSERT INTO `sys_user_role` VALUES (9, 4);
INSERT INTO `sys_user_role` VALUES (9, 3);
commit ;

SET FOREIGN_KEY_CHECKS = 1;
