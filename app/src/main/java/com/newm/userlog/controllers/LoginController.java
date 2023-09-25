package com.newm.userlog.controllers;

import android.util.Log;

import com.newm.userlog.models.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private static LoginController instance = new LoginController();
    public List<Login> loginList = new ArrayList<>();

    public static LoginController getInstance() {
        return instance;
    }

    public void createUser(String username, String password) {
        try {
            Login newLogin = new Login(username, password);
            loginList.add(newLogin);
        } catch(Exception exception) {}
    }

    public Login login(String username, String password) {
        for (Login login : loginList) {
            if (username.equals(login.getUsername())) {
                if (login.checkPassword(password)) {
                    return login;
                }
            }
        }
        return null;
    }
}
