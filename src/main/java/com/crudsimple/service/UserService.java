package com.crudsimple.service;

import com.crudsimple.entity.User;

import java.util.List;

/**
 * A interface to define all required methods for user Object.
 * @author Aji Pramono
 * @version 1.0
 * @since 2021-08-16
 */
public interface UserService {
    User saveUser(User user);
    User findUserById(Long userId);
    List<User> findAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}
