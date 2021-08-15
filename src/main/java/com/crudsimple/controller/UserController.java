package com.crudsimple.controller;

import com.crudsimple.entity.User;
import com.crudsimple.model.MessageResponse;
import com.crudsimple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The UserController Class is a Rest Controller class which will have all end points for User
 * which is includes POST, GET, GET ALL, PUT, DELETE.
 *
 * @author Aji Pramono
 * @version 1.0
 * @since 2021-08-16
 */
@RestController
@RequestMapping("/simplecrud/v1")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Create a new USER by POST request, end point is http://hostname:port/simplecrud/v1/user
     *
     * @param user
     * @return user
     */
    @PostMapping(value = "/user")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Get all list of users based on GET request.
     * @return
     */
    @GetMapping(value = "/user")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    /**
     * Get a USER by ID in GET request, end point is http://hostname:port/simplecrud/v1/user/id
     * @param userId
     * @return
     */

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
        User user = userService.findUserById(userId);
        if (user == null) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setMessage("User not found.");
            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    /**
     * Delete a user based on user ID.
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("User has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
    }

    /**
     * Update a user based on PUT request.
     * @param userId
     * @param user
     * @return
     */
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
    }
}
