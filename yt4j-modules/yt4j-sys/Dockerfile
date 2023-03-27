FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER shichenyang89

ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /app

WORKDIR /app

ADD ./target/yt4j-sys.jar ./

CMD java $JAVA_OPTS -jar yt4j-sys.jar
