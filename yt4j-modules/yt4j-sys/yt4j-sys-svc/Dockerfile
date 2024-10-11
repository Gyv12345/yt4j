FROM registry.cn-heyuan.aliyuncs.com/yt4j/jdk21:21.0.4.0.4.7

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /app

WORKDIR /app

ADD ./target/yt4j-sys-svc.jar ./

CMD java $JAVA_OPTS -jar yt4j-sys-svc.jar
