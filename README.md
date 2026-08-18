Aamaaa 😎 Task 1 **Data Redundancy Removal System**-ku தான் README கேட்டிருக்க! இதோ **full professional `README.md`**, author-உம் சேர்த்து. Direct-aa copy-paste பண்ணலாம்.

# Data Redundancy Removal System

A cloud-deployed web application designed to identify duplicate data and classify incoming records as **UNIQUE** or **REDUNDANT**.

The system provides a simple frontend interface where users can submit data for validation. The backend processes the request, checks the existing records in the database, and stores only unique data while identifying duplicate submissions.

---

## Project Overview

The **Data Redundancy Removal System** is developed as part of the **CodeAlpha Cloud Computing Internship**.

The primary goal of this project is to demonstrate how cloud technologies can be used to build, deploy, and operate a backend-driven application with database integration.

The system validates incoming data against previously stored records and provides an appropriate classification.

### Classification

* **UNIQUE** – The submitted data does not already exist in the database.
* **REDUNDANT** – The submitted data already exists in the database.
* **FALSE_POSITIVE** – The submitted input is invalid or empty.

---

## Objectives

* Identify duplicate data efficiently.
* Prevent redundant records from being stored.
* Validate incoming data before database insertion.
* Provide clear UNIQUE / REDUNDANT classification.
* Store validated data in a cloud-based MySQL database.
* Deploy the application using cloud infrastructure.
* Gain practical experience with Docker and cloud deployment.

---

## Key Features

### Data Validation

* Accepts user-provided data.
* Validates empty or invalid input.
* Checks submitted data against existing records.

### Duplicate Detection

* Identifies whether submitted data already exists.
* Classifies duplicate records as `REDUNDANT`.
* Prevents duplicate data from being inserted.

### Unique Data Storage

* New data is classified as `UNIQUE`.
* Unique records are stored in the database.
* Each successfully stored record receives a unique ID.

### Cloud Integration

* Spring Boot backend deployed on Render.
* MySQL database hosted on Aiven.
* Docker used for application containerization.
* Frontend deployed as a Render Static Site.

---

## System Architecture

```text
                 ┌──────────────────────────┐
                 │        Frontend           │
                 │     HTML / CSS / JS       │
                 └────────────┬─────────────┘
                              │
                              │ REST API
                              ▼
                 ┌──────────────────────────┐
                 │      Render Web Service  │
                 │       Spring Boot        │
                 │        Backend           │
                 └────────────┬─────────────┘
                              │
                              │ JPA / Hibernate
                              ▼
                 ┌──────────────────────────┐
                 │       Aiven MySQL        │
                 │      Cloud Database      │
                 └──────────────────────────┘
```

---

## Application Workflow

```text
User enters data
        │
        ▼
Frontend validation
        │
        ▼
POST /api/data
        │
        ▼
Spring Boot Backend
        │
        ▼
Check database for existing data
        │
        ├───────────────┐
        │               │
        ▼               ▼
 Data exists       Data does not exist
        │               │
        ▼               ▼
  REDUNDANT           UNIQUE
        │               │
        │               ▼
        │          Save to database
        │               │
        └───────┬───────┘
                ▼
          Return response
                │
                ▼
          Display result
```

---

## Technology Stack

### Frontend

* HTML5
* CSS3
* JavaScript
* Fetch API

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* REST API

### Database

* MySQL 8.4
* Aiven Cloud MySQL

### Cloud & DevOps

* Render
* Aiven
* Docker

### Development Tools

* Visual Studio Code
* Git
* GitHub
* Postman

---

## Project Structure

```text
data-redundancy-removal-system/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── codealpa/
│       │           └── redundancy/
│       │               ├── controller/
│       │               │   ├── DataEntryController.java
│       │               │   └── HomeController.java
│       │               │
│       │               ├── entity/
│       │               │   └── DataEntry.java
│       │               │
│       │               ├── repository/
│       │               │   └── DataEntryRepository.java
│       │               │
│       │               └── service/
│       │                   └── DataEntryService.java
│       │
│       └── resources/
│           └── application.properties
│
├── frontend/
│   ├── index.html
│   ├── script.js
│   └── style.css
│
├── Dockerfile
├── pom.xml
├── .gitignore
└── README.md
```

---

## REST API

### Check and Add Data

**Endpoint:**

```text
POST /api/data
```

### Request Parameter

```text
data
```

