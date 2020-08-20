mvn clean install -Dmaven.test.skip=true
docker-compose down  --remove
docker-compose up -d