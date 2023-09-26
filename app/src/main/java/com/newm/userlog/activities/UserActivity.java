package com.newm.userlog.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.newm.userlog.R;
import com.newm.userlog.controllers.LoginController;
import com.newm.userlog.models.Login;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        LoginController loginController = LoginController.getInstance();
        Login loggedUser = loginController.getLoggedUser();

        if (loggedUser != null) {
            TextView usernameShow = findViewById(R.id.usernameShow);
            usernameShow.setText("Usuário Logado: " + loggedUser.getUsername());
        } else {
            goToLogin();
        }
    }

    public void onLogOffClick(View v) {
        LoginController loginController = LoginController.getInstance();
        loginController.logoff();

        goToLogin();
    }

    public void goToLogin() {
        Intent goToLogin = new Intent(this, FormLogin.class);
        startActivity(goToLogin);
    }
}