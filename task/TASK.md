Dưới đây là **task breakdown đúng kiểu công ty giao việc**, đủ chi tiết để làm **tuần tự**, đủ giới hạn để **không lan man**, và đủ sâu để **đánh giá fresher top 25%**.

---

## TASK 0 — Project Bootstrap & Build Foundation

**Mục tiêu:** App chạy được, nền móng đúng chuẩn.

**Deliverables**

* Spring Boot project (Java 17)
* `pom.xml` chuẩn
* `application.yml`
* Flyway chạy thành công

**Yêu cầu kỹ thuật**

* Không `ddl-auto=create`
* DB connect OK
* Swagger lên được

**Tiêu chí pass**

* App start không error
* `V1__init.sql` chạy đúng

---

## TASK 1 — Domain Model & JPA Mapping

**Mục tiêu:** Entity thiết kế đúng, không bug tương lai.

**Phạm vi**

* `User`
* `Task`
* `Role`, `TaskStatus`

**Yêu cầu kỹ thuật**

* `@ManyToOne(fetch = LAZY)`
* `@Enumerated(EnumType.STRING)`
* Audit fields
* Không Lombok lạm dụng

**Tiêu chí pass**

* Hibernate generate SQL đúng
* Không eager load ngoài ý muốn

---

## TASK 2 — Repository Layer & Query Strategy

**Mục tiêu:** Data access đúng chuẩn, tránh N+1.

**Phạm vi**

* `UserRepository`
* `TaskRepository`

**Yêu cầu kỹ thuật**

* Query phân quyền (USER vs ADMIN)
* `Pageable`
* `@EntityGraph` hoặc `join fetch`

**Tiêu chí pass**

* Không N+1 khi list task
* Pagination hoạt động

---

## TASK 3 — Authentication (Register / Login)

**Mục tiêu:** Auth đúng chuẩn backend.

**Phạm vi**

* Register
* Login
* Password hashing

**Yêu cầu kỹ thuật**

* BCrypt
* Không trả password
* DTO cụ thể

**Tiêu chí pass**

* Login sai password → 401
* Register trùng email → 400

---

## TASK 4 — JWT Security Infrastructure

**Mục tiêu:** Security không “copy tutorial”.

**Phạm vi**

* JWT util
* JWT filter
* Security config

**Yêu cầu kỹ thuật**

* Stateless
* Role-based authorization
* Không hardcode user

**Tiêu chí pass**

* Request không token → 401
* USER gọi API ADMIN → 403

---

## TASK 5 — User API

**Mục tiêu:** Hiểu principal & security context.

**Phạm vi**

* `GET /users/me`
* `GET /users` (ADMIN)

**Yêu cầu kỹ thuật**

* Lấy user từ `SecurityContext`
* Không query thừa

**Tiêu chí pass**

* `/me` trả đúng user đang login
* USER không gọi được `/users`

---

## TASK 6 — Task CRUD (Core Business)

**Mục tiêu:** Business logic cụ thể, đúng quyền.

**Phạm vi**

* Create / Update / Delete / Get

**Yêu cầu kỹ thuật**

* Check ownership
* ADMIN override
* DTO != Entity

**Tiêu chí pass**

* USER sửa task người khác → 403
* ADMIN sửa được tất cả

---

## TASK 7 — Validation & Exception Handling

**Mục tiêu:** API predictable, không vỡ.

**Phạm vi**

* Validation input
* Global exception handler

**Yêu cầu kỹ thuật**

* `@ControllerAdvice`
* Error response thống nhất

**Tiêu chí pass**

* Input sai → 400 + message rõ
* Không stacktrace lộ ra ngoài

---

## TASK 8 — Transaction & Consistency

**Mục tiêu:** Hiểu transaction boundary.

**Phạm vi**

* Service layer
* Update task logic

**Yêu cầu kỹ thuật**

* `@Transactional` đúng chỗ
* Không mở transaction trong controller

**Tiêu chí pass**

* Partial update không xảy ra
* Rollback đúng khi exception

---

## TASK 9 — Testing & Documentation

**Mục tiêu:** Code công ty, không phải bài học.

**Phạm vi**

* Unit test service
* Swagger
* README
* DESIGN.md

**Yêu cầu kỹ thuật**

* Mockito
* Test logic, không test framework

**Tiêu chí pass**

* Test chạy được
* README giải thích được design

---

## Cách làm đúng công ty

* Mỗi task = 1 branch
* Xong task → tự review
* Chỉ merge khi:

    * Giải thích được **vì sao làm vậy**
    * Biết mình **chưa làm gì**

---

## Nhận định cuối

Nếu mày:

* Làm **đủ 9 task**
* Không cheat
* Hiểu từng quyết định kỹ thuật

➡️ **Spring Boot backend của mày đạt chuẩn fresher top 25%**

Nếu muốn, bước sau tao có thể:

* Giao **TASK 1 chi tiết như ticket JIRA**
* Hoặc **review từng task như senior chấm PR**
