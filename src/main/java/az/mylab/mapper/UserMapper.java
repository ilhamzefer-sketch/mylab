package az.mylab.mapper;

import az.mylab.dto.request.UserRegisterRequest;
import az.mylab.dto.request.UserResponse;
import az.mylab.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegisterRequest request) {
        if (request == null) {
            return null;
        }

        return User.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .passwordHash(request.password())
                .bornDate(request.bornDate())
                .gender(request.gender())
                .build();
    }

    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }

        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getBornDate(),
                user.getGender(),
                user.getUserStatus(),
                user.getCreatedDate(),
                user.getLastModifiedDate()
        );
    }
}
