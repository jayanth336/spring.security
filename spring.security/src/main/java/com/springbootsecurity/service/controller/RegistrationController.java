package com.springbootsecurity.service.controller;

import com.springbootsecurity.service.entity.User;
import com.springbootsecurity.service.event.RegistrationCompleteEvent;
import com.springbootsecurity.service.model.UserModel;
import com.springbootsecurity.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "SUCCESS";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam String token) {
        String result = userService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid"))
            return "User verified successfully";

        return "Bad user";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http:/" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
