FROM openjdk:8-jdk-alpine
LABEL maintainer="renato.p.almeida@gmail.com"
VOLUME /main-app
ADD target/seguradoraapi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]