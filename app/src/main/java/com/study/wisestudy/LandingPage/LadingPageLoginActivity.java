package com.study.wisestudy.LandingPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.study.wisestudy.MyInformation.InsertProfileActivity;
import com.study.wisestudy.R;

public class LadingPageLoginActivity extends AppCompatActivity
{
    private Button loginButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage_login);
        loginButton = (Button) findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InsertProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
