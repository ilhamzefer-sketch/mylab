package az.mylab.service.impl;


import az.mylab.entity.User;
import az.mylab.enums.ErrorCode;
import az.mylab.exception.ResourceNotFoundException;
import az.mylab.repository.UserRepository;
import az.mylab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email){
        return  userRepository.findByEmail(email)
                .orElseThrow(() ->new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public User createUser(User user){
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }

}
