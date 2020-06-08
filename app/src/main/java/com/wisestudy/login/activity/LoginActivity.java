package com.wisestudy.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.user.activity.UserCreateActivity;
import com.wisestudy.wisestudy.R;

public class LoginActivity extends AppCompatActivity
{
    private Button loginButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton =findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), UserCreateActivity.class);
                startActivity(intent);
            }
        });
    }
}
