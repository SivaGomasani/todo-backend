# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set environment variable
ENV JAVA_OPTS=""

# Set working directory
WORKDIR /app

# Copy JAR file from target
COPY target/*.jar app.jar

# Expose port (change if your Spring Boot app uses different)
EXPOSE 8080

# Run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
