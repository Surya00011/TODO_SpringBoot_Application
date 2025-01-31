# Use OpenJDK 17 Slim for best stability and small image size
FROM openjdk:17-slim

# Set working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/ToDo-Application-0.0.1-SNAPSHOT.jar app.jar/app

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "ToDo-Application-0.0.1-SNAPSHOT.jar"]
