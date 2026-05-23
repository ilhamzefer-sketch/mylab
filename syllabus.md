# Spring Boot Production-Grade API Yol Xəritəsi (Sillabus)

Bu sənəd bir REST API-ni real istehsalat (production) səviyyəsinə çatdırmaq üçün keçməli olduğunuz mərhələləri və mövzuları əhatə edir. Hər mövzu üzrə mövcud vəziyyətinizi qeyd edib ardıcıllıqla irəliləyə bilərsiniz.

---

## 📈 Mövcud Vəziyyət və Yol Xəritəsi

### 🟢 Mərhələ 1: Core Architecture & Clean Code (Tamamlandı)
* [x] **Entity & Database Mapping:** Entity sinifləri və əlaqələrinin qurulması.
* [x] **Repository Layer:** Spring Data JPA ilə verilənlər bazası sorğuları.
* [x] **Service Layer:** Biznes məntiqlərinin yazılması.
* [x] **DTO Pattern:** Request/Response obyektlərinin ayrılması (Təhlükəsizlik və performans üçün).
* [x] **Controller Layer:** REST Endpoint-lərin açılması.

---

### 🟡 Mərhələ 2: Validation & Global Exception Handling (İndi Tamamlanır)
* [x] **Global Exception Handler:** `@RestControllerAdvice` və `@ExceptionHandler` ilə xətaların mərkəzləşdirilməsi.
* [ ] **JSR 380 Validation:** Input məlumatlarının yoxlanılması (`@NotNull`, `@Size`, `@Email`, `@Pattern`).
* [ ] **Validation Exception Handling:** Validasiyadan keçməyən sahələrin xəta mesajlarını `validationErrors` map-i vasitəsilə səliqəli şəkildə qaytarmaq.
* [ ] **Custom Validation Annotations:** Xüsusi validasiya qaydalarının yazılması (məs: `@UniqueEmail`).

---

### 🔴 Mərhələ 3: Database Version Control (Flyway / Liquibase)
> **Production Məsələsi:** Real layihələrdə heç vaxt `ddl-auto=update` istifadə olunmur, çünki bazadakı məlumatların silinmə riski var.
* [ ] **Flyway/Liquibase İnteqrasiyası:** Verilənlər bazası strukturunun versiyalarla idarə edilməsi.
* [ ] **Migration Skriptləri:** Cədvəllərin və ilkin dataların (seed) SQL skriptləri vasitəsilə yaradılması.

---

### 🔴 Mərhələ 4: Logging & Monitoring (İzləmə)
> **Production Məsələsi:** Kodda `System.out.println` yazmaq qəti qadağandır. Sistemdə nə baş verdiyini loqlardan izləməliyik.
* [ ] **SLF4J & Logback:** Düzgün log səviyyələrinin (`DEBUG`, `INFO`, `WARN`, `ERROR`) istifadəsi.
* [ ] **Spring Boot Actuator:** Tətbiqin sağlamlıq vəziyyətini (`/health`, `/info`) yoxlamaq üçün endpoint-lər.

---

### 🔴 Mərhələ 5: Security & Authentication (Token)
> **Production Məsələsi:** İstifadəçilərin identifikasiyası və icazələrin (roles) idarə edilməsi.
* [ ] **Spring Security:** Tətbiqin qorunması, URL-lərə giriş icazələrinin verilməsi.
* [ ] **JWT (JSON Web Token):** Təhlükəsiz Access Token generatoru və filteri.
* [ ] **Refresh Token Rotation:** İstifadəçi təhlükəsizliyini təmin etmək üçün köhnələn tokenlərin avtomatik yenilənməsi.
* [ ] **HttpOnly Cookies:** Tokenlərin XSS hücumlarından qorunması üçün brauzerdə təhlükəsiz saxlanması.

---

### 🔴 Mərhələ 6: API Performance & Caching
> **Production Məsələsi:** Bazaya hər dəfə müraciət etmək performansı aşağı salır. Tez-tez dəyişməyən məlumatları yaddaşda saxlamalıyıq.
* [ ] **Spring Cache & Redis:** Tez-tez oxunan dataların (məs: məhsul siyahısı, ölkələr) keşe (cache) yığılması.
* [ ] **N+1 Query Problem:** JPA sorğularının optimallaşdırılması (`EntityGraph` və `Fetch Join` istifadəsi).

---

### 🔴 Mərhələ 7: Rate Limiting & Security Hardening
> **Production Məsələsi:** Eyni istifadəçinin saniyədə minlərlə istək göndərib sistemi çökdürməsinin (DDoS) qarşısını almaq.
* [ ] **Rate Limiting (Bucket4j / Spring Cloud Gateway):** Hər IP və ya istifadəçi üçün saniyəlik istək limitinin qoyulması.
* [ ] **CORS Configuration:** API-nin yalnız icazə verilən domenlərdən (məs: sənin öz front-end saytından) çağırılmasını təmin etmək.
* [ ] **HTTPS/SSL:** Bütün məlumat mübadiləsinin şifrələnməsi.

---

### 🔴 Mərhələ 8: Testing (Unit & Integration)
> **Production Məsələsi:** Yazdığımız kodun sabah başqa bir dəyişikliklə xarab olmayacağına əmin olmaq.
* [ ] **JUnit 5 & Mockito:** Service və Controller laylarının Unit testlərinin yazılması.
* [ ] **Testcontainers:** Real verilənlər bazası (məs: Postgres) ilə inteqrasiya testlərinin yazılması.

---

### 🔴 Mərhələ 9: Containerization & CI/CD
> **Production Məsələsi:** API-nin serverdə asanlıqla ayağa qaldırılması və avtomatlaşdırılması.
* [ ] **Docker:** Spring Boot tətbiqinin Dockerize edilməsi (Multi-stage build).
* [ ] **GitHub Actions:** Kod hər dəfə `main` budağına push olunanda testlərin avtomatik qaçması və deployment-ə hazır olması.

---

## 🛠️ Növbəti Addımımız Nədir?
Sillabusa uyğun olaraq növbəti addımımız **Mərhələ 2-ni tamamlamaqdır**:
1. Controller-də `@Valid` annotasiyası vasitəsilə input yoxlamaları (validation) etmək.
2. `GlobalExceptionHandler`-da validasiya xətalarını tutub front-end üçün səliqəli `validationErrors` map-i doldurmaq.

Başlayaq?
