# Book CRUD API Guide

## Overview
Simple CRUD (Create, Read, Update, Delete) operations for managing books.

## Base URL
```
http://localhost:8080/books/v1
```

## API Endpoints

### 1. Create a Book (POST)
**Endpoint:** `POST /books/v1`

**Request Body:**
```json
{
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```

**Response:** `201 CREATED`
```json
{
  "id": 1,
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```

---

### 2. Get All Books (GET)
**Endpoint:** `GET /books/v1`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "title": "Spring Boot in Action",
    "author": "Craig Walls"
  },
  {
    "id": 2,
    "title": "Clean Code",
    "author": "Robert C. Martin"
  }
]
```

---

### 3. Get Book by ID (GET)
**Endpoint:** `GET /books/v1/{id}`

**Example:** `GET /books/v1/1`

**Response:** `200 OK`
```json
{
  "id": 1,
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```

**Response (Not Found):** `404 NOT FOUND`

---

### 4. Update a Book (PUT)
**Endpoint:** `PUT /books/v1/{id}`

**Example:** `PUT /books/v1/1`

**Request Body:**
```json
{
  "title": "Spring Boot in Action (Updated)",
  "author": "Craig Walls"
}
```

**Response:** `200 OK`
```json
{
  "id": 1,
  "title": "Spring Boot in Action (Updated)",
  "author": "Craig Walls"
}
```

**Response (Not Found):** `404 NOT FOUND`

---

### 5. Delete a Book (DELETE)
**Endpoint:** `DELETE /books/v1/{id}`

**Example:** `DELETE /books/v1/1`

**Response:** `204 NO CONTENT`

**Response (Not Found):** `404 NOT FOUND`

---

## Testing with cURL Commands

### Create a Book
```bash
curl -X POST http://localhost:8080/books/v1 -H "Content-Type: application/json" -d "{\"title\":\"Spring Boot in Action\",\"author\":\"Craig Walls\"}"
```

### Get All Books
```bash
curl -X GET http://localhost:8080/books/v1
```

### Get Book by ID
```bash
curl -X GET http://localhost:8080/books/v1/1
```

### Update a Book
```bash
curl -X PUT http://localhost:8080/books/v1/1 -H "Content-Type: application/json" -d "{\"title\":\"Updated Title\",\"author\":\"Updated Author\"}"
```

### Delete a Book
```bash
curl -X DELETE http://localhost:8080/books/v1/1
```

---

## Running the Application

1. Make sure PostgreSQL is running on localhost:5432
2. Create a database named `crud_db`
3. Run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or on Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

4. The application will start on http://localhost:8080

## Notes
- The database table will be automatically created by Hibernate (ddl-auto=update)
- All endpoints return appropriate HTTP status codes
- JSON format is used for request and response bodies

