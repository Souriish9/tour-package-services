# Tour Package Service – Documentation

## 1. Pre-requisites

Before setting up and running the project, ensure the following are installed on your system:

- **Java 17+**
- **Maven 3.9+**
- **Docker** (latest stable version)
- **Docker Compose**
- **Git**
- **Postman** or **cURL** for API testing

---

## 2. Clone & Run Locally

### 2.1 Clone the Repository
```bash
git clone <your-git-repo-url>
cd tour-package-service
```
- Please make sure to uncomment the correct DB configuration from application.properties file and Create a new Database: tourdb

```bash
CREATE DATABASE tourdb
```

### 2.2 Run Locally (Without Docker)
```bash
mvn clean install
mvn spring-boot:run
```
##### The service will be available:
```adruino
http://localhost:8081
```

### 2.3 Run with Docker (using docker-compose.yaml)

- Instead of running locally, you can run everything in containers.

#### Step 1 - Build and Push Docker Image
```bash
docker build -t your-dockerhub-username/tour-package-service:latest .
docker push your-dockerhub-username/tour-package-service:latest
```

#### Step 2 - Run with Docker Compose
```bash
docker-compose up -d
```

### Step 3 - Check Running Container
```bash
docker ps
```

## 3. Modify Database Settings
##### The application.properties file is located at:
```css
src/main/resources/application.properties
```
#### Update DB configurations as per your environment:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tourdb
spring.datasource.username=your_pg_username
spring.datasource.password=your_pg_pwd
```

## 4. REST API Documentation
#### The project is integrated with Swagger/OpenAPI for interactive API documentation.
##### Once the service is running, access the Swagger UI at:
```bash
http://localhost:8081/swagger-ui.html
```

## 5. Project Structure
```bash
tour-package-service/
 ├── src/main/java/...   # Java source code
 ├── src/main/resources/ # Config files (application.properties)
 ├── Dockerfile          # Docker build file
 ├── docker-compose.yaml # Docker Compose setup
 └── pom.xml             # Maven dependencies & build config
 
```
## 6. Postman Collection
##### Postman Collection present inside postman folder.