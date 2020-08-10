package com.wisestudy.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class UserCreateStudyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_createstudy);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyMemberToolbar));
        UiHelper.hideWindow(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_push_ok, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.ok){
            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
