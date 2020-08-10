package com.wisestudy.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisestudy.user.domain.UserStudyVO;
import com.wisestudy.user.module.adapter.UserRecyclerViewAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<UserStudyVO> list;

    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Initialized();

        UiHelper.toolBarInitialize(this,toolbar);
        UiHelper.hideWindow(this);

        recyclerView = findViewById(R.id.userApplyStudyRecyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

        UiHelper.navigationOnclick(this, bottomNavigationView);
    }

    private void Initialized() {

        toolbar = findViewById(R.id.userToolbar);
        bottomNavigationView = findViewById(R.id.userBottomNavigation);
        list = new ArrayList<>();
        list.add(new UserStudyVO("운기의 스터디","2020.08.15","범계역 스타벅스"));
        list.add(new UserStudyVO("문성이형의 스터디","2020.09.15","신림역 동네커피숍"));
        list.add(new UserStudyVO("택윤이의 스터디","2020.10.15","구로역 할리스"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.modify,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.appBarModify){
            Intent intent = new Intent(getApplicationContext(), UserModifyActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
