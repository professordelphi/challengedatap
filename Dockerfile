FROM openjdk
WORKDIR /app

COPY target/dataprev.jar /app/spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-app.jar"]