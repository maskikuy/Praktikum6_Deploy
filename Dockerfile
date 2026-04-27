FROM eclipse-temurin:25-jdk
COPY target/Praktikum6-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080