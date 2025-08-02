FROM registry.access.redhat.com/ubi9/openjdk-21

WORKDIR /curso

COPY target/*.jar curso.jar

ENV SERVER_PORT=8080

ENTRYPOINT ["java", "-jar", "curso.jar"]