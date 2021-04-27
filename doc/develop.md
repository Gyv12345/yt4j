
> 首先欢迎你尝试yt4j

## 视频地址

[视频](https://www.bilibili.com/video/BV1J64y1U7r2/)

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

## 四、启动nacos

![nacos](..\img\5.png)

application.yml中是一些公用的配置，你只需要修改yt4j-sys.yml中的数据库连接地址，账号和密码

## 五、不开启Plumelog

![Plumelog](..\img\6.png)

将配置文件中配置项注释掉即可

## 六、启动项目

现在你可以启动项目了，yt4j现在比较简陋，将gateway和sys启动，服务端就已经启动起来了

前端使用yarn run serve 命令进行启动
