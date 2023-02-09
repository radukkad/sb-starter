FROM amazoncorretto:11
MAINTAINER Rajesh
COPY target/sb-starter-0.0.1-SNAPSHOT.jar sb-starter-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/sb-starter-0.0.1.jar"]