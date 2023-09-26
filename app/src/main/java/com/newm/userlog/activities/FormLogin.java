package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;

import com.newm.userlog.R;
import com.newm.userlog.controllers.LoginController;
import com.newm.userlog.models.Login;

public class FormLogin extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.8f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
    }

    public void onLoginClick(View v) {
        v.startAnimation(buttonClick);

        LoginController loginController = LoginController.getInstance();

        String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();

        if (loginController.login(username, password) != null) {
            goToMain();
        } else {
            Log.d("LoginController", "Não foi possível logar, dados incorretos.");
        }
    }

    public void onGotoRegisterClick(View v) {
        goToRegister();
    }

    public void goToRegister() {
        Intent goToRegister = new Intent(this, FormRegister.class);
        startActivity(goToRegister);
    }

    public void goToMain() {
        Intent goToMain = new Intent(this, UserActivity.class);
        startActivity(goToMain);
    }
}