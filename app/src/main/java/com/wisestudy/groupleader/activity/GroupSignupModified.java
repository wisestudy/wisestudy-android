package com.wisestudy.groupleader.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupSignupModified  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_signup_management);

        UiHelper.toolBarInitialize(this, findViewById(R.id.management_signup_title));
        UiHelper.hideWindow(this);
    }
}
