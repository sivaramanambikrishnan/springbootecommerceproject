# Use lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the pre-built JAR
COPY target/your-app.jar app.jar

# Expose the port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "app.jar"]
