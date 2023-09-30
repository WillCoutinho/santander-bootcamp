# Santander Bootcamp 2023
Bootcamp project by [DIO](https://www.dio.me/) and sponsored by [Santander](https://app.becas-santander.com/pt-BR/program/bolsas-santander-santander-bootcamp-2023).    
This project is developed in Java 17, Spring Boot 3, Gradle and serves as an evaluation of the technical knowledge acquired during the bootcamp    

## Figma
This project is designed with support from [Santander - Dashboard](https://www.figma.com/file/0ZsjwjsYlYd3timxqMWlbj/SANTANDER---Projeto-Web%2FMobile?type=design&node-id=1421-432&mode=design) on Figma for APIs.


## Requirements
Ensure you have the following prerequisites before running the project:  
- [Java 17 LTS](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) installed with properly configured environment variables ([Oracle Docs](https://docs.oracle.com/cd/E11882_01/java.112/e10588/chfour.htm#JJDEV13217))   
- Git installed to clone this project ([Git Docs](https://git-scm.com/downloads)).  

## Installation and Execution
Follow these steps to clone and run the project:

1. Clone the project (with admin privileges) using this command:  
```bash
git clone https://github.com/WillCoutinho/santander-bootcamp.git && cd santander-bootcamp
```
2. Start the project with this command: ``gradlew bootRun --args='--spring.profiles.active=dev'``    
3. Once the project is running, you can access the Swagger documentation at the following URL: ``http://localhost/swagger-ui/index.html``  
4. To run the tests available in this project, use the following command: ``gradlew test``

> **_Notes_**   
>* These instructions were tested on Windows 10  
>* The "_postman-collections_" folder contains _.json_ files that can be imported into Postman for manual test execution  
>* The "_prd_url_" within collection "_prd_" is hosted on Railway and may become unavailable due to associated usage charges  


## Class Diagram - Dashboard

````mermaid
classDiagram
  class User {
    - name: string
    - account: Account
    - features: Feature[]
    - card: Card
    - news: News[]
    + getName(): string
    + getAccount(): Account
    + getFeatures(): Feature[]
    + getCard(): Card
    + getNews(): News[]
  }

  class Account {
    - number: string
    - agency: string
    - balance: number
    - limit: number
    + getNumber(): string
    + getAgency(): string
    + getBalance(): number
    + getLimit(): number
  }

  class Feature {
    - icon: string
    - description: string
    + getIcon(): string
    + getDescription(): string
  }

  class Card {
    - number: string
    - limit: number
    + getNumber(): string
    + getLimit(): number
  }

  class News {
    - icon: string
    - description: string
    + getIcon(): string
    + getDescription(): string
  }

  User "1" *-- "1" Account
  User "1" *-- "1..N" Feature
  User "1" *-- "1" Card
  User "1" *-- "1..N" News

````


## Tech Stack
[Gradle](https://docs.gradle.org/current/userguide/userguide.html) - Build tool and dependency manager  
[Java 17 LTS](https://www.oracle.com/br/java/technologies/downloads/#java17) - Long Term Support version of Java  
[JUnit5](https://junit.org/junit5/docs/current/user-guide/) - Unit test for Java  
[Mermaid](https://mermaid.js.org/syntax/classDiagram.html) - Class diagrams  
[PostgreSQL](https://jdbc.postgresql.org/documentation/setup/) - Object-relational database system  
[Railway](https://docs.railway.app/) - Cloud infrastructure  
[SpringBoot](https://spring.io/projects/spring-boot) - Create stand-alone Spring applications  
[Swagger OpenAPI](https://springdoc.org/#Introduction) - Enable Swagger for the application 

