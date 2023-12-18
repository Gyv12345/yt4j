
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (4, 'yt4j-sys.yml', 'DEFAULT_GROUP', 'spring:\n  datasource:\n    url: jdbc:mysql://192.168.31.100:3306/yt4j?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    username: root\n    password: \'root\'\n', '586307a8e8f1b0926787ce3e77d64ae5', '2023-11-18 21:00:50', '2023-11-18 21:01:55', 'nacos', '192.168.31.178', '', '', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (5, 'yt4j-gateway.yml', 'DEFAULT_GROUP', 'spring:\n  cloud:\n    gateway:\n      routes:\n        - id: yt4j-sys\n          uri: lb://yt4j-sys\n          predicates:\n            - Path=/sys/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-auth\n          uri: lb://yt4j-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-crm\n          uri: lb://yt4j-crm\n          predicates:\n            - Path=/crm/**\n          filters:\n            - StripPrefix=1\n        - id: yt4j-generate\n          uri: lb://yt4j-generate\n          predicates:\n            - Path=/gen/**\n          filters:\n            - StripPrefix=1\n--- # 聚合文档\nknife4j:\n  gateway:\n    # 开区网关聚合文档 默认:/\n    enabled: true\n    # 网关前缀(如nginx配置的代理前缀) 默认:/\n    api-path-prefix: /\n    # 使用的UI版本(v2或者v3) 默认: v3\n    version: v3\n    # 服务发现\n    discover:\n      # 开启服务发现 默认:true\n      enabled: true\n      # 默认排序 默认:0\n      default-order: 0\n      # 排除的服务名 默认:为空(建议排除网关服务)\n      excluded-services: gateway\n    v3:\n      # 文档访问地址 默认:/v3/api-docs\n      api-docs-path: \'/v3/api-docs\'\n      # oauth2 redirect url\n      oauth2-redirect-url: \'\'\n      # validator url\n      validator-url: \'\'\n    routes:\n      # 分组名称\n      - name: 系统服务\n        # 文档地址\n        url: \'/sys/v3/api-docs\'\n        # context-path\n        context-path: \'/sys\'\n        # 服务名\n        service-name: sys\n        # 排序\n        order: 0\n      - name: 鉴权服务\n        # 文档地址\n        url: \'/auth/v3/api-docs\'\n        # context-path\n        context-path: \'/auth\'\n        # 服务名\n        service-name: auth\n        # 排序\n        order: 1\n      - name: 代码生成服务\n        # 文档地址\n        url: \'/gen/v3/api-docs\'\n        # context-path\n        context-path: \'/gen\'\n        # 服务名\n        service-name: gen\n        # 排序\n        order: 2', 'd67e7f799d290be3d8f7095d949af237', '2023-11-18 21:00:50', '2023-11-18 21:00:50', NULL, '192.168.31.178', '', '', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (6, 'application.yml', 'DEFAULT_GROUP', 'spring:\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n  boot:\n    admin:\n      client:\n        url: http://yt4j-admin:8891/admin\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.nologging.NoLoggingImpl\nyt4j:\n  swagger:\n    enabled: true\n    info:\n      title: ${spring.application.name}文档\n      version: 1.0\n      description: \'使用Knife4j返回Open-Api文档\'\n  sa:\n    ignoredUrl:\n      - /user/login\n      - /auth/login\n      - /swagger-ui.html\n      - /swagger-resources/**\n      - /swagger/**\n      - /**/v3/api-docs\n      - /**/*.js\n      - /**/*.css\n      - /**/*.png\n      - /**/*.ico\n      - /webjars/springfox-swagger-ui/**\n      - /actuator/**\n      - /doc.html\n      - /v3/**\n      - /v3/api-docs/swagger-config\njasypt:\n  encryptor:\n    password: yt4j\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: ALWAYS\n    logfile:\n      external-file: ./logs/${spring.application.name}/console.log\n# Sa-Token配置\nsa-token:\n  # token名称 (同时也是cookie名称)\n  token-name: Authorization\n  # token有效期 设为一天 (必定过期) 单位: 秒\n  timeout: 86400\n  # token临时有效期 (指定时间无操作就过期) 单位: 秒\n  activity-timeout: 1800\n  # 开启内网服务调用鉴权\n  check-same-token: true\n  # Id-Token的有效期 (单位: 秒)\n  id-token-timeout: 600\n  # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)\n  is-concurrent: true\n  # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)\n  is-share: false\n  # 是否尝试从header里读取token\n  is-read-head: true\n  # 是否尝试从cookie里读取token\n  is-read-cookie: false\n  # token前缀\n  token-prefix: \"Bearer\"\n  # 是否输出操作日志\n  is-log: true\n--- # \nspring:\n  data:\n    redis:\n      host: yt4j-redis\n      password: 123456\n# plumelog 集中式日志 链路追踪\nplumelog:\n  appName: ${spring.application.name}\n  redisHost: ${spring.data.redis.host}\n  redisAuth: ${spring.data.redis.password}\n  redisDb: 0\n\n--- # 动态线程池 本质上动态线程池最好还是放到各个子模块里，这样可以方便的对不同模块应用进行不同的操作\nspring:\n  dynamic:\n    tp:\n      enabled: true\n      enabledCollect: true                   # 是否开启监控指标采集，默认false\n      collectorTypes: micrometer,logging     # 监控数据采集器类型（logging | micrometer | internal_logging），默认micrometer\n      logPath: /home/logs                    # 监控日志数据路径，默认 ${user.home}/logs，采集类型非logging不用配置\n      monitorInterval: 5                     # 监控时间间隔（报警检测、指标采集），默认5s\n      platforms:                              # 通知报警平台配置                # 接受人飞书名称/openid\n        - platform: email\n          platformId: 4\n          receivers: gyv12345@163.com   # 收件人\n      executors:                                   # 动态线程池配置，都有默认值，采用默认值的可以不配置该项，减少配置量\n        - threadPoolName: dtpExecutor1\n          threadPoolAliasName: 测试线程池            # 线程池别名\n          executorType: common                     # 线程池类型common、eager：适用于io密集型\n          corePoolSize: 6\n          maximumPoolSize: 8\n          queueCapacity: 200\n          queueType: VariableLinkedBlockingQueue   # 任务队列，查看源码QueueTypeEnum枚举类\n          rejectedHandlerType: CallerRunsPolicy    # 拒绝策略，查看RejectedTypeEnum枚举类\n          keepAliveTime: 50\n          allowCoreThreadTimeOut: false                  # 是否允许核心线程池超时\n          threadNamePrefix: test                         # 线程名前缀\n          waitForTasksToCompleteOnShutdown: false        # 参考spring线程池设计，优雅关闭线程池\n          awaitTerminationSeconds: 5                     # 单位（s）\n          preStartAllCoreThreads: false                  # 是否预热所有核心线程，默认false\n          runTimeout: 200                                # 任务执行超时阈值，目前只做告警用，单位（ms）\n          queueTimeout: 100                              # 任务在队列等待超时阈值，目前只做告警用，单位（ms）\n          taskWrapperNames: [\"ttl\", \"mdc\"]               # 任务包装器名称，继承TaskWrapper接口\n          notifyEnabled: true                            # 是否开启报警，默认true\n          notifyItems:                     # 报警项，不配置自动会按默认值配置（变更通知、容量报警、活性报警、拒绝报警、任务超时报警）\n            - type: capacity               # 报警项类型，查看源码 NotifyTypeEnum枚举类\n              enabled: true\n              threshold: 80                # 报警阈值\n              platforms: [ding,wechat]     # 可选配置，不配置默认拿上层platforms配置的所以平台\n              interval: 120                # 报警间隔（单位：s）\n            - type: liveness\n              enabled: true\n              threshold: 80\n            - type: reject\n              enabled: true\n              threshold: 1\n            - type: run_timeout\n              enabled: true\n              threshold: 1\n            - type: queue_timeout\n              enabled: true\n              threshold: 1', '6f468f6e6e3720a7c67e2ba13f43bbf3', '2023-11-18 21:00:50', '2023-12-18 23:14:29', 'nacos', '192.168.31.179', '', '', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (7, 'yt4j-generate.yml', 'DEFAULT_GROUP', 'spring:\n  datasource:\n    type: com.zaxxer.hikari.HikariDataSource\n    # 动态数据源文档 https://www.kancloud.cn/tracy5546/dynamic-datasource/content\n    dynamic:\n      # 性能分析插件(有性能损耗 不建议生产环境使用)\n      p6spy: false\n      # 设置默认的数据源或者数据源组,默认值即为 master\n      primary: master\n      # 严格模式 匹配不到数据源则报错\n      strict: false\n      datasource:\n        # 主库数据源\n        master:\n          type: ${spring.datasource.type}\n          driverClassName: com.mysql.cj.jdbc.Driver\n          # jdbc 所有参数配置参考 https://lionli.blog.csdn.net/article/details/122018562\n          # rewriteBatchedStatements=true 批处理优化 大幅提升批量插入更新删除性能(对数据库有性能损耗 使用批量操作应考虑性能问题)\n          url: jdbc:mysql://gz-cynosdbmysql-grp-097nbpx3.sql.tencentcdb.com:29323/yt4j?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&autoReconnect=true&rewriteBatchedStatements=true\n          username: root\n          password: \'!Shijie123456\'\n      hikari:\n        # 最大连接池数量\n        maxPoolSize: 20\n        # 最小空闲线程数量\n        minIdle: 10\n        # 配置获取连接等待超时的时间\n        connectionTimeout: 10000\n        # 校验超时时间\n        validationTimeout: 5000\n        # 空闲连接存活最大时间，默认10分钟\n        idleTimeout: 60000\n        # 此属性控制池中连接的最长生命周期，值0表示无限生命周期，默认30分钟\n        maxLifetime: 900000\n        # 连接测试query（配置检测连接是否有效）\n        connectionTestQuery: SELECT 1\n---\nyt4j:\n  datasource:\n    url: ${spring.datasource.dynamic.datasource.master.url}\n    username: ${spring.datasource.dynamic.datasource.master.username}\n    password: ${spring.datasource.dynamic.datasource.master.password}\n    driverClassName: ${spring.datasource.dynamic.datasource.master.driverClassName}\n    queryDsSql: \'select * from gen_datasource\'', '22f25604640251cee7d364a46e04c5eb', '2023-11-18 21:00:50', '2023-11-18 21:00:50', NULL, '192.168.31.178', '', '', NULL, NULL, NULL, 'yaml', NULL, '');

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC, `datum_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC, `tag_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id` ASC, `tag_name` ASC, `tag_type` ASC) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint UNSIGNED NOT NULL,
  `nid` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create` ASC) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified` ASC) USING BTREE,
  INDEX `idx_did`(`data_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (6, 16, 'application.yml', 'DEFAULT_GROUP', '', 'spring:\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n  boot:\n    admin:\n      client:\n        url: http://yt4j-admin:8891/admin\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\nyt4j:\n  swagger:\n    enabled: true\n    info:\n      title: ${spring.application.name}文档\n      version: 1.0\n      description: \'使用Knife4j返回Open-Api文档\'\n  sa:\n    ignoredUrl:\n      - /user/login\n      - /auth/login\n      - /swagger-ui.html\n      - /swagger-resources/**\n      - /swagger/**\n      - /**/v3/api-docs\n      - /**/*.js\n      - /**/*.css\n      - /**/*.png\n      - /**/*.ico\n      - /webjars/springfox-swagger-ui/**\n      - /actuator/**\n      - /doc.html\n      - /v3/**\n      - /v3/api-docs/swagger-config\njasypt:\n  encryptor:\n    password: yt4j\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: ALWAYS\n    logfile:\n      external-file: ./logs/${spring.application.name}/console.log\n# Sa-Token配置\nsa-token:\n  # token名称 (同时也是cookie名称)\n  token-name: Authorization\n  # token有效期 设为一天 (必定过期) 单位: 秒\n  timeout: 86400\n  # token临时有效期 (指定时间无操作就过期) 单位: 秒\n  activity-timeout: 1800\n  # 开启内网服务调用鉴权\n  check-same-token: true\n  # Id-Token的有效期 (单位: 秒)\n  id-token-timeout: 600\n  # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)\n  is-concurrent: true\n  # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)\n  is-share: false\n  # 是否尝试从header里读取token\n  is-read-head: true\n  # 是否尝试从cookie里读取token\n  is-read-cookie: false\n  # token前缀\n  token-prefix: \"Bearer\"\n  # 是否输出操作日志\n  is-log: true\n--- # \nspring:\n  data:\n    redis:\n      host: yt4j-redis\n      password: 123456\n# plumelog 集中式日志 链路追踪\nplumelog:\n  appName: ${spring.application.name}\n  redisHost: ${spring.data.redis.host}\n  redisAuth: ${spring.data.redis.password}\n  redisDb: 0\n\n--- # 动态线程池 本质上动态线程池最好还是放到各个子模块里，这样可以方便的对不同模块应用进行不同的操作\nspring:\n  dynamic:\n    tp:\n      enabled: true\n      enabledCollect: true                   # 是否开启监控指标采集，默认false\n      collectorTypes: micrometer,logging     # 监控数据采集器类型（logging | micrometer | internal_logging），默认micrometer\n      logPath: /home/logs                    # 监控日志数据路径，默认 ${user.home}/logs，采集类型非logging不用配置\n      monitorInterval: 5                     # 监控时间间隔（报警检测、指标采集），默认5s\n      platforms:                              # 通知报警平台配置                # 接受人飞书名称/openid\n        - platform: email\n          platformId: 4\n          receivers: gyv12345@163.com   # 收件人\n      executors:                                   # 动态线程池配置，都有默认值，采用默认值的可以不配置该项，减少配置量\n        - threadPoolName: dtpExecutor1\n          threadPoolAliasName: 测试线程池            # 线程池别名\n          executorType: common                     # 线程池类型common、eager：适用于io密集型\n          corePoolSize: 6\n          maximumPoolSize: 8\n          queueCapacity: 200\n          queueType: VariableLinkedBlockingQueue   # 任务队列，查看源码QueueTypeEnum枚举类\n          rejectedHandlerType: CallerRunsPolicy    # 拒绝策略，查看RejectedTypeEnum枚举类\n          keepAliveTime: 50\n          allowCoreThreadTimeOut: false                  # 是否允许核心线程池超时\n          threadNamePrefix: test                         # 线程名前缀\n          waitForTasksToCompleteOnShutdown: false        # 参考spring线程池设计，优雅关闭线程池\n          awaitTerminationSeconds: 5                     # 单位（s）\n          preStartAllCoreThreads: false                  # 是否预热所有核心线程，默认false\n          runTimeout: 200                                # 任务执行超时阈值，目前只做告警用，单位（ms）\n          queueTimeout: 100                              # 任务在队列等待超时阈值，目前只做告警用，单位（ms）\n          taskWrapperNames: [\"ttl\", \"mdc\"]               # 任务包装器名称，继承TaskWrapper接口\n          notifyEnabled: true                            # 是否开启报警，默认true\n          notifyItems:                     # 报警项，不配置自动会按默认值配置（变更通知、容量报警、活性报警、拒绝报警、任务超时报警）\n            - type: capacity               # 报警项类型，查看源码 NotifyTypeEnum枚举类\n              enabled: true\n              threshold: 80                # 报警阈值\n              platforms: [ding,wechat]     # 可选配置，不配置默认拿上层platforms配置的所以平台\n              interval: 120                # 报警间隔（单位：s）\n            - type: liveness\n              enabled: true\n              threshold: 80\n            - type: reject\n              enabled: true\n              threshold: 1\n            - type: run_timeout\n              enabled: true\n              threshold: 1\n            - type: queue_timeout\n              enabled: true\n              threshold: 1', 'cde397c491c92041934e619403134e60', '2023-12-18 23:14:29', '2023-12-18 23:14:29', 'nacos', '192.168.31.179', 'U', '', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role` ASC, `resource` ASC, `action` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username` ASC, `role` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp` ASC, `tenant_id` ASC) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
