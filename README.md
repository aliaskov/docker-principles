Что общего между devopsом и бомжом?
оба хорошо разбираются в контейнерах.



example.java.helloworld
=======================
##
This is the "Hello World" Example for Java. Dockerized, for sure
##


Compile class
-------------

For compile the main class for package, execute the follow command: ::

``  javac HelloWorld/Main.java``

This generate the ``Main.class`` file into ``HelloWorld`` directory.

Run class
---------

For run the main class for package, execute the follow command: ::

``  java -cp . HelloWorld.Main``

This show the ``Hello world`` message. Ctrl + c to interrupt

Create a JAR file
-----------------

For pack the main class for package as a JAR file, execute the follow command: ::

  ``jar cfm Main.jar Manifest.txt HelloWorld/Main.class``


Run a JAR file
--------------

For run the JAR file packed, execute the follow command: ::

  ``java -jar Main.jar``

This show the ``Hello world`` message and type that it's alive. Ctrl + c to interrupt

### Docker ###
![Image of Docker](https://github.com/aliaskov/docker-principles/blob/master/docker.png)


Docker build
--------------
To build local docker image run: 
  ``docker build app``

Where app is the directory, where Dockerfile is located.

```
Sending build context to Docker daemon  4.096kB
Step 1/4 : FROM openjdk:8
 ---> c14ba9d23b3a
Step 2/4 : ADD Main.jar Main.jar
 ---> Using cache
 ---> cd01ac514fc0
Step 3/4 : EXPOSE 8080
 ---> Using cache
 ---> 2184856efa48
Step 4/4 : ENTRYPOINT java -jar Main.jar
 ---> Using cache
 ---> ca4f636e0e79
Successfully built ca4f636e0e79

```
After this wee can tag the local image ( change ID!) : 
  ``docker tag ca4f636e0e79 javahelloworld``

Now we can run container from local image javahelloworld (ctrl +c to interrupt): ::
  ``docker run javahelloworld``

To run container in detached mode: ::
``  docker run --name javahelloworldapp -d javahelloworld:latest``

Where javahelloworldapp is the container name

Look at the status:
```
docker ps
CONTAINER ID        IMAGE                   COMMAND                CREATED             STATUS              PORTS               NAMES
5c7e34ff4460        javahelloworld:latest   "java -jar Main.jar"   43 seconds ago      Up 42 seconds       8080/tcp            javahelloworldapp
```
In order to stop running container: ::
  ``docker stop javahelloworldapp``
or ::
  ``docker stop 5c7e34ff4460``
Where 5c7e34ff4460 is the container ID

To see log output of running container: ::
  ``docker logs javahelloworldapp``

To follow the log (ctrl +c to interrupt): ::
  ``docker logs -f 5c7e34ff4460``
or ::
  ``docker logs -f javahelloworldapp``


  Docker hub
  --------------

Create dockerhub account.
Run 
`` docker login `` 
and enter credentials.

Create a tag by running 
``docker tag LOCALIMAGE:VERSION DOCKERHUBUSER/DOCKERHUNREPO:VERSION``:

``
docker tag javahelloworld aliaskov/javahelloworld:latest
``
Push image to dockerhub: ::
``docker push aliaskov/javahelloworld
``

Also possible: ::
  ``docker build -t aliaskov/javahelloworld:latest app
  ``

Get full image info : ::
``  docker inspect aliaskov/javahelloworld
``


Run Mysql container
--------------

``  
docker run -p 3306:3306 --name mysqlDB -e MYSQL_ROOT_PASSWORD=my-secret-pw -v /opt/mysql-data:/var/lib/mysql -d mysql:latest
``
Where:
  some-mysql is the container name
  -e MYSQL_ROOT_PASSWORD - environment variable
  my-secret-pw - mysql root password
  -d - detached mode
   mysql:latest - image name and version tag
  -v /opt/mysql-data:/var/lib/mysql 
  volume mount to save DB files, where /opt/mysql-data - host dir and /var/lib/mysql - container dir

Stop mysql container
 `` docker stop some-mysql ``

Start mysql container
  `` docker start some-mysql ``


  Docker-compose
  --------------

```yml
#docker-compose version
version: '3.3'

#Services we configure to run
services:

# Database service name.
# This name is used to refer this "service" inside of this docker-compose.yml configuration file
# When docker-compose will be started, db container will be visible to other containers of this file by name "db"
  db:

#   By this name db container will be accessible, using docker commands, intead of container name,
#   like, docker logs -f db
    container_name: db

#    Image, we want to build container from
    image: mysql:5.7

#   Environment variables we pass inside of the container, like JAVA_HOME
    environment:
      - MYSQL_ROOT_PASSWORD=r00t

#   Ports we want to bind our container with host OS
    ports:
      - "3306:3306"

# Java application service name.
# This name is used to refer this "service" inside of this docker-compose.yml configuration file
# When docker-compose will be started, web container will be visible to other containers of this file by name "web"
  app:

#   By this name "web" container will be accessible, using docker commands, instead of container name,
#   like: docker logs -f db
    container_name: app

#   We define, how we want to build our container.
#   Here, we are providing configuration to build, using Dockerfile
    build:

#     Dockerfile location
      dockerfile: app/Dockerfile

#     Dockerfile context. Like "working directory" or "workspace" of Dockerfile.
#     This configuration provides so-called "base path" for Dockerfile
      context: app/

#   Ports we want to bind our container with host OS
    ports:
    - "8080:8080"

#   Environment variables we pass inside of the container, like JAVA_HOME
    environment:
    - MYSQL_ROOT_PASSWORD=r00t
    - MYSQL_ROOT_USERNAME=root
    - START_DELAY=20000

#   This container (web) will start only, after "db" starts.
#   There is no reason to start web, if db is not started
    depends_on:
      - db
```

  Multistage build
  --------------
![simple_build](https://github.com/aliaskov/docker-principles/blob/master/simplebuild.png)
![multistage build](https://github.com/aliaskov/docker-principles/blob/master/multistage_build.png)

```
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
```

Reference
=========

- java - [How to run a JAR file - Stack Overflow] [http://stackoverflow.com/questions/1238145/how-to-run-a-jar-file]
- multistage build [How make images small] [https://habr.com/ru/company/ruvds/blog/485650]

To run debug container with aws-cli
`` docker run -it --rm -v "$(pwd)":/src -v "$HOME/.aws":/root/.aws amazon/aws-cli bash ``

