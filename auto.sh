mvn clean install -Dmaven.test.skip=true
docker-compose down  --remove
docker-compose build
docker-compose up -d