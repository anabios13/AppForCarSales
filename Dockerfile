FROM openjdk:17-jdk-alpine
MAINTAINER anabios13
EXPOSE 8000
COPY build/libs/*.jar appForCarSales.jar
ENTRYPOINT ["java","-jar","/appForCarSales.jar"]