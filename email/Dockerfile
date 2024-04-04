# Use an official OpenJDK runtime as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /home

# Copy the packaged JAR file into the container
COPY target/email-1.0.jar .

# Expose the port that your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "email-1.0.jar"]