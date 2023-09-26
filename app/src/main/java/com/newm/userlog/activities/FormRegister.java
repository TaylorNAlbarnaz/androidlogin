package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.TextView;

import com.newm.userlog.R;
import com.newm.userlog.controllers.LoginController;

public class FormRegister extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.8f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
        resetError();
    }

    public void onRegisterClick(View v) {
        v.startAnimation(buttonClick);
        resetError();

        String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();
        String repeatPassword = ((EditText) findViewById(R.id.repeatPasswordInput)).getText().toString();

        if (username.length() < 4) {
            setError("Insira um username válido!");
            return;
        }

        if (password.length() < 4) {
            setError("Insira uma senha válida!");
            return;
        }

        if (!password.equals(repeatPassword)) {
            setError("As senhas não coincidem!");
            return;
        }

        LoginController loginController = LoginController.getInstance();
        if (loginController.createUser(username, password) != null) {
            goToLogin();
        } else {
            setError("Já existe um usuário com esse nome!");
        }
    }

    public void onGotoLoginClick(View v) {
        goToLogin();
    }

    public void goToLogin() {
        Intent goToLogin = new Intent(this, FormLogin.class);
        startActivity(goToLogin);
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