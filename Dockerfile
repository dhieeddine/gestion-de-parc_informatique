FROM maven:3.9.6-eclipse-temurin-21 AS backend-builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=backend-builder /app/target/gestion-de-parc_informatique-0.0.1-SNAPSHOT.jar app.jar
EXPOSE ${port}
CMD ["java", "-jar", "app.jar"]

