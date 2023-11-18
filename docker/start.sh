#!/bin/bash
docker-compose down
docker-compose build
docker-compose up -d
echo " ------------ 环境部署完成。  ------------ ";
