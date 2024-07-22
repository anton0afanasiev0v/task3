FROM amazoncorretto:17.0.7-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} metrics-consumer.jar
ENTRYPOINT ["java","-jar","/metrics-consumer.jar"]
