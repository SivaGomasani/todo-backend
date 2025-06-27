# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/backend-spring.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
