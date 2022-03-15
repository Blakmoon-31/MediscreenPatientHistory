FROM openjdk:11-jdk
COPY target/mediscreenPatientHistory-0.0.1-SNAPSHOT.jar mediscreenPatientHistory-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mediscreenPatientHistory-0.0.1-SNAPSHOT.jar"]