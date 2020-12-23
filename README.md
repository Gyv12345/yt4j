# Yt4j 

一个简简单单前后台分离的权限管理系统，现在很多以spring cloud为根基的权限管理系统。但是有些时候感觉并不是很有必要上微服务，所以就想开发一套前后台分离，并且也便于将来改造成微服务的这样一个系统。

所以在开发之初，我们的思路就是便于扩展，并且因为是基于spring boot，如果想搞微服务，集成spring cloud 或者某个rpc框架进来即可。

如果你想开发一个简单的系统，仅需要做个后台，做点前台，那么可以使用yt4j，它和别的项目没什么两样，提供了一个新的选择罢了。

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
Spring Boot |  2.4.0
Mybatis Plus | 3.4.1
hutool | 5.4.7

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
│  ├─yt4j-ding 钉钉OA相关（还没有开始做）
│  └─yt4j-sys 基础系统【9999】

```

## 部署
部署的时候，需要设置一下host
```
127.0.0.1 yt4j-mysql
127.0.0.1 yt4j-redis
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
2e62edbcf91a59aa878963e32108478e 7天有效
