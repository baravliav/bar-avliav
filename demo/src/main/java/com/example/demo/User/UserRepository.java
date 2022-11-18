package com.example.demo.User;

import java.util.List;

public interface UserRepository {
    void createUser(User customer);
    void updateUserById(Long customerId, User customer);
    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getUsersByFirstName(String firstName);
    List<User> getAllUsers();
    List<Long> getUserIdsByFirstName(String firstName);
}
