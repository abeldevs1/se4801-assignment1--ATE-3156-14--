# ShopWave Enterprise Assignment

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0.4-brightgreen?style=for-the-badge&logo=spring-boot)
![Build Status](https://img.shields.io/github/actions/workflow/status/abeldevs1/se4801-assignment1-ATE-3156-14/ci.yml?style=for-the-badge&logo=githubactions)
![Database](https://img.shields.io/badge/Database-H2_In--Memory-blue?style=for-the-badge&logo=database)


**Name:** Abel Taye  
**Student Number:** ATE-3156-14

## 📖 Overview
ShopWave is a production-grade e-commerce back-end built with Spring Boot 3.x and Java 21. It is designed with a strict layered architecture (`Controller` → `Service` → `Repository`) and adheres to SOLID principles to ensure long-term maintainability and scalability.

## Technology Stack
| Category | Technology |
| :--- | :--- |
| **Language** | Java 21 |
| **Framework** | Spring Boot 3.0.4 |
| **Database** | H2 (In-Memory) |
| **Data Access** | Spring Data JPA / Hibernate |
| **Testing** | JUnit 5, Mockito, Spring Boot Test |

##  Build & Execution Instructions

### Prerequisites
Before you begin, ensure you have the following installed:
* [Java 21 JDK](https://adoptium.net/)
* [Maven 3.8+](https://maven.apache.org/)

### 1. Build the Application
Navigate to the root directory containing the `pom.xml` and run the Maven package phase to compile the code and build the application:
```bash
mvn clean package
```
### 2. Run the Application
Start the embedded Tomcat server. The application will be accessible on port 8080:

```Bash
mvn spring-boot:run
```
### 3. Run the Test Suite
Execute the automated unit and integration tests across the Web, Service, and Repository layers to ensure system stability:
```
Bash
mvn clean test
```
### Academic Integrity & AI Declaration
In accordance with the assignment guidelines, I declare that this codebase and the accompanying report represent my own work.

Generative AI (Gemini) was utilized purely as an interactive tutor and debugging assistant during development. Specifically, AI was used to:

Identify and resolve Maven lifecycle and directory execution errors.

Explain the interaction and underlying mechanics of Spring Boot annotations (@RestController, @Service, @Repository).

Assist in generating boilerplate JUnit 5 and Mockito test structures.
