FROM openjdk:latest
COPY ./target/Group6-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semCoursework_6.jar", "db:3306"]

