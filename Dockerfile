FROM openjdk:17-oracle

EXPOSE 8080

COPY ./build/libs/notification-0.0.1-SNAPSHOT.jar /app/notification.jar
WORKDIR /app

CMD ["java", "-Xmx4g", "-jar", "notification.jar"]