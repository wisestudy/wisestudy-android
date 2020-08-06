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

public class GroupManagement extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmanagement);

        UiHelper.toolBarInitialize(this, findViewById(R.id.manageMentToolbar));
        UiHelper.hideWindow(this);
    }
}