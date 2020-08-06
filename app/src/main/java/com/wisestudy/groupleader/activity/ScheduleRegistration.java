package com.wisestudy.groupleader.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class ScheduleRegistration extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_registration);
        UiHelper.toolBarInitialize(this, findViewById(R.id.schedule_toolbar));
        UiHelper.hideWindow(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_schedule,menu);

        return true;
    }
}