SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'group_id',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'configuration description',
  `c_use` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'configuration usage',
  `effect` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT '配置生效的描述',
  `type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT '配置的类型',
  `c_schema` text COLLATE utf8mb3_bin COMMENT '配置的模式',
  `encrypted_data_key` text COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
BEGIN;
INSERT INTO `config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`, `encrypted_data_key`) VALUES (1, 'application.yml', 'DEFAULT_GROUP', 'spring:\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n  boot:\n    admin:\n      client:\n        url: http://yt4j-admin:8891/admin\nmybatis-plus:\n  global-config:\n    dbConfig:\n      # 主键类型\n      # AUTO 自增 NONE 空 INPUT 用户输入 ASSIGN_ID 雪花 ASSIGN_UUID 唯一 UUID\n      # 如需改为自增 需要将数据库表全部设置为自增\n      idType: ASSIGN_ID\nyt4j:\n  swagger:\n    enabled: true\n    info:\n      title: ${spring.application.name}文档\n      version: 1.0\n      description: \'使用Knife4j返回Open-Api文档\'\n  sa:\n    ignoredUrl:\n      - /user/login\n      - /auth/login\n      - /swagger-ui.html\n      - /swagger-resources/**\n      - /swagger/**\n      - /**/v3/api-docs\n      - /**/*.js\n      - /**/*.css\n      - /**/*.png\n      - /**/*.ico\n      - /webjars/springfox-swagger-ui/**\n      - /actuator/**\n      - /doc.html\n      - /v3/**\n      - /v3/api-docs/swagger-config\njasypt:\n  encryptor:\n    password: yt4j\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: ALWAYS\n    logfile:\n      external-file: ./logs/${spring.application.name}/console.log\n# Sa-Token配置\nsa-token:\n  # token名称 (同时也是cookie名称)\n  token-name: Authorization\n  # token有效期 设为一天 (必定过期) 单位: 秒\n  timeout: 86400\n  # token临时有效期 (指定时间无操作就过期) 单位: 秒\n  activity-timeout: 1800\n  # 开启内网服务调用鉴权\n  check-same-token: true\n  # Id-Token的有效期 (单位: 秒)\n  id-token-timeout: 600\n  # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)\n  is-concurrent: true\n  # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)\n  is-share: false\n  # 是否尝试从header里读取token\n  is-read-head: true\n  # 是否尝试从cookie里读取token\n  is-read-cookie: false\n  # token前缀\n  token-prefix: \"Bearer\"\n  # 是否输出操作日志\n  is-log: true\n--- #\nspring:\n  data:\n    redis:\n      host: yt4j-redis\n      password: 123456\n# plumelog 集中式日志 链路追踪\nplumelog:\n  appName: ${spring.application.name}\n  redisHost: ${spring.data.redis.host}\n  redisAuth: ${spring.data.redis.password}\n  redisDb: 0\n--- # 动态线程池 本质上动态线程池最好还是放到各个子模块里，这样可以方便的对不同模块应用进行不同的操作\nspring:\n  dynamic:\n    tp:\n      enabled: true\n      enabledCollect: true                   # 是否开启监控指标采集，默认false\n      collectorTypes: micrometer,logging     # 监控数据采集器类型（logging | micrometer | internal_logging），默认micrometer\n      logPath: ${user.home}/logs                   # 监控日志数据路径，默认 ${user.home}/logs，采集类型非logging不用配置\n      monitorInterval: 5                     # 监控时间间隔（报警检测、指标采集），默认5s\n      platforms:                              # 通知报警平台配置                # 接受人飞书名称/openid\n        - platform: email\n          platformId: 4\n          receivers: gyv12345@163.com   # 收件人\n      executors:                                   # 动态线程池配置，都有默认值，采用默认值的可以不配置该项，减少配置量\n        - threadPoolName: dtpExecutor1\n          threadPoolAliasName: 测试线程池            # 线程池别名\n          executorType: common                     # 线程池类型common、eager：适用于io密集型\n          corePoolSize: 6\n          maximumPoolSize: 8\n          queueCapacity: 200\n          queueType: VariableLinkedBlockingQueue   # 任务队列，查看源码QueueTypeEnum枚举类\n          rejectedHandlerType: CallerRunsPolicy    # 拒绝策略，查看RejectedTypeEnum枚举类\n          keepAliveTime: 50\n          allowCoreThreadTimeOut: false                  # 是否允许核心线程池超时\n          threadNamePrefix: test                         # 线程名前缀\n          waitForTasksToCompleteOnShutdown: false        # 参考spring线程池设计，优雅关闭线程池\n          awaitTerminationSeconds: 5                     # 单位（s）\n          preStartAllCoreThreads: false                  # 是否预热所有核心线程，默认false\n          runTimeout: 200                                # 任务执行超时阈值，目前只做告警用，单位（ms）\n          queueTimeout: 100                              # 任务在队列等待超时阈值，目前只做告警用，单位（ms）\n          taskWrapperNames: [\"ttl\", \"mdc\"]               # 任务包装器名称，继承TaskWrapper接口\n          notifyEnabled: true                            # 是否开启报警，默认true\n          notifyItems:                     # 报警项，不配置自动会按默认值配置（变更通知、容量报警、活性报警、拒绝报警、任务超时报警）\n            - type: capacity               # 报警项类型，查看源码 NotifyTypeEnum枚举类\n              enabled: true\n              threshold: 80                # 报警阈值\n              platforms: [ding,wechat]     # 可选配置，不配置默认拿上层platforms配置的所以平台\n              interval: 120                # 报警间隔（单位：s）\n            - type: liveness\n              enabled: true\n              threshold: 80\n            - type: reject\n              enabled: true\n              threshold: 1\n            - type: run_timeout\n              enabled: true\n              threshold: 1\n            - type: queue_timeout\n              enabled: true\n              threshold: 1\n', '8e43b8657426cfe62a06d08c322e5433', '2024-03-02 16:06:07', '2024-03-28 22:55:58', 'nacos', '192.168.31.196', '', '', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`, `encrypted_data_key`) VALUES (3, 'yt4j-gateway.yml', 'DEFAULT_GROUP', 'spring:\n  cloud:\n    gateway:\n      routes:\n        - id: yt4j-sys-svc\n          uri: lb://yt4j-sys-svc\n          predicates:\n            - Path=/sys/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-auth\n          uri: lb://yt4j-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-crm\n          uri: lb://yt4j-crm\n          predicates:\n            - Path=/crm/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-generate\n          uri: lb://yt4j-generate\n          predicates:\n            - Path=/gen/**\n          filters:\n            - StripPrefix=1\n--- # 聚合文档\nknife4j:\n  gateway:\n    # 开区网关聚合文档 默认:/\n    enabled: true\n    # 网关前缀(如nginx配置的代理前缀) 默认:/\n    api-path-prefix: /\n    # 使用的UI版本(v2或者v3) 默认: v3\n    version: v3\n    # 服务发现\n    discover:\n      # 开启服务发现 默认:true\n      enabled: true\n      # 默认排序 默认:0\n      default-order: 0\n      # 排除的服务名 默认:为空(建议排除网关服务)\n      excluded-services: gateway\n    v3:\n      # 文档访问地址 默认:/v3/api-docs\n      api-docs-path: \'/v3/api-docs\'\n      # oauth2 redirect url\n      oauth2-redirect-url: \'\'\n      # validator url\n      validator-url: \'\'\n    routes:\n      # 分组名称\n      - name: 系统服务\n        # 文档地址\n        url: \'/sys/v3/api-docs\'\n        # context-path\n        context-path: \'/sys\'\n        # 服务名\n        service-name: sys\n        # 排序\n        order: 0\n      - name: 鉴权服务\n        # 文档地址\n        url: \'/auth/v3/api-docs\'\n        # context-path\n        context-path: \'/auth\'\n        # 服务名\n        service-name: auth\n        # 排序\n        order: 1\n      - name: 代码生成服务\n        # 文档地址\n        url: \'/gen/v3/api-docs\'\n        # context-path\n        context-path: \'/gen\'\n        # 服务名\n        service-name: gen\n        # 排序\n        order: 2\n', '4ee783fe27ff54381b3abcda9b306e9f', '2024-03-02 16:06:48', '2024-03-02 16:25:45', 'nacos', '192.168.31.195', '', '', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` (`id`, `data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`, `encrypted_data_key`) VALUES (4, 'yt4j-sys-svc.yml', 'DEFAULT_GROUP', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root\n', 'd5802d98d932056abd23daa97310c264', '2024-03-02 16:24:46', '2024-03-02 16:24:46', 'nacos', '192.168.31.195', '', '', NULL, NULL, NULL, 'yaml', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='增加租户字段';

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_beta';

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_tag';

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation` (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT COMMENT 'nid, 自增长标识',
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_tag_relation';

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------
BEGIN;
COMMIT;

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
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='集群、各Group容量信息表';

-- ----------------------------
-- Records of group_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info` (
  `id` bigint unsigned NOT NULL COMMENT 'id',
  `nid` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'nid, 自增标识',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `op_type` char(10) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'operation type',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='多租户改造';

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
BEGIN;
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (0, 1, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n  boot:\n    admin:\n      client:\n        url: http://yt4j-admin:8891/admin\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  swagger:\n    enabled: true\n    info:\n      title: ${spring.application.name}文档\n      version: 1.0\n      description: \'使用Knife4j返回Open-Api文档\'\n  sa:\n    ignoredUrl:\n      - /user/login\n      - /auth/login\n      - /swagger-ui.html\n      - /swagger-resources/**\n      - /swagger/**\n      - /**/v3/api-docs\n      - /**/*.js\n      - /**/*.css\n      - /**/*.png\n      - /**/*.ico\n      - /webjars/springfox-swagger-ui/**\n      - /actuator/**\n      - /doc.html\n      - /v3/**\n      - /v3/api-docs/swagger-config\njasypt:\n  encryptor:\n    password: yt4j\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: ALWAYS\n    logfile:\n      external-file: ./logs/${spring.application.name}/console.log\n# Sa-Token配置\nsa-token:\n  # token名称 (同时也是cookie名称)\n  token-name: Authorization\n  # token有效期 设为一天 (必定过期) 单位: 秒\n  timeout: 86400\n  # token临时有效期 (指定时间无操作就过期) 单位: 秒\n  activity-timeout: 1800\n  # 开启内网服务调用鉴权\n  check-same-token: true\n  # Id-Token的有效期 (单位: 秒)\n  id-token-timeout: 600\n  # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)\n  is-concurrent: true\n  # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)\n  is-share: false\n  # 是否尝试从header里读取token\n  is-read-head: true\n  # 是否尝试从cookie里读取token\n  is-read-cookie: false\n  # token前缀\n  token-prefix: \"Bearer\"\n  # 是否输出操作日志\n  is-log: true\n--- #\nspring:\n  data:\n    redis:\n      host: yt4j-redis\n      password: 123456\n# plumelog 集中式日志 链路追踪\nplumelog:\n  appName: ${spring.application.name}\n  redisHost: ${spring.data.redis.host}\n  redisAuth: ${spring.data.redis.password}\n  redisDb: 0\n--- # 动态线程池 本质上动态线程池最好还是放到各个子模块里，这样可以方便的对不同模块应用进行不同的操作\nspring:\n  dynamic:\n    tp:\n      enabled: true\n      enabledCollect: true                   # 是否开启监控指标采集，默认false\n      collectorTypes: micrometer,logging     # 监控数据采集器类型（logging | micrometer | internal_logging），默认micrometer\n      logPath: ${user.home}/logs                   # 监控日志数据路径，默认 ${user.home}/logs，采集类型非logging不用配置\n      monitorInterval: 5                     # 监控时间间隔（报警检测、指标采集），默认5s\n      platforms:                              # 通知报警平台配置                # 接受人飞书名称/openid\n        - platform: email\n          platformId: 4\n          receivers: gyv12345@163.com   # 收件人\n      executors:                                   # 动态线程池配置，都有默认值，采用默认值的可以不配置该项，减少配置量\n        - threadPoolName: dtpExecutor1\n          threadPoolAliasName: 测试线程池            # 线程池别名\n          executorType: common                     # 线程池类型common、eager：适用于io密集型\n          corePoolSize: 6\n          maximumPoolSize: 8\n          queueCapacity: 200\n          queueType: VariableLinkedBlockingQueue   # 任务队列，查看源码QueueTypeEnum枚举类\n          rejectedHandlerType: CallerRunsPolicy    # 拒绝策略，查看RejectedTypeEnum枚举类\n          keepAliveTime: 50\n          allowCoreThreadTimeOut: false                  # 是否允许核心线程池超时\n          threadNamePrefix: test                         # 线程名前缀\n          waitForTasksToCompleteOnShutdown: false        # 参考spring线程池设计，优雅关闭线程池\n          awaitTerminationSeconds: 5                     # 单位（s）\n          preStartAllCoreThreads: false                  # 是否预热所有核心线程，默认false\n          runTimeout: 200                                # 任务执行超时阈值，目前只做告警用，单位（ms）\n          queueTimeout: 100                              # 任务在队列等待超时阈值，目前只做告警用，单位（ms）\n          taskWrapperNames: [\"ttl\", \"mdc\"]               # 任务包装器名称，继承TaskWrapper接口\n          notifyEnabled: true                            # 是否开启报警，默认true\n          notifyItems:                     # 报警项，不配置自动会按默认值配置（变更通知、容量报警、活性报警、拒绝报警、任务超时报警）\n            - type: capacity               # 报警项类型，查看源码 NotifyTypeEnum枚举类\n              enabled: true\n              threshold: 80                # 报警阈值\n              platforms: [ding,wechat]     # 可选配置，不配置默认拿上层platforms配置的所以平台\n              interval: 120                # 报警间隔（单位：s）\n            - type: liveness\n              enabled: true\n              threshold: 80\n            - type: reject\n              enabled: true\n              threshold: 1\n            - type: run_timeout\n              enabled: true\n              threshold: 1\n            - type: queue_timeout\n              enabled: true\n              threshold: 1\n', '95222f0f4f56e0e78cf6a5607682890d', '2024-03-02 16:06:07', '2024-03-02 16:06:07', 'nacos', '192.168.31.195', 'I', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (0, 2, 'yt4j-sys.yml', 'DEFAULT_GROUP', '', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root\n', 'd5802d98d932056abd23daa97310c264', '2024-03-02 16:06:28', '2024-03-02 16:06:29', 'nacos', '192.168.31.195', 'I', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (0, 3, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      routes:\n        - id: yt4j-sys\n          uri: lb://yt4j-sys\n          predicates:\n            - Path=/sys/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-auth\n          uri: lb://yt4j-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-crm\n          uri: lb://yt4j-crm\n          predicates:\n            - Path=/crm/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-generate\n          uri: lb://yt4j-generate\n          predicates:\n            - Path=/gen/**\n          filters:\n            - StripPrefix=1\n--- # 聚合文档\nknife4j:\n  gateway:\n    # 开区网关聚合文档 默认:/\n    enabled: true\n    # 网关前缀(如nginx配置的代理前缀) 默认:/\n    api-path-prefix: /\n    # 使用的UI版本(v2或者v3) 默认: v3\n    version: v3\n    # 服务发现\n    discover:\n      # 开启服务发现 默认:true\n      enabled: true\n      # 默认排序 默认:0\n      default-order: 0\n      # 排除的服务名 默认:为空(建议排除网关服务)\n      excluded-services: gateway\n    v3:\n      # 文档访问地址 默认:/v3/api-docs\n      api-docs-path: \'/v3/api-docs\'\n      # oauth2 redirect url\n      oauth2-redirect-url: \'\'\n      # validator url\n      validator-url: \'\'\n    routes:\n      # 分组名称\n      - name: 系统服务\n        # 文档地址\n        url: \'/sys/v3/api-docs\'\n        # context-path\n        context-path: \'/sys\'\n        # 服务名\n        service-name: sys\n        # 排序\n        order: 0\n      - name: 鉴权服务\n        # 文档地址\n        url: \'/auth/v3/api-docs\'\n        # context-path\n        context-path: \'/auth\'\n        # 服务名\n        service-name: auth\n        # 排序\n        order: 1\n      - name: 代码生成服务\n        # 文档地址\n        url: \'/gen/v3/api-docs\'\n        # context-path\n        context-path: \'/gen\'\n        # 服务名\n        service-name: gen\n        # 排序\n        order: 2\n', '211f4b9ce1d8fb05a4dfcb829e16c0d5', '2024-03-02 16:06:47', '2024-03-02 16:06:48', 'nacos', '192.168.31.195', 'I', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (0, 4, 'yt4j-sys-svc.yml', 'DEFAULT_GROUP', '', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root\n', 'd5802d98d932056abd23daa97310c264', '2024-03-02 16:24:46', '2024-03-02 16:24:46', 'nacos', '192.168.31.195', 'I', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (2, 5, 'yt4j-sys.yml', 'DEFAULT_GROUP', '', 'spring:\n  datasource:\n    url: jdbc:mysql://yt4j-mysql:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: root\n', 'd5802d98d932056abd23daa97310c264', '2024-03-02 16:24:50', '2024-03-02 16:24:51', 'nacos', '192.168.31.195', 'D', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (3, 6, 'yt4j-gateway.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:\n    gateway:\n      routes:\n        - id: yt4j-sys\n          uri: lb://yt4j-sys\n          predicates:\n            - Path=/sys/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-auth\n          uri: lb://yt4j-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-crm\n          uri: lb://yt4j-crm\n          predicates:\n            - Path=/crm/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-generate\n          uri: lb://yt4j-generate\n          predicates:\n            - Path=/gen/**\n          filters:\n            - StripPrefix=1\n--- # 聚合文档\nknife4j:\n  gateway:\n    # 开区网关聚合文档 默认:/\n    enabled: true\n    # 网关前缀(如nginx配置的代理前缀) 默认:/\n    api-path-prefix: /\n    # 使用的UI版本(v2或者v3) 默认: v3\n    version: v3\n    # 服务发现\n    discover:\n      # 开启服务发现 默认:true\n      enabled: true\n      # 默认排序 默认:0\n      default-order: 0\n      # 排除的服务名 默认:为空(建议排除网关服务)\n      excluded-services: gateway\n    v3:\n      # 文档访问地址 默认:/v3/api-docs\n      api-docs-path: \'/v3/api-docs\'\n      # oauth2 redirect url\n      oauth2-redirect-url: \'\'\n      # validator url\n      validator-url: \'\'\n    routes:\n      # 分组名称\n      - name: 系统服务\n        # 文档地址\n        url: \'/sys/v3/api-docs\'\n        # context-path\n        context-path: \'/sys\'\n        # 服务名\n        service-name: sys\n        # 排序\n        order: 0\n      - name: 鉴权服务\n        # 文档地址\n        url: \'/auth/v3/api-docs\'\n        # context-path\n        context-path: \'/auth\'\n        # 服务名\n        service-name: auth\n        # 排序\n        order: 1\n      - name: 代码生成服务\n        # 文档地址\n        url: \'/gen/v3/api-docs\'\n        # context-path\n        context-path: \'/gen\'\n        # 服务名\n        service-name: gen\n        # 排序\n        order: 2\n', '211f4b9ce1d8fb05a4dfcb829e16c0d5', '2024-03-02 16:25:45', '2024-03-02 16:25:45', 'nacos', '192.168.31.195', 'U', '', '');
INSERT INTO `his_config_info` (`id`, `nid`, `data_id`, `group_id`, `app_name`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `op_type`, `tenant_id`, `encrypted_data_key`) VALUES (1, 7, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n  boot:\n    admin:\n      client:\n        url: http://yt4j-admin:8891/admin\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  swagger:\n    enabled: true\n    info:\n      title: ${spring.application.name}文档\n      version: 1.0\n      description: \'使用Knife4j返回Open-Api文档\'\n  sa:\n    ignoredUrl:\n      - /user/login\n      - /auth/login\n      - /swagger-ui.html\n      - /swagger-resources/**\n      - /swagger/**\n      - /**/v3/api-docs\n      - /**/*.js\n      - /**/*.css\n      - /**/*.png\n      - /**/*.ico\n      - /webjars/springfox-swagger-ui/**\n      - /actuator/**\n      - /doc.html\n      - /v3/**\n      - /v3/api-docs/swagger-config\njasypt:\n  encryptor:\n    password: yt4j\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: ALWAYS\n    logfile:\n      external-file: ./logs/${spring.application.name}/console.log\n# Sa-Token配置\nsa-token:\n  # token名称 (同时也是cookie名称)\n  token-name: Authorization\n  # token有效期 设为一天 (必定过期) 单位: 秒\n  timeout: 86400\n  # token临时有效期 (指定时间无操作就过期) 单位: 秒\n  activity-timeout: 1800\n  # 开启内网服务调用鉴权\n  check-same-token: true\n  # Id-Token的有效期 (单位: 秒)\n  id-token-timeout: 600\n  # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)\n  is-concurrent: true\n  # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)\n  is-share: false\n  # 是否尝试从header里读取token\n  is-read-head: true\n  # 是否尝试从cookie里读取token\n  is-read-cookie: false\n  # token前缀\n  token-prefix: \"Bearer\"\n  # 是否输出操作日志\n  is-log: true\n--- #\nspring:\n  data:\n    redis:\n      host: yt4j-redis\n      password: 123456\n# plumelog 集中式日志 链路追踪\nplumelog:\n  appName: ${spring.application.name}\n  redisHost: ${spring.data.redis.host}\n  redisAuth: ${spring.data.redis.password}\n  redisDb: 0\n--- # 动态线程池 本质上动态线程池最好还是放到各个子模块里，这样可以方便的对不同模块应用进行不同的操作\nspring:\n  dynamic:\n    tp:\n      enabled: true\n      enabledCollect: true                   # 是否开启监控指标采集，默认false\n      collectorTypes: micrometer,logging     # 监控数据采集器类型（logging | micrometer | internal_logging），默认micrometer\n      logPath: ${user.home}/logs                   # 监控日志数据路径，默认 ${user.home}/logs，采集类型非logging不用配置\n      monitorInterval: 5                     # 监控时间间隔（报警检测、指标采集），默认5s\n      platforms:                              # 通知报警平台配置                # 接受人飞书名称/openid\n        - platform: email\n          platformId: 4\n          receivers: gyv12345@163.com   # 收件人\n      executors:                                   # 动态线程池配置，都有默认值，采用默认值的可以不配置该项，减少配置量\n        - threadPoolName: dtpExecutor1\n          threadPoolAliasName: 测试线程池            # 线程池别名\n          executorType: common                     # 线程池类型common、eager：适用于io密集型\n          corePoolSize: 6\n          maximumPoolSize: 8\n          queueCapacity: 200\n          queueType: VariableLinkedBlockingQueue   # 任务队列，查看源码QueueTypeEnum枚举类\n          rejectedHandlerType: CallerRunsPolicy    # 拒绝策略，查看RejectedTypeEnum枚举类\n          keepAliveTime: 50\n          allowCoreThreadTimeOut: false                  # 是否允许核心线程池超时\n          threadNamePrefix: test                         # 线程名前缀\n          waitForTasksToCompleteOnShutdown: false        # 参考spring线程池设计，优雅关闭线程池\n          awaitTerminationSeconds: 5                     # 单位（s）\n          preStartAllCoreThreads: false                  # 是否预热所有核心线程，默认false\n          runTimeout: 200                                # 任务执行超时阈值，目前只做告警用，单位（ms）\n          queueTimeout: 100                              # 任务在队列等待超时阈值，目前只做告警用，单位（ms）\n          taskWrapperNames: [\"ttl\", \"mdc\"]               # 任务包装器名称，继承TaskWrapper接口\n          notifyEnabled: true                            # 是否开启报警，默认true\n          notifyItems:                     # 报警项，不配置自动会按默认值配置（变更通知、容量报警、活性报警、拒绝报警、任务超时报警）\n            - type: capacity               # 报警项类型，查看源码 NotifyTypeEnum枚举类\n              enabled: true\n              threshold: 80                # 报警阈值\n              platforms: [ding,wechat]     # 可选配置，不配置默认拿上层platforms配置的所以平台\n              interval: 120                # 报警间隔（单位：s）\n            - type: liveness\n              enabled: true\n              threshold: 80\n            - type: reject\n              enabled: true\n              threshold: 1\n            - type: run_timeout\n              enabled: true\n              threshold: 1\n            - type: queue_timeout\n              enabled: true\n              threshold: 1\n', '95222f0f4f56e0e78cf6a5607682890d', '2024-03-28 22:55:58', '2024-03-28 22:55:58', 'nacos', '192.168.31.196', 'U', '', '');
COMMIT;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'role',
  `resource` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'resource',
  `action` varchar(8) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'action',
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of permissions
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'username',
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'role',
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN;
INSERT INTO `roles` (`username`, `role`) VALUES ('nacos', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `label` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门名称',
  `order_no` int DEFAULT NULL COMMENT '排序',
  `state` tinyint DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` (`id`, `parent_id`, `label`, `order_no`, `state`, `create_time`, `update_time`) VALUES (1, 0, '总部', 1, NULL, '2020-08-19 16:24:53', NULL);
INSERT INTO `sys_dept` (`id`, `parent_id`, `label`, `order_no`, `state`, `create_time`, `update_time`) VALUES (2, 1, '洛阳分部', 2, NULL, '2020-08-19 16:25:15', '2020-08-19 16:26:25');
INSERT INTO `sys_dept` (`id`, `parent_id`, `label`, `order_no`, `state`, `create_time`, `update_time`) VALUES (4, 1, '郑州分部', 2, NULL, '2020-09-06 11:13:48', '2020-09-06 11:46:56');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典关键字',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典名称',
  `state` int DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='字典';

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
  `type` tinyint NOT NULL COMMENT '类型 1系统 2菜单 3按钮',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `label` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '路由名称 不能重复',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路由标题',
  `permission` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限标识',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `layer` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '层级',
  `order_no` int DEFAULT NULL COMMENT '排序',
  `hidden` tinyint DEFAULT NULL COMMENT '是否显示在左侧',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重定向',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求地址',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组件地址',
  `keepalive` tinyint DEFAULT NULL COMMENT '保持不变',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='资源权限';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (1, 1, 0, 'System', '基础系统', 'sys_system', 'heat-map', '[0]', 1, 0, '/dashboard/workplace', '/', 'RouteView', 1, '2020-08-11 13:43:54', '2020-09-11 14:14:05');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (2, 1, 0, 'dashboard', '仪表盘', 'dashboard', NULL, '[0]', 1, 0, '/dashboard/workplace', '', 'RouteView', 1, '2020-08-14 15:39:33', '2020-09-21 11:46:39');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (3, 2, 2, 'workplace', '工作台', 'workplace', NULL, '[0],[2]', 1, 0, NULL, NULL, 'Workplace', 1, '2020-08-14 15:42:57', '2020-09-16 09:18:29');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (4, 2, 2, 'Analysis', '分析页', 'Analysis', NULL, '[0],[2]', 1, 0, NULL, 'dashboard/analysis', 'Analysis', 1, '2020-08-14 15:44:55', '2020-09-16 22:32:07');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (5, 2, 2, 'table-list', '表格', 'table', NULL, '[0],[2]', 1, 0, NULL, '/list/table-list', 'TableList', 1, '2020-08-17 09:35:53', '2020-09-11 12:01:12');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (6, 2, 1, 'sys_user', '用户管理', 'sys_user', 'copy', '[0],[1]', 1, 0, NULL, '/sys-user/list', 'sys/user/index', 1, '2020-08-17 15:05:11', '2020-09-17 10:32:44');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (7, 2, 1, 'sys_menu', '菜单管理', 'sys_menu', 'file-add', '[0],[1]', 1, 0, NULL, '/sys-menu/list', 'sys/menu/index', 1, '2020-08-25 15:48:04', '2020-09-17 10:32:56');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (8, 2, 1, 'sys_role', '角色管理', 'sys_role', 'user', '[0],[1]', 1, 0, NULL, '/sys-role/list', 'sys/role/index', 1, '2020-08-25 15:56:50', '2020-09-17 10:33:08');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (9, 2, 1, 'sys_dept', '部门管理', 'sys_dept', 'table', '[0],[1]', 1, 0, NULL, '/sys-dept/list', 'sys/dept/index', 1, '2020-08-25 15:58:22', '2020-09-17 10:33:23');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (10, 2, 1, 'sys_dict', '字典管理', 'sys_dict', 'project', '[0],[1]', 1, 1, NULL, '/sys-dict/list', 'sys/dict/index', NULL, '2020-09-08 23:11:43', '2020-09-17 10:33:37');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (11, 1, 0, 'test', '测试应用', 'test', NULL, '[0]', 100, 1, NULL, 'ccc', 'TestView', NULL, '2020-09-10 08:52:56', '2020-09-17 08:57:14');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (12, 2, 11, 'test_01', '测试菜单一级1', 'test_1', NULL, '[0],[11]', 100, 1, NULL, 'aaa', 'RouteView', NULL, '2020-09-10 08:55:55', '2022-09-20 10:04:51');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (13, 2, 12, 'test_1_1', '测试菜单二级', 'test_2', 'fast-forward', '[0],[11],[12]', 100, 1, NULL, ' /bbb', 'list/TableList', NULL, '2020-09-10 09:00:57', '2022-09-20 10:04:55');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (14, 1, 13, 'test_1_1_1', '测试按钮', '434', NULL, '[0],[11],[12],[13]', 100, 1, NULL, ' 3434', 'PageView', NULL, '2020-09-10 09:03:41', '2022-09-20 10:04:57');
INSERT INTO `sys_menu` (`id`, `type`, `parent_id`, `label`, `title`, `permission`, `icon`, `layer`, `order_no`, `hidden`, `redirect`, `path`, `component`, `keepalive`, `create_time`, `update_time`) VALUES (15, 3, 13, 'test21', '测试按钮2', '12', NULL, '[0],[11],[12],[13]', 100, 1, NULL, NULL, ' 12', NULL, '2020-09-10 09:13:02', '2022-09-20 10:05:01');
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
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `id_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `sex` tinyint DEFAULT NULL COMMENT '性别',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
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
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1, 1, '超级管理员', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', '410303198911282511', 'https://s1.ax1x.com/2020/08/14/dCRXDg.jpg', 1, 'gyv12345@163.com', '15139960649', 1, '2020-08-11 13:42:53', '2023-08-09 19:39:02');
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689241945228320769, NULL, NULL, '777', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, 1, '1423', '123', 1, '2023-08-09 19:47:20', '2023-08-09 19:47:31');
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689244142674518017, NULL, NULL, '1', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', 1, '2023-08-09 19:56:03', NULL);
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689244154573758465, NULL, NULL, '2', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', 1, '2023-08-09 19:56:06', NULL);
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689244167186030593, NULL, NULL, '3', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', 1, '2023-08-09 19:56:09', NULL);
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689244178879750145, NULL, NULL, '4', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', 1, '2023-08-09 19:56:12', NULL);
INSERT INTO `sys_user` (`id`, `dept_id`, `nick_name`, `username`, `password`, `id_card`, `avatar`, `sex`, `email`, `phone`, `state`, `create_time`, `update_time`) VALUES (1689244200010653697, NULL, NULL, '5', 'd41d8cd98f00b204e9800998ecf8427e', NULL, NULL, NULL, '', '', 1, '2023-08-09 19:56:17', NULL);
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
COMMIT;

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='租户容量信息表';

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='tenant_info';

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'username',
  `password` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'password',
  `enabled` tinyint(1) NOT NULL COMMENT 'enabled',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
