package com.crudsimple.controller;

import com.crudsimple.entity.User;
import com.crudsimple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
