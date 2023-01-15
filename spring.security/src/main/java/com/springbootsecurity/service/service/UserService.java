package com.springbootsecurity.service.service;

import com.springbootsecurity.service.entity.User;
import com.springbootsecurity.service.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);
}
