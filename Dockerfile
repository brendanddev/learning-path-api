
# =======================================
# Dockerfile for SpringDock Application
# =======================================

# Use official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

COPY source dest

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT [ "java", "-jar", "springdock.jar" ]