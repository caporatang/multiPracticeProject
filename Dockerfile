# jdk 8
FROM openjdk:1.8-jdk

ARG JAR_FILE=build/libs/*.jar

#jar file copy
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=h2", "-jar", "app.jar"]