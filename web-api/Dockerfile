FROM openjdk:17
ENV APP_HOME=/Users/edell/private-workspace/haru-note/web-api/
WORKDIR $APP_HOME
COPY ./build/libs/* ./app.jar
EXPOSE 8080
CMD ["java","-Dspring.profiles.active=local","-jar","app.jar"]