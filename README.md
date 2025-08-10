# URL Shortener Application

A simple and efficient URL shortening service built with **Java** and **Spring Boot**.  
It allows users to generate short, shareable links from long URLs and redirect them quickly.

## 🚀 Features
- Create short URLs from long ones
- Redirect to the original link when accessed
- Optional expiration time for links
- REST API endpoints for easy integration
- Backend built with **Spring Boot**
- Data stored in **PostgreSQL**

## 📌 Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA / Spring Data Postgresql**
- **[Postgresql]**
- **Maven 

## 📂 Project Structure

src/
├── main/
│ ├── java/
│ │ └── uz.learning.urlshortener/
│ │ ├── config/
│ │ ├── controller/
│ │ ├── dto/
│ │ ├── entity/
│ │ ├── mapper/
│ │ ├── repository/
│ │ ├── service/
│ │ ├── utils/
│ └── resources/
│ ├── application.yml
│ └────────────────────────


## 📚 API Endpoints

### Create Short URL
```http
POST /api/url/shorter
Content-Type: application/json

{
  "description":"Spring CLoud Documentation Url"
  "path": "https://localhosst:8080/api/url/shorter](https://docs.spring.io/spring-cloud-build/docs/4.0.6/reference/html"
  "expired_at": LocalDateTime
}
Response:
{
  "code": "http://localhost:8080/abc123"
}


# Clone the repository
git clone https://github.com/Otabek0811/urlShorter_springboot_java.git
cd urlShorter_springboot_java

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run



