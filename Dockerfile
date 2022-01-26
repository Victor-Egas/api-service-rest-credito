FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD ./target/api-service-rest-credito-0.0.1-SNAPSHOT.jar service-credito.jar
ENTRYPOINT ["java","-jar","/service-credito.jar"]