# Yt4j-cloud

[配套UI](https://github.com/Gyv12345/yt4j-ui) 

[快速开始](doc/develop.md)

**[jenkins运行](doc/cicd.md)** 暂时不能用了，架构改了

<p align="center">
 <img src="https://img.shields.io/badge/Yt4j-1.0.1-success.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/antd%20vue%20pro-3.0.0-green.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/spring%20boot-2.4.X-blue" alt="Coverage Status">
</p>


- 基于spring boot、spring cloud、jwt的RBAC权限管理系统
- 基于ant design pro vue模板，构建前端界面
- 提供对docker支持


## 依赖


依赖 | 版本
---|---
Spring Boot | 2.4.x
Mybatis Plus | 3.4.2
hutool | 5.5.4 
 Spring Cloud | 2020.0.1
 Spring Cloud Alibaba | 2020.1
 knife4j |  3.0.2

## 模块说明

```
yt4j
├─yt4j-commons 公共模块
│  ├─yt4j-core 核心包
│  ├─yt4j-data mybatis-plus设置
│  ├─yt4j-job xxl-job
│  ├─yt4j-log 统一日志
│  ├─yt4j-security 安全相关
│  ├─yt4j-swagger 引入了军刀
│  └─yt4j-web web定义相关
├─yt4j-dependencies 依赖管理
├─yt4j-gateway 项目网关
├─yt4j-modules 业务模块
│  └─yt4j-sys 基础系统【9100】
├─yt4j-monitor 监控模块
│  ├─yt4j-log-server 统一日志服务端、ui Plumelog项目中服务端直接搬过来了方便开发
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

## 复杂流程设计器
最近在疯狂的看规则引擎，但是发现还是比较复杂的，而且可能不是自己想要的效果，我其实只是想要一个将业务流程画出来的东西，然后让代码按照流程去走，有些流程节点可以进行复用，所以在网上找了找，找到了一个前端项目，非常的惊喜，因为前端就是我想要的，自己写了一套后台，最后想要以stater的方式引入到项目中来
