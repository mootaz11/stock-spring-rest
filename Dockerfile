FROM  FROM openjdk:11
WORKDIR application
EXPOSE 8000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} stock_app.jar
ENTRYPOINT ["java","-jar","stock_app.jar"]


