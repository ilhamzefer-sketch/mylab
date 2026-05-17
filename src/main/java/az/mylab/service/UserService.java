package az.mylab.service;

import az.mylab.entity.User;

public interface UserService  {
    User findByEmail(String email);
    User createUser(User user);

}
