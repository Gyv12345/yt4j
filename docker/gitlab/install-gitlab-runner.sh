#!/bin/bash
# shellcheck disable=SC2046
BASE_PATH=$(cd `dirname $0`;pwd)
echo "当前系统版本：";sudo cat /etc/redhat-release;
echo -e "\033[46;37;5m -------------- 开始安装gitlab-runner -------------- \033[0m";
# 安装gitlab runner
wget https://mirror.ghproxy.com/https://gitlab-runner-downloads.s3.amazonaws.com/latest/rpm/gitlab-runner_amd64.rpm
rpm -ivh gitlab-runner_amd64.rpm
gitlab-runner --version
