
# =======================================
# Dockerfile for SpringDock Application
# =======================================


# Use official OpenJDK runtime as base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory in the container
WORKDIR /app

# Copy the built JAR into the container
# Renames the jar for simplicity
COPY target/springdock-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT [ "java", "-jar", "app.jar" ]