package com.wisestudy.user.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class UserModifyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modfiy);

        UiHelper.toolBarInitialize(this,findViewById(R.id.userModifyToolbar));
        UiHelper.hideWindow(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_push_ok, menu);

        return true;
    }



    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(menuItem.getItemId() == R.id.ok){
            /**
             *  내 정보 변경 저장하기
             */
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
