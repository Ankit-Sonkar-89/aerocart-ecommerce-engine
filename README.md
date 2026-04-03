# 🛒 AeroCart: E-Commerce Database & Application Engine

## 📌 Project Overview
AeroCart started as an advanced SQL-based E-Commerce Database Management System designed to seamlessly manage customers, products, orders, and transactions for an online store. It has now been upgraded into a Full-Stack application powered by Java and Spring Boot, perfectly simulating real-world enterprise operations.

## 🚀 Technology Stack
*   **Backend:** Java 17, Spring Boot, Spring JDBC
*   **Database:** MySQL (Relational DB, Stored Procedures, Views)
*   **Frontend:** HTML5, CSS3 (Glassmorphism), Vanilla JavaScript
*   **Data Visualization:** Chart.js
*   **Security:** Real-time Email OTP via JavaMailSender

## 💡 Core Features Implemented
1. **Advanced Database Management:** Uses relational database concepts, primary/foreign keys, and complex SQL queries to maintain strict data integrity.
2. **Dynamic Stored Procedures:** Includes robust SQL procedures for order placement, automatic inventory deduction, and transaction handling, pushing business logic directly to the database layer.
3. **Headless REST APIs:** A Spring Boot engine that seamlessly connects the frontend UI to the database procedures without writing heavy application-level validations.
4. **Secure OTP Authentication:** A custom-built 2FA system that sends 6-digit dynamic OTPs to actual user emails to unlock the storefront.
5. **Admin Analytics Vault:** A restricted dashboard executing real-time SQL Views to render Total Revenue and Category-wise sales on interactive charts.

## ⚙️ Setup Instructions
1. Execute the provided `ECOMMERCE_DB.sql` script in MySQL Workbench to generate tables and Stored Procedures.
2. Update `application.properties` with your database credentials and Gmail App Password.
3. Run the Spring Boot application on Port `8084`.
4. Open `http://localhost:8084` for the Storefront and `http://localhost:8084/admin.html` for the Analytics Vault.
