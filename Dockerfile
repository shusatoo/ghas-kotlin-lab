FROM gradle:8.10.2-jdk17 AS builder

WORKDIR /workspace

COPY build.gradle.kts settings.gradle.kts ./
COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY src ./src

RUN ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /workspace/build/libs/*.jar app.jar

EXPOSE 80

ENTRYPOINT ["java", "-Dserver.port=80", "-jar", "/app/app.jar"]
