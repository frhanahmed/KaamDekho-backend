# ⚙️ KaamDekho — Backend

KaamDekho Backend is a RESTful backend service for the KaamDekho job-post management application.

It is built using **Java 21, Spring Boot, Spring Data JPA, and PostgreSQL** and provides APIs for creating, retrieving, updating, deleting, and searching job postings.

The backend follows a layered architecture separating the **REST controller, service layer, repository layer, and entity/model layer**.

---

## 🌐 Project Links

🚀 **Live Frontend:**  
https://kaam-dekho.vercel.app/

📂 **Frontend GitHub Repository:**  
https://github.com/frhanahmed/KaamDekho-frontend

📂 **Backend GitHub Repository:**  
https://github.com/frhanahmed/KaamDekho-backend

🔗 **Live Backend API:**  
https://kaamdekho-backend-ct8k.onrender.com

---

## 🚀 Key Features

* **RESTful API:** Provides HTTP endpoints for job-post management.
* **Full CRUD Operations:** Create, retrieve, update, and delete job postings.
* **Keyword Search:** Search job posts using job profile or description keywords.
* **PostgreSQL Integration:** Uses PostgreSQL as the persistent relational database.
* **Spring Data JPA:** Provides repository-based database operations.
* **Layered Architecture:** Separates controller, service, repository, and model responsibilities.
* **CORS Configuration:** Allows communication with the deployed React frontend.
* **Sample Data Loading:** Includes a `/load` endpoint for loading predefined job-post records.
* **JPA Entity Mapping:** Job posts are represented as persistent JPA entities.
* **Production Deployment:** Backend is deployed on Render.

---

## 🏗️ Backend Architecture

The backend follows a layered architecture:

```text
                  ┌───────────────────────┐
                  │     React Frontend    │
                  │        Vercel         │
                  └───────────┬───────────┘
                              │
                              │ HTTP / REST
                              ▼
                  ┌───────────────────────┐
                  │    REST Controller    │
                  │ JobRestController.java│
                  └───────────┬───────────┘
                              │
                              ▼
                  ┌───────────────────────┐
                  │     Service Layer     │
                  │    JobService.java    │
                  └───────────┬───────────┘
                              │
                              ▼
                  ┌───────────────────────┐
                  │   Repository Layer    │
                  │      JobRepo.java     │
                  └───────────┬───────────┘
                              │
                              │ JPA
                              ▼
                  ┌───────────────────────┐
                  │     PostgreSQL DB     │
                  └───────────────────────┘
```

---

## 🛠️ Technology Stack

### Backend

* **Java 21** — Core programming language.
* **Spring Boot 4.1.1** — Backend application framework.
* **Spring Web MVC** — REST API development.
* **Spring Data JPA** — Database persistence and repository abstraction.
* **PostgreSQL** — Relational database.
* **Lombok** — Reduces boilerplate code in Java entities.
* **Maven** — Dependency management and build automation.
* **Docker** — Containerization support through the project's Dockerfile.

The project's Maven configuration specifies Java 21, Spring Boot 4.1.1, Spring Web MVC, Spring Data JPA, PostgreSQL, and Lombok.

---

## 📋 JobPost Entity

The primary database entity is `JobPost`.

It contains:

```text
postId
postProfile
postDesc
reqExperience
postTechStack
```

The entity is mapped using JPA and uses `postId` as its primary key.

### Entity Structure

| Field | Type | Description |
|---|---|---|
| `postId` | `int` | Unique job-post identifier |
| `postProfile` | `String` | Job profile/title |
| `postDesc` | `String` | Job description |
| `reqExperience` | `int` | Required experience in years |
| `postTechStack` | `List<String>` | Required technical skills |

---

## 🔌 REST API Endpoints

