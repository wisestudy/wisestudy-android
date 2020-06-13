package com.wisestudy.landing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.login.activity.LoginActivity;
import com.wisestudy.wisestudy.R;

public class LandingActivity extends AppCompatActivity
{
    Handler handler =new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {
            Intent intent  = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            finish();
        }
    };
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }
    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(run, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(run);
    }
}
