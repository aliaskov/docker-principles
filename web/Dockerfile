#Base image for our spring application: OS + Java 8
FROM openjdk:8

#Copy jar file from "target" directory to "root" folder in container
#This step requires to build application before building the image
#This folder and this jar are built by "Maven install" command
ADD Main.jar Main.jar

#Container should allow data transferring on port 8080
EXPOSE 8080

#The command, container should execute as soon as it starts -  start our java application (project-tracker.jar)

#In a regular terminal, this command looks like:
#java -Dspring.profiles.active=docker -jar project-tracker.jar

#-Dspring... - the way to pass in Java parameters to the application.
#actual: spring.profiles.active=docker

#Spring profiles - is a feature, that helps to specify/split configuration for different environments,
#like: dev, test, prod.
#For example, prod configuration will be started only if "prod" keyword was passed.
#Otherwise - default configurations will be activated

ENTRYPOINT ["java", "-jar", "Main.jar"]
