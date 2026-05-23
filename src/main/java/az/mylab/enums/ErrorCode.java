package az.mylab.enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND("İstifadəçi tapılmadı"),
    USER_ALREADY_EXISTS("Bu e-poçt ünvanı artıq mövcuddur"),
    INVALID_CREDENTIALS("E-poçt və ya şifrə yanlışdır"),
    INTERNAL_SERVER_ERROR("Gözlənilməyən daxili xəta baş verdi");
    // Enum-a aid xəta mesajı
    private final String message;
}