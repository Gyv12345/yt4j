# Yt4j 
如果你想开发一个简单的系统，仅需要做个后台，做点前台，那么可以使用yt4j，它和别的项目没什么两样，提供了一个新的选择罢了。

增加spring cloud 依赖，只是想要使用一些简单服务调用和配置中心，stream功能,尤其是stream，我下来想把企业微信和钉钉服务端都集成进来，主要是企业自研方面，把所有API都进行实现一下

之后会出系列视频，简单讲解一下思路和用到的技术

[配套UI](https://github.com/Gyv12345/yt4j-ui) 

[jenkins运行](doc/cicd.md)

[在线体验](https://www.yt4j.cn/ui/) （只有一台1c2g的服务器，所有东西都在上面，体验一下就行了）

<p align="center">
 <img src="https://img.shields.io/badge/Yt4j-1.0.1-success.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/antd%20vue%20pro-3.0.0-green.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/spring%20boot-2.4.0-blue" alt="Coverage Status">
</p>


- 基于spring boot 2.4.0、jwt的RBAC权限管理系统
- 基于ant design pro vue模板，构建前端界面
- 提供对docker支持

## 学习交流群

1067552007



## 依赖


依赖 | 版本
---|---
Spring Boot | 2.3.6 
Mybatis Plus | 3.4.1
hutool | 5.5.4 
 Spring Cloud | Hoxton.SR9 
 Spring Cloud Alibaba | 2.2.3 
 knife4j |  3.0.2

## 模块说明

```
yt4j
├─yt4j-commons 公共模块
│  ├─yt4j-core 核心包
│  ├─yt4j-data mybatis-plus设置
│  ├─yt4j-security 安全相关
│  └─yt4j-web web定义相关
├─yt4j-dependencies 依赖管理
├─yt4j-modules 业务模块
│  ├─yt4j-ding 钉钉相关 【9200】
│  └─yt4j-sys 基础系统【9100】
│  └─yt4j-wx 企业微信 【9300】

```

## 部署
部署的时候，需要设置一下host
```
127.0.0.1 yt4j-mysql
127.0.0.1 yt4j-redis
127.0.0.1 yt4j-nacos
```
## 是否预览
```
在 yt4j-data DataAutoConfiguration 中有是否预览的设置，这个设置主要是防止演示环境被人删除数据
在本地开发的话，可以将之除去
//增加预览过滤器，增删改操作直接不成功
interceptor.addInnerInterceptor(new PreviewInterceptor(false));
```
## yt4j的密码用了rsa加密
配套的前端内有公钥进行加密，所以如果想要使用swagger测试的话，登录哪里注意去掉解密

## 配套easycode模板 
d247cb4eeafd63c09d36e38042da2c2c 7天有效
