package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.TextView;

import com.newm.userlog.R;
import com.newm.userlog.controllers.LoginController;
import com.newm.userlog.models.Login;

public class FormLogin extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.8f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        resetError();
    }

    public void onLoginClick(View v) {
        v.startAnimation(buttonClick);
        resetError();

        String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();

        if (username.length() < 4) {
            setError("Insira um username válido!");
            return;
        }

        if (password.length() < 4) {
            setError("Insira uma senha válida!");
            return;
        }

        LoginController loginController = LoginController.getInstance();
        if (loginController.login(username, password) != null) {
            goToMain();
        } else {
            setError("Dados incorretos!");
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

    public void setError(String error) {
        TextView errorText = findViewById(R.id.errorText);

        errorText.setVisibility(View.VISIBLE);
        errorText.setText(error);
    }

    public void resetError() {
        TextView errorText = findViewById(R.id.errorText);

        errorText.setVisibility(View.INVISIBLE);
    }
}