# 📋 Customer CRUD — Java Backend Project

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)](https://www.java.com)
[![GSON](https://img.shields.io/badge/GSON-2.x-blue?style=flat-square)](https://github.com/google/gson)
[![Architecture](https://img.shields.io/badge/Architecture-MVC-green?style=flat-square)]()
[![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)]()

A Java backend CRUD application for customer management, built with MVC architecture, JSON persistence using GSON, and business validation layers.

> 🚀 **Next step:** Migrating from JSON persistence to relational database using JDBC.

---

## 📌 About the Project

This project was built as a study application to practice real-world backend development concepts in Java. It simulates a customer registration system where you can create, read, update, and delete customer records — all persisted in a JSON file using the GSON library.

The focus was on applying **clean architecture** principles, separating responsibilities across layers and keeping business rules isolated from the interface layer.

---

## ✨ Features

- ✅ Register new customers with CPF, name, age, and address
- ✅ List all registered customers
- ✅ Search customer by CPF
- ✅ Update customer name
- ✅ Remove customer by CPF
- ✅ JSON data persistence with GSON (data survives application restarts)
- ✅ Business validations: CPF required, age between 0 and 120
- ✅ Exception handling with descriptive error messages

---

## 🏗️ Architecture — MVC Pattern

```
src/
└── br/com/crud_clientes/
    ├── Main.java                    # Entry point — user interface (View)
    ├── controller/
    │   └── ClienteController.java   # Business logic & validation (Controller)
    ├── model/
    │   ├── Cliente.java             # Customer entity (Model)
    │   └── Endereco.java            # Address entity (Model)
    └── repository/
        └── ClienteRepository.java   # JSON persistence layer (Repository)
```

### Layer responsibilities

| Layer | Responsibility |
|---|---|
| **Main (View)** | User interaction via terminal — menus and input collection |
| **Controller** | Business rules, validations, and orchestration |
| **Model** | Data entities — Customer and Address |
| **Repository** | Read and write operations to JSON file via GSON |

---

## 🛠️ Technologies

| Technology | Usage |
|---|---|
| **Java 17+** | Main programming language |
| **GSON** | JSON serialization/deserialization for data persistence |
| **MVC Pattern** | Architectural pattern for separation of concerns |
| **OOP** | Encapsulation, classes, and objects |
| **Exception Handling** | Business rule violations and I/O errors |

---

## ✅ Business Validations

Validations are applied inside the `ClienteController` layer — keeping the business rules separate from the UI:

```java
// CPF cannot be null or empty
if (cpf == null || cpf.isEmpty()) {
    throw new Exception("CPF cannot be empty");
}

// Age must be between 0 and 120
if (idade < 0 || idade > 120) {
    throw new Exception("Invalid age");
}

// Duplicate CPF check before registration
if (controller.buscarCliente(cpfDigitado) != null) {
    System.out.println("Customer already registered");
}
```

---

## 🚀 How to Run

**Prerequisites:** Java 17+ and GSON dependency configured

```bash
# Clone the repository
git clone https://github.com/Joaovitorcgds/crud-clientes-java.git

# Navigate to project folder
cd crud-clientes-java

# Compile
javac -cp .:gson-2.13.2.jar src/br/com/crud_clientes/Main.java

# Run
java -cp .:gson-2.13.2.jar br.com.crud_clientes.Main
```

### Application menu

```
1 - Register customer
2 - List customers
3 - Search customer
4 - Edit customer
5 - Remove customer
0 - Exit
```

---

## 🗺️ Roadmap

- [x] MVC architecture
- [x] JSON persistence with GSON
- [x] Business validations
- [x] Exception handling
- [ ] Migrate persistence to relational database with JDBC
- [ ] Expose operations as REST API with Spring Boot
- [ ] Add unit tests with JUnit

---

## 👨‍💻 Author

**João Vitor Costa**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-joaovitorcgds-blue?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/joaovitorcgds/)
[![GitHub](https://img.shields.io/badge/GitHub-Joaovitorcgds-black?style=flat-square&logo=github)](https://github.com/Joaovitorcgds)
