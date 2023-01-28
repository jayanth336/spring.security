package com.springbootsecurity.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    /**
     * This class is to get data from user
     */
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
}
