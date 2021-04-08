> 首先欢迎你尝试yt4j，针对于文档对应视频即将上线



## 环境说明

| 软件          | 版本    | 备注                                                         |
| ------------- | ------- | ------------------------------------------------------------ |
| jdk           | 1.8以上 | 必须                                                         |
| mysql         | 8以上   | 必须                                                         |
| redis         | 3.2+    | 必须                                                         |
| node          | 10.0+   | 必须                                                         |
| maven         | 3.6.2+  | 必须                                                         |
| nacos         | 1.4     | 必须                                                         |
| xxl-job-admin | 2.2.0   | 项目当中没有用到，所以在启动项目的时候可以不用               |
| es            | 7.0+    | 其实好像都可以，主要用于日志搜集，当然如果不需要的话，可以关闭 |
| IDEA          | 2019+   | 需要安装lombok插件                                           |

## 一、项目下载

~~~shell
git clone https://github.com/Gyv12345/yt4j.git
~~~

## 二、配置数据库

数据库脚本说明

~~~shell
docker/db/schema.sql 建库语句
docker/db/yt4j.sql 核心数据库
docker/db/nacos_config.sql nacos配置数据
~~~

## 三、配置本地HOST

~~~shell
127.0.0.1 yt4j-mysql
127.0.0.1 yt4j-redis
127.0.0.1 yt4j-nacos
~~~

