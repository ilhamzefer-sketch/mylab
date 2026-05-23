package az.mylab.dto.request;

import az.mylab.enums.Gender;
import az.mylab.enums.UserStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String firstName,
        String lastName,
        LocalDate bornDate,
        Gender gender,
        UserStatus userStatus,
        LocalDateTime createdDAte,
        LocalDateTime lastModifiedDate
) {
}
