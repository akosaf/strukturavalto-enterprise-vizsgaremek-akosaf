#FROM adoptopenjdk:14-jre-hotspot
#RUN mkdir /opt/app
#COPY target/inventoryApp 0.0.1-SNAPSHOT.jar /opt/app/inventory.jar
#CMD ["java", "-jar", "/opt/app/inventory.jar"]

#FROM maven:3.8.5-openjdk-17-slim
#WORKDIR /app
#COPY ./pom.xml .
#RUN mvn dependency:go-offline
#COPY ./src ./src
#RUN mvn clean package -DskipTests
#CMD mvn test spring-boot:run

#FROM maven:3.8.5-openjdk-17-slim as builder
#WORKDIR /app
#COPY ./pom.xml .
#RUN mvn dependency:go-offline
#COPY ./src ./src
#RUN mvn clean package -DskipTest
#
#FROM openjdk:17-alpine
#WORKDIR /app
#COPY --from=builder /app/target/inventoryApp 0.0.1-SNAPSHOT.jar ./app.jar
#CMD java -jar ./app.jar


FROM adoptopenjdk:14-jre-hotspot as builder
WORKDIR application
COPY target/inventoryapp-0.0.1-SNAPSHOT.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:14-jre-hotspot
WORKDIR application

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh .
RUN chmod +x ./wait-for-it.sh

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", \
"org.springframework.boot.loader.JarLancher"]
