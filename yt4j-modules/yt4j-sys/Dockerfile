FROM pig4cloud/java:8-jre

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /yt4j-sys

WORKDIR /yt4j-sys

EXPOSE 9100

ADD ./target/yt4j-sys.jar ./

CMD sleep 60;java $JAVA_OPTS -jar yt4j-sys.jar
