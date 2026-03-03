# Stew Task App

A web application for managing an ongoing list of tasks. Built with Java and Spring Boot, containerized with Docker Compose.

---

## Features

- Create new tasks
- Edit existing tasks
- Mark tasks as complete
- Delete tasks

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| Framework | Spring Boot |
| Build Tool | Maven |
| Database | H2 (in-memory) |
| Frontend | React |
| Containerization | Docker & Docker Compose |

---

## Prerequisites

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/) (or use the included `mvnw` wrapper)
- [Docker](https://www.docker.com/) & [Docker Compose](https://docs.docker.com/compose/)

---

## Getting Started

### Run the Frontend with Docker Compose

```bash
git clone https://github.com/MStew64/stew-task-app.git
cd stew-task-app
docker-compose up --build
```

The frontend will be available at `http://localhost:3000`.

### Run the Backend locally with Maven

```bash
./mvnw spring-boot:run
```

> On Windows, use `mvnw.cmd spring-boot:run`

The backend API will be available at `http://localhost:8080`.

> **Note:** This app uses an H2 in-memory database. Data will not persist between application restarts.

---

## Project Structure

```
stew-task-app/
├── src/
│   ├── main/
│   │   ├── java/        # Application source code
│   │   └── resources/   # Configuration files
│   └── test/            # Unit and integration tests
├── docker-compose.yml   # Docker Compose configuration
├── pom.xml              # Maven dependencies and build config
└── mvnw / mvnw.cmd      # Maven wrapper scripts
```

---

## Configuration

Application settings (e.g., database connection, port) can be found in:

```
src/main/resources/application.properties
```

---

