package com.newm.userlog.models;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String username;
    private int passwordHash;

    public Login(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.username = username;
        this.passwordHash = password.hashCode();

        Log.d("loginController", "Usuário criado: " + username);
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String passwordToCheck) {
        return (passwordToCheck.hashCode() == passwordHash);
    }
}
