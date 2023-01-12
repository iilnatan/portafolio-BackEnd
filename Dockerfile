FROM amazoncorretto:19-alpine-jdk

MAINTAINER iilnatan

COPY target/Spring-Boot-0.0.1-SNAPSHOT.jar Spring-Boot-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/Spring-Boot-0.0.1-SNAPSHOT.jar"]