package com.springbootsecurity.service.controller;

import com.springbootsecurity.service.entity.User;
import com.springbootsecurity.service.model.UserModel;
import com.springbootsecurity.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        return "SUCCESS";
    }
}
