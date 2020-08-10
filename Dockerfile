FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/service-c.jar
COPY ${JAR_FILE} service-c.jar
ENTRYPOINT ["java","-jar","/service-c.jar"]