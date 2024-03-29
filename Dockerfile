FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jdk 
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java","-jar","/app.jar", "--debug" ,"--message2=${envmessage}" ]
