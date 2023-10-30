#FROM eclipse-temurin:17-jre-alpine
#
#COPY ./target/digital_hoteis-1.jar /opt/app/application.jar
#
#RUN addgroup -S spring && adduser -S spring -G spring
#
#RUN wget https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh -O /usr/local/bin/wait-for-it.sh
#RUN chmod +x /usr/local/bin/wait-for-it.sh
#
#CMD ["wait-for-it.sh", "--timeout=120", "mysql:3306", "--", "java", "-jar", "/opt/app/digital_hoteis-1.jar", "-Dspring.profiles.active=dockerembbed,oauth-security"]

# Build stage
FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

# Copy Maven wrapper files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Resolve project dependencies
RUN ./mvnw dependency:resolve

# Copy the application source code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Production stage
FROM eclipse-temurin:17-jre-jammy as production

# Set the working directory
WORKDIR /app

# Expose port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/digital_hoteis-*.jar /digital_hoteis-1.jar

# Start the application
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/digital_hoteis-1.jar"]
