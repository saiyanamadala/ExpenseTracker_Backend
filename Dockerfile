FROM eclipse-temurin:22-jdk-alpine
RUN apk add --no-cache maven
ARG JAR_FILE=target/*.jar
COPY ./target/Expense_Tracker_Backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]