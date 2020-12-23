
# ʹ��jenkins��docker�����в���
## �༭jenkins����
���ǵ�yt4j��Ŀ����Ҫʹ��maven�����д��spring boot��Ŀ��Ҳ��Ҫnodejs����ǰ�˽��в����������ұȽ�ϰ��ʹ��jenkins��Ϊ���������Լ����maven��node
```
FROM jenkins/jenkins
MAINTAINER shichenyang89
USER root
RUN curl -sL https://deb.nodesource.com/setup_14.x | bash -
RUN apt-get install -y nodejs
RUN curl -sL https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update && apt-get install yarn
RUN yarn config set registry https://registry.npm.taobao.org
ADD apache-maven-3.6.3-bin.tar.gz /opt
COPY settings.xml /opt/apache-maven-3.6.3/conf
ENV PATH /opt/apache-maven-3.6.3/bin:$PATH
```

## �������
```
docker build -t jenkins-master:1.0 .
```

## ����jenkins
```
docker run -u root -itd -p 8080:8080 -p 50000:50000 \
--restart=always \
-v /var/jenkins_home:/var/jenkins_home \
-v /var/run/docker.sock:/var/run/docker.sock \
-v /usr/bin/docker:/usr/bin/docker \
-v /usr/local/bin/docker-compose:/usr/local/bin/docker-compose \
--name jenkins-master jenkins-master:1.0
```
## ��¼jenkins
��һ�ε�¼��ʱ�򣬻������������룬����������ͨ��cat���������в���

֮����ǰ�װ����ˣ�����ʹ���Ƽ������ȫ��װ�˾ͺã������һ���������ˣ���������Ϊ���Դ���ʹ��www.google.com��ԭ�򣬿���ͨ�����뵽�����ڲ������޸ĵķ�ʽ�����


