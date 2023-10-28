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

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY ./target/digital_hoteis-1.jar .

EXPOSE 8080

CMD ["java", "-jar", "digital_hoteis-1.jar"]
