 1987  ssh elk 
 1988  docker ps 
 1989  docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
 
1990  docker ps 

 1991  docker rm e3b63d1417904d02aa49311f59f87b1258525135339f6428fe9dd7a499e3fb45

 1992  docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
 1993  docker ps 
 1994  docker exec -it some-mysql bash
 1995  docker run hello-world
 1996  docker ps 
 1997  ps
 1998  docker ps 
 1999  docker run -it debian:stretch-slim bash
 2000  docker run -d debian:stretch-slim bash
 2001  docker ps 
 2002  docker run -d debian:stretch-slim
 2003  docker ps 
 2004  docker run -d debian:stretch-slim bash
 2005  docker run debian:stretch-slim bash
 2006  docker run -it debian:stretch-slim bash
 2007  docker ps 
 2008  docker exec -it some-mysql bash
 2009  docker pull mysql:5.7
 2010  docker image list
 2011  docker ps 
 2012  docker stop some-mysql
 2013  docker ps 
 2014  docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
 2015  docker start -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d some-mysql
 2016  docker start  -d some-mysql
 2017  docker start some-mysql
 2018  docker ps 
 2019  docker image list
 2020  docker container ls
 2021  docker ps
 2022  docker stop some-mysql
 2023  docker lsi
 2024  ils
 2025  docker inspect some-mysql
 2026  docker search ubuntu
 2027  docker search jdk
 2028  docker start some-mysql
 2029  docker stop some-mysql
 2030  docker rm some-mysql
 2031  #docker run -p 3306:3306  -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
 2032  env
 2033  export REGION=Berlin
 2034  echo $REGION
 2035  echo $USER
 2036  echo $PATH
 2037  docker run -p 3306:3306  -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
 2038  docker ps 
 2039  docker restart focused_easley
 2040  docker ps 
 2041  docker stop focused_easley
 2042  cd /Projects/
 2043  git clone https://github.com/edwardKatsCourse/project-tracker.git
 2044  cd project-tracker/
 2045  ls
 2046  mkdir db 
 2047  mkdir web
 2048  mv Dockerfile web/
 2049  rm -f pom.xml mvnw.cmd mvnw 
 2050  rm -rf src/
 2051  ls
 2052  rm -rf .gitignore .mvn .git
 2053  ls -alth 
 2054  cd web/
 2055  ls
 2056  cat Dockerfile 
 2057  vi Dockerfile 
 2058  cd ..
 2059  git clone
 2060  git clone https://github.com/macagua/example.java.helloworld.git
 2061  cd example.java.helloworld
 2062  ls
 2063  jar cfme Main.jar Manifest.txt HelloWorld.Main HelloWorld/Main.class
 2064  sudo apt install default-jdk
 2065  jar cfme Main.jar Manifest.txt HelloWorld.Main HelloWorld/Main.class
 2066  javac HelloWorld/Main.java
 2067  jar cfme Main.jar Manifest.txt HelloWorld.Main HelloWorld/Main.class
 2068  ls
 2069  java -jar Main.jar
 2070  cp Main.jar ../project-tracker/web/
 2071  cd ../project-tracker/web/
 2072  ls
 2073  vi Dockerfile 
 2074  ls
 2075  java -jar Main.jar
 2076  docker build .
 2077* 
 2078  docker tag 8d91b5a59efe web:latest
 2079  docker run web:latest
 2080  cd ..
 2081  vi docker-compose.yml 
 2082  docker-compose up -d
 2083  docker ps
 2084  docker ps -a
 2085  docker logs web
 2086  history > myhistory.txt
