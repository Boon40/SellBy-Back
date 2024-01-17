FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn dependency:go-offline
RUN mvn package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/SellBy-0.0.1-SNAPSHOT.jar"]