### Example Request

```text
POST /api/data?data=Hello%20World
```

### Unique Data Response

```json
{
  "data": "Cloud Test 999",
  "status": "UNIQUE",
  "id": 2
}
```

### Redundant Data Response

```json
{
  "data": "Cloud Test 999",
  "status": "REDUNDANT",
  "id": null
}
```

---

## Database

The system uses a MySQL database hosted on **Aiven Cloud**.

The database stores validated unique data records.

### DataEntry

| Field  | Description        |
| ------ | ------------------ |
| id     | Unique record ID   |
| data   | Submitted data     |
| status | UNIQUE / REDUNDANT |

Only unique data is persisted as a new record.

---

## Local Setup

### 1. Clone the Repository

```bash
git clone https://github.com/jpugazholi/CodeAlpha-cloud-computing-Internship_Task1_DataRedundancyRemovalSystem.git
```

### 2. Navigate to the Project

```bash
cd data-redundancy-removal-system
```

### 3. Configure MySQL

Update:

```text
src/main/resources/application.properties
```

For local development:

```properties
spring.application.name=data-redundancy-removal-system

spring.datasource.url=jdbc:mysql://localhost:3306/redundancy_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The backend will be available at:

```text
http://localhost:8080
```

---

## Docker

The backend is containerized using Docker.

### Build Docker Image

```bash
docker build -t data-redundancy-removal-system .
```

### Run Docker Container

```bash
docker run -p 8080:8080 data-redundancy-removal-system
```

---

## Cloud Deployment

### Backend

The Spring Boot backend is deployed on **Render**.

### Database

The production database is hosted on **Aiven MySQL**.

### Frontend

The frontend is deployed as a **Render Static Site**.

### Deployment Flow

```text
GitHub
   │
   ├── Frontend → Render Static Site
   │
   └── Backend → Render Web Service
                      │
                      ▼
                  Aiven MySQL
```

---

## Live Application

🌐 **Frontend:**

[https://codealpha-cloud-computing-internship-zvcm.onrender.com](https://codealpha-cloud-computing-internship-zvcm.onrender.com)

🔗 **Backend:**

[https://codealpha-cloud-computing-internship.onrender.com](https://codealpha-cloud-computing-internship.onrender.com)

---

## GitHub Repository

🔗 **Repository:**

[https://github.com/jpugazholi/CodeAlpha-cloud-computing-Internship_Task1_DataRedundancyRemovalSystem](https://github.com/jpugazholi/CodeAlpha-cloud-computing-Internship_Task1_DataRedundancyRemovalSystem)

---

## Testing

The application was tested using both the frontend and Postman.

### Test Case 1 — Unique Data

Input:

```text
Hello World,vaccination test 123
```

Result:

```text
UNIQUE
```

The data is stored in the database.

### Test Case 2 — Duplicate Data

Submit the same data again.

Result:

```text
REDUNDANT
```

The duplicate record is not inserted.

### Test Case 3 — Empty Data

Submit an empty value.

Result:

```text
Invalid / Empty Data
```

---

## Security

* Database credentials are managed using environment variables in cloud deployment.
* Sensitive passwords should not be committed to GitHub.
* Cloud database connections use secure connections.
* CORS is configured for frontend-backend communication.

---

## Future Enhancements

* Advanced duplicate detection algorithms.
* Data similarity checking.
* False-positive classification improvements.
* Admin dashboard.
* Data analytics and reporting.
* Authentication and authorization.
* Automated cloud monitoring.
* CI/CD pipeline.
* Improved validation rules.
* Large-scale dataset processing.

---

## Learning Outcomes

This project provided practical experience in:

* Java development
* Spring Boot
* REST API development
* Spring Data JPA
* MySQL database integration
* Docker containerization
* Cloud deployment
* Render
* Aiven Cloud
* Git and GitHub
* Frontend-backend integration
* API testing
* Cloud-based application architecture

---

## Internship

**Program:** CodeAlpha Cloud Computing Internship

**Task:** Task 1 – Data Redundancy Removal System

---

## Author

**PUGAZHOLI J**

B.Tech Information Technology Student
J. J. College of Engineering and Technology

---

## License

This project is developed for **educational and internship purposes**.

---

## Acknowledgement

This project was developed as part of the **CodeAlpha Cloud Computing Internship** to gain practical experience in cloud application development, deployment, database integration, and DevOps practices.
