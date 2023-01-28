# Yt4j

ui部分 放弃了，前端太难了

[老UI](https://github.com/Gyv12345/yt4j-ui)

[快速开始](doc/develop.md)

<p>
 <img src="https://img.shields.io/badge/Yt4j-1.0.3-success.svg" alt="Build Status">
 <img src="https://img.shields.io/badge/spring%20boot-3.0.1-blue" alt="Coverage Status">
</p>


- 基于spring boot、spring cloud、sa-token的RBAC权限管理系统
- ~~基于ant design pro vue模板，构建前端界面~~
- 提供对docker支持


## 依赖


依赖 | 版本
---|---
Spring Boot | 3.0.1
Mybatis Plus | 3.5.3.1
hutool | 5.8.11
Spring Cloud | 2022.0.0
Spring Cloud Alibaba | 2022.0.0
sa-token | 1.34.0
plumelog | 3.5.3
xxl-job | 2.3.0

## 模块说明

```
yt4j
├─yt4j-auth 鉴权服务
├─yt4j-commons 公共模块
│  ├─yt4j-core 核心包
│  ├─yt4j-data mybatis-plus设置 数据权限
│  ├─yt4j-flow 自己开发的流程编排，暂时只能做同步调用，不能做异步调用
│  ├─yt4j-job xxl-job
│  ├─yt4j-log 统一日志
│  ├─yt4j-sa-token 使用sa-token 换了一个框架
│  ├─yt4j-security 安全相关
│  ├─yt4j-swagger swagger的配置 使用knife4j /doc.html 
│  └─yt4j-web web定义相关
├─yt4j-dependencies 依赖管理
├─yt4j-gateway 项目网关 【8888】
├─yt4j-modules 业务模块
│  └─yt4j-crm crm
│  └─yt4j-sys 基础系统
│  └─yt4j-sys-api feign调用

```

## 代码生成
感觉easycode作者大佬增加了官网，模板可以永久下载了，再也不用担心丢失之苦

acba9f2c5c244d87e9779722ba7392

## 部署
部署的时候，需要设置一下host
```
127.0.0.1 yt4j-mysql
127.0.0.1 yt4j-redis
127.0.0.1 yt4j-nacos
127.0.0.1 yt4j-admin
```
## 是否预览
```
在 yt4j-data DataAutoConfiguration 中有是否预览的设置，这个设置主要是防止演示环境被人删除数据
在本地开发的话，可以将之除去
//增加预览过滤器，增删改操作直接不成功
interceptor.addInnerInterceptor(new PreviewInterceptor(false));
```
## yt4j的密码用了rsa加密
~~配套的前端内有公钥进行加密，所以如果想要使用swagger测试的话，登录哪里注意去掉解密~~这个现在没有启用哦

## 流程编排（yt4j-flow）
像是[liteFlow](https://gitee.com/dromara/liteFlow?_from=gitee_search) 
[Gobrs-Async](https://gitee.com/dromara/gobrs-async) 
功能都很强大，水平有限写不出来这样好的框架，最初设计的时候就是想要能够让流程以拖拉拽的形式去设计，
然后找到了[easy-flow](https://gitee.com/xiaoka2017/easy-flow)项目， fork了一个项目
，增加了两个字段 beanId 和 condition 一个填写spring bean name，一个写spEL表达式
，完成以后，下载json文件，流程就在json文件中了，yt4j-flow会将这个文件中的节点转成树，一个个节点，按照符合条件去执行

fork 的项目 [yt4j-flow流程设计页](https://gitee.com/yangshao/easy-flow)

[![jUrxl6.png](https://s1.ax1x.com/2022/07/06/jUrxl6.png)](https://imgtu.com/i/jUrxl6)

~~~json
{
  "name": "测试流程",
  "nodeList": [
    {
      "id": "59uh21rtyo",
      "name": "开始",
      "type": "timer",
      "left": "266px",
      "top": "220px",
      "ico": "el-icon-time",
      "state": "success"
    },
    {
      "id": "4vcvxgcpo",
      "name": "大于十岁处理",
      "type": "task",
      "left": "610px",
      "top": "132px",
      "ico": "el-icon-odometer",
      "state": "success",
      "beanId": "flowDemo1"
    },
    {
      "id": "tk07ay06hm",
      "name": "小于十岁处理",
      "type": "task",
      "left": "597px",
      "top": "376px",
      "ico": "el-icon-odometer",
      "state": "success",
      "beanId": "flowDemo2"
    },
    {
      "id": "ewo9o56u8x",
      "name": "流程结束",
      "type": "end",
      "left": "998px",
      "top": "211px",
      "ico": "el-icon-caret-right",
      "state": "success"
    }
  ],
  "lineList": [
    {
      "from": "59uh21rtyo",
      "to": "4vcvxgcpo",
      "label": "大于10岁",
      "condition": "#age>10"
    },
    {
      "from": "59uh21rtyo",
      "to": "tk07ay06hm",
      "label": "小于10岁",
      "condition": "#age<10"
    },
    {
      "from": "tk07ay06hm",
      "to": "ewo9o56u8x"
    },
    {
      "from": "4vcvxgcpo",
      "to": "ewo9o56u8x"
    }
  ],
  "id": "0"
}


~~~


## 感谢 JetBrains 免费的开源授权

<a href="https://www.jetbrains.com/?from=yt4j" target="_blank">
<img src="https://user-images.githubusercontent.com/1787798/69898077-4f4e3d00-138f-11ea-81f9-96fb7c49da89.png" height="200"/></a>
