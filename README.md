# 🧑‍💼 Job Board Web Application

A full-featured **Job Board Backend** built with **Spring Boot**, **JWT-based Authentication**, **MySQL**, and **Docker**. Includes admin control, recruiter job posting, and secure user access with role-based authorization.

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **Spring Data JPA + Hibernate**
- **MySQL**
- **Docker & Docker Compose**
- **Maven Wrapper (`mvnw`)**

---

## 👤 Roles and Access

| Role       | Capabilities                                               |
|------------|------------------------------------------------------------|
| `USER`     | Register, login, view jobs                                 |
| `RECRUITER`| Post jobs                                                  |
| `ADMIN`    | Manage users (GET all, GET by ID, DELETE), system monitor  |

---

## 🔐 Authentication & Authorization

- **JWT Token-based Auth**
- **Secure Endpoints** using Spring Security
- **Role-based Access Control** (via `@PreAuthorize` and config rules)

---

## 📦 Features

✅ User registration & login  
✅ JWT generation & verification  
✅ Recruiters can post jobs  
✅ Admins can fetch and delete users  
✅ Dockerized MySQL & backend  
✅ RESTful API structure  
✅ Clean code with layered architecture

---

## 📁 Project Structure

src
└── main
├── java/com/example/jobboard
│ ├── controller
│ ├── model
│ ├── repository
│ ├── service
│ └── config (JWT/Security)
└── resources
└── application.properties

---

## 🐳 Docker Setup

> Requires: Docker & Docker Compose installed
> ```bash
# Start MySQL and Spring Boot backend
docker-compose up --build
Access API at: http://localhost:8080

🔧 Local Setup
Requires: Java 17+, Maven
# Clone the repo
git clone https://github.com/yourusername/job-board-backend.git
cd job-board-backend

# Start the app
./mvnw spring-boot:run

##🛠️ Endpoints

🔑 Auth
POST /api/auth/register

POST /api/auth/login

👥 Admin
GET /api/users — Get all users (Admin only)
GET /api/users/{id} — Get user by ID
DELETE /api/users/{id} — Delete user

💼 Jobs
POST /api/jobs — Post a job (Recruiter)
GET /api/jobs — View jobs

📸 Screenshots
Feature	Preview
JWT Login	<img width="2548" height="1382" alt="JWT Login via Postman" src="https://github.com/user-attachments/assets/08169c31-4cf1-477c-b480-6d98063ffcd1" />

JWT REGISTER <img width="2574" height="1440" alt="JWT Register via Postman" src="https://github.com/user-attachments/assets/006b0a87-8322-4833-b907-46db929a4610" />

DATABASE PREVIEW <img width="1074" height="525" alt="DataBase (users, user_roles, jobs)" src="https://github.com/user-attachments/assets/5654388b-ece9-4c11-b46b-eab086dbab93" />

Docker <img width="2547" height="1440" alt="Docker containers running" src="https://github.com/user-attachments/assets/f1f5873d-8a44-4777-9f96-f3b6c5f1eada" />

LOCALLY RUNNING <img width="2581" height="1439" alt="Project Running Locally" src="https://github.com/user-attachments/assets/004e0ab4-b976-4827-9602-715efb14b962" />


📚 Future Improvements
Pagination and filtering for jobs
User profile & resume upload
Email notifications
Swagger API docs

🧑‍💻 Author
MUHAMMAD JAHANGIR ILYAS
📧 JAHANGIR1ILYAS@GMAIL.COM
