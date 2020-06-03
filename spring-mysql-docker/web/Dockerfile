FROM openjdk:8-jdk-alpine

EXPOSE 8181

ADD ./build/libs/web*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
