package com.springbootsecurity.service.event;

import com.springbootsecurity.service.entity.User;
import com.springbootsecurity.service.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Log4j2
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create verification token for User with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user, token);

        //Send mail to the user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;
        log.info("Click the link to verify your account : {}", url);
    }
}
