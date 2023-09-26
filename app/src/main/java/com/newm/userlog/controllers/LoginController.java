package com.newm.userlog.controllers;

import android.util.Log;

import com.newm.userlog.models.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private Login loggedUser;
    private List<Login> loginList = new ArrayList<>();

    private static LoginController instance = new LoginController();
    public static LoginController getInstance() {
        return instance;
    }

    public Login getLoggedUser() {
        return loggedUser;
    }

    public Login createUser(String username, String password) {
        try {
            for (Login login : loginList) {
                if (username.equals(login.getUsername())) {
                    return null;
                }
            }
            Login newLogin = new Login(username, password);
            loginList.add(newLogin);

            return newLogin;
        } catch(Exception exception) {}
        return null;
    }

    public Login login(String username, String password) {
        for (Login login : loginList) {
            if (username.equals(login.getUsername())) {
                if (login.checkPassword(password)) {
                    loggedUser = login;
                    return login;
                }
            }
        }
        return null;
    }

    public void logoff() {
        loggedUser = null;
    }
}
