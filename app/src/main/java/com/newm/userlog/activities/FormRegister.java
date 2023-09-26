package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;

import com.newm.userlog.R;
import com.newm.userlog.controllers.LoginController;

public class FormRegister extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.8f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
    }

    public void onRegisterClick(View v) {
        v.startAnimation(buttonClick);

        registerUser();
        goToLogin();
    }

    public void registerUser() {
        LoginController loginController = LoginController.getInstance();

        String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();

        loginController.createUser(username, password);
    }

    public void onGotoLoginClick(View v) {
        goToLogin();
    }

    public void goToLogin() {
        Intent goToLogin = new Intent(this, FormLogin.class);
        startActivity(goToLogin);
    }
}