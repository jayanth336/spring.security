package com.springbootsecurity.service.service;

import com.springbootsecurity.service.entity.User;
import com.springbootsecurity.service.entity.VerificationToken;
import com.springbootsecurity.service.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(User user, String token);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);
}
