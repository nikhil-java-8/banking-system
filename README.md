# 🏦 Banking Management System (Spring Boot)

## 📌 Overview

This project is a **Backend Banking Application** developed using **Java and Spring Boot**.
It simulates real-world banking operations like account management, transactions, and secure authentication.

The system is designed with **clean architecture, proper layering, and REST APIs**, making it suitable for real-world backend development.

---

## 🚀 Features

* 🔐 Secure Login with Token-based Authentication (valid for 1 hour)
* 👤 Create and Manage Customer Accounts
* 💰 Deposit Money
* 💸 Withdraw Money
* 🔄 Transfer Funds Between Accounts
* 📜 View Transaction History
* 🧾 Audit Logging for all operations
* ⚠️ Global Exception Handling

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Database:** MySQL
* **ORM:** Hibernate (Spring Data JPA)
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 📂 Project Structure

```id="pnmcc3"
com.nikhil
│── controller      # REST Controllers (API Layer)
│── service         # Business Logic
│── repository      # Database Access Layer
│── entity          # JPA Entities
│── dto             # Request/Response DTOs
│── exception       # Global Exception Handling
│── config          # Security & Configurations
```

---

## 🔑 API Endpoints

### 🔐 Authentication

* `POST /login` → Generate Token

### 👤 Account APIs

* `POST /accounts` → Create Account
* `GET /accounts/{id}` → Get Account Details

### 💰 Transaction APIs

* `POST /deposit`
* `POST /withdraw`
* `POST /transfer`

### 📜 Transaction History

* `GET /transactions/{accountId}`

---

## 🔒 Security Flow

1. User logs in using credentials
2. System generates a token
3. Token is valid for **1 hour**
4. All APIs require token in request header
5. Unauthorized access is blocked

---
## Banking System Flow Diagram 🚀

This diagram represents the complete backend flow of the banking system, 
including authentication, account management, transactions, and audit logging.
<img width="1536" height="1024" alt="ChatGPT Image Mar 29, 2026, 10_05_19 AM" src="https://github.com/user-attachments/assets/59e19dd3-5dfa-4c2f-9d00-eaffce5ba7a1" />


## 🗄️ Database Design

* **Customer**
* **Account**
* **Transaction**
* **AuditLog**

---

## ⚙️ How to Run

### 1️⃣ Clone the Repository

```id="md5n4n"
git clone https://github.com/nikhil-java-8/banking-system.git
```

### 2️⃣ Configure Database

Update `application.properties`:

```id="lgsmba"
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3️⃣ Run the Application

```id="y06yv3"
mvn spring-boot:run
```

---

## 🧪 Testing

* Use Postman to test APIs
* Import collection (if available)

---

## 📸 Screenshots

<img width="1920" height="1080" alt="Screenshot (98)" src="https://github.com/user-attachments/assets/2b4ad8e8-579e-4d8a-a18e-5d88be01d362" />

---

## 💡 Future Enhancements

* Role-Based Access (Admin/User)
* JWT Authentication
* Email Notifications
* Docker Deployment
* Microservices Architecture

---
## 👨‍💻 Author

**Nikhil Dagadkar**
Backend Developer | Java | Spring Boot

---

## ⭐ Support

If you like this project, please ⭐ the repository!

---
