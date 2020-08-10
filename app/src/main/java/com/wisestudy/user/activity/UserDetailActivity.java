package com.wisestudy.user.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class UserDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdeatail);

        UiHelper.toolBarInitialize(this, findViewById(R.id.userDetailToolBar));
        UiHelper.hideWindow(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_group_leave, menu);
        return true;
    }
}
