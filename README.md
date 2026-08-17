# Data Redundancy Removal System

A web-based **Data Redundancy Removal System** that identifies and classifies incoming data as **UNIQUE**, **REDUNDANT**, or **FALSE_POSITIVE**.

The system validates new data before storing it in the database and prevents duplicate records from being inserted.

---

## 🎯 Objective

The main objective of this project is to identify and classify data as:

* **UNIQUE** – New data that does not already exist in the database.
* **REDUNDANT** – Data that already exists in the database.
* **FALSE_POSITIVE** – Empty or invalid data that should not be stored.

---

## ✨ Features

* Add and validate new data
* Detect duplicate data
* Case-insensitive duplicate detection
* Prevent redundant data from being stored
* Identify empty input as `FALSE_POSITIVE`
* Store valid unique data in MySQL
* REST API for data validation
* Interactive frontend UI
* Status-based result display
* CORS enabled for frontend-backend communication

---

## 🛠️ Technologies Used

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL

### Frontend

* HTML
* CSS
* JavaScript

### API Testing

* Thunder Client

### Version Control

* Git
* GitHub

---

## 📁 Project Structure

```text
data-redundancy-removal-system/
│
├── frontend/
│   ├── index.html
│   ├── script.js
│   └── style.css
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── codealpa/
│   │   │           └── redundancy/
│   │   │               ├── controller/
│   │   │               │   └── DataEntryController.java
│   │   │               │
│   │   │               ├── entity/
│   │   │               │   └── DataEntry.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── DataEntryRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── DataEntryService.java
│   │   │               │
│   │   │               └── DataRedundancyRemovalSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 🔄 System Workflow

```text
User enters data
       ↓
Frontend sends request
       ↓
Spring Boot REST API
       ↓
Data Validation
       ↓
Is input empty?
   ↓              ↓
 YES              NO
 ↓                ↓
FALSE_       Check database
POSITIVE           ↓
             Data already exists?
                ↓          ↓
               YES         NO
                ↓           ↓
            REDUNDANT     UNIQUE
                            ↓
                   Save to database
```

---

## 🔌 REST API

### Add Data

**Method:**

```text
POST
```

**Endpoint:**

```text
/api/data
```

**Example Request:**

```text
http://localhost:8080/api/data?data=Hello World
```

---

## ✅ Unique Data

When completely new data is entered, the system stores it in the database and returns:

```json
{
  "data": "Hello World",
  "status": "UNIQUE",
  "id": 1
}
```

---

## ⚠️ Redundant Data

When the same data already exists, the system identifies it as redundant and does not create a new database record.

Example:

```json
{
  "data": "hello world",
  "status": "REDUNDANT",
  "id": null
}
```

The system also performs **case-insensitive duplicate detection**.

For example:

```text
Hello World
HELLO WORLD
hello world
```

These are treated as the same data.

---

## ❌ False Positive

Empty or invalid input is classified as `FALSE_POSITIVE` and is not stored in the database.

Example:

```json
{
  "data": "",
  "status": "FALSE_POSITIVE",
  "id": null
}
```

---

## 🗄️ Database

The project uses **MySQL**.

### Database

```text
redundancy_db
```

### Table

```text
data_entries
```

### Columns

| Column   | Description         |
| -------- | ------------------- |
| `id`     | Unique identifier   |
| `data`   | Input data          |
| `status` | Data classification |

Possible status values:

```text
UNIQUE
REDUNDANT
FALSE_POSITIVE
```

Only `UNIQUE` data is stored in the database.

---

## 🧪 Testing

The REST API was tested using **Thunder Client**.

### Test Case 1 – Unique Data

Input:

```text
Hello World
```

Expected:

```text
UNIQUE
```

---

### Test Case 2 – Duplicate Data

Input:

```text
Hello World
```

again.

Expected:

```text
REDUNDANT
```

---

### Test Case 3 – Case-Insensitive Duplicate

Existing data:

```text
Hello World
```

New input:

```text
HELLO WORLD
```

Expected:

```text
REDUNDANT
```

---

### Test Case 4 – Empty Data

Input:

```text
(empty)
```

Expected:

```text
FALSE_POSITIVE
```

---

## 🎨 Frontend

The frontend provides a simple and attractive interface for entering and validating data.

The result is displayed dynamically based on the detected status.

### Status Display

* 🟢 **UNIQUE**
* 🟡 **REDUNDANT**
* 🔴 **FALSE_POSITIVE**

The frontend communicates with the Spring Boot backend using the REST API.

---

## 🚀 How to Run the Project

### Step 1 – Clone the Repository

```text
git clone https://github.com/jpugazholi/CodeAlpha-cloud-computing-Internship_Task1_DataRedundancyRemovalSystem.git
```

---

### Step 2 – Create MySQL Database

Open MySQL Workbench and create:

```sql
CREATE DATABASE redundancy_db;
```

---

### Step 3 – Configure Database

Open:

```text
src/main/resources/application.properties
```

Configure the MySQL username and password according to your local MySQL setup.

---

### Step 4 – Start the Backend

Open Command Prompt inside the project folder and run:

```text
mvnw.cmd spring-boot:run
```

The Spring Boot application runs on:

```text
http://localhost:8080
```

---

### Step 5 – Open the Frontend

Open:

```text
frontend/index.html
```

in a browser.

---

## 📌 Project Architecture

```text
Frontend
   ↓
REST API
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
```

### Controller

Handles incoming HTTP requests.

### Service

Contains the data validation and redundancy detection logic.

### Repository

Communicates with the MySQL database using Spring Data JPA.

### Entity

Represents the `data_entries` database table.

---

## 🔐 Validation Logic

The system follows this logic:

```text
Input received
      ↓
Is input empty?
   ↓        ↓
 YES        NO
 ↓          ↓
FALSE_    Check database
POSITIVE      ↓
         Already exists?
          ↓       ↓
         YES      NO
          ↓        ↓
      REDUNDANT  UNIQUE
                    ↓
               Save data
```

---

## 📊 Expected Results

| Input                         | Result         | Database         |
| ----------------------------- | -------------- | ---------------- |
| New data                      | UNIQUE         | Stored           |
| Existing data                 | REDUNDANT      | Not stored again |
| Same data with different case | REDUNDANT      | Not stored again |
| Empty data                    | FALSE_POSITIVE | Not stored       |

---

## 📈 Project Status

**Completed ✅**

The project successfully implements:

* Data validation
* Duplicate detection
* Case-insensitive duplicate detection
* False-positive classification
* MySQL database integration
* Spring Boot REST API
* Frontend integration
* Thunder Client API testing
* Git version control
* GitHub repository management

---

## 👩‍💻 Author

**Pugazholi J**

B.Tech Information Technology Student

### CodeAlpha Cloud Computing Internship – Task 1

**Project:** Data Redundancy Removal System
