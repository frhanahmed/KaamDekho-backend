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

The project's Maven configuration specifies Java 21, Spring Boot 4.1.1, Spring Web MVC, Spring Data JPA, PostgreSQL, and Lombok. :contentReference[oaicite:15]{index=15}

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

The entity is mapped using JPA and uses `postId` as its primary key. :contentReference[oaicite:16]{index=16}

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

These endpoints are implemented in `JobRestController`. :contentReference[oaicite:17]{index=17}

---

## 🔍 Search Functionality

KaamDekho supports keyword-based job searching.

The backend exposes:

```text
GET /jobPosts/keyword/{keyword}
```

The search checks both:

```text
postProfile
postDesc
```

using a Spring Data JPA derived query:

```text
findByPostProfileContainingOrPostDescContaining(...)
```

This allows users to search for jobs using either the job profile or description. :contentReference[oaicite:18]{index=18}

---

## ➕ Create Job Post

A new job post can be created using:

```text
POST /jobPost
```

Example request body:

```json
{
  "postId": 12,
  "postProfile": "Java Developer",
  "postDesc": "Develop scalable backend applications.",
  "reqExperience": 3,
  "postTechStack": [
    "Java",
    "Spring Boot",
    "PostgreSQL",
    "Docker"
  ]
}
```

The controller receives the request and passes the entity to the service layer, which persists it using the JPA repository. :contentReference[oaicite:19]{index=19}

---

## ✏️ Update Job Post

Existing job posts can be updated using:

```text
PUT /jobPost
```

The service layer uses the repository's `save()` method to persist the updated entity. :contentReference[oaicite:20]{index=20}

---

## 🗑️ Delete Job Post

A job post can be removed using:

```text
DELETE /jobPost/{postId}
```

The service layer delegates the deletion to Spring Data JPA:

```text
jobRepo.deleteById(postId)
```

:contentReference[oaicite:21]{index=21}

---

## 📚 Sample Data

The backend contains a `/load` endpoint that inserts predefined job posts into the database.

The sample dataset includes roles such as:

* Java Developer
* Python Developer
* React Developer
* Full Stack Developer
* Machine Learning Engineer
* Data Scientist
* Software Developer
* Software Engineer
* Frontend Developer
* Backend Developer
* Node.js Developer

The sample records contain job descriptions, required experience, and technical stacks. :contentReference[oaicite:22]{index=22}

---

## 🌐 CORS Configuration

The backend allows requests from the deployed KaamDekho frontend and local development environments.

Configured frontend origins include:

```text
http://localhost:3000
https://kaam-dekho.vercel.app
```

This allows the React application to communicate with the Spring Boot API from the browser. :contentReference[oaicite:23]{index=23}

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

The repository follows a clear Spring Boot layered structure with controller, model, repository, service, and configuration resources. :contentReference[oaicite:24]{index=24}

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

This allows Hibernate to automatically update the database schema based on the entity mappings. :contentReference[oaicite:25]{index=25}

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

The frontend uses Axios to consume the backend endpoints. :contentReference[oaicite:26]{index=26}

---

## ☁️ Deployment

The backend is deployed on **Render**.

### Production API

https://kaamdekho-backend-ct8k.onrender.com

The repository also includes a `Dockerfile`, allowing the application to be containerized for deployment. :contentReference[oaicite:27]{index=27}

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

This separation keeps the API layer, business/service logic, and persistence logic organized independently. :contentReference[oaicite:28]{index=28}

---

## 🎯 Use Cases

The backend can support:

* 💼 Job-board applications
* 🔎 Job search systems
* 📝 Job-post management
* 🗃️ CRUD-based applications
* 🌐 REST API demonstrations
* ☕ Spring Boot portfolio projects
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
* Database indexing
* DTO-based API responses
* Global exception handling
* API validation
* Unit and integration tests
* Swagger/OpenAPI documentation
* Improved environment configuration
* CI/CD automation

---

## 👨‍💻 Project

**KaamDekho Backend** is the server-side component of the KaamDekho full-stack job-post management application.

It demonstrates the integration of:

```text
Java
   +
Spring Boot
   +
Spring Data JPA
   +
PostgreSQL
   +
REST APIs
   +
React Frontend
```

---

## ⭐ Links

### Primary Portfolio Repository

The **frontend repository is the primary KaamDekho repository for portfolio/resume purposes**:

https://github.com/frhanahmed/KaamDekho-frontend

### Frontend

https://kaam-dekho.vercel.app/

### Backend Repository

https://github.com/frhanahmed/KaamDekho-backend

### Live Backend API

https://kaamdekho-backend-ct8k.onrender.com
