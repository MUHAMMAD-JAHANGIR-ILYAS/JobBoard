# Use official Java 17 image
FROM openjdk:17

# Set app directory inside container
VOLUME /tmp

# Copy your packaged .jar file into the container
COPY target/jobboard-0.0.1-SNAPSHOT.jar app.jar

# Start your app
ENTRYPOINT ["java", "-jar", "/app.jar"]
