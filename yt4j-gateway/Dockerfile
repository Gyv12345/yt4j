FROM registry.cn-heyuan.aliyuncs.com/yt4j/jdk21:21.0.4.0.4.7

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /yt4j-gateway

WORKDIR /yt4j-gateway

EXPOSE 8888

ADD ./target/yt4j-gateway.jar ./

CMD java $JAVA_OPTS -jar yt4j-gateway.jar
