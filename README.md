# Mediscreen Patient History
## Technical:

1. Framework: Spring Boot v2.6.3
2. Project Maven
3. Java 11
4. Spring Data MongoDB
5. Spring Web
6. Lombok
7. JaCoCo
8. SureFire
9. Validation
10. Swagger

## Setup MongoDB for local testing
1. Change the "MongoDB Connection configuration" in file src/main/resources/application.properties if needed.
2. Create a database "patientHistory".
3. Create a collection "histories".
4. To populate the collection, import the file "patient_histories.json" in the folder src/main/resources/MongoDBDataTest.

## Use
1. The service address is http://localhost:8082.
2. The Swagger documentation for the API is available at the adress http://localhost:8082/swagger-ui.html.

## Docker service
1. After importing all services (patient, history, assessment and Web UI), run the command "docker-compose up --build" from the folder of the MediscreenPatient project.
2. The Web UI address is http://localhost:8083.
