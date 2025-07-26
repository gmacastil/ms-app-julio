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
