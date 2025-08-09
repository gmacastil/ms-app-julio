# Comandos

## Compliar

$ mvn clean compile


## Exportar pakage

$ mvn clean package

$ mvn clean package -DskipTests

## Sonarqube


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=factura \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=squ_4f6dcdb4bd7766b0c72d40c25809fe75477d2aad \
  -DskipTests

# Build images

$ docker build . -t factura:v6
$ docker tag factura:v6 mauron/factura:v6
$ docker push mauron/factura:v6

# Run container


$ docker run --name factura2  \
  -d \
  -e DATABASE_URL="jdbc:postgresql://192.168.1.184:5432/postgres" \
  -e DATABASE_USERNAME="postgres" \
  -e DATABASE_PASSWORD="123456" \
  -e JAVA_OPTS="-Xms256m -Xmx512m" \
  -e SERVER_PORT="8082" \
  -p 8084:8082 \
  factura:v4

$ docker compose up -d

