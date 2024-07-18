# Gym Membership Management System

## Overview
This console-based application simulates a gym membership management system. It is built using Core Java, MySQL, and JDBC, allowing users to manage members, trainers, and membership plans.

## Functionalities
1. **Member Management:**
    - Add a new member
    - View member details
    - Update member information
    - Delete a member

2. **Trainer Management:**
    - Add a new trainer
    - View trainer details
    - Update trainer information
    - Delete a trainer

3. **Membership Plan Management:**
    - Create a new membership plan
    - View plan details
    - Update plan information
    - Delete a membership plan

## Database Schema

### Member Table
| Column Name   | Data Type         | Constraints          |
|---------------|--------------------|-----------------------|
| `member_id`   | `INT`              | `AUTO_INCREMENT, PRIMARY KEY` |
| `name`        | `VARCHAR(255)`     | `NOT NULL`            |
| `email`       | `VARCHAR(255)`     | `NOT NULL, UNIQUE`    |
| `phone_number`| `VARCHAR(20)`      | `NOT NULL`            |
| `address`     | `TEXT`             |                       |

### Trainer Table
| Column Name   | Data Type         | Constraints          |
|---------------|--------------------|-----------------------|
| `trainer_id`  | `INT`              | `AUTO_INCREMENT, PRIMARY KEY` |
| `name`        | `VARCHAR(255)`     | `NOT NULL`            |
| `email`       | `VARCHAR(255)`     | `NOT NULL, UNIQUE`    |
| `phone_number`| `VARCHAR(20)`      | `NOT NULL`            |
| `speciality`  | `VARCHAR(255)`     |                       |

### MembershipPlan Table
| Column Name      | Data Type         | Constraints          |
|------------------|--------------------|-----------------------|
| `plan_id`        | `INT`              | `AUTO_INCREMENT, PRIMARY KEY` |
| `name`           | `VARCHAR(255)`     | `NOT NULL`            |
| `duration_months`| `INT`              | `NOT NULL`            |
| `price_per_month`| `DECIMAL(10, 2)`   | `NOT NULL`            |



## Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK):**
    - Install JDK 8 or later. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use an open-source version like [OpenJDK](https://openjdk.java.net/).

2. **MySQL Server:**
    - Ensure MySQL Server is installed and running. You can download it from [MySQL's website](https://dev.mysql.com/downloads/mysql/).

3. **MySQL Connector/J:**
    - Download the MySQL Connector/J JDBC driver from [MySQL's website](https://dev.mysql.com/downloads/connector/j/).
    - Place the `mysql-connector-java-8.0.26.jar` file in the `lib` directory of the project.

### 1. Clone the Repository

Open a terminal or command prompt and run:
```bash
git clone https://github.com/yourusername/gym-management-system.git
cd gym-management-system
```
### 2.Set Up the Database
   Open MySQL Workbench or your preferred MySQL client.

Connect to your MySQL server.

Execute the SQL scripts provided below to create the required tables:

### 3. Configure Database Connection
   Open src/gymmanagement/DBConnection.java in your project directory.

Update the following constants with your MySQL database credentials:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
private static final String DB_USER = "your_username";
private static final String DB_PASSWORD = "your_password";
```
### 4. Compile the Project
   Open a terminal or command prompt.

Navigate to the src directory of your project.

Compile the Java files using the following command:
```bash
javac -cp "lib/mysql-connector-java-8.0.26.jar" gymmanagement/*.java
```
### 5. Run the Application
Execute the main class using the following command:
 ```bash
 java -cp "lib/mysql-connector-java-8.0.26.jar;src" gymmanagement.GymManagementApp
```
## Purpose

This project serves as a comprehensive tool for gym administrators to:

- **Manage Members**: Add, view, update, and delete gym members. Keep track of member details such as contact information and address.
- **Manage Trainers**: Add, view, update, and delete trainers. Store and manage trainer information including specialization and contact details.
- **Manage Membership Plans**: Create, view, update, and delete membership plans. Define various plans with details like duration and pricing.

## Features
1. **Member Management**:
- **Add New Member**: Register new members with essential details.
- **View Member Details**: Access and view the information of existing members.
- **Update Member Information**: Modify member details as needed.
- **Delete Member**: Remove members from the system.

2. **Trainer Management**:
    - **Add New Trainer**: Register new trainers with their details and specialization.
    - **View Trainer Details**: Access and view the information of existing trainers.
    - **Update Trainer Information**: Modify trainer details as needed.
    - **Delete Trainer**: Remove trainers from the system.

3. **Membership Plan Management**:
    - **Create New Membership Plan**: Define new membership plans with a name, duration, and price.
    - **View Plan Details**: Access and view the details of existing membership plans.
    - **Update Plan Information**: Modify membership plan details as required.
    - **Delete Membership Plan**: Remove plans from the system.

## Use Case

This project is ideal for:

- **Gym Administrators**: To efficiently manage gym operations and track members, trainers, and membership plans.
- **Developers**: As a practical example of using Core Java and JDBC with a MySQL database.
- **Students**: To understand the integration of Java with databases and practice building a complete console application.

## How It Works

1. **Database Connection**: The application connects to a MySQL database to perform CRUD (Create, Read, Update, Delete) operations.
2. **Console Interface**: Users interact with the application through a console-based menu system.
3. **Data Management**: The system allows for seamless management of gym members, trainers, and membership plans.
