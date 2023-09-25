package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

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

        LoginController loginController = LoginController.getInstance();

        loginController.createUser("teste", "123");
    }

    public void onLoginClick(View v) {
        v.startAnimation(buttonClick);

        LoginController loginController = LoginController.getInstance();

        String username = ((EditText) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordInput)).getText().toString();

        Log.d("LoginController", loginController.login(username, password) != null ? "logado!" : "dados incorretos!");
    }
}