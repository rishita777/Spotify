package com.preproject.UserAuthentication.controller;

import com.preproject.UserAuthentication.domain.User;
import com.preproject.UserAuthentication.exception.UserNotFound;
import com.preproject.UserAuthentication.service.UserService;
import com.preproject.UserAuthentication.service.iTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {
    iTokenGenerator iTokenGenerator;
    UserService userService;

    @Autowired
    public UserController(com.preproject.UserAuthentication.service.iTokenGenerator iTokenGenerator, UserService userService) {
        this.iTokenGenerator = iTokenGenerator;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserNotFound {
        try {
            return new ResponseEntity<>(userService.savingUser(user), HttpStatus.CREATED);
        } catch (UserNotFound e) {
            throw new UserNotFound();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) {
        User result = userService.login(user.getUserEmail(), user.getPassword());
        if (result != null) {
            Map<String, String> map = iTokenGenerator.tokenGeneration(result);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid User or User Does Not Exist", HttpStatus.NOT_FOUND);
        }

    }
}
