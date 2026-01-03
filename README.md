# The Green Basket - Grocery Management System

The Green Basket is a Java-based desktop application designed for managing a green grocery store. It implements core Object-Oriented Programming (OOP) concepts to handle users, products, and inventory with data persistence using CSV files.

## Features

- **User Authentication**: Secure login system for different user roles.
- **Role-Based Access Control**:
  - **Store Manager**: Full access to create users, monitor inventory, and manage products.
  - **Sales Assistant**: Access to view products, add new items, and search by category.
- **Inventory Management**: Track stock levels and product details.
- **CSV Data Persistence**: All data is stored in `data/products.csv` and `data/users.csv` for simple, lightweight persistence.

## System Architecture

The project follows a modular package structure:
- `user`: Contains user hierarchy (`User`, `SalesAssistant`, `StoreManager`).
- `model`: Contains core business entities (`Product`, `Inventory`).
- `FileHandler`: Handles all CSV-related I/O operations.
- `MainApp`: Entry point for the application.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.

### Installation & Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kavishka-CodXlab/OOP-Assesment.git
   cd OOP-Assesment
   ```

2. **Navigate to the source folder**:
   ```bash
   cd TheGreenBasket
   ```

3. **Compile the project**:
   ```bash
   javac MainApp.java model/*.java user/*.java
   ```

4. **Run the application**:
   ```bash
   java MainApp
   ```

## Default Credentials

| Role | Username | Password |
| :--- | :--- | :--- |
| **Store Manager** | `admin` | `admin123` |
| **Sales Assistant** | `kavishka` | `pwd123` |

## Data Files

Data is persisted in the `data/` directory:
- `data/products.csv`: Stores product details (ID, Name, Category, Price, Quantity).
- `data/users.csv`: Stores user accounts and roles.

---
Developed as part of an OOP Assessment.
