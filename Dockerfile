FROM openjdk:14.0.1-oracle
WORKDIR /app
COPY spring-boot-service/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]