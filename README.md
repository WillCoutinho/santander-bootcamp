# Santander Bootcamp 2023
Bootcamp project from [DIO](https://www.dio.me/) sponsored by [Santander](https://app.becas-santander.com/pt-BR/program/bolsas-santander-santander-bootcamp-2023).    
This project was made in Java, SpringBoot and Gradle with the aim of evaluating the technical knowledge acquired during the bootcamp.  

## Preconditions
WIP

## Install & Run
WIP


## Class diagram

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


## Libs and Tools
[Gradle](https://docs.gradle.org/current/userguide/userguide.html) - Build tool and dependecy manager  
[Java 17 LTS](https://www.oracle.com/br/java/technologies/downloads/#java17) - Long Term Support version of Java  
[Mermaid](https://mermaid.js.org/syntax/classDiagram.html) - Class diagrams  
[SpringBoot](https://spring.io/projects/spring-boot) - Create stand-alone Spring applications  
