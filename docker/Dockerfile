FROM openjdk:21

WORKDIR /app

# Define a build argument for the JAR file path
ARG JAR_FILE

# Copy the JAR file into the image
COPY $JAR_FILE /app/

# Define environment variables and expose ports as needed
ENV SPRING_PROFILES_ACTIVE=dev
EXPOSE 8080

# Define the command to run the JAR file
CMD ["java", "-jar", "/app/AuthApi-0.0.1-SNAPSHOT.jar"]
