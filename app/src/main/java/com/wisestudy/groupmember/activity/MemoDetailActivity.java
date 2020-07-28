package com.wisestudy.groupmember.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class MemoDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmember_detailscreen);


        UiHelper.toolBarInitialize(this, findViewById(R.id.memoDetailToolbar));
        UiHelper.hideWindow(this);
    }
}
