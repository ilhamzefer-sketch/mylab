package az.mylab.mapper;

import az.mylab.dto.request.UserRegisterRequest;
import az.mylab.dto.request.UserResponse;
import az.mylab.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // 1. Request DTO-nu -> User Entity-sinə çevirir (Qeydiyyat üçün)
    public User toEntity(UserRegisterRequest request){
        if(request==null){
            return null;
        }
        // Entity daxilində @Builder annotasiyası olduğu üçün rahatlıqla istifadə edirik
        return  User.builder()
                .email((request.email()))
                .firstName(request.lastName())
                .lastName(request.lastName())
                // Parolu bura set edirik, amma hələ şifrələnməyib. Bunu Service-də edəcəyik.
                .passwordHash((request.password()))
                .bornDate(request.bornDate())
                .gender(request.gender())
                // Qeyd: id, status, və audit (createdDate) avtomatik formalaşacaq
                .build();
    }

    public UserResponse toResponse(User user){
        if(user==null){
            return  null;
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
