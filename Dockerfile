FROM zenika/alpine-maven as build

COPY src /usr/src/app/src

COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package
FROM openjdk:8-jdk-alpine

COPY --from=build /usr/src/app/target/google-auth-demo-0.0.1-SNAPSHOT.jar /usr/app/service-1.0.jar

ENTRYPOINT java -jar /usr/app/service-1.0.jar
