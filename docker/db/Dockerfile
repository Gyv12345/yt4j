FROM mysql:8.0.22

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY schema.sql /docker-entrypoint-initdb.d

COPY yt4j.sql /docker-entrypoint-initdb.d

COPY nacos_config.sql /docker-entrypoint-initdb.d
