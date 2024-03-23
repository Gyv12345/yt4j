#!/bin/bash
# shellcheck disable=SC2046
BASE_PATH=$(cd `dirname $0`;pwd)
echo "当前系统版本：";sudo cat /etc/redhat-release;
echo -e "\033[46;37;5m -------------- 开始安装docker所需环境 -------------- \033[0m";
# 安装docker环境
echo " ------------ 开始安装docker服务 ------------ ";
yum update -y;
yum install -y yum-utils device-mapper-persistent-data lvm2;
yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo;
sed -i 's+download.docker.com+mirrors.aliyun.com/docker-ce+' /etc/yum.repos.d/docker-ce.repo;
yum makecache fast;
yum install -y docker-ce;
systemctl start docker;
systemctl enable docker;
docker version;
curl -L https://mirror.ghproxy.com/https://github.com/docker/compose/releases/download/v2.23.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose;
sudo chmod +x /usr/local/bin/docker-compose;
docker-compose version;
echo " ------------ docker服务安装完毕 ------------ ";


