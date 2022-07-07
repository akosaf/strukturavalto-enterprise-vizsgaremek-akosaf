#FROM adoptopenjdk:14-jre-hotspot
#RUN mkdir /opt/app
#COPY target/warehouseapp-0.0.1-SNAPSHOT.jar /opt/app/inventory.jar
#CMD ["java", "-jar", "/opt/app/inventory.jar"]

FROM maven:3.8.5-openjdk-17-slim
WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package -DskipTests
CMD mvn test spring-boot:run