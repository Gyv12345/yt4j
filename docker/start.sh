#!/bin/bash
docker network create --driver=bridge yt4j
docker-compose up -d
echo " ------------ 环境部署完成。  ------------ ";
