#
# Build stage
#
FROM maven:3.6.0-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true


#
# Package stage
#
FROM openjdk:8-jdk-slim
COPY --from=build /home/app/target/project-0.0.1-SNAPSHOT.jar /usr/local/lib/accounting.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","/usr/local/lib/accounting.jar"]
