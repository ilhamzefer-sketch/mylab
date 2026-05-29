package az.mylab.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND("Istifadeci tapilmadi"),
    USER_ALREADY_EXISTS("Bu email artiq movcuddur"),
    INVALID_CREDENTIALS("Email ve ya sifre yanlisdir"),
    INTERNAL_SERVER_ERROR("Gozlenilmeyen daxili xeta bas verdi");

    private final String message;
}
