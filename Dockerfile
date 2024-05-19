FROM eclipse-temurin:21
RUN mkdir /app
COPY ./target/ProgKornyCRUD-Library-1.0-SNAPSHOT.jar /app
EXPOSE 8082
CMD ["java", "-jar", "ProgKornyCRUD-Library-1.0-SNAPSHOT.jar"]