The backend exposes the following endpoints:

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/jobPosts` | Retrieve all job posts |
| `GET` | `/jobPost/{postId}` | Retrieve a specific job post |
| `POST` | `/jobPost` | Create a new job post |
| `PUT` | `/jobPost` | Update an existing job post |
| `DELETE` | `/jobPost/{postId}` | Delete a job post |
| `GET` | `/jobPosts/keyword/{keyword}` | Search jobs by keyword |
| `GET` | `/load` | Load predefined sample job data |

These endpoints are implemented in `JobRestController`.

---

## 🌐 CORS Configuration

The backend allows requests from the deployed KaamDekho frontend and local development environments.

Configured frontend origins include:

```text
http://localhost:3000
https://kaam-dekho.vercel.app
```

This allows the React application to communicate with the Spring Boot API from the browser.

---

## 🗂️ Project Structure

```text
KaamDekho-backend/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── frhanahmed/
│   │   │           └── jobApp_backend/
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── JobRestController.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── JobPost.java
│   │   │               │
│   │   │               ├── repo/
│   │   │               │   └── JobRepo.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── JobService.java
│   │   │               │
│   │   │               └── JobAppBackendApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .gitignore
└── README.md
```

The repository follows a clear Spring Boot layered structure with controller, model, repository, service, and configuration resources.

---

## 🗄️ Database Configuration

The application uses PostgreSQL.

Database configuration is provided through environment variables:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
```

The application also uses:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

This allows Hibernate to automatically update the database schema based on the entity mappings.

---

## 🔐 Environment Variables

Before running the backend locally, configure:

| Variable | Description |
|---|---|
| `DB_URL` | PostgreSQL database connection URL |
| `DB_USERNAME` | PostgreSQL database username |
| `DB_PASSWORD` | PostgreSQL database password |

Example:

```env
DB_URL=jdbc:postgresql://localhost:5432/kaamdekho
DB_USERNAME=postgres
DB_PASSWORD=your_password
```

> **Important:** Never commit real database credentials to GitHub.

---

## ⚙️ Local Installation & Setup

### 1. Prerequisites

Make sure you have:

* **Java 21**
* **Maven** or Maven Wrapper
* **PostgreSQL**
* **Git**

---

### 2. Clone the Repository

```bash
git clone https://github.com/frhanahmed/KaamDekho-backend.git
cd KaamDekho-backend
```

---

### 3. Configure PostgreSQL

Create a PostgreSQL database:

```sql
CREATE DATABASE kaamdekho;
```

Then configure the required environment variables:

```env
DB_URL=jdbc:postgresql://localhost:5432/kaamdekho
DB_USERNAME=postgres
DB_PASSWORD=your_password
```

---

### 4. Run the Application

#### Windows

```bash
mvnw.cmd spring-boot:run
```

#### macOS / Linux

```bash
./mvnw spring-boot:run
```

Alternatively, if Maven is installed globally:

```bash
mvn spring-boot:run
```

---

## 🔗 Connecting the Frontend

Once the backend is running, the frontend can communicate with it through the REST API.

For local development, the frontend API base URL can point to:

```text
http://localhost:8080
```

For the deployed application, the frontend currently communicates with:

```text
https://kaamdekho-backend-ct8k.onrender.com
```

The frontend uses Axios to consume the backend endpoints.

---

## ☁️ Deployment

The backend is deployed on **Render**.

### Production API

https://kaamdekho-backend-ct8k.onrender.com

The repository also includes a `Dockerfile`, allowing the application to be containerized for deployment.

---

## 🧩 Backend Request Flow

A typical request follows this path:

```text
Client
  │
  │ HTTP Request
  ▼
JobRestController
  │
  │ calls
  ▼
JobService
  │
  │ calls
  ▼
JobRepo
  │
  │ Spring Data JPA
  ▼
PostgreSQL
  │
  │ Result
  ▼
JobRepo
  │
  ▼
JobService
  │
  ▼
JobRestController
  │
  │ JSON Response
  ▼
Client
```

This separation keeps the API layer, business/service logic, and persistence logic organized independently.

---

## 🎯 Use Cases

The backend can support:

* 💼 Job-board applications
* 🔎 Job search systems
* 📝 Job-post management
* 🗃️ CRUD-based applications
* 🌐 REST API demonstrations
* ☕ Spring Boot projects
* 🗄️ PostgreSQL database integration projects
* 🔗 React + Spring Boot full-stack applications

---

## 🔮 Future Improvements

Potential improvements include:

* JWT-based authentication
* Role-based authorization
* Employer and applicant accounts
* Job application APIs
* Pagination and sorting
* Advanced filtering
* Job categories
* Location-based search
* Global exception handling
* API validation
* CI/CD automation
