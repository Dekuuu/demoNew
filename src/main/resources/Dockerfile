FROM openjdk:8

COPY *.jar /demo.jar

CMD ["--server.port=9080"]

EXPOSE 9080

ENTRYPOINT ["java","-jar","/demo.jar"]