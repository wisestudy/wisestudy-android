package com.study.wisestudy.MainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.wisestudy.R;

public class MainActivity extends AppCompatActivity {
    private Button calendarIntentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarIntentButton = findViewById(R.id.calendarIntentBtn);

        calendarIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainPageCalendarActivity.class);
                startActivity(intent);

            }
        });
    }
}
