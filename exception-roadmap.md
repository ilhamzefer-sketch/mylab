# Exception Roadmap

Bu fayl exception-lardan sonra ne etmeli oldugunu itirmemek ucun qisa map-dir.

## 1. GlobalExceptionHandler-i tamamla

`GlobalExceptionHandler` icinde bu handler-leri saxla:

- `ResourceNotFoundException` -> `404 Not Found`
- `MethodArgumentNotValidException` -> `400 Bad Request`
- umumi `Exception` -> `500 Internal Server Error`

Validation handler-in meqsedi odur ki, `@Valid` xetalari eyni standart response formatinda qayitsin.

## 2. ErrorResponse formatini sabit saxla

Front-end her zaman eyni format gormelidir:

```java
private LocalDateTime timeStamp;
private int status;
private String error;
private String message;
private String path;
private Map<String, String> validationErrors;
```

`validationErrors` yalniz validation xetalari olanda dolmalidir.

## 3. Duplicate email ucun ayrica exception yaz

Yeni exception:

```java
public class UserAlreadyExistsException extends RuntimeException {
    private final ErrorCode errorCode;

    public UserAlreadyExistsException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
```

Handler-de bu exception ucun `409 Conflict` qaytar.

## 4. createUser icinde email yoxlamasi et

`UserServiceImpl.createUser()` icinde save-den once yoxla:

```java
if (userRepository.findByEmail(user.getEmail()).isPresent()) {
    throw new UserAlreadyExistsException(ErrorCode.USER_ALREADY_EXISTS);
}
```

Sonra password-u hash et ve user-i save et.

## 5. Mapper bug-ini duzelt

`UserMapper.toEntity()` icinde bu setr sehvdir:

```java
.firstName(request.lastName())
```

Duzgun variant:

```java
.firstName(request.firstName())
```

## 6. ErrorCode mesajlarini duzelt

`ErrorCode` faylinda Azerbaycan herfleri pozulubsa, fayli UTF-8 saxla ve mesajlari yeniden normal yaz:

```java
USER_NOT_FOUND("Istifadeci tapilmadi"),
USER_ALREADY_EXISTS("Bu email artiq movcuddur"),
INVALID_CREDENTIALS("Email ve ya sifre yanlisdir"),
INTERNAL_SERVER_ERROR("Gozlenilmeyen daxili xeta bas verdi");
```

## 7. Postman ile yoxla

Bu case-leri test et:

- Olmayan user email -> `404`
- Bos ve ya yanlis request body -> `400`
- Eyni email ile ikinci register -> `409`
- Normal register -> `201`

## Oyrenme ardicilligi

1. Validation handler
2. Duplicate email exception
3. Service icinde business check
4. Postman test
5. Unit ve integration test

