## Reading Is Good - Design
I have designed reading is good and its project structure with the mind set of having a clean architecture and code.
Services only communicate themselves in the service level because I wanted to maintain the level of abstraction between them.
In the end, I would say that the reading is good service can be considered as a giant microservice but loosely coupled on the inside because of applied SOLID principles.


## TECH STACK
    • Java 17
    • Spring Boot 2.6.3 (Please refer to the build.gradle file for the dependencies)
    • Mockito and JUnit 5
    • Lombok
    • MongoDB
    • Swagger
    • Docker, Docker-Compose and Docker Hub
    • Docker Compose
    • Docker Hub
    • Gitkraken and Github

## How to use
Requires JDK17 Gradle Docker and Docker-compose to build and run. One can refer to the postman collection in order to get a knowledge about how to use the application. Also please refer to the swagger ui endpoint given in the postman collection for api documentation.

Luckily I have pushed the latest Docker image to the Docker Hub as a public container image. Hence, only docker compose run command below is sufficient.

    > docker-compose -f docker-compose.yaml up

## How to improve
    • Test coverage is the first thing comes to my mind in terms of improvement. I needed to use Embedded MongoDb or a seperate database for testing. However time did not allow such a improvement. However it is noted that test coverage would improve a lot by the two things that is proposed.
    • I also could have made 5 seperate microservices in terms of high level design and the overall architecture would be very neat. One can apply seperation of concerns and develop Customer, Authentication, Book, Order and Statistics microservices.
