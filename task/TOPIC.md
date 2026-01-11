## Mục tiêu dự án (chuẩn **fresher Java Spring Boot top 25%**)

### Tên dự án

**Internal Task Management API** (Backend-only)

### Bối cảnh thực tế

API quản lý công việc nội bộ cho team nhỏ (5–20 người): tạo task, giao việc, theo dõi trạng thái, phân quyền cơ bản.

---

## Phạm vi & Giới hạn (cố ý giới hạn để học đúng trọng tâm)

* **Chỉ backend** (REST API)
* **1 service duy nhất** (monolith)
* **Không microservices**
* **Không frontend**
* **Không message queue**
* **Không cloud**
* **Không reactive**

---

## Stack bắt buộc (chuẩn công ty)

* Java 17+
* Spring Boot
* Spring Web (REST)
* Spring Data JPA
* Spring Security + JWT
* PostgreSQL (hoặc MySQL)
* Flyway (migration)
* Lombok (hạn chế lạm dụng)
* Maven
* JUnit 5 + Mockito
* Swagger / OpenAPI

---

## Domain Model (đủ nhưng không dư)

### User

* id
* email (unique)
* password (BCrypt)
* role: `ADMIN`, `USER`
* createdAt

### Task

* id
* title
* description
* status: `TODO`, `IN_PROGRESS`, `DONE`
* assignee (User)
* createdBy (User)
* createdAt
* updatedAt

---

## API Yêu cầu (tối thiểu nhưng chuẩn)

### Auth

* `POST /auth/register`
* `POST /auth/login`

### User

* `GET /users/me`
* `GET /users` (ADMIN)

### Task

* `POST /tasks`
* `GET /tasks`
* `GET /tasks/{id}`
* `PUT /tasks/{id}`
* `DELETE /tasks/{id}`

### Rule nghiệp vụ

* USER chỉ thấy task mình tạo hoặc được assign
* ADMIN thấy tất cả
* Không được update task của người khác nếu không phải ADMIN

---

## Kỹ thuật bắt buộc phải làm đúng

### Spring Core

* Constructor Injection (không `@Autowired` field)
* Bean lifecycle hiểu cụ thể
* Không logic trong Controller

### Validation

* `@Valid`, `@NotBlank`, `@Email`
* Global Exception Handler (`@ControllerAdvice`)

### JPA

* Mapping chuẩn (`@ManyToOne`, `fetch = LAZY`)
* Không N+1 (dùng `@EntityGraph` hoặc join fetch)
* Pagination (`Pageable`)
* Audit (`@CreatedDate`, `@LastModifiedDate`)

### Security

* JWT filter tự viết
* Stateless
* Role-based authorization
* Không hardcode user

### Clean Code

* DTO != Entity
* Package:

  ```
  controller
  service
  repository
  domain
  dto
  security
  config
  exception
  ```

---

## Tiêu chí đánh giá **top 25% fresher**

Bạn đạt nếu:

* Giải thích được **vì sao** dùng JWT, không chỉ “vì tutorial nói vậy”
* Không có nghiệp vụ trong Controller
* Hiểu rõ transaction boundary
* Biết chỉ ra trade-off:

    * JWT vs Session
    * Monolith vs Microservice
* API predictable, error response chuẩn
* Code đọc như code công ty, không phải bài học

---

## Không làm (rất quan trọng)

* ❌ Copy full tutorial
* ❌ Viết code “cho chạy được”
* ❌ Over-engineering
* ❌ Dùng AI generate tràn lan không hiểu

---

## Kết quả đầu ra để đưa CV

* GitHub repo (README)
* Swagger public
* Sample curl/Postman
* 1 file `DESIGN.md`:

    * Architecture
    * Security flow
    * Trade-offs đã chọn

---

## Nhận định thẳng

Nếu **làm trọn vẹn và hiểu sâu** dự án này:

* Đủ trình fresher Java backend **top 25%**
* Đi phỏng vấn không bị “hỏi tới đâu chết tới đó”
* Dùng AI **có kiểm soát**, không lệ thuộc

Nếu muốn, tao có thể:

* Chia project này thành **7–10 task như công ty giao**
* Hoặc đóng vai **senior review code từng phần**
