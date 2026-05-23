package az.mylab.web;

import az.mylab.dto.request.UserRegisterRequest;
import az.mylab.dto.request.UserResponse;
import az.mylab.entity.User;
import az.mylab.mapper.UserMapper;
import az.mylab.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> findByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        UserResponse response = userMapper.toResponse(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRegisterRequest request) {
        User userEntity  =userMapper.toEntity(request);

        User savedUser =userService.createUser(userEntity);

        UserResponse response=userMapper.toResponse(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
