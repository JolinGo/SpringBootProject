package com.example.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("test");
        boolean isValidPwd = password.equalsIgnoreCase("password");

        return isValidUserName && isValidPwd;
    }
}
