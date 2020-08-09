package com.wisestudy.user.activity;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        UiHelper.toolBarInitialize(this,findViewById(R.id.userToolbar));
        UiHelper.hideWindow(this);

        Initialized();

        recyclerView = findViewById(R.id.userApplyStudyRecyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void Initialized() {

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
}
