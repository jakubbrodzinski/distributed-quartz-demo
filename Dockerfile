FROM openjdk:11.0.11-slim
MAINTAINER jakubbrodzinski
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]