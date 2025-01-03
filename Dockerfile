FROM openjdk:22-jdk-slim
RUN apt-get update && apt-get install -y maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk-slim
COPY target/Expense_Tracker_Backend-0.0.1-SNAPSHOT.jar /app/Expense_Tracker_Backend.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","Expense_Tracker_Backend.jar"]