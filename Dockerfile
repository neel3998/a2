# Use a base image with Java 21 installed
FROM amazoncorretto:21

# Set the working directory inside the container
WORKDIR /app

# Copy the server JAR file to the container
COPY build/libs/assignment-2-*-SNAPSHOT.jar server.jar

# Run the server when the container starts
ENTRYPOINT ["java", "-jar", "server.jar"]
