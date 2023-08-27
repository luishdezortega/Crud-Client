FROM openjdk:17-jdk-alpine
COPY target/client-0.0.1.jar /gml-client.jar
EXPOSE 9090
CMD ["java", "-jar", "/gml-client.jar"]