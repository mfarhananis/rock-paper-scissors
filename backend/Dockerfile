FROM maven:3.6.2-jdk-8-slim as jbilder

WORKDIR /backend_b

COPY . /backend_b

RUN mvn install

FROM openjdk:8-jre-alpine

WORKDIR /backend

COPY --from=jbilder /backend_b/target/backend-*.jar /backend/backend.jar

EXPOSE 8080

CMD ["java", "-jar", "backend.jar"]