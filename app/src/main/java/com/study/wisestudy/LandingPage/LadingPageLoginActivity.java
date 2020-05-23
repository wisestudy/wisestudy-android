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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page_login);
        Button Login = (Button) findViewById(R.id.Login_Btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InsertProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
