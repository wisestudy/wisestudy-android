package com.wisestudy.groupleader.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupLeaderCreateMemberActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_createmember);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyMemberToolbar));
        UiHelper.hideWindow(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_push_ok, menu);
        return true;
    }
}
