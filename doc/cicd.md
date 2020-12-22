```
docker run -u root -itd -p 8080:8080 -p 50000:50000 \
--restart=always \
-v /var/jenkins_home:/var/jenkins_home \
-v /var/run/docker.sock:/var/run/docker.sock \
-v /usr/bin/docker:/usr/bin/docker \
-v /usr/local/bin/docker-compose:/usr/local/bin/docker-compose \
--name jenkins-master jenkins-master:1.0
```
