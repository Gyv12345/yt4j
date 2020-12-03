FROM pig4cloud/java:8-jre

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms256m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /yt4j-sys

WORKDIR /yt4j-sys

EXPOSE 9999

ADD ./target/yt4j-sys.jar ./

CMD java $JAVA_OPTS -jar yt4j-sys.jar --spring.profiles.active=prod
