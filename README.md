# Yt4j 

一个简简单单前后台分离的权限管理系统

官网 

<p align="center">
 <img src="https://img.shields.io/badge/Yt4j-1.0.1-success.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/antd-3.0.0-green.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/spring%20boot-2.3.3-blue" alt="Coverage Status">
</p>

- 基于spring boot 2.3.3、jwt的RBAC权限管理系统
- 基于ant design pro vue模板，构建前端界面
- 提供对docker支持
- 使用smart-doc进行接口文档生成



## 依赖


依赖 | 版本
---|---
Spring Boot |  2.3.3.RELEASE 
Mybatis Plus | 3.4.0
hutool | 5.4.0

## 模块说明

```
yt4j
├─yt4j-commons 公共模块
│  ├─yt4j-core 核心包
│  ├─yt4j-data mybatis-plus扩展
│  ├─yt4j-security 安全相关
│  └─yt4j-web web定义相关
├─yt4j-dependencies 依赖管理
├─yt4j-modules 业务模块
│  ├─yt4j-ding 钉钉OA相关
│  └─yt4j-sys 基础系统【9999】
└─yt4j-ui 系统前端ui【8000】

```

