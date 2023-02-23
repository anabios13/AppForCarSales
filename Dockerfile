FROM openjdk:17-jdk-alpine
MAINTAINER anabios13
COPY build/libs/*.jar AppForCarSales.jar
ENTRYPOINT ["java","-jar","/AppForCarSales.jar"]