SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_datasource
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource`;
CREATE TABLE `gen_datasource` (
  `id` bigint NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据源名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库连接',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库密码',
  `database_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库类型',
  `database_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='数据源表';

-- ----------------------------
-- Records of gen_datasource
-- ----------------------------
BEGIN;
INSERT INTO `gen_datasource` (`id`, `name`, `url`, `username`, `password`, `database_type`, `database_name`, `create_time`, `update_time`) VALUES (1650319063614193665, 'test', 'jdbc:mysql://192.168.0.123:3306/wk_crm_table?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowPublicKeyRetrieval=true', 'root', 'Admin001m', 'MYSQL', 'wk_crm_table', '2023-06-08 10:00:19', '2023-06-08 10:00:19');
COMMIT;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint NOT NULL COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `datasource_id` bigint DEFAULT NULL COMMENT '数据源ID',
  `datasource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据源名称',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint NOT NULL COMMENT '编号',
  `table_id` bigint DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '字典类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_type
-- ----------------------------
DROP TABLE IF EXISTS `gen_type`;
CREATE TABLE `gen_type` (
  `id` bigint NOT NULL COMMENT 'ID',
  `column_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字段类型',
  `attr_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性类型',
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性包名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_column_type` (`column_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字段类型管理';

-- ----------------------------
-- Records of gen_type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint NOT NULL COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配置名称',
  `key` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配置key',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配置值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门名称',
  `order_no` int DEFAULT NULL COMMENT '排序',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `department_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方部门ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` (`id`, `parent_id`, `name`, `order_no`, `status`, `department_id`, `create_time`, `update_time`) VALUES (1, 0, '总部', 1, NULL, NULL, '2020-08-19 16:24:53', NULL);
INSERT INTO `sys_dept` (`id`, `parent_id`, `name`, `order_no`, `status`, `department_id`, `create_time`, `update_time`) VALUES (2, 1, '洛阳分部', 2, NULL, NULL, '2020-08-19 16:25:15', '2020-08-19 16:26:25');
INSERT INTO `sys_dept` (`id`, `parent_id`, `name`, `order_no`, `status`, `department_id`, `create_time`, `update_time`) VALUES (4, 1, '郑州分部', 2, NULL, NULL, '2020-09-06 11:13:48', '2020-09-06 11:46:56');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_user`;
CREATE TABLE `sys_dept_user` (
  `id` bigint NOT NULL COMMENT 'ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门用户';

-- ----------------------------
-- Records of sys_dept_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL COMMENT 'id',
  `code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典关键字',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典名称',
  `state` int DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (1, 'data_scop', '数据权限', NULL, '2020-08-19 17:13:46', NULL);
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (2, 'system_active', '通用状态', NULL, '2020-08-20 09:14:10', NULL);
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (9, 'menu_level', '菜单级别', NULL, '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (10, 'data_scope_type', '角色权限等级', NULL, '2020-09-10 10:40:08', NULL);
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (11, 'test1234', '测试数据2', NULL, '2020-09-17 10:52:28', '2020-09-17 10:52:28');
INSERT INTO `sys_dict` (`id`, `code`, `name`, `state`, `create_time`, `update_time`) VALUES (12, 'test_data', '测试数据444', NULL, '2020-09-17 10:52:58', '2020-09-17 10:52:58');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典编码',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '值',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (1, 'data_scop', '本级及子集', '1', '2020-08-19 17:15:36', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (2, 'data_scop', '本级', '2', '2020-08-19 17:15:45', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (3, 'data_scop', '自己', '3', '2020-08-19 17:15:54', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (4, 'system_active', '有效', '1', '2020-08-20 09:14:31', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (5, 'system_active', '无效', '0', '2020-08-20 09:14:38', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (16, 'menu_level', '应用', '1', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (17, 'menu_level', '菜单', '2', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (18, 'menu_level', '按钮', '3', '2020-09-08 17:36:53', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (19, 'data_scope_type', '部门以及下属部门所有信息', '1', '2020-09-10 10:40:40', '2020-09-10 10:41:04');
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (20, 'data_scope_type', '本部门', '2', '2020-09-10 10:41:10', '2020-09-10 10:41:20');
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (21, 'data_scope_type', '本人', '3', '2020-09-10 10:41:29', '2020-09-10 10:41:32');
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (22, 'test_data2', '测试item2', '2', '2020-09-10 16:24:12', '2020-09-10 16:25:43');
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (23, 'test_data', 'item1', '1', '2020-09-10 16:26:15', NULL);
INSERT INTO `sys_dict_item` (`id`, `code`, `label`, `value`, `create_time`, `update_time`) VALUES (24, 'test_data', 'item2', '2', '2020-09-10 16:26:20', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `menu_type` tinyint NOT NULL COMMENT '类型 1系统 2菜单 3按钮',
  `parent_id` bigint NOT NULL COMMENT '父级ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路由标题',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '路由名称 不能重复',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求地址',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组件地址',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `roles` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  `auths` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限标识',
  `layer` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '层级',
  `hidden` tinyint DEFAULT NULL COMMENT '是否显示在左侧',
  `rank` int DEFAULT NULL COMMENT '排序',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重定向',
  `extra_icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧图标',
  `enter_transition` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '进场动画',
  `leave_transition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '离场动画',
  `frame_src` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '链接地址',
  `frame_loading` tinyint(1) DEFAULT NULL COMMENT '加载动画',
  `keep_alive` tinyint(1) DEFAULT NULL COMMENT '缓存页面',
  `hidden_tag` tinyint(1) DEFAULT NULL COMMENT '标签页',
  `show_link` tinyint(1) DEFAULT NULL COMMENT '菜单是否可见',
  `show_parent` tinyint(1) DEFAULT NULL COMMENT '父级菜单是否可见',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='资源权限';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (1, 1, 0, '基础系统', 'System', '/', 'RouteView', 'heat-map', NULL, 'sys_system', '[0]', 0, 1, '/dashboard/workplace', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-11 13:43:54', '2020-09-11 14:14:05');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (2, 1, 0, '仪表盘', 'dashboard', '', 'RouteView', NULL, NULL, 'dashboard', '[0]', 0, 1, '/dashboard/workplace', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-14 15:39:33', '2020-09-21 11:46:39');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (3, 2, 2, '工作台', 'workplace', NULL, 'Workplace', NULL, NULL, 'workplace', '[0],[2]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-14 15:42:57', '2020-09-16 09:18:29');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (4, 2, 2, '分析页', 'Analysis', 'dashboard/analysis', 'Analysis', NULL, NULL, 'Analysis', '[0],[2]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-14 15:44:55', '2020-09-16 22:32:07');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (5, 2, 2, '表格', 'table-list', '/list/table-list', 'TableList', NULL, NULL, 'table', '[0],[2]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-17 09:35:53', '2020-09-11 12:01:12');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (6, 2, 1, '用户管理', 'sys_user', '/sys-user/list', 'sys/user/index', 'copy', NULL, 'sys_user', '[0],[1]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-17 15:05:11', '2020-09-17 10:32:44');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (7, 2, 1, '菜单管理', 'sys_menu', '/sys-menu/list', 'sys/menu/index', 'file-add', NULL, 'sys_menu', '[0],[1]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-25 15:48:04', '2020-09-17 10:32:56');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (8, 2, 1, '角色管理', 'sys_role', '/sys-role/list', 'sys/role/index', 'user', NULL, 'sys_role', '[0],[1]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-25 15:56:50', '2020-09-17 10:33:08');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (9, 2, 1, '部门管理', 'sys_dept', '/sys-dept/list', 'sys/dept/index', 'table', NULL, 'sys_dept', '[0],[1]', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-25 15:58:22', '2020-09-17 10:33:23');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (10, 2, 1, '字典管理', 'sys_dict', '/sys-dict/list', 'sys/dict/index', 'project', NULL, 'sys_dict', '[0],[1]', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-08 23:11:43', '2020-09-17 10:33:37');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (11, 1, 0, '测试应用', 'test', 'ccc', 'TestView', NULL, NULL, 'test', '[0]', 1, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-10 08:52:56', '2020-09-17 08:57:14');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (12, 2, 11, '测试菜单一级1', 'test_01', 'aaa', 'RouteView', NULL, NULL, 'test_1', '[0],[11]', 1, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-10 08:55:55', '2022-09-20 10:04:51');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (13, 2, 12, '测试菜单二级', 'test_1_1', ' /bbb', 'list/TableList', 'fast-forward', NULL, 'test_2', '[0],[11],[12]', 1, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-10 09:00:57', '2022-09-20 10:04:55');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (14, 1, 13, '测试按钮', 'test_1_1_1', ' 3434', 'PageView', NULL, NULL, '434', '[0],[11],[12],[13]', 1, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-10 09:03:41', '2022-09-20 10:04:57');
INSERT INTO `sys_menu` (`id`, `menu_type`, `parent_id`, `title`, `name`, `path`, `component`, `icon`, `roles`, `auths`, `layer`, `hidden`, `rank`, `redirect`, `extra_icon`, `enter_transition`, `leave_transition`, `frame_src`, `frame_loading`, `keep_alive`, `hidden_tag`, `show_link`, `show_parent`, `create_time`, `update_time`) VALUES (15, 3, 13, '测试按钮2', 'test21', NULL, ' 12', NULL, NULL, '12', '[0],[11],[12],[13]', 1, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-10 09:13:02', '2022-09-20 10:05:01');
COMMIT;

-- ----------------------------
-- Table structure for sys_oss_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss_file`;
CREATE TABLE `sys_oss_file` (
  `id` bigint NOT NULL COMMENT '文件id',
  `url` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '文件访问地址',
  `size` bigint DEFAULT NULL COMMENT '文件大小，单位字节',
  `filename` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件名称',
  `original_filename` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '原始文件名',
  `base_path` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '基础存储路径',
  `path` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '存储路径',
  `ext` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件扩展名',
  `content_type` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT 'MIME类型',
  `platform` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '存储平台',
  `th_url` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '缩略图访问路径',
  `th_filename` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '缩略图名称',
  `th_size` bigint DEFAULT NULL COMMENT '缩略图大小，单位字节',
  `th_content_type` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '缩略图MIME类型',
  `object_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件所属对象id',
  `object_type` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件所属对象类型，例如用户头像，评价图片',
  `metadata` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '文件元数据',
  `user_metadata` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '文件用户元数据',
  `th_metadata` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '缩略图元数据',
  `th_user_metadata` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '缩略图用户元数据',
  `attr` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '附加属性',
  `file_acl` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件ACL',
  `th_file_acl` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '缩略图文件ACL',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='文件记录表';

-- ----------------------------
-- Records of sys_oss_file
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色标识',
  `level` smallint DEFAULT NULL COMMENT '角色权限等级 1部门及下属部门所有信息 2本部门 3本人',
  `state` smallint DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `name`, `code`, `level`, `state`, `create_time`, `update_time`) VALUES (1, '超级管理员', 'ROLE_ADMIN', 1, 1, '2020-08-11 13:43:20', '2020-09-10 10:48:45');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色权限';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 1);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 2);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 3);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 4);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 5);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 6);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 7);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 8);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 9);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 10);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 11);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 12);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 13);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `id_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `sex` tinyint DEFAULT NULL COMMENT '性别',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `leader_id` bigint DEFAULT NULL COMMENT '负责人ID',
  `open_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方应用iD',
  `state` smallint DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `sys_user_username_uindex` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1689244200010653698 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1, '超级管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '410303198911282511', 'https://s1.ax1x.com/2020/08/14/dCRXDg.jpg', 1, 'gyv12345@163.com', '15139960649', NULL, NULL, 1, '2020-08-11 13:42:53', '2024-03-15 14:57:59');
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689241945228320769, NULL, '777', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, 1, '1423', '123', NULL, NULL, 1, '2023-08-09 19:47:20', '2023-08-09 19:47:31');
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689244142674518017, NULL, '1', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', NULL, NULL, 1, '2023-08-09 19:56:03', NULL);
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689244154573758465, NULL, '2', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', NULL, NULL, 1, '2023-08-09 19:56:06', NULL);
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689244167186030593, NULL, '3', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', NULL, NULL, 1, '2023-08-09 19:56:09', NULL);
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689244178879750145, NULL, '4', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', NULL, NULL, 1, '2023-08-09 19:56:12', NULL);
INSERT INTO `sys_user` (`id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `leader_id`, `open_id`, `state`, `create_time`, `update_time`) VALUES (1689244200010653697, NULL, '5', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', NULL, NULL, 1, '2023-08-09 19:56:17', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (2, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (5, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (5, 3);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (6, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (6, 3);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (6, 4);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (9, 4);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (9, 3);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
