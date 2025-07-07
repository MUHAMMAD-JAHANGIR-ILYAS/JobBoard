# Use a lightweight base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container.
# All subsequent commands (COPY, ENTRYPOINT) will be relative to this directory.
WORKDIR /app

# Copy the packaged JAR file from your build context (your host's target directory)
# into the /app directory inside the container.
# Make sure the JAR name matches your actual build output.
COPY target/jobboard-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application listens on.
# This is for documentation; actual port mapping is done in docker-compose.yml.
EXPOSE 8080

# Define a volume for /tmp to optimize for temporary files created by Spring Boot,
# allowing Docker to manage them efficiently.
VOLUME /tmp

# Specify the command to run your Spring Boot application when the container starts.
ENTRYPOINT ["java", "-jar", "app.jar"]