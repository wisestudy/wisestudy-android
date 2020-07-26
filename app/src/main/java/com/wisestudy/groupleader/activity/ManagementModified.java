package com.wisestudy.groupleader.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class ManagementModified  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_modified);

        UiHelper.toolBarInitialize(this, findViewById(R.id.management_modified_toolbar));
        UiHelper.hideWindow(this);
    }
}
