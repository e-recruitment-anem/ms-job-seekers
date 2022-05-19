FROM openjdk:11

COPY target/ms-job-seeker*.jar ms-job-seeker.jar

ENTRYPOINT [ "java","-jar","/ms-job-seeker.jar" ]

EXPOSE 8090