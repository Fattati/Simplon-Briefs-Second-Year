FROM openjdk:11
ADD target/docker-springboot.jar docker-springboot.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker-springboot.jar"]